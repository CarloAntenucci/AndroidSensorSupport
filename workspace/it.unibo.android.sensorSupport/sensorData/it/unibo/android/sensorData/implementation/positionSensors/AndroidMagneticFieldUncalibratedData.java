package it.unibo.android.sensorData.implementation.positionSensors;

import it.unibo.android.sensorData.implementation.AndroidThreeAxisSensorDataWithCorrection;
import it.unibo.android.sensorData.interfaces.positionSensors.IAndroidMagneticFieldUncalibratedData;

public class AndroidMagneticFieldUncalibratedData extends AndroidThreeAxisSensorDataWithCorrection implements
		IAndroidMagneticFieldUncalibratedData{

	public AndroidMagneticFieldUncalibratedData(float[] values, int accuracy, long timestamp) {
		super(values, accuracy, timestamp);
	}

	@Override
	public float getMagneticFieldX() {
		return getX();
	}

	@Override
	public float getMagneticFieldY() {
		return getY();
	}

	@Override
	public float getMagneticFieldZ() {
		return getZ();
	}

	@Override
	public float getBiasX() {
		return getCorrectionX();
	}

	@Override
	public float getBiasY() {
		return getCorrectionY();
	}

	@Override
	public float getBiasZ() {
		return getCorrectionZ();
	}

}
