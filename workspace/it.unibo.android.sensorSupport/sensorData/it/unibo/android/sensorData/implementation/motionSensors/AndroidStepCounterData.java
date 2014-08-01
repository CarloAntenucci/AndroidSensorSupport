package it.unibo.android.sensorData.implementation.motionSensors;

import it.unibo.android.sensorData.implementation.AndroidSingleValueSensorData;
import it.unibo.android.sensorData.interfaces.motionSensors.IAndroidStepCounterData;

public class AndroidStepCounterData extends AndroidSingleValueSensorData implements
		IAndroidStepCounterData {

	
	public AndroidStepCounterData(float[] values, int accuracy, long timestamp) {
		super(values, accuracy, timestamp);
	}

	@Override
	public float getSteps() {
		return getValue();
	}



}
