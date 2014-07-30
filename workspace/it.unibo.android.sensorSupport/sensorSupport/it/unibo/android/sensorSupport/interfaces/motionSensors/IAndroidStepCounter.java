/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorSupport.interfaces.motionSensors;

import it.unibo.android.sensorSupport.interfaces.IAndroidSensor;
import it.unibo.android.sensorData.interfaces.motionSensors.IAndroidStepCounterData;

public interface IAndroidStepCounter extends IAndroidSensor {
	/**
	 * Get method that
	 * @return the AndroidStepCounterData
	 */
	public IAndroidStepCounterData getData();
}
