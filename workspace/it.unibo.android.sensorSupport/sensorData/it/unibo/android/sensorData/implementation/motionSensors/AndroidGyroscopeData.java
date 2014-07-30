package it.unibo.android.sensorData.implementation.motionSensors;

import it.unibo.android.sensorData.implementation.AndroidThreeAxisSensorData;
import it.unibo.android.sensorData.interfaces.motionSensors.IAndroidGyroscopeData;

public class AndroidGyroscopeData extends AndroidThreeAxisSensorData implements
		IAndroidGyroscopeData {

	public AndroidGyroscopeData(){
		super();
	}
	
	public AndroidGyroscopeData(float[] values, int accuracy, long timestamp) {
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

}
