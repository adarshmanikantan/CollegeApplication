package com.adarsh.collegeapplication.Staff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.AddAttendenceModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddAttendenceActivity extends AppCompatActivity {

    EditText month,present,working;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attendence);

        month=findViewById(R.id.month);
        present=findViewById(R.id.present);
        working=findViewById(R.id.working);
    }

    public void AddAttendenceClick(View view) {

        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("studentpref", Context.MODE_PRIVATE);



        new Retro().getApi().ADD_ATTENDENCE_MODEL_CALL( sharedPreferences.getString("clgid",null),sharedPreferences.getString("regno",null),month.getText().toString(),present.getText().toString(),
                 working.getText().toString()).enqueue(new Callback<AddAttendenceModel>() {
            @Override
            public void onResponse(Call<AddAttendenceModel> call, Response<AddAttendenceModel> response) {
                AddAttendenceModel addAttendenceModel=response.body();
                if(addAttendenceModel.getStatus().equalsIgnoreCase("success"))
                {
                    Toast.makeText(AddAttendenceActivity.this,addAttendenceModel.getStatus(), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(AddAttendenceActivity.this,addAttendenceModel.getStatus(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<AddAttendenceModel> call, Throwable t) {
                Toast.makeText(AddAttendenceActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
