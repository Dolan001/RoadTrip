package com.project250.roadtrip;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class CustomerCarReservationDetails extends AppCompatActivity {
    private static final String TAG = "CustomerCarReservationD";
    private TextView pickupdate,dropoffdate,pickuptime,dropofftime;
    private DatePickerDialog.OnDateSetListener mypickupdatelistener;
    private DatePickerDialog.OnDateSetListener mydropoffdatelistener;
    private TimePickerDialog.OnTimeSetListener mypickuptimelistener;
    private TimePickerDialog.OnTimeSetListener mydropofftimelistener;
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    Button showprice;
    Button buttonprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_car_reservation_details);
        total_amount();
        my_pickup_date();
        my_dropoff_date();
        my_pickup_time();
        my_dropoff_time();
        radio_button_clicked();
        showtotalprice();
    }

    //Show price button click
    public void total_amount(){
        showprice = (Button) findViewById(R.id.showprice);
        showprice.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent carpaice = new Intent(CustomerCarReservationDetails.this, CarPrice.class);
                        startActivity(carpaice);
                    }
                }
        );
    }

    //Pick up date
    public void my_pickup_date(){
        pickupdate = (TextView)findViewById(R.id.pickupdate);
        pickupdate.setOnClickListener(
                new TextView.OnClickListener(){
                    public void onClick(View v){
                        Calendar calendar = Calendar.getInstance();
                        int year = calendar.get(Calendar.YEAR);
                        int month = calendar.get(Calendar.MONTH);
                        int day = calendar.get(Calendar.DAY_OF_MONTH);
                        DatePickerDialog datePickerDialog = new DatePickerDialog(
                                CustomerCarReservationDetails.this,
                                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                                mypickupdatelistener, year, month, day);
                        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        datePickerDialog.show();
                    }
                }
        );
        mypickupdatelistener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyyy" + dayOfMonth + "/" + month + "/" + year);
                String pick_up_date = dayOfMonth + "/" + month + "/" + year;
                pickupdate.setText(pick_up_date);
            }
        };
    }

    //Drop off date
    public void my_dropoff_date(){
        dropoffdate = (TextView)findViewById(R.id.dropoffdate);
        dropoffdate.setOnClickListener(
                new TextView.OnClickListener(){
                    public void onClick(View v){
                        Calendar calendar = Calendar.getInstance();
                        int year = calendar.get(Calendar.YEAR);
                        int month = calendar.get(Calendar.MONTH);
                        int day = calendar.get(Calendar.DAY_OF_MONTH);
                        DatePickerDialog datePickerDialog = new DatePickerDialog(
                                CustomerCarReservationDetails.this,
                                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                                mydropoffdatelistener, year,month,day);
                        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        datePickerDialog.show();
                    }
                }
        );
        mydropoffdatelistener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyyy" + dayOfMonth + "/" + month + "/" + year);
                String drop_off_date = dayOfMonth + "/" + month + "/" + year;
                dropoffdate.setText(drop_off_date);
            }
        };
    }

    //Pick up time
    public void my_pickup_time(){
        pickuptime = (TextView)findViewById(R.id.pickuptime);
        pickuptime.setOnClickListener(
                new TextView.OnClickListener(){
                    public void onClick(View v){
                        Calendar calendar = Calendar.getInstance();
                        int hour = calendar.get(Calendar.HOUR);
                        int min = calendar.get(Calendar.MINUTE);
                        TimePickerDialog timePickerDialog = new TimePickerDialog(
                                CustomerCarReservationDetails.this,
                                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                                mypickuptimelistener,hour,min,false);
                        timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        timePickerDialog.show();
                    }
                }
        );
        mypickuptimelistener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //Log.d(TAG, "onTimeSet: hh:mm" + hourOfDay + ":" + minute);
                //String pick_up_time = hourOfDay + ":" + minute;
                String pick_up_time;
                if(hourOfDay>=0 && hourOfDay<12){
                    pick_up_time = hourOfDay + " : " + minute + " AM";
                } else {
                    if(hourOfDay == 12){
                        pick_up_time = hourOfDay + " : " + minute + " PM";
                    } else{
                        hourOfDay = hourOfDay -12;
                        pick_up_time = hourOfDay + " : " + minute + " PM";
                    }
                }
                pickuptime.setText(pick_up_time);
            }
        };
    }

    //Drop off time
    public void my_dropoff_time(){
        dropofftime = (TextView)findViewById(R.id.dropofftime);
        dropofftime.setOnClickListener(
                new TextView.OnClickListener(){
                    public void onClick(View v){
                        Calendar calendar = Calendar.getInstance();
                        int hour = calendar.get(Calendar.HOUR);
                        int min = calendar.get(Calendar.MINUTE);
                        TimePickerDialog timePickerDialog = new TimePickerDialog(
                                CustomerCarReservationDetails.this,
                                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                                mydropofftimelistener,hour,min,false);
                        timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        timePickerDialog.show();
                    }
                }
        );
        mydropofftimelistener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //Log.d(TAG, "onTimeSet: hh:mm" + hourOfDay + ":" + minute);
                //String drop_off_time = hourOfDay + ":" + minute;
                String drop_off_time;
                if(hourOfDay>=0 && hourOfDay<12){
                    drop_off_time = hourOfDay + " : " + minute + " AM";
                } else {
                    if(hourOfDay == 12){
                        drop_off_time = hourOfDay + " : " + minute + " PM";
                    } else{
                        hourOfDay = hourOfDay -12;
                        drop_off_time = hourOfDay + " : " + minute + " PM";
                    }
                }
                dropofftime.setText(drop_off_time);
            }
        };
    }

    //Manage radio button
    public void radio_button_clicked(){
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        int selected_id = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton)findViewById(selected_id);
    }

    //show the price
    public void showtotalprice(){
        buttonprice = (Button)findViewById(R.id.showprice);
        buttonprice.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent price = new Intent(CustomerCarReservationDetails.this,CarPrice.class);
                        startActivity(price);
                    }
                }
        );
    }
}
