package com.adarsh.collegeapplication.Student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.adarsh.collegeapplication.R;

public class StudentHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);
    }

    public void studentSyllabusClick(View view) {
        Intent i=new Intent(StudentHome.this,StudentSyllabus.class);
        startActivity(i);
    }

    public void studentEventsClick(View view) {
        Intent i=new Intent(StudentHome.this,StudentEvents.class);
        startActivity(i);
    }

    public void notesClick(View view) {
        Intent i=new Intent(StudentHome.this,StudentNotes.class);
        startActivity(i);
    }

    public void questionsClick(View view) {
        Intent i=new Intent(StudentHome.this,StudentQuestions.class);
        startActivity(i);
    }

    public void viewAttendence(View view) {
        Intent i=new Intent(StudentHome.this,StudentAttendence.class);
        startActivity(i);
    }

    public void viewJobsClick(View view) {
        Intent i=new Intent(StudentHome.this,ViewJobsStudent.class);
        startActivity(i);
    }
}
