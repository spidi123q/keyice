package net.sf.keyice;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class About extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 setContentView (R.layout.about);
		 TextView aboutText = (TextView) findViewById (R.id.aboutText);
		 aboutText.setText("\tCompany : icefeast"+
				 "\n\n\tWebsite : www.icefeast.sf.net" +
		 		"\n\n\tDeveloper : Suraj kiran"+
				 "\n\n\tEmail : icefeast@live.com"+
				 "\n\n\tVersion : 1.0");
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	
	

}
