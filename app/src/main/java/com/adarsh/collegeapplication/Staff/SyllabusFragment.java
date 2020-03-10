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

import com.adarsh.collegeapplication.Adapter.SyllabusStaffAdapter;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Api;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.ViewSyllabusbyStaffModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class SyllabusFragment extends Fragment {

     RecyclerView syllabusrecycler;
     Button addsyllabusbtn;
     String staffid;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_syllabus, container, false);
         syllabusrecycler=view.findViewById(R.id.syllabusrecycler);
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("staffdetails",MODE_PRIVATE);
        staffid=sharedPreferences.getString("id",null);
         new Retro().getApi().VIEW_SYLLABUSBY_STAFF_MODEL_CALL(staffid).enqueue(new Callback<ViewSyllabusbyStaffModel>() {
             @Override
             public void onResponse(Call<ViewSyllabusbyStaffModel> call, Response<ViewSyllabusbyStaffModel> response) {
                 ViewSyllabusbyStaffModel viewSyllabusbyStaffModel=response.body();
                 if(viewSyllabusbyStaffModel.getStatus().equalsIgnoreCase("success"))
                 {
                     SyllabusStaffAdapter syllabusStaffAdapter=new SyllabusStaffAdapter(getActivity(),viewSyllabusbyStaffModel);
                     syllabusrecycler.setAdapter(syllabusStaffAdapter);
                 }
             }

             @Override
             public void onFailure(Call<ViewSyllabusbyStaffModel> call, Throwable t) {

             }
         });
         LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
         syllabusrecycler.setLayoutManager(linearLayoutManager);


        addsyllabusbtn=view.findViewById(R.id.syllabus_fab);
        addsyllabusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),AddSyllabus.class);
                startActivity(i);
            }
        });
        return view ;
    }

}
