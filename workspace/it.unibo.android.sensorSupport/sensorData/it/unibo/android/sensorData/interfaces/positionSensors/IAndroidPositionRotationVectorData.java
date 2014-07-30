/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.interfaces.positionSensors;

import it.unibo.android.sensorData.interfaces.IAndroidThreeAxisSensorData;

public interface IAndroidPositionRotationVectorData extends IAndroidThreeAxisSensorData {
	/**
	 * Get method that
	 * @return the rotation component around X axis
	 */
	public float getComponentX();
	/**
	 * Get method that
	 * @return the rotation component around Y axis
	 */
	public float getComponentY();
	/**
	 * Get method that
	 * @return the rotation component around Z axis
	 */
	public float getComponentZ();

}
