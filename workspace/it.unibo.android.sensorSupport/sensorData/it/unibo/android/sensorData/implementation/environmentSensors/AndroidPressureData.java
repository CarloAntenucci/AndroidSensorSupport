package it.unibo.android.sensorData.implementation.environmentSensors;

import it.unibo.android.sensorData.implementation.AndroidSingleValueSensorData;
import it.unibo.android.sensorData.interfaces.environmentSensors.IAndroidPressureData;

public class AndroidPressureData extends AndroidSingleValueSensorData implements
		IAndroidPressureData {

	public AndroidPressureData(){
		super();
	}
	
	public AndroidPressureData(float[] values, int accuracy, long timestamp) {
		super(values, accuracy, timestamp);
	}

	@Override
	public float getPressure() {
		return value;
	}

}
