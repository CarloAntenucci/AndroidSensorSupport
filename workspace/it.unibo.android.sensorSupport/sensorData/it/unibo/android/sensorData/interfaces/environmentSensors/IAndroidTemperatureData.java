/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.interfaces.environmentSensors;
/**

 */
import it.unibo.android.sensorData.interfaces.IAndroidSingleValueSensorData;

public interface IAndroidTemperatureData extends IAndroidSingleValueSensorData{
	/**
	 * Get method that
	 * @return the ambient temperature in Celsius degrees
	 */
	public float getTemperatureCelsius();

	/**
	 * Get method that
	 * @return the ambient temperature in Farenheit degrees
	 */
	public float getTemperatureFarenheit();
	
	/**
	 * Get method that
	 * @return the ambient temperature in Kelvin Degrees
	 */
	public float getTemperatureKelvin();
}
