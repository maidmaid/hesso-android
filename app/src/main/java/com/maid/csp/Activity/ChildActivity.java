package com.maid.csp.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.maid.csp.Activity.Base.ListActivity;
import com.maid.csp.R;
import com.maid.csp.UI.Base.DbListView;

public class ChildActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
    }

    @Override
    protected Intent createIntentEditor(boolean editMode) {
        Intent intent = new Intent(this, ChildEditorActivity.class);
        if(editMode) {
            intent.putExtra("id", getListView().cursor.getId());
            intent.putExtra("firstname", getListView().cursor.getChildFirstname());
        }
        return intent;
    }

    @Override
    protected DbListView getListView() {
        return (DbListView) findViewById(R.id.c_listView);
    }
}
