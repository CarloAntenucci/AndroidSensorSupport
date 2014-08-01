package it.unibo.android.sensorSupport.implementations.motionSensors;

import it.unibo.android.sensorSupport.implementations.AndroidSensor;
import it.unibo.android.sensorSupport.interfaces.motionSensors.IAndroidGravity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import it.unibo.android.sensorData.implementation.motionSensors.AndroidGravityData;
import it.unibo.android.sensorData.interfaces.motionSensors.IAndroidGravityData;

public class AndroidGravity extends AndroidSensor implements
		IAndroidGravity {

	private static AndroidGravity[] instances = new AndroidGravity[4];
	protected IAndroidGravityData sensorData;
	
	/**
	 * This method returns, if exist, an instance of AndroidGravity, else
	 * the AndroidGravity is created and returned.
	 * 
	 * @param manager the instance of SensorManager
	 * @param delay the registration delay defined by one of <b>SensorManager.SENSOR_DELAY_*</b>
	 * 
	 * @return the instance of AndroidGravity
	 */
	public static AndroidGravity getInstance(SensorManager manager, int delay){
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
				instances[index] = new AndroidGravity(manager, accelerometer, delay);
			return instances[index];
		}
		else
			return null;
	}
	
	private AndroidGravity(SensorManager manager, Sensor accelerometer, int delay){
		super(manager);
		manager.registerListener(this, accelerometer, delay);
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		sensorData = new AndroidGravityData(event.values, event.accuracy, event.timestamp);
		this.update(this, sensorData);
	}
	
	@Override
	public IAndroidGravityData getData(){
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
