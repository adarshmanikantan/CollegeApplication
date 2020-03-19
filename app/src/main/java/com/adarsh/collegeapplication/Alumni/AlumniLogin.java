package com.adarsh.collegeapplication.Alumni;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.AlumniLoginModel;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlumniLogin extends AppCompatActivity {

    private TextInputEditText alumniEmail;
    private TextInputEditText alumniPswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumni_login);
        initView();
    }

    public void AlumniLoginClick(View view) {

        if(alumniEmail.getText().toString().equals(""))
        {
            alumniEmail.setError("Enter Email");
        }
      else if(alumniPswd.getText().toString().equals(""))
        {
            alumniPswd.setError("Enter Password");
        }
      else{
          new Retro().getApi().ALUMNI_LOGIN_MODEL_CALL(alumniEmail.getText().toString(),alumniPswd.getText().toString()).enqueue(new Callback<AlumniLoginModel>() {
              @Override
              public void onResponse(Call<AlumniLoginModel> call, Response<AlumniLoginModel> response) {
                  AlumniLoginModel alumniLoginModel=response.body();
                  if(alumniLoginModel.getStatus().equalsIgnoreCase("Success"))
                  {
//                      "alumni_id": "1",
//                          "name": "Aarthi",
//                          "email": "aarthi.sics@gmail.com",
//                          "department": "MCA",
//                          "passout": "2018",
//                          "phone": "9791369503",
//                          "password": "qwerty",
//                          "college_id": "1"

                      SharedPreferences alumnipreferences=getApplicationContext().getSharedPreferences("alumni",MODE_PRIVATE);
                      SharedPreferences.Editor editor=alumnipreferences.edit();
                      editor.putString("alumniid",alumniLoginModel.getUser_data().getAlumni_id());
                      editor.putString("name",alumniLoginModel.getUser_data().getName());
                      editor.putString("email",alumniLoginModel.getUser_data().getEmail());
                      editor.putString("department",alumniLoginModel.getUser_data().getDepartment());
                      editor.putString("passout",alumniLoginModel.getUser_data().getPassout());
                      editor.putString("phone",alumniLoginModel.getUser_data().getPhone());
                      editor.putString("password",alumniLoginModel.getUser_data().getPassword());
                      editor.putString("collegeid",alumniLoginModel.getUser_data().getCollege_id());
                      editor.apply();

                      Intent i=new Intent(AlumniLogin.this,AlumniHome.class);
                      startActivity(i);
                  }
              }

              @Override
              public void onFailure(Call<AlumniLoginModel> call, Throwable t) {

              }
          });
        }
    }

    private void initView() {
        alumniEmail = findViewById(R.id.alumni_email);
        alumniPswd = findViewById(R.id.alumni_pswd);
    }
}
