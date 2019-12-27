package com.example.crimereporting.Data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crimereporting.R;
import com.example.crimereporting.login;

public class Signing extends AppCompatActivity {
    EditText e1,e2,e3;
    Button Signup;
    Databasehelper DB_Helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        e1=findViewById(R.id.name);
        e2=findViewById(R.id.username);
        e3=findViewById((R.id.password));
        Signup=findViewById(R.id.sign);
        DB_Helper =new Databasehelper(this);
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor edit = getSharedPreferences("personal", MODE_PRIVATE).edit();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s1 = e1.getText().toString();
                boolean z = false;
                z = Register(s1, s2, s3);
                if (z == true) {
                    Toast.makeText(getApplicationContext(), "User Registered", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "User not registered", Toast.LENGTH_LONG).show();
                }
            }

        });

    }

    public void Signing(View view) {
    }
    public boolean Register (String name,String email,String password){

        SQLiteDatabase sq =DB_Helper.getWritableDatabase();
        ContentValues co=new ContentValues();
        co.put(ComplaintContract.userTable.NAME,name);
        co.put(ComplaintContract.userTable.E_MAIL,email);
        co.put(ComplaintContract.userTable.PASSWORD,password);

        long x=sq.insert(ComplaintContract.userTable.TABLE_NAME,null,co);

        if(x==-1) {
            return false;
        }
        else{
            return true;
        }
    }

    private View.OnClickListener signup = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent1;
            intent1= new Intent(Signing.this, login.class);
            startActivity(intent1);
        }
    };

    public void signup(View view) {
    }
}
