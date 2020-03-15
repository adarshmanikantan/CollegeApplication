package com.adarsh.collegeapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.collegeapplication.College.ui.EventUpdateActivity;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.model.ViewEventModel;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {
    Context context;
    ViewEventModel viewEventModel;
    public EventsAdapter(Context context,ViewEventModel viewEventModel)
    {
       this.context=context;
       this.viewEventModel=viewEventModel;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_row,parent,false);
        EventsAdapter.MyViewHolder holder=new EventsAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
      String eventid=viewEventModel.getEvents().get(position).getEvent_id();
      holder.title.setText(viewEventModel.getEvents().get(position).getEvent());
      holder.date.setText(viewEventModel.getEvents().get(position).getDate());
        holder.desc.setText(viewEventModel.getEvents().get(position).getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=context.getSharedPreferences("event",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("eventid",viewEventModel.getEvents().get(position).getEvent_id());
                editor.putString("title",viewEventModel.getEvents().get(position).getEvent());
                editor.putString("date",viewEventModel.getEvents().get(position).getDate());
                editor.putString("description",viewEventModel.getEvents().get(position).getDescription());
                editor.apply();
                Intent i=new Intent(context, EventUpdateActivity.class);
                holder.itemView.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {

            return viewEventModel.getEvents().size();

    }



    public class MyViewHolder extends RecyclerView.ViewHolder
    {
       TextView title,date,desc;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.event_txtview);
            date=itemView.findViewById(R.id.eventdatetxt);
            desc=itemView.findViewById(R.id.event_desc_txt);
        }



    }
}
