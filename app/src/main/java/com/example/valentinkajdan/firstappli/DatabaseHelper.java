package com.example.valentinkajdan.firstappli;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by valentinkajdan on 17/03/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private final String CREATE_TABLE =
            "CREATE TABLE post (" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "TYPE TEXT," +
                    "SLUG TEXT," +
                    "URL TEXT," +
                    "TITLE TEXT" +
                    "TITLE_PLAIN TEXT," +
                    "CONTENT TEXT," +
                    "EXCERPT TEXT," +
                    "DATE TEXT," +
                    "MODIFIED TEXT," +
                    "CATEGORY TEXT," +
                    "TAGS TEXT," +
                    "AUTHOR TEXT);";

    private static final String DB_NAME = "database.db";
    private static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
