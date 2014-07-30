package it.unibo.android.aboutSensorEvents;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class AboutSensorEvents extends Activity {

	//fields definition
	private Spinner spinnerList;
	private SensorManager manager;
	private List<Sensor> sensors;
	private Sensor sensorSelected;
	private ArrayAdapter<String> adapter;
	private TextView textVersion;
	private TextView textVendor;
	private TextView textPower;
	private TextView textMaxRange;
	private TextView textResolution;
	private TextView textMinDelay;
	private SensorEventListener listener;
	private TextView textX;
	private TextView textY;
	private TextView textZ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//set the default layout
		setContentView(R.layout.activity_about_sensor_events);
		//initialize the resources
		initializeResources();
	}

	@Override
	protected void onResume() {
		super.onResume();
		manager.registerListener(listener, sensorSelected, SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	protected void onPause() {
		super.onPause();
		manager.unregisterListener(listener, sensorSelected);

	}

	private void initializeResources() {
		//obtain the SensorManager instance and get the sensors list
		manager = (SensorManager) getSystemService(SENSOR_SERVICE);
		sensors = manager.getSensorList(Sensor.TYPE_ALL);
		//get the TextView where put the sensor information
		textVersion = (TextView)findViewById(R.id.valueVersion);
		textVendor = (TextView)findViewById(R.id.valueVendor);
		textPower = (TextView)findViewById(R.id.valuePower);
		textMaxRange = (TextView)findViewById(R.id.valueMaxRange);
		textResolution = (TextView)findViewById(R.id.valueResolution);
		textMinDelay = (TextView)findViewById(R.id.valueMinDelay);
		//get the TextView where put sensor raw data received
		textX = (TextView)findViewById(R.id.ValueDataX);
		textY = (TextView)findViewById(R.id.ValueDataY);
		textZ = (TextView)findViewById(R.id.ValueDataZ);
		//get the spinner
		spinnerList = (Spinner)findViewById(R.id.spinner_sensors);
		//set up the spinner adapter with sensors names
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getSensorsNames());
		adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		spinnerList.setAdapter(adapter);
		//add the spinner listener
		addSpinnerListener();
	}
	
	private void updateSensorListener() {
		//if exist a selected element remove old listener
		if(listener!=null)
			manager.unregisterListener(listener, sensorSelected);
		//register new listener
		listener = new SensorEventsListener();
		manager.registerListener(listener, sensors.get(spinnerList.getSelectedItemPosition()), SensorManager.SENSOR_DELAY_NORMAL);
		
		//POJO observere with loop: DISASTER!
		
//		manager.registerListener(new SensorEventListener() {
//			
//			@Override
//			public void onSensorChanged(SensorEvent event) {
//				System.out.println("EventDetected");
//				while(true){
//					;
//				}
//			}
//			
//			@Override
//			public void onAccuracyChanged(Sensor sensor, int accuracy) {
//				// TODO Auto-generated method stub
//				
//			}
//		}, sensors.get(spinnerList.getSelectedItemPosition()), SensorManager.SENSOR_DELAY_NORMAL);
	}

	private void addSpinnerListener() {
		spinnerList.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				//when an item is selected update the text view 
				//with the selected sensor's informations
				Sensor s = sensors.get(position);
				if (s != sensorSelected){
					System.out.println(s.toString());
					textVersion.setText(""+s.getVersion());
					textVendor.setText(""+s.getVendor());
					textPower.setText(s.getPower()+" mA");
					textMaxRange.setText(""+s.getMaximumRange());
					textResolution.setText(""+s.getResolution());
					textMinDelay.setText(s.getMinDelay()/1000+" ms");
					updateSensorListener();
					sensorSelected = s;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				textVersion.setText("");
				textVendor.setText("");
			}
			
		});
	}

	private List<String> getSensorsNames() {
		//returns the list that contains the names of all available sensors
		List<String> sensorNames = new ArrayList<String>();
		for (Sensor s: sensors)
			sensorNames.add(s.getName());
		return sensorNames;
	}
	
	private class SensorEventsListener implements SensorEventListener {

		@Override
		public void onSensorChanged(SensorEvent event) {
			//show values
			textX.setText(""+event.values[0]);
			textY.setText(""+event.values[1]);
			textZ.setText(""+event.values[2]);
			if(event.sensor.getType() == Sensor.TYPE_SIGNIFICANT_MOTION){
				textX.setText(""+event.timestamp);
			}
		}

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			//do something when accuracy changes
		}

	}
	
}