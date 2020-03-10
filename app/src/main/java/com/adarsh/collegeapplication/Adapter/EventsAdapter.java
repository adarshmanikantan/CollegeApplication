package com.adarsh.collegeapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      String eventid=viewEventModel.getEvents().get(position).getEvent_id();
      holder.title.setText(viewEventModel.getEvents().get(position).getEvent());
      holder.date.setText(viewEventModel.getEvents().get(position).getDate());
        holder.desc.setText(viewEventModel.getEvents().get(position).getDescription());

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
