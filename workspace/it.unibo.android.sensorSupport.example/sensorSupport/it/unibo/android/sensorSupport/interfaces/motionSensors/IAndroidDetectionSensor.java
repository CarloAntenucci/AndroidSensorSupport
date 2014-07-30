/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorSupport.interfaces.motionSensors;

import it.unibo.android.sensorSupport.interfaces.IAndroidSensor;
import it.unibo.android.sensorData.interfaces.IAndroidDetectionSensorData;

public interface IAndroidDetectionSensor extends IAndroidSensor {
	/**
	 * Get method that
	 * @return the AndroidDetectionSensorData
	 */
	public IAndroidDetectionSensorData getData();
}
