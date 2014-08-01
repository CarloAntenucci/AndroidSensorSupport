package it.unibo.android.sensorSupport.implementations;

import it.unibo.android.sensorSupport.interfaces.IAndroidSensor;
import it.unibo.is.interfaces.IObserver;

import java.util.Observable;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import it.unibo.android.sensorData.implementation.AndroidSensorData;
import it.unibo.android.sensorData.interfaces.IAndroidSensorData;

public abstract class AndroidSensor extends Observable implements IAndroidSensor {
	
	protected static IAndroidSensorData sensorData;
	protected SensorManager myManager;
	
	public AndroidSensor(SensorManager manager){
		myManager = manager;
	}
	
	@Override
	/**
	 * @inheritDoc
	 * 
	 * This implementation realize the update of sensorData when the new measurement is notified to this listener
	 */
	public void onSensorChanged(SensorEvent event) {
		sensorData = new AndroidSensorData(event.values, event.accuracy, event.timestamp);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	@Override
	/**
	 * When this method is called a notification is sent to all observers
	 */
	public void update(Observable arg0, Object arg1) {
		this.setChanged();
		this.notifyObservers( arg1 );
	}

	@Override
	public void addObserver(IObserver arg0) {
		super.addObserver(arg0);
	}

	@Override
	public void unregister(){
		this.deleteObservers();
		myManager.unregisterListener(this);
	}
	
	@Override
	public IAndroidSensorData getData(){
		return sensorData;
	}
	
}
