/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.interfaces.motionSensors;

import it.unibo.android.sensorData.interfaces.IAndroidThreeAxisSensorData;

public interface IAndroidGravityData extends IAndroidThreeAxisSensorData {
	/**
	 * Get method that
	 * @return the gravity value on the X axis
	 */	
	public float getGravityX();
	/**
	 * Get method that
	 * @return the gravity value on the Y axis
	 */	
	public float getGravityY();
	/**
	 * Get method that
	 * @return the gravity value on the Z axis
	 */	
	public float getGravityZ();

}
