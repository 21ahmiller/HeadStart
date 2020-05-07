package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class NewJob extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_job);
    }

    public void onClickSubmit(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();

        Job newJob = new Job();

        EditText jobNameText = findViewById(R.id.jobNameText);
        String jobTitle = jobNameText.getText().toString();

        newJob.setJobTitle(jobTitle);

        EditText jobInformationText = findViewById(R.id.jobInformationText);
        String jobInformation = jobInformationText.getText().toString();

        newJob.setJobDescription(jobInformation);

        EditText locationText = findViewById(R.id.locationText);
        String location = locationText.getText().toString();

        EditText addressText = findViewById(R.id.addressText);
        String address = addressText.getText().toString();

        newJob.getLocation().setAddress(address);

        EditText requirementsText = findViewById(R.id.requirementsText);
        String requirements = requirementsText.getText().toString();

        newJob.setRequirements(requirements);

        EditText preferredSkillsText = findViewById(R.id.preferredSkillsText);
        String preferredSkills = preferredSkillsText.getText().toString();

        newJob.setSkills(preferredSkills);

        EditText scheduleText = findViewById(R.id.scheduleText);
        String schedule = scheduleText.getText().toString();

        newJob.setSchedule(schedule);

        EditText salaryText = findViewById(R.id.salaryText);
        String salary = salaryText.getText().toString();

        newJob.setSalary(salary);

        EditText benefitsText = findViewById(R.id.benefitsText);
        String benefits = benefitsText.getText().toString();

        newJob.setBenefits(benefits);

        RadioButton fullTime = findViewById(R.id.FullTime);
        RadioButton partTime = findViewById(R.id.PartTime);
        RadioButton internship = findViewById(R.id.Internship);
        RadioButton coOp = findViewById(R.id.Coop);

        if(fullTime.isChecked()){
            newJob.setJobType("Full Time");
        }else if(partTime.isChecked()){
            newJob.setJobType("Part Time");
        }else if(internship.isChecked()){
            newJob.setJobType("Internship");
        }else{
            newJob.setJobType("Co-Op");
        }

        RadioButton HS = findViewById(R.id.highSchoolButton);
        RadioButton HSG = findViewById(R.id.HSGrad);
        RadioButton C = findViewById(R.id.CollegeStd);
        RadioButton CG = findViewById(R.id.CollegeGrad);

        if(HS.isChecked()){
            newJob.getEduction().setSchool("High School");
        }else if(HSG.isChecked()){
            newJob.getEduction().setSchool("High School Graduate");
        }else if(C.isChecked()){
            newJob.getEduction().setSchool("College");
        }else{
            newJob.getEduction().setSchool("College Graduate");
        }

        EditText ageText = findViewById(R.id.ageText);
        String minimumAge = ageText.getText().toString();

        newJob.setAgeMinimum(minimumAge);


        String[] locationArray = location.split(",");
        if(locationArray.length == 3){
            String state = locationArray[0];
            String city = locationArray[1];
            String zipCode = locationArray[2];
            newJob.getLocation().setState(state);
            newJob.getLocation().setZipCode(zipCode);
            newJob.getLocation().setCity(city);
        }

        if(jobTitle.equals("") || jobInformation.equals("") || address.equals("") || requirements.equals("") || preferredSkills.equals("") || schedule.equals("") || salary.equals("") || benefits.equals("") || minimumAge.equals("") || newJob.getLocation().getState().equals("") || newJob.getLocation().getCity().equals("") || newJob.getLocation().getZipCode().equals("") || !(fullTime.isChecked() || partTime.isChecked() || internship.isChecked() || coOp.isChecked()) || !(HS.isChecked() || HSG.isChecked() || C.isChecked()|| CG.isChecked())){
            Toast toast = Toast.makeText(getApplicationContext(), "All Fields Must Be Filled", Toast.LENGTH_LONG);
            toast.show();
        }else{
            currentEmployer.addJob(newJob);
            Intent intent = new Intent(this, employerMainPage.class);
            startActivity(intent);
        }
    }
}
