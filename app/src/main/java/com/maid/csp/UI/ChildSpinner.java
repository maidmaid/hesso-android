package com.maid.csp.UI;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.maid.csp.Db.Db;
import com.maid.csp.Db.DbContract;
import com.maid.csp.Db.DbCursor;
import com.maid.csp.Db.DbHelper;

public class ChildSpinner extends Spinner {
    public DbCursor cursor;

    public ChildSpinner(Context context) {
        super(context);
    }

    public ChildSpinner(Context context, int mode) {
        super(context, mode);
        init();
    }

    public ChildSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ChildSpinner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public ChildSpinner(Context context, AttributeSet attrs, int defStyle, int mode) {
        super(context, attrs, defStyle, mode);
        init();
    }

    private void init() {
        SpinnerAdapter adapter;
        if(isInEditMode()) {
            adapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_spinner_item,
                new String[] { "Child Spinner Widget" }
            );
        } else {
            cursor = Db.getChildren();
            adapter = new SimpleCursorAdapter(
                getContext(),
                android.R.layout.simple_spinner_item,
                cursor,
                new String[] { DbContract.Child.COLUMN_NAME_FIRSTNAME },
                new int[] { android.R.id.text1 },
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
            );
        }
        setAdapter(adapter);
        setOnItemSelectedListener(new OnChildItemSelectedListener());
    }

    private class OnChildItemSelectedListener implements OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            cursor.moveToPosition(i);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
}
