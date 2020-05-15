package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class jobListingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_listing_page);

        final Controller aController = (Controller) getApplicationContext();

        ArrayList<Job> jobs = new ArrayList<Job>();
        Button button1 = findViewById(R.id.jobListingButton1);
        if(aController.getViewingJobs().size() > 0)
            button1.setText(jobs.get(0).toString());

        Button button2 = findViewById(R.id.jobListingButton2);
        if(jobs.size() > 1)
            button2.setText(jobs.get(1).toString());

        Button button3 = findViewById(R.id.jobListingButton3);
        if(jobs.size() > 2)
            button3.setText(jobs.get(2).toString());

        Button button4 = findViewById(R.id.jobListingButton4);
        if(jobs.size() > 3)
            button4.setText(jobs.get(3).toString());

        Button button5 = findViewById(R.id.jobListingButton5);
        if(jobs.size() > 4)
            button5.setText(jobs.get(4).toString());

        Button button6 = findViewById(R.id.jobListingButton6);
        if(jobs.size() > 5)
            button6.setText(jobs.get(5).toString());

        Button button7 = findViewById(R.id.jobListingButton7);
        if(jobs.size() > 6)
            button7.setText(jobs.get(6).toString());

        Button button8 = findViewById(R.id.jobListingButton8);
        if(jobs.size() > 7)
            button8.setText(jobs.get(7).toString());

        Button button9 = findViewById(R.id.jobListingButton9);
        if(jobs.size() > 8)
            button9.setText(jobs.get(8).toString());

        Button button10 = findViewById(R.id.jobListingButton10);
        if(jobs.size() > 9)
            button10.setText(jobs.get(9).toString());

        Button button11 = findViewById(R.id.jobListingButton11);
        if(jobs.size() > 10)
            button11.setText(jobs.get(10).toString());

        Button button12 = findViewById(R.id.jobListingButton12);
        if(jobs.size() > 11)
            button12.setText(jobs.get(11).toString());

        Button button13 = findViewById(R.id.jobListingButton13);
        if(jobs.size() > 12)
            button13.setText(jobs.get(12).toString());

        Button button14 = findViewById(R.id.jobListingButton14);
        if(jobs.size() > 13)
            button14.setText(jobs.get(13).toString());

        Button button15 = findViewById(R.id.jobListingButton15);
        if(jobs.size() > 14)
            button15.setText(jobs.get(14).toString());

        Button button16 = findViewById(R.id.jobListingButton16);
        if(jobs.size() > 15)
            button16.setText(jobs.get(15).toString());

        Button button17 = findViewById(R.id.jobListingButton17);
        if(jobs.size() > 16)
            button17.setText(jobs.get(16).toString());

        Button button18 = findViewById(R.id.jobListingButton18);
        if(jobs.size() > 17)
            button18.setText(jobs.get(17).toString());

        Button button19 = findViewById(R.id.jobListingButton19);
        if(jobs.size() > 18)
            button19.setText(jobs.get(18).toString());

        Button button20 = findViewById(R.id.jobListingButton20);
        if(jobs.size() > 19)
            button20.setText(jobs.get(19).toString());

    }

    public void performOpenJobApplication(View v){
        Intent intent = new Intent(this, Application.class);
        startActivity(intent);
    }

    public void performOpenFilterMenu(View v){
        Intent intent = new Intent(this, FiltrationMenu.class);
        startActivity(intent);
    }

    public void performOpenProfile(View v){
        Intent intent = new Intent(this, ApplicantProfile.class);
        startActivity(intent);
    }

    public void open1(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(0);
        if(aController.getViewingJobs().size() > 0)
            performOpenJobApplication(v);
    }
    public void open2(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(1);
        if(aController.getViewingJobs().size() > 1)
            performOpenJobApplication(v);
    }
    public void open3(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(2);
        if(aController.getViewingJobs().size() > 2)
            performOpenJobApplication(v);
    }
    public void open4(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(3);
        if(aController.getViewingJobs().size() > 3)
            performOpenJobApplication(v);
    }
    public void open5(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(4);
        if(aController.getViewingJobs().size() > 4)
            performOpenJobApplication(v);
    }
    public void open6(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(5);
        if(aController.getViewingJobs().size() > 5)
         performOpenJobApplication(v);
    }
    public void open7(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(6);
        if(aController.getViewingJobs().size() > 6)
            performOpenJobApplication(v);
    }
    public void open8(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(7);
        if(aController.getViewingJobs().size() > 7)
            performOpenJobApplication(v);
    }
    public void open9(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(8);
        if(aController.getViewingJobs().size() > 8)
            performOpenJobApplication(v);
    }
    public void open10(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(9);
        if(aController.getViewingJobs().size() > 9)
            performOpenJobApplication(v);
    }
    public void open11(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(10);
        if(aController.getViewingJobs().size() > 10)
            performOpenJobApplication(v);
    }
    public void open12(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(11);
        if(aController.getViewingJobs().size() > 11)
            performOpenJobApplication(v);
    }
    public void open13(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(12);
        if(aController.getViewingJobs().size() > 12)
            performOpenJobApplication(v);
    }
    public void open14(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(13);
        if(aController.getViewingJobs().size() > 13)
            performOpenJobApplication(v);
    }
    public void open15(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(14);
        if(aController.getViewingJobs().size() > 14)
            performOpenJobApplication(v);
    }
    public void open16(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(15);
        if(aController.getViewingJobs().size() > 15)
            performOpenJobApplication(v);
    }
    public void open17(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(16);
        if(aController.getViewingJobs().size() > 16)
            performOpenJobApplication(v);
    }
    public void open18(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(17);
        if(aController.getViewingJobs().size() > 17)
            performOpenJobApplication(v);
    }
    public void open19(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(18);
        if(aController.getViewingJobs().size() > 18)
            performOpenJobApplication(v);
    }
    public void open20(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(19);
        if(aController.getViewingJobs().size() > 19)
            performOpenJobApplication(v);
    }
    public void refresh(View v){
        final Controller aController = (Controller) getApplicationContext();
        if(aController.getJobRefreshNumber() < 9){
            aController.setJobRefreshNumber(aController.getJobRefreshNumber() + 1);
            Intent intent = new Intent(this, jobListingPage.class);
            startActivity(intent);
        }else{
            Toast toast = Toast.makeText(getApplicationContext(), "Edit filter settings to see new jobs", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
