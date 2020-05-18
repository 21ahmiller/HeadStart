package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    /**
     * opens the view of the page
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * runs when the applicant button is clicked; tries to sign in user
     * @param v the view
     */
    public void clickApplicantButton(View v){
        EditText emailText = findViewById(R.id.emailConfirmText);
        String email = emailText.getText().toString().replaceAll(" ", "");

        EditText passwordText = findViewById(R.id.passwordText);
        String password = passwordText.getText().toString();

        applicantSignIn(email, password, v);
    }

    /**
     * Uses the email and the password to check if the user is legitimate; If the user exists, they sign in
     * @param email the user email
     * @param password the user's password
     * @param v the view
     */
    public void applicantSignIn(String email, String password, View v){
        findUser(email);
        final Controller aController = (Controller) getApplicationContext();
        User currentUser = aController.getUser();

        if(currentUser.getEmail().equals("")){

        }else{
            if(currentUser.comparePassword(password)){
                Database jobs = new Database("Jobs");
                ArrayList<Job> randomJobs = jobs.populateRandom();
                aController.setFilteredJobs(randomJobs);
                Intent intent = new Intent(this, ApplicantProfile.class);
                startActivity(intent);
            }
            else{
                Toast toast = Toast.makeText(getApplicationContext(), "Incorrect Password", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }

    /**
     * finds the user based off of the email they use; sets this user as the user in the controller class
     * @param email the email that is input when the user signs in
     */
    public void findUser(final String email){
        final Controller aController = (Controller) getApplicationContext();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference usersRef = database.getReference("Users");

        usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //This method is called once with the initial value and again
                //whenever data at this location is updated.
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    User extracted = ds.getValue(User.class);
                    if(extracted.getEmail().equals(email)) {
                        final Controller aController = (Controller) getApplicationContext();
                        aController.setUser(extracted);
                        break;
                    }
                }
                if(aController.getUser().getEmail().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_LONG);
                    toast.show();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                //Failed to read value
                Log.w("MainActivity", "Failed to read value", error.toException());
            }
        });
    }

    /**
     * signs in the app user as a guest
     * @param v the view
     */
    public void guestButton(View v){
        final Controller aController = (Controller) getApplicationContext();
        Database jobs = new Database("Jobs");
        ArrayList<Job> randomJobs = jobs.populateRandom();
        aController.setFilteredJobs(randomJobs);
        Intent intent = new Intent(this, ApplicantProfile.class);
        startActivity(intent);
    }

    /**
     * runs when the button for signing in an employer is clicked
     * @param v the view
     */
    public void clickEmployerButton(View v){
        EditText emailText = findViewById(R.id.emailConfirmText);
        String email = emailText.getText().toString().replaceAll(" ", "");

        EditText passwordText = findViewById(R.id.passwordText);
        String password = passwordText.getText().toString();

        employerSignIn(email, password, v);
    }

    /**
     * uses the email and password of the employer to look for an employer in firebase and sign them in
     * @param email the employer email
     * @param password the employer password
     * @param v the view
     */
    public void employerSignIn(String email, String password, View v){
        findEmployer(email);
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();

        if(currentEmployer.getEmail().equals("")){

        }else{
            if(currentEmployer.comparePassword(password)){
                performOpenEmployerMainPage(v);
            }else{
                Toast toast = Toast.makeText(getApplicationContext(), "Incorrect Password", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }

    /**
     * looks through firebase for the employer and sets them as the employer in the controller class
     * @param email the employer email
     */
    public void findEmployer(final String email){
        final Controller aController = (Controller) getApplicationContext();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference employersRef = database.getReference("Employers");
        employersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    Employer extracted = ds.getValue(Employer.class);
                    if(extracted.getEmail().equals(email)){
                        final Controller aController = (Controller) getApplicationContext();
                        aController.setEmployer(extracted);
                        break;
                    }
                }
                if(aController.getEmployer().getEmail().equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_LONG);
                    toast.show();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("MainActivity", "Failed to read value.", error.toException());
            }
        });
    }

    /**
     * opens the employer main page
     * @param v the view
     */
    public void performOpenEmployerMainPage(View v){
        Intent intent = new Intent(this, employerMainPage.class);
        startActivity(intent);
    }

    /**
     * sends the user to a page which allows them to create an account
     * @param v the view
     */
    public void performCreateProfilePage(View v){
        Intent intent = new Intent(this, createProfile.class);
        startActivity(intent);
    }
}
