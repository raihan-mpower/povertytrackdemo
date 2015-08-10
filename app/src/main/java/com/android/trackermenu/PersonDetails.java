package com.android.trackermenu;

import java.lang.reflect.Field;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.widget.TextView;

import com.android.trackermenu.datamodel.family;

public class PersonDetails  extends Activity{

      public static	family Family ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_person);
        ((TextView)findViewById(R.id.name)).setText(Family.getNameHH());
        ((TextView)findViewById(R.id.agehh)).setText(Family.getNameHH());
        ((TextView)findViewById(R.id.children)).setText(Family.getNumberOfChildren() + " Children");
		
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
	 
	        
	    case R.id.survey:
	         i =  new Intent(PersonDetails.this , Survey.class);
	        startActivity(i);
	        return true; 
	        
	        
	    case R.id.follow:
	         i =  new Intent(PersonDetails.this , Followups.class);
	        startActivity(i);
	        return true; 
	        
	    case R.id.transfer:
	         i =  new Intent(PersonDetails.this , Transfer.class);
	        startActivity(i);
	        return true;    
	        
	     
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}
	
	
	
}
