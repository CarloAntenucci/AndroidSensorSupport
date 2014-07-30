/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.interfaces;

public interface IAndroidSingleValueSensorData extends IAndroidSensorData{
	/**
	 * Get method that
	 * @return the significant value of a SingleValueSensor measurement
	 */	
	public float getValue();
	
}
