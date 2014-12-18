package com.maid.csp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.maid.csp.Db.Db;
import com.maid.csp.Db.DbCursor;
import com.maid.csp.R;
import com.maid.csp.UI.DbListView;
import com.maid.csp.UI.PlanningListView;


public class PlanningActivity extends Activity {
    private DbCursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Db.initialize(this);
        setContentView(R.layout.activity_planning);
        PlanningListView listView = (PlanningListView) findViewById(R.id.p_listView);
        cursor = listView.cursor;
        listView.setOnItemClickListener(new OnClickListener());
    }

    /**
     * Click listener
     */
    private class OnClickListener extends DbListView.OnDbItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            super.onItemClick(parent, view, position, id);
            openPlanningEditor(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_planning, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.p_add:
                openPlanningEditor();
                return true;
            case R.id.p_open_sport:
                openSport();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Open planning editor
     */
    private void openPlanningEditor(boolean editMode) {
        Intent intent = new Intent(this, PlanningEditorActivity.class);
        intent.putExtra("edit_mode", editMode);
        if(editMode) {
            intent.putExtra("id", cursor.getId());
            intent.putExtra("id_child", cursor.getPlanningChild());
            intent.putExtra("id_sport", cursor.getPlanningSport());
            intent.putExtra("date", cursor.getPlanningDateAsCalendar());
        }
        startActivity(intent);
    }

    /**
     * Open planing editor (with new mode)
     */
    private void openPlanningEditor() {
        openPlanningEditor(false);
    }

    /**
     * Open sport
     */
    private void openSport() {
        Intent intent = new Intent(this, SportActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        cursor.requery();
    }
}
