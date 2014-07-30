/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.interfaces.motionSensors;
/**

 */
import it.unibo.android.sensorData.interfaces.IAndroidThreeAxisSensorDataWithCorrection;

public interface IAndroidGyroscopeUncalibratedData extends IAndroidThreeAxisSensorDataWithCorrection, IAndroidGyroscopeData {
	/**
	 * Get method that
	 * @return the drift on the X axis
	 */	
	public float getDriftX();
	/**
	 * Get method that
	 * @return the drift on the Y axis
	 */	
	public float getDriftY();
	/**
	 * Get method that
	 * @return the drift on the Z axis
	 */	
	public float getDriftZ();

}
