package com.example.pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {

    Button signin;
    EditText email,password;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=(EditText)findViewById(R.id.email_sign);
        password=(EditText)findViewById(R.id.password_sign);
        signin=(Button)findViewById(R.id.signin_button);
        back=(ImageView)findViewById(R.id.back_arrow);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String semail=email.getText().toString().trim();
                String spass=password.getText().toString().trim();

                if(semail.isEmpty()||spass.isEmpty()){
                    email.setError("This field cannot be empty");
                    password.setError("This field cannot be empty");
                }
                else if(semail.isEmpty()&&spass.isEmpty()){
                    email.setError("This field cannot be empty");
                    password.setError("This field cannot be empty");
                }
                else{
                    startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
                    finish();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
    }
}