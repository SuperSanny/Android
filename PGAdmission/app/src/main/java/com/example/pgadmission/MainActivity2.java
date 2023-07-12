package com.example.pgadmission;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    TextView registrationNumber1, name1, email1, gender1, course, state, district, city;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        registrationNumber1 = (TextView) findViewById(R.id.registrationNumber1);
        name1 = (TextView) findViewById(R.id.name1);
        email1 = (TextView) findViewById(R.id.email1);
        gender1 = (TextView) findViewById(R.id.gender1);
        course = (TextView) findViewById(R.id.preferredCourse1);
        state = (TextView) findViewById(R.id.state1);
        district = (TextView) findViewById(R.id.district1);
        city = (TextView) findViewById(R.id.city1);

        Intent intent = getIntent();

        registrationNumber1.setText(intent.getStringExtra("Registration_Number"));
        name1.setText(intent.getStringExtra("Name"));
        email1.setText(intent.getStringExtra("Email"));
        gender1.setText(intent.getStringExtra("Gender"));
        course.setText(intent.getStringExtra("Course"));
        state.setText(intent.getStringExtra("State"));
        district.setText(intent.getStringExtra("District"));
        city.setText(intent.getStringExtra("City"));


    }
}