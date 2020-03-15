package com.adarsh.collegeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.adarsh.collegeapplication.Alumni.AlumniLogin;
import com.adarsh.collegeapplication.College.College_Login;
import com.adarsh.collegeapplication.Student.Student_Login;

public class Profile_Selection extends AppCompatActivity {

ImageView studentimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileselector);

        studentimg=findViewById(R.id.studentimg);
        studentimg.bringToFront();


    }

    public void studentClick(View view) {
        Intent i=new Intent(Profile_Selection.this, Student_Login.class);
        startActivity(i);
    }

    public void staffClick(View view) {
        Intent i=new Intent(Profile_Selection.this,Staff_Login.class);
        startActivity(i);
    }

    public void collegeClick(View view) {
        Intent i=new Intent(Profile_Selection.this, College_Login.class);
        startActivity(i);
    }

    public void parentClick(View view) {
        Intent i=new Intent(Profile_Selection.this,Parent_Login.class);
        startActivity(i);
    }

    public void alumniClick(View view) {
        Intent i=new Intent(Profile_Selection.this, AlumniLogin.class);
        startActivity(i);
    }
}
