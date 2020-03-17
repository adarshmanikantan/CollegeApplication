package com.adarsh.collegeapplication.Alumni;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.adarsh.collegeapplication.College.AddStaffActivity;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Api;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.AlumniRegistrationModel;
import com.adarsh.collegeapplication.model.ViewDepartmentModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddAlumni extends AppCompatActivity {

    private TextInputLayout outlinedTextField;
    private TextInputEditText alumniname;
    private TextInputEditText alumniemail;
    private TextInputEditText alumniphone;
    private Spinner alumnidepartment;
    private TextInputEditText alumnipassout;
    private TextInputEditText alumnipswd;
    String[] deptArray;
    String collegeId,selectedDept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alumni);
        initView();
        final SharedPreferences collegepreferences = getApplicationContext().getSharedPreferences("collegepref", MODE_PRIVATE);
        collegeId = collegepreferences.getString("collegeidkey", null);
        new Retro().getApi().VIEW_DEPARTMENT_MODEL_CALL(collegeId).enqueue(new Callback<ViewDepartmentModel>() {
            @Override
            public void onResponse(Call<ViewDepartmentModel> call, Response<ViewDepartmentModel> response) {
                ViewDepartmentModel viewDepartmentModel = response.body();
                deptArray=new String[viewDepartmentModel.getDepartments().size()];

                // deptLists.add("Choose Your Department");
                if (viewDepartmentModel != null) {
                    for (int i = 0; i < viewDepartmentModel.getDepartments().size(); i++) {

                        deptArray[i]=viewDepartmentModel.getDepartments().get(i).getDept_name();
                    }
                    ArrayAdapter<String> aa = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,deptArray);
                    aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    //Setting the ArrayAdapter data on the Spinner
                    alumnidepartment.setAdapter(aa);
                    alumnidepartment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            selectedDept=deptArray[position];
                            Toast.makeText(AddAlumni.this, ""+selectedDept, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }

            }

            @Override
            public void onFailure(Call<ViewDepartmentModel> call, Throwable t) {
                Toast.makeText(AddAlumni.this, "API FAILED" + t, Toast.LENGTH_SHORT).show();
            }
        });





    }

    public void addAlumniMember(View view) {

        new Retro().getApi().ALUMNI_REGISTRATION_MODEL_CALL(alumniname.getText().toString(),alumniemail.getText().toString(),selectedDept,alumnipassout.getText().toString(),
                 alumniphone.getText().toString(),alumnipswd.getText().toString(),collegeId).enqueue(new Callback<AlumniRegistrationModel>() {
            @Override
            public void onResponse(Call<AlumniRegistrationModel> call, Response<AlumniRegistrationModel> response) {
                AlumniRegistrationModel alumniRegistrationModel=response.body();
                if(alumniRegistrationModel.getStatus().equalsIgnoreCase("success"))
                {
                    Toast.makeText(AddAlumni.this,alumniRegistrationModel.getStatus(), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(AddAlumni.this,alumniRegistrationModel.getStatus(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<AlumniRegistrationModel> call, Throwable t) {
                Toast.makeText(AddAlumni.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void initView() {
        outlinedTextField = findViewById(R.id.outlinedTextField);
        alumniname = findViewById(R.id.alumniname);
        alumniemail = findViewById(R.id.alumniemail);
        alumniphone = findViewById(R.id.alumniphone);
        alumnidepartment = findViewById(R.id.alumnidepartment);
        alumnipassout = findViewById(R.id.alumnipassout);
        alumnipswd = findViewById(R.id.alumnipswd);
    }
}
