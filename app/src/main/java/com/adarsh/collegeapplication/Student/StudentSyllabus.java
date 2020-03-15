package com.adarsh.collegeapplication.Student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.adarsh.collegeapplication.Adapter.SyllabusStaffAdapter;
import com.adarsh.collegeapplication.Adapter.SyllabusStudentAdapter;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.ViewSyllabusModel;
import com.adarsh.collegeapplication.model.ViewSyllabusbyStaffModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentSyllabus extends AppCompatActivity {
    RecyclerView recyclerView;
    String stud_id,clg_id,stud_name,batch,reg_no,dept,dob,stud_email,stud_phone,
           parent_phone,stud_photo,semester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_syllabus);

        recyclerView=findViewById(R.id.student_syllabusrecycler);
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("student",MODE_PRIVATE);
       stud_id=sharedPreferences.getString("stud_id",null);
       clg_id= sharedPreferences.getString("college_id",null);
       stud_name= sharedPreferences.getString("stud_name",null);
        batch=sharedPreferences.getString("batch",null);
       reg_no=sharedPreferences.getString("reg_no",null);
       dept=sharedPreferences.getString("department",null);
       dob=sharedPreferences.getString("dob",null);
       stud_email=sharedPreferences.getString("stud_email",null);
        stud_phone=sharedPreferences.getString("stud_phone",null);
        parent_phone=sharedPreferences.getString("parent_phone",null);
        stud_photo=sharedPreferences.getString("stud_photo",null);
        semester=sharedPreferences.getString("semester",null);

        new Retro().getApi().VIEW_SYLLABUS_MODEL_CALL(dept,semester,clg_id).enqueue(new Callback<ViewSyllabusModel>() {
            @Override
            public void onResponse(Call<ViewSyllabusModel> call, Response<ViewSyllabusModel> response) {
                ViewSyllabusModel viewSyllabusModel=response.body();
                if(viewSyllabusModel.getStatus().equalsIgnoreCase("success"))
                {
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    SyllabusStudentAdapter syllabusStudentAdapter=new SyllabusStudentAdapter(getApplicationContext(),viewSyllabusModel);
                    recyclerView.setAdapter(syllabusStudentAdapter);
                }
            }

            @Override
            public void onFailure(Call<ViewSyllabusModel> call, Throwable t) {

            }
        });
    }
}
