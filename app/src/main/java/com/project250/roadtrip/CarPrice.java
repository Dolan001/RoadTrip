package com.project250.roadtrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CarPrice extends AppCompatActivity {

    Button payment_method_botton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_price);
        payment();
    }

    public void payment(){

        payment_method_botton = (Button)findViewById(R.id.payment_method_button);

        payment_method_botton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent payment_method = new Intent(CarPrice.this, CustomerBillPaymentmethod.class);
                        startActivity(payment_method);
                    }
                }
        );
    }
}
