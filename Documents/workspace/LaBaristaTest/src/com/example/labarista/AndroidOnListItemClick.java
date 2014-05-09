package com.example.labarista;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class AndroidOnListItemClick extends ListActivity {
	
	protected void onListItemClick(ListView l, View v, int position, long id) {
		  // TODO Auto-generated method stub
		  super.onListItemClick(l, v, position, id);
		  
		  new AlertDialog.Builder(this)
		   .setTitle("Hello")
		   .setMessage("from " + getListView().getItemAtPosition(position))
		   .setPositiveButton("OK",
		     new DialogInterface.OnClickListener() {
		      public void onClick(DialogInterface dialog, int which) {}}
		     )
		   .show();
		  
		  Toast.makeText(AndroidOnListItemClick.this,
		    "ListView: " + l.toString() + "\n" +
		    "View: " + v.toString() + "\n" +
		    "position: " + String.valueOf(position) + "\n" +
		    "id: " + String.valueOf(id),
		    Toast.LENGTH_LONG).show();
		 }

}
