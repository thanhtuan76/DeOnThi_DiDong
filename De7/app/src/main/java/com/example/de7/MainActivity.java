package com.example.de7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btnCalculate;
    EditText inputPrice;
    Spinner spnCategory, spnLocation;
    TextView price1, price2, price3, price4, price5, price6, priceTotal, percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initial();
        start();

    }

    public void start(){
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                double input = Double.parseDouble(inputPrice.getText().toString());
                double r = 0, rf =0, p2 = 0, p3 = 0, p4 = 0, p5 = 0, p6 = 0 ;
                if (inputPrice.getText().length() > 0){
                     price1.setText(new DecimalFormat("###,###,###.###").format(input) + " Đ");
                     switch (spnLocation.getSelectedItemPosition()){
                         case 0:
                             percent.setText("(10%)");
                             price5.setText("11,000,000 Đ");
                             p5 = 11000000;
                             r = input * 10/100;
                             price2.setText(new DecimalFormat("###,###,###.###").format(r) + " Đ");
                             p2 = r;
                             break;
                         case 1:
                         case 2:
                             percent.setText("(3%)");
                             price5.setText("3,000,000 Đ");
                             p5 = 3000000;
                             r = input * 3/100;
                             price2.setText(new DecimalFormat("###,###,###.###").format(r) + " Đ");
                             p2 = r;
                             break;
                         default:
                             return;
                     }
                     switch (spnCategory.getSelectedItemPosition()){
                         case 0:
                             price3.setText("1,560,000 Đ");
                             p3 = 1560000;
                             price4.setText("794,000 Đ");
                             p4 = 794000;
                             price6.setText("340,000 Đ");
                             p6 = 340000;
                             break;
                         case 1:
                             price3.setText("Không thu");
                             p3 = 0;
                             price4.setText("933,000 Đ");
                             p4 = 933000;
                             price6.setText("540,000 Đ");
                             p6 = 540000;
                             break;
                         case 2:
                             price3.setText("2,160,000 Đ");
                             p3 = 2160000;
                             price4.setText("953,000 Đ");
                             p4 = 953000;
                             price6.setText("540,000 Đ");
                             p6 = 540000;
                             break;
                     }

                     rf = input + p2 + p3 + p4 + p5 + p6;
                     priceTotal.setText(new DecimalFormat("###,###,###").format(rf) + " Đ");
                }
            }
        });
    }

    public void Initial(){
        btnCalculate = findViewById(R.id.btnCal);
        inputPrice = findViewById(R.id.inputPrice);
        spnCategory = findViewById(R.id.spnCategory);
        spnLocation = findViewById(R.id.spnLocation);
        price1 = findViewById(R.id.price1);
        price2 = findViewById(R.id.price2);
        price3 = findViewById(R.id.price3);
        price4 = findViewById(R.id.price4);
        price5 = findViewById(R.id.price5);
        price6 = findViewById(R.id.price6);
        percent = findViewById(R.id.percent);
        priceTotal = findViewById(R.id.priceTotal);
    }
}