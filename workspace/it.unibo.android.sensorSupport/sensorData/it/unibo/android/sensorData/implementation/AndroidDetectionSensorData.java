package it.unibo.android.sensorData.implementation;

import it.unibo.android.sensorData.interfaces.IAndroidDetectionSensorData;

/*
 *	This class is used for each detection sensors: SIGNIFICANT_MOTION and STEP_DETECTOR 
 */
public class AndroidDetectionSensorData extends AndroidSensorData implements
		IAndroidDetectionSensorData {

	private long detectionTime;
	
	public AndroidDetectionSensorData(float[] values, int accuracy, long timestamp) {
		super(values, accuracy, timestamp);
		detectionTime = System.currentTimeMillis();
	}

	//for json reconstruction
	public AndroidDetectionSensorData(float[] values, int accuracy, long timestamp, long detectionTime) {
		super(values, accuracy, timestamp);
		this.detectionTime = detectionTime;
	}
	
	@Override
	/**
	 * This method, IN THIS CLASS, returns a null value because this type of sensors 
	 * doesn't have values but only notifies a detection, so may return an empty array.
	 */
	public float[] giveMeValues() {
		return null;
	}

	@Override
	public String getPrologRep(){
			String rep = getName()+"(timestamp("+getTimestamp()+"),accuracy("+getAccuracy()+"))";
			return rep;
	}

	@Override
	public long getLastDetectionTime() {
		return detectionTime;
	}

	

}
