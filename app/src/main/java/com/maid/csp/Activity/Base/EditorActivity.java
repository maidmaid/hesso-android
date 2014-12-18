package com.maid.csp.Activity.Base;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.maid.csp.R;

public abstract class EditorActivity extends Activity {
    protected long id;
    protected boolean editMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        editMode = intent.getBooleanExtra("edit_mode", false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        if(!editMode) {
            menu.findItem(R.id.e_delete).setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.e_accept:
                if(editMode) {
                    updateAction();
                } else {
                    addAction();
                }
                return true;
            case R.id.e_delete:
                showDeleteAction();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * add action
     */
    public abstract void addAction();

    /**
     * Update action
     */
    public abstract void updateAction();

    /**
     * Delete action
     */
    public abstract void deleteAction();

    /**
     * Show delete action
     */
    public void showDeleteAction() {
        new AlertDialog.Builder(this)
            .setTitle(R.string.warning)
            .setMessage(R.string.delete_question)
            .setPositiveButton(android.R.string.yes, new AlertDialog.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    deleteAction();
                }
            })
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show();
    }
}
