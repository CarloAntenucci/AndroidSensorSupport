/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.interfaces.motionSensors;
/**

 */
import it.unibo.android.sensorData.interfaces.IAndroidSensorData;

public interface IAndroidMotionRotationVectorData extends IAndroidSensorData {
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
	/**
	 * Get method that
	 * @return the rotation's scalar component (can be null)
	 */
	public float getScalarComponent();

}
