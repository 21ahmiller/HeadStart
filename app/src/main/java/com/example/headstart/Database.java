package com.example.headstart;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.renderscript.Sampler;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.*;

public class Database {

    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<Job> jobs;

    public Database(String path) {
        database = FirebaseDatabase.getInstance();
        ref = database.getReference(path);
        jobs = new ArrayList<Job>();
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

    public void createJob(Job job) {

        String jobTitleNoSpace = job.getJobTitle().replaceAll(" ", "");
        String ID = jobTitleNoSpace + job.getCompanyID();

        ref.child(ID).setValue(job);
        //school and year backwards? eduction node misspelled

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

    public void removeJob(Job job){
        String jobTitleNoSpace = job.getJobTitle().replaceAll(" ", "");
        String ID = jobTitleNoSpace + job.getCompanyID();
        ref.child(ID).removeValue();
    }

    public void updateJob(Job job){
        String jobTitleNoSpace = job.getJobTitle().replaceAll(" ", "");
        String ID = jobTitleNoSpace + job.getCompanyID();
        ref.child(ID).setValue(job);
    }

    public ArrayList<Job> populateRandom(){
            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    int count = 0;
                    for(DataSnapshot ds : dataSnapshot.getChildren()){
                        count += 1;
                    }
                    ArrayList<Integer> randomJobs = new ArrayList<Integer>();
                    Random rand = new Random();
                    for(int i = 0; i < 200; i ++){
                        int random = rand.nextInt(count);
                        if(!randomJobs.contains(random)){
                            randomJobs.add(random);
                        }
                    }
                    count = 0;
                    for(DataSnapshot ds : dataSnapshot.getChildren()){
                        if(randomJobs.contains(count)){
                            jobs.add(ds.getValue(Job.class));
                        }
                        count += 1;
                    }
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w("MainActivity", "Failed to read value.", error.toException());
                }
            });
        return jobs;
    }

    public ArrayList<Job> populateFiltered(final String minAge, int maxDrive, final int minpay, final String school, final String jobType, final ArrayList<String> Keywords, String state, User user){
        this.jobs = new ArrayList<Job>();
        Query query = ref.orderByChild("state").equalTo(state);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    Job job = ds.getValue(Job.class);
                    boolean field = false;
                    for(int i = 0; i < Keywords.size(); i ++){
                        if(job.getKeywords().contains(Keywords.get(i))){
                            field = true;
                            break;
                        }
                    }
                    if(Integer.parseInt(job.getAgeMinimum()) < Integer.parseInt(minAge) && Integer.parseInt(job.getSalary()) > minpay &&  job.getJobType().equals(jobType) && schoolToNum(school) >= schoolToNum(job.getSchool()) && field){
                        jobs.add(job);
                    }
                    if(jobs.size() == 200){
                        break;
                    }
                }
                if(!(jobs.size() == 200)){
                    for(DataSnapshot ds : dataSnapshot.getChildren()){
                        Job job = ds.getValue(Job.class);
                        boolean field = false;
                        for(int i = 0; i < Keywords.size(); i ++){
                            if(job.getKeywords().contains(Keywords.get(i))){
                                field = true;
                                break;
                            }
                        }
                        if(Integer.parseInt(job.getAgeMinimum()) < Integer.parseInt(minAge) &&  job.getJobType().equals(jobType) && schoolToNum(school) >= schoolToNum(job.getSchool()) && field && !jobs.contains(job)){
                            jobs.add(job);
                        }
                        if(jobs.size() == 200){
                            break;
                        }
                    }
                }
                if(!(jobs.size() == 200)){
                    for(DataSnapshot ds : dataSnapshot.getChildren()){
                        Job job = ds.getValue(Job.class);
                        boolean field = false;
                        for(int i = 0; i < Keywords.size(); i ++){
                            if(job.getKeywords().contains(Keywords.get(i))){
                                field = true;
                                break;
                            }
                        }
                        if(Integer.parseInt(job.getAgeMinimum()) < Integer.parseInt(minAge) && schoolToNum(school) >= schoolToNum(job.getSchool()) && field && !jobs.contains(job)){
                            jobs.add(job);
                        }
                        if(jobs.size() == 200){
                            break;
                        }
                    }
                }
                if(!(jobs.size() == 200)){
                    for(DataSnapshot ds : dataSnapshot.getChildren()){
                        Job job = ds.getValue(Job.class);
                        boolean field = false;
                        for(int i = 0; i < Keywords.size(); i ++){
                            if(job.getKeywords().contains(Keywords.get(i))){
                                field = true;
                                break;
                            }
                        }
                        if(field && !jobs.contains(job)){
                            jobs.add(job);
                        }
                        if(jobs.size() == 200){
                            break;
                        }
                    }
                }
                if(!(jobs.size() == 200)){
                    for(DataSnapshot ds : dataSnapshot.getChildren()){
                        Job job = ds.getValue(Job.class);
                        if(!jobs.contains(job)){
                            jobs.add(job);
                        }
                        if(jobs.size() == 200){
                            break;
                        }
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("MainActivity", "Failed to read value.", error.toException());
            }
        });
        return jobs;
    }

    public Integer schoolToNum(String school){
        if(school.equals("High School")){
            return 1;
        }else if(school.equals("High School Graduate")){
            return 2;
        }else if(school.equals("College")){
            return 3;
        }else{
            return 4;
        }

    }
}