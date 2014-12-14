package com.maid.csp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.maid.csp.Db.Db;
import com.maid.csp.R;


public class PlanningActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Db.initialize(this);
        setContentView(R.layout.activity_planning);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_planning, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_planning:
                openPlanningEditor();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    /**
     * Open planning editor
     */
    private void openPlanningEditor() {
        Intent intent = new Intent(this, PlanningEditorActivity.class);
        startActivity(intent);
    }
}
