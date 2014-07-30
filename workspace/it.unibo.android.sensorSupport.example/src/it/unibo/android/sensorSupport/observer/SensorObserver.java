package it.unibo.android.sensorSupport.observer;

import java.util.Observable;

import it.unibo.android.sensorData.implementation.environmentSensors.AndroidLightData;
import it.unibo.android.sensorData.implementation.environmentSensors.AndroidTemperatureData;
import it.unibo.android.sensorData.implementation.motionSensors.AndroidAccelerometerData;
import it.unibo.android.sensorData.implementation.positionSensors.AndroidProximityData;
import it.unibo.android.sensorSupport.implementations.environmentSensors.AndroidAmbientTemperature;
import it.unibo.android.sensorSupport.implementations.environmentSensors.AndroidLight;
import it.unibo.android.sensorSupport.implementations.environmentSensors.AndroidTemperature;
import it.unibo.android.sensorSupport.implementations.motionSensors.AndroidAccelerometer;
import it.unibo.android.sensorSupport.implementations.positionSensors.AndroidProximity;
import it.unibo.is.interfaces.IObserver;
import it.unibo.is.interfaces.IOutputView;

public class SensorObserver implements IObserver {
	
	IOutputView view;
	
	public SensorObserver(IOutputView v){
		view = v;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof AndroidAccelerometer){
			AndroidAccelerometerData d = (AndroidAccelerometerData)arg1;
	    	view.setOutput(d.getJsonRep());
		}
		else if(arg0 instanceof AndroidProximity){
			AndroidProximityData d = (AndroidProximityData)arg1;
			view.setOutput(d.getJsonRep());
		}
		else if(arg0 instanceof AndroidLight){
			AndroidLightData d = (AndroidLightData)arg1;
			view.setOutput(d.getJsonRep());
	    	
		}
		else if((arg0 instanceof AndroidTemperature) || (arg0 instanceof AndroidAmbientTemperature)){
			AndroidTemperatureData d = (AndroidTemperatureData)arg1;
			view.setOutput(d.getJsonRep());
	    	
		}
	}
}
