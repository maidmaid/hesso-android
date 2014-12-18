package com.maid.csp.UI;

import android.content.Context;
import android.util.AttributeSet;

import com.maid.csp.Db.Db;
import com.maid.csp.Db.DbContract;
import com.maid.csp.Db.DbCursor;
import com.maid.csp.UI.Base.DbSpinner;

public class ChildSpinner extends DbSpinner {
    public ChildSpinner(Context context) {
        super(context);
    }

    public ChildSpinner(Context context, int mode) {
        super(context, mode);
    }

    public ChildSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChildSpinner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ChildSpinner(Context context, AttributeSet attrs, int defStyle, int mode) {
        super(context, attrs, defStyle, mode);
    }

    @Override
    protected DbCursor initializeCursor() {
        return Db.getChildren();
    }

    @Override
    protected String getColumnDisplayed() {
        return DbContract.Child.COLUMN_NAME_FIRSTNAME;
    }
}
