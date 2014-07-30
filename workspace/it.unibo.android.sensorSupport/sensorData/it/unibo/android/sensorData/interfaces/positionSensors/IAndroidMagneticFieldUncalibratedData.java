/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.interfaces.positionSensors;

import it.unibo.android.sensorData.interfaces.IAndroidThreeAxisSensorDataWithCorrection;

public interface IAndroidMagneticFieldUncalibratedData extends IAndroidThreeAxisSensorDataWithCorrection, 
																IAndroidMagneticFieldData {
	/**
	 * Get method that
	 * @return the bias value on the X axis
	 */
	public float getBiasX();
	/**
	 * Get method that
	 * @return the bias value on the Y axis
	 */
	public float getBiasY();
	/**
	 * Get method that
	 * @return the bias value on the Z axis
	 */
	public float getBiasZ();

}
