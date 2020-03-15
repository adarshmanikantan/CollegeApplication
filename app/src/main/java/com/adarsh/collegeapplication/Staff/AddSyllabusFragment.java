package com.adarsh.collegeapplication.Staff;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adarsh.collegeapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddSyllabusFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_add_syllabus, container, false);
        return root;
    }

}
