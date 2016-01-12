package de.krischkes.moritz.aufgabe2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;

import java.util.Iterator;
import java.util.List;

public class SummaryActivity extends Activity {

    TextView anzFahrtenTV, strecke;
    Button changeBackButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        //initialize ActiveAndroid
        ActiveAndroid.initialize(getApplication());
        //get views
        anzFahrtenTV=(TextView)findViewById(R.id.anzFahrten);
        strecke=(TextView)findViewById(R.id.streckeGesamt);

        changeBackButton=(Button)findViewById(R.id.changeBackButton);
        //show results
        showResults();

        //onclick
        changeBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeIntent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(changeIntent);
            }
        });
    }

    public void showResults(){
        List<Fahrt> fahrten = new Select().from(Fahrt.class).execute();
        Iterator iterator = fahrten.iterator();
        int anzFahrten=0;
        int streckeGesamt=0;
        while(iterator.hasNext()){
            Fahrt tempFahrt = (Fahrt)iterator.next();
            anzFahrten++;
            streckeGesamt+=tempFahrt.getEntfernung();
        }
        anzFahrtenTV.setText(String.valueOf(anzFahrten));
        strecke.setText(String.valueOf(streckeGesamt));
    }
}
