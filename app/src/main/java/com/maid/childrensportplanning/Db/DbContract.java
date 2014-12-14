package com.maid.childrensportplanning.Db;

import android.provider.BaseColumns;

/**
 * Contract of database
 */
public class DbContract {
    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "database.sqlite";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    /**
     * Children table definition
     */
    public static abstract class Child implements BaseColumns {
        public static final String TABLE_NAME = "child";
        public static final String COLUMN_NAME_FIRSTNAME = "firstname";
        public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_NAME_FIRSTNAME + TEXT_TYPE +
            ")";
        public static final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    /**
     * Sport table definition
     */
    public static abstract class Sport implements BaseColumns {
        public static final String TABLE_NAME = "sport";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_NAME_NAME + TEXT_TYPE +
            ")";
        public static final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    /**
     * Planning table definition
     */
    public static abstract class Planning implements BaseColumns {
        public static final String TABLE_NAME = "planning";
        public static final String COLUMN_NAME_CHILDREN = "id_children";
        public static final String COLUMN_NAME_SPORT = "id_sport";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_NAME_CHILDREN + INTEGER_TYPE + COMMA_SEP +
                    COLUMN_NAME_SPORT + INTEGER_TYPE + COMMA_SEP +
                    COLUMN_NAME_DATE + TEXT_TYPE +
            ")";
        public static final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        public static final String SQL_JOIN_SPORT =
            "INNER JOIN " + Sport.TABLE_NAME + " s " +
                " ON s." + Sport._ID + " = " + COLUMN_NAME_SPORT;
        public static final String SQL_JOIN_CHILDREN =
            "INNER JOIN " + Child.TABLE_NAME + " c " +
                " ON c." + Child._ID + " = " + COLUMN_NAME_CHILDREN;
    }
}
