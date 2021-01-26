package com.example.pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class RegistrationActivity extends AppCompatActivity {

    ImageView back;
    EditText email, password, fname,lname,phone;
    Button cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        back=(ImageView)findViewById(R.id.back_arrow);
        email=(EditText)findViewById(R.id.email_register);
        password=(EditText)findViewById(R.id.password_register);
        fname=(EditText)findViewById(R.id.fname_register);
        lname=(EditText)findViewById(R.id.lname_register);
        phone=(EditText)findViewById(R.id.phone_register);
        cont=(Button)findViewById(R.id.continue_button);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });

        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vemail=email.getText().toString().trim();
                String vpass=password.getText().toString().trim();
                String vfname=fname.getText().toString().trim();
                String vlname=lname.getText().toString().trim();
                String vphone=phone.getText().toString().trim();

                if(vemail.isEmpty()||vpass.isEmpty()||vfname.isEmpty()||vlname.isEmpty()||vphone.isEmpty()){
                    email.setError("This field cannot be blank");
                    password.setError("This field cannot be blank");
                    fname.setError("This field cannot be blank");
                    lname.setError("This field cannot be blank");
                    phone.setError("This field cannot be blank");

                }

                else if (vemail.isEmpty()&&vpass.isEmpty()&&vfname.isEmpty()&&vlname.isEmpty()&&vphone.isEmpty()){
                    email.setError("This field cannot be blank");
                    password.setError("This field cannot be blank");
                    fname.setError("This field cannot be blank");
                    lname.setError("This field cannot be blank");
                    phone.setError("This field cannot be blank");
                }
                else{
                    startActivity(new Intent(getApplicationContext(), ContActivity.class));
                    finish();
                }

            }
        });
    }
}