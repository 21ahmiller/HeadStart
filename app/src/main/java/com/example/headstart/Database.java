package com.example.headstart;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.renderscript.Sampler;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Database {

    FirebaseDatabase database;
    DatabaseReference ref;

    public Database(String path) {
        database = FirebaseDatabase.getInstance();
        ref = database.getReference(path);
    }

    public FirebaseDatabase getFirebaseDatabase() {
        return database;
    }

    public DatabaseReference getDatabaseReference() {
        return ref;
    }

    public void addDefaultUser(String name, String email, String password) {
        User user = new User();
        user.setDisplayName(name);
        user.setEmail(email);
        String ID = emailReducer(email);

        ref.child(ID).setValue(user);
        ref.child(ID).child("password").setValue(password);

        ValueEventListener userListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                Log.i("Data", user.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Data", "loadJob:onCancelled", databaseError.toException());
            }
        };
        ref.child(ID).addValueEventListener(userListener);
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

    public void updateUserProfile(String ID, String state, String city, String zipcode, String year, String school, String description, String phoneNumber, String age) {
        Profile profile = new Profile(state, city, zipcode, year, school, description, phoneNumber, age);
        ref.child(ID).child("profile").setValue(profile);
        ref.child(ID).child("profile").child("location").child("address").removeValue();
    }

    public void addDefaultEmployer(String name, String email, String password) {
        Employer employer = new Employer();
        employer.setDisplayName(name);
        employer.setEmail(email);
        String ID = emailReducer(email);

        ref.child(ID).setValue(employer);
        ref.child(ID).child("password").setValue(password);

        ValueEventListener employerListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Employer employer = dataSnapshot.getValue(Employer.class);
                Log.i("Data", employer.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Data", "loadJob:onCancelled", databaseError.toException());
            }
        };
        ref.child(ID).addValueEventListener(employerListener);
    }

    public void updateEmployerProfile(String ID, String state, String city, String zipcode, String address, String description, String phoneNumber) {
        Profile profile = new Profile(state, city, zipcode, address, description, phoneNumber);

        ref.child(ID).child("profile").setValue(profile);
        ref.child(ID).child("profile").child("education").removeValue();
        ref.child(ID).child("profile").child("age").removeValue();
    }

    public void createJob(String jobTitle, String jobType, String jobDescription, String state, String city, String zipCode, String address, String requirements,
                          String skills, String schedule, String salary, String benefits, String ageMinimum, String school, String year, String companyID) {
        Job job = new Job(jobTitle, jobType, jobDescription, state, city, zipCode, address, requirements,
                skills, schedule, salary, benefits, ageMinimum, school, year, companyID);

        String jobTitleNoSpace = jobTitle.replaceAll(" ", "");
        String ID = jobTitleNoSpace + companyID;

        ref.child(ID).setValue(job);
        //school and year backwards? eduction node misspelled
        ref.child(ID).child("eduction").child("school").removeValue();

        ValueEventListener jobListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Job job = dataSnapshot.getValue(Job.class);
                Log.i("Data", job.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Data", "loadJob:onCancelled", databaseError.toException());
            }
        };
        ref.child(ID).addValueEventListener(jobListener);
    }
}