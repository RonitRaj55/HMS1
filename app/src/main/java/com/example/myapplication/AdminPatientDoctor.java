package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.Doctor.DoctorLogin;
import com.example.myapplication.Patient.PatientLogin;
import com.google.android.material.button.MaterialButton;

public class AdminPatientDoctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_patient_doctor);

        MaterialButton adminbutton = (MaterialButton) findViewById(R.id.adminbutton);
        MaterialButton patientbutton = (MaterialButton) findViewById(R.id.patientbutton);
        MaterialButton doctorbutton = (MaterialButton) findViewById(R.id.doctorbutton);

        adminbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchActivity1=new Intent(AdminPatientDoctor.this,MainActivity.class);
                startActivity(launchActivity1);
            }
        });

        patientbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ob=new Intent(AdminPatientDoctor.this, PatientLogin.class);
                startActivity(ob);
            }
        });

        doctorbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s=new Intent(AdminPatientDoctor.this, DoctorLogin.class);
                startActivity(s);
            }
        });
    }
}