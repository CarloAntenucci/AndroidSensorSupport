/**
 * @author Carlo Antenucci
 */

package it.unibo.android.sensorSupport.example;


import it.unibo.android.sensorData.interfaces.IAndroidSensorData;
import it.unibo.android.sensorData.utils.AndroidSensorDataUtils;
import it.unibo.android.sensorSupport.example.R;
import android.app.Activity;
import android.widget.TextView;


public class GuiActivity extends Activity{
	//text views for sensor names
	private TextView[] textSensors = new TextView[4];
	//text views for data: [sensor][x,y,z]
	private TextView[][] textData = new TextView[4][3];
	//text view for json representation
	private TextView textJSON;



	@Override
	protected void onStart() {
		super.onStart();
		setContentView(R.layout.sensorsupport_example);
		//obtain views' references
		textSensors[0] = (TextView)findViewById(R.id.sen1);
		textSensors[1] = (TextView)findViewById(R.id.sen2);
		textSensors[2] = (TextView)findViewById(R.id.sen3);
		textSensors[3] = (TextView)findViewById(R.id.sen4);
		textData[0][0] = (TextView)findViewById(R.id.s1x);
		textData[0][1] = (TextView)findViewById(R.id.s1y);
		textData[0][2] = (TextView)findViewById(R.id.s1z);
		textData[1][0] = (TextView)findViewById(R.id.s2x);
		textData[1][1] = (TextView)findViewById(R.id.s2y);
		textData[1][2] = (TextView)findViewById(R.id.s2z);
		textData[2][0] = (TextView)findViewById(R.id.s3x);
		textData[2][1] = (TextView)findViewById(R.id.s3y);
		textData[2][2] = (TextView)findViewById(R.id.s3z);
		textData[3][0] = (TextView)findViewById(R.id.s4x);
		textData[3][1] = (TextView)findViewById(R.id.s4y);
		textData[3][2] = (TextView)findViewById(R.id.s4z);
		textJSON = (TextView)findViewById(R.id.other);
		//obtain sensor manager
	}

	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}


	protected void initGui(String[] names) {
		for(int i=0; i < names.length; i++){
			if(names[i]!=null)
				textSensors[i].setText(names[i]);
			else{
				textSensors[i].setText("sensor_"+i);
				textData[i][0].setText("not");
				textData[i][1].setText("present");
			}
		}
	}

	public void setJSONRep(String msg) {
		textJSON.setText(msg);
	}

	public void setData(String msg) {
		//		textOther.setText(msg);
		IAndroidSensorData d = AndroidSensorDataUtils.buildDataFromJson(msg);
		float values[] = d.giveMeValues();
		for(int i = 0; i < 4; i++){
			if(d.getName().contains(textSensors[i].getText())){
				for(int j = 0; j < values.length; j++)
					textData[i][j].setText(""+d.giveMeValues()[j]);
				return;
			}
		}
	}
}