package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class jobListingPage extends AppCompatActivity {

    private int pages;
    private int pageNumber;
    private ArrayList<Job> jobs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_listing_page);

        final Controller aController = (Controller) getApplicationContext();
        jobs = aController.getFilteredJobs();
        if(!jobs.equals(null)){
            if(!(jobs.size() == 0)){
                pageNumber = 0;
                if(jobs.size() % 20 == 0){
                    pages = jobs.size() / 20 - 1;
                }else{
                    pages = jobs.size() / 20;
                }
                setButtons();
            }
        }
    }

    public void setButtons(){
        Button button1 = findViewById(R.id.jobListingButton1);
        if(jobs.size() > pageNumber * 20)
            button1.setText(jobs.get(pageNumber * 20).toString());

        Button button2 = findViewById(R.id.jobListingButton2);
        if(jobs.size() > pageNumber * 20 + 1)
            button2.setText(jobs.get(pageNumber * 20 + 1).toString());

        Button button3 = findViewById(R.id.jobListingButton3);
        if(jobs.size() > pageNumber * 20 + 2)
            button3.setText(jobs.get(pageNumber * 20 + 2).toString());

        Button button4 = findViewById(R.id.jobListingButton4);
        if(jobs.size() > pageNumber * 20 + 3)
            button4.setText(jobs.get(pageNumber * 20 + 3).toString());

        Button button5 = findViewById(R.id.jobListingButton5);
        if(jobs.size() > pageNumber * 20 + 4)
            button5.setText(jobs.get(pageNumber * 20 + 4).toString());

        Button button6 = findViewById(R.id.jobListingButton6);
        if(jobs.size() > pageNumber * 20 + 5)
            button6.setText(jobs.get(pageNumber * 20 + 5).toString());

        Button button7 = findViewById(R.id.jobListingButton7);
        if(jobs.size() > pageNumber * 20 + 6)
            button7.setText(jobs.get(pageNumber * 20 + 6).toString());

        Button button8 = findViewById(R.id.jobListingButton8);
        if(jobs.size() > pageNumber * 20 + 7)
            button8.setText(jobs.get(pageNumber * 20 + 7).toString());

        Button button9 = findViewById(R.id.jobListingButton9);
        if(jobs.size() > pageNumber * 20 + 8)
            button9.setText(jobs.get(pageNumber * 20 + 8).toString());

        Button button10 = findViewById(R.id.jobListingButton10);
        if(jobs.size() > pageNumber * 20 + 9)
            button10.setText(jobs.get(pageNumber * 20 + 9).toString());

        Button button11 = findViewById(R.id.jobListingButton11);
        if(jobs.size() > pageNumber * 20 + 10)
            button11.setText(jobs.get(pageNumber * 20 + 10).toString());

        Button button12 = findViewById(R.id.jobListingButton12);
        if(jobs.size() > pageNumber * 20 + 11)
            button12.setText(jobs.get(pageNumber * 20 + 11).toString());

        Button button13 = findViewById(R.id.jobListingButton13);
        if(jobs.size() > pageNumber * 20 + 12)
            button13.setText(jobs.get(pageNumber * 20 + 12).toString());

        Button button14 = findViewById(R.id.jobListingButton14);
        if(jobs.size() > pageNumber * 20 + 13)
            button14.setText(jobs.get(pageNumber * 20 + 13).toString());

        Button button15 = findViewById(R.id.jobListingButton15);
        if(jobs.size() > pageNumber * 20 + 14)
            button15.setText(jobs.get(pageNumber * 20 + 14).toString());

        Button button16 = findViewById(R.id.jobListingButton16);
        if(jobs.size() > pageNumber * 20 + 15)
            button16.setText(jobs.get(pageNumber * 20 + 15).toString());

        Button button17 = findViewById(R.id.jobListingButton17);
        if(jobs.size() > pageNumber * 20 + 16)
            button17.setText(jobs.get(pageNumber * 20 + 16).toString());

        Button button18 = findViewById(R.id.jobListingButton18);
        if(jobs.size() > pageNumber * 20 + 17)
            button18.setText(jobs.get(pageNumber * 20 + 17).toString());

        Button button19 = findViewById(R.id.jobListingButton19);
        if(jobs.size() > pageNumber * 20 + 18)
            button19.setText(jobs.get(pageNumber * 20 + 18).toString());

        Button button20 = findViewById(R.id.jobListingButton20);
        if(jobs.size() > pageNumber * 20 + 19)
            button20.setText(jobs.get(pageNumber * 20 + 19).toString());
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
        aController.setJobNumber(pageNumber * 20);
        if(jobs.size() > pageNumber * 20)
            performOpenJobApplication(v);
    }
    public void open2(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(pageNumber * 20 + 1);
        if(jobs.size() > pageNumber * 20 + 1)
            performOpenJobApplication(v);
    }
    public void open3(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(pageNumber * 20 + 2);
        if(jobs.size() > pageNumber * 20 + 2)
            performOpenJobApplication(v);
    }
    public void open4(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(pageNumber * 20 + 3);
        if(jobs.size() > pageNumber * 20 + 3)
            performOpenJobApplication(v);
    }
    public void open5(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(pageNumber * 20 + 4);
        if(jobs.size() > pageNumber * 20 + 4)
            performOpenJobApplication(v);
    }
    public void open6(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(pageNumber * 20 + 5);
        if(jobs.size() > pageNumber * 20 + 5)
         performOpenJobApplication(v);
    }
    public void open7(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(pageNumber * 20 + 6);
        if(jobs.size() > pageNumber * 20 + 6)
            performOpenJobApplication(v);
    }
    public void open8(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(pageNumber * 20 + 7);
        if(jobs.size() > pageNumber * 20 + 7)
            performOpenJobApplication(v);
    }
    public void open9(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(pageNumber * 20 + 8);
        if(jobs.size() > pageNumber * 20 + 8)
            performOpenJobApplication(v);
    }
    public void open10(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(pageNumber * 20 + 9);
        if(jobs.size() > pageNumber * 20 + 9)
            performOpenJobApplication(v);
    }
    public void open11(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(pageNumber * 20 + 10);
        if(jobs.size() > pageNumber * 20 + 10)
            performOpenJobApplication(v);
    }
    public void open12(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(pageNumber * 20 + 11);
        if(jobs.size() > pageNumber * 20 + 11)
            performOpenJobApplication(v);
    }
    public void open13(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(pageNumber * 20 + 12);
        if(jobs.size() > pageNumber * 20 + 12)
            performOpenJobApplication(v);
    }
    public void open14(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(pageNumber * 20 + 13);
        if(jobs.size() > pageNumber * 20 + 13)
            performOpenJobApplication(v);
    }
    public void open15(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(pageNumber * 20 + 14);
        if(jobs.size() > pageNumber * 20 + 14)
            performOpenJobApplication(v);
    }
    public void open16(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(pageNumber * 20 + 15);
        if(jobs.size() > pageNumber * 20 + 15)
            performOpenJobApplication(v);
    }
    public void open17(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(pageNumber * 20 + 16);
        if(jobs.size() > pageNumber * 20 + 16)
            performOpenJobApplication(v);
    }
    public void open18(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(pageNumber * 20 + 17);
        if(jobs.size() > pageNumber * 20 + 17)
            performOpenJobApplication(v);
    }
    public void open19(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(pageNumber * 20 + 18);
        if(jobs.size() > pageNumber * 20 + 18)
            performOpenJobApplication(v);
    }
    public void open20(View v){
        final Controller aController = (Controller) getApplicationContext();
        aController.setJobNumber(pageNumber * 20 + 19);
        if(jobs.size() > pageNumber * 20 + 19)
            performOpenJobApplication(v);
    }

    public void goAhead(View v){
        if(pageNumber == pages){
            Toast toast = Toast.makeText(getApplicationContext(), "No Other Jobs", Toast.LENGTH_LONG);
            toast.show();
        }else{
            pageNumber += 1;
        }
        setButtons();
    }

    public void moveBack(View v){
        if(pageNumber == 0){
            Toast toast = Toast.makeText(getApplicationContext(), "This is the first page", Toast.LENGTH_LONG);
            toast.show();
        }else{
            pageNumber -= 1;
        }
        setButtons();
    }

}
