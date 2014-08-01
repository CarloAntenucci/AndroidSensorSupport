package it.unibo.android.sensorData.implementation.environmentSensors;

import it.unibo.android.sensorData.implementation.AndroidSingleValueSensorData;
import it.unibo.android.sensorData.interfaces.environmentSensors.IAndroidLightData;

public class AndroidLightData extends AndroidSingleValueSensorData implements
		IAndroidLightData {

	public AndroidLightData(float[] values, int accuracy, long timestamp) {
		super(values, accuracy, timestamp);
	}

	@Override
	public float getLight() {
		return value;
	}

}
