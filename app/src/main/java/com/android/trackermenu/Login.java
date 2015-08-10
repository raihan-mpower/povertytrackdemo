package com.android.trackermenu;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        final EditText username,password;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login );
		username = (EditText)findViewById(R.id.hhname);
        password = (EditText)findViewById(R.id.password);
		Button login_button = (Button) findViewById(R.id.button_login);
		
		login_button.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 if(username.getEditableText().toString().equalsIgnoreCase("user")&&password.getEditableText().toString().equalsIgnoreCase("password")) {
                     Intent I = new Intent(Login.this, MainActivity.class);
                     startActivity(I);
                 }else{
                     Toast.makeText(Login.this,"wrong username and password",Toast.LENGTH_LONG);
                }
			}
		});
		
	}
    
}
