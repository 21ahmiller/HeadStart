package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewJob extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_job);
    }

    public void onClickSubmit(View v){
        EditText jobNameText = findViewById(R.id.jobNameText);
        String jobTitle = jobNameText.getText().toString();

        EditText jobInformationText = findViewById(R.id.jobInformationText);
        String jobInformation = jobInformationText.getText().toString();

        EditText locationText = findViewById(R.id.locationText);
        String location = locationText.getText().toString();

        EditText requirementsText = findViewById(R.id.requirementsText);
        String requirements = requirementsText.getText().toString();

        EditText preferredSkillsText = findViewById(R.id.preferredSkillsText);
        String preferredSkills = preferredSkillsText.getText().toString();

        EditText scheduleText = findViewById(R.id.scheduleText);
        String schedule = scheduleText.getText().toString();

        EditText salaryText = findViewById(R.id.salaryText);
        String salary = salaryText.getText().toString();

        EditText benefitsText = findViewById(R.id.benefitsText);
        String benefits = benefitsText.getText().toString();

        EditText jobTypeText = findViewById(R.id.jobTypeText);
        String jobType = jobTypeText.getText().toString();

        Job job = new Job(jobTitle, jobType, jobInformation, location, requirements, preferredSkills, schedule, salary, benefits);

        Intent intent = new Intent(this, employerMainPage.class);
        startActivity(intent);
    }
}
