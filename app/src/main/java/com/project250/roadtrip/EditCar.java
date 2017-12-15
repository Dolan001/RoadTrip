package com.project250.roadtrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EditCar extends AppCompatActivity {

    Button edit_car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_car);

        edit_car();
    }

    public void edit_car(){

        edit_car = (Button)findViewById(R.id.edit_car);
        edit_car.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Toast.makeText(getApplicationContext(),"Successfully saved",Toast.LENGTH_SHORT).show();
                        Intent edit_car = new Intent(EditCar.this,AdminCarDetails.class);
                        startActivity(edit_car);
                    }
                }
        );
    }
}
