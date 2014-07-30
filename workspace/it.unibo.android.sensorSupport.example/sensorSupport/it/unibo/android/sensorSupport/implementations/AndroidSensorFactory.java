package it.unibo.android.sensorSupport.implementations;

import it.unibo.android.sensorSupport.implementations.environmentSensors.AndroidAmbientTemperature;
import it.unibo.android.sensorSupport.implementations.environmentSensors.AndroidLight;
import it.unibo.android.sensorSupport.implementations.environmentSensors.AndroidPressure;
import it.unibo.android.sensorSupport.implementations.environmentSensors.AndroidRelativeHumidity;
import it.unibo.android.sensorSupport.implementations.environmentSensors.AndroidTemperature;
import it.unibo.android.sensorSupport.implementations.motionSensors.AndroidAccelerometer;
import it.unibo.android.sensorSupport.implementations.motionSensors.AndroidGravity;
import it.unibo.android.sensorSupport.implementations.motionSensors.AndroidGyroscope;
import it.unibo.android.sensorSupport.implementations.motionSensors.AndroidGyroscopeUncalibrated;
import it.unibo.android.sensorSupport.implementations.motionSensors.AndroidLinearAcceleration;
import it.unibo.android.sensorSupport.implementations.motionSensors.AndroidRotationVector;
import it.unibo.android.sensorSupport.implementations.motionSensors.AndroidSignificantMotion;
import it.unibo.android.sensorSupport.implementations.motionSensors.AndroidStepCounter;
import it.unibo.android.sensorSupport.implementations.motionSensors.AndroidStepDetector;
import it.unibo.android.sensorSupport.implementations.positionSensors.AndroidGameRotationVector;
import it.unibo.android.sensorSupport.implementations.positionSensors.AndroidGeomagneticRotationVector;
import it.unibo.android.sensorSupport.implementations.positionSensors.AndroidMagneticField;
import it.unibo.android.sensorSupport.implementations.positionSensors.AndroidMagneticFieldUncalibrated;
import it.unibo.android.sensorSupport.implementations.positionSensors.AndroidOrientation;
import it.unibo.android.sensorSupport.implementations.positionSensors.AndroidProximity;
import it.unibo.android.sensorSupport.interfaces.IAndroidSensor;
import it.unibo.android.sensorSupport.interfaces.environmentSensors.IAndroidLight;
import it.unibo.android.sensorSupport.interfaces.environmentSensors.IAndroidPressure;
import it.unibo.android.sensorSupport.interfaces.environmentSensors.IAndroidRelativeHumidity;
import it.unibo.android.sensorSupport.interfaces.environmentSensors.IAndroidTemperature;
import it.unibo.android.sensorSupport.interfaces.motionSensors.IAndroidAccelerometer;
import it.unibo.android.sensorSupport.interfaces.motionSensors.IAndroidDetectionSensor;
import it.unibo.android.sensorSupport.interfaces.motionSensors.IAndroidGravity;
import it.unibo.android.sensorSupport.interfaces.motionSensors.IAndroidGyroscope;
import it.unibo.android.sensorSupport.interfaces.motionSensors.IAndroidGyroscopeUncalibrated;
import it.unibo.android.sensorSupport.interfaces.motionSensors.IAndroidLinearAcceleration;
import it.unibo.android.sensorSupport.interfaces.motionSensors.IAndroidRotationVector;
import it.unibo.android.sensorSupport.interfaces.motionSensors.IAndroidStepCounter;
import it.unibo.android.sensorSupport.interfaces.positionSensors.IAndroidMagneticField;
import it.unibo.android.sensorSupport.interfaces.positionSensors.IAndroidMagneticFieldUncalibrated;
import it.unibo.android.sensorSupport.interfaces.positionSensors.IAndroidOrientation;
import it.unibo.android.sensorSupport.interfaces.positionSensors.IAndroidPositionRotationVector;
import it.unibo.android.sensorSupport.interfaces.positionSensors.IAndroidProximity;
import it.unibo.is.interfaces.IObserver;
import android.hardware.Sensor;
import android.hardware.SensorManager;

