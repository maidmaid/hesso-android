package com.maid.csp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.maid.csp.Db.Db;
import com.maid.csp.R;

import java.util.Calendar;

public class SportEditorActivity extends EditorActivity {
    private long sport;
    private EditText nameTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_editor);
        nameTxt = (EditText) findViewById(R.id.se_name);

        // Intent
        Intent intent = getIntent();
        if(editMode) {
            sport = intent.getLongExtra("id", 0);
            String name = intent.getStringExtra("name");
            nameTxt.setText(name);
        }
    }

    @Override
    public void addAction() {
        String name = nameTxt.getText().toString();
        Db.insertSport(name);
        finish();
    }

    @Override
    public void updateAction() {
        String name = nameTxt.getText().toString();
        Db.updateSport(sport, name);
        finish();
    }

    @Override
    public void deleteAction() {
        // TODO
    }
}
