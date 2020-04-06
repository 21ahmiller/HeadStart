package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickApplicantButton(View v){
        performOpenJobListings(v);
    }

    public void performOpenJobListings(View v){
        Intent intent = new Intent(this, jobListingPage.class);
        startActivity(intent);
    }

    public void clickEmployerButton(View v){
        performOpenEmployerMainPage(v);
    }

    public void performOpenEmployerMainPage(View v){
        Intent intent = new Intent(this, employerMainPage.class);
        startActivity(intent);
    }
}
