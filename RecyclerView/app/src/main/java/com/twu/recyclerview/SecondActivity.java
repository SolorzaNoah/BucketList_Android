package com.twu.recyclerview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.twu.recyclerview.R;

public class SecondActivity extends AppCompatActivity {

    ImageView mainImageView;
    TextView title, description;

    String data1, data2;
    int myImage;

    Button btn;
    EditText et;
    String st;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn =findViewById(R.id.button);
        et =findViewById(R.id.edittext);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SecondActivity.this,MainActivity.class);
                st=et.getText().toString();
                i.putExtra("Value",st);
                startActivity(i);
                finish();
            }
        });


       /*


       ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Second Activity");

        FloatingActionButton fab =(FloatingActionButton) findViewById(R.id.floatAction);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "You Clicked This!", Toast.LENGTH_SHORT).show();

            }
        });

        addTextEdit = (EditText) findViewById(R.id.editText);

        button = (Button) findViewById(R.id.buttonSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFromEditText(addTextEdit.getText().toString());
            }
        });*/







    }

    private void saveFromEditText(String text) {

    }


    private void getData(){
        if(getIntent().hasExtra("data1") ){
            data1 = getIntent().getStringExtra("data1");
            //data2 = getIntent().getStringExtra("data2");
            //myImage = getIntent().getIntExtra("myImage", 1);
        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        title.getEditableText();
        MainActivity ma = new MainActivity();
        ma.addExampleList(data1);
        //description.setText(data2);
        //mainImageView.setImageResource(myImage);
    }
}
