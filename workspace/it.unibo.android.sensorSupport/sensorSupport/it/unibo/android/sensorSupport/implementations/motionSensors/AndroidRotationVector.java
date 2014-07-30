package it.unibo.android.sensorSupport.implementations.motionSensors;

import it.unibo.android.sensorSupport.implementations.AndroidSensor;
import it.unibo.android.sensorSupport.interfaces.motionSensors.IAndroidRotationVector;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import it.unibo.android.sensorData.implementation.motionSensors.AndroidMotionRotationVectorData;
import it.unibo.android.sensorData.interfaces.motionSensors.IAndroidMotionRotationVectorData;

public class AndroidRotationVector extends AndroidSensor implements
		IAndroidRotationVector {

	private static AndroidRotationVector[] instances = new AndroidRotationVector[4];
	protected IAndroidMotionRotationVectorData sensorData;
	
	/**
	 * This method returns, if exist, an instance of AndroidRotationVector, else
	 * the AndroidRotationVector is created and returned.
	 * 
	 * @param manager the instance of SensorManager
	 * @param delay the registration delay defined by one of <b>SensorManager.SENSOR_DELAY_*</b>
	 * 
	 * @return the instance of AndroidRotationVector
	 */
	public static AndroidRotationVector getInstance(SensorManager manager, int delay){
		Sensor rotationVector = manager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
		if(rotationVector != null){
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
				instances[index] = new AndroidRotationVector(manager, rotationVector, delay);
			return instances[index];
		}
		else
			return null;
	}
	
	private AndroidRotationVector(SensorManager manager, Sensor rotationVector, int delay){
		sensorData = new AndroidMotionRotationVectorData();	
		manager.registerListener(this, rotationVector, delay);
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		sensorData = new AndroidMotionRotationVectorData(event.values, event.accuracy, event.timestamp);
		this.update(this, sensorData);
	}
	
	@Override
	public IAndroidMotionRotationVectorData getData(){
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
