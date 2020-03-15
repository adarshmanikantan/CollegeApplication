package com.adarsh.collegeapplication.Staff;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.adarsh.collegeapplication.Adapter.QuestionsStaffAdapter;
import com.adarsh.collegeapplication.Adapter.SyllabusStaffAdapter;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.ViewQuestionByStaffModel;
import com.adarsh.collegeapplication.model.ViewSyllabusbyStaffModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {

    RecyclerView recyclerView;
    Button button;
    String staffid;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_questions, container, false);
        recyclerView=root.findViewById(R.id.question_recycler);
        button=root.findViewById(R.id.addquestionbtn);
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("staffdetails",MODE_PRIVATE);
        staffid=sharedPreferences.getString("id",null);
        new Retro().getApi().VIEW_QUESTION_BY_STAFF_MODEL_CALL(staffid).enqueue(new Callback<ViewQuestionByStaffModel>() {
            @Override
            public void onResponse(Call<ViewQuestionByStaffModel> call, Response<ViewQuestionByStaffModel> response) {
                ViewQuestionByStaffModel viewQuestionByStaffModel=response.body();
                if(viewQuestionByStaffModel.getStatus().equalsIgnoreCase("success"))
                {
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    QuestionsStaffAdapter questionsStaffAdapter=new QuestionsStaffAdapter(getActivity(),viewQuestionByStaffModel);
                    recyclerView.setAdapter(questionsStaffAdapter);
                }
            }

            @Override
            public void onFailure(Call<ViewQuestionByStaffModel> call, Throwable t) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent=new Intent(getActivity(),AddQuestions.class);
                startActivity(intent);
            }
        });
        return root;
    }

}
