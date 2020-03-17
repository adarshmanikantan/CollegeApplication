package com.adarsh.collegeapplication.College;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Staff.AddAttendenceActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

public class StudentProfile extends AppCompatActivity {
    LinearLayout linearLayout;
    TextView name,batch,semester,regno,dept,dob,stud_email,stud_phone,parent_phone;
    ImageView studentPhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        linearLayout=findViewById(R.id.linearLayoutstudent);
        name=findViewById(R.id.studentnametext);
        batch=findViewById(R.id.studentbatch);
        semester=findViewById(R.id.studentSemester);
        regno=findViewById(R.id.student_regno);
        dept=findViewById(R.id.studentnamedept);
        dob=findViewById(R.id.studentdob);
        stud_email=findViewById(R.id.studentemail);
        stud_phone=findViewById(R.id.student_phone);
        parent_phone=findViewById(R.id.parentphone);
        studentPhoto=findViewById(R.id.studentimageview);
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("studentpref", Context.MODE_PRIVATE);
//        sharedPreferences.getString("clgid",null);
//        sharedPreferences.getString("stud_name",null);
//        sharedPreferences.getString("batch",null);
//        sharedPreferences.getString("regno",null);
//        sharedPreferences.getString("department",null);
//        sharedPreferences.getString("dob",null);
//        sharedPreferences.getString("stud_email",null);
//        sharedPreferences.getString("stud_phone",null);
//        sharedPreferences.getString("parent_phone",null);
//        sharedPreferences.getString("semester",null);
//
        Glide
                .with(getApplicationContext()).asBitmap().load( sharedPreferences.getString("student_photo",null))///image
                .placeholder(R.drawable.ic_add_black_24dp)
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        studentPhoto.setImageBitmap(resource);
                        Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(@Nullable Palette palette) {
                                int defaultValue = 0x000000;
                                int vibrant = palette.getDominantColor(defaultValue);
                                linearLayout.setBackgroundColor(vibrant);
                            }
                        });
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
         name.setText(sharedPreferences.getString("stud_name",null));
         batch.setText(sharedPreferences.getString("batch",null));
         semester.setText(sharedPreferences.getString("semester",null));
         regno.setText(sharedPreferences.getString("regno",null));
         dept.setText( sharedPreferences.getString("department",null));
         dob.setText(sharedPreferences.getString("dob",null));
         stud_email.setText(sharedPreferences.getString("stud_email",null));
         stud_phone.setText(sharedPreferences.getString("stud_phone",null));
    }

    public void addAttendence(View view) {
        Intent i=new Intent(StudentProfile.this, AddAttendenceActivity.class);
        startActivity(i);
    }
}
