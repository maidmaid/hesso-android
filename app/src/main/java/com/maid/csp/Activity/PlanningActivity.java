package com.maid.csp.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.maid.csp.Db.DbContract;
import com.maid.csp.Db.DbCursor;
import com.maid.csp.Db.Db;
import com.maid.csp.R;


public class PlanningActivity extends Activity {

    private DbCursor cursor;
    private CursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);
        Db.initialize(this);

        cursor = Db.getPlanningsWithSportAndChildren();
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new OnPlanningItemClickListener());
        adapter = new SimpleCursorAdapter(
            this,
            R.layout.listview_planning,
            cursor,
            new String[] {
                DbContract.Child.COLUMN_NAME_FIRSTNAME,
                DbContract.Sport.COLUMN_NAME_NAME,
                DbContract.Planning.COLUMN_NAME_DATE
            },
            new int[] {
                R.id.title,
                R.id.subtitle,
                R.id.description
            },
            CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );
        listView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_planning, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case R.id.action_add_planning:
                addPlanning();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    /**
     * Planning item click listener
     */
    private class OnPlanningItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            cursor.moveToPosition(i);
        }
    }

    /**
     * Add planning
     */
    private void addPlanning() {
        long o = Db.insertChildren("Obama");
        long b = Db.insertSport("Basket");
        Db.insertPlanning(o, b, "14.12.2014 15:03");
        cursor.requery();
    }
}
