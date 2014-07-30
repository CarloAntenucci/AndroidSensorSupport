package it.unibo.android.sensorSupport.implementations.positionSensors;

import it.unibo.android.sensorSupport.implementations.AndroidSensor;
import it.unibo.android.sensorSupport.interfaces.positionSensors.IAndroidPositionRotationVector;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import it.unibo.android.sensorData.implementation.positionSensors.AndroidGameRotationVectorData;
import it.unibo.android.sensorData.interfaces.positionSensors.IAndroidPositionRotationVectorData;

public class AndroidGameRotationVector extends AndroidSensor implements
		IAndroidPositionRotationVector {

	private static AndroidGameRotationVector[] instances = new AndroidGameRotationVector[4];
	protected IAndroidPositionRotationVectorData sensorData;
	
	/**
	 * This method returns, if exist, an instance of AndroidGameRotationVector, else
	 * the AndroidGameRotationVector is created and returned.
	 * 
	 * @param manager the instance of SensorManager
	 * @param delay the registration delay defined by one of <b>SensorManager.SENSOR_DELAY_*</b>
	 * 
	 * @return the instance of AndroidGameRotationVector
	 */
	public static AndroidGameRotationVector getInstance(SensorManager manager, int delay){
		Sensor gameRotationVector = manager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR);
		if(gameRotationVector != null){
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
				instances[index] = new AndroidGameRotationVector(manager, gameRotationVector, delay);
			return instances[index];
		}
		else
			return null;
	}
	
	private AndroidGameRotationVector(SensorManager manager, Sensor gameRotationVector, int delay){
		sensorData = new AndroidGameRotationVectorData();
		manager.registerListener(this, gameRotationVector, delay);
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		sensorData = new AndroidGameRotationVectorData(event.values, event.accuracy, event.timestamp);
		this.update(this, sensorData);
	}
	
	@Override
	public IAndroidPositionRotationVectorData getData(){
		return sensorData;
	}

	@Override
	public void unregister(SensorManager manager){
		for(int i = 0; i < instances.length; i++)
			if(this.equals(instances[i]))
				instances[i] = null;
		super.unregister(manager);
	}
}

