package com.example.phn2ndtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img1, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = findViewById(R.id.birdFruit);
        img2 = findViewById(R.id.tree);
        Bundle b = new Bundle();

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b.putString("birdName", "Gauriya");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b.putString("treeName", "Nariyal");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}