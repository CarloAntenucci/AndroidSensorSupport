/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.interfaces.positionSensors;

import it.unibo.android.sensorData.interfaces.IAndroidSingleValueSensorData;

public interface IAndroidProximityData extends IAndroidSingleValueSensorData{
	/**
	 * Get method that
	 * @return true if there is something near the device
	 */
	public boolean isPresent();

}
