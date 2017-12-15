package com.project250.roadtrip;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Customer_edit_profile extends Fragment {


    View view;
    Button logout,edit_pro;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_customer_edit_profile, container, false);

        logout = (Button) view.findViewById(R.id.logout_button);
        edit_pro = (Button)view.findViewById(R.id.edit_pro);
        edit_pro_button();

        return view;
    }

    public void edit_pro_button(){
        logout.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent logout_page = new Intent(getActivity(),Signinpage.class);
                        startActivity(logout_page);
                    }
                }
        );

        edit_pro.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent edit_page = new Intent(getActivity(),Customer_edit_profile_value.class);
                        startActivity(edit_page);
                    }
                }
        );
    }
}
