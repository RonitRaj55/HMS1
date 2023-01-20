package com.example.myapplication.Patient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetails extends AppCompatActivity {

    private String[][] doctor_details1 =
            {
                    { "Doctor Name : Anique Jana", "Hospital Address : Newtown","Exp :10yrs", "Mobile No: 9988776655","600"},
                    { "Doctor Name : Dipesh Mahato", "Hospital Address : Saltlake","Exp :15yrs", "Mobile No: 9988572651","100"},
                    { "Doctor Name : Ronit Raj", "Hospital Address : Kodarma","Exp :13yrs", "Mobile No: 5982774655","400"},
                    { "Doctor Name : Ram Das", "Hospital Address : Bali","Exp :1yrs", "Mobile No: 9984176625","300"},
                    { "Doctor Name : Yukti Butolia", "Hospital Address : Chinar Park","Exp :11yrs", "Mobile No: 8938746665","450"}

            };
    private String[][] doctor_details2 =
            {
                    { "Doctor Name : Anique Jana", "Hospital Address : Newtown","Exp :10yrs", "Mobile No: 9988776655","600"},
                    { "Doctor Name : Dipesh Mahato", "Hospital Address : Saltlake","Exp :15yrs", "Mobile No: 9988572651","100"},
                    { "Doctor Name : Ronit Raj", "Hospital Address : Kodarma","Exp :13yrs", "Mobile No: 5982774655","400"},
                    { "Doctor Name : Ram Das", "Hospital Address : Bali","Exp :1yrs", "Mobile No: 9984176625","300"},
                    { "Doctor Name : Yukti Butolia", "Hospital Address : Chinar Park","Exp :11yrs", "Mobile No: 8938746665","450"}

            };
    private String[][] doctor_details3 =
            {
                    { "Doctor Name : Anique Jana", "Hospital Address : Newtown","Exp :10yrs", "Mobile No: 9988776655","600"},
                    { "Doctor Name : Dipesh Mahato", "Hospital Address : Saltlake","Exp :15yrs", "Mobile No: 9988572651","100"},
                    { "Doctor Name : Ronit Raj", "Hospital Address : Kodarma","Exp :13yrs", "Mobile No: 5982774655","400"},
                    { "Doctor Name : Ram Das", "Hospital Address : Bali","Exp :1yrs", "Mobile No: 9984176625","300"},
                    { "Doctor Name : Yukti Butolia", "Hospital Address : Chinar Park","Exp :11yrs", "Mobile No: 8938746665","450"}

            };
    private String[][] doctor_details4 =
            {
                    { "Doctor Name : Anique Jana", "Hospital Address : Newtown","Exp :10yrs", "Mobile No: 9988776655","600"},
                    { "Doctor Name : Dipesh Mahato", "Hospital Address : Saltlake","Exp :15yrs", "Mobile No: 9988572651","100"},
                    { "Doctor Name : Ronit Raj", "Hospital Address : Kodarma","Exp :13yrs", "Mobile No: 5982774655","400"},
                    { "Doctor Name : Ram Das", "Hospital Address : Bali","Exp :1yrs", "Mobile No: 9984176625","300"},
                    { "Doctor Name : Yukti Butolia", "Hospital Address : Chinar Park","Exp :11yrs", "Mobile No: 8938746665","450"}

            };
    private String[][] doctor_details5 =
            {
                    { "Doctor Name : Anique Jana", "Hospital Address : Newtown","Exp :10yrs", "Mobile No: 9988776655","600"},
                    { "Doctor Name : Dipesh Mahato", "Hospital Address : Saltlake","Exp :15yrs", "Mobile No: 9988572651","100"},
                    { "Doctor Name : Ronit Raj", "Hospital Address : Kodarma","Exp :13yrs", "Mobile No: 5982774655","400"},
                    { "Doctor Name : Ram Das", "Hospital Address : Bali","Exp :1yrs", "Mobile No: 9984176625","300"},
                    { "Doctor Name : Yukti Butolia", "Hospital Address : Chinar Park","Exp :11yrs", "Mobile No: 8938746665","450"}

            };

    TextView tv;
    Button btn;
    String[][] doctor_details={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonDDBack);
        Intent it =getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("PHYSICIAN")==0)
            doctor_details = doctor_details1;
        else

        if(title.compareTo("DIETICIAN")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("DENTIST")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("SURGEON")==0)
            doctor_details = doctor_details4;

        else
            doctor_details = doctor_details5;



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetails.this,FindDoctors.class));
            }
        });

        list=new ArrayList();
        for(int i=0;i<doctor_details.length;i++)
        {
            item=new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees: Rs."+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        ListView lst=findViewById(R.id.listViewDD);
        lst.setAdapter(sa);


    }
}