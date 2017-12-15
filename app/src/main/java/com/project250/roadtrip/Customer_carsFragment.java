package com.project250.roadtrip;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Customer_carsFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_customer_cars, container, false);

        ConstraintLayout constraintLayout1 = (ConstraintLayout) view.findViewById(R.id.constraintLayout1);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.constraintLayout2);

        constraintLayout1.setOnClickListener(
                new ConstraintLayout.OnClickListener(){
                    public void onClick(View v){
                        Intent customerCarDetails = new Intent(getActivity(),CostomerCarDetails.class);
                        startActivity(customerCarDetails);
                    }
                }
        );
        constraintLayout2.setOnClickListener(
                new ConstraintLayout.OnClickListener(){
                    public void onClick(View v){
                        Intent customerCarDetails = new Intent(getActivity(), CostomerCarDetails.class);
                        startActivity(customerCarDetails);
                    }
                }
        );
        return view;
    }
}
