package com.example.headstart;

import android.app.Application;

import java.util.ArrayList;

public class Controller extends Application {

    User currentUser = new User();
    Employer currentCompany = new Employer();
    ArrayList<Job> viewingJobs = new ArrayList<>();

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

    public void filterJobs(int age, int driveDistance, int minPayRate, String education, String jobType, String keywords, int experience){
        //for some amount of jobs, add jobs to viewingJobs


    }

}
