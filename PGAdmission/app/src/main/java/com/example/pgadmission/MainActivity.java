package com.example.pgadmission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    Create Objects
    EditText registrationNumber, name, email;
    RadioGroup radioGroup;
    RadioButton male, female;
    CheckBox mca, msc, mba;
    Spinner state, district, city;
    Button enterBtn;
    TextView registrationNumberView, nameView, emailView, genderView, courseView, stateView, districtView, cityView;
    ConstraintLayout constraintLayout;

    String[] states = {"Andhra Pradesh", "Arunachal Pradesh", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana"};
    String[] districts = {"Anantapur", "Chittoor", "Namsai", "Tirap", "Chachar", "Hojai", "Patna", "Gaya"};
    String[] cities = {"Mumbai", "Delhi", "Chennai", "Kolkata", "Kanpur", "Jaipur"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Initialize Id
        registrationNumber = (EditText) findViewById(R.id.registrationNumber);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        mca = (CheckBox) findViewById(R.id.mca);
        msc = (CheckBox) findViewById(R.id.msc);
        mba = (CheckBox) findViewById(R.id.mba);
        state = (Spinner) findViewById(R.id.state);
        district = (Spinner) findViewById(R.id.district);
        city = (Spinner) findViewById(R.id.city);
        enterBtn = (Button) findViewById(R.id.enterBtn);

//        ArrayAdapter statesArray = new ArrayAdapter(this, android.R.layout.simple_spinner_item, states);
//        statesArray.setDropDownViewResource(android.R.layout.simple_spinner_item);
//        state.setAdapter(statesArray);
//
//        ArrayAdapter districtsArray = new ArrayAdapter(this, android.R.layout.simple_spinner_item, districts);
//        districtsArray.setDropDownViewResource(android.R.layout.simple_spinner_item);
//        district.setAdapter(districtsArray);
//
//        ArrayAdapter citiesArray = new ArrayAdapter(this, android.R.layout.simple_spinner_item, cities);
//        citiesArray.setDropDownViewResource(android.R.layout.simple_spinner_item);
//        city.setAdapter(citiesArray);

        registrationNumberView = (TextView) findViewById(R.id.registrationNumberView);
        nameView = (TextView) findViewById(R.id.nameView);
        emailView = (TextView) findViewById(R.id.emailView);
        genderView = (TextView) findViewById(R.id.genderView);
        courseView = (TextView) findViewById(R.id.courseView);
        stateView = (TextView) findViewById(R.id.stateView);
        districtView = (TextView) findViewById(R.id.districtView);
        cityView = (TextView) findViewById(R.id.cityView);
        constraintLayout = (ConstraintLayout) findViewById(R.id.viewLayout);

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String gender = "";
                String course = "";

                if(male.isChecked())
                    gender = "Male";
                else if(female.isChecked())
                    gender = "Female";

                if (mca.isChecked())
                    course += mca.getText().toString() + ", ";
                if (msc.isChecked())
                    course += msc.getText().toString() + ", ";
                if (mba.isChecked())
                    course += mba.getText().toString() + ", ";

                StringBuffer sb = new StringBuffer(course);
                sb.deleteCharAt(sb.length()-2);

                if (registrationNumber.getText().toString().isEmpty()) {
                    registrationNumber.setError("Please enter registration number.");
                    registrationNumber.requestFocus();
                }
                else if (name.getText().toString().isEmpty()) {
                    name.setError("Please enter name");
                    name.requestFocus();
                }
                else if (email.getText().toString().isEmpty()) {
                    email.setError("Please enter e-mail");
                    email.requestFocus();
                }
//                else if (gender.equals("")) {
//                    male.setError("Please choose gender");
//                    male.requestFocus();
//                }
//                else if (!(mca.isChecked() || mba.isChecked() || msc.isChecked())) {
//                    errorMessage.setText("Please choose preferred course.");
//                    mca.requestFocus();
//                }
//                else {
                    constraintLayout.setVisibility(View.VISIBLE);
                    registrationNumberView.setText(registrationNumber.getText().toString());
                    nameView.setText(name.getText().toString());
                    emailView.setText(email.getText().toString());
                    genderView.setText(gender);
                    courseView.setText(sb);
                    stateView.setText(state.getSelectedItem().toString());
                    districtView.setText(district.getSelectedItem().toString());
                    cityView.setText(city.getSelectedItem().toString());
//                }




                intent.putExtra("Registration_Number", registrationNumber.getText().toString());
                intent.putExtra("Name", name.getText().toString());
                intent.putExtra("Email", email.getText().toString());
                intent.putExtra("Gender", gender);
                intent.putExtra("Course", course);
                intent.putExtra("State", state.getSelectedItem().toString());
                intent.putExtra("District", district.getSelectedItem().toString());
                intent.putExtra("City", city.getSelectedItem().toString());
                startActivity(intent);
            }
        });


    }
}