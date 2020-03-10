package com.adarsh.collegeapplication.Staff;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.adarsh.collegeapplication.Adapter.StaffAdapter;
import com.adarsh.collegeapplication.College.AddStaffActivity;
import com.adarsh.collegeapplication.College.SemesterActivity;
import com.adarsh.collegeapplication.College.ViewStudents;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.ViewStaffModel;

import java.util.ArrayList;

import nl.psdcompany.duonavigationdrawer.views.DuoMenuView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    RecyclerView recyclerView;
    Button button;
    ArrayList<String>semesterList;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView=root.findViewById(R.id.main_student_recycler);
        button=root.findViewById(R.id.addstudentbtn);
        semesterList=new ArrayList<String>();
        semesterList.add("1");
        semesterList.add("2");
        semesterList.add("3");
        semesterList.add("4");
        semesterList.add("5");
        semesterList.add("6");
        semesterList.add("7");
        semesterList.add("8");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),AddStudentActivity.class);
                startActivity(i);
            }
        });
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        MainFragment.VerticalAdapter verticalAdapter=new MainFragment.VerticalAdapter(semesterList);
        recyclerView.setAdapter(verticalAdapter);
        return root;
    }
    public class VerticalAdapter extends RecyclerView.Adapter<MainFragment.VerticalAdapter.MyViewHolder>
    {
        ArrayList<String>semesterList;
        public VerticalAdapter(ArrayList<String>semesterList)
        {
            this.semesterList=semesterList;
        }
        @NonNull
        @Override
        public MainFragment.VerticalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sem_row,parent,false);
            MainFragment.VerticalAdapter.MyViewHolder holder=new MainFragment.VerticalAdapter.MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
            holder.textView.setText(semesterList.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences sharedPreferences=getActivity().getSharedPreferences("sempref",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("semkey",semesterList.get(position));
                    editor.apply();
                    Intent i=new Intent(getActivity(),ViewStudents.class);
                    startActivity(i);
                }
            });
        }


        @Override
        public int getItemCount() {
            return semesterList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder
        {
            TextView textView;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                textView=itemView.findViewById(R.id.semtxt);
            }
        }
    }
}

