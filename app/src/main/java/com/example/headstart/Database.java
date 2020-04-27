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

    private static final String TAG = "Database";

    public void basicReadWrite(FirebaseDatabase database, DatabaseReference ref) {
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
        writeNewUser("test1234", "1234");
        writeNewUser("test5678", "5678");
    }

    public FirebaseDatabase getFirebaseDatabase() {
        return database;
    }

    public DatabaseReference getDatabaseReference() {
        return ref;
    }

    public void writeNewUser(String ID, String password) {
        User user = new User();

        ref.child(ID).setValue(user);

        //why isn't this default constructed like the rest?
        ref.child(ID).child("password").setValue(password);
    }
}