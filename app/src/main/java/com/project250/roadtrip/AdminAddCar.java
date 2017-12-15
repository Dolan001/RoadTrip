package com.project250.roadtrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminAddCar extends AppCompatActivity {

    Button add_car_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_car);

        add_car_button = (Button) findViewById(R.id.add_car_button);
        add_car_button.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent add = new Intent(AdminAddCar.this,Admin_Home.class);
                        startActivity(add);
                    }
                }
        );
    }
}
