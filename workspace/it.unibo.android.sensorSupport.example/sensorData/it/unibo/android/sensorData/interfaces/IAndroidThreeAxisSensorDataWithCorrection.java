/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.interfaces;

public interface IAndroidThreeAxisSensorDataWithCorrection extends IAndroidThreeAxisSensorData{
	/**
	 * Get method that
	 * @return the correction value of measurement on the X axis of a three axis sensor
	 */	
	public float getCorrectionX();
	/**
	 * Get method that
	 * @return the correction value of measurement on the Y axis of a three axis sensor
	 */	
	public float getCorrectionY();
	/**
	 * Get method that
	 * @return the correction value of measurement on the Z axis of a three axis sensor
	 */	
	public float getCorrectionZ();
}
