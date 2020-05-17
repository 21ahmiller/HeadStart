package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EditJob extends AppCompatActivity {

    /**
     * Creates page and sets contentView
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_job);
    }

    /**
     * Brings employer to the ReviewJobs page
     * @param v
     */
    public void returnToJobView (View v){
        Intent intent = new Intent(this, ReviewJobs.class);
        startActivity(intent);
    }
}
