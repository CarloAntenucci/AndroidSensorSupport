/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.interfaces.positionSensors;

import it.unibo.android.sensorData.interfaces.IAndroidThreeAxisSensorData;

@Deprecated
/**
 *	This interface in deprecated since Android 2.2 Froyo (API Level 8) 
 */
public interface IAndroidOrientationData extends IAndroidThreeAxisSensorData{
	/**
	 * Get method that
	 * @return the Azimuth value  (X axis)
	 */
	public float getAzimuth();
	/**
	 * Get method that
	 * @return the Pitch value (Y axis)
	 */
	public float getPitch();
	/**
	 * Get method that
	 * @return the Roll value (Z axis)
	 */
	public float getRoll();

}
