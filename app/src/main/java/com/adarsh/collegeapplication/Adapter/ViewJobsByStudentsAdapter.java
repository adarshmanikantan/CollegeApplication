package com.adarsh.collegeapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.model.ViewJobsModel;
import com.adarsh.collegeapplication.model.ViewJobsbyAlumniModel;

public class ViewJobsByStudentsAdapter extends RecyclerView.Adapter<ViewJobsByStudentsAdapter.MyViewHolder> {
    Context context;
    ViewJobsModel viewJobsModel;
    public ViewJobsByStudentsAdapter(Context context, ViewJobsModel viewJobsModel)
    {
       this.context=context;
       this.viewJobsModel=viewJobsModel;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.jobs_row_alumni,parent,false);
        ViewJobsByStudentsAdapter.MyViewHolder holder=new ViewJobsByStudentsAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      holder.companyname.setText(viewJobsModel.getJobs().get(position).getCompany());
      holder.jobtitle.setText(viewJobsModel.getJobs().get(position).getTitle());
        holder.jobdesc.setText(viewJobsModel.getJobs().get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return viewJobsModel.getJobs().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
      TextView companyname,jobtitle,jobdesc;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            companyname=itemView.findViewById(R.id.cname);
            jobtitle=itemView.findViewById(R.id.cpost);
            jobdesc=itemView.findViewById(R.id.cdesc);
        }
    }
}
