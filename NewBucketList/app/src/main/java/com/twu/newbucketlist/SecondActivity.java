package com.twu.newbucketlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {

    TextView viewName, viewDescr;
    String data1, data2;
    private EditText editName;
    private EditText editDescr;

    Button btn;
    EditText et;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn =findViewById(R.id.button);
        et =findViewById(R.id.edit_name);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SecondActivity.this,MainActivity.class);
                st=et.getText().toString();
                i.putExtra("Value",st);
                startActivityForResult(i, 1);
                finish();
            }
        });

        editName = (EditText) findViewById(R.id.edit_name);
        editDescr = (EditText) findViewById(R.id.edit_description);

        viewName = findViewById(R.id.edit_name);
        viewDescr = findViewById(R.id.edit_description);

        getData_from_Parent();
        setData_to_Child();

    }

    private void getData_from_Parent(){

        if(getIntent().hasExtra("data1") &&
                getIntent().hasExtra("data2")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
           // myImage = getIntent().getIntExtra("myImage", 1);
        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData_to_Child(){
        viewName.setText(data1);
        viewDescr.setText(data2);
        //Intent mainIntent = new Intent(SecondActivity.this, MainActivity.class);
        //mainIntent.putExtra("bucket_list", mBucketList);
        //startActivity(mainIntent);
    }
    private void setData_to_Parent(){
        String newName = editName.getText().toString();
        String newDesc = editDescr.getText().toString();
    }
}
