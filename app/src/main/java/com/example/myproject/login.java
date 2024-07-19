package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {
Button loginBtn;
EditText emailEditText,passwordEditText;
int counter=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
       /* lbtn=findViewById(R.id.button2);
        lbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(login.this,finall.class);
                startActivity(i);*/
        emailEditText=findViewById(R.id.editTextTextEmailAddress2);
        passwordEditText=findViewById(R.id.editTextTextPassword2);
        loginBtn=findViewById(R.id.button2);
        String registeredEmail=getIntent().getStringExtra("email");
        String registeredPassword=getIntent().getStringExtra("password");
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailEditText.getText().toString();
                String password=passwordEditText.getText().toString();
                if(registeredEmail.equals(email)&& registeredPassword.equals(password))
                {
                    Intent intent=new Intent(login.this,finall.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(login.this,"Invalid Credentials",Toast.LENGTH_LONG).show();
                }
                counter--;
                if (counter==0)
                {
                    Toast.makeText(getBaseContext(),"FAILED LOGIN ATTEMPTS",Toast.LENGTH_LONG).show();
                            loginBtn.setEnabled(false);
                }
            }
        });
    }
}
