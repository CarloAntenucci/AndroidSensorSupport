package it.unibo.android.sensorData.implementation;

import it.unibo.android.sensorData.interfaces.IAndroidSingleValueSensorData;

public class AndroidSingleValueSensorData extends AndroidSensorData implements
		IAndroidSingleValueSensorData {

	protected float value;
	
	public AndroidSingleValueSensorData(float[] values, int accuracy, long timestamp) {
		super(values, accuracy, timestamp);
		value = values[0];
	}

	@Override
	public float getValue() {
		return value;
	}

	@Override
	public String getPrologRep(){
			String rep = getName()+"(value("+getValue()+"),";
			rep += "timestamp("+getTimestamp()+"),accuracy("+getAccuracy()+"))";
			return rep;
	}
}
