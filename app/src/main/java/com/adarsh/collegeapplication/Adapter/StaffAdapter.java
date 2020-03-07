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
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.model.ViewStaffModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.myViewHolder> {
   Context context;
   ViewStaffModel viewStaffModel;
    int vibrant;
public StaffAdapter(Context context, ViewStaffModel viewStaffModel)
{
this.context=context;
this.viewStaffModel=viewStaffModel;
}
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.staff_view_item,parent,false);
        myViewHolder holder=new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder holder, final int position) {
        Glide
                .with(context).asBitmap().load(viewStaffModel.getStaffs().get(position).getPhoto())///image
                .placeholder(R.drawable.ic_add_black_24dp)
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        holder.staffimageView.setImageBitmap(resource);
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
     holder.textViewname.setText(viewStaffModel.getStaffs().get(position).getStaff_name());
    holder.textViewdesignation.setText(viewStaffModel.getStaffs().get(position).getPost());
    holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences sharedPreferences=context.getSharedPreferences("pref",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("key1",viewStaffModel.getStaffs().get(position).getStaff_name());
            editor.putString("key2",viewStaffModel.getStaffs().get(position).getEmp_id());
            editor.putString("key3",viewStaffModel.getStaffs().get(position).getPost());
            editor.putString("key4",viewStaffModel.getStaffs().get(position).getDepartment());
            editor.putString("key5",viewStaffModel.getStaffs().get(position).getEmail());
            editor.putString("key6",viewStaffModel.getStaffs().get(position).getPhone());
            editor.putString("key7",viewStaffModel.getStaffs().get(position).getPhoto());
            editor.putInt("key8",vibrant);

            editor.apply();
            Intent i=new Intent(context,StaffProfile.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           context.startActivity(i);

        }
    });
    }

    @Override
    public int getItemCount()
    {
        return viewStaffModel.getStaffs().size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder
    {
        RelativeLayout relativeLayout;
        ImageView staffimageView;
        TextView textViewname,textViewdesignation;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout=itemView.findViewById(R.id.relativelayout);
            staffimageView=itemView.findViewById(R.id.staffimage);
            textViewname=itemView.findViewById(R.id.staffname);
            textViewdesignation=itemView.findViewById(R.id.staffdesignation);
        }
    }
}
