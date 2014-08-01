package it.unibo.android.sensorSupport.implementations.positionSensors;

import it.unibo.android.sensorSupport.implementations.AndroidSensor;
import it.unibo.android.sensorSupport.interfaces.positionSensors.IAndroidMagneticField;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import it.unibo.android.sensorData.implementation.positionSensors.AndroidMagneticFieldData;
import it.unibo.android.sensorData.interfaces.positionSensors.IAndroidMagneticFieldData;

public class AndroidMagneticField extends AndroidSensor implements
		IAndroidMagneticField {

	private static AndroidMagneticField[] instances = new AndroidMagneticField[4];
	protected IAndroidMagneticFieldData sensorData;
	
	/**
	 * This method returns, if exist, an instance of AndroidMagneticField, else
	 * the AndroidMagneticField is created and returned.
	 * 
	 * @param manager the instance of SensorManager
	 * @param delay the registration delay defined by one of <b>SensorManager.SENSOR_DELAY_*</b>
	 * 
	 * @return the instance of AndroidMagneticField
	 */
	public static AndroidMagneticField getInstance(SensorManager manager, int delay){
		Sensor magneticField = manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
		if(magneticField != null){
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
				instances[index] = new AndroidMagneticField(manager, magneticField, delay);
			return instances[index];
		}
		else
			return null;
	}
	
	private AndroidMagneticField(SensorManager manager, Sensor magneticField, int delay){
		super(manager);
		manager.registerListener(this, magneticField, delay);
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		sensorData = new AndroidMagneticFieldData(event.values, event.accuracy, event.timestamp);
		this.update(this, sensorData);
	}
	
	@Override
	public IAndroidMagneticFieldData getData(){
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
