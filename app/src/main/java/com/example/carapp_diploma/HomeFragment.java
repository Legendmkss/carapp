package com.example.carapp_diploma;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.carapp_diploma.Models.Events;
import com.example.carapp_diploma.Models.EventsList;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    DatabaseReference events;
    ListView list_events;
    List<Events> eventsList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        String onlineUserID = mUser.getUid();
        events = FirebaseDatabase.getInstance().getReference().child("Users").child(onlineUserID);

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView textViewName = (TextView) view.findViewById(R.id.name_events);
        TextView textViewPrice = (TextView) view.findViewById(R.id.price);
        TextView textViewDateTime = (TextView) view.findViewById(R.id.date_time);

        list_events = (ListView) view.findViewById(R.id.list_events);
        eventsList = new ArrayList<>();

        /*events.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                eventsList.clear();
                for (DataSnapshot eventsSnapshot : snapshot.getChildren()){
                    Events event = eventsSnapshot.getValue(Events.class);

                    eventsList.add(event);
                }
                EventsList adapter = new EventsList(getActivity(), eventsList);
                list_events.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        return view;
    }
}