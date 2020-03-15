package com.adarsh.collegeapplication.College.ui;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.adarsh.collegeapplication.College.AddEvents;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.DeleteEventModel;
import com.adarsh.collegeapplication.model.EventUpdateModel;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventUpdateActivity extends AppCompatActivity {

    private EditText eTitle;
    private EditText eDate;
    private EditText eDescription;
    String eventid,title,date,desc,clgid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_update);
        initView();
        SharedPreferences collegepreferences=getApplicationContext().getSharedPreferences("collegepref",MODE_PRIVATE);
        clgid=collegepreferences.getString("collegeidkey",null);


        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("event", Context.MODE_PRIVATE);
        eventid=sharedPreferences.getString("eventid",null);
        title=sharedPreferences.getString("title",null);
        date=sharedPreferences.getString("date",null);
        desc=sharedPreferences.getString("description",null);
         eTitle.setText(title);
         eDate.setText(date);
         eDescription.setText(desc);
        eDate.setInputType(InputType.TYPE_NULL);
        eDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog picker = new DatePickerDialog(EventUpdateActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
    }

    private void initView() {
        eTitle = (EditText) findViewById(R.id.e_title);
        eDate = (EditText) findViewById(R.id.e_date);
        eDescription = (EditText) findViewById(R.id.e_description);
    }

    public void updateEventClick(View view) {
        new Retro().getApi().EVENT_UPDATE_MODEL_CALL(eTitle.getText().toString(),eventid,eDate.getText().toString(),
                eDescription.getText().toString()).enqueue(new Callback<EventUpdateModel>() {
            @Override
            public void onResponse(Call<EventUpdateModel> call, Response<EventUpdateModel> response) {
                EventUpdateModel eventUpdateModel=response.body();
                Toast.makeText(EventUpdateActivity.this,eventUpdateModel.getStatus(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<EventUpdateModel> call, Throwable t) {
                Toast.makeText(EventUpdateActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void deleteEventClick(View view) {
        new Retro().getApi().DELETE_EVENT_MODEL_CALL(clgid,eventid).enqueue(new Callback<DeleteEventModel>() {
            @Override
            public void onResponse(Call<DeleteEventModel> call, Response<DeleteEventModel> response) {
                DeleteEventModel deleteEventModel=response.body();
                Toast.makeText(EventUpdateActivity.this,deleteEventModel.getStatus(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<DeleteEventModel> call, Throwable t) {
                Toast.makeText(EventUpdateActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
