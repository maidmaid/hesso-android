package com.maid.csp.UI;

import android.content.Context;
import android.util.AttributeSet;

import com.maid.csp.Db.Db;
import com.maid.csp.Db.DbContract;
import com.maid.csp.Db.DbCursor;
import com.maid.csp.UI.Base.DbSpinner;

public class SportSpinner extends DbSpinner {
    public SportSpinner(Context context) {
        super(context);
    }

    public SportSpinner(Context context, int mode) {
        super(context, mode);
    }

    public SportSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SportSpinner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SportSpinner(Context context, AttributeSet attrs, int defStyle, int mode) {
        super(context, attrs, defStyle, mode);
    }

    @Override
    protected DbCursor initializeCursor() {
        return Db.getSports();
    }

    @Override
    protected String getColumnDisplayed() {
        return DbContract.Sport.COLUMN_NAME_NAME;
    }
}