public class AndroidSensorFactory {
	/**
	 * This method return an instance of an AndroidSensor.
	 * 
	 * @param manager the sensor manager
	 * @param type the type of sensor you need
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_*
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidSensor
	 */
	public static IAndroidSensor getSensor(SensorManager manager, int type, int delay, IObserver observer){
		IAndroidSensor sensor = null;
		switch(type){
			
			/*
			 * MOTION SENSORS
			 */
		
			case Sensor.TYPE_ACCELEROMETER:
				sensor = AndroidAccelerometer.getInstance(manager, delay);
				break;
			case Sensor.TYPE_LINEAR_ACCELERATION:
				sensor = AndroidLinearAcceleration.getInstance(manager, delay);
				break;
			case Sensor.TYPE_GYROSCOPE:
				sensor = AndroidGyroscope.getInstance(manager, delay);
				break;
			case Sensor.TYPE_GYROSCOPE_UNCALIBRATED:
				sensor = AndroidGyroscopeUncalibrated.getInstance(manager, delay);
				break;
			case Sensor.TYPE_GRAVITY:
				sensor = AndroidGravity.getInstance(manager, delay);
				break;
			case Sensor.TYPE_ROTATION_VECTOR:
				sensor = AndroidRotationVector.getInstance(manager, delay);
				break;
			case Sensor.TYPE_SIGNIFICANT_MOTION:
				sensor = AndroidSignificantMotion.getInstance(manager, delay);
				break;
			case Sensor.TYPE_STEP_DETECTOR:
				sensor = AndroidStepDetector.getInstance(manager, delay);
				break;
			case Sensor.TYPE_STEP_COUNTER:
				sensor = AndroidStepCounter.getInstance(manager, delay);
				break;
				
			/*
			 * POSITION SENSORS	
			 */
				
			case Sensor.TYPE_MAGNETIC_FIELD:
				sensor = AndroidMagneticField.getInstance(manager, delay);
				break;
			case Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED:
				sensor = AndroidMagneticFieldUncalibrated.getInstance(manager, delay);
				break;
			case Sensor.TYPE_GAME_ROTATION_VECTOR:
				sensor = AndroidGameRotationVector.getInstance(manager, delay);
				break;
			case Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR:
				sensor = AndroidGeomagneticRotationVector.getInstance(manager, delay);
				break;
			case Sensor.TYPE_PROXIMITY:
				sensor = AndroidProximity.getInstance(manager, delay);
				break;
			//Only for retro-compatibility
			case Sensor.TYPE_ORIENTATION:
				sensor = AndroidOrientation.getInstance(manager, delay);
				break;
				
			/*
			 * ENVIRONMENT SENSORS
			 */
				
			case Sensor.TYPE_AMBIENT_TEMPERATURE:
				sensor = AndroidAmbientTemperature.getInstance(manager, delay);
				break;
			case Sensor.TYPE_LIGHT:
				sensor = AndroidLight.getInstance(manager, delay);
				break;
			case Sensor.TYPE_PRESSURE:
				sensor = AndroidPressure.getInstance(manager, delay);
				break;
			case Sensor.TYPE_RELATIVE_HUMIDITY:
				sensor = AndroidRelativeHumidity.getInstance(manager, delay);
				break;
			//Only for retro-compatibility
			case Sensor.TYPE_TEMPERATURE:
				sensor = AndroidTemperature.getInstance(manager, delay);
				break;
			default: return null;
		}
		if(sensor != null)
			sensor.addObserver(observer);
		return sensor;
	}
	
	/*
	 * 
	 * MOTION SENSORS
	 * 
	 */
	
	/**
	 * This method return an instance of an AndroidAccelerometer
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @return an instance of an AndroidAccelerometer
	 */
	public static IAndroidAccelerometer getAccelerometer(SensorManager manager, int delay){
		return AndroidAccelerometer.getInstance(manager, delay);
	}
	
	/**
	 * This method return an instance of an AndroidAccelerometer and registers to it the observer
	 * 
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidAccelerometer
	 */
	public static IAndroidAccelerometer getAccelerometer(SensorManager manager,
			int delay, IObserver observer) {
		IAndroidAccelerometer a = getAccelerometer(manager, delay);
		if (a != null) 
			a.addObserver(observer);
		return a;
	}

	/**
	 * This method return an instance of an AndroidLinearAcceleration
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @return an instance of an AndroidLinearAcceleration
	 */
	public static IAndroidLinearAcceleration getLinearAcceleration(SensorManager manager, int delay){
		return AndroidLinearAcceleration.getInstance(manager, delay);
	}

