package com.maid.csp.UI;

import android.content.Context;
import android.util.AttributeSet;

import com.maid.csp.Db.Db;
import com.maid.csp.Db.DbContract;
import com.maid.csp.Db.DbCursor;
import com.maid.csp.UI.Base.DbListView;

public class ChildListView extends DbListView {
    public ChildListView(Context context) {
        super(context);
    }

    public ChildListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChildListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public DbCursor initializeCursor() {
        return Db.getChildren();
    }

    @Override
    public int getLayout() {
        return android.R.layout.simple_list_item_1;
    }

    @Override
    public int[] getViews() {
        return new int[] { android.R.id.text1 };
    }

    @Override
    public String[] getColumns() {
        return new String[] { DbContract.Child.COLUMN_NAME_FIRSTNAME };
    }
}
