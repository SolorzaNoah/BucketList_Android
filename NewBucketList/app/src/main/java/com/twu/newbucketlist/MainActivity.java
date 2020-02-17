package com.twu.newbucketlist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    TextView tv;
    String st;

    private Toolbar mToolbar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    ArrayList<BucketItem> mBucketList;
    private int currentPos;
    //private String newS1, newS2;

    public static final String EXTRA_MESSAGE =
            "com.twu.newbucketlist.extra.MESSAGE";


    String  s2[];
    LinkedList<String> s1;
    LinkedList<Boolean> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = new LinkedList<String>();
        s1.add("Baseball");
        s1.add("Computer");
        s1.add("Game");
        s1.add("Grade");

        images = new LinkedList<Boolean>();
        images.add(false);
        images.add(false);
        images.add(false);
        images.add(false);

        //getResources().getStringArray(R.array.list_items);
        s2 = getResources().getStringArray(R.array.description);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Main Activity");

        //tv = findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            st = bundle.getString("Value");
            s1.add("+ Word " + st);
            int wordListSize = s1.size();
            //mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
            //mRecyclerView.smoothScrollToPosition(wordListSize);
        }
        //tv.setText(st);

        FloatingActionButton fab =(FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                int wordListSize = s1.size();
                s1.addLast("+ Word " + st);
                //mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
                //mRecyclerView.smoothScrollToPosition(wordListSize);
            }
        });

    }
}


