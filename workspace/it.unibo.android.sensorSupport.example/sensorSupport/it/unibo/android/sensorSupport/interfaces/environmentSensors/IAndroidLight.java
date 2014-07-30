/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorSupport.interfaces.environmentSensors;

import it.unibo.android.sensorSupport.interfaces.IAndroidSensor;
import it.unibo.android.sensorData.interfaces.environmentSensors.IAndroidLightData;

public interface IAndroidLight extends IAndroidSensor {
	/**
	 * Get method that
	 * @return the AndroidLightData
	 */
	public IAndroidLightData getData();
}
