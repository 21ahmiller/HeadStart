package com.example.headstart;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.renderscript.Sampler;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Reference{

    FirebaseDatabase database;
    DatabaseReference ref;
    String path;
    String ID;

    public Reference(String path) {
        database = FirebaseDatabase.getInstance();
        ref = database.getReference(path);
        this.path = path;
    }

    public Reference(String path, String ID) {
        database = FirebaseDatabase.getInstance();
        ref = database.getReference(path).child(ID);
        this.path = path;
        this.ID = ID;
    }

    public void readJob() {
        ValueEventListener jobListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Job job = dataSnapshot.getValue(Job.class);
                Log.i("Data", job.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Data", "loadJob:onCancelled", databaseError.toException());
            }
        };
        this.getReference().addValueEventListener(jobListener);
    }

    public DatabaseReference getReference() {
        return ref;
    }

    public String toString() {
        return path+ID;
    }
}
