package com.android.trackermenu;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login );
		
		Button login_button = (Button) findViewById(R.id.button_login);
		
		login_button.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 
				Intent I = new Intent(Login.this, MainActivity.class);
				startActivity(I);
			}
		});
		
	}
    
}
