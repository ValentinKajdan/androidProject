package com.example.valentinkajdan.firstappli;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by valentinkajdan on 17/03/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private final String CREATE_TABLE =
            "CREATE TABLE table (" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "MESSAGE TEXT);";

    private final String DB_NAME = "database.db";
    private final int DB_VERSION = 1;
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
