package com.project250.roadtrip;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class AdminAddCarsFragment extends Fragment {

    View view;
    Button addcar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_adminaddcars, container, false);

        addcar = (Button) view.findViewById(R.id.add_car);
        addcar.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent add = new Intent(getActivity(),Admin_Home.class);
                        startActivity(add);
                    }
                }
        );

        return view;
    }
}
