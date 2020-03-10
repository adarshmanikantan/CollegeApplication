package com.adarsh.collegeapplication.College.ui.slideshow;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.collegeapplication.Adapter.DepartmentAdapter;
import com.adarsh.collegeapplication.Adapter.EventsAdapter;
import com.adarsh.collegeapplication.College.AddEvents;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.ViewDepartmentModel;
import com.adarsh.collegeapplication.model.ViewEventModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


public class EventsFragment extends Fragment {

    Button add_event;
    RecyclerView event_recyclerview;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_events, container, false);
        add_event=root.findViewById(R.id.addevent);
        event_recyclerview=root.findViewById(R.id.event_recycler);
        add_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),AddEvents.class);
                startActivity(i);
            }
        });
        SharedPreferences collegepreferences=getActivity().getSharedPreferences("collegepref",MODE_PRIVATE);
        String college_id=collegepreferences.getString("collegeidkey",null);


        new Retro().getApi().VIEW_EVENT_MODEL_CALL(college_id).enqueue(new Callback<ViewEventModel>() {
            @Override
            public void onResponse(Call<ViewEventModel> call, Response<ViewEventModel> response) {
                ViewEventModel viewEventModel=response.body();
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
                event_recyclerview.setLayoutManager(linearLayoutManager);
                EventsAdapter eventsAdapter=new EventsAdapter(getActivity(),viewEventModel);
                event_recyclerview.setAdapter(eventsAdapter);
            }

            @Override
            public void onFailure(Call<ViewEventModel> call, Throwable t) {

            }
        });

        return root;
    }
}