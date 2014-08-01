package it.unibo.android.sensorData.implementation;

import it.unibo.android.sensorData.interfaces.IAndroidThreeAxisSensorDataWithCorrection;

public class AndroidThreeAxisSensorDataWithCorrection extends AndroidThreeAxisSensorData implements
		IAndroidThreeAxisSensorDataWithCorrection {

	float correctionX, correctionY, correctionZ;
	
	public AndroidThreeAxisSensorDataWithCorrection(float[] values, int accuracy, long timestamp) {
		super(values, accuracy, timestamp);
		correctionX = values[3];
		correctionY = values[4];
		correctionZ = values[5];
	}
	
	@Override
	public float getCorrectionX() {
		return correctionX;
	}

	@Override
	public float getCorrectionY() {
		return correctionY;
	}

	@Override
	public float getCorrectionZ() {
		return z;
	}
	
	@Override
	public String getPrologRep(){
            String rep = getName()+"(x("+getX()+"),y("+getY()+"),z("+getZ()+"),";
            rep += "correctionX("+getCorrectionX()+"),correctionY("+getCorrectionY()+"),";
            rep += "correctionZ("+getCorrectionZ()+"),timestamp("+getTimestamp()+"),";
            rep += "accuracy("+getAccuracy()+"))";
            return rep;
	}
	

}
