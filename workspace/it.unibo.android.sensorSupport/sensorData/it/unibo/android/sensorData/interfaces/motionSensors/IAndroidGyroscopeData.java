/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.interfaces.motionSensors;
/**

 */
import it.unibo.android.sensorData.interfaces.IAndroidThreeAxisSensorData;

public interface IAndroidGyroscopeData extends IAndroidThreeAxisSensorData {
	
	/**
	 * Get method that
	 * @return the rotation rate on the X axis
	 */	
	public float getRotationRateX();
	/**
	 * Get method that
	 * @return the rotation rate on the Y axis
	 */	
	public float getRotationRateY();
	/**
	 * Get method that
	 * @return the rotation rate on the Z axis
	 */	
	public float getRotationRateZ();

}
