package com.adarsh.collegeapplication.College;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.adarsh.collegeapplication.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import de.hdodenhof.circleimageview.CircleImageView;

public class StaffProfile extends AppCompatActivity {

    CircleImageView staffimage;
    TextView textname,textemp,textpost,textdept,textemail,textphone;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_profile);
        linearLayout=findViewById(R.id.linearLayout);
        staffimage=findViewById(R.id.staffimageview);
        textname=findViewById(R.id.staffnametext);
        textemp=findViewById(R.id.staffnameemp);
        textpost=findViewById(R.id.staffnamepost);
        textdept=findViewById(R.id.staffnamedept);
        textemail=findViewById(R.id.staffnameemail);
        textphone=findViewById(R.id.staffnamephone);

        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("pref",MODE_PRIVATE);
        Glide
                .with(getApplicationContext()).asBitmap().load(sharedPreferences.getString("key7",null))///image
                .placeholder(R.drawable.ic_add_black_24dp)
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        staffimage.setImageBitmap(resource);
                        Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(@Nullable Palette palette) {
                                int defaultValue = 0x000000;
                               int vibrant = palette.getDominantColor(defaultValue);
                                linearLayout.setBackgroundColor(vibrant);
                            }
                        });
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
        textname.setText(sharedPreferences.getString("key1",null));
        textemp.setText(sharedPreferences.getString("key2",null));
        textpost.setText(sharedPreferences.getString("key3",null));
        textdept.setText(sharedPreferences.getString("key4",null));
        textemail.setText(sharedPreferences.getString("key5",null));
        textphone.setText(sharedPreferences.getString("key6",null));

    }
}
