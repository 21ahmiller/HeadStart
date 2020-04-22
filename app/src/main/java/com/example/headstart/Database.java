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
    DatabaseReference myRef;

    public Database() {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");
    }

    private static final String TAG = "Database";

    public void basicReadWrite(FirebaseDatabase database, DatabaseReference myRef) {

        myRef.setValue("Hello, World!");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    public FirebaseDatabase getFirebaseDatabase() {
        return database;
    }

    public DatabaseReference getDatabaseReference() {
        return myRef;
    }
}