package it.unibo.android.sensorSupport.implementations.environmentSensors;

import it.unibo.android.sensorSupport.implementations.AndroidSensor;
import it.unibo.android.sensorSupport.interfaces.environmentSensors.IAndroidTemperature;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import it.unibo.android.sensorData.implementation.environmentSensors.AndroidTemperatureData;
import it.unibo.android.sensorData.interfaces.environmentSensors.IAndroidTemperatureData;

@Deprecated
/**
 *	Since API Level 14 (Android 4) this sensor is deprecated
 */
public class AndroidTemperature extends AndroidSensor implements IAndroidTemperature {
	
	private static AndroidTemperature[] instances = new AndroidTemperature[4];
	protected IAndroidTemperatureData sensorData;
	
	/**
	 * This method returns, if exist, an instance of AndroidProximity, else
	 * the AndroidProximity is created and returned.
	 * 
	 * @param manager the instance of SensorManager
	 * @param delay the registration delay defined by one of <b>SensorManager.SENSOR_DELAY_*</b>
	 * 
	 * @return the instance of AndroidProximity
	 */
	public static AndroidTemperature getInstance(SensorManager manager, int delay){
		Sensor proximity = manager.getDefaultSensor(Sensor.TYPE_TEMPERATURE);
		if(proximity != null){
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
				instances[index] = new AndroidTemperature(manager, proximity, delay);
			return instances[index];
		}
		return null;
	}
	
	@Override
	public IAndroidTemperatureData getData() {
		return sensorData;
	}
	
	
	private AndroidTemperature(SensorManager manager, Sensor proximity, int delay){
			super(manager);
			manager.registerListener(this, proximity, delay);
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		sensorData = new AndroidTemperatureData(event.values, event.accuracy, event.timestamp);
		this.update(this, sensorData);
	}
	
	@Override
	public void unregister(){
		for(int i = 0; i < instances.length; i++)
			if(this.equals(instances[i]))
				instances[i] = null;
		super.unregister();
	}
	
}
