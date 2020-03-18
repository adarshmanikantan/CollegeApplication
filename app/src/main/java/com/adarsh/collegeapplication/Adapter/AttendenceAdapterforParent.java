package com.adarsh.collegeapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.model.ViewAttendenceModel;

public class AttendenceAdapterforParent extends RecyclerView.Adapter<AttendenceAdapterforParent.myViewHolder> {
    Context context;
    ViewAttendenceModel viewAttendenceModel;
    int vibrant;
    public AttendenceAdapterforParent(Context context, ViewAttendenceModel viewAttendenceModel)
    {
        this.context=context;
        this.viewAttendenceModel=viewAttendenceModel;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.attendence_row_parent,parent,false);
        myViewHolder holder=new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder holder, final int position) {

//        Glide.with(context).load(viewStaffModel.getStaffs().get(position).getPhoto()).into(holder.staffimageView);
        holder.textViewmonth.setText(viewAttendenceModel.getAttendance().get(position).getMonth());
        holder.textViewpresent.setText(viewAttendenceModel.getAttendance().get(position).getPresent());
        holder.textviewworking.setText(viewAttendenceModel.getAttendance().get(position).getWorking());
        holder.textviewpercentage.setText(viewAttendenceModel.getAttendance().get(position).getPercentage());
//        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(context, StudentProfileCollege.class);
//                holder.itemView.getContext().startActivity(i);
//
//            }
//        });
    }

    @Override
    public int getItemCount()
    {
        return viewAttendenceModel.getAttendance().size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder
    {
        RelativeLayout relativeLayout;
        ImageView studentImageview;
        TextView textViewmonth,textViewpresent,textviewworking,textviewpercentage;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewmonth=itemView.findViewById(R.id.p_month);
            textViewpresent=itemView.findViewById(R.id.p_present);
            textviewworking=itemView.findViewById(R.id.p_working);
            textviewpercentage=itemView.findViewById(R.id.p_percentage);

        }
    }
}


