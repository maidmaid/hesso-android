package com.maid.csp.UI;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.maid.csp.Db.Db;
import com.maid.csp.Db.DbContract;
import com.maid.csp.Db.DbCursor;
import com.maid.csp.R;

public abstract class DbListView extends ListView {
    public DbCursor cursor;
    public ListAdapter adapter;

    public DbListView(Context context) {
        super(context);
        init();
    }

    public DbListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DbListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        if(isInEditMode()) {
            adapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_spinner_item,
                new String[] { getClass().getSimpleName() + " (DbListView)"  }
            );
        } else {
            cursor = Db.getPlanningsWithSportAndChildren();
            adapter = new SimpleCursorAdapter(
                    getContext(),
                getLayout(),
                cursor,
                getColumns(),
                getViews(),
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
            );
        }
        setAdapter(adapter);
    }

    public abstract int getLayout();
    public abstract int[] getViews();
    public abstract String[] getColumns();

    /**
     * Planning item click listener
     */
    public static class OnDbItemClickListener implements OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            DbListView plv = (DbListView) parent;
            plv.cursor.moveToPosition(position);
        }
    }
}
