package com.example.labarista;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.Parse;

public class OccTable extends Activity {
	private String table;
	private ArrayList<String> array = new ArrayList<String>();
	private int total;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.occ_table);
		Bundle mona = getIntent().getExtras();
		String wela = mona.getString("Table");
		table = wela;
		Parse.initialize(this, "21Kt4Bfjgl2Xxfa3nqm4LY74Etj1BVqI73mQCflt", "eEyWeokMchKUtVrEn6htK7V08ujFH67yGRCH1WBh");
		if(getIntent().getStringArrayListExtra("Order")!= null){
			array = new ArrayList<String>(getIntent().getStringArrayListExtra("Order"));
			ListView listView1 = (ListView) findViewById(R.id.listView1);
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, array.toArray(new String[array.size()]));
			listView1.setAdapter(adapter);
			//getList();
			setTotal(getIntent().getStringExtra("Total"));
		}
		else{
			getList();
			setTextView();
			
		}
		
		
		
        
		}
	public void checkout(View view){
		final MediaPlayer mp = new MediaPlayer();

		if(mp.isPlaying()){
			mp.stop();
			mp.reset();
		} 
		try{

			AssetFileDescriptor afd;
			afd = getAssets().openFd("cash_register2.mp3");
			mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
			mp.prepare();
			mp.start();
		} 
		catch (IllegalStateException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	
		
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
	
	public void setTotal(String total){
		this.total = Integer.parseInt(total);
		TextView textView1 = (TextView) findViewById(R.id.textView1);
		textView1.setText("Total: " + total +" fr.");
		TextView textView2 = (TextView) findViewById(R.id.textView3);
		textView2.setText(table);
	}
	public void setTextView(){
		Parse1 par = new Parse1();
		par.getTotal(table, this);

	}
	
}
