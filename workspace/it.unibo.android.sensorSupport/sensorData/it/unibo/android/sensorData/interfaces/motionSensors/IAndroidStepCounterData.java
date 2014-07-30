/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.interfaces.motionSensors;
/**

 */
import it.unibo.android.sensorData.interfaces.IAndroidSingleValueSensorData;

public interface IAndroidStepCounterData extends IAndroidSingleValueSensorData{
	/**
	 * Get method that
	 * @return the number of steps since last reboot
	 */
	public float getSteps();

}
