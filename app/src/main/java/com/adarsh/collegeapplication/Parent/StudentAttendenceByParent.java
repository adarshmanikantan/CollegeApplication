package com.adarsh.collegeapplication.Parent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.adarsh.collegeapplication.Adapter.AttendenceAdapter;
import com.adarsh.collegeapplication.Adapter.AttendenceAdapterforParent;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.Student.StudentAttendence;
import com.adarsh.collegeapplication.model.ViewAttendenceModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentAttendenceByParent extends AppCompatActivity {

    String college_id,regno;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendence_by_parent);

        recyclerView=findViewById(R.id.attendence_recycler);
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("parentpref",MODE_PRIVATE);
        college_id=sharedPreferences.getString("clgid",null);
        regno=sharedPreferences.getString("regno",null);

        new Retro().getApi().VIEW_ATTENDENCE_MODEL_CALL(college_id,regno).enqueue(new Callback<ViewAttendenceModel>() {
            @Override
            public void onResponse(Call<ViewAttendenceModel> call, Response<ViewAttendenceModel> response) {
                ViewAttendenceModel viewAttendenceModel=response.body();
                if(viewAttendenceModel.getStatus().equalsIgnoreCase("success"))
                {
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    AttendenceAdapterforParent attendenceAdapter=new AttendenceAdapterforParent(getApplicationContext(),viewAttendenceModel);
                    recyclerView.setAdapter(attendenceAdapter);
                }
                else
                {
                    Toast.makeText(StudentAttendenceByParent.this,viewAttendenceModel.getStatus(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ViewAttendenceModel> call, Throwable t) {
                Toast.makeText(StudentAttendenceByParent.this,t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
