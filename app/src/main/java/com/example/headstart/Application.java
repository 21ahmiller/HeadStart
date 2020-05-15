package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Application extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        final Controller aController = (Controller) getApplicationContext();
        ArrayList<Job> jobs = aController.getViewingJobs();
        Job displayedJob = aController.getViewingJobs().get(aController.getJobNumber());

        TextView jobDescription = findViewById(R.id.jobInformationText);
        jobDescription.setText(displayedJob.getJobDescription());

        TextView companyInformation = findViewById(R.id.companyInformationText);
        String employerID = displayedJob.getCompanyID();

        Database employers = new Database("Employers");
        DatabaseReference ref = employers.getDatabaseReference();
        Query query = ref.orderByKey().equalTo(employerID);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Employer extracted = dataSnapshot.getValue(Employer.class);
                final Controller aController = (Controller) getApplicationContext();
                aController.setEmployer(extracted);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("MainActivity", "Failed to read value.", error.toException());
            }
        });

        Employer employer = aController.getEmployer();
        String description = employer.getCompanyDescription();
        if(!description.equals("")){
            companyInformation.setText(description);
        }else{
            companyInformation.setText("COMPANY HAS NO DESCRIPTION");
        }

        TextView title = findViewById(R.id.jobTitle);
        title.setText(displayedJob.getJobTitle());

        TextView location = findViewById(R.id.locationEdit);
        location.setText(displayedJob.getAddress() + " " + displayedJob.getCity() + ", " + displayedJob.getState() + " " + displayedJob.getZipcode());

        TextView requirements = findViewById(R.id.requirementsEdit);
        requirements.setText(displayedJob.getRequirements());

        TextView skills = findViewById(R.id.preferredSkillsEdit);
        skills.setText(displayedJob.getSkills());

        TextView time = findViewById(R.id.scheduleEdit);
        time.setText(displayedJob.getSchedule());

        TextView salary = findViewById(R.id.salaryEdit);
        salary.setText("$" + displayedJob.getSalary() + " / hr");

        TextView benefits = findViewById(R.id.benefitsEdit);
        benefits.setText(displayedJob.getBenefits());

    }

    public void returnToJobs (View v){
        Intent intent = new Intent(this, jobListingPage.class);
        startActivity(intent);
    }


}
