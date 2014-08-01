package it.unibo.android.sensorData.implementation.motionSensors;

import it.unibo.android.sensorData.implementation.AndroidThreeAxisSensorData;
import it.unibo.android.sensorData.interfaces.motionSensors.IAndroidGravityData;

public class AndroidGravityData extends AndroidThreeAxisSensorData implements
		IAndroidGravityData {

	public AndroidGravityData(float[] values, int accuracy, long timestamp) {
		super(values, accuracy, timestamp);
	}

	@Override
	public float getGravityX() {
		return getX();
	}

	@Override
	public float getGravityY() {
		return getY();
	}

	@Override
	public float getGravityZ() {
		return getZ();
	}

}
