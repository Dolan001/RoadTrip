package com.project250.roadtrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CostomerCarDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costomer_car_details);

        Button button3 = (Button)findViewById(R.id.button3);

        button3.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent price = new Intent(CostomerCarDetails.this, CustomerCarReservationDetails.class);
                        startActivity(price);
                    }
                }
        );

    }
}
