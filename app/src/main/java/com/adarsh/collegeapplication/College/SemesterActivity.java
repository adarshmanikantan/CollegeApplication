package com.adarsh.collegeapplication.College;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adarsh.collegeapplication.Adapter.DepartmentAdapter;
import com.adarsh.collegeapplication.R;

import java.util.ArrayList;

public class SemesterActivity extends AppCompatActivity {
   RecyclerView sem_recycler;
   ArrayList<String>semesterList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);

        sem_recycler=findViewById(R.id.sem_recycler);
        semesterList=new ArrayList<String>();
        semesterList.add("1");
        semesterList.add("2");
        semesterList.add("3");
        semesterList.add("4");
        semesterList.add("5");
        semesterList.add("6");
        semesterList.add("7");
        semesterList.add("8");

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        sem_recycler.setLayoutManager(linearLayoutManager);

        VerticalAdapter verticalAdapter=new VerticalAdapter(semesterList);
        sem_recycler.setAdapter(verticalAdapter);
    }

    public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.MyViewHolder>
    {
        ArrayList<String>semesterList;
      public VerticalAdapter(ArrayList<String>semesterList)
      {
          this.semesterList=semesterList;
      }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sem_row,parent,false);
            VerticalAdapter.MyViewHolder holder=new VerticalAdapter.MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
          holder.textView.setText(semesterList.get(position));
          holder.itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("sempref",MODE_PRIVATE);
                  SharedPreferences.Editor editor=sharedPreferences.edit();
                  editor.putString("semkey",semesterList.get(position));
                  editor.apply();
                  Intent i=new Intent(getApplicationContext(),ViewStudents.class);
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
