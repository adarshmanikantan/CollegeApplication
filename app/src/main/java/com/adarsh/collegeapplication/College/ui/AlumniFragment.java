package com.adarsh.collegeapplication.College.ui;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.adarsh.collegeapplication.Alumni.AddAlumni;
import com.adarsh.collegeapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlumniFragment extends Fragment {

    RecyclerView recyclerView;
    Button button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_alumni, container, false);
        recyclerView=root.findViewById(R.id.alumnirecycler);
        button=root.findViewById(R.id.add_alumni_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),AddAlumni.class);
                startActivity(i);
            }
        });
        return root;

    }

}
