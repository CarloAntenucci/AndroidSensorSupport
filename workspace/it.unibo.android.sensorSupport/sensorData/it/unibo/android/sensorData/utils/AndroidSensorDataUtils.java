/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.utils;

import it.unibo.android.sensorData.implementation.*;
import it.unibo.android.sensorData.implementation.motionSensors.*;
import it.unibo.android.sensorData.implementation.positionSensors.*;
import it.unibo.android.sensorData.implementation.environmentSensors.*;
import it.unibo.android.sensorData.interfaces.IAndroidSensorData;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class AndroidSensorDataUtils {
	/**
	 * This class reconstruct an AndroidSensorData and returns an instance of
	 * specific AndroidSensorData subclasses.
	 * @param json string, received from the device
	 * @return an instance of a specific AndroidSensorData subclass
	 */
	public static IAndroidSensorData buildDataFromJson(String json){
		JsonParser parser = new JsonParser();
		JsonObject object = parser.parse(json).getAsJsonObject();
		String name = object.get("name").getAsString();
		JsonArray arr = object.get("values").getAsJsonArray();
		float [] values = new float[arr.size()];
		for (int i = 0; i < arr.size(); i++)
			values[i] = arr.get(i).getAsFloat();
		long timestamp = object.get("timestamp").getAsLong();
		int accuracy = object.get("accuracy").getAsInt();
		/*
		 * MOTION SENSORS
		 */
		if(name.equals("AndroidAccelerometerData")){
			return new AndroidAccelerometerData(values, accuracy, timestamp);
		}
		if(name.equals("AndroidLinearAccelerationData")){
			return new AndroidAccelerometerData(values, accuracy, timestamp);
		}
		if(name.equals("AndroidGravityData")){
			return new AndroidGravityData(values, accuracy, timestamp);
		}
		if(name.equals("AndroidGyroscopeData")){
			return new AndroidGyroscopeData(values, accuracy, timestamp);
		}
		if(name.equals("AndroidGyroscopeUncalibratedData")){
			return new AndroidGyroscopeUncalibratedData(values, accuracy, timestamp);
		}
		if(name.equals("AndroidRotationVectorData")){
			return new AndroidMotionRotationVectorData(values, accuracy, timestamp);
		}
		if(name.equals("AndroidDetectionSensorData")){
			return new AndroidDetectionSensorData(values, accuracy, timestamp, object.get("detectionTime").getAsLong());
		}
		if(name.equals("AndroidStepCounterData")){
			return new AndroidStepCounterData(values, accuracy, timestamp);
		}
		/*
		 * POSITION SENSORS
		 */
		if(name.equals("AndroidMagneticFieldData")){
			return new AndroidMagneticFieldData(values, accuracy, timestamp);
		}
		if(name.equals("AndroidMagneticFieldUncalibratedData")){
			return new AndroidMagneticFieldUncalibratedData(values, accuracy, timestamp);
		}
		if(name.equals("AndroidGeomagneticRotationVectorData")){
			return new AndroidGeomagneticRotationVectorData(values, accuracy, timestamp);
		}
		if(name.equals("AndroidGameRotationVectorData")){
			return new AndroidGameRotationVectorData(values, accuracy, timestamp);
		}
		if(name.equals("AndroidProximityData")){
			return new AndroidProximityData(values, accuracy, timestamp);
		}
		//Only for retro-compatibility
		if(name.equals("AndroidOrientationData")){
			return new AndroidOrientationData(values, accuracy, timestamp);
		}
		if(name.equals("AndroidTemperatureData")){
			return new AndroidTemperatureData(values, accuracy, timestamp);
		}
		if(name.equals("AndroidLightData")){
			return new AndroidLightData(values, accuracy, timestamp);
		}
		if(name.equals("AndroidPressureData")){
			return new AndroidPressureData(values, accuracy, timestamp);
		}
		if(name.equals("AndroidRelativeHumidityData")){
			return new AndroidRelativeHumidityData(values, accuracy, timestamp);
		}
		return null;
	}
	
}