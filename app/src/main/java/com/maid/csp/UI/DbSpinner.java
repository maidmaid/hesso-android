package com.maid.csp.UI;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.maid.csp.Db.DbCursor;

public abstract class DbSpinner extends Spinner {
    public DbCursor cursor;

    public DbSpinner(Context context) {
        super(context);
    }

    public DbSpinner(Context context, int mode) {
        super(context, mode);
        init();
    }

    public DbSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DbSpinner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public DbSpinner(Context context, AttributeSet attrs, int defStyle, int mode) {
        super(context, attrs, defStyle, mode);
        init();
    }

    protected void init() {
        SpinnerAdapter adapter;
        if(isInEditMode()) {
            adapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_spinner_item,
                new String[] { getClass().getSimpleName() + " (Db Spinner)"  }
            );
        } else {
            cursor = initializeCursor();
            adapter = new SimpleCursorAdapter(
                getContext(),
                android.R.layout.simple_spinner_item,
                cursor,
                new String[] { getColumnDisplayed() },
                new int[] { android.R.id.text1 },
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
            );
        }
        setAdapter(adapter);
        setOnItemSelectedListener(new OnDbItemSelectedListener());
    };

    protected class OnDbItemSelectedListener implements OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            cursor.moveToPosition(i);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

    /**
     * Select by ID's data
     * @param id ID's data
     */
    public void select(long id)
    {
        cursor.moveToId(id);
        setSelection(cursor.getPosition());
    }

    /**
     * Initialize cursor
     * @return DbCursor
     */
    protected abstract DbCursor initializeCursor();

    /**
     * Get column to display
     * @return String
     */
    protected abstract String getColumnDisplayed();
}
