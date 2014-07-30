/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorSupport.interfaces.motionSensors;

import it.unibo.android.sensorSupport.interfaces.IAndroidSensor;
import it.unibo.android.sensorData.interfaces.motionSensors.IAndroidMotionRotationVectorData;

public interface IAndroidRotationVector extends IAndroidSensor {
	/**
	 * Get method that
	 * @return the AndroidMotionRotationVectorData
	 */
	public IAndroidMotionRotationVectorData getData();
}
