package com.maid.childrensportplanning;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.maid.childrensportplanning.Db.DbCursor;
import com.maid.childrensportplanning.Db.Db;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Test Db
        Db.initialize(getApplicationContext());
        long children = Db.insertChildren("Dany");
        long sport = Db.insertSport("Football");
        Db.insertPlanning(children, sport, "14.12.2014 12:00");

        TextView textView = (TextView) findViewById(R.id.textView);

        DbCursor c = Db.getChildren();
        c.moveToFirst();
        String firstname = c.getChildFirstname();
        textView.setText(firstname);

        c = Db.getSports();
        c.moveToFirst();
        String name = c.getSportName();
        textView.setText(name);

        c = Db.getPlannings();
        c.moveToFirst();
        String d = c.getPlanningDate();
        textView.setText(d);

        c = Db.getPlanningsWithSportAndChildren();
        c.moveToFirst();
        firstname = c.getPlanningDate();
        textView.setText(firstname);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
