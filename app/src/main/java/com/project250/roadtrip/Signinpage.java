package com.project250.roadtrip;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signinpage extends AppCompatActivity {
    private String username, userpass;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinpage);

        firebaseAuth = FirebaseAuth.getInstance();
        Button signin = (Button)findViewById(R.id.signin);
        final TextView inputemail = (TextView)findViewById(R.id.inputemail);
        final TextView inputpass = (TextView)findViewById(R.id.inputpass);
        TextView createacc = (TextView)findViewById(R.id.createacc);
        TextView forgotpass = (TextView)findViewById(R.id.forgotpass);

        signin.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        validate();
                        if(!validate()){
                            Toast.makeText(getApplicationContext(),"Please enter all information",Toast.LENGTH_LONG).show();

                            Intent samepage = new Intent(Signinpage.this, Signinpage.class);
                            startActivity(samepage);
                        }else {
                            username = String.valueOf(inputemail.getText().toString().trim());
                            userpass = String.valueOf(inputpass.getText().toString().trim());
                            firebaseAuth.signInWithEmailAndPassword(username,userpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(getApplicationContext(),"Successfully sign in",Toast.LENGTH_SHORT).show();
                                        Intent home = new Intent(Signinpage.this,Customer_home.class);
                                        startActivity(home);
                                    }else{
                                        Toast.makeText(getApplicationContext(),"Enter Correct information",Toast.LENGTH_SHORT).show();
                                        Intent same = new Intent(Signinpage.this,Signinpage.class);
                                        startActivity(same);
                                    }
                                }
                            });

                        }
                    }
                    public boolean validate(){
                        boolean valid = true;
                        username = String.valueOf(inputemail.getText());
                        userpass = String.valueOf(inputpass.getText());
                        if(username.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(username).matches()){
                            valid = false;
                        }
                        if(userpass.isEmpty() ||  userpass.length() < 8){
                            valid = false;
                        }

                        return valid;
                    }
                }
        );
        createacc.setOnClickListener(
                new TextView.OnClickListener(){
                    public void onClick(View v){
                        Intent signuppage = new Intent(Signinpage.this, signuppage.class);
                        startActivity(signuppage);
                    }
                }
        );
    }
}
