/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.interfaces;

public interface IAndroidThreeAxisSensorData extends IAndroidSensorData {
	/**
	 * Get method that
	 * @return the measurement value on the X axis of a three axis sensor
	 */	
	public float getX();
	/**
	 * Get method that
	 * @return the measurement value on the Y axis of a three axis sensor
	 */		
	public float getY();
	/**
	 * Get method that
	 * @return the measurement value on the Z axis of a three axis sensor
	 */		
	public float getZ();

}
