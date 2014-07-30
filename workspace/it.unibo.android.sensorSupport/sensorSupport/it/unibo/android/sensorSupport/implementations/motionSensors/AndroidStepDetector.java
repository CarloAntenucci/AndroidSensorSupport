package it.unibo.android.sensorSupport.implementations.motionSensors;

import it.unibo.android.sensorSupport.implementations.AndroidSensor;
import it.unibo.android.sensorSupport.interfaces.motionSensors.IAndroidDetectionSensor;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import it.unibo.android.sensorData.implementation.AndroidDetectionSensorData;
import it.unibo.android.sensorData.interfaces.IAndroidDetectionSensorData;

public class AndroidStepDetector extends AndroidSensor implements
		IAndroidDetectionSensor{

	private static AndroidStepDetector[] instances = new AndroidStepDetector[4];
	protected IAndroidDetectionSensorData sensorData;
	
	/**
	 * This method returns, if exist, an instance of AndroidStepDetector, else
	 * the AndroidStepDetector is created and returned.
	 * 
	 * @param manager the instance of SensorManager
	 * @param delay the registration delay defined by one of <b>SensorManager.SENSOR_DELAY_*</b>
	 * 
	 * @return the instance of AndroidStepDetector
	 */
	public static AndroidStepDetector getInstance(SensorManager manager, int delay){
		Sensor stepDetector = manager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
		if(stepDetector != null){
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
				instances[index] = new AndroidStepDetector(manager, stepDetector, delay);
			return instances[index];
		}
		else
			return null;
	}
	
	private AndroidStepDetector(SensorManager manager, Sensor stepDetector, int delay){
		sensorData = new AndroidDetectionSensorData();	
		manager.registerListener(this, stepDetector, delay);
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		sensorData = new AndroidDetectionSensorData(event.values, event.accuracy, event.timestamp);
		this.update(this, sensorData);
	}
	
	@Override
	public IAndroidDetectionSensorData getData(){
		return sensorData;
	}

	@Override
	public void unregister(SensorManager manager){
		for(int i = 0; i < instances.length; i++)
			if(this.equals(instances[i]))
				instances[i] = null;
		super.unregister(manager);
	}
}
