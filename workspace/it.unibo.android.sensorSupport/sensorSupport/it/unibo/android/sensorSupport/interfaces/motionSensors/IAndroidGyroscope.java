/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorSupport.interfaces.motionSensors;

import it.unibo.android.sensorSupport.interfaces.IAndroidSensor;
import it.unibo.android.sensorData.interfaces.motionSensors.IAndroidGyroscopeData;

public interface IAndroidGyroscope extends IAndroidSensor {
	/**
	 * Get method that
	 * @return the AndroidGyroscopeData
	 */
	public IAndroidGyroscopeData getData();
}
