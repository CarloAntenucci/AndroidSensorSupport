package it.unibo.android.sensorSupport.implementations.positionSensors;

import it.unibo.android.sensorSupport.implementations.AndroidSensor;
import it.unibo.android.sensorSupport.interfaces.positionSensors.IAndroidMagneticFieldUncalibrated;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import it.unibo.android.sensorData.implementation.positionSensors.AndroidMagneticFieldUncalibratedData;
import it.unibo.android.sensorData.interfaces.positionSensors.IAndroidMagneticFieldUncalibratedData;

public class AndroidMagneticFieldUncalibrated extends AndroidSensor implements
		IAndroidMagneticFieldUncalibrated {

	private static AndroidMagneticFieldUncalibrated[] instances = new AndroidMagneticFieldUncalibrated[4];
	protected IAndroidMagneticFieldUncalibratedData sensorData;
	
	/**
	 * This method returns, if exist, an instance of AndroidMagneticFieldUncalibrated, else
	 * the AndroidMagneticFieldUncalibrated is created and returned.
	 * 
	 * @param manager the instance of SensorManager
	 * @param delay the registration delay defined by one of <b>SensorManager.SENSOR_DELAY_*</b>
	 * 
	 * @return the instance of AndroidMagneticFieldUncalibrated
	 */
	public static AndroidMagneticFieldUncalibrated getInstance(SensorManager manager, int delay){
		Sensor magneticFieldUncalibrated = manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED);
		if(magneticFieldUncalibrated != null){
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
				instances[index] = new AndroidMagneticFieldUncalibrated(manager, magneticFieldUncalibrated, delay);
			return instances[index];
		}
		else
			return null;
	}
	
	private AndroidMagneticFieldUncalibrated(SensorManager manager, Sensor magneticFieldUncalibrated, int delay){
		super(manager);
		manager.registerListener(this, magneticFieldUncalibrated, delay);
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		sensorData = new AndroidMagneticFieldUncalibratedData(event.values, event.accuracy, event.timestamp);
		this.update(this, sensorData);
	}
	
	@Override
	public IAndroidMagneticFieldUncalibratedData getData(){
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
