/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.interfaces.motionSensors;
/**

 */
import it.unibo.android.sensorData.interfaces.IAndroidThreeAxisSensorData;

public interface IAndroidAccelerometerData extends IAndroidThreeAxisSensorData{
	/**
	 * Get method that
	 * @return the acceleration value on the X axis
	 */	
	public float getAccelerationX();
	/**
	 * Get method that
	 * @return the acceleration value on the Y axis
	 */	
	public float getAccelerationY();
	/**
	 * Get method that
	 * @return the acceleration value on the Z axis
	 */	
	public float getAccelerationZ();
	/**
	 * Get method that
	 * @return the device's acceleration value
	 */	
	public float getAcceleration();

}
