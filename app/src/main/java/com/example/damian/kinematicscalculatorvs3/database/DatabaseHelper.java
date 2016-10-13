package com.example.damian.kinematicscalculatorvs3.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damian on 2016-05-27.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "database";
    private static final String DB_TODO_TABLE = "points";

    public static final String KEY_ID = "_id";
    public static final String KEY_XAXIS = "X_AXIS";
    public static final String KEY_YAXIS = "Y_AXIS";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + DB_TODO_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_XAXIS + " X_Axis,"
                + KEY_YAXIS + " Y_Axis" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DB_TODO_TABLE);
        onCreate(db);
    }

    // Adding new rubber
    public void addRubber(Rubber rubber) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_XAXIS, rubber.getX_axis()); // Contact Name
        values.put(KEY_YAXIS, rubber.getY_axis()); // Contact Phone Number

        db.insert(DB_TODO_TABLE, null, values);
        db.close(); // Closing database connection
    }

    // Getting single rubber
    public Rubber getRubber(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DB_TODO_TABLE, new String[]{KEY_ID,
                        KEY_XAXIS, KEY_YAXIS}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Rubber rubber = new Rubber(Integer.parseInt(cursor.getString(0)), Float.parseFloat(cursor.getString(1)), Float.parseFloat(cursor.getString(2)));
        return rubber;
    }

    // Getting All rubber
    public List<Rubber> getAllRubbers() {
        List<Rubber> rubberlist = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + DB_TODO_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Rubber rubber = new Rubber();
                rubber.set_id(Integer.parseInt(cursor.getString(0)));
                rubber.setX_axis(Float.parseFloat(cursor.getString(1)));
                rubber.setY_axis(Float.parseFloat(cursor.getString(2)));
                rubberlist.add(rubber);
            } while (cursor.moveToNext());
        }

        return rubberlist;
    }

}

