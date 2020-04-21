package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateEmployer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_employer);
    }

    public void performCreateEmployer(View v){
        EditText emailText = findViewById(R.id.companyEmailText);
        String email = emailText.getText().toString();

        EditText passwordText = findViewById(R.id.companyPasswordText);
        String password = passwordText.getText().toString();

        EditText usernameText = findViewById(R.id.companyNameText);
        String displayName = usernameText.getText().toString();

        User applicant = new User(email, password, displayName);
        Intent intent = new Intent(this, employerMainPage.class);
        startActivity(intent);
    }
}
