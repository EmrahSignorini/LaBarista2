package com.example.labarista;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;

public class Table extends Activity {
	public int people;
	public boolean taken;
	EditText text;
	
	
	//public Table(int people) {
		//taken = false;
		//this.people = 0;
	//}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table);
		Parse.initialize(this, "21Kt4Bfjgl2Xxfa3nqm4LY74Etj1BVqI73mQCflt", "eEyWeokMchKUtVrEn6htK7V08ujFH67yGRCH1WBh");
		
		}

	public void takeTable(int people){
		this.people = people;
		taken = true;

	}
	
	public void leaveTable() {
		this.people = 0;
		taken = false;
	}
	
	public void finish(View view) {
		//save data on parse, end order
		Toast toast = Toast.makeText(this, "Ended", Toast.LENGTH_SHORT);
		toast.show();
		Intent mona = new Intent(this, MainActivity.class);
		startActivity(mona);
	}
	
	public void next(View view){
		//save actual data on parse and locally, renew page with empty fields
		Toast toast = Toast.makeText(this, "Next", Toast.LENGTH_SHORT);
		toast.show();
	}
	
	public void previous(View view) {

		//reacall data of previous order from (hashmap?arraylist?parse?)
		Toast toast = Toast.makeText(this, "Previous", Toast.LENGTH_SHORT);
		toast.show();
		Parse1 takeOrders = new Parse1();
		takeOrders.getStringArray("Orders", "Table", "Table 1" , "Drinks", this);

	}
	
	
	
	public void addString(String text){
		EditText textBox = (EditText) findViewById(R.id.editText1);
		textBox.setText(" "+text);
	}
	
	
	
	
}

