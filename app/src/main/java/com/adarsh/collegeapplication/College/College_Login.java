package com.adarsh.collegeapplication.College;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.CollegeLoginModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class College_Login extends AppCompatActivity {

    EditText emailedit,passwordesit;
    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collegelogin);

        initViews();


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          Intent i=new Intent(College_Login.this,CollegeSignup.class);
          startActivity(i);
            }
        });
    }

    public void collegeLogin(View view) {
        if(emailedit.getText().toString().equals("")||passwordesit.getText().equals(""))
        {
            Toast.makeText(this, "Enter values", Toast.LENGTH_SHORT).show();
        }
        else {
            new Retro().getApi().COLLEGE_LOGIN_MODEL_CALL(emailedit.getText().toString(),passwordesit.getText().toString()).enqueue(new Callback<CollegeLoginModel>() {
                @Override
                public void onResponse(Call<CollegeLoginModel> call, Response<CollegeLoginModel> response) {
                   CollegeLoginModel loginModel=response.body();
                    if(loginModel.getStatus().equals("Success"))
                   {
                      String collegeId=loginModel.getUser_data().getCollege_id();
                       SharedPreferences collegepreferences=getApplicationContext().getSharedPreferences("collegepref",MODE_PRIVATE);
                       SharedPreferences.Editor editor=collegepreferences.edit();
                       editor.putString("collegeidkey",collegeId);
                       editor.apply();
                      Intent i=new Intent(College_Login.this,CollegeHome.class);
                      startActivity(i);
                   }
                    else{
                        Toast.makeText(College_Login.this, loginModel.getStatus(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<CollegeLoginModel> call, Throwable t) {

                }
            });

        }
    }
    public void initViews()
    {
        emailedit=findViewById(R.id.college_email_login);
        passwordesit=findViewById(R.id.college_password_login);
        signup=findViewById(R.id.clgsignup);
    }
}
