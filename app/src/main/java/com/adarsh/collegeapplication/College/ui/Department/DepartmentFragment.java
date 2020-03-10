package com.adarsh.collegeapplication.College.ui.Department;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.collegeapplication.Adapter.DepartmentAdapter;
import com.adarsh.collegeapplication.College.ui.AddDepartment;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.ViewDepartmentModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


public class DepartmentFragment extends Fragment {

Button add_department;
RecyclerView department_recyclerview;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_department, container, false);
        add_department=root.findViewById(R.id.adddepartment);
        department_recyclerview=root.findViewById(R.id.department_recycler);
        add_department.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), AddDepartment.class);
                startActivity(i);
            }
        });
        SharedPreferences collegepreferences=getActivity().getSharedPreferences("collegepref",MODE_PRIVATE);
        String college_id=collegepreferences.getString("collegeidkey",null);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        department_recyclerview.setLayoutManager(linearLayoutManager);

        new Retro().getApi().VIEW_DEPARTMENT_MODEL_CALL(college_id).enqueue(new Callback<ViewDepartmentModel>() {
            @Override
            public void onResponse(Call<ViewDepartmentModel> call, Response<ViewDepartmentModel> response) {
                ViewDepartmentModel viewDepartmentModel=response.body();
                DepartmentAdapter departmentAdapter=new DepartmentAdapter(getActivity(),viewDepartmentModel);
                department_recyclerview.setAdapter(departmentAdapter);
            }

            @Override
            public void onFailure(Call<ViewDepartmentModel> call, Throwable t) {

            }
        });


        return root;
    }
}