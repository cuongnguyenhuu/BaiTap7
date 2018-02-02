package com.nhc.cuongnguyen.baitap7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ip_a,ip_b,ip_c;
    Button btn_giai,btn_xoa;

    TextView tv_kq;

    Float a,b,c,x1,x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ip_a = (EditText) findViewById(R.id.ip_a);
        ip_b = (EditText) findViewById(R.id.ip_b);
        ip_c = (EditText) findViewById(R.id.ip_c);

        btn_giai = (Button) findViewById(R.id.btn_giai);
        btn_xoa = (Button) findViewById(R.id.btn_xoa);

        tv_kq = (TextView) findViewById(R.id.tv_kq);

        btn_giai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    a = Float.parseFloat(ip_a.getText().toString());
                    b = Float.parseFloat(ip_b.getText().toString());
                    c = Float.parseFloat(ip_c.getText().toString());
                Float denta;
                denta = b*b-4*(a*c);
                if(denta>0){
                    x1=(-b+(float) Math.sqrt(denta))/(2*a);
                    x2=(-b-(float) Math.sqrt(denta))/(2*a);
                    tv_kq.setText("x1="+x1+";x2="+x2);
                }
                else if(denta==0){
                    x1=x2=(-b)/(2*a);
                    tv_kq.setText("x1=x2="+x1);
                }
                else{
                    tv_kq.setText("Phuong trinh vo nghiem!");
                }
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "vui long nhap so", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ip_a.setText("");
                ip_b.setText("");
                ip_c.setText("");
                ip_a.requestFocus();
            }
        });

    }
}
