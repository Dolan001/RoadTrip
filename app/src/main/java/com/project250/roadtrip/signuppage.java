package com.project250.roadtrip;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signuppage extends AppCompatActivity {
    FirebaseAuth auth;
    Firebase rootfb;
    String username;
    String useremail;
    String userpassword;
    String usermobile_no;
    String useraddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);

        auth=FirebaseAuth.getInstance();
        rootfb = new Firebase("https://roadtrip-3f2fe.firebaseio.com/Customer").push();
        final Button signup = (Button)findViewById(R.id.signup);
        final TextView fname = (TextView)findViewById(R.id.fname);
        final TextView email = (TextView)findViewById(R.id.email);
        final TextView pass = (TextView)findViewById(R.id.pass);
        final TextView phn_no = (TextView)findViewById(R.id.phn_no);
        final TextView address = (TextView)findViewById(R.id.address);
        TextView existsacc = (TextView)findViewById(R.id.existsacc);


        signup.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        validate();
                            if (!validate()) {
                                Toast.makeText(getApplicationContext(),"All information required",Toast.LENGTH_LONG).show();

                                Intent samepage = new Intent(signuppage.this, signuppage.class);
                                startActivity(samepage);
                            } else {
                                Firebase customerchildname = rootfb.child("Name");
                                customerchildname.setValue(username);
                                Firebase customerchildemail = rootfb.child("Email");
                                customerchildemail.setValue(useremail);
                                Firebase customerchildphn = rootfb.child("Mobile_No");
                                customerchildphn.setValue(usermobile_no);
                                Firebase customerchildaddress = rootfb.child("Address");
                                customerchildaddress.setValue(useraddress);

                                auth.createUserWithEmailAndPassword(useremail,userpassword).addOnCompleteListener(
                                        new OnCompleteListener<AuthResult>() {
                                            @Override
                                            public void onComplete(@NonNull Task<AuthResult> task) {
                                                if(task.isSuccessful())
                                                {
                                                    Toast.makeText(getApplicationContext(),"username saved",Toast.LENGTH_SHORT).show();
                                                    Intent signin = new Intent(signuppage.this, Signinpage.class);
                                                    startActivity(signin);
                                                }else{
                                                    Toast.makeText(getApplicationContext(),"Failed please try again!",Toast.LENGTH_SHORT).show();
                                                }

                                            }
                                        });
                            }

                        }
                    public  boolean validate(){
                        username = String.valueOf(fname.getText().toString().trim());
                        useremail = String.valueOf(email.getText().toString().trim());
                        userpassword = String.valueOf(pass.getText().toString().trim());
                        usermobile_no = String.valueOf(phn_no.getText().toString().trim());
                        useraddress = String.valueOf(address.getText().toString().trim());
                        boolean valid = true;
                        if (username.isEmpty() || username.length() > 32) {
                            valid = false;
                        }
                        if (useremail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(useremail).matches()) {
                            valid = false;
                        }
                        if (userpassword.isEmpty() || userpassword.length() < 8) {
                            valid = false;
                        }
                        if (usermobile_no.isEmpty() || useraddress.isEmpty()) {
                            valid = false;
                        }
                        return valid;
                    }
                }
        );
        existsacc.setOnClickListener(
                new TextView.OnClickListener(){
                    public void onClick(View v){
                        Intent signinpage = new Intent(signuppage.this,Signinpage.class);
                        startActivity(signinpage);
                    }
                }
        );
    }
}