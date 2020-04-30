package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ApplicantProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant_profile);
    }

    public void performEditProfile(View v){
        Intent intent = new Intent(this, EditProfile.class);
        startActivity(intent);
    }

    public void performViewJobs(View v){
        Intent intent = new Intent(this, jobListingPage.class);
        startActivity(intent);
    }
}
