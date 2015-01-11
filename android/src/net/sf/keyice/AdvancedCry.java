package net.sf.keyice;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TabHost.TabSpec;

public class AdvancedCry extends Activity{

	private IAEF myString;
	  
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// objects declarations
		myString = new IAEF();
		
		    setContentView (R.layout.advancedcry);
	        TabHost th = (TabHost) findViewById(R.id.tabhost);
	        //decaring decrypt tab elements
	        final EditText inputTextD = (EditText) findViewById (R.id.editText1D);
	        final EditText outputTextD = (EditText ) findViewById (R.id.editText2D);
	        final EditText passwordBox = (EditText ) findViewById (R.id.passwordBox);
	        final TextView tempText = (TextView ) findViewById (R.id.textView1);
	        passwordBox.setHint("Enter password");
	        @SuppressWarnings("unused")
			final TextView passText = (TextView ) findViewById (R.id.textViewPass);
	        Button deButton = (Button) findViewById (R.id.deButton);
	        //declaring encrypt tab elements
	        final EditText inputText = (EditText) findViewById (R.id.editText1);
	        final EditText outputText = (EditText ) findViewById (R.id.editText2);	        
	        Button enButton = (Button) findViewById (R.id.enButton);
	        
	        enButton.setOnClickListener(new View.OnClickListener() {			
				@Override
				public void onClick(View arg0) {
					// simple encryption starts
					
					String toEncry = inputText.getText().toString();
					myString.keyGen();
					String key = String.valueOf(IAEF.key);
					myString.advancedEncrypt(toEncry)	; 
					outputText.setText(IAEF.enoutput);
					tempText.setText("\n\nYour password : "+key);
					
					
				}
			});
	        
	        deButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					//simple decryption start
					String toDecry = inputTextD.getText().toString();
					String myKey = passwordBox.getText().toString();
					if(myKey.isEmpty())
					{
						outputTextD.setText("Password not found");
					}
					else
					{
						try {
					int key = Integer.parseInt(myKey);
					myString.advancedDecrypt(toDecry, key)	;		 
					outputTextD.setText(IAEF.deoutput);
						}	catch (Exception e) {
						    e.printStackTrace();
						}
					}
					
					
				}
			});
	        
	        //setting tabs
	        
	        th.setup();
	        TabSpec ts = th.newTabSpec("tab1 my");
	        ts.setContent(R.id.tab1);
	        ts.setIndicator("Encrypt");
	        th.addTab(ts);
	        
	        
	        ts = th.newTabSpec("tab2 my");
	        ts.setContent(R.id.tab2);
	        ts.setIndicator("Decrypt");
	        th.addTab(ts);
	        
	        //file write
	       
		super.onCreate(savedInstanceState);
		
		
		
		 
	
	}


	public boolean onCreateOptionsMenu(Menu menu) {
		// create menu bar	
		super.onCreateOptionsMenu(menu);
	
		  SubMenu encryptMenu = menu.addSubMenu("Encrypt");
		  SubMenu decryptMenu = menu.addSubMenu("Decrypt");
		    encryptMenu.add (0, R.id.writeToFile, 0, "Save");
		    encryptMenu.add(1, R.id.readFile, 1, "Open");
		    encryptMenu.add(2, R.id.readText, 2, "Read dash text");
		   
		    decryptMenu.add (0, R.id.writeToFileD, 0, "Save");
		    decryptMenu.add(1, R.id.readFileD, 1, "Open");
		    decryptMenu.add(2, R.id.readTextD, 2, "Read dash text");
	
		
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item) {
		// make menu do operation
		switch( item.getItemId() ) {
		//Encrypt submenu action
		case R.id.writeToFile :
			//starts save file activity
			
			Intent saveIntent = new Intent(this, SimpleSave.class);
	        startActivity(saveIntent);
	        IAEF.val = false;
			break;
		
		case R.id.readFile :
			//start openfile activity
			Intent openIntent = new Intent(this, SimpleOpen.class);
	        startActivity(openIntent);
	        IAEF.val = false;		
			break;
			
		case R.id.readText :
			// check for empty text
			if(IAEF.toencrypt.isEmpty())	{
				Toast.makeText(getApplicationContext(),"No text found on dash",Toast.LENGTH_LONG).show();
				Toast.makeText(getApplicationContext(),"choose 'Open ' from Encrypt menu",Toast.LENGTH_LONG).show();
			}
			else {
			final EditText inputText = (EditText) findViewById (R.id.editText1);
			inputText.setText(IAEF.toencrypt);
			}
			break;
			
			//Decrypt submenu action
		case R.id.writeToFileD :
			//starts save file activity
			saveIntent = new Intent(this, SimpleSave.class);
	        startActivity(saveIntent);
	        //informs that decryption is operation to do
	        IAEF.val = true;
			break;
		
		case R.id.readFileD :
			//start openfile activity
			openIntent = new Intent(this, SimpleOpen.class);
	        startActivity(openIntent);
	      //informs that decryption is operation to do
	        IAEF.val = true;
	        
			break;
			
		case R.id.readTextD :
			//informs that decryption is operation to do
	        IAEF.val = true;
			// check for empty text
			if(IAEF.todecrypt.isEmpty())	{
				Toast.makeText(getApplicationContext(),"No text found on dash",Toast.LENGTH_LONG).show();
				Toast.makeText(getApplicationContext(),"choose 'Open ' from Decrypt menu",Toast.LENGTH_LONG).show();
			}
			else {
			final EditText inputText = (EditText) findViewById (R.id.editText1D);
			inputText.setText(IAEF.todecrypt);
			}	
		}
		
		return super.onContextItemSelected(item); 
	}
	

}
