package it.unibo.android.sensorData.implementation;


import it.unibo.android.sensorData.interfaces.IAndroidSensorData;

import com.google.gson.Gson;

public class AndroidSensorData implements IAndroidSensorData{
	
	private String name;
	
	protected transient float[] values ;
	private long timestamp;
	private int accuracy;
	
	
	public AndroidSensorData(float[] values, int accuracy, long timestamp){
		this.name = this.getClass().getSimpleName();
		this.values = values;
		this.accuracy = accuracy;
		this.timestamp = timestamp;
	}

	@Override
	public String getName() {
			return name;
	}

	public float[] giveMeValues() {
		return values;
	}

	@Override
	public String getPrologRep() {
			String rep = getName()+"(values(";
			for(int i=0;i<values.length;i++){
				rep += "v"+i+"("+values[i]+")";
				if(i!=values.length)
					rep += ",";
			}
			rep += "),timestamp("+getTimestamp()+"),accuracy("+getAccuracy()+"))";
			return rep;
	}

	@Override
	public int getAccuracy() {
		return accuracy;
	}

	@Override
	public long getTimestamp() {
		return timestamp;
	}

	@Override
	public String getJsonRep(){
			return (new Gson()).toJson(this);
	}

}
