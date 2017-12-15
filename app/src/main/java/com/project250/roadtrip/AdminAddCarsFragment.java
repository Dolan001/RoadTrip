package com.project250.roadtrip;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class AdminAddCarsFragment extends AppCompatActivity {

    View view;
    Button addcar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_adminaddcars);

        addcar = (Button) view.findViewById(R.id.add_car);
        addcar.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent add = new Intent(AdminAddCarsFragment.this,Admin_Home.class);
                        startActivity(add);
                    }
                }
        );
    }
}
