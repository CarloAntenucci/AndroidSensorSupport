/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.interfaces.positionSensors;

import it.unibo.android.sensorData.interfaces.IAndroidThreeAxisSensorData;

public interface IAndroidMagneticFieldData extends IAndroidThreeAxisSensorData{
	/**
	 * Get method that
	 * @return the magnetic field value on the X axis
	 */
	public float getMagneticFieldX();
	/**
	 * Get method that
	 * @return the magnetic field value on the Y axis
	 */
	public float getMagneticFieldY();
	/**
	 * Get method that
	 * @return the magnetic field value on the Z axis
	 */
	public float getMagneticFieldZ();

}
