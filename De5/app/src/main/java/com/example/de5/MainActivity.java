package com.example.de5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity{
    Button cal;
    Spinner spn;
    TextView txtKQ;
    EditText thuNhap, chiTra, tienVay;
    RadioButton rd12, rd24, rd36, rd48;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Innitial();
        action();
    }

    private void action(){
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (TextUtils.isEmpty(thuNhap.getText().toString()))
                {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập thu nhập hàng tháng!!!", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(chiTra.getText().toString()))
                {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập chi phí trả trong tháng!!!", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(tienVay.getText().toString()))
                {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số tiền muốn vay!!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    double sa = Double.parseDouble(thuNhap.getText().toString());
                    double sb = Double.parseDouble(chiTra.getText().toString());
                    double sc = Double.parseDouble(tienVay.getText().toString());

                    if (sc >= 10*(sa - sb))
                    {
                        Toast.makeText(MainActivity.this, "Số tiền vay không được quá 10 lần tiền còn lại", Toast.LENGTH_SHORT).show();
                    }
                    else if (sc <= 20000000)
                    {
                        Toast.makeText(MainActivity.this, "Số tiền vay không được ít hơn 20 triệu", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        double result = 0;
                        if (rd12.isChecked())
                        {
                            result = sc * Math.pow(1+laiSuat(), 12)/12;
                            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                            txtKQ.setText(decimalFormat.format(result) + "Đ");
                        }
                        else if (rd24.isChecked())
                        {
                            result = (sc * Math.pow(1+laiSuat(), 24))/24;
                            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                            txtKQ.setText(decimalFormat.format(result) + "Đ");
                        }
                        else if (rd36.isChecked())
                        {
                            result = (sc * Math.pow(1+laiSuat(), 36))/36;
                            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                            txtKQ.setText(decimalFormat.format(result) + "Đ");
                        }
                        else if (rd48.isChecked())
                        {
                            result = (sc * Math.pow(1+laiSuat(), 48))/48;
                            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                            txtKQ.setText(decimalFormat.format(result) + "Đ");
                        }
                    }
                }
            }
        });
    }


    public void Innitial (){
        thuNhap = findViewById(R.id.numThuNhap);
        chiTra = findViewById(R.id.numTra);
        tienVay = findViewById(R.id.numVay);
        txtKQ = findViewById(R.id.textKQ);
        spn = findViewById(R.id.spinner);
        cal = findViewById(R.id.btnCalculate);
        rd12 = findViewById(R.id.rabtn12);
        rd24 = findViewById(R.id.rabtn24);
        rd36 = findViewById(R.id.rabtn36);
        rd48 = findViewById(R.id.rabtn48);
    }

    public double laiSuat() {
        int check = spn.getSelectedItemPosition();
        if (check == 0)
            return 0.16;
        else if (check == 1)
            return 0.17;
        else return 0.18;
    }
}