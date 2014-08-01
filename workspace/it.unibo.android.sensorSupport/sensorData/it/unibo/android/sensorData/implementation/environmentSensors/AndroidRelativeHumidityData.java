package it.unibo.android.sensorData.implementation.environmentSensors;

import it.unibo.android.sensorData.implementation.AndroidSingleValueSensorData;
import it.unibo.android.sensorData.interfaces.environmentSensors.IAndroidRelativeHumidityData;

public class AndroidRelativeHumidityData extends AndroidSingleValueSensorData implements
		IAndroidRelativeHumidityData {

	public AndroidRelativeHumidityData(float[] values, int accuracy, long timestamp) {
		super(values, accuracy, timestamp);
	}

	@Override
	public float getHumidity() {
		return value;
	}

}
