package com.adarsh.collegeapplication.College.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.adarsh.collegeapplication.College.ui.Department.DepartmentFragment;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Api;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.AddDepartmentModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDepartment extends AppCompatActivity {
 EditText department;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_department);
        department=findViewById(R.id.department_name);
    }

    public void saveClick(View view) {
        SharedPreferences collegepreferences=getApplicationContext().getSharedPreferences("collegepref",MODE_PRIVATE);
        String college_id=collegepreferences.getString("collegeidkey",null);
        new Retro().getApi().ADD_DEPARTMENT_MODEL_CALL(department.getText().toString(),college_id)
                .enqueue(new Callback<AddDepartmentModel>() {
                    @Override
                    public void onResponse(Call<AddDepartmentModel> call, Response<AddDepartmentModel> response) {
                        AddDepartmentModel addDepartmentModel=response.body();
                        if(addDepartmentModel.getStatus().equalsIgnoreCase("success"))
                        {
                            Toast.makeText(AddDepartment.this, addDepartmentModel.getStatus(), Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(getApplicationContext(), DepartmentFragment.class);
                            startActivity(i);
                        }
                    }

                    @Override
                    public void onFailure(Call<AddDepartmentModel> call, Throwable t) {

                    }
                });

    }
}
