package com.maid.csp.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.maid.csp.R;
import com.maid.csp.UI.DbListView;

public class SportActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);
    }

    @Override
    protected Intent createIntentEditor(boolean editMode) {
        Intent intent = new Intent(this, SportEditorActivity.class);
        return intent;
    }

    @Override
    protected DbListView getListView() {
        return (DbListView) findViewById(R.id.s_listView);
    }
}
