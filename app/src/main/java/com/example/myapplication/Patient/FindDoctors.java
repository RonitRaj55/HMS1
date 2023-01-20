package com.example.myapplication.Patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class FindDoctors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctors);


        CardView exit =findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindDoctors.this,PatientPage.class));
            }
        });

        CardView physician = findViewById(R.id.cardFDPhysician);
        physician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent( FindDoctors.this,DoctorDetails.class);
                it.putExtra("title","PHYSICIAN");
                startActivity(it);
            }
        });



        CardView dietician = findViewById(R.id.cardFDDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent( FindDoctors.this,DoctorDetails.class);
                it.putExtra("title","DIETICIAN");
                startActivity(it);
            }
        });
        CardView dentist = findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctors.this,DoctorDetails.class);
                it.putExtra("title","DENTIST");
                startActivity(it);
            }
        });

        CardView surgeon= findViewById(R.id.cardFDSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent( FindDoctors.this,DoctorDetails.class);
                it.putExtra("title","SURGEON");
                startActivity(it);
            }
        });
        CardView cardiologist = findViewById(R.id.cardFDCardiologists);
        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent( FindDoctors.this,DoctorDetails.class);
                it.putExtra("title","CARDIOLOGIST");
                startActivity(it);
            }
        });



    }
}