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

    public Reference(String path) {
        database = FirebaseDatabase.getInstance();
        ref = database.getReference(path);
    }

    public Reference(String path, String ID) {
        database = FirebaseDatabase.getInstance();
        ref = database.getReference(path).child(ID);
    }
}
