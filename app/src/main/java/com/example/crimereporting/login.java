package com.example.crimereporting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crimereporting.Data.ComplaintContract;
import com.example.crimereporting.Data.Databasehelper;

public class login extends AppCompatActivity {
TextView t1,t2;
EditText e1,e2;
Databasehelper DB_Helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=findViewById(R.id.user);
        e2=findViewById(R.id.password);
        final Button Login = findViewById(R.id.login);
        DB_Helper=new Databasehelper(this);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                SharedPreferences pref = getSharedPreferences("personal", MODE_PRIVATE);
                String user=pref.getString("username","No name defined");
                String pass=pref.getString("password","No name");
                String z = login(s1, s2);
                if (s2.equals(z)) {
                    Toast.makeText(getApplicationContext(), "Login succesful", Toast.LENGTH_LONG).show();
                    logging.onClick(Login);
                } else {
                    Toast.makeText(getApplicationContext(), "User not registered", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void logging(View view) {
    }
    public String login(String email_id,String up){

        SQLiteDatabase sq=DB_Helper.getReadableDatabase();
        Cursor cu=sq.rawQuery("select*from " + ComplaintContract.userTable.TABLE_NAME + " where "
                + ComplaintContract.userTable.E_MAIL + " = " + email_id + "and" + ComplaintContract.userTable.PASSWORD+ " = " + up ,null);
        if(cu.getCount()<1){
            cu.close();
            return "user not exist";

        }

        //Log.v(LOG,Integer.toString(cu.getColumnIndex("Password")));
        cu.moveToFirst();
        String x=cu.getString(cu.getColumnIndex("Password"));
        cu.close();
        sq.close();
        return x;
    }


    private View.OnClickListener logging= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent1;
            intent1 =new Intent(login.this, Middle.class);
            startActivity(intent1);
        }
    };


}
