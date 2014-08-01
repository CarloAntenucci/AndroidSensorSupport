package it.unibo.android.sensorData.implementation.motionSensors;

import it.unibo.android.sensorData.implementation.AndroidSensorData;
import it.unibo.android.sensorData.interfaces.motionSensors.IAndroidMotionRotationVectorData;

public class AndroidMotionRotationVectorData extends AndroidSensorData implements
		IAndroidMotionRotationVectorData {
	
	protected float componentX;
	protected float componentY;
	protected float componentZ;
	protected float componentS;

	
	public AndroidMotionRotationVectorData(float[] values, int accuracy, long timestamp) {
		super(values, accuracy, timestamp);
		componentX = values[0];
		componentY = values[1];
		componentZ = values[2];
		if (values.length == 4)
			componentS = values[3]; 
	}

	@Override
	public float getComponentX() {
		return componentX;
	}

	@Override
	public float getComponentY() {
		return componentY;
	}

	@Override
	public float getComponentZ() {
		return componentZ;
	}

	@Override
	public float getScalarComponent() {
		return componentS;
	}

	@Override
	public String getPrologRep(){
		String rep = getName()+"(x("+getComponentX()+"),y("+getComponentY()+"),z("+getComponentZ()+"),";
		rep += "s("+getScalarComponent()+"),timestamp("+getTimestamp()+"),accuracy("+getAccuracy()+"))";
		return rep;
	}
}
