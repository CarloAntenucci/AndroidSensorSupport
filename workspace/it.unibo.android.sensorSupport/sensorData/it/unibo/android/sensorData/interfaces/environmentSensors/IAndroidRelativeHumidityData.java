/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.interfaces.environmentSensors;
/**

 */
import it.unibo.android.sensorData.interfaces.IAndroidSingleValueSensorData;

public interface IAndroidRelativeHumidityData extends IAndroidSingleValueSensorData{
	/**
	 * Get method that
	 * @return the ambient relative humidity in %
	 */
	public float getHumidity();
}
