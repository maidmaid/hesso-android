package com.maid.csp.Db;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.provider.BaseColumns;

/**
 * Cursor with utils methods for getting data
 */
public class DbCursor extends CursorWrapper {
    public DbCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Get ID
     */
    public long getId() {
        return getWrappedCursor().getLong(getWrappedCursor().getColumnIndex(BaseColumns._ID));
    }

    /**
     * Get firstname's child
     */
    public String getChildFirstname() {
        return getWrappedCursor().getString(getWrappedCursor().getColumnIndex(DbContract.Child.COLUMN_NAME_FIRSTNAME));
    }

    /**
     * Get ID's child of planning
     */
    public long getPlanningChild() {
        return getWrappedCursor().getLong(getWrappedCursor().getColumnIndex(DbContract.Planning.COLUMN_NAME_CHILD));
    }

    /**
     * Get ID's sport of planning
     */
    public long getPlanningSport() {
        return getWrappedCursor().getLong(getWrappedCursor().getColumnIndex(DbContract.Planning.COLUMN_NAME_SPORT));
    }

    /**
     * Get date's planning
     */
    public String getPlanningDate() {
        return getWrappedCursor().getString(getWrappedCursor().getColumnIndex(DbContract.Planning.COLUMN_NAME_DATE));
    }

    /**
     * Get name's sport
     */
    public String getSportName() {
        return getWrappedCursor().getString(getWrappedCursor().getColumnIndex(DbContract.Sport.COLUMN_NAME_NAME));
    }
}
