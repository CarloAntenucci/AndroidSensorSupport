/**
 * @author Carlo Antenucci
 */

package it.unibo.android.sensorSupport.example;


import it.unibo.android.sensorSupport.implementations.AndroidSensorFactory;
import it.unibo.android.sensorSupport.interfaces.environmentSensors.IAndroidLight;
import it.unibo.android.sensorSupport.interfaces.environmentSensors.IAndroidTemperature;
import it.unibo.android.sensorSupport.interfaces.motionSensors.IAndroidAccelerometer;
import it.unibo.android.sensorSupport.interfaces.positionSensors.IAndroidProximity;
import it.unibo.android.sensorSupport.observer.SensorObserver;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;


public class ExampleActivity extends GuiActivity {

	private SensorManager mSensorManager;
	private IAndroidAccelerometer sensor_1;
	private IAndroidProximity sensor_2;
	private IAndroidLight sensor_3;
	private IAndroidTemperature sensor_4;

	private SensorObserver observer;



	@Override
	protected void onStart() {
		super.onStart();
		//obtain sensor manager
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		//ask an instances of sensors
		initSensors();
		//complete the GUI
		String[] names = {
				"Accelerometer",
				"Proximity",
				"Light",
				"Temperatures"
		};
		super.initGui(names);
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
			sensor_1.unregister();
		if(sensor_2 != null)
			sensor_2.unregister();
		if(sensor_3 != null)
			sensor_3.unregister();
		if(sensor_4 != null)
			sensor_4.unregister();
		sensor_1 = null;
		sensor_2 = null;
		sensor_3 = null;
		sensor_4 = null;
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
	}
	
	public void sensorUpdated(String name){
		switch(name){
			case "AndroidAccelerometerData":
				if(sensor_4 != null)
					setJSONRep(sensor_4.getData().getJsonRep());
				else
					setJSONRep("sensor_4 not present\n\n" + sensor_1.getData().getJsonRep());
				break;
			case "AndroidProximityData":
				if(sensor_3 != null)
					setJSONRep(sensor_3.getData().getJsonRep());
				else
					setJSONRep("sensor_3 not present\n\n" + sensor_2.getData().getJsonRep());
				break;
			case "AndroidLightData":
				if(sensor_4 != null)
					setJSONRep(sensor_2.getData().getJsonRep());
				else
					setJSONRep("sensor_2 not present\n\n" + sensor_3.getData().getJsonRep());
				break;
			case "AndroidTemperatureData":
				if(sensor_4 != null)
					setJSONRep(sensor_1.getData().getJsonRep());
				else
					setJSONRep("sensor_1 not present\n\n" + sensor_4.getData().getJsonRep());
				break;
		}
	}
}