	/**
	 * This method return an instance of an AndroidLinearAcceleration and registers to it the observer
	 * 
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidLinearAcceleration
	 */
	public static IAndroidLinearAcceleration getLinearAcceleration(SensorManager manager,
			int delay, IObserver observer) {
		IAndroidLinearAcceleration a = getLinearAcceleration(manager, delay);
		if (a != null) 
			a.addObserver(observer);
		return a;
	}

	/**
	 * This method return an instance of an AndroidGyroscope
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @return an instance of an AndroidGyroscope
	 */
	public static IAndroidGyroscope getGyroscope(SensorManager manager, int delay){
		return AndroidGyroscope.getInstance(manager, delay);
	}

	/**
	 * This method return an instance of an AndroidGyroscope and registers to it the observer
	 * 
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidGyroscope
	 */
	public static IAndroidGyroscope getGyroscope(SensorManager manager,
			int delay, IObserver observer) {
		IAndroidGyroscope g = getGyroscope(manager, delay);
		if (g != null) 
			g.addObserver(observer);
		return g;
	}

	/**
	 * This method return an instance of an AndroidGyroscopeUncalibrated
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @return an instance of an AndroidGyroscopeUncalibrated
	 */
	public static IAndroidGyroscopeUncalibrated getGyroscopeUncalibrated(SensorManager manager, int delay){
		return AndroidGyroscopeUncalibrated.getInstance(manager, delay);
	}

	/**
	 * This method return an instance of an AndroidGyroscopeUncalibrated and registers to it the observer
	 * 
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidGyroscopeUncalibrated
	 */
	public static IAndroidGyroscopeUncalibrated getGyroscopeUncalibrated(SensorManager manager,
			int delay, IObserver observer) {
		IAndroidGyroscopeUncalibrated g = getGyroscopeUncalibrated(manager, delay);
		if (g != null) 
			g.addObserver(observer);
		return g;
	}

	/**
	 * This method return an instance of an AndroidGravity
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @return an instance of an AndroidGravity
	 */
	public static IAndroidGravity getGravity(SensorManager manager, int delay){
		return AndroidGravity.getInstance(manager, delay);
	}

	/**
	 * This method return an instance of an AndroidGravity and registers to it the observer
	 * 
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidGravity
	 */
	public static IAndroidGravity getGravity(SensorManager manager,
			int delay, IObserver observer) {
		IAndroidGravity g = getGravity(manager, delay);
		if (g != null) 
			g.addObserver(observer);
		return g;
	}
	
	/**
	 * This method return an instance of an AndroidRotationVector
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @return an instance of an AndroidRotationVector
	 */
	public static IAndroidRotationVector getRotationVector(SensorManager manager, int delay){
		return AndroidRotationVector.getInstance(manager, delay);
	}

	/**
	 * This method return an instance of an AndroidRotationVector and registers to it the observer
	 * 
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidRotationVector
	 */
	public static IAndroidRotationVector getRotationVector(SensorManager manager,
			int delay, IObserver observer) {
		IAndroidRotationVector r = getRotationVector(manager, delay);
		if (r != null) 
			r.addObserver(observer);
		return r;
	}
	
	/**
	 * This method return an instance of an AndroidStepDetector
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @return an instance of an AndroidStepDetector
	 */
	public static IAndroidDetectionSensor getStepDetector(SensorManager manager, int delay){
		return AndroidStepDetector.getInstance(manager, delay);
	}

	/**
	 * This method return an instance of an AndroidStepDetector and registers to it the observer
	 * 
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidStepDetector
	 */
	public static IAndroidDetectionSensor getStepDetector(SensorManager manager,
			int delay, IObserver observer) {
		IAndroidDetectionSensor s = getStepDetector(manager, delay);
		if (s != null) 
			s.addObserver(observer);
		return s;
	}
	
	/**
	 * This method return an instance of an AndroidSignificantMotion
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @return an instance of an AndroidSignificantMotion
	 */
	public static IAndroidDetectionSensor getSignificantMotion(SensorManager manager, int delay){
		return AndroidSignificantMotion.getInstance(manager, delay);
	}

	/**
	 * This method return an instance of an AndroidSignificantMotion and registers to it the observer
	 * 
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidSignificantMotion
	 */
	public static IAndroidDetectionSensor getSignificantMotion(SensorManager manager,
			int delay, IObserver observer) {
		IAndroidDetectionSensor s = getSignificantMotion(manager, delay);
		if (s != null) 
			s.addObserver(observer);
		return s;
	}

