package com.adarsh.collegeapplication.College;

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
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.AddStaffModel;
import com.adarsh.collegeapplication.model.CollegeRegistrationModel;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CollegeSignup extends AppCompatActivity {
    CircleImageView circleImageView;
    EditText name,address,email,phone,password;
    File imgfile;
    String picturePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_signup);
        name = findViewById(R.id.collegename_signup);
        address = findViewById(R.id.addstaffname);
        email = findViewById(R.id.addemail);
        phone = findViewById(R.id.addphone);
        password = findViewById(R.id.addpassword);

        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] options = {"Choose from Gallery", "Cancel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(CollegeSignup.this);
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
                circleImageView.setImageBitmap(thumbnail);
            }

        }
    }


    public void signUpClick(View view) {
        RequestBody namereq=RequestBody.create(MediaType.parse("text/plain"),name.getText().toString());
        RequestBody addressreq=RequestBody.create(MediaType.parse("text/plain"),address.getText().toString());
        RequestBody emailreq=RequestBody.create(MediaType.parse("text/plain"),email.getText().toString());
        RequestBody phonereq=RequestBody.create(MediaType.parse("text/plain"),phone.getText().toString());
        RequestBody pswdreq=RequestBody.create(MediaType.parse("text/plain"),password.getText().toString());


        MultipartBody.Part filePart = MultipartBody.Part.createFormData("avatar", imgfile.getName(), RequestBody.create(MediaType.parse("image/*"), imgfile));

        new Retro().getApi().COLLEGE_REGISTRATION_MODEL_CALL(namereq,addressreq,emailreq,phonereq,pswdreq,filePart).enqueue(new Callback<CollegeRegistrationModel>() {
            @Override
            public void onResponse(Call<CollegeRegistrationModel> call, Response<CollegeRegistrationModel> response) {
                CollegeRegistrationModel addStaffModel=response.body();
                if(addStaffModel.getStatus().equals("success"))
                {
                    Toast.makeText(getApplicationContext(),addStaffModel.getMessage(),Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(CollegeSignup.this, addStaffModel.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CollegeRegistrationModel> call, Throwable t) {
                Toast.makeText(CollegeSignup.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
