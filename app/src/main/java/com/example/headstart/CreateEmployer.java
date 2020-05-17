package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class CreateEmployer extends AppCompatActivity {

    /**
     * Creates page and sets ContentView
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_employer);
    }

    /**
     * Checks if information entered is valid, and
     * If valid: creates an employer in Firebase with given information
     * If not valid: Toasts error message
     * @param v
     */
    public void performCreateEmployer(View v){
        EditText emailText = findViewById(R.id.companyEmailText);
        String email = emailText.getText().toString().replaceAll(" ", "");

        EditText passwordText = findViewById(R.id.companyPasswordText);
        String password = passwordText.getText().toString();

        EditText usernameText = findViewById(R.id.companyNameText);
        String displayName = usernameText.getText().toString();

        if(isEmail(email)){
            if(uniqueEmail(email)){
                if(password.length() >= 8){
                    Employer employer = new Employer(email, password, displayName);
                    final Controller aController = (Controller) getApplicationContext();
                    aController.setEmployer(employer);

                    Database Employers = new Database("Employers");
                    DatabaseReference ref = Employers.getDatabaseReference();
                    ref.child(emailReducer(email)).setValue(employer);

                    Intent intent = new Intent(this, employerMainPage.class);
                    startActivity(intent);
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Password Must Be 8 Characters or Longer", Toast.LENGTH_LONG);
                    toast.show();
                }
            }else{
                Toast toast = Toast.makeText(getApplicationContext(), "This email is already taken", Toast.LENGTH_LONG);
                toast.show();
            }
        }else{
            Toast toast = Toast.makeText(getApplicationContext(), "Invalid email", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    /**
     * Checks if a given email already exists in Firebase
     * Not currently working
     * @param email
     * @return true if email exists, false if email is not present
     */
    public boolean uniqueEmail(String email){
        String reduced = emailReducer(email);
        return true; //just a test
    }

    /**
     * changes email into unique ID without unallowed characters
     * @param email
     * @return reduced
     */
    public static String emailReducer(String email){
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
     * Checks if a string is in a correct email format
     * @param email
     * @return true if email is in correct format
     */
    public static boolean isEmail(String email){
        int atTimes = 0;
        int periodTimes = 0;
        int atPos = 0;
        int periodPos = 0;
        for(int i = 0; i < email.length(); i ++){
            if(email.substring(i, i + 1).equals("@")){
                atTimes += 1;
                atPos = i;
            }else if(email.substring(i, i + 1).equals(".")){
                periodTimes += 1;
                periodPos = i;
            }
        }
        if(atTimes == 1 && periodTimes == 1 && atPos + 1 < periodPos && atPos != 0 && periodPos != email.length() - 1){
            return true;
        }
        return false;
    }
}
