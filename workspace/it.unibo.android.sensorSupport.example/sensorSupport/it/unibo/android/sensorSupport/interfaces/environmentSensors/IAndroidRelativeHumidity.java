/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorSupport.interfaces.environmentSensors;

import it.unibo.android.sensorSupport.interfaces.IAndroidSensor;
import it.unibo.android.sensorData.interfaces.environmentSensors.IAndroidRelativeHumidityData;

public interface IAndroidRelativeHumidity extends IAndroidSensor {
	/**
	 * Get method that
	 * @return the AndroidRelativeHumidityData
	 */
	public IAndroidRelativeHumidityData getData();
}
