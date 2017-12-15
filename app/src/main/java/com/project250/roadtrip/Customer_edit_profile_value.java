package com.project250.roadtrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Customer_edit_profile_value extends AppCompatActivity {

    Button save_button_pro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_edit_profile_value);

        change_pro();
    }

    public void change_pro(){
        save_button_pro = (Button)findViewById(R.id.Save_button_pro);
        save_button_pro.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Toast.makeText(getApplicationContext(),"Changed has been saved",Toast.LENGTH_SHORT).show();
                        Intent save_pro = new Intent(Customer_edit_profile_value.this,Customer_home.class);
                        startActivity(save_pro);
                    }
                }
        );

    }
}
