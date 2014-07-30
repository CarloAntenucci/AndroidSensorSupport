package it.unibo.android.sensorSupport.interfaces.positionSensors;

import it.unibo.android.sensorSupport.interfaces.IAndroidSensor;
import it.unibo.android.sensorData.interfaces.positionSensors.IAndroidOrientationData;

@Deprecated
/**
 *	Since API Level 8 (Android 2.2) this interface is deprecated
 */
public interface IAndroidOrientation extends IAndroidSensor {
	/**
	 * Get method that
	 * @return the AndroidOrientationData
	 */
	public IAndroidOrientationData getData();
}
