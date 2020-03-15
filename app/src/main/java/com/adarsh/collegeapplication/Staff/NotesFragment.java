package com.adarsh.collegeapplication.Staff;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.collegeapplication.Adapter.NotesFragmentAdapter;
import com.adarsh.collegeapplication.Adapter.SyllabusStaffAdapter;
import com.adarsh.collegeapplication.R;
import com.adarsh.collegeapplication.Retro.Retro;
import com.adarsh.collegeapplication.model.ViewNotesModel;
import com.adarsh.collegeapplication.model.ViewSyllabusbyStaffModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclassn.
 */
public class NotesFragment extends Fragment {

    private RecyclerView notesrecycler;
    private Button notesFab;
    String staffid;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_notes, container, false);
        notesrecycler = root.findViewById(R.id.notesrecycler);
        notesFab =root.findViewById(R.id.notes_fab);
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("staffdetails",MODE_PRIVATE);
        staffid=sharedPreferences.getString("id",null);
        new Retro().getApi().VIEW_NOTES_MODEL_CALL(staffid).enqueue(new Callback<ViewNotesModel>() {
            @Override
            public void onResponse(Call<ViewNotesModel> call, Response<ViewNotesModel> response) {
                ViewNotesModel viewNotesModel=response.body();
                if(viewNotesModel.getStatus().equalsIgnoreCase("success"))
                {
                   NotesFragmentAdapter notesFragmentAdapter=new NotesFragmentAdapter(getActivity(),viewNotesModel);
                    notesrecycler.setAdapter(notesFragmentAdapter);
                }
            }

            @Override
            public void onFailure(Call<ViewNotesModel> call, Throwable t) {

            }
        });
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        notesrecycler.setLayoutManager(linearLayoutManager);



        notesFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i=new Intent(getActivity(),AddNotes.class);
                startActivity(i);
            }
        });
        return root;
    }


}
