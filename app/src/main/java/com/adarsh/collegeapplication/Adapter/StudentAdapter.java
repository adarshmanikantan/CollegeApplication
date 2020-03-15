package com.adarsh.collegeapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.collegeapplication.College.StaffProfile;
import com.adarsh.collegeapplication.College.StudentProfile;
import com.adarsh.collegeapplication.College.StudentProfileCollege;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.model.ViewStaffModel;
import com.adarsh.collegeapplication.model.ViewStudentModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.myViewHolder> {
    Context context;
    ViewStudentModel viewStudentModel;
    int vibrant;
    public StudentAdapter(Context context, ViewStudentModel viewStudentModel)
    {
        this.context=context;
        this.viewStudentModel=viewStudentModel;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.student_view_item,parent,false);
        myViewHolder holder=new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder holder, final int position) {
        Glide
                .with(context).asBitmap().load(viewStudentModel.getStudents().get(position).getStud_photo())///image
                .placeholder(R.drawable.ic_add_black_24dp)
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        holder.studentImageview.setImageBitmap(resource);
                        Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(@Nullable Palette palette) {
                                int defaultValue = 0x000000;
                                vibrant = palette.getDominantColor(defaultValue);
                                holder.relativeLayout.setBackgroundColor(vibrant);
                            }
                        });
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });

//        Glide.with(context).load(viewStaffModel.getStaffs().get(position).getPhoto()).into(holder.staffimageView);
        holder.textViewname.setText(viewStudentModel.getStudents().get(position).getStud_name());
        holder.textViewregno.setText(viewStudentModel.getStudents().get(position).getReg_no());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, StudentProfileCollege.class);
                holder.itemView.getContext().startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount()
    {
        return viewStudentModel.getStudents().size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder
    {
        RelativeLayout relativeLayout;
        ImageView studentImageview;
        TextView textViewname,textViewregno;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout=itemView.findViewById(R.id.relativelayout);
            studentImageview=itemView.findViewById(R.id.studentimage);
            textViewname=itemView.findViewById(R.id.studentname);
            textViewregno=itemView.findViewById(R.id.studentregno);
        }
    }
}


