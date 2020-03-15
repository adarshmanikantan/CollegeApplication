package com.adarsh.collegeapplication.Staff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.adarsh.collegeapplication.R;
import com.jaiselrahman.filepicker.activity.FilePickerActivity;
import com.jaiselrahman.filepicker.config.Configurations;
import com.jaiselrahman.filepicker.model.MediaFile;

import java.util.ArrayList;

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
//    private int PICK_PDF_REQUEST = 1;
//    private final static int FILE_REQUEST_CODE = 1;
//    private FileListAdapter fileListAdapter;
//    private ArrayList<MediaFile> mediaFiles = new ArrayList<>();
//
//    private static final int STORAGE_PERMISSION_CODE = 123;
//    private Uri filePath;
//    EditText semester_edt,subject_edt,subcode_edt;
//    String department,semester,subject,subcode,clgid,staffid;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_syllabus);
//        semester_edt=findViewById(R.id.semester);
//        subject_edt=findViewById(R.id.subjectname);
//        subcode_edt=findViewById(R.id.subjectcode);
//        RecyclerView recyclerView = findViewById(R.id.file_list);
//        fileListAdapter = new FileListAdapter(mediaFiles);
//        recyclerView.setAdapter(fileListAdapter);
//        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("staffdetails",MODE_PRIVATE);
//       department=sharedPreferences.getString("department",null);
//        Toast.makeText(this, department, Toast.LENGTH_SHORT).show();
//       clgid=sharedPreferences.getString("clgid",null);
//       staffid=sharedPreferences.getString("id",null);
//        Toast.makeText(this,staffid, Toast.LENGTH_SHORT).show();
//        requestStoragePermission();
//    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == FILE_REQUEST_CODE
//                && resultCode == RESULT_OK
//                && data != null) {
//            mediaFiles.clear();
//            mediaFiles.addAll(data.<MediaFile>getParcelableArrayListExtra(FilePickerActivity.MEDIA_FILES));
//            fileListAdapter.notifyDataSetChanged();
//            SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("pref", Context.MODE_PRIVATE);
//            String s=sharedPreferences.getString("key1",null);
//            Toast.makeText(this,s, Toast.LENGTH_SHORT).show();
//        }
//    }
//
//
//    public void selectPdf(View view)
//    {
//        Intent intent = new Intent(AddSyllabus.this, FilePickerActivity.class);
//        intent.putExtra(FilePickerActivity.CONFIGS, new Configurations.Builder()
//                .setCheckPermission(true)
//                .setSelectedMediaFiles(mediaFiles)
//                .setShowFiles(true)
//                .setShowImages(false)
//                .setShowVideos(false)
//                .setMaxSelection(10)
//                .setRootPath(Environment.getExternalStorageDirectory().getPath() + "/Download")
//                .build());
//        startActivityForResult(intent, FILE_REQUEST_CODE);
//    }

//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//    public void addSyllabusClick(View view) {
//
//        String path =FilePath.getPath(this, filePath);
//
//        if (path == null) {
//
//            Toast.makeText(this, "Please move your .pdf file to internal storage and retry", Toast.LENGTH_LONG).show();
//        } else {
//            //Upl
//            semester=semester_edt.getText().toString();
//            subject=subject_edt.getText().toString();
//            subcode=subcode_edt.getText().toString();
//            RequestBody departmentreq = RequestBody.create(MediaType.parse("text/plain"), department);
//            RequestBody semesterreq = RequestBody.create(MediaType.parse("text/plain"), semester);
//            final RequestBody subreq = RequestBody.create(MediaType.parse("text/plain"), subject);
//            RequestBody subcodereq = RequestBody.create(MediaType.parse("text/plain"), subcode);
//            RequestBody clgidreq = RequestBody.create(MediaType.parse("text/plain"), clgid);
//            RequestBody staffidreq = RequestBody.create(MediaType.parse("text/plain"), staffid);
//
//            MultipartBody.Part filePart = MultipartBody.Part.createFormData("avatar", path, RequestBody.create(MediaType.parse("pdf/*"), path));
//
//            new Retro().getApi().ADD_SYLLABUS_MODEL_CALL(departmentreq, semesterreq, subreq, subcodereq, filePart, clgidreq, staffidreq).enqueue(new Callback<AddSyllabusModel>() {
//                @Override
//                public void onResponse(Call<AddSyllabusModel> call, Response<AddSyllabusModel> response) {
//                    AddSyllabusModel addSyllabusModel = response.body();
//                    if (addSyllabusModel.getStatus().equalsIgnoreCase("success")) {
//                        Toast.makeText(AddSyllabus.this,addSyllabusModel.getStatus(), Toast.LENGTH_SHORT).show();
//                    }
//                    else {
//                        Toast.makeText(AddSyllabus.this,addSyllabusModel.getMessage(),Toast.LENGTH_SHORT).show();
//
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<AddSyllabusModel> call, Throwable t) {
//                    Toast.makeText(AddSyllabus.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            });
//
//        }
//    }
//    private void showFileChooser() {
//
//
//    }
//




    //Requesting permission
//    private void requestStoragePermission() {
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
//            return;
//
//        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
   //     }
        //And finally ask for the permission
//        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
//    }
//
//
//    //This method will be called when the user will tap on allow or deny
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//
//        //Checking the request code of our request
//        if (requestCode == STORAGE_PERMISSION_CODE) {
//
//            //If permission is granted
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                //Displaying a toast
//                Toast.makeText(this, "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();
//            } else {
//                //Displaying another toast if permission is not granted
//                Toast.makeText(this, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
//            }
//        }
//    }


}
