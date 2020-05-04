package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class EditEmployer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employer);

        final Controller aController = (Controller) getApplicationContext();
        User currentUser = aController.getUser();

        EditText emailConfirmText = findViewById(R.id.emailConfirmText);
        emailConfirmText.setText(currentUser.getEmail());

        EditText phoneNumberText = findViewById(R.id.PhoneNumText);
        if(filled(currentUser.getProfile().getPhoneNumber()))
            phoneNumberText.setText(currentUser.getProfile().getPhoneNumber());

        EditText stateText = findViewById(R.id.stateText);
        if(filled(currentUser.getProfile().getLocation().getState()))
            stateText.setText(currentUser.getProfile().getLocation().getState());

        EditText cityText = findViewById(R.id.cityText);
        if(filled(currentUser.getProfile().getLocation().getCity()))
            cityText.setText(currentUser.getProfile().getLocation().getCity());

        EditText zipcodeText = findViewById(R.id.cityText);
        if(filled(currentUser.getProfile().getLocation().getZipCode()))
            zipcodeText.setText(currentUser.getProfile().getLocation().getZipCode());

        EditText interestsText = findViewById(R.id.backgroundText);
        if(currentUser.getProfile().getInterests().size() > 0)
            interestsText.setText(arrayToString(currentUser.getProfile().getInterests()));

        EditText experiencesText = findViewById(R.id.descriptionText);
        if(currentUser.getProfile().getExperiences().size() > 0)
            experiencesText.setText(arrayToString(currentUser.getProfile().getExperiences()));

    }

    public boolean filled(String a){
        if(a.equals("")){
            return false;
        }else{
            return true;
        }
    }

    public String arrayToString(ArrayList<String> strings){
        String total = "";
        if(strings.size() > 0){
            for(int i = 0; i < strings.size() - 1; i ++){
                total += strings.get(i) + ", ";
            }
            return total + strings.get(strings.size() - 1);
        }
        return total;
    }

    public void saveChanges(View v){
        final Controller aController = (Controller) getApplicationContext();
        User currentUser = aController.getUser();

        EditText phoneNumberText = findViewById(R.id.PhoneNumText);
        currentUser.getProfile().setPhoneNumber(phoneNumberText.getText().toString());

        EditText stateText = findViewById(R.id.stateText);
        currentUser.getProfile().getLocation().setState(stateText.getText().toString());

        EditText cityText = findViewById(R.id.cityText);
        currentUser.getProfile().getLocation().setCity(cityText.getText().toString());

        EditText zipcodeText = findViewById(R.id.cityText);
        currentUser.getProfile().getLocation().setZipCode(zipcodeText.getText().toString());

        EditText backgroundText = findViewById(R.id.backgroundText);
        String background = backgroundText.getText().toString();


        EditText descriptionText = findViewById(R.id.descriptionText);
        String description = descriptionText.getText().toString();


        //save changes to firebase from the controller
        //make controller static method?
        returnHome(v);
    }

    public void returnHome(View v){
        Intent intent = new Intent(this, employerMainPage.class);
        startActivity(intent);
    }
}
