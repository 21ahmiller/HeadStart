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
            uniqueEmail(email);
            final Controller aController = (Controller) getApplicationContext();
            Toast toast = Toast.makeText(getApplicationContext(), aController.getUser().toString(), Toast.LENGTH_LONG);
            toast.show();
            if(aController.getUser().getEmail().equals("")){
                User applicant = new User(email, password, displayName);
                aController.setUser(applicant);

                Database Users = new Database("Users");
                Users.addDefaultUser(displayName, email, password);

                Database jobs = new Database("Jobs");
                for(int i = 0; i < jobs.populateRandom().size(); i++){
                    aController.getFilteredJobs().set(i, jobs.populateRandom().get(i));
                }
                aController.setJobRefreshNumber(0);
                Intent intent = new Intent(this, jobListingPage.class);
                startActivity(intent);
            }else{
                Toast toast2 = Toast.makeText(getApplicationContext(), "This email is already taken", Toast.LENGTH_LONG);
                toast2.show();
            }
        }else{
            Toast toast = Toast.makeText(getApplicationContext(), "Invalid email", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void uniqueEmail(final String email){
        final Controller aController = (Controller) getApplicationContext();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference usersRef = database.getReference("Users");
        Query query = usersRef.orderByChild("email").equalTo(email);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    User extracted = ds.getValue(User.class);
                    if(extracted.getEmail().equals(email)){
                        final Controller aController = (Controller) getApplicationContext();
                        aController.setUser(extracted);
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("MainActivity", "Failed to read value.", error.toException());
            }
        });
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
