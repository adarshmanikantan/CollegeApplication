package com.adarsh.collegeapplication.Adapter;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.model.ViewEventModel;
import com.adarsh.collegeapplication.model.ViewSyllabusbyStaffModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.System.currentTimeMillis;

public class SyllabusStaffAdapter extends RecyclerView.Adapter<SyllabusStaffAdapter.MyViewHolder> {
    Context context;
    ViewSyllabusbyStaffModel viewSyllabusbyStaffModel;

    //    private ProgressDialog pDialog;
    public SyllabusStaffAdapter(Context context, ViewSyllabusbyStaffModel viewSyllabusbyStaffModel) {
        this.context = context;
        this.viewSyllabusbyStaffModel = viewSyllabusbyStaffModel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.syllabus_row, parent, false);
        SyllabusStaffAdapter.MyViewHolder holder = new SyllabusStaffAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.sub.setText(viewSyllabusbyStaffModel.getSyllabus().get(position).getSubject());
        holder.subcode.setText(viewSyllabusbyStaffModel.getSyllabus().get(position).getSubcode());

        holder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = viewSyllabusbyStaffModel.getSyllabus().get(position).getFiles();
                //   new DownloadFile().execute(url, "five-point-someone-chetan-bhagat_ebook.pdf");

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                holder.itemView.getContext().startActivity(browserIntent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return viewSyllabusbyStaffModel.getSyllabus().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView sub, subcode;
        Button download;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sub = itemView.findViewById(R.id.syllabus_txtview);
            subcode = itemView.findViewById(R.id.syllabus_subcode);
            download = itemView.findViewById(R.id.syllabus_download);
        }
    }

    }



