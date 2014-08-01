package it.unibo.android.sensorData.implementation;

import it.unibo.android.sensorData.interfaces.IAndroidThreeAxisSensorData;

public class AndroidThreeAxisSensorData extends AndroidSensorData implements
		IAndroidThreeAxisSensorData {

	float x, y, z;
	
	public AndroidThreeAxisSensorData(float[] values, int accuracy, long timestamp) {
		super(values, accuracy, timestamp);
		x = values[0];
		y = values[1];
		z = values[2];
	}
	
	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public float getZ() {
		return z;
	}
	
	@Override
	public String getPrologRep(){
			String rep = getName()+"(x("+getX()+"),y("+getY()+"),z("+getZ()+"),";
			rep += "timestamp("+getTimestamp()+"),accuracy("+getAccuracy()+"))";
			return rep;
	}

}
