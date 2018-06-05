package com.bbs.mr.employeemanage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Button btnCancel = findViewById(R.id.btnCancelEm);
        Button btnAdd = findViewById(R.id.btnAddEm);
        final EditText txtID = findViewById(R.id.txtID);
        final EditText txtName = findViewById(R.id.txtName);
        final EditText txtBirthday = findViewById(R.id.txtBirthday);
        final EditText txtPhone = findViewById(R.id.txtPhone);
        final EditText txtEmail = findViewById(R.id.txtEmail);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtID.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(getApplicationContext(), "Please input data", Toast.LENGTH_SHORT).show();
                } else {
                    Employee ee = new Employee(txtID.getText().toString(),
                            txtName.getText().toString(),
                            txtBirthday.getText().toString(),
                            txtPhone.getText().toString(), txtEmail.getText().toString());
                    ListActivity.employees.add(ee);
                    Toast.makeText(getApplicationContext(), "Add data complete", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

