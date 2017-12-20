package com.project250.roadtrip;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.support.v4.app.ListFragment;

import java.util.ArrayList;


public class AdmincarsFragment extends Fragment {

    View v;
    ArrayList<Car> cars;
    RecyclerView recyclerView;
    CarAdapter adapter;
    ImageView imageView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_admincars, container, false);


        mFirebaseDatabase = FirebaseDatabase.getInstance();
        database = mFirebaseDatabase.getReference().child("Cars");
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cars = new ArrayList<Car>();
                for (DataSnapshot x : dataSnapshot.getChildren()) {
                    Car car = x.getValue(Car.class);
                    cars.add(car);
                }
                recyclerView.setAdapter(new CarAdapter(cars, getActivity()));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return v;

    }

}
