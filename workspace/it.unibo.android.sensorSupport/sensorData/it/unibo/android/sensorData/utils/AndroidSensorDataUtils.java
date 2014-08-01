/**
 * @author Carlo Antenucci
 */
package it.unibo.android.sensorData.utils;

import it.unibo.android.sensorData.implementation.*;
import it.unibo.android.sensorData.implementation.motionSensors.*;
import it.unibo.android.sensorData.implementation.positionSensors.*;
import it.unibo.android.sensorData.implementation.environmentSensors.*;
import it.unibo.android.sensorData.interfaces.IAndroidSensorData;

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
		long timestamp = object.get("timestamp").getAsLong();
		int accuracy = object.get("accuracy").getAsInt();
		/*
		 * MOTION SENSORS
		 */
		if(name.equals("AndroidAccelerometerData")){
			return new AndroidAccelerometerData(obtainValues("ThreeAxis", object), 
					accuracy, timestamp);
		}
		if(name.equals("AndroidGravityData")){
			return new AndroidGravityData(obtainValues("ThreeAxis", object), 
					accuracy, timestamp);
		}
		if(name.equals("AndroidGyroscopeData")){
			return new AndroidGyroscopeData(obtainValues("ThreeAxis", object), 
					accuracy, timestamp);
		}
		if(name.equals("AndroidGyroscopeUncalibratedData")){
			return new AndroidGyroscopeUncalibratedData(
					obtainValues("ThreeAxisWithCorrection", object), 
					accuracy, timestamp);
		}
		if(name.equals("AndroidRotationVectorData")){
			return new AndroidMotionRotationVectorData(obtainValues("RotationVectorData", object), 
					accuracy, timestamp);
		}
		if(name.equals("AndroidDetectionSensorData")){
			return new AndroidDetectionSensorData(obtainValues("Detection", object), 
					accuracy, timestamp, object.get("detectionTime").getAsLong());
		}
		if(name.equals("AndroidStepCounterData")){
			return new AndroidStepCounterData(obtainValues("SingleValue", object), 
					accuracy, timestamp);
		}
		/*
		 * POSITION SENSORS
		 */
		if(name.equals("AndroidMagneticFieldData")){
			return new AndroidMagneticFieldData(obtainValues("ThreeAxis", object), 
					accuracy, timestamp);
		}
		if(name.equals("AndroidMagneticFieldUncalibratedData")){
			return new AndroidMagneticFieldUncalibratedData(
					obtainValues("ThreeAxisWithCorrection", object), 
					accuracy, timestamp);
		}
		if(name.equals("AndroidGeomagneticRotationVectorData")){
			return new AndroidGeomagneticRotationVectorData(obtainValues("ThreeAxis", object),
					accuracy, timestamp);
		}
		if(name.equals("AndroidGameRotationVectorData")){
			return new AndroidGameRotationVectorData(obtainValues("ThreeAxis", object),
					accuracy, timestamp);
		}
		if(name.equals("AndroidProximityData")){
			return new AndroidProximityData(obtainValues("SingleValue", object), 
					accuracy, timestamp);
		}
		//Only for retro-compatibility
		if(name.equals("AndroidOrientationData")){
			return new AndroidOrientationData(obtainValues("SingleValue", object), 
					accuracy, timestamp);
		}
		if(name.equals("AndroidTemperatureData")){
			return new AndroidTemperatureData(obtainValues("SingleValue", object), 
					accuracy, timestamp);
		}
		if(name.equals("AndroidLightData")){
			return new AndroidLightData(obtainValues("SingleValue", object), 
					accuracy, timestamp);
		}
		if(name.equals("AndroidPressureData")){
			return new AndroidPressureData(obtainValues("SingleValue", object),
					accuracy, timestamp);
		}
		if(name.equals("AndroidRelativeHumidityData")){
			return new AndroidRelativeHumidityData(obtainValues("SingleValue", object), 
					accuracy, timestamp);
		}
		return null;
	}

	private static float[] obtainValues(String type, JsonObject obj) {
		float [] values;
		switch(type){
			case "ThreeAxis":
				values = new float[3];
				values[0] = obj.get("x").getAsFloat();
				values[1] = obj.get("y").getAsFloat();
				values[2] = obj.get("z").getAsFloat();
				return values;
			case "RotationVectorData":
				values = new float[4];
				values[0] = obj.get("componentX").getAsFloat();
				values[1] = obj.get("componentY").getAsFloat();
				values[2] = obj.get("componentZ").getAsFloat();
				try{
					values[3] = obj.get("componentS").getAsFloat();
				}catch(Exception e){ System.out.println("componentS not exist");}
				return values;
			case "ThreeAxisWithCorrection":
				values = new float[6];
				values[0] = obj.get("x").getAsFloat();
				values[1] = obj.get("y").getAsFloat();
				values[2] = obj.get("z").getAsFloat();
				values[4] = obj.get("correctionX").getAsFloat();
				values[5] = obj.get("correctionY").getAsFloat();
				values[6] = obj.get("correctionZ").getAsFloat();
				return values;
			case "SingleValue":
				values = new float[1];
				values[0] = obj.get("value").getAsFloat();
				return values;
			default: return new float[3];
		}
	}
}