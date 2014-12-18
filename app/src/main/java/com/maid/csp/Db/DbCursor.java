package com.maid.csp.Db;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.provider.BaseColumns;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
     * Get date's planning as formatted string (yyyy-MM-dd HH:mm)
     */
    public String getPlanningDateAsFormattedString() {
        String date = getPlanningDate();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String formatted = formatter.format(date);
        return formatted;
    }

    /**
     * Get date's planning as Calendar object
     */
    public Calendar getPlanningDateAsCalendar() {
        String date = getPlanningDate();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(formatter.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return calendar;
    }

    /**
     * Get name's sport
     */
    public String getSportName() {
        return getWrappedCursor().getString(getWrappedCursor().getColumnIndex(DbContract.Sport.COLUMN_NAME_NAME));
    }

    /**
     * Move to ID
     * @param id
     * @param column
     */
    public void moveToId(long id, String column) {
        moveToFirst();
        while(getLong(getColumnIndex(column)) != id && !isLast()) {
            moveToNext();
        }
    }

    /**
     * Move to ID
     * @param id
     */
    public void moveToId(long id) {
        moveToId(id, BaseColumns._ID);
    }
}
