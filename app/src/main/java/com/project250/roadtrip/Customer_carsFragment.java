package com.project250.roadtrip;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Customer_carsFragment extends Fragment {

    View view;
    ArrayList<Car> cars;
    RecyclerView recyclerview;
    CarAdapter adapter;
    ImageView imageView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_customer_cars, container, false);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        database = mFirebaseDatabase.getReference().child("Cars");
        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cars = new ArrayList<Car>();
                for (DataSnapshot x : dataSnapshot.getChildren()) {
                    Car car = x.getValue(Car.class);
                    cars.add(car);
                }
                recyclerview.setAdapter(new customer_car_adapter(cars, getActivity()));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return view;
    }
}
