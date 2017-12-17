package com.project250.roadtrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminAddCar extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    Button add_car_button;
    TextView carname,firstinfo, seconfinfo, thirdinfo, forthinfo, fifthinfo, passengerno, seats, priceperday, carlocation;
    DatabaseReference databaseReference;
    Car car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_car);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Cars");

        carname = (TextView)findViewById(R.id.carname);
        firstinfo = (TextView) findViewById(R.id.firstinfo);
        seconfinfo = (TextView) findViewById(R.id.secondinfo);
        thirdinfo = (TextView) findViewById(R.id.thirdinfo);
        forthinfo = (TextView) findViewById(R.id.forthinfo);
        fifthinfo = (TextView) findViewById(R.id.fifthinfo);
        passengerno = (TextView) findViewById(R.id.passengerno);
        seats = (TextView) findViewById(R.id.seats);
        priceperday = (TextView) findViewById(R.id.priceperday);
        carlocation = (TextView) findViewById(R.id.carlocation);
        add_car_button = (Button) findViewById(R.id.add_car_button);


        add_car_button.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cars();
                    }
                }
        );
    }
    private void Cars() {
        String car_name = carname.getText().toString().trim();
        String info1 = firstinfo.getText().toString().trim();
        String info2 = seconfinfo.getText().toString().trim();
        String info3 = thirdinfo.getText().toString().trim();
        String info4 = forthinfo.getText().toString().trim();
        String info5 = fifthinfo.getText().toString().trim();
        String passenger = passengerno.getText().toString().trim();
        String seat = seats.getText().toString().trim();
        String price = priceperday.getText().toString().trim();
        String location = carlocation.getText().toString().trim();
        String date = "Available";
        String time = "Now";

        if(!TextUtils.isEmpty(car_name) || !TextUtils.isEmpty(info1) || !TextUtils.isEmpty(info2) || !TextUtils.isEmpty(info3) || !TextUtils.isEmpty(info4) || !TextUtils.isEmpty(info5) || !TextUtils.isEmpty(passenger) || !TextUtils.isEmpty(seat) || !TextUtils.isEmpty(price) || !TextUtils.isEmpty(location)){

            String id = databaseReference.push().getKey();
            car = new Car(car_name,info1,info2,info3,info4,info5,passenger,seat,price,location,date,time);
            databaseReference.child(id).setValue(car);
            Toast.makeText(this,"Successfully inserted data", Toast.LENGTH_SHORT).show();
            Intent add = new Intent(AdminAddCar.this,Admin_Home.class);
            startActivity(add);
        }else {
            Toast.makeText(this,"you should enter all information", Toast.LENGTH_SHORT).show();
        }
    }
}
