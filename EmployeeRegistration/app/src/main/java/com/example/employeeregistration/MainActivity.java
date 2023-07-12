package com.example.employeeregistration;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText empId, name, age, salary;
    Spinner department;
    Button saveBtn, viewBtn;
    String[] department_array = {"Select", "BCA", "B.Tech", "BBA", "BSC", "MCA", "M.Tech", "MBA", "MSC"};

    DBHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empId = (EditText) findViewById(R.id.empId);
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        department = (Spinner) findViewById(R.id.department);
        salary = (EditText) findViewById(R.id.salary);
        saveBtn = (Button) findViewById(R.id.saveBtn);
        viewBtn = (Button) findViewById(R.id.viewBtn);

        ArrayAdapter department_element = new ArrayAdapter(this, android.R.layout.simple_spinner_item, department_array);
        department_element.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        department.setAdapter(department_element);

        dbHelper = new DBHelper(MainActivity.this);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String empIdText = empId.getText().toString();
                String nameText = name.getText().toString();
                String ageText = age.getText().toString();
                String departmentText = department.getSelectedItem().toString();
                String salaryText = salary.getText().toString();

                if (empIdText.isEmpty() || nameText.isEmpty() || ageText.isEmpty() || salaryText.isEmpty() || departmentText.equals("Select")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("Error Message");
                    builder.setMessage("Please fill all data.");
                    builder.show();
                }
                else{
                    Boolean save = dbHelper.inserData(empIdText, nameText, ageText, departmentText, salaryText);
                    if(save == true) {
                        Toast.makeText(MainActivity.this, "Insertion Successful...", Toast.LENGTH_SHORT).show();
                        empId.setText("");
                        name.setText("");
                        age.setText("");
                        department.setAdapter(department_element);
                        salary.setText("");
                        empId.requestFocus();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Insertion Unsuccessful...", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = dbHelper.viewData();
                if (cursor.getCount() == 0){
                    Toast.makeText(MainActivity.this, "No data exists...", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    StringBuffer buffer = new StringBuffer();
                    while (cursor.moveToNext()){
                        buffer.append("EmpId : " + cursor.getString(0) + "\n");
                        buffer.append("Name : " + cursor.getString(1) + "\n");
                        buffer.append("Age : " + cursor.getString(2) + "\n");
                        buffer.append("Department : " + cursor.getString(3) + "\n");
                        buffer.append("Salary : " + cursor.getString(4) + "\n\n");
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("Employee Details");
                    builder.setMessage(buffer);
                    builder.show();
                }

            }
        });

    }
}