package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Database testUsers = new Database("Users");
    Database testEmployers = new Database("Employers");
    Database testJobs = new Database("Jobs");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      testUsers.addDefaultUser("user1234", "name1234", "user1234@gmail.com", "1234");
      testUsers.updateUserProfile("user1234", "MA", "test city", "00000", "Junior", "test school", "test description.", "000-000-0000", "17");

      testEmployers.addDefaultEmployer("employer5678", "company5678", "employer5678@gmail.com", "5678");
      testEmployers.updateEmployerProfile("employer5678", "MA", "test city", "00000", "10 Street", "test description", "000-000-0000");

      testJobs.createJob("job9101112", "job9101112", "full-time", "test description", "MA", "test city", "00000", "10 Street", "req 1, req 2", "skill 1, skill 2", "weekdays", "$1000", "test benefits", "16");
    }

    public void clickApplicantButton(View v){
        EditText emailText = findViewById(R.id.emailText);
        String email = emailText.getText().toString();

        EditText passwordText = findViewById(R.id.passwordText);
        String password = passwordText.getText().toString();

        applicantSignIn(email, password, v);
    }

    public void applicantSignIn(String email, String password, View v){
        findUser(email);
        final Controller aController = (Controller) getApplicationContext();
        User currentUser = aController.getUser();

        if(currentUser.comparePassword(password)){
            performOpenJobListings(v);
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(), "Incorrect Password", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void findUser(String email){
        // look through database for user with same email.
        User mockUser = new User("jeffwilcox@hotmail.com", "password", "Jeffrey Wilcox"); //this is a fake user for example
        final Controller aController = (Controller) getApplicationContext();
        aController.setUser(mockUser);
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

    public boolean isEmail(String email){
        int atTimes = 0;
        int periodTimes = 0;
        for(int i = 0; i < email.length(); i ++){
            if(email.substring(i, i + 1).equals("@")){
                atTimes += 1;
            }else if(email.substring(i, i + 1).equals(".")){
                periodTimes += 1;
            }
        }
        if(atTimes == 1 && periodTimes == 1){
            return true;
        }
        return false;
    }

    public void performOpenJobListings(View v){
        Intent intent = new Intent(this, jobListingPage.class);
        startActivity(intent);
    }

    public void guestButton(){
        final Controller aController = (Controller) getApplicationContext();
        aController.setUser(new User());

        Intent intent = new Intent(this, jobListingPage.class);
        startActivity(intent);
    }

    public void clickEmployerButton(View v){
        EditText emailText = findViewById(R.id.emailText);
        String email = emailText.getText().toString();

        EditText passwordText = findViewById(R.id.passwordText);
        String password = passwordText.getText().toString();

        employerSignIn(email, password, v);
    }

    public void employerSignIn(String email, String password, View v){
        findEmployer(email);
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();

        if(currentEmployer.comparePassword(password)){
            performOpenEmployerMainPage(v);
        }else{
            Toast toast = Toast.makeText(getApplicationContext(), "Incorrect Password", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void findEmployer(String email){
        // look through database for employer with same email.
        Employer mockEmployer = new Employer("target@hotmail.com", "password", "Target"); //this is a fake user for example
        final Controller aController = (Controller) getApplicationContext();
        aController.setEmployer(mockEmployer);
    }

    public void performOpenEmployerMainPage(View v){
        Intent intent = new Intent(this, employerMainPage.class);
        startActivity(intent);
    }

    public void performCreateProfilePage(View v){
        Intent intent = new Intent(this, createProfile.class);
        startActivity(intent);
    }
}
