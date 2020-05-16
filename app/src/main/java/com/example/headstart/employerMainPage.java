package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class employerMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_main_page);

        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();

        TextView companyTitle = findViewById(R.id.companyTitleText);
        companyTitle.setText(currentEmployer.getDisplayName());

        TextView companyBio = findViewById(R.id.companyBioText);
        if(filled(currentEmployer.getCompanyBackground())){
            companyBio.setText(currentEmployer.getCompanyBackground());
        }else{
            companyBio.setText("EDIT PROFILE TO ADD COMPANY BACKGROUND");
        }


        TextView companyDescription = findViewById(R.id.companyDescriptionText);
        if(filled(currentEmployer.getCompanyDescription())){
            companyDescription.setText(currentEmployer.getCompanyDescription());
        }else{
            companyDescription.setText("EDIT PROFILE TO ADD COMPANY DESCRIPTION");
        }

    }

    public boolean filled(String a){
        if(a.equals("")){
            return false;
        }else{
            return true;
        }
    }

    public void performOpenNewJob(View v){
        Intent intent = new Intent(this, NewJob.class);
        startActivity(intent);
    }

    public void performReviewJobs(View v){
        Intent intent = new Intent(this, ReviewJobs.class);
        startActivity(intent);
    }

    public void performEditProfile(View v){
        Intent intent = new Intent(this, EditEmployer.class);
        startActivity(intent);
    }

    public void signOut(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setEmployer(new Employer());

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
