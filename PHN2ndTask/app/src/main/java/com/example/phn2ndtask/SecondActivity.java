package com.example.phn2ndtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String birdName = extras.getString("birdName");
            Toast.makeText(this, birdName, Toast.LENGTH_SHORT).show();
        }
    }
}