package com.twu.newbucketlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    TextView viewName, viewDescr;
    String data1, data2;
    private Toolbar mToolbar;
    private ArrayList<BucketItem> mBucketList;
    private EditText editName;
    private EditText editDescr;
    //private Button saveChanges;

    Button btn;
    EditText et;
    String st;

    public static final String EXTRA_MESSAGE =
            "com.twu.newbucketlist.extra.MESSAGE";

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

//        mToolbar = (Toolbar) findViewById(R.id.edit_toolbar);
//        setSupportActionBar(mToolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editName = (EditText) findViewById(R.id.edit_name);
        editDescr = (EditText) findViewById(R.id.edit_description);
        //saveChanges = (Button) findViewById(R.id.save_changes);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.mBucketList = (ArrayList<BucketItem>) extras.getSerializable("bucket_list");
        }

        viewName = findViewById(R.id.edit_name);
        viewDescr = findViewById(R.id.edit_description);

        Intent intent = getIntent();
        String message =
                intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.title);
        //textView.setText(message);

        getData_from_Parent();
        setData_to_Child();

        /*saveChanges = (Button) findViewById(R.id.save_changes);
        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //saveFromEditText(addTextEdit.getText().toString());
                setData_to_Parent();
            }
        });*/

    }

    public void saveFromEditText(View view) {
        //title.setText(data1);
        //description.setText(data2);
        setData_to_Parent();

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
        //Toast.makeText(this,newName, Toast.LENGTH_SHORT).show();

        final BucketItem bucketItem = new BucketItem(newName,false,newDesc);
        Intent saveIntent = new Intent(SecondActivity.this, MainActivity.class);
        Log.d("SecondActivity","inside setDataToParent");
        saveIntent.putExtra("item",bucketItem);
        setResult(RESULT_OK,saveIntent);
        finish();

        /*
        Bundle extras = new Bundle();
        extras.putString("data1",newName);
        extras.putString("data2",newDesc);
        //extras.putString("data2",newDesc);

        mainIntent.putExtras(extras );

        startActivity(mainIntent);

         */
    }
}
