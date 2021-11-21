package com.example.basicbankingsystem.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserContract.UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


// Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserContract.UserEntry.TABLE_NAME + " ("
                + UserContract.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserContract.UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserContract.UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserContract.UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserContract.UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserContract.UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values('1010005678','Ajay ', 'ajay@gmail.com','BANK0001','7895641238', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values('1010001234','Balaji', 'balaji@gmail.com','BANK0001','8995641238', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values('1010009012','Surya ', 'surya@gmail.com','BANK0001','7595645896', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values('1010003456','Ganya', 'ganya@gmail.com','BANK0001','9995640038', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values('1010007890','Nitin ', 'nitin@gmail.com','BANK0001','9095648962', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values('1010001357','Sai', 'sai@gmail.com','BANK0001','8855640238', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values('1010002468','Varun', 'varun@gmail.com','BANK0001','8895640215', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values('1010003692','Mustakim ', 'mustakim@gmail.com','BANK0001','9985021539', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values('1010004826','Rahul', 'rahul@gmail.com','BANK0001','9309565238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values('1010005050','Jackson', 'jackson@gmail.com','BANK0001','8292591201', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values('1010006284','Prafful', 'prafful@gmail.com','BANK0001','9015641200', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values('1010007417','Lakhan', 'lakhan@gmail.com','BANK0001','9995641999', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values('1010008642','Sandy', 'sandy@gmail.com','BANK0001','9119541001', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values('1010009876','Venu', 'venu@gmail.com','BANK0001','6254642205', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values('1010000234','Teja', 'teja@gmail.com','BANK0001','6893641266', 1010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserContract.UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserContract.UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserContract.UserEntry.TABLE_NAME + " where " +
                UserContract.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserContract.UserEntry.TABLE_NAME + " set " + UserContract.UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserContract.UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}