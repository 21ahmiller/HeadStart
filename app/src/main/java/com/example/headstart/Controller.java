package com.example.headstart;

import android.app.Application;

import java.util.ArrayList;

public class Controller extends Application {

    User currentUser = new User();
    Employer currentCompany = new Employer();
    ArrayList<Job> viewingJobs = new ArrayList<>();
    int jobNumber = 0;

    public void setUser(User user){
        currentUser = user;
    }

    public User getUser() {
        return currentUser;
    }

    public void setEmployer(Employer company){
        currentCompany = company;
    }

    public Employer getEmployer() {
        return currentCompany;
    }

    public void setJobNumber (int number){
        jobNumber = number;
    }

    public int getJobNumber(){
        return jobNumber;
    }

    public void updateFireBaseUser(){
        //updates the User data in firebase
    }

    public void updateFireBaseEmployer(){
        //updates the Employer data in firebase
    }

}
