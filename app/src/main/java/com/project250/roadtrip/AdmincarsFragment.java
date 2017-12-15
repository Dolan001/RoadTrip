package com.project250.roadtrip;


import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public class AdmincarsFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_admincars, container, false);

        ConstraintLayout car1 = (ConstraintLayout) view.findViewById(R.id.constraintLayout1);
        ConstraintLayout car2 = (ConstraintLayout) view.findViewById(R.id.constraintLayout2);

        car1.setOnClickListener(
                new ConstraintLayout.OnClickListener(){
                    public void onClick(View v){
                        Intent details = new Intent(getActivity(),AdminCarDetails.class);
                        startActivity(details);
                    }
                }
        );

        car2.setOnClickListener(
                new ConstraintLayout.OnClickListener(){
                    public void onClick(View v){
                        Intent details = new Intent(getActivity(),AdminCarDetails.class);
                        startActivity(details);
                    }
                }
        );

        return view;

    }

}
