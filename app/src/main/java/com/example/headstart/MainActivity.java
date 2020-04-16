package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Database Firebase = new Database(FirebaseDatabase.getInstance());
        Firebase.databaseTest("TEST MESSAGE");
    }

    public void clickApplicantButton(View v){
        EditText usernameText = findViewById(R.id.usernameText);
        String username = usernameText.getText().toString();

        EditText passwordText = findViewById(R.id.passwordText);
        String password = passwordText.getText().toString();

        if(username.equals("") && password.equals("")){
            performOpenJobListings(v);
        }
    }

    public void performOpenJobListings(View v){
        Intent intent = new Intent(this, jobListingPage.class);
        startActivity(intent);
    }

    public void clickEmployerButton(View v){
        EditText usernameText = findViewById(R.id.usernameText);
        String username = usernameText.getText().toString();

        EditText passwordText = findViewById(R.id.passwordText);
        String password = passwordText.getText().toString();

        if(username.equals("") && password.equals("")){
            performOpenEmployerMainPage(v);
        }
    }

    public void performOpenEmployerMainPage(View v){
        Intent intent = new Intent(this, employerMainPage.class);
        startActivity(intent);
    }
}
