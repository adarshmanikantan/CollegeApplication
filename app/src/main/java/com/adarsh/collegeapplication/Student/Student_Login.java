package com.adarsh.collegeapplication.Student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.Staff.StaffHome;
import com.adarsh.collegeapplication.model.StaffLoginModel;
import com.adarsh.collegeapplication.model.StudentLoginModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Student_Login extends AppCompatActivity {

    EditText regno,email_edt;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__login);

        regno=findViewById(R.id.registrationno);
        email_edt=findViewById(R.id.email_edt);
        imageView=findViewById(R.id.loginimg);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email_edt.getText().toString().equals("")) {
                  email_edt.setError("Enter email address");
                } else if (regno.getText().toString().equals("")) {
                   regno.setError("Enter register number");
                } else {
                    new Retro().getApi().STUDENT_LOGIN_MODEL_CALL(email_edt.getText().toString(),regno.getText().toString()).enqueue(new Callback<StudentLoginModel>() {
                        @Override
                        public void onResponse(Call<StudentLoginModel> call, Response<StudentLoginModel> response) {
                            StudentLoginModel studentLoginModel = response.body();
                            Toast.makeText(Student_Login.this,studentLoginModel.getStatus(), Toast.LENGTH_SHORT).show();
                            if (studentLoginModel.getStatus().equalsIgnoreCase("success")) {
                                String stud_id=studentLoginModel.getStudent_data().getStud_id();
                                String college_id=studentLoginModel.getStudent_data().getCollege_id();
                                String stud_name=studentLoginModel.getStudent_data().getStud_name();
                                String batch=studentLoginModel.getStudent_data().getBatch();
                                String reg_no=studentLoginModel.getStudent_data().getReg_no();
                                String department=studentLoginModel.getStudent_data().getDepartment();
                                String dob=studentLoginModel.getStudent_data().getDob();
                                String stud_email=studentLoginModel.getStudent_data().getStud_email();
                                String stud_phone=studentLoginModel.getStudent_data().getStud_phone();
                                String parent_phone=studentLoginModel.getStudent_data().getParent_phone();
                                String stud_photo=studentLoginModel.getStudent_data().getStud_photo();
                                String semester=studentLoginModel.getStudent_data().getSemester();

                                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("student",MODE_PRIVATE);
                                SharedPreferences.Editor editor=sharedPreferences.edit();
                                editor.putString("stud_id",stud_id);
                                editor.putString("college_id",college_id);
                                editor.putString("stud_name",stud_name);
                                editor.putString("batch",batch);
                                editor.putString("reg_no",reg_no);
                                editor.putString("department",department);
                                editor.putString("dob",dob);
                                editor.putString("stud_email",stud_email);
                                editor.putString("stud_phone",stud_phone);
                                editor.putString("parent_phone",parent_phone);
                                editor.putString("stud_photo",stud_photo);
                                editor.putString("semester",semester);
                                editor.apply();
                                Intent i=new Intent(Student_Login.this,StudentHome.class);
                                startActivity(i);
                            }
                        }

                        @Override
                        public void onFailure(Call<StudentLoginModel> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }


}
