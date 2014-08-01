package it.unibo.android.sensorSupport.implementations.motionSensors;

import it.unibo.android.sensorSupport.implementations.AndroidSensor;
import it.unibo.android.sensorSupport.interfaces.motionSensors.IAndroidGyroscopeUncalibrated;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import it.unibo.android.sensorData.implementation.motionSensors.AndroidGyroscopeUncalibratedData;
import it.unibo.android.sensorData.interfaces.motionSensors.IAndroidGyroscopeUncalibratedData;

public class AndroidGyroscopeUncalibrated extends AndroidSensor implements
		IAndroidGyroscopeUncalibrated {

	private static AndroidGyroscopeUncalibrated[] instances = new AndroidGyroscopeUncalibrated[4];
	protected IAndroidGyroscopeUncalibratedData sensorData;
	
	/**
	 * This method returns, if exist, an instance of AndroidGyroscopeUncalibrated, else
	 * the AndroidGyroscopeUncalibrated is created and returned.
	 * 
	 * @param manager the instance of SensorManager
	 * @param delay the registration delay defined by one of <b>SensorManager.SENSOR_DELAY_*</b>
	 * 
	 * @return the instance of AndroidGyroscopeUncalibrated
	 */
	public static AndroidGyroscopeUncalibrated getInstance(SensorManager manager, int delay){
		Sensor gyroscope = manager.getDefaultSensor(Sensor.TYPE_GYROSCOPE_UNCALIBRATED);
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
				instances[index] = new AndroidGyroscopeUncalibrated(manager, gyroscope, delay);
			return instances[index];
		}
		else
			return null;
	}
	
	private AndroidGyroscopeUncalibrated(SensorManager manager, Sensor accelerometer, int delay){
		super(manager);
		manager.registerListener(this, accelerometer, delay);
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		sensorData = new AndroidGyroscopeUncalibratedData(event.values, event.accuracy, event.timestamp);
		this.update(this, sensorData);
	}
	
	@Override
	public IAndroidGyroscopeUncalibratedData getData(){
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
