package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class employerMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_main_page);
    }

    public void performOpenNewJob(View v){
        Intent intent = new Intent(this, NewJob.class);
        startActivity(intent);
    }

    public void performReviewJobs(View v){
        Intent intent = new Intent(this, ReviewJobs.class);
        startActivity(intent);
    }

    public void performEditProfile(View v){
        Intent intent = new Intent(this, EditEmployer.class);
        startActivity(intent);
    }
}
