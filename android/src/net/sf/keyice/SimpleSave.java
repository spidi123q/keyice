package net.sf.keyice;


import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.OutputStreamWriter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.widget.Toast;

public class SimpleSave extends Activity {
	
	IAEF myString;
	
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplesave);
        
        
       
        final EditText fileN = (EditText) findViewById (R.id.fileName);
        final TextView tempText = (TextView) findViewById (R.id.textView2);
        tempText.setText("\n\n\tKeyice will save your file\n\tin /sdcard/Keyice folder");
       
        Button saveButton = (Button) findViewById (R.id.saveButton);
        Button closeButton = (Button) findViewById (R.id.closeButton);
        
        closeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			
			  //close activity
				 Intent intent = new Intent();
				 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				 finish();
				
				
			}
		});
        
        
        //do action on save button
        saveButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// save starts
				
				String location = Environment.getExternalStorageDirectory().getPath();
				//empty filename check
				String temp = fileN.getText().toString();
				if(temp.isEmpty())
				{
					tempText.setText("\n\n\n\n\nFile name not found");
					
				}
				String filename="/"+fileN.getText().toString();
				File folder = new File(location + "/Keyice");
				boolean success = true;
				if (!folder.exists()) {
				    success = folder.mkdir();
				}
				if (success) {
				    // Do write on success
					String data;
					//if val is true decrypt tab will be flaged
					if(IAEF.val)	{
					data = IAEF.deoutput;
					}
					else	{
					data = IAEF.enoutput;
					}
					
					
					
					@SuppressWarnings("unused")
					FileOutputStream fos;
					   try {
						   File myFile = new File(location + "/Keyice"+filename);
							myFile.createNewFile();
							FileOutputStream fOut = new FileOutputStream(myFile);
							OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
							myOutWriter.append(data);
							myOutWriter.close();
							fOut.close();
					   
					    Toast.makeText(getApplicationContext(),filename + " saved",Toast.LENGTH_LONG).show();
					    Intent intent = new Intent();
						intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						 finish();
					    
					   
					   } catch (FileNotFoundException e) {e.printStackTrace();}
					   catch (IOException e) {e.printStackTrace();}
				} else {
				    // Do something else on failure 
					Toast.makeText(getApplicationContext(),filename + " unknown save error",Toast.LENGTH_LONG).show();
				}
				 
				
				
			
				
			}
        });
        
        
        
        
        
        
        
    }

	 
	@SuppressLint("SdCardPath")
	public void readFile()
	{
		
		
	    
	}
	
	 

}
