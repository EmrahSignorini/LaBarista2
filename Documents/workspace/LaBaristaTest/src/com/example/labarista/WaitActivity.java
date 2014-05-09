package com.example.labarista;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;

import com.parse.Parse;

public class WaitActivity extends Activity {
	private ArrayList<String> tavolo1 = new ArrayList<String>();
	private ListAdapter adapter = null;
	private ListView card = null;
	private PopupMenu popup;
	private PopupMenu popup2;
	private int pos;
	private String Drinks = "";
	private String Appetizers= "";
	private String Seconds = "";
	private String Firsts = "";
	private String Desserts = "";
	private final Parse1 Test = new Parse1();
	private int Total = 0;
	private HashMap<String,Integer> test = new HashMap<String,Integer>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order);
		Parse.initialize(this, "21Kt4Bfjgl2Xxfa3nqm4LY74Etj1BVqI73mQCflt", "eEyWeokMchKUtVrEn6htK7V08ujFH67yGRCH1WBh");
		if (getIntent().getStringArrayListExtra("Order")!= null){
			tavolo1 = new ArrayList<String>(getIntent().getStringArrayListExtra("Order"));
			card = (ListView)findViewById(R.id.listView1);
			card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
		}
		else{
			tavolo1 = new ArrayList<String>();
			tavolo1.add("Test");
			card = (ListView)findViewById(R.id.listView1);
			card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wait, menu);
		return true;
	}


	public void ordine(View view) {
		test.put("Drinks",0);
		test.put("Appetizers",0);
		test.put("Firsts",0);
		test.put("Seconds",0);
		test.put("Desserts",0);
		card = (ListView)findViewById(R.id.listView1);
		popup = new PopupMenu(this, view);
		popup2 = new PopupMenu(this, view);
		desserts(view);
		getMenuInflater().inflate(R.menu.comanda, popup2.getMenu());
		Test(card);
		}
	
	public void ordine1(View view) {
		test.put("Drinks",0);
		test.put("Appetizers",0);
		test.put("Firsts",0);
		test.put("Seconds",0);
		test.put("Desserts",0);
		card = (ListView)findViewById(R.id.listView1);
		popup = new PopupMenu(this, view);
		popup2 = new PopupMenu(this, view);
		entrances(view);
		getMenuInflater().inflate(R.menu.comanda, popup2.getMenu());
		Test(card);
		}
	public void ordine2(View view) {
		test.put("Drinks",0);
		test.put("Appetizers",0);
		test.put("Firsts",0);
		test.put("Seconds",0);
		test.put("Desserts",0);
		card = (ListView)findViewById(R.id.listView1);
		popup = new PopupMenu(this, view);
		popup2 = new PopupMenu(this, view);
		first(view);
		getMenuInflater().inflate(R.menu.comanda, popup2.getMenu());
		Test(card);
		}
	public void ordine3(View view) {
		test.put("Drinks",0);
		test.put("Appetizers",0);
		test.put("Firsts",0);
		test.put("Seconds",0);
		test.put("Desserts",0);
		card = (ListView)findViewById(R.id.listView1);
		popup = new PopupMenu(this, view);
		popup2 = new PopupMenu(this, view);
		drinks(view);
		getMenuInflater().inflate(R.menu.comanda, popup2.getMenu());
		Test(card);
		}
	public void ordine4(View view) {
		test.put("Drinks",0);
		test.put("Appetizers",0);
		test.put("Firsts",0);
		test.put("Seconds",0);
		test.put("Desserts",0);
		card = (ListView)findViewById(R.id.listView1);
		popup = new PopupMenu(this, view);
		popup2 = new PopupMenu(this, view);
		seconds(view);
		getMenuInflater().inflate(R.menu.comanda, popup2.getMenu());
		Test(card);
		}
	
	
	public void drinks(View view) {
		getMenuInflater().inflate(R.menu.bevande, popup.getMenu());
		popup.show();
		popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
				switch(item.getItemId()){
				default:
					break;
				case R.id.Heineken:
					getValueDrinks(item.getTitle().toString(),true);;
					Drinks += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.FeldSchlossen:
					getValueDrinks(item.getTitle().toString(),true);;
					Drinks += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Corona:
					getValueDrinks(item.getTitle().toString(),true);;
					Drinks += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Cardinal:
					getValueDrinks(item.getTitle().toString(),true);;
					Drinks += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Coca_Cola:
					getValueDrinks(item.getTitle().toString(),true);;
					Drinks += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Fanta:
					getValueDrinks(item.getTitle().toString(),true);;
					Drinks += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Water:
					getValueDrinks(item.getTitle().toString(),true);;
					Drinks += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Dr_Pepper:
					getValueDrinks(item.getTitle().toString(),true);;
					Drinks += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.SOTB:
					getValueDrinks(item.getTitle().toString(),true);;
					Drinks += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Mojito:
					getValueDrinks(item.getTitle().toString(),true);;
					Drinks += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.VRB:
					getValueDrinks(item.getTitle().toString(),true);;
					Drinks += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.JaegerBomb:
					getValueDrinks(item.getTitle().toString(),true);;
					Drinks += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Done:
					Desserts = Desserts + Total;
					Firsts = Firsts + Total;
					Seconds = Seconds + Total;
					Appetizers = Appetizers + Total;
					Drinks = Drinks + Total;
					Back();
					break;
				}
				
			    return true;
			}
		});
		popup = new PopupMenu(this, view);

	}
	public void entrances(View view) {
		getMenuInflater().inflate(R.menu.antipasti, popup.getMenu());
		popup.show();
		popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
				switch(item.getItemId()){
				default:
					break;
				case R.id.Consomme:
					getValueAppetizers(item.getTitle().toString(),true);;
					Appetizers += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Minestrone:
					getValueAppetizers(item.getTitle().toString(),true);;
					Appetizers += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Onions:
					getValueAppetizers(item.getTitle().toString(),true);;
					Appetizers += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Pumpkin:
					getValueAppetizers(item.getTitle().toString(),true);;
					Appetizers += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Mix:
					getValueAppetizers(item.getTitle().toString(),true);;
					Appetizers += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Ham:
					getValueAppetizers(item.getTitle().toString(),true);;
					Appetizers += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Salami:
					getValueAppetizers(item.getTitle().toString(),true);;
					Appetizers += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Cheese:
					getValueAppetizers(item.getTitle().toString(),true);;
					Appetizers += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Escargots:
					getValueAppetizers(item.getTitle().toString(),true);;
					Appetizers += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Bruschetta:
					getValueAppetizers(item.getTitle().toString(),true);;
					Appetizers += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Shrimps_Cocktail:
					getValueAppetizers(item.getTitle().toString(),true);;
					Appetizers += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Done:
					Desserts = Desserts + Total;
					Firsts = Firsts + Total;
					Seconds = Seconds + Total;
					Appetizers = Appetizers + Total;
					Drinks = Drinks + Total;
					Back();
					break;
				}
				
			    return true;
			}
		});
		popup = new PopupMenu(this, view);
	}
	public void seconds(View view) {
		getMenuInflater().inflate(R.menu.secondi, popup.getMenu());
		popup.show();
		popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
				switch(item.getItemId()){
				default:
					break;
				case R.id.Margherita:
					getValueSeconds(item.getTitle().toString(),true);;
					Seconds += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Marinara:
					getValueSeconds(item.getTitle().toString(),true);;
					Seconds += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Prosciutto_Funghi:
					getValueSeconds(item.getTitle().toString(),true);;
					Seconds += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Quattro_Formaggi:
					getValueSeconds(item.getTitle().toString(),true);;
					Seconds += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Bianca:
					getValueSeconds(item.getTitle().toString(),true);;
					Seconds += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Calzone:
					getValueSeconds(item.getTitle().toString(),true);;
					Seconds += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Prosciutto:
					getValueSeconds(item.getTitle().toString(),true);;
					Seconds += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Filet:
					getValueSeconds(item.getTitle().toString(),true);;
					Seconds += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.EntreCote:
					getValueSeconds(item.getTitle().toString(),true);;
					Seconds += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Steak:
					getValueSeconds(item.getTitle().toString(),true);;
					Seconds += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Cordon_Bleu:
					getValueSeconds(item.getTitle().toString(),true);;
					Seconds += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Horse:
					getValueSeconds(item.getTitle().toString(),true);;
					Seconds += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Shrimps_Curry:
					getValueSeconds(item.getTitle().toString(),true);;
					Seconds += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Royal_Shrimps:
					getValueSeconds(item.getTitle().toString(),true);;
					Seconds += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Giant_Shrimps:
					getValueSeconds(item.getTitle().toString(),true);;
					Seconds += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Huge_Shrimps:
					getValueSeconds(item.getTitle().toString(),true);;
					Seconds += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Titan_Shrimps:
					getValueSeconds(item.getTitle().toString(),true);;
					Seconds += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Done:
					Desserts = Desserts + Total;
					Firsts = Firsts + Total;
					Seconds = Seconds + Total;
					Appetizers = Appetizers + Total;
					Drinks = Drinks + Total;
					Back();
					break;
				}
				
			    return true;
			}
		});
		popup = new PopupMenu(this, view);
	}
	public void first(View view) {
		
		getMenuInflater().inflate(R.menu.primi, popup.getMenu());
		popup.show();
		popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
				switch(item.getItemId()){
				default:
					break;
				case R.id.Carbonara:
					getValueFirsts(item.getTitle().toString(),true);;
					Firsts += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Pesto:
					getValueFirsts(item.getTitle().toString(),true);;
					Firsts += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Sea_Fruit:
					getValueFirsts(item.getTitle().toString(),true);;
					Firsts += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Risotto:
					getValueFirsts(item.getTitle().toString(),true);;
					Firsts += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Luganiga:
					getValueFirsts(item.getTitle().toString(),true);;
					Firsts += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.shrimps_saffran:
					getValueFirsts(item.getTitle().toString(),true);;
					Firsts += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Tar_Tare:
					getValueFirsts(item.getTitle().toString(),true);;
					Firsts += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Carpaccio:
					getValueFirsts(item.getTitle().toString(),true);;
					Firsts += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Scallops_Gratin:
					getValueFirsts(item.getTitle().toString(),true);;
					Firsts += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Done:
					Desserts = Desserts + Total;
					Firsts = Firsts + Total;
					Seconds = Seconds + Total;
					Appetizers = Appetizers + Total;
					Drinks = Drinks + Total;
					Back();
					break;
				}
				
			    return true;
			}
		});
		popup = new PopupMenu(this, view);
	}
	
	public void desserts(View view) {
		getMenuInflater().inflate(R.menu.dessert, popup.getMenu());
		popup.show();
		popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
				switch(item.getItemId()){
				default:
					break;
				case R.id.torta:
					getValueDesserts(item.getTitle().toString(),true);
					Desserts += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.panna:
					getValueDesserts(item.getTitle().toString(),true);
					Desserts += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.mer:
					getValueDesserts(item.getTitle().toString(),true);
					Desserts += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.icec:
					getValueDesserts(item.getTitle().toString(),true);
					Desserts += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.cres:
					getValueDesserts(item.getTitle().toString(),true);;
					Desserts += item.getTitle().toString() + "-";
					tavolo1.add(item.getTitle().toString());
					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));
					break;
				case R.id.Done:
					Desserts = Desserts + Total;
					Firsts = Firsts + Total;
					Seconds = Seconds + Total;
					Appetizers = Appetizers + Total;
					Drinks = Drinks + Total;
					Back();
					break;	
				}
				
			    return true;
			}
		});	
		popup = new PopupMenu(this, view);
	}
	public ListAdapter asd(String[] mona){
		adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1,mona);
		return adapter;
	}
	public void getValueDesserts(final String value, boolean Check){
		Test.toInt("Desserts", "Product", value, "Price",Check, this);
	}
	public void getValueDrinks(final String value, boolean Check){
		Test.toInt("Drinks", "Product", value, "Price",Check, this);
	}
	public void getValueAppetizers(final String value, boolean Check){
		Test.toInt("Appetizers", "Product", value, "Price",Check, this);
	}
	public void getValueFirsts(final String value, boolean Check){
		Test.toInt("Firsts", "Product", value, "Price",Check, this);
	}
	public void getValueSeconds(final String value, boolean Check){
		Test.toInt("Seconds", "Product", value, "Price",Check, this);
		
	}
	public void setTotal(int total, boolean Check){
		if (Check){
			this.Total = Total + total;
			}
		else {
			this.Total = Total - total;
			}
	}

	public void Back(){
		Test.findSaveString("Orders","Table",getIntent().getExtras().getString("Table"),"Drinks",Drinks, "Appetizers",Appetizers,"Firsts",Firsts,"Seconds",Seconds,"Desserts",Desserts);
		Test.findSaveString1("Orders","Table",getIntent().getExtras().getString("Table"),"Total",String.valueOf(Total));
		Test.SetBool("Tables", "Table", getIntent().getExtras().getString("Table"), "Taken", false,null,this);
	}
	public void Back2(){
		Intent Main = new Intent(this,MainActivity.class);
		startActivity(Main);
	}
	private void Test(ListView Test){
		Test.setOnItemClickListener(
		        new OnItemClickListener()
		        {

		            @Override
		            public void onItemClick(AdapterView<?> arg0, View view,
		                    int position, long id) {
		                // TODO Auto-generated method stub
		            	pos = position;
		                //Object o = card.getItemAtPosition(position);
		                //String pen = o.toString();
		        		popup2.show();
		        		popup2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
		        			public boolean onMenuItemClick(MenuItem item) {
		        				switch(item.getItemId()){
		        				default:
		        					break;
		        				case R.id.command:
		        					for(String key: test.keySet()){
		        						if(key.equals("Desserts")){
		        							getValueDesserts(tavolo1.get(pos),false);
		        							String[] test = Desserts.split("-");
		        							ArrayList<String> test1 = new ArrayList<String>(Arrays.asList(test));
		        							for(String element :test1){
		        								if(element.equals(tavolo1.get(pos))){
		        									test1.remove(tavolo1.get(pos));
		        								}
	        									
	        								
	        								
		        							}
		        							
		        							Desserts = "";
		        							for(String element :test1){
		        									Desserts = Desserts + element + "-";
		        								
		        								
		        							}
		        						}
		        						else if(key.equals("Appetizers")){
		        							getValueAppetizers(tavolo1.get(pos),false);
		        							String[] test = Appetizers.split("-");
		        							ArrayList<String> test1 = new ArrayList<String>(Arrays.asList(test));
		        							for(String element :test1){
		        								if(element.equals(tavolo1.get(pos))){
		        									test1.remove(tavolo1.get(pos));
		        								}
	        									
	        								
	        								
		        							}
		        							
		        							Appetizers = "";
		        							for(String element : test1){
		        									Appetizers = Appetizers + element + "-";
		        								
		        								
		        							}
		        						}
		        						else if(key.equals("Firsts")){
		        							getValueFirsts(tavolo1.get(pos),false);
		        							String[] test = Firsts.split("-");
		        							ArrayList<String> test1 = new ArrayList<String>(Arrays.asList(test));
		        							for(String element :test1){
		        								if(element.equals(tavolo1.get(pos))){
		        									test1.remove(tavolo1.get(pos));
		        								}
	        									
	        								
	        								
		        							}
		        							
		        							Firsts = "";
		        							for(String element :test1){
		        									Firsts = Firsts + element + "-";
		        								
		        								
		        							}
		        						}
		        						else if(key.equals("Seconds")){
		        							getValueSeconds(tavolo1.get(pos),false);
		        							String[] test = Seconds.split("-");
		        							ArrayList<String> test1 = new ArrayList<String>(Arrays.asList(test));
		        							for(String element :test1){
		        								if(element.equals(tavolo1.get(pos))){
		        									test1.remove(tavolo1.get(pos));
		        								}
		        							}
		        							Seconds = "";
		        							for(String element :test1){
		        									Seconds = Seconds + element + "-";	
		        							}
		        						}
		        						else if(key.equals("Drinks")){
		        							getValueDrinks(tavolo1.get(pos),false);
		        							String[] test = Drinks.split("-");
		        							ArrayList<String> test1 = new ArrayList<String>(Arrays.asList(test));
		        							for(String element :test1){
		        								if(element.equals(tavolo1.get(pos))){
		        									test1.remove(tavolo1.get(pos));
		        								}
	        									
	        								
	        								
		        							}
		        							
		        							Drinks = "";
		        							for(String element :test1){
		        									Drinks = Drinks + element + "-";
		        								
		        								
		        							}
		        						}
		        						
		        					}
		        					tavolo1.remove(pos);
		        					card.setAdapter(asd(tavolo1.toArray(new String[tavolo1.size()])));	
		        				}
		        				
		        			    return true;
		        			}
		        		});
		            }   
		        }    
		        
		);
	}

	
	

	


}
