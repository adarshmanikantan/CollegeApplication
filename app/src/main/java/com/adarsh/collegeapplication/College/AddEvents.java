package com.adarsh.collegeapplication.College;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.adarsh.collegeapplication.College.ui.slideshow.EventsFragment;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.AddEventModel;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEvents extends AppCompatActivity {

    EditText event_title,event_date,event_desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events);

        event_title=findViewById(R.id.event_title);
        event_date=findViewById(R.id.event_date);
        event_desc=findViewById(R.id.event_description);

        event_date.setInputType(InputType.TYPE_NULL);
        event_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog picker = new DatePickerDialog(AddEvents.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                event_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
    }

    public void addEventClick(View view) {
        String eventtitle=event_title.getText().toString();
        String eventdate=event_date.getText().toString();
        String eventDesc=event_desc.getText().toString();
        SharedPreferences collegepreferences=getApplicationContext().getSharedPreferences("collegepref",MODE_PRIVATE);
        String collegeId=collegepreferences.getString("collegeidkey",null);

        new Retro().getApi().ADD_EVENT_MODEL_CALL(collegeId,eventtitle,eventdate,eventDesc).enqueue(new Callback<AddEventModel>() {
            @Override
            public void onResponse(Call<AddEventModel> call, Response<AddEventModel> response) {
                AddEventModel addEventModel=response.body();
                if(addEventModel.getStatus().equalsIgnoreCase("success"))
                {
                    Toast.makeText(AddEvents.this, addEventModel.getStatus(), Toast.LENGTH_SHORT).show();
//                    Intent i=new Intent(AddEvents.this, EventsFragment.class);
//                    startActivity(i);
                }
                else
                {
                    Toast.makeText(AddEvents.this, addEventModel.getStatus(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<AddEventModel> call, Throwable t) {

            }
        });

    }
}
