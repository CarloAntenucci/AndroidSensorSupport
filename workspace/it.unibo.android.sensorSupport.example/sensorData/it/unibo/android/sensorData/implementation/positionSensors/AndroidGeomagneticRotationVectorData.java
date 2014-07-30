package it.unibo.android.sensorData.implementation.positionSensors;

import it.unibo.android.sensorData.implementation.AndroidThreeAxisSensorData;
import it.unibo.android.sensorData.interfaces.positionSensors.IAndroidPositionRotationVectorData;

public class AndroidGeomagneticRotationVectorData extends AndroidThreeAxisSensorData implements
		IAndroidPositionRotationVectorData {

	
	public AndroidGeomagneticRotationVectorData(){
		super();
	}
	
	public AndroidGeomagneticRotationVectorData(float[] values, int accuracy, long timestamp) {
		super(values, accuracy, timestamp);
	}

	@Override
	public float getComponentX() {
		return getX();
	}

	@Override
	public float getComponentY() {
		return getY();
	}

	@Override
	public float getComponentZ() {
		return getZ();
	}

}
