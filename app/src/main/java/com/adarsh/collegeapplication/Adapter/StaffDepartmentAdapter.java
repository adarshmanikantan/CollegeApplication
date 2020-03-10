package com.adarsh.collegeapplication.Adapter;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.collegeapplication.College.SemesterActivity;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.model.ViewDepartmentModel;


public class StaffDepartmentAdapter extends RecyclerView.Adapter<StaffDepartmentAdapter.MyViewHolder>{

    Context context;
    ViewDepartmentModel viewDepartmentModel;
    String dept_id,dept_name;
    public StaffDepartmentAdapter(Context context, ViewDepartmentModel viewDepartmentModel)
    {
        this.context=context;
        this.viewDepartmentModel=viewDepartmentModel;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.staffdepartment_row,parent,false);
        StaffDepartmentAdapter.MyViewHolder holder=new StaffDepartmentAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
      dept_id=viewDepartmentModel.getDepartments().get(position).getDept_id();
      dept_name=viewDepartmentModel.getDepartments().get(position).getDept_name();

      holder.textViewname.setText(dept_name);

      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              SharedPreferences sharedPreferences=context.getSharedPreferences("prefer",Context.MODE_PRIVATE);
              SharedPreferences.Editor editor=sharedPreferences.edit();
              editor.putString("key1",dept_id);
              editor.putString("key2",viewDepartmentModel.getDepartments().get(position).getDept_name());
              editor.apply();

              Intent i=new Intent(context, SemesterActivity.class);
              holder.itemView.getContext().startActivity(i);
          }
      });

    }

    @Override
    public int getItemCount() {
        return viewDepartmentModel.getDepartments().size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textViewname;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewname=itemView.findViewById(R.id.s_departmenttextview);
        }
    }


}
