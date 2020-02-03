package com.twu.bucketlist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    FloatingActionButton fab =(FloatingActionButton) findViewById(R.id.floatingActionButton);

    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(ButtonActivity.this, "You Clicked This!", Toast.LENGTH_SHORT).show();
        }
    });

  }

}