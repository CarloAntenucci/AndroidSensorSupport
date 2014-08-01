package it.unibo.android.sensorData.implementation.positionSensors;

import it.unibo.android.sensorData.implementation.AndroidSingleValueSensorData;
import it.unibo.android.sensorData.interfaces.positionSensors.IAndroidProximityData;

public class AndroidProximityData extends AndroidSingleValueSensorData implements
		IAndroidProximityData {

	public AndroidProximityData(float[] values, int accuracy, long timestamp) {
		super(values, accuracy, timestamp);
	}

	@Override
	public boolean isPresent() {
		if (value == 0)
			return true;
		else
			return false;
	}

}
