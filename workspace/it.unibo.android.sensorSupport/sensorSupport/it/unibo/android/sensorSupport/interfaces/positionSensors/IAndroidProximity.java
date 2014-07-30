/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorSupport.interfaces.positionSensors;

import it.unibo.android.sensorSupport.interfaces.IAndroidSensor;
import it.unibo.android.sensorData.interfaces.positionSensors.IAndroidProximityData;

public interface IAndroidProximity extends IAndroidSensor {
	/**
	 * Get method that
	 * @return the AndroidProximityData
	 */
	public IAndroidProximityData getData();
}
