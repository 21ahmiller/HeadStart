package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditEmployer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employer);

        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();

        EditText emailConfirmText = findViewById(R.id.emailConfirmText);
        emailConfirmText.setText(currentEmployer.getEmail());

        EditText phoneNumberText = findViewById(R.id.PhoneNumText);
        if(filled(currentEmployer.getProfile().getPhoneNumber()))
            phoneNumberText.setText(currentEmployer.getProfile().getPhoneNumber());

        EditText stateText = findViewById(R.id.stateText);
        if(filled(currentEmployer.getProfile().getLocation().getState()))
            stateText.setText(currentEmployer.getProfile().getLocation().getState());

        EditText cityText = findViewById(R.id.cityText);
        if(filled(currentEmployer.getProfile().getLocation().getCity()))
            cityText.setText(currentEmployer.getProfile().getLocation().getCity());

        EditText zipcodeText = findViewById(R.id.zipcodeText);
        if(filled(currentEmployer.getProfile().getLocation().getZipCode()))
            zipcodeText.setText(currentEmployer.getProfile().getLocation().getZipCode());

        EditText interestsText = findViewById(R.id.backgroundText);
        if(filled(currentEmployer.getCompanyBackground()))
            interestsText.setText(currentEmployer.getCompanyBackground());

        EditText experiencesText = findViewById(R.id.descriptionText);
        if(filled(currentEmployer.getCompanyDescription()))
            experiencesText.setText(currentEmployer.getCompanyDescription());

    }

    public boolean filled(String a){
        if(a.equals("")){
            return false;
        }else{
            return true;
        }
    }


    public void saveChanges(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();

        EditText phoneNumberText = findViewById(R.id.phoneNumText);
        currentEmployer.getProfile().setPhoneNumber(phoneNumberText.toString());

        EditText stateText = findViewById(R.id.stateText);
        currentEmployer.getProfile().getLocation().setState(stateText.getText().toString());

        EditText cityText = findViewById(R.id.cityText);
        currentEmployer.getProfile().getLocation().setCity(cityText.getText().toString());

        EditText zipcodeText = findViewById(R.id.zipcodeText);
        currentEmployer.getProfile().getLocation().setZipCode(zipcodeText.getText().toString());

        EditText backgroundText = findViewById(R.id.backgroundText);
        String background = backgroundText.getText().toString();
        currentEmployer.setCompanyBackground(background);


        EditText descriptionText = findViewById(R.id.descriptionText);
        String description = descriptionText.getText().toString();
        currentEmployer.setCompanyDescription(description);

        Toast toast = Toast.makeText(getApplicationContext(), "Changes Saved", Toast.LENGTH_LONG);
        toast.show();

        aController.updateFireBaseEmployerProfile();
    }

    public void returnHome(View v){
        Intent intent = new Intent(this, employerMainPage.class);
        startActivity(intent);
    }
}
