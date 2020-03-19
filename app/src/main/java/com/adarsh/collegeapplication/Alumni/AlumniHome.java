package com.adarsh.collegeapplication.Alumni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.adarsh.collegeapplication.R;

public class AlumniHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumni_home);
    }

    public void PostJobsClick(View view) {
        Intent intent=new Intent(AlumniHome.this,PostJobs.class);
        startActivity(intent);
    }

    public void ViewJobsClick(View view) {
        Intent intent=new Intent(AlumniHome.this,ViewJobs.class);
        startActivity(intent);
    }
}
