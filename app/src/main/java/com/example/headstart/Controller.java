package com.example.headstart;

import android.app.Application;

import java.util.ArrayList;

public class Controller extends Application {

    User currentUser = new User();
    ArrayList<Job> viewingJobs = new ArrayList<>();

    public void setUser(User user){
        currentUser = user;
    }

    public User getUser(){
        return currentUser;
    }


}
