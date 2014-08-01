package it.unibo.android.sensorSupport.implementations.motionSensors;

import it.unibo.android.sensorSupport.implementations.AndroidSensor;
import it.unibo.android.sensorSupport.interfaces.motionSensors.IAndroidAccelerometer;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import it.unibo.android.sensorData.implementation.motionSensors.AndroidAccelerometerData;
import it.unibo.android.sensorData.interfaces.motionSensors.IAndroidAccelerometerData;

public class AndroidAccelerometer extends AndroidSensor implements
		IAndroidAccelerometer {

	private static AndroidAccelerometer[] instances = new AndroidAccelerometer[4];
	protected IAndroidAccelerometerData sensorData;
	/**
	 * This method returns, if exist, an instance of AndroidAccelerometer, else
	 * the AndroidAccelerometer is created and returned.
	 * 
	 * @param manager the instance of SensorManager
	 * @param delay the registration delay defined by one of <b>SensorManager.SENSOR_DELAY_*</b>
	 * 
	 * @return the instance of AndroidAccelerometer
	 */
	public static AndroidAccelerometer getInstance(SensorManager manager, int delay){
		Sensor accelerometer = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		if(accelerometer != null){
			int index;
			switch (delay){
				case SensorManager.SENSOR_DELAY_NORMAL:
					index = 0;
					break;
				case SensorManager.SENSOR_DELAY_UI:
					index = 1;
					break;
				case SensorManager.SENSOR_DELAY_GAME:
					index = 2;
					break;
				case SensorManager.SENSOR_DELAY_FASTEST:
					index = 3;
					break;
				default: return null;
			}
			if (instances[index] == null)
				instances[index] = new AndroidAccelerometer(manager, accelerometer, delay);
			return instances[index];
		}
		else
			return null;
	}
	
	private AndroidAccelerometer(SensorManager manager, Sensor accelerometer, int delay){
		super(manager);
		manager.registerListener(this, accelerometer, delay);
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		sensorData = new AndroidAccelerometerData(event.values, event.accuracy, event.timestamp);
		this.update(this, sensorData);
	}
	
	@Override
	public IAndroidAccelerometerData getData(){
		return sensorData;
	}
	
	@Override
	public void unregister(){
		for(int i = 0; i < instances.length; i++)
			if(this.equals(instances[i]))
				instances[i] = null;
		super.unregister();
	}
	
}
