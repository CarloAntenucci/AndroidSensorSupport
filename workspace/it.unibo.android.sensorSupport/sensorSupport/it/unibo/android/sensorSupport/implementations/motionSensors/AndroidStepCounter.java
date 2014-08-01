package it.unibo.android.sensorSupport.implementations.motionSensors;

import it.unibo.android.sensorSupport.implementations.AndroidSensor;
import it.unibo.android.sensorSupport.interfaces.motionSensors.IAndroidStepCounter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import it.unibo.android.sensorData.implementation.motionSensors.AndroidStepCounterData;
import it.unibo.android.sensorData.interfaces.motionSensors.IAndroidStepCounterData;

public class AndroidStepCounter extends AndroidSensor implements IAndroidStepCounter {
	
	private static AndroidStepCounter[] instances = new AndroidStepCounter[4];
	protected IAndroidStepCounterData sensorData;
	
	/**
	 * This method returns, if exist, an instance of AndroidStepCounter, else
	 * the AndroidStepCounter is created and returned.
	 * 
	 * @param manager the instance of SensorManager
	 * @param delay the registration delay defined by one of <b>SensorManager.SENSOR_DELAY_*</b>
	 * 
	 * @return the instance of AndroidStepCounter
	 */
	public static AndroidStepCounter getInstance(SensorManager manager, int delay){
		Sensor stepCounter = manager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
		if(stepCounter != null){
			int index;
			switch (delay){
				case SensorManager.SENSOR_DELAY_NORMAL:
					index = 0;
					break;
				case SensorManager.SENSOR_DELAY_UI:
					index = 1;
					break;
				case SensorManager.SENSOR_DELAY_GAME:
					index = 2;
					break;
				case SensorManager.SENSOR_DELAY_FASTEST:
					index = 3;
					break;
				default: return null;
			}
			if (instances[index] == null)
				instances[index] = new AndroidStepCounter(manager, stepCounter, delay);
			return instances[index];
		}
		return null;
	}

	private AndroidStepCounter(SensorManager manager, Sensor stepCounter, int delay){
		super(manager);
		manager.registerListener(this, stepCounter, delay);
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		sensorData = new AndroidStepCounterData(event.values, event.accuracy, event.timestamp);
		this.update(this, sensorData);
	}
	
	@Override
	public IAndroidStepCounterData getData() {
		return sensorData;
	}

	@Override
	public void unregister(){
		for(int i = 0; i < instances.length; i++)
			if(this.equals(instances[i]))
				instances[i] = null;
		super.unregister();
	}
}
