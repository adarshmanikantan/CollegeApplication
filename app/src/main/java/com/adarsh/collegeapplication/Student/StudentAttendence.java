package com.adarsh.collegeapplication.Student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.adarsh.collegeapplication.Adapter.AttendenceAdapter;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.ViewAttendenceModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentAttendence extends AppCompatActivity {

    String stud_id,clg_id,stud_name,batch,reg_no,dept,dob,stud_email,stud_phone,
            parent_phone,stud_photo,semester;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendence);
         recyclerView=findViewById(R.id.recycler_attendence);
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("student",MODE_PRIVATE);
        stud_id=sharedPreferences.getString("stud_id",null);
        clg_id= sharedPreferences.getString("college_id",null);
        stud_name= sharedPreferences.getString("stud_name",null);
        batch=sharedPreferences.getString("batch",null);
        reg_no=sharedPreferences.getString("reg_no",null);
       // Toast.makeText(this,reg_no+"/"+clg_id, Toast.LENGTH_SHORT).show();
        dept=sharedPreferences.getString("department",null);
        dob=sharedPreferences.getString("dob",null);
        stud_email=sharedPreferences.getString("stud_email",null);
        stud_phone=sharedPreferences.getString("stud_phone",null);
        parent_phone=sharedPreferences.getString("parent_phone",null);
        stud_photo=sharedPreferences.getString("stud_photo",null);
        semester=sharedPreferences.getString("semester",null);

        new Retro().getApi().VIEW_ATTENDENCE_MODEL_CALL(clg_id,reg_no).enqueue(new Callback<ViewAttendenceModel>() {
            @Override
            public void onResponse(Call<ViewAttendenceModel> call, Response<ViewAttendenceModel> response) {
                ViewAttendenceModel viewAttendenceModel=response.body();
                if(viewAttendenceModel.getStatus().equalsIgnoreCase("success"))
                {
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    AttendenceAdapter attendenceAdapter=new AttendenceAdapter(getApplicationContext(),viewAttendenceModel);
                    recyclerView.setAdapter(attendenceAdapter);
                }
                else
                {
                    Toast.makeText(StudentAttendence.this,viewAttendenceModel.getStatus(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ViewAttendenceModel> call, Throwable t) {
                Toast.makeText(StudentAttendence.this,t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
