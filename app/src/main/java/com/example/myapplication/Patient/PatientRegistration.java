package com.example.myapplication.Patient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Database;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.google.android.material.button.MaterialButton;

public class PatientRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);

        EditText name = (EditText) findViewById(R.id.name);
        EditText email = (EditText) findViewById(R.id.email);
        EditText age = (EditText) findViewById(R.id.age);
        EditText gender = (EditText) findViewById(R.id.gender);
        EditText bloodgroup = (EditText) findViewById(R.id.bloodgroup);
        EditText newpassword = (EditText) findViewById(R.id.newpassword);
        EditText confirmpassword = (EditText) findViewById(R.id.confirmpassword);

        MaterialButton button2 = (MaterialButton) findViewById(R.id.button2);

        TextView already = (TextView) findViewById(R.id.already);

        String text = "Already have an account ? Log in";

        SpannableString s = new SpannableString(text);

        ClickableSpan s1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent in = new Intent(PatientRegistration.this,PatientLogin.class);
                startActivity(in);
            }
        };

        s.setSpan(s1,26,32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        already.setText(s);
        already.setMovementMethod(LinkMovementMethod.getInstance());

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name1 = name.getText().toString();
                final String email1 = email.getText().toString();
                final String pass = newpassword.getText().toString();
                final String cnf = confirmpassword.getText().toString();
                Database db=new Database(getApplicationContext(),"Patient",null,1);

                if(name1.isEmpty()  || email1.isEmpty() || pass.isEmpty() || cnf.isEmpty())
                {
                    Toast.makeText(PatientRegistration.this, "Enter valid credentials", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    if(confirmpassword.getText().toString().equals(pass)) {
                        if(isValid(pass)){
                            db.register(name1,email1,pass);
                            Toast.makeText(PatientRegistration.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(PatientRegistration.this, PatientLogin.class));
                        }
                        else{
                            Toast.makeText(PatientRegistration.this,"Password must contain at least 8 characters,having letter,digit and special characters",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(PatientRegistration.this, "Password and Confirm Password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    public static boolean isValid(String passwordhere) {
        int f1=0,f2=0,f3=0;
        if(passwordhere.length()<8) {
            return false;
        }else{
            for(int p = 0; p<passwordhere.length(); p++){
                if(Character.isLetter(passwordhere.charAt(p))){
                    f1=1;
                }
            }
            for(int r=0;r<passwordhere.length();r++){
                if(Character.isDigit(passwordhere.charAt(r))){
                    f2=1;
                }
            }
            for(int s=0;s<passwordhere.length();s++){
                char c=passwordhere.charAt(s);
                if(c>=33 && c<=46 || c==64){
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1){
                return true;
            }
            return false;
        }
    }
}