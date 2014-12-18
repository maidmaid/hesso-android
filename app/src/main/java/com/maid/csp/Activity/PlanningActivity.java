package com.maid.csp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.maid.csp.Activity.Base.ListActivity;
import com.maid.csp.Db.Db;
import com.maid.csp.R;
import com.maid.csp.UI.Base.DbListView;


public class PlanningActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Db.initialize(this);
        setContentView(R.layout.activity_planning);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_planning, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.p_open_sport:
                openSport();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected Intent createIntentEditor(boolean editMode) {
        Intent intent = new Intent(this, PlanningEditorActivity.class);
        if(editMode) {
            intent.putExtra("id", getListView().cursor.getId());
            intent.putExtra("id_child", getListView().cursor.getPlanningChild());
            intent.putExtra("id_sport", getListView().cursor.getPlanningSport());
            intent.putExtra("date", getListView().cursor.getPlanningDateAsCalendar());
        }
        return intent;
    }

    @Override
    protected DbListView getListView() {
        return (DbListView) findViewById(R.id.p_listView);
    }

    /**
     * Open sport
     */
    private void openSport() {
        Intent intent = new Intent(this, SportActivity.class);
        startActivity(intent);
    }
}
