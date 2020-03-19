package com.adarsh.collegeapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.model.ViewJobsbyAlumniModel;

public class ViewJobsAdapter extends RecyclerView.Adapter<ViewJobsAdapter.MyViewHolder> {
    Context context;
    ViewJobsbyAlumniModel viewJobsbyAlumniModel;
    public ViewJobsAdapter(Context context,ViewJobsbyAlumniModel viewJobsbyAlumniModel)
    {
       this.context=context;
       this.viewJobsbyAlumniModel=viewJobsbyAlumniModel;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.jobs_row_alumni,parent,false);
        ViewJobsAdapter.MyViewHolder holder=new ViewJobsAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      holder.companyname.setText(viewJobsbyAlumniModel.getJobs().get(position).getCompany());
      holder.jobtitle.setText(viewJobsbyAlumniModel.getJobs().get(position).getTitle());
        holder.jobdesc.setText(viewJobsbyAlumniModel.getJobs().get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return viewJobsbyAlumniModel.getJobs().size();
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
