package it.unibo.android.sensorSupport.interfaces.positionSensors;

import it.unibo.android.sensorSupport.interfaces.IAndroidSensor;
import it.unibo.android.sensorData.interfaces.positionSensors.IAndroidMagneticFieldData;

public interface IAndroidMagneticField extends IAndroidSensor {
	/**
	 * Get method that
	 * @return the AndroidMagneticFieldData
	 */
	public IAndroidMagneticFieldData getData();
}
