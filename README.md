This repository contains a model of Android sensors and Android sensor data that simplify the request and the usage of sensors in Android applications. <br><br>
The useful features that this model introduces are: <br>
	— the new sensor classes are not only observer of the real sensor but also observable<br>
	— the onSensorChange() method updates transparently the SensorData and notifies this update to all observers<br>
	— is introduced a SensorData model that contains all sensor data informations relative to the last update and provide a JSON and a Prolog representation<br>
	— is defined an AndroidSensorFactory that returns a specific sensor and provides to registrate the Android Sensor to the SensorManager<br>
	— is defined an SensorDataUtils class that rebuild the SensorData from a JSON string representation<br>
<br>
Last update: 2014/07/30
