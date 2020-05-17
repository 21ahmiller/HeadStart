package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class ReviseJob extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revise_job);

        final Controller aController = (Controller) getApplicationContext();
        Job newJob = aController.getEmployer().getJobs().get(aController.getJobNumber());

        EditText jobNameText = findViewById(R.id.jobNameText);
        jobNameText.setText(newJob.getJobTitle());

        EditText jobInformationText = findViewById(R.id.jobInformationText);
        jobInformationText.setText(newJob.getJobDescription());

        EditText locationText = findViewById(R.id.locationText);
        locationText.setText(newJob.getState() + "," + newJob.getCity() + "," + newJob.getZipcode());

        EditText addressText = findViewById(R.id.addressText);
        addressText.setText(newJob.getAddress());

        EditText requirementsText = findViewById(R.id.requirementsText);
        requirementsText.setText(newJob.getRequirements());

        EditText preferredSkillsText = findViewById(R.id.preferredSkillsText);
        preferredSkillsText.setText(newJob.getSkills());

        EditText scheduleText = findViewById(R.id.scheduleText);
        scheduleText.setText(newJob.getSchedule());

        EditText salaryText = findViewById(R.id.salaryText);
        salaryText.setText(newJob.getSalary());

        EditText benefitsText = findViewById(R.id.benefitsText);
        benefitsText.setText(newJob.getBenefits());

        EditText urlText = findViewById(R.id.URLText);
        urlText.setText(newJob.getApplicationURL());

        RadioButton fullTime = findViewById(R.id.FullTime);
        RadioButton partTime = findViewById(R.id.PartTime);
        RadioButton internship = findViewById(R.id.Internship);
        RadioButton coOp = findViewById(R.id.Coop);

        if(newJob.getJobType().equals("Full Time")){
            fullTime.setChecked(true);
        }else if(newJob.getJobType().equals("Part Time")){
            partTime.setChecked(true);
        }else if(newJob.getJobType().equals("Internship")){
            internship.setChecked(true);
        }else{
            coOp.setChecked(true);
        }

        RadioButton highSchoolButton = findViewById(R.id.CurrentHS);
        RadioButton highSchoolGraduateButton = findViewById(R.id.HSGrad);
        RadioButton collegeButton = findViewById(R.id.CollegeStd);
        RadioButton collegeGraduateButton = findViewById(R.id.CollegeGrad);

        if(newJob.getSchool().equals("High School")){
            highSchoolButton.setChecked(true);
        }else if(newJob.getSchool().equals("High School Graduate")){
            highSchoolGraduateButton.setChecked(true);
        }else if(newJob.getSchool().equals("College")){
            collegeButton.setChecked(true);
        }else{
            collegeGraduateButton.setChecked(true);
        }


        EditText ageText = findViewById(R.id.ageText);
        ageText.setText(newJob.getAgeMinimum());

        EditText keywordText = findViewById(R.id.keywordText);
        keywordText.setText(arrayToString(newJob.getKeywords()));
    }

    public boolean filled(String a){
        if(a.equals("")){
            return false;
        }else{
            return true;
        }
    }

    public String arrayToString(ArrayList<String> strings){
        String total = "";
        if(strings.size() > 0){
            for(int i = 0; i < strings.size() - 1; i ++){
                total += strings.get(i) + ", ";
            }
            return total + strings.get(strings.size() - 1);
        }
        return total;
    }

    public void returnToJobView (View v){
        Intent intent = new Intent(this, ReviewJobs.class);
        startActivity(intent);
    }

    public void applyChanges(View v){
        final Controller aController = (Controller) getApplicationContext();
        Job newJob = aController.getEmployer().getJobs().get(aController.getJobNumber());

        EditText jobNameText = findViewById(R.id.jobNameText);
        String jobTitle = jobNameText.getText().toString();


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

        EditText urlText = findViewById(R.id.URLText);
        String urlString = urlText.getText().toString();
        newJob.setApplicationURL(urlString);

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
                newJob.getKeywords().set(i, keywordsArray[i].replaceAll(" ", "").toLowerCase());
            }
        }

        if(jobTitle.equals("") || jobInformation.equals("") || address.equals("") || requirements.equals("") || preferredSkills.equals("") || schedule.equals("") || salary.equals("") || benefits.equals("") || minimumAge.equals("") || newJob.getState().equals("") || newJob.getCity().equals("") || newJob.getZipcode().equals("") || !(fullTime.isChecked() || partTime.isChecked() || internship.isChecked() || coOp.isChecked()) || !(highSchoolButton.isChecked() || highSchoolGraduateButton.isChecked() || collegeButton.isChecked()|| collegeGraduateButton.isChecked()) || keywords.equals("") || urlString.equals("")){
            Toast toast = Toast.makeText(getApplicationContext(), "All Fields Must Be Filled", Toast.LENGTH_LONG);
            toast.show();
        }else{
            Database jobs = new Database("Jobs");
            jobs.updateJob(newJob);
            Toast toast = Toast.makeText(getApplicationContext(), "Changes Saved", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    public void deleteJob (View v){
        final Controller aController = (Controller) getApplicationContext();
        Database jobs = new Database("Jobs");
        jobs.removeJob(aController.getEmployer().getJobs().get(aController.getJobNumber()));
        aController.getEmployer().getJobs().remove(aController.getJobNumber());
        aController.getEmployer().updateFireBaseJobs();
        returnToJobView(v);
    }
}
