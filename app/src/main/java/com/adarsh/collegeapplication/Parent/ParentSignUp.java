package com.adarsh.collegeapplication.Parent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.adarsh.collegeapplication.Parent_Login;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.ParentSignUpModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ParentSignUp extends AppCompatActivity {

    EditText name,regno,email,phone,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_sign_up);

        name=findViewById(R.id.parentreg_name);
        regno=findViewById(R.id.parentreg_registrn);
        email=findViewById(R.id.parentreg_email);
        phone=findViewById(R.id.parentreg_phone);
        password=findViewById(R.id.parentreg_pswd);
    }

    public void parentSignUpClick(View view) {
    if(name.getText().toString().equals(""))
    {
        Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show();
    }
else if(regno.getText().toString().equals(""))
    {
        Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show();

    }
else if(email.getText().toString().equals(""))
    {
        Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show();

    }
    else if(phone.getText().toString().equals(""))
    {
        Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show();

    }
    else if(password.getText().toString().equals(""))
    {
        Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show();

    }
    else
    {
        new Retro().getApi().PARENT_SIGN_UP_MODEL_CALL(name.getText().toString(),email.getText().toString(),phone.getText().toString(),regno.getText().toString(),password.getText().toString())
                .enqueue(new Callback<ParentSignUpModel>() {
                    @Override
                    public void onResponse(Call<ParentSignUpModel> call, Response<ParentSignUpModel> response) {
                        ParentSignUpModel parentSignUpModel=response.body();
                        if(parentSignUpModel.getStatus().equalsIgnoreCase("success"))
                        {
                            Toast.makeText(ParentSignUp.this, parentSignUpModel.getStatus(), Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(ParentSignUp.this, Parent_Login.class);
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(ParentSignUp.this, parentSignUpModel.getStatus(), Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<ParentSignUpModel> call, Throwable t) {
                    }
                });
    }


    }
}
