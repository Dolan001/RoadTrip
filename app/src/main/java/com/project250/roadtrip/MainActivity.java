package com.project250.roadtrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Signincustomer = (TextView)findViewById(R.id.Signincustomer);

        Signincustomer.setOnClickListener(
                new TextView.OnClickListener() {
                    public void onClick(View v) {
                        Intent signinpage = new Intent(MainActivity.this, Signinpage.class);
                        startActivity(signinpage);
                    }
                }
        );
        TextView Signupcustomer = (TextView)findViewById(R.id.Signupcustomer);

        Signupcustomer.setOnClickListener(
                new TextView.OnClickListener(){
                    public void onClick(View v){
                        Intent signuppage = new Intent(MainActivity.this, signuppage.class);
                        startActivity(signuppage);
                    }
                }
        );
    }
}
