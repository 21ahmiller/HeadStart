package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class createProfile extends AppCompatActivity {

    /**
     * Creates page and sets ContentView
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
    }

    /**
     * Brings user to the CreateUser page
     * @param v
     */
    public void performCreateApplicant(View v){
        Intent intent = new Intent(this, CreateUser.class);
        startActivity(intent);
    }

    /**
     * Brings user to the CreateEmployer page
     * @param v
     */
    public void performCreateEmployer(View v){
        Intent intent = new Intent(this, CreateEmployer.class);
        startActivity(intent);
    }
}
