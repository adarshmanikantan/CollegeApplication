package com.adarsh.collegeapplication.College;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.adarsh.collegeapplication.College.ui.home.StaffFragment;
import com.adarsh.collegeapplication.MainActivity;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.AddStaffModel;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddStaffActivity extends AppCompatActivity {

    CircleImageView circleImageView;
    EditText staff_name,emp_id,email,phone,post,department,password;
    File imgfile;
    String picturePath;
    Button addbutton;
    private String collegeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_staff);

        circleImageView = findViewById(R.id.imageView2);
        staff_name = findViewById(R.id.addstaffname);
        emp_id = findViewById(R.id.addemployeeid);
        email = findViewById(R.id.addemail);
        phone = findViewById(R.id.addphone);
        post = findViewById(R.id.addpost);
        department = findViewById(R.id.adddepartment);
        password = findViewById(R.id.addpassword);
        addbutton=findViewById(R.id.addbutton);

        final SharedPreferences collegepreferences=getApplicationContext().getSharedPreferences("collegepref",MODE_PRIVATE);
         collegeId=collegepreferences.getString("collegeidkey",null);
        Toast.makeText(this, collegeId, Toast.LENGTH_SHORT).show();
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] options = {"Choose from Gallery", "Cancel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(AddStaffActivity.this);
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

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestBody empidreq=RequestBody.create(MediaType.parse("text/plain"),emp_id.getText().toString());
                RequestBody staff_namereq=RequestBody.create(MediaType.parse("text/plain"),staff_name.getText().toString());
                RequestBody emailreq=RequestBody.create(MediaType.parse("text/plain"),email.getText().toString());
                RequestBody phonereq=RequestBody.create(MediaType.parse("text/plain"),phone.getText().toString());
                RequestBody postreq=RequestBody.create(MediaType.parse("text/plain"),post.getText().toString());
                RequestBody depreq=RequestBody.create(MediaType.parse("text/plain"),department.getText().toString());
                RequestBody clgidreq=RequestBody.create(MediaType.parse("text/plain"),collegeId);
                RequestBody pswdreq=RequestBody.create(MediaType.parse("text/plain"),password.getText().toString());


                MultipartBody.Part filePart = MultipartBody.Part.createFormData("avatar", imgfile.getName(), RequestBody.create(MediaType.parse("image/*"), imgfile));

                new Retro().getApi().ADD_STAFF_MODEL_CALL(staff_namereq,empidreq,emailreq,phonereq,postreq,depreq,clgidreq,pswdreq,
                        filePart).enqueue(new Callback<AddStaffModel>() {
                    @Override
                    public void onResponse(Call<AddStaffModel> call, Response<AddStaffModel> response) {
                        AddStaffModel addStaffModel=response.body();
                        if(addStaffModel.getStatus().equals("success"))
                        {
                            Toast.makeText(getApplicationContext(),addStaffModel.getMessage(),Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            Toast.makeText(AddStaffActivity.this, addStaffModel.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<AddStaffModel> call, Throwable t) {
                        Toast.makeText(AddStaffActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

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
                    circleImageView.setImageBitmap(thumbnail);
                }

        }
    }


}