	/**
	 * This method return an instance of an AndroidStepCounter
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @return an instance of an AndroidStepCounter
	 */
	public static IAndroidStepCounter getStepCounter(SensorManager manager, int delay){
		return AndroidStepCounter.getInstance(manager, delay);
	}

	/**
	 * This method return an instance of an AndroidStepCounter and registers to it the observer
	 * 
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidStepCounter
	 */
	public static IAndroidStepCounter getStepCounter(SensorManager manager,
			int delay, IObserver observer) {
		IAndroidStepCounter s = getStepCounter(manager, delay);
		if (s != null) 
			s.addObserver(observer);
		return s;
	}
	
	/*
	 *
	 * POSITION SENSORS
	 * 
	 */
	
	/**
	 * This method return an instance of an AndroidProximity
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @return an instance of an AndroidProximity
	 */
	public static IAndroidProximity getProximity(SensorManager manager, int delay){
		return AndroidProximity.getInstance(manager, delay);
	}
	
	/**
	 * This method return an instance of an AndroidProximity and registers to it the observer
	 * 
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidProximity
	 */
	public static IAndroidProximity getProximity(SensorManager manager,
			int delay, IObserver observer) {
		IAndroidProximity p = getProximity(manager, delay);
		if (p != null) 
			p.addObserver(observer);
		return p;
	}

	/**
	 * This method return an instance of an AndroidMagneticField
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @return an instance of an AndroidMagneticField
	 */
	public static IAndroidMagneticField getMagnetometer(SensorManager manager, int delay){
		return AndroidMagneticField.getInstance(manager, delay);
	}

	/**
	 * This method return an instance of an AndroidMagneticField and registers to it the observer
	 * 
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidMagneticField
	 */
	public static IAndroidMagneticField getMagnetometer(SensorManager manager,
			int delay, IObserver observer) {
		IAndroidMagneticField m = getMagnetometer(manager, delay);
		if (m != null) 
			m.addObserver(observer);
		return m;
	}

	/**
	 * This method return an instance of an AndroidMagneticFieldUncalibrated
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @return an instance of an AndroidMagneticFieldUncalibrated
	 */
	public static IAndroidMagneticFieldUncalibrated getMagneticFieldUncalibrated(SensorManager manager, int delay){
		return AndroidMagneticFieldUncalibrated.getInstance(manager, delay);
	}

	/**
	 * This method return an instance of an AndroidMagneticFieldUncalibrated and registers to it the observer
	 * 
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidMagneticFieldUncalibrated
	 */
	public static IAndroidMagneticFieldUncalibrated getMagneticFieldUncalibrated(SensorManager manager,
			int delay, IObserver observer) {
		IAndroidMagneticFieldUncalibrated m = getMagneticFieldUncalibrated(manager, delay);
		if (m != null) 
			m.addObserver(observer);
		return m;
	}

	/**
	 * This method return an instance of an AndroidGameRotationVector
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @return an instance of an AndroidGameRotationVector
	 */
	public static IAndroidPositionRotationVector getGameRotationVector(SensorManager manager, int delay){
		return AndroidGameRotationVector.getInstance(manager, delay);
	}

	/**
	 * This method return an instance of an AndroidGameRotationVector and registers to it the observer
	 * 
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidGameRotationVector
	 */
	public static IAndroidPositionRotationVector getGameRotationVector(SensorManager manager,
			int delay, IObserver observer) {
		IAndroidPositionRotationVector g = getGameRotationVector(manager, delay);
		if (g != null) 
			g.addObserver(observer);
		return g;
	}
	
	/**
	 * This method return an instance of an AndroidGeomagneticRotationVector
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @return an instance of an AndroidGeomagneticRotationVector
	 */
	public static IAndroidPositionRotationVector getGeomagneticRotationVector(SensorManager manager, int delay){
		return AndroidGeomagneticRotationVector.getInstance(manager, delay);
	}

	/**
	 * This method return an instance of an AndroidGeomagneticRotationVector and registers to it the observer
	 * 
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidGeomagneticRotationVector
	 */
	public static IAndroidPositionRotationVector getGeomagneticRotationVector(SensorManager manager,
			int delay, IObserver observer) {
		IAndroidPositionRotationVector g = getGeomagneticRotationVector(manager, delay);
		if (g != null) 
			g.addObserver(observer);
		return g;
	}
	
