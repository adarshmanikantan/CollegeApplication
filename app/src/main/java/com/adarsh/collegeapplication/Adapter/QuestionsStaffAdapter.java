package com.adarsh.collegeapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.model.ViewQuestionByStaffModel;
import com.adarsh.collegeapplication.model.ViewQuestionModel;

import java.io.File;
import java.io.IOException;

public class QuestionsStaffAdapter extends RecyclerView.Adapter<QuestionsStaffAdapter.MyViewHolder> {
    Context context;
    ViewQuestionByStaffModel viewQuestionModel;
//    private ProgressDialog pDialog;
    public QuestionsStaffAdapter(Context context, ViewQuestionByStaffModel viewQuestionModel)
    {
        this.context=context;
        this.viewQuestionModel=viewQuestionModel;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.questions_staff_row,parent,false);
        QuestionsStaffAdapter.MyViewHolder holder=new QuestionsStaffAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.sub.setText(viewQuestionModel.getQuesion_paper().get(position).getSubject());
        holder.subcode.setText(viewQuestionModel.getQuesion_paper().get(position).getSubcode());

        holder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=viewQuestionModel.getQuesion_paper().get(position).getFiles();
             //   new DownloadFile().execute(url, "five-point-someone-chetan-bhagat_ebook.pdf");
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                holder.itemView.getContext().startActivity(browserIntent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return viewQuestionModel.getQuesion_paper().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView sub,subcode;
        Button download;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sub=itemView.findViewById(R.id.questions_staff_subject);
            subcode=itemView.findViewById(R.id.questions_staff_subcode);
            download=itemView.findViewById(R.id.questions_staff_downloadbtn);
        }
    }
    private class DownloadFile extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //showpDialog();
        }

        @Override
        protected Void doInBackground(String... strings) {

            String fileUrl = strings[0];
// -> https://letuscsolutions.files.wordpress.com/2015/07/five-point-someone-chetan-bhagat_ebook.pdf
            String fileName = strings[1];
// ->five-point-someone-chetan-bhagat_ebook.pdf
            String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
            File folder = new File(extStorageDirectory, "PDF DOWNLOAD");
            folder.mkdir();

            File pdfFile = new File(folder, fileName);

            try{
                pdfFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
            FileDownloader.downloadFile(fileUrl, pdfFile);
            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
           // hidepDialog();
            Toast.makeText(context, "Download PDf successfully", Toast.LENGTH_SHORT).show();

            Log.d("Download complete", "----------");
        }
    }


//    private void showpDialog() {
//        if (!pDialog.isShowing())
//            pDialog.show();
//    }
//
//    private void hidepDialog() {
//        if (pDialog.isShowing())
//            pDialog.dismiss();
//    }

}
