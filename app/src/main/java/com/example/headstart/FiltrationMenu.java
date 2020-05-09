package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;

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

        SeekBar fieldExperienceBar = findViewById(R.id.FieldExperienceBar);
        fieldExperienceBar.setProgress(0);

        EditText enterKeywordText = findViewById(R.id.EnterKeywords);
        enterKeywordText.setText("");

    }

    public void applyFilters(View v){


        // ADD LOT OF FILTER STUFF HERE

        Toast toast = Toast.makeText(getApplicationContext(), "Filter Settings Updated", Toast.LENGTH_LONG);
        toast.show();
    }

    public void returnHome(View v){
        Intent intent = new Intent(this, jobListingPage.class);
        startActivity(intent);
    }
}
