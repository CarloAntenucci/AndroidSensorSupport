/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.interfaces;
/**

 */

public interface IAndroidSensorData {
	/**
	 * Get method that
	 * @return the SensorData's name
	 */
	public String getName();
	/**
	 * Get method that
	 * @return the float array of sensor's values
	 */
	public float[] giveMeValues();
	/**
	 * Get method that
	 * @return the SensorData prolog representation (a string)
	 */	
	public String getPrologRep();
	/**
	 * Get method that
	 * @return measurement accuracy of the sensor
	 */	
	public int getAccuracy();
	/**
	 * Get method that
	 * @return timestamp of measurement (relative to the sensor)
	 */	
	public long getTimestamp();
	/**
	 * Get method that
	 * @return the SensorData Json representation (a string)
	 */	
	public String getJsonRep();
	
}
