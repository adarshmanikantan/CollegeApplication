package com.adarsh.collegeapplication.College;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.adarsh.collegeapplication.College.ui.home.StaffFragment;
import com.adarsh.collegeapplication.MainActivity;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.AddStaffModel;
import com.adarsh.collegeapplication.model.ViewDepartmentModel;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddStaffActivity extends AppCompatActivity {

    CircleImageView circleImageView;
    EditText staff_name, emp_id, email, phone, password;
    File imgfile;
    String picturePath;
    Button addbutton;
    private String collegeId;
    Spinner department,post;
    List<String> deptLists;
    String selectedDept;
    String selectedPost;
    String[] country = { "India", "USA", "China", "Japan", "Other"};
    String[] postArray = {"Select post","HOD","Asst Proffessor","Assosciate Proffessor"};
    String[] deptArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_staff);

        deptLists = new ArrayList<String>();
        final SharedPreferences collegepreferences = getApplicationContext().getSharedPreferences("collegepref", MODE_PRIVATE);
        collegeId = collegepreferences.getString("collegeidkey", null);
        Toast.makeText(this, collegeId, Toast.LENGTH_SHORT).show();

        new Retro().getApi().VIEW_DEPARTMENT_MODEL_CALL(collegeId).enqueue(new Callback<ViewDepartmentModel>() {
            @Override
            public void onResponse(Call<ViewDepartmentModel> call, Response<ViewDepartmentModel> response) {
                ViewDepartmentModel viewDepartmentModel = response.body();
                deptLists.clear();
                deptArray=new String[viewDepartmentModel.getDepartments().size()];

                // deptLists.add("Choose Your Department");
                if (viewDepartmentModel != null) {
                    for (int i = 0; i < viewDepartmentModel.getDepartments().size(); i++) {
                        deptLists.add(viewDepartmentModel.getDepartments().get(i).getDept_name());

                        deptArray[i]=viewDepartmentModel.getDepartments().get(i).getDept_name();
                    }
                    ArrayAdapter<String> aa = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,deptArray);
                    aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    //Setting the ArrayAdapter data on the Spinner
                    department.setAdapter(aa);
                    department.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            selectedDept=deptArray[position];
                            Toast.makeText(AddStaffActivity.this, ""+selectedDept, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }

            }

            @Override
            public void onFailure(Call<ViewDepartmentModel> call, Throwable t) {
                Toast.makeText(AddStaffActivity.this, "API FAILED" + t, Toast.LENGTH_SHORT).show();
            }
        });





        circleImageView = findViewById(R.id.imageView2);
        staff_name = findViewById(R.id.addstaffname);
        emp_id = findViewById(R.id.addemployeeid);
        email = findViewById(R.id.addemail);
        phone = findViewById(R.id.addphone);
        post = findViewById(R.id.addpost);
        department = findViewById(R.id.adddepartment);
        password = findViewById(R.id.addpassword);
        addbutton = findViewById(R.id.addbutton);


        //................spinner
        // Creating adapter for spinner
        //Creating the ArrayAdapter instance having the country list

        ArrayAdapter<String> postadapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,postArray);
        postadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        post.setAdapter(postadapter);
        post.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedPost=postArray[position];
                Toast.makeText(AddStaffActivity.this, ""+selectedPost, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






        //....................spiner ends
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
                RequestBody empidreq = RequestBody.create(MediaType.parse("text/plain"), emp_id.getText().toString());
                RequestBody staff_namereq = RequestBody.create(MediaType.parse("text/plain"), staff_name.getText().toString());
                RequestBody emailreq = RequestBody.create(MediaType.parse("text/plain"), email.getText().toString());
                RequestBody phonereq = RequestBody.create(MediaType.parse("text/plain"), phone.getText().toString());
                //RequestBody postreq = RequestBody.create(MediaType.parse("text/plain"), post.getText().toString());
               // RequestBody depreq = RequestBody.create(MediaType.parse("text/plain"), department.getText().toString());
                RequestBody postreq = RequestBody.create(MediaType.parse("text/plain"), selectedPost);

                RequestBody depreq = RequestBody.create(MediaType.parse("text/plain"), selectedDept);


                RequestBody clgidreq = RequestBody.create(MediaType.parse("text/plain"), collegeId);
                RequestBody pswdreq = RequestBody.create(MediaType.parse("text/plain"), password.getText().toString());


                MultipartBody.Part filePart = MultipartBody.Part.createFormData("avatar", imgfile.getName(), RequestBody.create(MediaType.parse("image/*"), imgfile));

                new Retro().getApi().ADD_STAFF_MODEL_CALL(staff_namereq, empidreq, emailreq, phonereq, postreq, depreq, clgidreq, pswdreq,
                        filePart).enqueue(new Callback<AddStaffModel>() {
                    @Override
                    public void onResponse(Call<AddStaffModel> call, Response<AddStaffModel> response) {
                        AddStaffModel addStaffModel = response.body();
                        if (addStaffModel.getStatus().equals("success")) {
                            Toast.makeText(getApplicationContext(), addStaffModel.getMessage(), Toast.LENGTH_SHORT).show();

                        } else {
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
                imgfile = new File(picturePath);
                c.close();
                Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
                Toast.makeText(this, picturePath + "", Toast.LENGTH_SHORT).show();
                circleImageView.setImageBitmap(thumbnail);
            }

        }
    }


}
