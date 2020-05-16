package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class FiltrationMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtration_menu);
    }

    public void resetFilters(View v){
        EditText typeAgeText = findViewById(R.id.TypeAgeText);
        typeAgeText.setText("");

        SeekBar maxDriveBar = findViewById(R.id.MaxDriveBar);
        maxDriveBar.setProgress(0);

        SeekBar minPayBar = findViewById(R.id.MinPayBar);
        minPayBar.setProgress(0);

        RadioButton highSchoolStudentButton = findViewById(R.id.CurrentHS);
        highSchoolStudentButton.setChecked(false);

        RadioButton highSchoolGradButton = findViewById(R.id.HSGrad);
        highSchoolGradButton.setChecked(false);

        RadioButton collegeStudentButton = findViewById(R.id.CollegeStd);
        collegeStudentButton.setChecked(false);

        RadioButton collegeGradButton = findViewById(R.id.CollegeGrad);
        collegeGradButton.setChecked(false);

        RadioButton fullTimeButton = findViewById(R.id.FullTime);
        fullTimeButton.setChecked(false);

        RadioButton partTimeButton = findViewById(R.id.PartTime);
        partTimeButton.setChecked(false);

        RadioButton internshipButton = findViewById(R.id.Internship);
        internshipButton.setChecked(false);

        RadioButton coOpButton = findViewById(R.id.Coop);
        coOpButton.setChecked(false);

        EditText enterKeywordText = findViewById(R.id.EnterKeywords);
        enterKeywordText.setText("");

        EditText stateText = findViewById(R.id.StateText);
        stateText.setText("");

    }

    public void applyFilters(View v){

        EditText typeAgeText = findViewById(R.id.TypeAgeText);
        String age = typeAgeText.getText().toString();

        EditText stateText = findViewById(R.id.StateText);
        String state = stateText.getText().toString();

        SeekBar maxDriveBar = findViewById(R.id.MaxDriveBar);
        int distance = 2 * maxDriveBar.getProgress();

        SeekBar minPayBar = findViewById(R.id.MinPayBar);
        int minPay = 10 + 2 * minPayBar.getProgress();

        String school = "";
        RadioButton highSchoolStudentButton = findViewById(R.id.CurrentHS);
        if(highSchoolStudentButton.isChecked()){
            school = "High School";
        }
        RadioButton highSchoolGradButton = findViewById(R.id.HSGrad);
        if(highSchoolGradButton.isChecked()){
            school = "High School Graduate";
        }
        RadioButton collegeStudentButton = findViewById(R.id.CollegeStd);
        if(collegeStudentButton.isChecked()){
            school = "College";
        }
        RadioButton collegeGradButton = findViewById(R.id.CollegeGrad);
        if(collegeGradButton.isChecked()){
            school = "College Graduate";
        }
        String jobType = "";
        RadioButton fullTimeButton = findViewById(R.id.FullTime);
        if(fullTimeButton.isChecked()){
            jobType = "Full Time";
        }
        RadioButton partTimeButton = findViewById(R.id.PartTime);
        if(partTimeButton.isChecked()){
            jobType = "Part Time";
        }
        RadioButton internshipButton = findViewById(R.id.Internship);
        if(internshipButton.isChecked()){
            jobType = "Internship";
        }
        RadioButton coOpButton = findViewById(R.id.Coop);
        if(coOpButton.isChecked()){
            jobType = "Co-Op";
        }

        EditText enterKeywordText = findViewById(R.id.EnterKeywords);
        String keywords = enterKeywordText.getText().toString();
        String[] keywordsArray = keywords.split(",");
        ArrayList<String> keywordsReduced = new ArrayList<String>();
        if(!keywords.equals("")){
            for(int i = 0; i < keywordsArray.length; i ++){
                keywordsReduced.add(keywordsArray[i].replaceAll(" ", "").toLowerCase());
            }
        }

        Database jobs = new Database("Jobs");
        final Controller aController = (Controller) getApplicationContext();
        ArrayList<Job> filteredJobs = jobs.populateFiltered(age, distance, minPay, school, jobType, keywordsReduced, state, aController.getUser());
        for(int i = 0; i < filteredJobs.size(); i++){
            aController.getFilteredJobs().set(i, filteredJobs.get(i));
        }
        aController.setJobRefreshNumber(0);

        Toast toast = Toast.makeText(getApplicationContext(), "Filter Settings Updated", Toast.LENGTH_LONG);
        toast.show();
    }

    public void returnHome(View v){
        Intent intent = new Intent(this, jobListingPage.class);
        startActivity(intent);
    }
}
