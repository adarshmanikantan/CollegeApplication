package com.adarsh.collegeapplication.College.ui.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.collegeapplication.Adapter.StaffAdapter;
import com.adarsh.collegeapplication.College.AddStaffActivity;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.ViewStaffModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


public class StaffFragment extends Fragment {

RecyclerView recyclerView;
Button button;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_staff, container, false);
       recyclerView=root.findViewById(R.id.recyclerview);
       button=root.findViewById(R.id.addstaffbtn);
        SharedPreferences collegepreferences=getActivity().getSharedPreferences("collegepref",MODE_PRIVATE);
        new Retro().getApi().VIEW_STAFF_MODEL_CALL(collegepreferences.getString("collegeidkey",null)).enqueue(new Callback<ViewStaffModel>() {
            @Override
            public void onResponse(Call<ViewStaffModel> call, Response<ViewStaffModel> response) {
                ViewStaffModel viewStaffModel=response.body();

                if(viewStaffModel.getStatus().equalsIgnoreCase("success")) {
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 2);
                    recyclerView.setLayoutManager(gridLayoutManager);
                    StaffAdapter staffAdapter = new StaffAdapter(getActivity().getApplicationContext(), viewStaffModel);
                    recyclerView.setAdapter(staffAdapter);
                }else
                {
                    Toast.makeText(getActivity(), "No staff found", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ViewStaffModel> call, Throwable t) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), AddStaffActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }
}