<h1 align="center">AndroidSensorSupport</h1>
AndroidSensorSupport provides a model for sensors and sensor data that makes easier sensors request and data usage in Android applications.

The model has been developed as project activity related to the <a href="http://www-natali.deis.unibo.it">Engineering of Software Systems</a> course at University of Bologna.

The useful features that this model introduces are: 
* the new sensor classes are not only observer of the real sensor but also observable
* the onSensorChange() method updates transparently the SensorData and notifies this update to all observers
* is also introduced a SensorData model that contains all sensor data informations relative to the last update and provide a JSON and a Prolog representation
* is defined an AndroidSensorFactory that returns a specific sensor and provides to registrate the AndroidSensor to the SensorManager
* is defined an SensorDataUtils class that rebuild the SensorData from a JSON string representation

Last update: 2014/07/30

For more informations, proposals, extensions, corrections and, obviously, bug please contact me at
<a href="mailto://carlo.antenucci@gmail.com">carlo.antenucci@gmail.com</a> or <a href="mailto://carlo.antenucci@studio.unibo.it">carlo.antenucci@studio.unibo.it</a> 
