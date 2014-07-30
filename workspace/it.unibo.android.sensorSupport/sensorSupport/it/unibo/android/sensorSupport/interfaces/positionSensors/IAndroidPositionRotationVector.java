/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorSupport.interfaces.positionSensors;

import it.unibo.android.sensorSupport.interfaces.IAndroidSensor;
import it.unibo.android.sensorData.interfaces.positionSensors.IAndroidPositionRotationVectorData;

public interface IAndroidPositionRotationVector extends IAndroidSensor {
	/**
	 * Get method that
	 * @return the AndroidPositionRotationVectorData
	 */
	public IAndroidPositionRotationVectorData getData();
}
