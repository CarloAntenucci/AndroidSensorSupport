/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorSupport.interfaces;

import it.unibo.is.interfaces.IObservable;
import it.unibo.is.interfaces.IObserver;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import it.unibo.android.sensorData.interfaces.IAndroidSensorData;

public interface IAndroidSensor extends SensorEventListener, IObserver, IObservable{
	/**
	 * This method deletes observers and unregister the AndroidSensor.
	 * @param manager the SensorManager instance
	 */
	public void unregister(SensorManager manager);
	/**
	 * Get method that
	 * @return an instance of AndroidSensorData (according to the sensor)
	 */
	public IAndroidSensorData getData(); 
}
