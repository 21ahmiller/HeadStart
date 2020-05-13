package com.example.headstart;

import android.app.Application;

import java.util.ArrayList;

public class Controller extends Application {

    private User currentUser = new User();
    private Employer currentCompany = new Employer();
    private ArrayList<Job> viewingJobs = new ArrayList<>(20);
    private ArrayList<Job> filteredJobs = new ArrayList<>(200);
    private int jobNumber = 0;

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

    public ArrayList<Job> getViewingJobs(){
        return viewingJobs;
    }

    public ArrayList<Job> getFilteredJobs(){
        return filteredJobs;
    }


    public void updateFireBaseUserProfile(){
        Database Users = new Database("Users");
        String ID = emailReducer(currentUser.getEmail());
        Users.getDatabaseReference().child(ID).child("profile").setValue(currentUser.getProfile());
    }

    public void updateFireBaseEmployerProfile(){
        Database Employers = new Database("Employers");
        String ID = emailReducer(currentCompany.getEmail());
        Employers.getDatabaseReference().child(ID).child("profile").setValue(currentCompany.getProfile());
        Employers.getDatabaseReference().child(ID).child("companyBackground").setValue(currentCompany.getCompanyBackground());
        Employers.getDatabaseReference().child(ID).child("companyDescription").setValue(currentCompany.getCompanyDescription());
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


}
