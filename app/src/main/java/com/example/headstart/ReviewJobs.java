package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReviewJobs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_jobs);

        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();


        Button test = findViewById(R.id.button3);
        if(currentEmployer.getJobs().size() > 0)
            test.setText(currentEmployer.getJobs().get(0).toString());
    }

    public void performReturnHome(View v){
        Intent intent = new Intent(this, employerMainPage.class);
        startActivity(intent);
    }
}
