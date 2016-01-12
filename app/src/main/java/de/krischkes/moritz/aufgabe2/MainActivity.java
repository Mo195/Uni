package de.krischkes.moritz.aufgabe2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.activeandroid.ActiveAndroid;

public class MainActivity extends Activity {

    EditText startOrtText, zielOrtText, entfernungText, datumText;
    Button changeButton, okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActiveAndroid.initialize(getApplication());

        //get views

        startOrtText = (EditText)findViewById(R.id.startOrt);
        zielOrtText = (EditText)findViewById(R.id.zielOrt);
        entfernungText = (EditText)findViewById(R.id.entfernung);
        datumText = (EditText)findViewById(R.id.datum);

        changeButton = (Button)findViewById(R.id.changeButton);
        okButton = (Button)findViewById(R.id.okButton);

        //onClick for change
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeIntent = new Intent(getBaseContext(), SummaryActivity.class);
                startActivity(changeIntent);
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveEntry();
            }
        });


    }

    public void saveEntry(){
        String startOrt="";
        String zielOrt="";
        String datum="";
        int entfernung = 0;

        startOrt=startOrtText.getText().toString();
        zielOrt=zielOrtText.getText().toString();
        datum=datumText.getText().toString();
        entfernung= Integer.valueOf((entfernungText.getText().toString()));

        Fahrt tempFahrt = new Fahrt(entfernung,startOrt,zielOrt,datum);
        tempFahrt.save();
    }
}
