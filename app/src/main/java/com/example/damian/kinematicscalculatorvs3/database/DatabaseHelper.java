package com.example.damian.kinematicscalculatorvs3.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.damian.kinematicscalculatorvs3.models.JoinListViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damian on 2016-05-27.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "join";
    private static final String DB_TODO_TABLE = "kienematicsSimple";

    public static final String KEY_ID = "_id";
    public static final String KEY_ALPHA = "ALPHA";
    public static final String KEY_A = "_A";
    public static final String KEY_THETA = "THETA";
    public static final String KEY_D = "_D";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = " CREATE TABLE " + DB_TODO_TABLE + "("
                + KEY_ID + " integer primary key autoincrement, "
                + KEY_ALPHA + " TEXT NOT NULL, "
                + KEY_A + " TEXT NOT NULL, "
                + KEY_THETA + " TEXT NOT NULL, "
                + KEY_D + " TEXT NOT NULL " + ");";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DB_TODO_TABLE);
        onCreate(db);
    }

    // Adding new rubber
    public void addJoin(JoinListViewModel joinListViewModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ALPHA, joinListViewModel.getEt_alpha());
        values.put(KEY_A, joinListViewModel.getEt_a());
        values.put(KEY_THETA, joinListViewModel.getEt_theta());
        values.put(KEY_D, joinListViewModel.getEt_d());

        db.insert(DB_TODO_TABLE, null, values);
        db.close(); // Closing database connection
    }

    // Getting single rubber
    public JoinListViewModel getJoin(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DB_TODO_TABLE, new String[]{KEY_ID,
                        KEY_ALPHA, KEY_A, KEY_THETA, KEY_D}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        JoinListViewModel joinListViewModel = new JoinListViewModel();
        joinListViewModel.setTv_lp(Integer.getInteger(cursor.getString(0)));
        joinListViewModel.setEt_alpha(Integer.parseInt(cursor.getString(1)));
        joinListViewModel.setEt_a(Integer.parseInt(cursor.getString(2)));
        joinListViewModel.setEt_theta(Integer.parseInt(cursor.getString(3)));
        joinListViewModel.setEt_d(Integer.parseInt(cursor.getString(4)));

        return joinListViewModel;
    }

    // Getting All rubber
    public ArrayList<JoinListViewModel> gerAllJoin() {
        ArrayList<JoinListViewModel> joinListViewModels = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + DB_TODO_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                JoinListViewModel joinListViewModel = new JoinListViewModel();
                joinListViewModel.setTv_lp(Integer.getInteger(cursor.getString(0)));
                joinListViewModel.setEt_alpha(Integer.parseInt(cursor.getString(1)));
                joinListViewModel.setEt_a(Integer.parseInt(cursor.getString(2)));
                joinListViewModel.setEt_theta(Integer.parseInt(cursor.getString(3)));
                joinListViewModel.setEt_d(Integer.parseInt(cursor.getString(4)));
                joinListViewModels.add(joinListViewModel);
            } while (cursor.moveToNext());
        }

        return joinListViewModels;
    }

    public boolean updateJoin(JoinListViewModel joinListViewModel) {
        long id = joinListViewModel.getTv_lp();

        int et_alpha = joinListViewModel.getEt_alpha();
        int et_a = joinListViewModel.getEt_a();
        int et_theta = joinListViewModel.getEt_theta();
        int et_d = joinListViewModel.getEt_d();

        return updateJoin(id, et_alpha, et_a, et_theta, et_d);
    }

    public boolean updateJoin(long id, int et_alpha, int et_a, int et_theta, int et_d) {
        String where = KEY_ID + "=" + id;

        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues updateTodoValues = new ContentValues();
        updateTodoValues.put(KEY_ALPHA, et_alpha);
        updateTodoValues.put(KEY_A, et_a);
        updateTodoValues.put(KEY_THETA, et_theta);
        updateTodoValues.put(KEY_D, et_d);

        return db.update(DB_TODO_TABLE, updateTodoValues, where, null) > 0;
    }

}

