package com.example.bhaumik.microfinance;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText un, pass;
    Button login;
    SQLiteDatabase mydb = null;
    String otp1;
    static String dbname = "microfinance.db";
    String dbpath = "/data/data/com.example.bhaumik.microfinance/databases/";
    static  String usname,passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        un = (EditText) findViewById(R.id.usernm);
        pass = (EditText) findViewById(R.id.pass);
        login = (Button) findViewById(R.id.login);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=un.getText().toString();
                String passwd=pass.getText().toString();

                if("admin".equals(username)&& "admin".equals(passwd)) {

                    Intent i = new Intent(getApplicationContext(), Home.class);
                    startActivity(i);
                    finish();
                }
                else{

                    Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_LONG).show();
                }


            }
        });

    }




}
