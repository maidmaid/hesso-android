package com.maid.csp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.maid.csp.Activity.Base.EditorActivity;
import com.maid.csp.Db.Db;
import com.maid.csp.R;

public class ChildEditorActivity extends EditorActivity {
    private long child;
    private TextView firstnameTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_editor);
        firstnameTxt = (TextView) findViewById(R.id.ce_firstname);

        // Intent
        Intent intent = getIntent();
        if(editMode) {
            child = intent.getLongExtra("id", 0);
            String firstname = intent.getStringExtra("firstname");
            firstnameTxt.setText(firstname);
        }
    }

    @Override
    public void addAction() {
        String firstname = firstnameTxt.getText().toString();
        Db.insertChild(firstname);
        finish();
    }

    @Override
    public void updateAction() {
        String firstname = firstnameTxt.getText().toString();
        Db.updateChild(child, firstname);
        finish();
    }

    @Override
    public void deleteAction() {

    }
}
