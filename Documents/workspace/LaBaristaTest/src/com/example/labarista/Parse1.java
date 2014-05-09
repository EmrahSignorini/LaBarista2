package com.example.labarista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.view.View;
import android.widget.Button;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class Parse1 {
	private String a;
	private boolean b;
	private String d;
	private HashMap<String,Integer> test;
	public ArrayList<View> hello;
	private String list = "";
	
	public Parse1(){
		a = "";
		b = false;
		d = "";
		test = new HashMap<String,Integer>();
		
		
	}
	
	public void findSaveString(final String cl, final String columnFind, final String valueFind, final String columnChange, final String valueChange,final String columnChange1,final String valueChange1,final String columnChange2,final String valueChange2,final String columnChange3,final String valueChange3,final String columnChange4,final String valueChange4){
		ParseQuery<ParseObject> query = ParseQuery.getQuery(cl);
		query.whereEqualTo(columnFind, valueFind);
		query.findInBackground(new FindCallback<ParseObject>() {
			   public void done(List<ParseObject> objects, ParseException e) {
			     if (e == null) {
			    	 for(int i =0;i<objects.size();i++){
			    		 ParseObject point = ParseObject.createWithoutData(cl, objects.get(i).getObjectId());
			    		 point.put(columnChange, valueChange);
			    		 point.put(columnChange1, valueChange1);
			    		 point.put(columnChange2, valueChange2);
			    		 point.put(columnChange3, valueChange3);
			    		 point.put(columnChange4, valueChange4);
			    		 point.saveInBackground();
			 		}}
			      else {
			       //
			     }
			   }
			 });
		
	}
	public void findSaveString1(final String cl, final String columnFind, final String valueFind, final String columnChange, final String valueChange){
		ParseQuery<ParseObject> query = ParseQuery.getQuery(cl);
		query.whereEqualTo(columnFind, valueFind);
		query.findInBackground(new FindCallback<ParseObject>() {
			   public void done(List<ParseObject> objects, ParseException e) {
			     if (e == null) {
			    	 for(int i =0;i<objects.size();i++){
			    		 ParseObject point = ParseObject.createWithoutData(cl, objects.get(i).getObjectId());
			    		 point.put(columnChange, valueChange);
			    		 point.saveInBackground();
			 		}}
			      else {
			       //
			     }
			   }
			 });
		
	}
	
	public void findSaveBool(final String cl, final String columnFind, final String valueFind, final String columnChange, final boolean valueChange, final OccTable table){
		ParseQuery<ParseObject> query = ParseQuery.getQuery(cl);
		query.whereEqualTo(columnFind, valueFind);
		query.findInBackground(new FindCallback<ParseObject>() {
			   public void done(List<ParseObject> objects, ParseException e) {
			     if (e == null) {
			    	 for(int i =0;i<objects.size();i++){
			    		 ParseObject point = ParseObject.createWithoutData(cl, objects.get(i).getObjectId());
			    		 point.put(columnChange, valueChange);
			    		 point.saveInBackground();
			 		}
			    	 table.back1(null);
			    	 }
			       
			      else {
			       //
			     }
			   }
			 });	
	}
	
	public String get(final String cl, final String column, final String value, final String toGet){
		ParseQuery<ParseObject> query = ParseQuery.getQuery(cl);
		query.whereExists(column);
		 query.findInBackground(new FindCallback<ParseObject>() {
			   public void done(List<ParseObject> objects, ParseException e) {
			     if (e == null) {
			    	 for(int i =0;i<objects.size();i++){
			    		 if(objects.get(i).getString(column).equals(value)){
			    		 a = objects.get(i).getString(toGet);
			    		 }
			    	 }
			       
			     } else {}
			   }
			 });
		 return a;
	}
	
	public boolean searchBool(final String cl, final String column, final String value, final String toGet){
		ParseQuery<ParseObject> query = ParseQuery.getQuery(cl);
		query.whereExists(column);
		 query.findInBackground(new FindCallback<ParseObject>() {
			   public void done(List<ParseObject> objects, ParseException e) {
			     if (e == null) {
			    	 for(int i =0;i<objects.size();i++){
			    		 if(objects.get(i).getString(column).equals(value)){
			    		 b = objects.get(i).getBoolean(toGet);
			    		 }
			    	 }
			       
			     } else {}
			   }
			 });
		 return b;
	}
	
	
	
	
	public String getStringArray(final String cl, final String columnFind, final String valueFind, final String columnToGet, final Table table){
		ParseQuery<ParseObject> query = ParseQuery.getQuery(cl);
		query.whereEqualTo(columnFind, valueFind);
		query.findInBackground(new FindCallback<ParseObject>() {
			   public void done(List<ParseObject> objects, ParseException e) {
			     if (e == null) {
			    	 for(int i =0;i<objects.size();i++){
			    		  d = objects.get(i).getString(columnToGet);
			    	 }  
				    		  String[] puta = d.split("-");
				    		  String fodes = "";
				    		  for (int index = 0; index < puta.length; index++){
				    			  fodes += puta[index]+" ";
				    		  }
			    			  table.addString(fodes); 
			     } else {}
			   }
			 });

		 return d;
	}
public void SetBool(final String cl,final String columnFind, final String valueFind,final String columnToGet,final boolean value,final MainActivity main,final WaitActivity wait){
	ParseQuery<ParseObject> query = ParseQuery.getQuery(cl);
	query.whereEqualTo(columnFind, valueFind);
	query.findInBackground(new FindCallback<ParseObject>() {
		   public void done(List<ParseObject> objects, ParseException e) {
		     if (e == null) {
		    	 if (main == null){
		    		 for(int i =0;i<objects.size();i++){
		    			 if (objects.get(i).getBoolean(columnToGet) == value){
		    				 	ParseObject point = ParseObject.createWithoutData(cl, objects.get(i).getObjectId());
		    				 	point.put("Taken", !value);
		    				 	point.saveInBackground();
		    				 	}
		    			 }
		    		 wait.Back2();
		    		 }
		    	 	
		    	 	else {
			    		 for(int i =0;i<objects.size();i++){
			    			 if (objects.get(i).getBoolean(columnToGet) == value){
			    				 
			    				 main.empty(valueFind);

			    			 }
			    				 	
			    			 else {
			    				main.updateTables();
			    			 	main.OccupiedTable(valueFind);
			    			 	}
			    		 }
		    	 	}
		    	 }
		       
		      else {
		       //
		     }
		   }
		 });
}
public void setColorBtn(final String cl,final String columnFind,final String columnToGet, final boolean toSearch,final int color1,final int color2,final MainActivity main,final Button btn){
	ParseQuery<ParseObject> query = ParseQuery.getQuery(cl);
	query.whereExists(columnFind);
	 query.findInBackground(new FindCallback<ParseObject>() {
		   public void done(List<ParseObject> objects, ParseException e) {
		     if (e == null) {
		    	 for(int i =0;i<objects.size();i++){
		    		 if(objects.get(i).getString(columnFind).equals(btn.getContentDescription().toString())){
		    		if (objects.get(i).getBoolean(columnToGet) == toSearch){
						main.SetColor(btn,color1);	
					}
					else {
						main.SetColor(btn,color2);	
		    		 }
		    	 }
		       
		    	 }} else {}
		   }
		 });
}
public void toInt(final String cl, final String column, final String value, final String toGet,final boolean Check, final WaitActivity wait){
	ParseQuery<ParseObject> query = ParseQuery.getQuery(cl);
	query.whereExists(column);
	 query.findInBackground(new FindCallback<ParseObject>() {
		   public void done(List<ParseObject> objects, ParseException e) {
		     if (e == null) {
		    	 for(int i =0;i<objects.size();i++){
		    		 if(objects.get(i).getString(column).equals(value)){
		    			 //asd.setPrice(Integer.parseInt(objects.get(i).getString(toGet)));
		    			 	test.put(value, Integer.parseInt(objects.get(i).getString(toGet)));
		    			 	wait.setTotal(Integer.parseInt(objects.get(i).getString(toGet)),Check);
		    		 
		    		 }
		    	  }
		       
		     } else {}
		   }
		 });

}
	public void SetView(ArrayList<View> prova){
		this.hello=prova;
		
	}
	public ArrayList<View> Test(){
		return hello;
		
	}
    public void getOrder(final String cl, final String columnFind, final String valueFind, final String columnToGet, final OccTable occtable){
        ParseQuery<ParseObject> query = ParseQuery.getQuery(cl);
        query.whereEqualTo(columnFind, valueFind);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    for(int i =0;i<objects.size();i++){
                        list = objects.get(i).getString(columnToGet);
                    }
                    occtable.setYolo(list);
                } else {}
            }
        });
    }
    
    
    
    public void deleteAllOrders(final String cl, final String columnFind, final String valueFind, final OccTable occtable){
        ParseQuery<ParseObject> query = ParseQuery.getQuery(cl);
        query.whereEqualTo(columnFind, valueFind);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    for(int i =0;i<objects.size();i++){
                        ParseObject point = ParseObject.createWithoutData(cl, objects.get(i).getObjectId());
                        point.put("Drinks", "");
                        point.put("Appetizers", "");
                        point.put("Firsts", "");
                        point.put("Seconds", "");
                        point.put("Desserts", "");
                        point.put("Total", "0");
                        point.saveInBackground();
                    }  
                } else {}
            }
        }); 
        
    }

}