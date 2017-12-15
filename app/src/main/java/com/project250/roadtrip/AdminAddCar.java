package com.project250.roadtrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class AdminAddCar extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    Firebase rootfb;
    Button add_car_button;
    TextView carname,firstinfo, seconfinfo, thirdinfo, forthinfo, fifthinfo, passengerno, seats, priceperday, carlocation;
    //DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_car);

        firebaseAuth = FirebaseAuth.getInstance();
        rootfb = new Firebase("https://roadtrip-3f2fe.firebaseio.com/Cars").push();
        //databaseReference = FirebaseDatabase.getInstance().getReference("Cars");

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
        String info6 = passengerno.getText().toString().trim();
        String info7 = seats.getText().toString().trim();
        String info8 = priceperday.getText().toString().trim();
        String info9 = carlocation.getText().toString().trim();
        String info10 = "Available";
        String info11 = "Now";

        if(!TextUtils.isEmpty(car_name) || !TextUtils.isEmpty(info1) || !TextUtils.isEmpty(info2) || !TextUtils.isEmpty(info3) || !TextUtils.isEmpty(info4) || !TextUtils.isEmpty(info5) || !TextUtils.isEmpty(info6) || !TextUtils.isEmpty(info7) || !TextUtils.isEmpty(info8) || !TextUtils.isEmpty(info9)){

//            String id = databaseReference.push().getKey();
//            Car car = new Car(info1,info2,info3,info4,info5,info6,info7,info8,info9);
//            databaseReference.child(id).setValue(car);
            Firebase car_info1 = rootfb.child("Car_Name");
            car_info1.setValue(car_name);
            Firebase car_info2 = rootfb.child("Info-1");
            car_info2.setValue(info1);
            Firebase car_info3 = rootfb.child("Info-2");
            car_info3.setValue(info2);
            Firebase car_info4 = rootfb.child("Info-3");
            car_info4.setValue(info3);
            Firebase car_info5 = rootfb.child("Info-4");
            car_info5.setValue(info4);
            Firebase car_info6 = rootfb.child("Info-5");
            car_info6.setValue(info5);
            Firebase car_info7 = rootfb.child("Passengers");
            car_info7.setValue(info6);
            Firebase car_info8 = rootfb.child("Seats");
            car_info8.setValue(info7);
            Firebase car_info9 = rootfb.child("Price_per_day");
            car_info9.setValue(info8);
            Firebase car_info10 = rootfb.child("Car_location");
            car_info10.setValue(info9);
            Firebase car_info11 = rootfb.child("Available_date");
            car_info11.setValue(info10);
            Firebase car_info12 = rootfb.child("Available_time");
            car_info12.setValue(info11);
            Toast.makeText(this,"Successfully inserted data", Toast.LENGTH_SHORT).show();
            Intent add = new Intent(AdminAddCar.this,Admin_Home.class);
            startActivity(add);
        }else {
            Toast.makeText(this,"you should enter all information", Toast.LENGTH_SHORT).show();
        }
    }
}
// class Car{
//
//     String info1;
//     String info2;
//     String info3;
//     String info4;
//     String info5;
//     String info6;
//     String info7;
//     String info8;
//     String info9;
//
//     public Car() {
//     }
//
//     public Car(String info1, String info2, String info3, String info4, String info5, String info6, String info7, String info8, String info9) {
//         this.info1 = info1;
//         this.info2 = info2;
//         this.info3 = info3;
//         this.info4 = info4;
//         this.info5 = info5;
//         this.info6 = info6;
//         this.info7 = info7;
//         this.info8 = info8;
//         this.info9 = info9;
//     }
//
//     public String getInfo1() {
//         return info1;
//     }
//
//     public String getInfo2() {
//         return info2;
//     }
//
//     public String getInfo3() {
//         return info3;
//     }
//
//     public String getInfo4() {
//         return info4;
//     }
//
//     public String getInfo5() {
//         return info5;
//     }
//
//     public String getInfo6() {
//         return info6;
//     }
//
//     public String getInfo7() {
//         return info7;
//     }
//
//     public String getInfo8() {
//         return info8;
//     }
//
//     public String getInfo9() {
//         return info9;
//     }
// }
