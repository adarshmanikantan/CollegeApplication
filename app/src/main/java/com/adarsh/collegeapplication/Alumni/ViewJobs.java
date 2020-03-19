package com.adarsh.collegeapplication.Alumni;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.adarsh.collegeapplication.Adapter.ViewJobsAdapter;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.AddJobModel;
import com.adarsh.collegeapplication.model.ViewJobsbyAlumniModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewJobs extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_jobs);
        recyclerView = findViewById(R.id.posts_recycler);

        SharedPreferences alumnipreferences = getApplicationContext().getSharedPreferences("alumni", MODE_PRIVATE);


        new Retro().getApi().VIEW_JOBSBY_ALUMNI_MODEL_CALL(alumnipreferences.getString("alumniid", null), alumnipreferences.getString("collegeid", null)).enqueue(new Callback<ViewJobsbyAlumniModel>() {
            @Override
            public void onResponse(Call<ViewJobsbyAlumniModel> call, Response<ViewJobsbyAlumniModel> response) {
                ViewJobsbyAlumniModel viewJobsbyAlumniModel=response.body();
                if(viewJobsbyAlumniModel.getStatus().equalsIgnoreCase("success"))
                {
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    ViewJobsAdapter adapter=new ViewJobsAdapter(getApplicationContext(),viewJobsbyAlumniModel);
                    recyclerView.setAdapter(adapter);
                }
                else
                {
                    Toast.makeText(ViewJobs.this, "No jobs have been added yet", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ViewJobsbyAlumniModel> call, Throwable t) {

            }
        });

    }
}

