package com.example.labarista;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.Parse;

public class MainActivity extends Activity {
	private ArrayList<String> test = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = 
			        new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			}
		Parse.initialize(this, "21Kt4Bfjgl2Xxfa3nqm4LY74Etj1BVqI73mQCflt", "eEyWeokMchKUtVrEn6htK7V08ujFH67yGRCH1WBh");
		updateTables();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void occupyTable(View view){
		//String redColor = "#cc3333"; 
		final String table = view.getContentDescription().toString();
		//view.setBackgroundColor(Color.parseColor(redColor));
		Parse1 isTableOccupied = new Parse1();
		isTableOccupied.SetBool("Tables", "Table", table, "Taken", false,this,null);

	}
	public void OccupiedTable(String table){
		Toast toast = Toast.makeText(this, "Table occupied", Toast.LENGTH_SHORT);
		toast.show();
		Intent next = new Intent(this, OccTable.class);
		next.putExtra("Table", table);
		startActivity(next);
	}
	
	public void empty(String table){

		Intent next = new Intent(this, WaitActivity.class);
		next.putStringArrayListExtra("TestA", test);
		next.putExtra("Table", table);
		startActivity(next);
	}
	
	
	public void updateTables(){
		//final String red = "#cc3333";
		//final String green = "#5ca028";
		final int puta1 = R.drawable.a_button2;
		final int puta2 = R.drawable.a_button3;
		Parse1 parseUpdate = new Parse1();
		Button a = (Button) findViewById(R.id.button1);
		Button b = (Button) findViewById(R.id.button2);
		Button c = (Button) findViewById(R.id.button3);
		Button d = (Button) findViewById(R.id.button4);
		Button e = (Button) findViewById(R.id.button5);
		Button f = (Button) findViewById(R.id.button6);
		final Button[] btnArray = {a,b,c,d,e,f};
		for(int i = 0; i < btnArray.length; i++){
			parseUpdate.setColorBtn("Tables","Table","Taken", true,puta2,puta1,this,btnArray[i]);
		}
		}
	
	public void refresh(View view){
		updateTables();
	} 
	public void SetColor(Button button,int color){
		button.setBackgroundResource(color);
		
	}

}