package net.sf.keyice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleOpen extends Activity {
	IAEF myString;
	
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simpleopen);
		//object creation
		   final EditText fileN = (EditText) findViewById (R.id.fileNameOpen);	       
	        Button openButton = (Button) findViewById (R.id.openButton);
	        Button closeButton = (Button) findViewById (R.id.closeButtonOpen);
	        final TextView tempText = (TextView) findViewById (R.id.textView2);
	        tempText.setText("\n\n\tKeyice will search for file\n\tin /sdcard/Keyice folder\n\tto display file content in input field choose\n\t 'Read dash text'from Encrypt\\Decrypt menu  ");
	        //openButton action
	        
	        openButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// do action
					String filename = fileN.getText().toString();
					String location = Environment.getExternalStorageDirectory().getPath();
					File xFile = new File("/"+location+"/Keyice/"+filename);
					
					if (xFile.exists()) {
							
						
					@SuppressWarnings("unused")
					StringBuffer stringBuffer = new StringBuffer();  
					String aDataRow = "";
					String fileContent = "";
					try {
						File myFile = new File("/"+location+"/Keyice/"+filename);
						FileInputStream fIn = new FileInputStream(myFile);
						BufferedReader myReader = new BufferedReader(
								new InputStreamReader(fIn));
						
						while ((aDataRow = myReader.readLine()) != null) {
							fileContent += aDataRow + "\n";
						}
						myReader.close();
					    
					} catch (IOException e) {
					    e.printStackTrace();
					}
					
					Toast.makeText(getApplicationContext(),filename+"\topensuccess",Toast.LENGTH_LONG).show();
					//if val is true decrypt tab will be flaged
					if (IAEF.val)	{
					IAEF.todecrypt = fileContent;
					}
					else	{
						IAEF.toencrypt = fileContent;
					}
					
					
					
					
					}
					else
						Toast.makeText(getApplicationContext(),filename+"\t error ",Toast.LENGTH_LONG).show();
					 Intent intent = new Intent();
					 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					 finish();
					
				}
			});
	        //close button action
	        closeButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();
					 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					 finish();
				}
			});
	    	
	}
	
	
	

}
