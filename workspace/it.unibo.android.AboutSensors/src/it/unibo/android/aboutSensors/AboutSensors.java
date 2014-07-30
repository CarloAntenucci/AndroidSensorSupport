package it.unibo.android.aboutSensors;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class AboutSensors extends Activity {

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//set the default layout
		setContentView(R.layout.activity_about_sensors);
		//initialize the resources
		initializeResources();
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
		//get the spinner
		spinnerList = (Spinner)findViewById(R.id.spinner_sensors);
		//set up the spinner adapter with sensors names
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getSensorsNames());
		adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		spinnerList.setAdapter(adapter);
		//add the spinner listener
		addSpinnerListener();
			
	}

	private void addSpinnerListener() {
		spinnerList.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				//when an item is selected update the text view 
				//with the selected sensor's informations
				Sensor s = sensors.get(position);
				if(s != sensorSelected){
					System.out.println(s.toString());
					textVersion.setText(""+s.getVersion());
					textVendor.setText(""+s.getVendor());
					textPower.setText(s.getPower()+" mA");
					textMaxRange.setText(""+s.getMaximumRange());
					textResolution.setText(""+s.getResolution());
					textMinDelay.setText(s.getMinDelay()/1000+" ms");
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
	
}