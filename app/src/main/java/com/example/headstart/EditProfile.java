package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        final Controller aController = (Controller) getApplicationContext();
        User currentUser = aController.getUser();

        EditText emailConfirmText = findViewById(R.id.emailConfirmText);
        emailConfirmText.setText(currentUser.getEmail());

        EditText phoneNumberText = findViewById(R.id.PhoneNumText);
        if(filled(currentUser.getProfile().getPhoneNumber()))
            phoneNumberText.setText(currentUser.getProfile().getPhoneNumber());

        EditText stateText = findViewById(R.id.stateText);
        if(filled(currentUser.getProfile().getLocation().getState()))
            stateText.setText(currentUser.getProfile().getLocation().getState());

        EditText cityText = findViewById(R.id.cityText);
        if(filled(currentUser.getProfile().getLocation().getCity()))
            cityText.setText(currentUser.getProfile().getLocation().getCity());

        EditText zipcodeText = findViewById(R.id.zipcodeText);
        if(filled(currentUser.getProfile().getLocation().getZipCode()))
            zipcodeText.setText(currentUser.getProfile().getLocation().getZipCode());


        RadioButton highSchool = findViewById(R.id.highSchoolButton);
        if(currentUser.getProfile().getEducation().getSchool().equals("High School")){
            highSchool.setChecked(true);
        }
        RadioButton college = findViewById(R.id.collegeButton);
        if(currentUser.getProfile().getEducation().getSchool().equals("College")){
            college.setChecked(true);
        }
        RadioButton collegeGrad = findViewById(R.id.collegeGradButton);
        if(currentUser.getProfile().getEducation().getSchool().equals("College Graduate")){
            collegeGrad.setChecked(true);
        }
        RadioButton neither = findViewById(R.id.neitherButton);
        if(currentUser.getProfile().getEducation().getSchool().equals("N/A")){
            neither.setChecked(true);
        }

        RadioButton freshman = findViewById(R.id.highSchoolButton);
        if(currentUser.getProfile().getEducation().getYear().equals("Freshman")){
            freshman.setChecked(true);
        }
        RadioButton sophomore = findViewById(R.id.collegeButton);
        if(currentUser.getProfile().getEducation().getYear().equals("Sophomore")){
            sophomore.setChecked(true);
        }
        RadioButton junior = findViewById(R.id.collegeGradButton);
        if(currentUser.getProfile().getEducation().getYear().equals("Junior")){
            junior.setChecked(true);
        }
        RadioButton senior = findViewById(R.id.neitherButton);
        if(currentUser.getProfile().getEducation().getYear().equals("Senior")){
            senior.setChecked(true);
        }

        EditText ageText = findViewById(R.id.ageText);
        if(filled(currentUser.getProfile().getAge()))
            ageText.setText(currentUser.getProfile().getAge());

        EditText interestsText = findViewById(R.id.interestText);
        if(currentUser.getProfile().getInterests().size() > 0)
            interestsText.setText(arrayToString(currentUser.getProfile().getInterests()));

        EditText experiencesText = findViewById(R.id.experienceText);
        if(currentUser.getProfile().getExperiences().size() > 0)
            experiencesText.setText(arrayToString(currentUser.getProfile().getExperiences()));

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

    public void saveChanges(View v){
        final Controller aController = (Controller) getApplicationContext();
        User currentUser = aController.getUser();

        EditText phoneNumberText = findViewById(R.id.PhoneNumText);
        currentUser.getProfile().setPhoneNumber(phoneNumberText.getText().toString());

        EditText stateText = findViewById(R.id.stateText);
        currentUser.getProfile().getLocation().setState(stateText.getText().toString());

        EditText cityText = findViewById(R.id.cityText);
        currentUser.getProfile().getLocation().setCity(cityText.getText().toString());

        EditText zipcodeText = findViewById(R.id.zipcodeText);
        currentUser.getProfile().getLocation().setZipCode(zipcodeText.getText().toString());

        RadioButton highSchool = findViewById(R.id.highSchoolButton);
        if(highSchool.isChecked()){
            currentUser.getProfile().getEducation().setSchool("High School");
        }
        RadioButton college = findViewById(R.id.collegeButton);
        if(college.isChecked()){
            currentUser.getProfile().getEducation().setSchool("College");
        }
        RadioButton collegeGrad = findViewById(R.id.collegeGradButton);
        if(collegeGrad.isChecked()){
            currentUser.getProfile().getEducation().setSchool("College Graduate");
        }
        RadioButton neither = findViewById(R.id.neitherButton);
        if(neither.isChecked()){
            currentUser.getProfile().getEducation().setSchool("N/A");
        }

        RadioButton freshman = findViewById(R.id.freshmanButton);
        if(freshman.isChecked()){
            currentUser.getProfile().getEducation().setYear("Freshman");
        }
        RadioButton sophomore = findViewById(R.id.sophomoreButton);
        if(sophomore.isChecked()){
            currentUser.getProfile().getEducation().setYear("Sophomore");
        }
        RadioButton junior = findViewById(R.id.juniorButton);
        if(junior.isChecked()){
            currentUser.getProfile().getEducation().setYear("Junior");
        }
        RadioButton senior = findViewById(R.id.seniorButton);
        if(senior.isChecked()){
            currentUser.getProfile().getEducation().setYear("Senior");
        }

        EditText ageText = findViewById(R.id.ageText);
            currentUser.getProfile().setAge(ageText.getText().toString());

        EditText interestsText = findViewById(R.id.interestText);
        String interests = interestsText.getText().toString();
        String[] interestsArray = interests.split(",");
        for(int i = 0; i < interestsArray.length; i ++){
            currentUser.getProfile().getInterests().add(interestsArray[i]);
        }

        EditText experiencesText = findViewById(R.id.experienceText);
        String experiences = experiencesText.getText().toString();
        String[] experiencesArray = experiences.split(",");
        for(int i = 0; i < experiencesArray.length; i ++){
            currentUser.getProfile().getExperiences().add(experiencesArray[i]);
        }

        //save changes to firebase from the controller
        //make controller static method?
        returnHome(v);
    }

    public void returnHome(View v){
        Intent intent = new Intent(this, ApplicantProfile.class);
        startActivity(intent);
    }
}
