package it.unibo.android.sensorData.implementation.positionSensors;

import it.unibo.android.sensorData.implementation.AndroidThreeAxisSensorData;
import it.unibo.android.sensorData.interfaces.positionSensors.IAndroidMagneticFieldData;

public class AndroidMagneticFieldData extends AndroidThreeAxisSensorData implements
		IAndroidMagneticFieldData {

	
	public AndroidMagneticFieldData(float[] values, int accuracy, long timestamp) {
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

}
