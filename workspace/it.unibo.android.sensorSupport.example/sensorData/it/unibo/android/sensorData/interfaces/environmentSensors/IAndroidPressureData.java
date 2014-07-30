/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.interfaces.environmentSensors;
/**

 */
import it.unibo.android.sensorData.interfaces.IAndroidSingleValueSensorData;

public interface IAndroidPressureData extends IAndroidSingleValueSensorData{
	/**
	 * Get method that
	 * @return the air pressure in hPa or mbar
	 */
	public float getPressure();
}
