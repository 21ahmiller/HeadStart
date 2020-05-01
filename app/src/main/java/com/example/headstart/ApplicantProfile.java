package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ApplicantProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant_profile);

        final Controller aController = (Controller) getApplicationContext();
        User currentUser = aController.getUser();

        TextView passwordText = findViewById(R.id.emailDisplay);
        passwordText.setText(currentUser.getEmail());

        TextView usernameText = findViewById(R.id.usernameDisplay);
        usernameText.setText(currentUser.getDisplayName());


        TextView phoneNumberText = findViewById(R.id.phoneNumberDisplay);
        if(filled(currentUser.getProfile().getPhoneNumber())){
            phoneNumberText.setText(currentUser.getProfile().getPhoneNumber());
        }else{
            phoneNumberText.setText("Empty Field");
        }

        TextView locationText = findViewById(R.id.locationDisplay);
        if(filled(currentUser.getProfile().getLocation().toString())){
            locationText.setText(currentUser.getProfile().getLocation().toString());
        }else{
            locationText.setText("Empty Field");
        }

        TextView educationText = findViewById(R.id.educationDisplay);
        if(filled(currentUser.getProfile().getEducation().toString())){
            educationText.setText(currentUser.getProfile().getEducation().toString());
        }else{
            educationText.setText("Empty Field");
        }


        TextView ageText = findViewById(R.id.ageDisplay);
        if(filled(currentUser.getProfile().getAge())){
            ageText.setText(currentUser.getProfile().getAge());
        }else{
            ageText.setText("Empty Field");
        }

        TextView interestsText = findViewById(R.id.interestsDisplay);
        if(currentUser.getProfile().getInterests().size() > 0){
            interestsText.setText(arrayToString(currentUser.getProfile().getInterests()));
        }else{
            interestsText.setText("Empty Field");
        }

        TextView experiencesText = findViewById(R.id.experiencesDisplay);
        if(currentUser.getProfile().getExperiences().size() > 0){
            experiencesText.setText(arrayToString(currentUser.getProfile().getExperiences()));
        }else{
            experiencesText.setText("Empty Field");
        }

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

    public void performEditProfile(View v){
        Intent intent = new Intent(this, EditProfile.class);
        startActivity(intent);
    }

    public void performViewJobs(View v){
        Intent intent = new Intent(this, jobListingPage.class);
        startActivity(intent);
    }


}
