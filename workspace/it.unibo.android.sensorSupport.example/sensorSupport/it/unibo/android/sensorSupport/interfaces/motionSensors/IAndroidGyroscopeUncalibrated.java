/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorSupport.interfaces.motionSensors;

import it.unibo.android.sensorSupport.interfaces.IAndroidSensor;
import it.unibo.android.sensorData.interfaces.motionSensors.IAndroidGyroscopeUncalibratedData;

public interface IAndroidGyroscopeUncalibrated extends IAndroidSensor {
	/**
	 * Get method that
	 * @return the AndroidGyroscopeUncalibratedData
	 */
	public IAndroidGyroscopeUncalibratedData getData();
}
