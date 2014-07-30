/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.interfaces;

public interface IAndroidDetectionSensorData extends IAndroidSensorData{
	/**
	 * Get method that
	 * @return the timestamp of last detection
	 */	
	public long getLastDetectionTime();
	
}
