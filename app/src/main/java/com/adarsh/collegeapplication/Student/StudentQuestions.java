package com.adarsh.collegeapplication.Student;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.collegeapplication.Adapter.NotessStudentAdapter;
import com.adarsh.collegeapplication.Adapter.QuestionsStudentAdapter;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.ViewNotesModel;
import com.adarsh.collegeapplication.model.ViewQuestionModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentQuestions extends AppCompatActivity {

    private RecyclerView questionRecyclerview;
    String stud_id,clg_id,stud_name,batch,reg_no,dept,dob,stud_email,stud_phone,
            parent_phone,stud_photo,semester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_questions);
        initView();
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

        new Retro().getApi().VIEW_QUESTION_MODEL_CALL(dept,semester,clg_id).enqueue(new Callback<ViewQuestionModel>() {
            @Override
            public void onResponse(Call<ViewQuestionModel> call, Response<ViewQuestionModel> response) {
                ViewQuestionModel viewQuestionModel=response.body();
                if(viewQuestionModel.getStatus().equalsIgnoreCase("success"))
                {
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                    questionRecyclerview.setLayoutManager(linearLayoutManager);
                    QuestionsStudentAdapter questionsStudentAdapter=new QuestionsStudentAdapter(getApplicationContext(),viewQuestionModel);
                    questionRecyclerview.setAdapter(questionsStudentAdapter);
                }
            }

            @Override
            public void onFailure(Call<ViewQuestionModel> call, Throwable t) {

            }
        });
    }

    private void initView() {
        questionRecyclerview = (RecyclerView) findViewById(R.id.question_recyclerview);
    }
}
