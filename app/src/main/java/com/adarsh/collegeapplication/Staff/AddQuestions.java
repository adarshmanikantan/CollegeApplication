package com.adarsh.collegeapplication.Staff;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.collegeapplication.Adapter.FileListAdapter;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.AddNotesModel;
import com.adarsh.collegeapplication.model.AddQuestionsModel;
import com.jaiselrahman.filepicker.activity.FilePickerActivity;
import com.jaiselrahman.filepicker.config.Configurations;
import com.jaiselrahman.filepicker.model.MediaFile;
import com.jaiselrahman.filepicker.utils.FilePickerProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddQuestions extends AppCompatActivity {

    private EditText questionsSemester;
    private EditText questionsSubjectname;
    private EditText questionsSubjectcode;
    private Button questionsLaunchFilePicker;
    private RecyclerView questionsFileList;
    private final static int FILE_REQUEST_CODE = 1;
    private FileListAdapter fileListAdapter;
    private ArrayList<MediaFile> mediaFiles = new ArrayList<>();
    EditText semester_edt,subject_edt,subcode_edt;
    String department,semester,subject,subcode,clgid,staffid,path;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_questions);
        initView();
        fileListAdapter = new FileListAdapter(mediaFiles);
        questionsFileList.setAdapter(fileListAdapter);
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("staffdetails",MODE_PRIVATE);
        department=sharedPreferences.getString("department",null);
        Toast.makeText(this, department, Toast.LENGTH_SHORT).show();
        clgid=sharedPreferences.getString("clgid",null);
        staffid=sharedPreferences.getString("id",null);
        Toast.makeText(this,staffid, Toast.LENGTH_SHORT).show();


        findViewById(R.id.questions_launch_filePicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddQuestions.this, FilePickerActivity.class);
                intent.putExtra(FilePickerActivity.CONFIGS, new Configurations.Builder()
                        .setCheckPermission(true)
                        .setSelectedMediaFiles(mediaFiles)
                        .setShowFiles(true)
                        .setShowImages(false)
                        .setShowVideos(false)
                        .setMaxSelection(1)
                        .setRootPath(Environment.getExternalStorageDirectory().getPath() + "/Download")
                        .build());
                startActivityForResult(intent, FILE_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_REQUEST_CODE
                && resultCode == RESULT_OK
                && data != null) {
            mediaFiles.clear();
            mediaFiles.addAll(data.<MediaFile>getParcelableArrayListExtra(FilePickerActivity.MEDIA_FILES));
            fileListAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.share_log) {
            shareLogFile();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void shareLogFile() {
        File logFile = new File(getExternalCacheDir(), "logcat.txt");
        try {
            if (logFile.exists())
                logFile.delete();
            logFile.createNewFile();
            Runtime.getRuntime().exec("logcat -f " + logFile.getAbsolutePath() + " -t 100 *:W Glide:S " + FilePickerActivity.TAG);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (logFile.exists()) {
            Intent intentShareFile = new Intent(Intent.ACTION_SEND);
            intentShareFile.setType("text/plain");
            intentShareFile.putExtra(Intent.EXTRA_STREAM,
                    FilePickerProvider.getUriForFile(this, logFile));
            intentShareFile.putExtra(Intent.EXTRA_SUBJECT, "FilePicker Log File");
            intentShareFile.putExtra(Intent.EXTRA_TEXT, "FilePicker Log File");
            startActivity(Intent.createChooser(intentShareFile, "Share"));
        }
    }

    public void addQuestionsClick(View view) {
        semester=questionsSemester.getText().toString();
        subject=questionsSubjectname.getText().toString();
        subcode=questionsSubjectcode.getText().toString();
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("syllabus", Context.MODE_PRIVATE);
        path=sharedPreferences.getString("key1",null);
        RequestBody departmentreq = RequestBody.create(MediaType.parse("text/plain"), department);
        RequestBody semesterreq = RequestBody.create(MediaType.parse("text/plain"), semester);
        final RequestBody subreq = RequestBody.create(MediaType.parse("text/plain"), subject);
        RequestBody subcodereq = RequestBody.create(MediaType.parse("text/plain"), subcode);
        RequestBody clgidreq = RequestBody.create(MediaType.parse("text/plain"), clgid);
        RequestBody staffidreq = RequestBody.create(MediaType.parse("text/plain"), staffid);

        MultipartBody.Part filePart = MultipartBody.Part.createFormData("avatar",path, RequestBody.create(MediaType.parse("application/pdf"), path));

        new Retro().getApi().ADD_QUESTIONS_MODEL_CALL(departmentreq, semesterreq, subreq, subcodereq, filePart, clgidreq, staffidreq).enqueue(new Callback<AddQuestionsModel>() {
            @Override
            public void onResponse(Call<AddQuestionsModel> call, Response<AddQuestionsModel> response) {
                AddQuestionsModel addQuestionsModel = response.body();
                if (addQuestionsModel.getStatus().equalsIgnoreCase("success")) {
                    Toast.makeText(AddQuestions.this,addQuestionsModel.getStatus(), Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(AddQuestions.this,addQuestionsModel.getMessage(),Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<AddQuestionsModel> call, Throwable t) {
                Toast.makeText(AddQuestions.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }
    private void initView() {
        questionsSemester = (EditText) findViewById(R.id.questions_semester);
        questionsSubjectname = (EditText) findViewById(R.id.questions_subjectname);
        questionsSubjectcode = (EditText) findViewById(R.id.questions_subjectcode);
        questionsLaunchFilePicker = (Button) findViewById(R.id.questions_launch_filePicker);
        questionsFileList = (RecyclerView) findViewById(R.id.questions_file_list);
    }
}
