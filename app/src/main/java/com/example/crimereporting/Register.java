package com.example.crimereporting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crimereporting.Data.ComplaintContract;
import com.example.crimereporting.Data.Databasehelper;

public class Register extends AppCompatActivity {
TextView t1,t2,t3,t4,t5;
Button Sub;
Databasehelper DB_Helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        t1=findViewById(R.id.name);
        t2=findViewById(R.id.police);
        t3=findViewById(R.id.crime);
        t4=findViewById(R.id.desc);
        t5=findViewById(R.id.email);
        Sub = findViewById(R.id.submit);
        DB_Helper=new Databasehelper(this);
        Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SharedPreferences.Editor edit = getSharedPreferences("personal", MODE_PRIVATE).edit();
                String s1=t1.getText().toString();
                String s2=t2.getText().toString();
                String s3=t3.getText().toString();
                String s4=t4.getText().toString();
                String s5=t5.getText().toString();
                boolean z=false;
                 z=Register(s1,s2, s3, s4, s5);
                 if(z==true) {
                     Toast.makeText(getApplicationContext(), "Complain Registered", Toast.LENGTH_LONG).show();
                     fnsubmit.onClick(Sub);


                 }
                 else{
                     Toast.makeText(getApplicationContext(),"Complain not registered",Toast.LENGTH_LONG).show();
                 }

            }
        });
    }

    public void Register(View view) {
    }
    public boolean Register(String Victim_name, String Police_station, String Crime_type, String Describe_the_crime, String Email_ID) {
        SQLiteDatabase sq = DB_Helper.getWritableDatabase();
        ContentValues co = new ContentValues();
        co.put(ComplaintContract.complainTable.VICTIM_NAME, Victim_name);
        co.put(ComplaintContract.complainTable.POLICE_STATION, Police_station);
        co.put(ComplaintContract.complainTable.CRIME_TYPE, Crime_type);
        co.put(ComplaintContract.complainTable.DESCRIPTION, Describe_the_crime);
        co.put(ComplaintContract.complainTable.E_MAIL, Email_ID);


        long x = sq.insert(ComplaintContract.complainTable.TABLE_NAME, null, co);
        sq.close();
        if (x == -1) {
            return false;
        } else {
            return true;
        }
    }

    private View.OnClickListener fnsubmit= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent1;

            intent1 =new Intent(Register.this, Middle.class);
            startActivity(intent1);
        }
    };
}
