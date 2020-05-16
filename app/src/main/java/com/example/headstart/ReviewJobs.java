package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReviewJobs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_jobs);

        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();

        if(currentEmployer.getJobs().equals(null)){

        }else{
            Button test3 = findViewById(R.id.button3);
            if(currentEmployer.getJobs().size() > 0)
                test3.setText(currentEmployer.getJobs().get(0).toString());
            Button test4 = findViewById(R.id.button4);
            if(currentEmployer.getJobs().size() > 1)
                test4.setText(currentEmployer.getJobs().get(1).toString());
            Button test5 = findViewById(R.id.button5);
            if(currentEmployer.getJobs().size() > 2)
                test5.setText(currentEmployer.getJobs().get(2).toString());
            Button test6 = findViewById(R.id.button6);
            if(currentEmployer.getJobs().size() > 3)
                test6.setText(currentEmployer.getJobs().get(3).toString());
            Button test7 = findViewById(R.id.button7);
            if(currentEmployer.getJobs().size() > 4)
                test7.setText(currentEmployer.getJobs().get(4).toString());
            Button test8 = findViewById(R.id.button8);
            if(currentEmployer.getJobs().size() > 5)
                test8.setText(currentEmployer.getJobs().get(5).toString());
            Button test9 = findViewById(R.id.button9);
            if(currentEmployer.getJobs().size() > 6)
                test9.setText(currentEmployer.getJobs().get(6).toString());
            Button test10 = findViewById(R.id.button10);
            if(currentEmployer.getJobs().size() > 7)
                test10.setText(currentEmployer.getJobs().get(7).toString());
            Button test11 = findViewById(R.id.button11);
            if(currentEmployer.getJobs().size() > 8)
                test11.setText(currentEmployer.getJobs().get(8).toString());
            Button test12 = findViewById(R.id.button12);
            if(currentEmployer.getJobs().size() > 9)
                test12.setText(currentEmployer.getJobs().get(9).toString());
        }
    }

    public void open3(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
       if(currentEmployer.getJobs().size() > 0){
           aController.setJobNumber(0);
           Intent intent = new Intent(this, ReviseJob.class);
           startActivity(intent);
       }
    }

    public void open4(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
        if(currentEmployer.getJobs().size() > 1){
            aController.setJobNumber(1);
            Intent intent = new Intent(this, ReviseJob.class);
            startActivity(intent);
        }
    }
    public void open5(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
        if(currentEmployer.getJobs().size() > 2){
            aController.setJobNumber(2);
            Intent intent = new Intent(this, ReviseJob.class);
            startActivity(intent);
        }
    }
    public void open6(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
        if(currentEmployer.getJobs().size() > 3){
            aController.setJobNumber(3);
            Intent intent = new Intent(this, ReviseJob.class);
            startActivity(intent);
        }
    }
    public void open7(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
        if(currentEmployer.getJobs().size() > 4){
            aController.setJobNumber(4);
            Intent intent = new Intent(this, ReviseJob.class);
            startActivity(intent);
        }
    }
    public void open8(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
        if(currentEmployer.getJobs().size() > 5){
            aController.setJobNumber(5);
            Intent intent = new Intent(this, ReviseJob.class);
            startActivity(intent);
        }
    }
    public void open9(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
        if(currentEmployer.getJobs().size() > 6){
            aController.setJobNumber(6);
            Intent intent = new Intent(this, ReviseJob.class);
            startActivity(intent);
        }
    }
    public void open10(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
        if(currentEmployer.getJobs().size() > 7){
            aController.setJobNumber(7);
            Intent intent = new Intent(this, ReviseJob.class);
            startActivity(intent);
        }
    }
    public void open11(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
        if(currentEmployer.getJobs().size() > 8){
            aController.setJobNumber(8);
            Intent intent = new Intent(this, ReviseJob.class);
            startActivity(intent);
        }
    }
    public void open12(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
        if(currentEmployer.getJobs().size() > 9){
            aController.setJobNumber(9);
            Intent intent = new Intent(this, ReviseJob.class);
            startActivity(intent);
        }
    }

    public void performReturnHome(View v){
        Intent intent = new Intent(this, employerMainPage.class);
        startActivity(intent);
    }
}
