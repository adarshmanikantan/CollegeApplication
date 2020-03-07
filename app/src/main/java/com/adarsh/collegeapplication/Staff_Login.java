package com.adarsh.collegeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class Staff_Login extends AppCompatActivity {
    EditText emp_id_edt,password_edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff__login);

        emp_id_edt=findViewById(R.id.et_emp_stafflogin);
        password_edt=findViewById(R.id.et_password_stafflogin

        );

    }

    public void staffLoginClick(View view) {
        new Retro().getApi().STAFF_LOGIN_MODEL_CALL(emp_id_edt.getText().toString(),password_edt.getText().toString())
                .enqueue(new Callback<StaffLoginModel>() {
                    @Override
                    public void onResponse(Call<StaffLoginModel> call, Response<StaffLoginModel> response) {
                        StaffLoginModel staffLoginModel=response.body();
                        if(staffLoginModel.getStatus().equalsIgnoreCase("success"))
                        {
                            Intent intent=new Intent(Staff_Login.this, StaffHome.class);
                            startActivity(intent);
                            Toast.makeText(Staff_Login.this,staffLoginModel.getStatus(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<StaffLoginModel> call, Throwable t) {

                    }
                });
    }
}
