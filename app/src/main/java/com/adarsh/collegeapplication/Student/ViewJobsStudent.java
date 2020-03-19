package com.adarsh.collegeapplication.Student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.adarsh.collegeapplication.Adapter.ViewJobsAdapter;
import com.adarsh.collegeapplication.Adapter.ViewJobsByStudentsAdapter;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.ViewJobsModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewJobsStudent extends AppCompatActivity {
 RecyclerView recyclerView;
 String clg_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_jobs_student);

        recyclerView=findViewById(R.id.student_posts_recycler);

        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("student",MODE_PRIVATE);
        clg_id= sharedPreferences.getString("college_id",null);

        new Retro().getApi().VIEW_JOBS_MODEL_CALL(clg_id).enqueue(new Callback<ViewJobsModel>() {
            @Override
            public void onResponse(Call<ViewJobsModel> call, Response<ViewJobsModel> response) {
                ViewJobsModel viewJobsModel=response.body();
                if(viewJobsModel.getStatus().equalsIgnoreCase("success"))
                {
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                    recyclerView.setLayoutManager(linearLayoutManager);

                    ViewJobsByStudentsAdapter adapter=new ViewJobsByStudentsAdapter(getApplicationContext(),viewJobsModel);
                    recyclerView.setAdapter(adapter);
                }
                else {
                    Toast.makeText(ViewJobsStudent.this, "", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ViewJobsModel> call, Throwable t) {

            }
        });
    }
}
