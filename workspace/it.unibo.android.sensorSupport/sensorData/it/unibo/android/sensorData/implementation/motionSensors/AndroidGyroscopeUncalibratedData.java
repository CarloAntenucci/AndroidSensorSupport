package it.unibo.android.sensorData.implementation.motionSensors;

import it.unibo.android.sensorData.implementation.AndroidThreeAxisSensorDataWithCorrection;
import it.unibo.android.sensorData.interfaces.motionSensors.IAndroidGyroscopeUncalibratedData;

public class AndroidGyroscopeUncalibratedData extends AndroidThreeAxisSensorDataWithCorrection implements
		IAndroidGyroscopeUncalibratedData{

	public AndroidGyroscopeUncalibratedData(float[] values, int accuracy, long timestamp) {
		super(values, accuracy, timestamp);
	}

	@Override
	public float getRotationRateX() {
		return getX();
	}

	@Override
	public float getRotationRateY() {
		return getY();
	}

	@Override
	public float getRotationRateZ() {
		return getZ();
	}

	@Override
	public float getDriftX() {
		return getCorrectionX();
	}

	@Override
	public float getDriftY() {
		return getCorrectionY();
	}

	@Override
	public float getDriftZ() {
		return getCorrectionZ();
	}

}
