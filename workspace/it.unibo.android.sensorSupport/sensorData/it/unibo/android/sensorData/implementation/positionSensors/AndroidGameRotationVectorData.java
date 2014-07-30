package it.unibo.android.sensorData.implementation.positionSensors;

import it.unibo.android.sensorData.implementation.AndroidThreeAxisSensorData;
import it.unibo.android.sensorData.interfaces.positionSensors.IAndroidPositionRotationVectorData;

public class AndroidGameRotationVectorData extends AndroidThreeAxisSensorData implements
		IAndroidPositionRotationVectorData {

	
	public AndroidGameRotationVectorData(){
		super();
	}
	
	public AndroidGameRotationVectorData(float[] values, int accuracy, long timestamp) {
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
