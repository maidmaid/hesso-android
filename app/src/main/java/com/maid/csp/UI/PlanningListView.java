package com.maid.csp.UI;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.maid.csp.Db.Db;
import com.maid.csp.Db.DbContract;
import com.maid.csp.Db.DbCursor;
import com.maid.csp.R;

public class PlanningListView extends ListView {
    public DbCursor cursor;
    public CursorAdapter adapter;

    public PlanningListView(Context context) {
        super(context);
        init();
    }

    public PlanningListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PlanningListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        if(isInEditMode()) {
            return;
        }
        cursor = Db.getPlanningsWithSportAndChildren();
        adapter = new SimpleCursorAdapter(
            getContext(),
            R.layout.listview_planning,
            cursor,
            new String[] {
                DbContract.Child.COLUMN_NAME_FIRSTNAME,
                DbContract.Sport.COLUMN_NAME_NAME,
                DbContract.Planning.COLUMN_NAME_DATE
            },
            new int[] {
                R.id.lvp_title,
                R.id.lvp_subtitle,
                R.id.lvp_description
            },
            CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );
        setAdapter(adapter);
    }

    /**
     * Planning item click listener
     */
    public static class OnPlanningItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            PlanningListView plv = (PlanningListView) parent;
            plv.cursor.moveToPosition(position);
        }
    }
}
