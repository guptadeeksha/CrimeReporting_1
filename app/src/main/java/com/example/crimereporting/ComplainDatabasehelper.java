package com.example.crimereporting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.crimereporting.Data.ComplaintContract;
import com.example.crimereporting.Data.Databasehelper;

public class ComplainDatabasehelper {
    public static final String DB_NAME = "CrimeReport";
//    public static final String TABLE_NAME = "complain";
//    public static final String Col_5 = "Email_ID";
//    public static final String Col_1 = "Victim_name";
//    public static final String Col_2 = "Police_station";
//    public static final String Col_3 = "Crime_Type";
//    public static final String Col_4 = "Describe_the_crime";
    public Databasehelper DB_Helper;

//    public final String SQL_CREATE_COMPLAIN_TABLE = "CREATE TABLE IF NOT EXISTS " + ComplaintContract.complainTable.TABLE_NAME + " ("
//            + ComplaintContract.complainTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//            + ComplaintContract.complainTable.VICTIM_NAME + "TEXT NOT NULL, "
//            + ComplaintContract.complainTable.E_MAIL + "TEXT NOT NULL, "
//            + ComplaintContract.complainTable.CRIME_TYPE +"TEXT NOT NULL, "
//            + ComplaintContract.complainTable.POLICE_STATION +"TEXT NOT NULL, "
//            + ComplaintContract.complainTable.DESCRIPTION + "TEXT NOT NULL  );";

    //public final String LOG = "Create table TABLE_NAME(ID integer primary key AUTOINCREMENT, Email_ID text ,Victim_name text,Police_station text,Crime_Type text,Describe_the_crime text)";

//
   //public ComplainDatabasehelper(Context context) {
   //super(context, DB_NAME, null, 1);
 }
//
  // @Override
// public void onCreate(SQLiteDatabase arg0) {
        //Log.v("ComplainDatabasehelper", "YAhi HAi!");
        //arg0.execSQL(SQL_CREATE_COMPLAIN_TABLE);
  // }

//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//
//    }

//
//
//    public Cursor ViewData() {
//        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
//        Cursor cursor = sqLiteDatabase.rawQuery("select*from " + ComplaintContract.complainTable.TABLE_NAME, null);
//        return cursor;
//    }
//    public String check(String email_id) {
//        SQLiteDatabase sq = this.getWritableDatabase();
//        String x;
//        Cursor cu = sq.rawQuery("select*from complain where Email_ID='" + email_id+"'", null);
//        if (cu.getCount() < 1) {
//            cu.close();
//            return "user does not exist";
//
//        }
//        else {
//            cu.moveToFirst();
//            do {
//                x = cu.getString(cu.getColumnIndex("Email_ID"));
//
//            } while (cu.moveToNext());
//            cu.close();
//            sq.close();
//
//            return x;
//        }
//
//    }
//
//
//}
