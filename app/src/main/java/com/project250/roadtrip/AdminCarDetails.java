package com.project250.roadtrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminCarDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_car_details);

        Button editCarbutton = (Button)findViewById(R.id.editcarbutton);
        Button add_car_button = (Button)findViewById(R.id.addCarbutton);



        editCarbutton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent edit = new Intent(AdminCarDetails.this, EditCar.class);
                        startActivity(edit);
                    }
                }
        );
        add_car_button.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent add_car = new Intent(AdminCarDetails.this, AdminAddCar.class);
                        startActivity(add_car);
                    }
                }
        );
    }
}
