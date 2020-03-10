package com.adarsh.collegeapplication.Staff;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.AddSyllabusModel;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("staffdetails",MODE_PRIVATE);
//         SharedPreferences.Editor editor=sharedPreferences.edit();
//         editor.putString("clgid",clgid);
//         editor.putString("id",staffid);
//         editor.putString("staffname",staffname);
//         editor.putString("email",email);
//         editor.putString("phone",phone);
//         editor.putString("post",post);
//         editor.putString("department",department);
//         editor.putString("password",password);
//         editor.putString("photo",photo);
//         editor.apply();
public class AddSyllabus extends AppCompatActivity {
    private int PICK_PDF_REQUEST = 1;
    private static final int STORAGE_PERMISSION_CODE = 123;
    private Uri filePath;
    EditText semester_edt,subject_edt,subcode_edt;
    String department,semester,subject,subcode,clgid,staffid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_syllabus);
        semester_edt=findViewById(R.id.semester);
        subject_edt=findViewById(R.id.subjectname);
        subcode_edt=findViewById(R.id.subjectcode);

        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("staffdetails",MODE_PRIVATE);
       department=sharedPreferences.getString("department",null);
        Toast.makeText(this, department, Toast.LENGTH_SHORT).show();
       clgid=sharedPreferences.getString("clgid",null);
       staffid=sharedPreferences.getString("id",null);
        requestStoragePermission();
    }

    public void selectPdf(View view)
    {
        showFileChooser();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void addSyllabusClick(View view) {

        String path =FilePath.getPath(this, filePath);

        if (path == null) {

            Toast.makeText(this, "Please move your .pdf file to internal storage and retry", Toast.LENGTH_LONG).show();
        } else {
            //Upl
            semester=semester_edt.getText().toString();
            subject=subject_edt.getText().toString();
            subcode=subcode_edt.getText().toString();
            RequestBody departmentreq = RequestBody.create(MediaType.parse("text/plain"), department);
            RequestBody semesterreq = RequestBody.create(MediaType.parse("text/plain"), semester);
            final RequestBody subreq = RequestBody.create(MediaType.parse("text/plain"), subject);
            RequestBody subcodereq = RequestBody.create(MediaType.parse("text/plain"), subcode);
            RequestBody clgidreq = RequestBody.create(MediaType.parse("text/plain"), clgid);
            RequestBody staffidreq = RequestBody.create(MediaType.parse("text/plain"), staffid);

            MultipartBody.Part filePart = MultipartBody.Part.createFormData("avatar", path, RequestBody.create(MediaType.parse("/*"), path));

            new Retro().getApi().ADD_SYLLABUS_MODEL_CALL(departmentreq, semesterreq, subreq, subcodereq, filePart, clgidreq, staffidreq).enqueue(new Callback<AddSyllabusModel>() {
                @Override
                public void onResponse(Call<AddSyllabusModel> call, Response<AddSyllabusModel> response) {
                    AddSyllabusModel addSyllabusModel = response.body();
                    if (addSyllabusModel.getStatus().equalsIgnoreCase("success")) {
                        Toast.makeText(AddSyllabus.this,subreq.toString(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<AddSyllabusModel> call, Throwable t) {
                    Toast.makeText(AddSyllabus.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Pdf"), PICK_PDF_REQUEST);
    }

    //handling the image chooser activity result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_PDF_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
//
            if (requestCode == PICK_PDF_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
                filePath = data.getData();

            }
        }
    }


    //Requesting permission
    private void requestStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            return;

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }
        //And finally ask for the permission
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
    }


    //This method will be called when the user will tap on allow or deny
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        //Checking the request code of our request
        if (requestCode == STORAGE_PERMISSION_CODE) {

            //If permission is granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Displaying a toast
                Toast.makeText(this, "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();
            } else {
                //Displaying another toast if permission is not granted
                Toast.makeText(this, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
            }
        }
    }


}
