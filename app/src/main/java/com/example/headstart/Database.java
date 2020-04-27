package com.example.headstart;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Database {

    FirebaseDatabase database;
    DatabaseReference ref;

    public Database(String path) {
        database = FirebaseDatabase.getInstance();
        ref = database.getReference(path);
    }

//    private static final String TAG = "Database";

//    public void basicReadWrite(FirebaseDatabase database, DatabaseReference ref) {
//
//        ref.setValue("Hello, World!");
//
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String value = dataSnapshot.getValue(String.class);
//                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
//
//        addDefaultUser("test1234", "name1234", "1234");
//        addDefaultUser("test5678", "name5678", "5678");
//    }

    public FirebaseDatabase getFirebaseDatabase() {
        return database;
    }

    public DatabaseReference getDatabaseReference() {
        return ref;
    }

    public void addDefaultUser(String ID, String name, String email, String password) {
        User user = new User();
        user.setDisplayName(name);
        user.setEmail(email);

        ref.child(ID).setValue(user);
        ref.child(ID).child("password").setValue(password);
    }

    public void updateUserProfile(String ID, String state, String city, String zipcode, String year, String school, String description, String phoneNumber, String age) {
        Profile profile = new Profile(state, city, zipcode, year, school, description, phoneNumber, age);

        ref.child(ID).child("profile").setValue(profile);
    }
}