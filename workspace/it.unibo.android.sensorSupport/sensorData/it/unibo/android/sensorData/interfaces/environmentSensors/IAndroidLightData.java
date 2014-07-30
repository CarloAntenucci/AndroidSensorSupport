/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.interfaces.environmentSensors;
/**

 */
import it.unibo.android.sensorData.interfaces.IAndroidSingleValueSensorData;

public interface IAndroidLightData extends IAndroidSingleValueSensorData{
	/**
	 * Get method that
	 * @return the ambient light in lx
	 */
	public float getLight();
}
