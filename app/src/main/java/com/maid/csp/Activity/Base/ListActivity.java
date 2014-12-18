package com.maid.csp.Activity.Base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.maid.csp.R;
import com.maid.csp.UI.Base.DbListView;

public abstract class ListActivity extends Activity {
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getListView().setOnItemClickListener(new OnClickListener());
    }

    /**
     * Click listener
     */
    protected class OnClickListener extends DbListView.OnDbItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            super.onItemClick(parent, view, position, id);
            openPlanningEditor(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.l_add:
                openPlanningEditor();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Open planning editor
     */
    private void openPlanningEditor(boolean editMode) {
        Intent intent = createIntentEditor(editMode);
        intent.putExtra("edit_mode", editMode);
        startActivity(intent);
    }

    /**
     * Open planing editor (with new mode)
     */
    private void openPlanningEditor() {
        openPlanningEditor(false);
    }

    /**
     * Create intent for editor
     * @param editMode
     * @return
     */
    protected abstract Intent createIntentEditor(boolean editMode);

    /**
     * Get main list view
     * @return
     */
    protected abstract DbListView getListView();

    @Override
    protected void onResume() {
        super.onResume();
        getListView().cursor.requery();
    }
}
