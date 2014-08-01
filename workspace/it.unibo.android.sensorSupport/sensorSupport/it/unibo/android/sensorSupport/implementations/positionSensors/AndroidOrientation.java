package it.unibo.android.sensorSupport.implementations.positionSensors;

import it.unibo.android.sensorSupport.implementations.AndroidSensor;
import it.unibo.android.sensorSupport.interfaces.positionSensors.IAndroidOrientation;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import it.unibo.android.sensorData.implementation.positionSensors.AndroidOrientationData;
import it.unibo.android.sensorData.interfaces.positionSensors.IAndroidOrientationData;

@Deprecated
/**
 *	Since API Level 8 (Android 2.2) this sensor is deprecated
 */
public class AndroidOrientation extends AndroidSensor implements
		IAndroidOrientation{

	private static AndroidOrientation[] instances = new AndroidOrientation[4];
	protected IAndroidOrientationData sensorData;
	
	/**
	 * This method returns, if exist, an instance of AndroidOrientation, else
	 * the AndroidOrientation is created and returned.
	 * 
	 * @param manager the instance of SensorManager
	 * @param delay the registration delay defined by one of <b>SensorManager.SENSOR_DELAY_*</b>
	 * 
	 * @return the instance of AndroidOrientation
	 */
	public static AndroidOrientation getInstance(SensorManager manager, int delay){
		Sensor orientation = manager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
		if(orientation != null){
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
				instances[index] = new AndroidOrientation(manager, orientation, delay);
			return instances[index];
		}
		else
			return null;
	}
	
	private AndroidOrientation(SensorManager manager, Sensor gameRotationVector, int delay){
		super(manager);
		manager.registerListener(this, gameRotationVector, delay);
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		sensorData = new AndroidOrientationData(event.values, event.accuracy, event.timestamp);
		this.update(this, sensorData);
	}
	
	@Override
	public IAndroidOrientationData getData(){
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

