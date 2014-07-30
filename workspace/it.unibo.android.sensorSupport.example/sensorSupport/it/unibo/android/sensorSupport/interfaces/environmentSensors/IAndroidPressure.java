/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorSupport.interfaces.environmentSensors;

import it.unibo.android.sensorSupport.interfaces.IAndroidSensor;
import it.unibo.android.sensorData.interfaces.environmentSensors.IAndroidPressureData;

public interface IAndroidPressure extends IAndroidSensor {
	/**
	 * Get method that
	 * @return the AndroidPressureData
	 */
	public IAndroidPressureData getData();
}
