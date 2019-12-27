package com.example.crimereporting.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.crimereporting.ComplainDatabasehelper;

public class Databasehelper extends SQLiteOpenHelper {
    public static final String DB_NAME="CrimeReport";
//    public static final String TABLE_NAME="users";
//    public static final String Col_2="Email_ID";
//    public static final String Col_3="Password";
//    public static final String Col_4="Name";
    private Databasehelper DB_Helper;


    // package declaration left out, use your application package
    private static final String SQL_CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS " + ComplaintContract.userTable.TABLE_NAME + " ("
            + ComplaintContract.userTable.NAME + "TEXT NOT NULL, "
            + ComplaintContract.userTable.E_MAIL + "TEXT PRIMARY KEY, "
            + ComplaintContract.userTable.PASSWORD + "TEXT );";
    //public final String LOG2 = "Create table complain(ID integer primary key AUTOINCREMENT, Email_ID varchar ,Victim_name text,Police_station text,Crime_Type varchar,Describe_the_crime text)";
    private static final String SQL_CREATE_COMPLAIN_TABLE = "CREATE TABLE IF NOT EXISTS " + ComplaintContract.complainTable.TABLE_NAME + " ("
            + ComplaintContract.complainTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ComplaintContract.complainTable.VICTIM_NAME + "TEXT NOT NULL, "
            + ComplaintContract.complainTable.E_MAIL + "TEXT NOT NULL, "
            + ComplaintContract.complainTable.CRIME_TYPE +"TEXT NOT NULL, "
            + ComplaintContract.complainTable.POLICE_STATION +"TEXT NOT NULL, "
            + ComplaintContract.complainTable.DESCRIPTION + "TEXT NOT NULL  );";
            public Databasehelper(Context context) {
        super(context, DB_NAME, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        arg0.execSQL(SQL_CREATE_USER_TABLE);
        arg0.execSQL(SQL_CREATE_COMPLAIN_TABLE);
      //  arg0.execSQL(LOG2);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

//    public String login(String email_id,String up){
//        SQLiteDatabase sq=DB_Helper.getReadableDatabase();
//        Cursor cu=sq.rawQuery("select*from " + ComplaintContract.userTable.TABLE_NAME + " where "
//                + ComplaintContract.userTable.E_MAIL + " = " + email_id + "and" + ComplaintContract.userTable.PASSWORD+ " = " + up ,null);
//        if(cu.getCount()<1){
//            cu.close();
//            return "user not exist";
//
//        }
//
//        //Log.v(LOG,Integer.toString(cu.getColumnIndex("Password")));
//        cu.moveToFirst();
//        String x=cu.getString(cu.getColumnIndex("Password"));
//        cu.close();
//        sq.close();
//        return x;
//    }


    }

