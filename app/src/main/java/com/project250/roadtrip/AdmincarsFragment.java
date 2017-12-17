package com.project250.roadtrip;


import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class AdmincarsFragment extends Fragment {

    View v;
    ArrayList<Car> cars;
    ListView listView;
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
        listView = (ListView)v.findViewById(R.id.listview);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cars = new ArrayList<Car>();
                for(DataSnapshot x: dataSnapshot.getChildren()) {
                    Car car = x.getValue(Car.class);
                    cars.add(car);
                }

                adapter = new CarAdapter(cars, getActivity());
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(
                        new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Toast.makeText(getContext(),"clicked",Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getActivity(),AdminCarDetails.class);
                                startActivity(i);
                            }
                        }
                );

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return v;

    }

}
