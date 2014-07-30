This repository contains a model of Android sensors and Android sensor data that simplify the request and the usage of sensors in Android applications.
The useful features that this model introduces are:
	— the new sensor classes are not only observer of the real sensor but also observable
	— the onSensorChange() method updates transparently the SensorData and notifies this update to all observers
	— is introduced a SensorData model that contains all sensor data informations relative to the last update and provide a JSON and a Prolog representation
	— is defined an AndroidSensorFactory that returns a specific sensor and provides to registrate the Android Sensor to the SensorManager
	— is defined an SensorDataUtils class that rebuild the SensorData from a JSON string representation

Last update: 2014/07/30
