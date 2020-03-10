package com.adarsh.collegeapplication.Staff;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.adarsh.collegeapplication.College.AddStaffActivity;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.AddStaffModel;
import com.adarsh.collegeapplication.model.AddStusdentModel;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddStudentActivity extends AppCompatActivity {

    ImageView imageView;
    EditText studentname;
    EditText batch, regno, dob, st_email, st_phone,
            parent_phone, post, semester;
    String s_clgid, s_name, s_batch, s_regno, s_dept, s_dob, s_st_email, s_st_phone,
            s_parent_phone, s_post, s_semester;
    File imgfile;
    String picturePath;
     Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        imageView =findViewById(R.id.addstudentimg);
        studentname =findViewById(R.id.addstudentname);
        batch =findViewById(R.id.addstudentbatch);
        regno =findViewById(R.id.addregno);
        dob =findViewById(R.id.addstudentname);
        st_email =findViewById(R.id.addstudentname);
        st_phone =findViewById(R.id.addstudentname);
        parent_phone =findViewById(R.id.addstudentname);
        post =findViewById(R.id.addstudentname);
        semester =findViewById(R.id.addstudentname);
        button=findViewById(R.id.addbutton);
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("staffdetails", MODE_PRIVATE);
        s_clgid = sharedPreferences.getString("clgid", null);
        s_post = sharedPreferences.getString("post", null);
        s_dept=sharedPreferences.getString("department",null);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] options = {"Choose from Gallery", "Cancel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(AddStudentActivity.this);
                builder.setTitle("Add Photo!");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {

                        if (options[item].equals("Choose from Gallery")) {
                            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            startActivityForResult(intent, 2);
                        } else if (options[item].equals("Cancel")) {
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s_name=studentname.getText().toString();
                s_batch=batch.getText().toString();
                s_regno=regno.getText().toString();
                s_dob=dob.getText().toString();
                s_st_email=st_email.getText().toString();
                s_st_phone=st_phone.getText().toString();
                s_parent_phone=parent_phone.getText().toString();
                s_semester=semester.getText().toString();
                RequestBody collegeId = RequestBody.create(MediaType.parse("text/plain"), s_clgid);
                RequestBody studentname = RequestBody.create(MediaType.parse("text/plain"),s_name);
                RequestBody batch = RequestBody.create(MediaType.parse("text/plain"),s_batch);
                RequestBody regno = RequestBody.create(MediaType.parse("text/plain"),s_regno);
                RequestBody depreq = RequestBody.create(MediaType.parse("text/plain"),s_dept);
                RequestBody dobreq = RequestBody.create(MediaType.parse("text/plain"),s_dob);
                RequestBody stemailreq = RequestBody.create(MediaType.parse("text/plain"),s_st_email);
                RequestBody stphonereq = RequestBody.create(MediaType.parse("text/plain"),s_st_phone);
                RequestBody ptphonereq = RequestBody.create(MediaType.parse("text/plain"),s_parent_phone);
                RequestBody postreq = RequestBody.create(MediaType.parse("text/plain"), s_post);
                RequestBody semreq = RequestBody.create(MediaType.parse("text/plain"), s_semester);


                MultipartBody.Part filePart = MultipartBody.Part.createFormData("avatar", imgfile.getName(), RequestBody.create(MediaType.parse("image/*"), imgfile));

                new Retro().getApi().ADD_STUSDENT_MODEL_CALL(collegeId,studentname,batch,regno,depreq,dobreq,stemailreq,stphonereq,ptphonereq,postreq,filePart,semreq).enqueue(new Callback<AddStusdentModel>() {
                    @Override
                    public void onResponse(Call<AddStusdentModel> call, Response<AddStusdentModel> response) {
                        AddStusdentModel addStusdentModel = response.body();
                        if (addStusdentModel.getStatus().equals("success")) {
                            Toast.makeText(getApplicationContext(), addStusdentModel.getMessage(), Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(AddStudentActivity.this, addStusdentModel.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<AddStusdentModel> call, Throwable t) {
                        Toast.makeText(AddStudentActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 2) {
                Uri selectedImage = data.getData();
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                picturePath = c.getString(columnIndex);
                imgfile=new File(picturePath);
                c.close();
                Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
                Toast.makeText(this, picturePath + "", Toast.LENGTH_SHORT).show();
                imageView.setImageBitmap(thumbnail);
            }

        }
    }






}
