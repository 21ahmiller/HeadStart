package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class jobListingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_listing_page);
    }

    public void performOpenJobApplication(View v){
        Intent intent = new Intent(this, Application.class);
        startActivity(intent);
    }

    public void performOpenFilterMenu(View v){
        Intent intent = new Intent(this, FiltrationMenu.class);
        startActivity(intent);
    }
}
