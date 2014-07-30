package it.unibo.android.sensorData.implementation;

import java.util.Observable;

import it.unibo.android.sensorData.interfaces.IAndroidSensorData;
import it.unibo.is.interfaces.IObserver;

import com.google.gson.Gson;

public class AndroidSensorData extends Observable implements IAndroidSensorData{
	
	private String name;
	private float[] values;
	private long timestamp;
	private int accuracy;
	private boolean init;
	
	
	public AndroidSensorData(){
		this.init = false;
	}
	
	public AndroidSensorData(float[] values, int accuracy, long timestamp){
		this.name = this.getClass().getSimpleName();
		this.values = values;
		this.accuracy = accuracy;
		this.timestamp = timestamp;
		this.init = true;
	}

	@Override
	public String getName() {
		if(initialized())
			return name;
		else
			return "Not yet initialized";
	}

	@Override
	public float[] getValues() {
		return values;
	}

	@Override
	public String getPrologRep() {
		if(initialized()){
			String rep = getName()+"(values(";
			for(int i=0;i<values.length;i++){
				rep += "v"+i+"("+values[i]+")";
				if(i!=values.length)
					rep += ",";
			}
			rep += "),timestamp("+getTimestamp()+"),accuracy("+getAccuracy()+"))";
			return rep;
		}
		else
			return "Not yet initialized";
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
		if(initialized())
			return (new Gson()).toJson(this);
		else
			return null;
	}

	@Override
	public void addObserver(IObserver observer) {
		if(initialized())
			super.addObserver(observer);
	}

	protected boolean initialized() {
		return init;
	}
}
