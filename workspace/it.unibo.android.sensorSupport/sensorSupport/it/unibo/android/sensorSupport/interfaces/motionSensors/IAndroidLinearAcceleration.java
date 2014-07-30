/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorSupport.interfaces.motionSensors;

import it.unibo.android.sensorSupport.interfaces.IAndroidSensor;
import it.unibo.android.sensorData.interfaces.motionSensors.IAndroidAccelerometerData;

public interface IAndroidLinearAcceleration extends IAndroidSensor {
	/**
	 * Get method that
	 * @return the AndroidAccelerometerData
	 */
	public IAndroidAccelerometerData getData();
}
