/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorSupport.interfaces.positionSensors;

import it.unibo.android.sensorSupport.interfaces.IAndroidSensor;
import it.unibo.android.sensorData.interfaces.positionSensors.IAndroidMagneticFieldUncalibratedData;

public interface IAndroidMagneticFieldUncalibrated extends IAndroidSensor {
	/**
	 * Get method that
	 * @return the AndroidMagneticFieldUncalibratedData
	 */
	public IAndroidMagneticFieldUncalibratedData getData();
}
