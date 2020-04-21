package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
    }

    public void performCreateApplicant(View v){
        EditText emailText = findViewById(R.id.emailText);
        String email = emailText.getText().toString();

        EditText passwordText = findViewById(R.id.passwordText);
        String password = passwordText.getText().toString();

        EditText usernameText = findViewById(R.id.usernameText);
        String displayName = usernameText.getText().toString();

        User applicant = new User(email, password, displayName);
        Intent intent = new Intent(this, jobListingPage.class);
        startActivity(intent);
    }
}