	@Deprecated
	/**
	 * This method is deprecated. Is defined only for retro-compatibility.
	 * It return an instance of an AndroidOrientation
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @return an instance of an AndroidOrientation
	 */
	public static IAndroidOrientation getOrientation(SensorManager manager, int delay){
		return AndroidOrientation.getInstance(manager, delay);
	}

	@Deprecated
	/**
	 * This method is deprecated. Is defined only for retro-compatibility. 
	 * It return an instance of an AndroidOrientation and registers to it the observer
	 * 
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidOrientation
	 */
	public static IAndroidOrientation getOrientation(SensorManager manager,
			int delay, IObserver observer) {
		IAndroidOrientation o = getOrientation(manager, delay);
		if (o != null) 
			o.addObserver(observer);
		return o;
	}
	
	/*
	 * 
	 * ENVIRONMENT SENSORS
	 * 
	 */
	
	/**
	 * This method return an instance of an AndroidAmbientTemperature
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @return an instance of an AndroidAmbientTemperature
	 */
	public static IAndroidTemperature getAmbientTemperatureSensor(SensorManager manager, int delay){
		return AndroidAmbientTemperature.getInstance(manager, delay);
	}

	/**
	 * This method return an instance of an AndroidAmbientTemperature and registers to it the observer
	 * 
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidAmbientTemperature
	 */
	public static IAndroidTemperature getAmbientTemperatureSensor(SensorManager manager,
			int delay, IObserver observer) {
		IAndroidTemperature t = getAmbientTemperatureSensor(manager, delay);
		if (t != null) 
			t.addObserver(observer);
		return t;
	}
	
	/**
	 * This method return an instance of an AndroidLight
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @return an instance of an AndroidLight
	 */
	public static IAndroidLight getLightSensor(SensorManager manager, int delay){
		return AndroidLight.getInstance(manager, delay);
	}

	/**
	 * This method return an instance of an AndroidLight and registers to it the observer
	 * 
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidLight
	 */
	public static IAndroidLight getLightSensor(SensorManager manager,
			int delay, IObserver observer) {
		IAndroidLight l = getLightSensor(manager, delay);
		if (l != null) 
			l.addObserver(observer);
		return l;
	}
	
	/**
	 * This method return an instance of an AndroidPressure
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @return an instance of an AndroidPressure
	 */
	public static IAndroidPressure getPressureSensor(SensorManager manager, int delay){
		return AndroidPressure.getInstance(manager, delay);
	}

	/**
	 * This method return an instance of an AndroidPressure and registers to it the observer
	 * 
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidPressure
	 */
	public static IAndroidPressure getPressureSensor(SensorManager manager,
			int delay, IObserver observer) {
		IAndroidPressure p = getPressureSensor(manager, delay);
		if (p != null) 
			p.addObserver(observer);
		return p;
	}	
	
	/**
	 * This method return an instance of an AndroidRelativeHumidity
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @return an instance of an AndroidRelativeHumidity
	 */
	public static IAndroidRelativeHumidity getRelativeHumiditySensor(SensorManager manager, int delay){
		return AndroidRelativeHumidity.getInstance(manager, delay);
	}

	/**
	 * This method return an instance of an AndroidRelativeHumidity and registers to it the observer
	 * 
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidRelativeHumidity
	 */
	public static IAndroidRelativeHumidity getRelativeHumiditySensor(SensorManager manager,
			int delay, IObserver observer) {
		IAndroidRelativeHumidity h = getRelativeHumiditySensor(manager, delay);
		if (h != null) 
			h.addObserver(observer);
		return h;
	}
	
	@Deprecated
	/**
	 * This method is deprecated. Is defined only for retro-compatibility.
	 * It return an instance of an AndroidOrientation
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @return an instance of an AndroidTemperature
	 */
	public static IAndroidTemperature getTemperature(SensorManager manager, int delay){
		return AndroidTemperature.getInstance(manager, delay);
	}

	@Deprecated
	/**
	 * This method is deprecated. Is defined only for retro-compatibility. 
	 * It return an instance of an AndroidOrientation and registers to it the observer
	 * 
	 * @param manager the sensor manager
	 * @param delay the sensor delay that you can choose from SensorManager.SENSOR_DELAY_* 
	 * @param observer the observer of the sensor
	 * 
	 * @return an instance of an AndroidTemperature
	 */
	public static IAndroidTemperature getTemperature(SensorManager manager,
			int delay, IObserver observer) {
		IAndroidTemperature t = getTemperature(manager, delay);
		if (t != null) 
			t.addObserver(observer);
		return t;
	}
}
