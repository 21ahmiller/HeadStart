package com.example.headstart;

import android.app.Application;

import java.util.ArrayList;

public class Controller extends Application {

    //Controller Data
    private User currentUser = new User();
    private Employer currentCompany = new Employer();
    private ArrayList<Job> filteredJobs = new ArrayList<>(200);
    private int jobNumber = 0;

    /**
     * sets currentUser to given user
     * @param user
     */
    public void setUser(User user){
        currentUser = user;
    }

    /**
     * gets user
     * @return currentUser
     */
    public User getUser() {
        return currentUser;
    }

    /**
     * sets currentCompany to given Employer
     * @param company
     */
    public void setEmployer(Employer company){
        currentCompany = company;
    }

    /**
     * gets employer
     * @return currentCompany
     */
    public Employer getEmployer() {
        return currentCompany;
    }

    /**
     * sets jobNumber to given int
     * @param number
     */
    public void setJobNumber (int number){
        jobNumber = number;
    }

    /**
     * gets jobNumber (index of job in arrayList filteredJobs)
     * @return jobNumber
     */
    public int getJobNumber(){
        return jobNumber;
    }

    /**
     * gets the arrayList of jobs after applying the filters
     * @return filteredJobs
     */
    public ArrayList<Job> getFilteredJobs(){
        return filteredJobs;
    }

    /**
     * sets filteredJobs arrayList to given arrayList
     * @param filteredJobs
     */
    public void setFilteredJobs(ArrayList<Job> filteredJobs){
        this.filteredJobs = filteredJobs;
    }

    /**
     * Uploads user's profile to Firebase
     */
    public void updateFireBaseUserProfile(){
        Database Users = new Database("Users");
        String ID = emailReducer(currentUser.getEmail());
        Users.getDatabaseReference().child(ID).child("profile").setValue(currentUser.getProfile());
    }

    /**
     * Uploads employer's profile to Firebase
     */
    public void updateFireBaseEmployerProfile(){
        Database Employers = new Database("Employers");
        String ID = emailReducer(currentCompany.getEmail());
        Employers.getDatabaseReference().child(ID).child("profile").setValue(currentCompany.getProfile());
        Employers.getDatabaseReference().child(ID).child("companyBackground").setValue(currentCompany.getCompanyBackground());
        Employers.getDatabaseReference().child(ID).child("companyDescription").setValue(currentCompany.getCompanyDescription());
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
}
