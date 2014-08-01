package it.unibo.android.sensorSupport.implementations.positionSensors;

import it.unibo.android.sensorSupport.implementations.AndroidSensor;
import it.unibo.android.sensorSupport.interfaces.positionSensors.IAndroidProximity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import it.unibo.android.sensorData.implementation.positionSensors.AndroidProximityData;
import it.unibo.android.sensorData.interfaces.positionSensors.IAndroidProximityData;

public class AndroidProximity extends AndroidSensor implements IAndroidProximity {
	
	private static AndroidProximity[] instances = new AndroidProximity[4];
	protected IAndroidProximityData sensorData;
	
	/**
	 * This method returns, if exist, an instance of AndroidProximity, else
	 * the AndroidProximity is created and returned.
	 * 
	 * @param manager the instance of SensorManager
	 * @param delay the registration delay defined by one of <b>SensorManager.SENSOR_DELAY_*</b>
	 * 
	 * @return the instance of AndroidProximity
	 */
	public static AndroidProximity getInstance(SensorManager manager, int delay){
		Sensor proximity = manager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
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
				instances[index] = new AndroidProximity(manager, proximity, delay);
			return instances[index];
		}
		return null;
	}
	
	@Override
	public IAndroidProximityData getData() {
		return sensorData;
	}
	
	
	private AndroidProximity(SensorManager manager, Sensor proximity, int delay){
			super(manager);
			manager.registerListener(this, proximity, delay);
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		sensorData = new AndroidProximityData(event.values, event.accuracy, event.timestamp);
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
