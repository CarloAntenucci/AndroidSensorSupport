/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorSupport.interfaces.environmentSensors;

import it.unibo.android.sensorSupport.interfaces.IAndroidSensor;
import it.unibo.android.sensorData.interfaces.environmentSensors.IAndroidTemperatureData;

public interface IAndroidTemperature extends IAndroidSensor {
	/**
	 * Get method that
	 * @return the AndroidTemperatureData
	 */
	public IAndroidTemperatureData getData();
}
