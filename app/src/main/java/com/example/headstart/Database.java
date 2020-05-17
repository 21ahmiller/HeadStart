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

    //Database data
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<Job> jobs;

    /**
     * Create a database with a reference to a given path
     * @param path
     */
    public Database(String path) {
        database = FirebaseDatabase.getInstance();
        ref = database.getReference(path);
        jobs = new ArrayList<Job>();
    }

    /**
     * gets database reference
     * @return ref
     */
    public DatabaseReference getDatabaseReference() {
        return ref;
    }

    /**
     * changes email into unique ID without unallowed characters
     * @param email
     * @return reduced
     */
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

    /**
     * Creates a job in Firebase
     * @param job
     */
    public void createJob(Job job) {

        String jobTitleNoSpace = job.getJobTitle().replaceAll(" ", "");
        String ID = jobTitleNoSpace + job.getCompanyID();

        ref.child(ID).setValue(job);

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

    /**
     * Removes a job from Firebase
     * @param job
     */
    public void removeJob(Job job){
        String jobTitleNoSpace = job.getJobTitle().replaceAll(" ", "");
        String ID = jobTitleNoSpace + job.getCompanyID();
        ref.child(ID).removeValue();
    }

    /**
     * Updates a job's information in Firebase
     * @param job
     */
    public void updateJob(Job job){
        String jobTitleNoSpace = job.getJobTitle().replaceAll(" ", "");
        String ID = jobTitleNoSpace + job.getCompanyID();
        ref.child(ID).setValue(job);
    }

    /**
     *  Populates arrayList jobs with 200 random jobs from Firebase
     * @return arrayList jobs
     */
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

    /**
     * Applies filters and returns new arrayList of jobs that match filters
     * @param minAge
     * @param maxDrive
     * @param minpay
     * @param school
     * @param jobType
     * @param Keywords
     * @param state
     * @param user
     * @return filtered arrayList jobs
     */
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

    /**
     * Translates school level into an int for use in populateFiltered method
     * @param school
     * @return int representing school
     */
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