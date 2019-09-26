package com.example.bhaumik.microfinance;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class create_user extends AppCompatActivity {

    EditText name,address,phoneno;
    Button next;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myDb = new DatabaseHelper(this);

        name=(EditText)findViewById(R.id.name);
        address=(EditText)findViewById(R.id.add);
        phoneno=(EditText)findViewById(R.id.phno);
        next=(Button)findViewById(R.id.Next);









    }
  /* public void DeleteData() {
        delete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(id.getText().toString());
                        if(deletedRows > 0) {
                            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                            clearall();
                        }
                        else
                            Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void UpdateData() {
        update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean val=validate();
                        if(val==true){
                            boolean isUpdate = myDb.updateData(id.getText().toString(),
                                    name.getText().toString(),
                                    email.getText().toString(),
                                    ftv.getText().toString());
                            if(isUpdate == true){
                                Toast.makeText(MainActivity.this,"Data Update",Toast.LENGTH_LONG).show();
                                clearall();


                            }

                            else

                                Toast.makeText(MainActivity.this,"Data not Updated :Please Enter Valid ID",Toast.LENGTH_LONG).show();
                        }
                        else
                            Toast.makeText(MainActivity.this,"Data not Updated:Please Enter Some Value to be changed",Toast.LENGTH_LONG).show();





                    }
                }
        );
    }*/

    public  void AddData() {
        next.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        boolean val=validation();

                        if(val==true)
                        {
                            boolean isInserted = myDb.insertData(name.getText().toString(),
                                    phoneno.getText().toString(),
                                    address.getText().toString() );
                            if(isInserted == true) {
                                clearall();
                                Toast.makeText(create_user.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            }
                            else
                                Toast.makeText(create_user.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                        }
                        else
                            Toast.makeText(create_user.this,"Data not Inserted",Toast.LENGTH_LONG).show();



                    }
                }
        );
    }








    /*public void viewAll() {
        view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clearall();
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("Email :"+ res.getString(2)+"\n");
                            buffer.append("Favourite TV Show :"+ res.getString(3)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }*/
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void clearall(){
        name.setText("");
        address.setText("");
        phoneno.setText("");



    }
    public boolean validate(){
        if(name.getText().toString().isEmpty() && phoneno.getText().toString().isEmpty()&&address.getText().toString().isEmpty())
        {
            return  false;

        }
        else
            return true;

    }
    public boolean validation(){
        if(name.getText().toString().isEmpty())
        {
            name.setError("Please Enter Name");
            return false;
        }
        else if(phoneno.getText().toString().isEmpty())
        {
            phoneno.setError("Please Enter Email");
            return false;
        }
        else if(address.getText().toString().isEmpty())
        {
            address.setError("Please Enter Tv SHOW");
            return false;

        }



        return  true;
    }






}




