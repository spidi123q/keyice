package net.sf.keyice;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        
        return true;
    }
    public void sendMessage(View view) 
    {
        Intent intent = new Intent(MainActivity.this, SimpleCry.class);
        startActivity(intent);
    }
    public void sendMessage2(View view) 
    {
        Intent intent = new Intent(MainActivity.this, AdvancedCry.class);
        startActivity(intent);
    }
    public void mabout(View view) 
    {
        Intent intent = new Intent(MainActivity.this, About.class);
        startActivity(intent);
    }
}
