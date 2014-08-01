package it.unibo.android.sensorData.implementation.environmentSensors;

import it.unibo.android.sensorData.implementation.AndroidSingleValueSensorData;
import it.unibo.android.sensorData.interfaces.environmentSensors.IAndroidTemperatureData;

public class AndroidTemperatureData extends AndroidSingleValueSensorData implements
		IAndroidTemperatureData {

	public AndroidTemperatureData(float[] values, int accuracy, long timestamp) {
		super(values, accuracy, timestamp);
	}

	@Override
	public float getTemperatureCelsius() {
		return value;
	}

	@Override
	public float getTemperatureFarenheit() {
		return (float) (32+(value*1.8));
	}

	@Override
	public float getTemperatureKelvin() {
		return (float) (value + 273.15);
	}

}
