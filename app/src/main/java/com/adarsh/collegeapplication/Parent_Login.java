package com.adarsh.collegeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.adarsh.collegeapplication.Parent.ParentHome;
import com.adarsh.collegeapplication.Parent.ParentSignUp;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.ParentLoginModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Parent_Login extends AppCompatActivity {
EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent__login);
        email=findViewById(R.id.et_parentemail_login);
        password=findViewById(R.id.et_parentpassword_login);
    }

    public void parentSignUpIntent(View view) {
        Intent i=new Intent(Parent_Login.this, ParentSignUp.class);
        startActivity(i);
    }

    public void loginClick(View view) {
        new Retro().getApi().PARENT_LOGIN_MODEL_CALL(email.getText().toString(),password.getText().toString())
                .enqueue(new Callback<ParentLoginModel>() {
                    @Override
                    public void onResponse(Call<ParentLoginModel> call, Response<ParentLoginModel> response) {
                        ParentLoginModel parentLoginModel=response.body();
                        if(parentLoginModel.getStatus().equalsIgnoreCase("success"))
                        {
                            String clgid=parentLoginModel.getUser_data().getCollege_id();
                            String studentid=parentLoginModel.getUser_data().getStud_id();
                            String parentid=parentLoginModel.getUser_data().getParent_id();
                            SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("parentpref",MODE_PRIVATE);
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putString("clgid",clgid);
                            editor.putString("studentid",studentid);
                            editor.putString("parentid",parentid);
                            editor.apply();
                            Toast.makeText(Parent_Login.this, parentLoginModel.getStatus(), Toast.LENGTH_SHORT).show();
                          Intent i=new Intent(Parent_Login.this, ParentHome.class);
                          startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(Parent_Login.this, parentLoginModel.getStatus(), Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<ParentLoginModel> call, Throwable t) {

                    }
                });

    }
}
