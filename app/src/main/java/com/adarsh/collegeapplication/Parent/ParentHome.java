package com.adarsh.collegeapplication.Parent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.adarsh.collegeapplication.R;

public class ParentHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_home);
    }

    public void eventsClick(View view) {
    Intent i=new Intent(getApplicationContext(),ParentEvent.class);
    startActivity(i);
    }
}
