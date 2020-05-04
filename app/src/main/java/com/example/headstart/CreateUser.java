package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
    }

    public void performCreateApplicant(View v){
        EditText emailText = findViewById(R.id.emailConfirmText);
        String email = emailText.getText().toString();

        EditText passwordText = findViewById(R.id.passwordText);
        String password = passwordText.getText().toString();

        EditText usernameText = findViewById(R.id.usernameText);
        String displayName = usernameText.getText().toString();

        if(isEmail(email)){
            if(uniqueEmail(email)){
                User applicant = new User(email, password, displayName);
                final Controller aController = (Controller) getApplicationContext();
                aController.setUser(applicant);
                //Upload user to firebase
                Intent intent = new Intent(this, jobListingPage.class);
                startActivity(intent);
            }else{
                Toast toast = Toast.makeText(getApplicationContext(), "This email is already taken", Toast.LENGTH_LONG);
                toast.show();
            }
        }else{
            Toast toast = Toast.makeText(getApplicationContext(), "Invalid email", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public boolean uniqueEmail(String email){
        //checks if email already exists in system
        // true if exists
        //false if doesn't
        String reduced = emailReducer(email);
        return true; //just a test
    }

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
