package com.adarsh.collegeapplication.Parent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import com.adarsh.collegeapplication.Adapter.EventsAdapter;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.ViewEventModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ParentEvent extends AppCompatActivity {
    RecyclerView event_recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_event);

        event_recyclerview=findViewById(R.id.p_eventrecycler);

        SharedPreferences collegepreferences=getApplicationContext().getSharedPreferences("collegepref",MODE_PRIVATE);
        String college_id=collegepreferences.getString("collegeidkey",null);


        new Retro().getApi().VIEW_EVENT_MODEL_CALL(college_id).enqueue(new Callback<ViewEventModel>() {
            @Override
            public void onResponse(Call<ViewEventModel> call, Response<ViewEventModel> response) {
                ViewEventModel viewEventModel=response.body();
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                event_recyclerview.setLayoutManager(linearLayoutManager);
                EventsAdapter eventsAdapter=new EventsAdapter(getApplicationContext(),viewEventModel);
                event_recyclerview.setAdapter(eventsAdapter);
            }

            @Override
            public void onFailure(Call<ViewEventModel> call, Throwable t) {

            }
        });

    }
}
