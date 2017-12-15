package com.project250.roadtrip;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CustomerBillPaymentmethod extends AppCompatActivity {

    Dialog myDialog;
    Button bkash,dutchbangla,ukash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_bill_payment_method);

        myDialog = new Dialog(this);
        button_click();
    }

    //pop up
    public void button_click(){

        bkash = (Button) findViewById(R.id.bkash);
        dutchbangla = (Button) findViewById(R.id.dutchbangla);
        ukash = (Button) findViewById(R.id.ukash);
        bkash.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                            TextView txtclose;
                            Button final_button;

                            myDialog.setContentView(R.layout.activity_customer_send_money_method_bkash);
                            txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
                            final_button = (Button) myDialog.findViewById(R.id.final_button);

                            final_button.setOnClickListener(
                                    new Button.OnClickListener() {
                                        public void onClick(View v) {
                                            Toast.makeText(getApplicationContext(), "Your Activity Is Successfully Stored, Please Pay First Within 48 Hours",
                                                    Toast.LENGTH_LONG).show();
                                            Intent home = new Intent(CustomerBillPaymentmethod.this, Customer_home.class);
                                            startActivity(home);
                                        }
                                    }
                            );

                            txtclose.setOnClickListener(
                                    new TextView.OnClickListener() {
                                        public void onClick(View v) {
                                            myDialog.dismiss();
                                        }
                                    }
                            );
                            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                            myDialog.show();
                        }

                }
        );

        dutchbangla.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        TextView txtclose;
                        Button final_button;

                        myDialog.setContentView(R.layout.customer_send_money_method_dutch_bangla);
                        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
                        final_button = (Button) myDialog.findViewById(R.id.final_button);

                        final_button.setOnClickListener(
                                new Button.OnClickListener() {
                                    public void onClick(View v) {
                                        Toast.makeText(getApplicationContext(), "Your Activity Is Successfully Stored, Please Pay First Within 48 Hours",
                                                Toast.LENGTH_LONG).show();
                                        Intent home = new Intent(CustomerBillPaymentmethod.this, Customer_home.class);
                                        startActivity(home);
                                    }
                                }
                        );

                        txtclose.setOnClickListener(
                                new TextView.OnClickListener() {
                                    public void onClick(View v) {
                                        myDialog.dismiss();
                                    }
                                }
                        );
                        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        myDialog.show();
                    }

                }
        );

        ukash.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        TextView txtclose;
                        Button final_button;

                        myDialog.setContentView(R.layout.customer_send_money_method_ukash);
                        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
                        final_button = (Button) myDialog.findViewById(R.id.final_button);

                        final_button.setOnClickListener(
                                new Button.OnClickListener() {
                                    public void onClick(View v) {
                                        Toast.makeText(getApplicationContext(), "Your Activity Is Successfully Stored, Please Pay First Within 48 Hours",
                                                Toast.LENGTH_LONG).show();
                                        Intent home = new Intent(CustomerBillPaymentmethod.this, Customer_home.class);
                                        startActivity(home);
                                    }
                                }
                        );

                        txtclose.setOnClickListener(
                                new TextView.OnClickListener() {
                                    public void onClick(View v) {
                                        myDialog.dismiss();
                                    }
                                }
                        );
                        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        myDialog.show();
                    }

                }
        );
    }
}
