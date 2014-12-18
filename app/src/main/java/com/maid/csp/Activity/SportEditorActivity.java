package com.maid.csp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.maid.csp.Db.Db;
import com.maid.csp.R;

import java.util.Calendar;

public class SportEditorActivity extends EditorActivity {
    private long sport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_editor);

        // Intent
        Intent intent = getIntent();
        editMode = intent.getBooleanExtra("edit_mode", false);
        if(editMode) {
            // Get data
            sport = intent.getLongExtra("id", 0);
        }
    }

    @Override
    public void addAction() {

    }

    @Override
    public void updateAction() {

    }

    @Override
    public void deleteAction() {

    }
}
