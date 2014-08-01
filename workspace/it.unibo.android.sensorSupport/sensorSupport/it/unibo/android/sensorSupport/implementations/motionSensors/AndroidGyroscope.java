package it.unibo.android.sensorSupport.implementations.motionSensors;

import it.unibo.android.sensorSupport.implementations.AndroidSensor;
import it.unibo.android.sensorSupport.interfaces.motionSensors.IAndroidGyroscope;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import it.unibo.android.sensorData.implementation.motionSensors.AndroidGyroscopeData;
import it.unibo.android.sensorData.interfaces.motionSensors.IAndroidGyroscopeData;

public class AndroidGyroscope extends AndroidSensor implements
		IAndroidGyroscope {

	private static AndroidGyroscope[] instances = new AndroidGyroscope[4];
	protected IAndroidGyroscopeData sensorData;
	
	/**
	 * This method returns, if exist, an instance of AndroidGyroscope, else
	 * the AndroidGyroscope is created and returned.
	 * 
	 * @param manager the instance of SensorManager
	 * @param delay the registration delay defined by one of <b>SensorManager.SENSOR_DELAY_*</b>
	 * 
	 * @return the instance of AndroidGyroscope
	 */
	public static AndroidGyroscope getInstance(SensorManager manager, int delay){
		Sensor gyroscope = manager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
		if(gyroscope != null){
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
				instances[index] = new AndroidGyroscope(manager, gyroscope, delay);
			return instances[index];
		}
		else
			return null;
	}
	
	private AndroidGyroscope(SensorManager manager, Sensor accelerometer, int delay){
		super(manager);
		manager.registerListener(this, accelerometer, delay);
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		sensorData = new AndroidGyroscopeData(event.values, event.accuracy, event.timestamp);
		this.update(this, sensorData);
	}
	
	@Override
	public IAndroidGyroscopeData getData(){
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
