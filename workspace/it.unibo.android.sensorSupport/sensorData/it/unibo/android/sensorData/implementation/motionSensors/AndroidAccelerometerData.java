package it.unibo.android.sensorData.implementation.motionSensors;

import it.unibo.android.sensorData.implementation.AndroidThreeAxisSensorData;
import it.unibo.android.sensorData.interfaces.motionSensors.IAndroidAccelerometerData;

public class AndroidAccelerometerData extends AndroidThreeAxisSensorData implements
		IAndroidAccelerometerData {

	public AndroidAccelerometerData(float[] values, int accuracy, long timestamp) {
		super(values, accuracy, timestamp);
	}
	
	@Override
	public float getAccelerationX() {
		return getX();
	}

	@Override
	public float getAccelerationY() {
		return getY();
	}

	@Override
	public float getAccelerationZ() {
		return getZ();
	}

	@Override
	public float getAcceleration() {
		return (float)Math.sqrt(Math.pow(getX(), 2)+Math.pow(getY(), 2)+Math.pow(getZ(), 2));
	}

}
