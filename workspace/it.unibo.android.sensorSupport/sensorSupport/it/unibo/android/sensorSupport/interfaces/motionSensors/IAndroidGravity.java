/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorSupport.interfaces.motionSensors;

import it.unibo.android.sensorSupport.interfaces.IAndroidSensor;
import it.unibo.android.sensorData.interfaces.motionSensors.IAndroidGravityData;

public interface IAndroidGravity extends IAndroidSensor {
	/**
	 * Get method that
	 * @return the AndroidGravityData
	 */
	public IAndroidGravityData getData();
}
