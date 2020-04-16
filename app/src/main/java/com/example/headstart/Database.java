package com.example.headstart;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Database {

    public FirebaseDatabase database;
    public DatabaseReference ref;


    public Database(FirebaseDatabase database) {
        this.database = database;
        Log.d("MainActivity", "Database test");
    }

    public void databaseTest (String val) {
        DatabaseReference ref = database.getReference("message");
        ref.setValue(val);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Log.d("MainActivity", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("MainActivity", "Failed to read value. ", error.toException());
            }
        });
    }
}
