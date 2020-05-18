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

    /**
     * Creates page and sets contentView
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtration_menu);
    }

    /**
     * Sets all filters to default (0, false, or "")
     * @param v
     */
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

    /**
     * Sets and applies filters, and sets arrayList filteredJobs
     * @param v
     */
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

        String[] states = {"Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"};
        Database jobs = new Database("Jobs");
        final Controller aController = (Controller) getApplicationContext();
        boolean stateComplete = false;
        for(int i = 0; i < states.length; i ++){
            if(states[i].equals(state)){
                stateComplete = true;
                break;
            }
        }
        if(age.equals("")){
            age = "0";
        }
        if(stateComplete){
            ArrayList<Job> filteredJobs = jobs.populateFiltered(age, distance, minPay, school, jobType, keywordsReduced, state, aController.getUser());
            aController.setFilteredJobs(filteredJobs);

            Toast toast = Toast.makeText(getApplicationContext(), "Filter Settings Updated", Toast.LENGTH_LONG);
            toast.show();
        }else{
            Toast toast = Toast.makeText(getApplicationContext(), "Not A Valid State", Toast.LENGTH_LONG);
            toast.show();
        }
    }


    /**
     * Sends user back to jobListingsPage
     * @param v
     */
    public void returnHome(View v){
        Intent intent = new Intent(this, jobListingPage.class);
        startActivity(intent);
    }
}
