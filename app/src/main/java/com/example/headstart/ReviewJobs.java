package com.example.headstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ReviewJobs extends AppCompatActivity {

    /**
     * the number of pages the employer can see (depending on the number of jobs they have)
     */
    private int pages;

    /**
     * The page number they are currently viewing
     */
    private int pageNumber;

    /**
     * The jobs that the employer has made and can view
     */
    private ArrayList<Job> jobs;

    /**
     * Opens the job viewing page and determines the total pages that can be viewed.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_jobs);

        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();

        if(!currentEmployer.getJobs().equals(null)){
            if(!(currentEmployer.getJobs().size() == 0)){
                pageNumber = 0;
                jobs = currentEmployer.getJobs();
                if(jobs.size() % 10 == 0){
                    pages = jobs.size() / 10 - 1;
                }else{
                    pages = jobs.size() / 10;
                }
                setButtons();
            }
        }
    }

    /**
     * Sets all the button text to the text from each job
     */
    public void setButtons(){
        Button test3 = findViewById(R.id.button3);
        if(jobs.size() > pageNumber * 10)
            test3.setText(jobs.get(pageNumber * 10).toString());
        Button test4 = findViewById(R.id.button4);
        if(jobs.size() > pageNumber * 10 + 1)
            test4.setText(jobs.get(pageNumber * 10 + 1).toString());
        Button test5 = findViewById(R.id.button5);
        if(jobs.size() > pageNumber * 10 + 2)
            test5.setText(jobs.get(pageNumber * 10 + 2).toString());
        Button test6 = findViewById(R.id.button6);
        if(jobs.size() > pageNumber * 10 + 3)
            test6.setText(jobs.get(pageNumber * 10 + 3).toString());
        Button test7 = findViewById(R.id.button7);
        if(jobs.size() > pageNumber * 10 + 4)
            test7.setText(jobs.get(pageNumber * 10 + 4).toString());
        Button test8 = findViewById(R.id.button8);
        if(jobs.size() > pageNumber * 10 + 5)
            test8.setText(jobs.get(pageNumber * 10 + 5).toString());
        Button test9 = findViewById(R.id.button9);
        if(jobs.size() > pageNumber * 10 + 6)
            test9.setText(jobs.get(pageNumber * 10 + 6).toString());
        Button test10 = findViewById(R.id.button10);
        if(jobs.size() > pageNumber * 10 + 7)
            test10.setText(jobs.get(pageNumber * 10 + 7).toString());
        Button test11 = findViewById(R.id.button11);
        if(jobs.size() > pageNumber * 10 + 8)
            test11.setText(jobs.get(pageNumber * 10 + 8).toString());
        Button test12 = findViewById(R.id.button12);
        if(jobs.size() > pageNumber * 10 + 9)
            test12.setText(jobs.get(pageNumber * 10 + 9).toString());
    }

    /**
     * opens job 1
     * @param v the view
     */
    public void open3(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
       if(jobs.size() > pageNumber * 10){
           aController.setJobNumber(0);
           Intent intent = new Intent(this, ReviseJob.class);
           startActivity(intent);
       }
    }

    /**
     * opens job 2
     * @param v the view
     */
    public void open4(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
        if(jobs.size() > pageNumber * 10 + 1){
            aController.setJobNumber(pageNumber * 10 + 1);
            Intent intent = new Intent(this, ReviseJob.class);
            startActivity(intent);
        }
    }

    /**
     * opens job 3
     * @param v the view
     */
    public void open5(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
        if(jobs.size() > pageNumber * 10 + 2){
            aController.setJobNumber(pageNumber * 10 + 2);
            Intent intent = new Intent(this, ReviseJob.class);
            startActivity(intent);
        }
    }

    /**
     * opens job 4
     * @param v the view
     */
    public void open6(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
        if(jobs.size() > pageNumber * 10 + 3){
            aController.setJobNumber(pageNumber * 10 + 3);
            Intent intent = new Intent(this, ReviseJob.class);
            startActivity(intent);
        }
    }

    /**
     * opens job 5
     * @param v the view
     */
    public void open7(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
        if(jobs.size() > pageNumber * 10 + 4){
            aController.setJobNumber(pageNumber * 10 + 4);
            Intent intent = new Intent(this, ReviseJob.class);
            startActivity(intent);
        }
    }

    /**
     * opens job 6
     * @param v the view
     */
    public void open8(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
        if(jobs.size() > pageNumber * 10 + 5){
            aController.setJobNumber(pageNumber * 10 + 5);
            Intent intent = new Intent(this, ReviseJob.class);
            startActivity(intent);
        }
    }

    /**
     * opens job 7
     * @param v the view
     */
    public void open9(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
        if(jobs.size() > pageNumber * 10 + 6){
            aController.setJobNumber(pageNumber * 10 + 6);
            Intent intent = new Intent(this, ReviseJob.class);
            startActivity(intent);
        }
    }

    /**
     * opens job 8
     * @param v the view
     */
    public void open10(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
        if(jobs.size() > pageNumber * 10 + 7){
            aController.setJobNumber(pageNumber * 10 + 7);
            Intent intent = new Intent(this, ReviseJob.class);
            startActivity(intent);
        }
    }

    /**
     * opens job 9
     * @param v the view
     */
    public void open11(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
        if(jobs.size() > pageNumber * 10 + 8){
            aController.setJobNumber(pageNumber * 10 + 8);
            Intent intent = new Intent(this, ReviseJob.class);
            startActivity(intent);
        }
    }

    /**
     * opens job 10
     * @param v the view
     */
    public void open12(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
        if(jobs.size() > pageNumber * 10 + 9){
            aController.setJobNumber(pageNumber * 10 + 9);
            Intent intent = new Intent(this, ReviseJob.class);
            startActivity(intent);
        }
    }

    /**
     * Allows the employer to view the jobs on the next page; returns a toast if there are no further pages
     * @param v the view
     */
    public void goAhead(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
        if(pageNumber == pages || currentEmployer.getJobs().equals(null)){
            Toast toast = Toast.makeText(getApplicationContext(), "No Other Jobs", Toast.LENGTH_LONG);
            toast.show();
        }else{
            pageNumber += 1;
        }
        setButtons();
    }

    /**
     * Allows the employer to view the jobs on the previous page; returns a toast if there are no previous pages
     * @param v the view
     */
    public void moveBack(View v){
        final Controller aController = (Controller) getApplicationContext();
        Employer currentEmployer = aController.getEmployer();
        if(pageNumber == 0 || currentEmployer.getJobs().equals(null)){
            Toast toast = Toast.makeText(getApplicationContext(), "This is the first page", Toast.LENGTH_LONG);
            toast.show();
        }else{
            pageNumber -= 1;
        }
        setButtons();
    }

    /**
     * Returns the employer to their home screen (their profile)
     * @param v the view
     */
    public void performReturnHome(View v){
        Intent intent = new Intent(this, employerMainPage.class);
        startActivity(intent);
    }
}
