package com.adarsh.collegeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.Staff.StaffHome;
import com.adarsh.collegeapplication.model.StaffLoginModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Student_Login extends AppCompatActivity {

    EditText regno,password_edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__login);

        regno=findViewById(R.id.registrationno_edt);
        password_edt=findViewById(R.id.studentpswdedt);

    }

    public void staffLoginClick(View view) {
        new Retro().getApi().STAFF_LOGIN_MODEL_CALL(regno.getText().toString(),password_edt.getText().toString())
                .enqueue(new Callback<StaffLoginModel>() {
                    @Override
                    public void onResponse(Call<StaffLoginModel> call, Response<StaffLoginModel> response) {
                        StaffLoginModel staffLoginModel=response.body();
                        if(staffLoginModel.getStatus().equalsIgnoreCase("success"))
                        {
                            String clgid=staffLoginModel.getUser_data().getCollege_id();
                            String staffid=staffLoginModel.getUser_data().getId();
                            String staffname=staffLoginModel.getUser_data().getStaff_name();
                            String email=staffLoginModel.getUser_data().getEmail();
                            String phone=staffLoginModel.getUser_data().getPhone();
                            String post=staffLoginModel.getUser_data().getPost();
                            String department=staffLoginModel.getUser_data().getDepartment();
                            String password=staffLoginModel.getUser_data().getPassword();
                            String photo=staffLoginModel.getUser_data().getPhoto();

                            SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("staffdetails",MODE_PRIVATE);
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putString("clgid",clgid);
                            editor.putString("id",staffid);
                            editor.putString("staffname",staffname);
                            editor.putString("email",email);
                            editor.putString("phone",phone);
                            editor.putString("post",post);
                            editor.putString("department",department);
                            editor.putString("password",password);
                            editor.putString("photo",photo);
                            editor.apply();

//
//                            Intent intent=new Intent(Staff_Login.this, StaffHome.class);
//                            startActivity(intent);
//                            Toast.makeText(Staff_Login.this,staffLoginModel.getStatus(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<StaffLoginModel> call, Throwable t) {

                    }
                });
    }
}
