package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Database test = new Database("User");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      test.addDefaultUser("test1234", "name1234", "test1234@gmail.com", "1234");
      test.updateUserProfile("test1234", "MA", "test city", "00000", "Junior", "test school", "test description.", "000-000-0000", "17");

      test.addDefaultUser("test5678", "name1234", "test1234@gmail.com", "1234");
      test.updateUserProfile("test5678", "MA", "test city", "00000", "Junior", "test school", "test description.", "000-000-0000", "17");
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

    public void performOpenJobListings(View v){
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
