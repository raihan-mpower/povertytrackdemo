package com.android.trackermenu;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Followups extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.followups);

		
		
		 try {
		        ViewConfiguration config = ViewConfiguration.get(this);
		        Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
		        if(menuKeyField != null) {
		            menuKeyField.setAccessible(true);
		            menuKeyField.setBoolean(config, false);
		        }
		    } catch (Exception ex) {
		        // Ignore
		    }
		
	 
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		Intent i;
		
	    // Handle item selection
	    switch (item.getItemId()) {
	    case R.id.profile:
	         i =  new Intent(Followups.this , PersonDetails.class);
	        startActivity(i);
	        return true;
	        
	        
	    case R.id.survey:
	         i =  new Intent(Followups.this , Survey.class);
	        startActivity(i);
	        return true; 
	        
	        
	    case R.id.transfer:
	         i =  new Intent(Followups.this , Transfer.class);
	        startActivity(i);
	        return true;    
	     
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}

}
