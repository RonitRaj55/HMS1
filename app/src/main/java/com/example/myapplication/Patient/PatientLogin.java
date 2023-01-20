package com.example.myapplication.Patient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.myapplication.Doctor.DoctorPage;
import com.example.myapplication.R;
import com.google.android.material.button.MaterialButton;

public class PatientLogin extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);

        EditText edusername = (EditText) findViewById(R.id.username);
        EditText edpassword = (EditText) findViewById(R.id.password);
        TextView account = (TextView) findViewById(R.id.account);

        MaterialButton button1 = (MaterialButton) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edusername.getText().toString();
                String password=edpassword.getText().toString();
                Database db =new Database(PatientLogin.this,"Patient",null,1);
                if(username.length()==0||password.length()==0){
                    Toast.makeText(getApplicationContext(),"please fill all details",Toast.LENGTH_SHORT).show();
                }else{
                    if(db.login(username,password)==1){
                        Toast.makeText(PatientLogin.this, "Login Success", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedpreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedpreferences.edit();
                        editor.putString("username", String.valueOf(username));
                        editor.apply();
                        startActivity(new Intent(PatientLogin.this, PatientPage.class));
                    }else{
                        Toast.makeText(getApplicationContext(),"Invalid Username or Password",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        String text="Dont have an account ? Sign Up";

        SpannableString s = new SpannableString(text);

        ClickableSpan s1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent ob1 = new Intent(PatientLogin.this,PatientRegistration.class);
                startActivity(ob1);
            }
        };

        s.setSpan(s1,23,30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        account.setText(s);
        account.setMovementMethod(LinkMovementMethod.getInstance());

       /* account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchActivity1=new Intent(MainActivity.this,Registration.class);
                startActivity(launchActivity1);
            }
        });*/
    }
}