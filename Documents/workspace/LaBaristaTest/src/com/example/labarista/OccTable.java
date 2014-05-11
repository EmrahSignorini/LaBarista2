package com.example.labarista;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.Parse;

public class OccTable extends Activity {
	private String table;
	private ArrayList<String> array = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.occ_table);
		Bundle mona = getIntent().getExtras();
		String wela = mona.getString("Table");
		table = wela;
		Parse.initialize(this, "21Kt4Bfjgl2Xxfa3nqm4LY74Etj1BVqI73mQCflt", "eEyWeokMchKUtVrEn6htK7V08ujFH67yGRCH1WBh");
		getList();
		
        
		}
	public void checkout(View view){
		Toast toast = Toast.makeText(this, "Done", Toast.LENGTH_SHORT);
		toast.show();
		Parse1 Checkout = new Parse1();
		Checkout.findSaveBool("Tables","Table", table, "Taken", false, this);	
		Checkout.deleteAllOrders("Orders", "Table", table, this);
	}
	public void back(String table, boolean what){
		Intent next = new Intent(OccTable.this, MainActivity.class);
		next.putExtra("Table", table);
		next.putExtra("Free", what);
		startActivity(next);
	}
	public void back1(View view){
		Intent next = new Intent(OccTable.this, MainActivity.class);
		startActivity(next);
	}
	
	public void getList(){
		Parse1 par = new Parse1();
		par.getOrder("Orders", "Table", table, "Drinks", this);
		par.getOrder("Orders", "Table", table, "Appetizers", this);
		par.getOrder("Orders", "Table", table, "Seconds", this);
		par.getOrder("Orders", "Table", table, "Desserts", this);
		par.getOrder("Orders", "Table", table, "Firsts", this);
	}
	
	public void setYolo(String value){
		String[] arr = value.split("-");
		for (int i=0; i<arr.length-1;i++){
			array.add(arr[i]);
		}

		ListView listView1 = (ListView) findViewById(R.id.listView1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, array.toArray(new String[array.size()]));
		listView1.setAdapter(adapter);

	}
	

	public void changeOrder(View view){
		Intent next = new Intent(OccTable.this, WaitActivity.class);
		next.putExtra("Table", getIntent().getExtras().getString("Table"));
		next.putStringArrayListExtra("Order", array);
		startActivity(next);
		
	}
	
}
