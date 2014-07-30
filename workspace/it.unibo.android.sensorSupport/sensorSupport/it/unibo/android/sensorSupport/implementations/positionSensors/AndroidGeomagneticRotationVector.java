package it.unibo.android.sensorSupport.implementations.positionSensors;

import it.unibo.android.sensorSupport.implementations.AndroidSensor;
import it.unibo.android.sensorSupport.interfaces.positionSensors.IAndroidPositionRotationVector;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import it.unibo.android.sensorData.implementation.positionSensors.AndroidGameRotationVectorData;
import it.unibo.android.sensorData.interfaces.positionSensors.IAndroidPositionRotationVectorData;

public class AndroidGeomagneticRotationVector extends AndroidSensor implements
		IAndroidPositionRotationVector {

	private static AndroidGeomagneticRotationVector[] instances = new AndroidGeomagneticRotationVector[4];
	protected IAndroidPositionRotationVectorData sensorData;
	
	/**
	 * This method returns, if exist, an instance of AndroidGeomagneticRotationVector, else
	 * the AndroidGeomagneticRotationVector is created and returned.
	 * 
	 * @param manager the instance of SensorManager
	 * @param delay the registration delay defined by one of <b>SensorManager.SENSOR_DELAY_*</b>
	 * 
	 * @return the instance of AndroidGeomagneticRotationVector
	 */
	public static AndroidGeomagneticRotationVector getInstance(SensorManager manager, int delay){
		Sensor geomagneticRotationVector = manager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR);
		if(geomagneticRotationVector != null){
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
				instances[index] = new AndroidGeomagneticRotationVector(manager, geomagneticRotationVector, delay);
			return instances[index];
		}
		else
			return null;
	}
	
	private AndroidGeomagneticRotationVector(SensorManager manager, Sensor geomagneticRotationVector, int delay){
		sensorData = new AndroidGameRotationVectorData();
		manager.registerListener(this, geomagneticRotationVector, delay);
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

