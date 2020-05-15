package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class NewJob extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_job);
    }

    public String emailReducer(String email){
        ArrayList<String> characters = new ArrayList<String>();
        for(int i = 0; i < email.length(); i ++){
            characters.add(email.substring(i, i + 1));
        }
        characters.remove("@");
        characters.remove(".");
        String reduced = "";
        for(int i = 0; i < characters.size(); i++){
            reduced += characters.get(i);
        }
        return reduced;
    }

    public void onClickSubmit(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();

        Job newJob = new Job();

        EditText jobNameText = findViewById(R.id.jobNameText);
        String jobTitle = jobNameText.getText().toString();

        boolean uniqueJob = true;
        for(int i = 0; i < currentEmployer.getJobs().size(); i ++){
            if(jobTitle.equals(currentEmployer.getJobs().get(i).getJobTitle())){
                uniqueJob = false;
            }
        }

        newJob.setJobTitle(jobTitle);

        EditText jobInformationText = findViewById(R.id.jobInformationText);
        String jobInformation = jobInformationText.getText().toString();

        newJob.setJobDescription(jobInformation);

        EditText locationText = findViewById(R.id.locationText);
        String location = locationText.getText().toString();

        EditText addressText = findViewById(R.id.addressText);
        String address = addressText.getText().toString();

        newJob.setAddress(address);

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

        RadioButton highSchoolButton = findViewById(R.id.CurrentHS);
        RadioButton highSchoolGraduateButton = findViewById(R.id.HSGrad);
        RadioButton collegeButton = findViewById(R.id.CollegeStd);
        RadioButton collegeGraduateButton = findViewById(R.id.CollegeGrad);

        if(highSchoolButton.isChecked()){
            newJob.setSchool("High School");
        }else if(highSchoolGraduateButton.isChecked()){
            newJob.setSchool("High School Graduate");
        }else if(collegeButton.isChecked()){
            newJob.setSchool("College");
        }else{
            newJob.setSchool("College Graduate");
        }

        EditText ageText = findViewById(R.id.ageText);
        String minimumAge = ageText.getText().toString();

        newJob.setAgeMinimum(minimumAge);

        String[] locationArray = location.split(",");
        if(locationArray.length == 3){
            String state = locationArray[0];
            String city = locationArray[1];
            String zipCode = locationArray[2];
            newJob.setState(state);
            newJob.setZipcode(zipCode);
            newJob.setCity(city);
        }

        EditText keywordText = findViewById(R.id.keywordText);
        String keywords = keywordText.getText().toString();

        String[] keywordsArray = keywords.split(",");
        if(!keywords.equals("")){
            for(int i = 0; i < keywordsArray.length; i ++){
                newJob.getKeywords().add(keywordsArray[i].replaceAll(" ", "").toLowerCase());
            }
        }

        newJob.setCompanyID(emailReducer(currentEmployer.getEmail()));

        if(jobTitle.equals("") || jobInformation.equals("") || address.equals("") || requirements.equals("") || preferredSkills.equals("") || schedule.equals("") || salary.equals("") || benefits.equals("") || minimumAge.equals("") || newJob.getState().equals("") || newJob.getCity().equals("") || newJob.getZipcode().equals("") || !(fullTime.isChecked() || partTime.isChecked() || internship.isChecked() || coOp.isChecked()) || !(highSchoolButton.isChecked() || highSchoolGraduateButton.isChecked() || collegeButton.isChecked()|| collegeGraduateButton.isChecked()) || keywords.equals("")){
            Toast toast = Toast.makeText(getApplicationContext(), "All Fields Must Be Filled", Toast.LENGTH_LONG);
            toast.show();
        }else if (uniqueJob){
            currentEmployer.addJob(newJob);

            Database jobs = new Database("Jobs");
            jobs.createJob(newJob);
            currentEmployer.updateFireBaseJobs();

            Intent intent = new Intent(this, employerMainPage.class);
            startActivity(intent);
        }else{
            Toast toast = Toast.makeText(getApplicationContext(), "Job Name Must Be Unique", Toast.LENGTH_LONG);
            toast.show();
        }


    }
}
