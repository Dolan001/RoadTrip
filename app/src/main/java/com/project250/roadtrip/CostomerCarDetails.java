package com.project250.roadtrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CostomerCarDetails extends AppCompatActivity {

    TextView carname,info1,info2,info3,info4,info5,passenger,seats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costomer_car_details);

        Button button3 = (Button)findViewById(R.id.button3);

        carname = (TextView)findViewById(R.id.carname);
        info1 = (TextView)findViewById(R.id.info1);
        info2 = (TextView)findViewById(R.id.info2);
        info3 = (TextView)findViewById(R.id.info3);
        info4 = (TextView)findViewById(R.id.info4);
        info5 = (TextView)findViewById(R.id.info5);
        passenger = (TextView)findViewById(R.id.passenger);
        seats = (TextView)findViewById(R.id.seats);

        carname.setText(getIntent().getStringExtra("carname"));
        String infoOne = getIntent().getStringExtra("info1");
        info1.setText(infoOne);
        info2.setText(getIntent().getStringExtra("info2"));
        info3.setText(getIntent().getStringExtra("info3"));
        info4.setText(getIntent().getStringExtra("info4"));
        info5.setText(getIntent().getStringExtra("info5"));
        passenger.setText(getIntent().getStringExtra("passenger"));
        seats.setText(getIntent().getStringExtra("seats"));

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
