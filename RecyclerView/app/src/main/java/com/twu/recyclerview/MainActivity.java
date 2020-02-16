package com.twu.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;


public class MainActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;
    WordListAdapter mAdapter;
    LinkedList<String> mWordList = new LinkedList<>();

    //TextView tv;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();

        // Create recycler view.
        mRecyclerView = findViewById(R.id.recyclerview);

        mAdapter = new WordListAdapter(this, mWordList);

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Main Activity");

        //tv = findViewById(R.id.textView);
        st = getIntent().getExtras().getString("value");
        //tv.setText(st);

        FloatingActionButton fab =(FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                int wordListSize = mWordList.size();
                mWordList.addLast("+ Word " + st);
                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
                mRecyclerView.smoothScrollToPosition(wordListSize);
            }
        });


    }


    public void createExampleList() {
        mWordList = new LinkedList<>();
        mWordList.add("Basketball");
        mWordList.add("Computer");
        mWordList.add("Game");
        mWordList.add("Grade");
    }

    public void addExampleList(String newWord) {
        mWordList.add(newWord);
    }
}