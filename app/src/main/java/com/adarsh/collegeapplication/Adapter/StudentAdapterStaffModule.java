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

import com.adarsh.collegeapplication.College.StudentProfile;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.model.ViewStudentModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

public class StudentAdapterStaffModule extends RecyclerView.Adapter<StudentAdapterStaffModule.myViewHolder> {
    Context context;
    ViewStudentModel viewStudentModel;
    int vibrant;
    public StudentAdapterStaffModule(Context context, ViewStudentModel viewStudentModel)
    {
        this.context=context;
        this.viewStudentModel=viewStudentModel;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.student_view_item_staff,parent,false);
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
//                        "id": "4",
//                                "college_id": "1",
//                                "stud_name": "Lekshmi",
//                                "batch": "2018-2020",
//                                "reg_no": "1214299",
//                                "department": "MCA",
//                                "dob": "09/07/1996",
//                                "stud_email": "lekshmi@gmail.com",
//                                "stud_phone": "90876543210",
//                                "parent_phone": "87654321908",
//                                "semester": "4",
//                                "stud_photo": "http://srishti-sy
                       String clgid=viewStudentModel.getStudents().get(position).getCollege_id();
                       String stud_name=viewStudentModel.getStudents().get(position).getStud_name();
                       String batch=viewStudentModel.getStudents().get(position).getBatch();
                       String regno=viewStudentModel.getStudents().get(position).getReg_no();
                       String department=viewStudentModel.getStudents().get(position).getDepartment();
                       String dob=viewStudentModel.getStudents().get(position).getDob();
                       String stud_email=viewStudentModel.getStudents().get(position).getStud_email();
                       String stud_phone=viewStudentModel.getStudents().get(position).getStud_phone();
                       String parent_phone=viewStudentModel.getStudents().get(position).getParent_phone();
                       String semester=viewStudentModel.getStudents().get(position).getSemester();
                       String student_photo=viewStudentModel.getStudents().get(position).getStud_photo();


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

                SharedPreferences sharedPreferences=context.getSharedPreferences("studentpref",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("clgid",viewStudentModel.getStudents().get(position).getCollege_id());
                editor.putString("stud_name",viewStudentModel.getStudents().get(position).getStud_name());
                editor.putString("batch",viewStudentModel.getStudents().get(position).getBatch());
                editor.putString("regno",viewStudentModel.getStudents().get(position).getReg_no());
                editor.putString("department",viewStudentModel.getStudents().get(position).getDepartment());
                editor.putString("dob",viewStudentModel.getStudents().get(position).getDob());
                editor.putString("stud_email",viewStudentModel.getStudents().get(position).getStud_email());
                editor.putString("stud_phone",viewStudentModel.getStudents().get(position).getStud_phone());
                editor.putString("parent_phone",viewStudentModel.getStudents().get(position).getParent_phone());
                editor.putString("semester",viewStudentModel.getStudents().get(position).getSemester());
                editor.putString("student_photo",viewStudentModel.getStudents().get(position).getStud_photo());
                editor.apply();

                Intent i=new Intent(context, StudentProfile.class);
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
            relativeLayout=itemView.findViewById(R.id.relativelayoutt);
            studentImageview=itemView.findViewById(R.id.studentsimage);
            textViewname=itemView.findViewById(R.id.studentsname);
            textViewregno=itemView.findViewById(R.id.studentsregno);
        }
    }
}


