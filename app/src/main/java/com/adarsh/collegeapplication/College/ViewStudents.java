package com.adarsh.collegeapplication.College;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.adarsh.collegeapplication.Adapter.StudentAdapter;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.ViewStudentModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewStudents extends AppCompatActivity {

    RecyclerView recyclerView;
    String college_id,department_name,semester;
    Button addstudntbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students);

        addstudntbtn=findViewById(R.id.addstudentbtn);
        recyclerView=findViewById(R.id.student_recycler);
        SharedPreferences sharedPreferencs=getApplicationContext().getSharedPreferences("staffdetails",MODE_PRIVATE);
        String post=sharedPreferencs.getString("post",null);
        if(post.equals("HOD"))
        {
            addstudntbtn.setVisibility(View.VISIBLE);
        }
        SharedPreferences collegepreferences=getApplicationContext().getSharedPreferences("collegepref",MODE_PRIVATE);
        college_id=collegepreferences.getString("collegeidkey",null);
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("prefer", Context.MODE_PRIVATE);
         department_name=sharedPreferences.getString("key2",null);
        SharedPreferences sharedPref=getApplicationContext().getSharedPreferences("sempref",MODE_PRIVATE);
         semester=sharedPref.getString("semkey",null);

        new Retro().getApi().VIEW_STUDENT_MODEL_CALL(department_name,semester,college_id).enqueue(new Callback<ViewStudentModel>() {
             @Override
             public void onResponse(Call<ViewStudentModel> call, Response<ViewStudentModel> response) {
                 ViewStudentModel viewStudentModel = response.body();

                 Toast.makeText(ViewStudents.this, college_id+"/"+semester+"/"+department_name, Toast.LENGTH_SHORT).show();
                 if (viewStudentModel.getStatus().equalsIgnoreCase("success")) {
                     GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
                     recyclerView.setLayoutManager(gridLayoutManager);

                     StudentAdapter studentAdapter = new StudentAdapter(getApplicationContext(), viewStudentModel);
                     recyclerView.setAdapter(studentAdapter);

                 }
                 else
                 {
                    // Toast.makeText(ViewStudents.this, "Failed", Toast.LENGTH_SHORT).show();
                 }
             }

             @Override
             public void onFailure(Call<ViewStudentModel> call, Throwable t) {
                 Toast.makeText(ViewStudents.this, t.getMessage(), Toast.LENGTH_SHORT).show();
             }
         });
    }

    public void addStudentClick(View view) {

    }
}
