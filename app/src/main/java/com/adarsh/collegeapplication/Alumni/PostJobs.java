package com.adarsh.collegeapplication.Alumni;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.AddJobModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostJobs extends AppCompatActivity {

    private TextInputEditText jobtitle;
    private TextInputLayout jobcompany;
    private TextInputEditText jobdesc;
    private TextInputEditText company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_jobs);
        initView();


    }

    public void postJobClick(View view) {
        if(jobtitle.getText().toString().equals(""))
        {
            jobtitle.setError("Enter details");
        }
        else if(company.getText().toString().equals(""))
        {
            company.setError("Enter details");

        }
        else if(jobdesc.getText().toString().equals(""))
        {
            jobdesc.setError("Enter details");

        }
        else
        {
            SharedPreferences alumnipreferences=getApplicationContext().getSharedPreferences("alumni",MODE_PRIVATE);


            new Retro().getApi().ADD_JOB_MODEL_CALL(alumnipreferences.getString("alumniid",null),alumnipreferences.getString("collegeid",null),
                    company.getText().toString(),jobtitle.getText().toString(),jobdesc.getText().toString()).enqueue(new Callback<AddJobModel>() {
                @Override
                public void onResponse(Call<AddJobModel> call, Response<AddJobModel> response) {
                    AddJobModel addJobModel=response.body();
                    if(addJobModel.getStatus().equalsIgnoreCase("success"))
                    {
                        Toast.makeText(PostJobs.this,addJobModel.getStatus(), Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(PostJobs.this,addJobModel.getStatus(), Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(Call<AddJobModel> call, Throwable t) {
                    Toast.makeText(PostJobs.this,t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }

    }

    private void initView() {
        jobtitle = findViewById(R.id.jobtitle);
        jobcompany = findViewById(R.id.jobcompany);
        jobdesc = findViewById(R.id.jobdesc);
        company=findViewById(R.id.jobcompanyy);
    }
}
