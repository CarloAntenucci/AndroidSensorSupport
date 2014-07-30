package it.unibo.android.sensorData.implementation.positionSensors;

import it.unibo.android.sensorData.implementation.AndroidThreeAxisSensorData;
import it.unibo.android.sensorData.interfaces.positionSensors.IAndroidOrientationData;

@Deprecated
/**
 *	Since API Level 8 (Android 2.2) this class is deprecated
 */
public class AndroidOrientationData extends AndroidThreeAxisSensorData implements
		IAndroidOrientationData {

	
	public AndroidOrientationData(){
		super();
	}
	
	public AndroidOrientationData(float[] values, int accuracy, long timestamp) {
		super(values, accuracy, timestamp);
	}
	
	@Override
	public float getAzimuth() {
		return getX();
	}

	@Override
	public float getPitch() {
		return getY();
	}

	@Override
	public float getRoll() {
		return getZ();
	}

}
