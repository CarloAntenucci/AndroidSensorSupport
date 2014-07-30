/**
 * @author Carlo Antenucci
 */

package it.unibo.android.sensorSupport.example;


import it.unibo.android.sensorData.interfaces.IAndroidSensorData;
import it.unibo.android.sensorData.interfaces.motionSensors.IAndroidAccelerometerData;
import it.unibo.android.sensorData.interfaces.positionSensors.IAndroidProximityData;
import it.unibo.android.sensorData.utils.AndroidSensorDataUtils;
import it.unibo.android.sensorSupport.example.R;
import it.unibo.android.sensorSupport.implementations.AndroidSensorFactory;
import it.unibo.android.sensorSupport.interfaces.environmentSensors.IAndroidLight;
import it.unibo.android.sensorSupport.interfaces.environmentSensors.IAndroidTemperature;
import it.unibo.android.sensorSupport.interfaces.motionSensors.IAndroidAccelerometer;
import it.unibo.android.sensorSupport.interfaces.positionSensors.IAndroidProximity;
import it.unibo.android.sensorSupport.observer.SensorObserver;
import it.unibo.is.interfaces.IOutputView;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.widget.TextView;


public class ExampleActivity extends Activity implements IOutputView {
	
	private SensorManager mSensorManager;
    private IAndroidAccelerometer sensor_1;
    private IAndroidProximity sensor_2;
    private IAndroidLight sensor_3;
    private IAndroidTemperature sensor_4;
    
    private TextView textSensor1;
	private TextView textSensor2;
	private TextView textSensor3;
	private TextView textSensor4;
	
	private TextView textX1;
	private TextView textY1;
	private TextView textZ1;
	private TextView textX2;
	private TextView textY2;
	private TextView textZ2;
	private TextView textX3;
	private TextView textY3;
	private TextView textZ3;
	private TextView textX4;
	private TextView textY4;
	private TextView textZ4;
	
	private TextView textOther;
	
	private SensorObserver observer;

	
	
    @Override
	protected void onStart() {
		super.onStart();
        setContentView(R.layout.sensorsupport_example);
		//obtain views' references
        textSensor1 = (TextView)findViewById(R.id.sen1);
        textSensor2 = (TextView)findViewById(R.id.sen2);
        textSensor3 = (TextView)findViewById(R.id.sen3);
        textSensor4 = (TextView)findViewById(R.id.sen4);
		textX1 = (TextView)findViewById(R.id.s1x);
		textY1 = (TextView)findViewById(R.id.s1y);
		textZ1 = (TextView)findViewById(R.id.s1z);
		textX2 = (TextView)findViewById(R.id.s2x);
		textY2 = (TextView)findViewById(R.id.s2y);
		textZ2 = (TextView)findViewById(R.id.s2z);
		textX3 = (TextView)findViewById(R.id.s3x);
		textY3 = (TextView)findViewById(R.id.s3y);
		textZ3 = (TextView)findViewById(R.id.s3z);
		textX4 = (TextView)findViewById(R.id.s4x);
		textY4 = (TextView)findViewById(R.id.s4y);
		textZ4 = (TextView)findViewById(R.id.s4z);
		textOther = (TextView)findViewById(R.id.other);
		//obtain sensor manager
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //ask an instance of accelerometer to AndroidSensorFactory
        initSensors();

	}

    private void initSensors(){
    	observer = new SensorObserver(this);
    	
    	sensor_1 = (IAndroidAccelerometer) AndroidSensorFactory.getSensor(mSensorManager, 
													    			Sensor.TYPE_ACCELEROMETER, 
													    			SensorManager.SENSOR_DELAY_NORMAL,
													    			observer);
    	sensor_2 = AndroidSensorFactory.getProximity(mSensorManager, 
    																SensorManager.SENSOR_DELAY_FASTEST,
    																observer);
    	sensor_3 = AndroidSensorFactory.getLightSensor(mSensorManager, 
    																SensorManager.SENSOR_DELAY_NORMAL);
    	sensor_4 = AndroidSensorFactory.getAmbientTemperatureSensor(mSensorManager, 
																	SensorManager.SENSOR_DELAY_NORMAL);
    	if(sensor_4 == null)
    		sensor_4 = AndroidSensorFactory.getTemperature(mSensorManager, 
					SensorManager.SENSOR_DELAY_NORMAL);
    	textSensor1.setText("Accelerometer");
    	textSensor2.setText("Proximity");
    	textSensor3.setText("Light");
    	textSensor4.setText("Temperature");
    	if (sensor_1 == null) {
    		textX1.setText("not");
    		textY1.setText("present");
    	}
    	if (sensor_2 == null) {
    		textX2.setText("not");
    		textY2.setText("present");
    	}
    	if (sensor_3 == null) {
    		textX3.setText("not");
    		textY3.setText("present");
    	}
    	if (sensor_4 == null) {
    		textX4.setText("not");
    		textY4.setText("present");
    	}
    }
    
    @Override
	protected void onResume() {
		super.onResume();
		if((sensor_1 == null) && (sensor_2 == null) && (sensor_3 == null) && (sensor_4 == null))
			initSensors();
    }

	@Override
	protected void onPause() {
		super.onPause();
		if(sensor_1 != null)
			sensor_1.unregister(mSensorManager);
		if(sensor_2 != null)
			sensor_2.unregister(mSensorManager);
		if(sensor_3 != null)
			sensor_3.unregister(mSensorManager);
		if(sensor_4 != null)
			sensor_4.unregister(mSensorManager);
		sensor_1 = null;
		sensor_2 = null;
		sensor_3 = null;
		sensor_4 = null;
	}

	@Override
	public String getCurVal() {
		return null;
	}

	@Override
	public void addOutput(String msg) {
		
	}

	@Override
	public void setOutput(String msg) {
		IAndroidSensorData d = AndroidSensorDataUtils.buildDataFromJson(msg);
		if(d instanceof IAndroidAccelerometerData){
			IAndroidAccelerometerData a = (IAndroidAccelerometerData)d;
			textX1.setText(""+a.getAccelerationX());
			textY1.setText(""+a.getAccelerationY());
			textZ1.setText(""+a.getAccelerationZ());
			if(sensor_4 != null){
				textX4.setText(""+sensor_4.getData().getTemperatureCelsius());
				textY4.setText(""+sensor_4.getData().getTemperatureFarenheit());
				textZ4.setText(""+sensor_4.getData().getTemperatureKelvin());
				textOther.setText(sensor_4.getData().getJsonRep()+"\n\n"+a.getName()+" changed");
			}
			else
				textOther.setText("sensor_4 not present\n\n"+a.getName()+" changed");
		}
		else if (d instanceof IAndroidProximityData){
			IAndroidProximityData p = (IAndroidProximityData)d;
			textX2.setText(""+p.getValue());
			textY2.setText(""+p.isPresent());
			textZ2.setText("");
			if(sensor_3 != null){
				textX3.setText(""+sensor_3.getData().getValue());
				textY3.setText("");
				textZ3.setText("");	
				textOther.setText(sensor_3.getData().getJsonRep()+"\n\n"+p.getName()+" changed");
			}
			else
				textOther.setText("sensor_3 not present\n\n"+p.getName()+" changed");
		}
	}
}