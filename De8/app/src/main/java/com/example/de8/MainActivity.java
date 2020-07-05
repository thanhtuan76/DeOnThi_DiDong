package com.example.de8;

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
    EditText salary, people;
    Spinner month, year;
    Button btnCalc;
    TextView txtSalaryTax, txtTaxValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initial();
        calculate();
    }

    public void calculate() {
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                double sal = Double.parseDouble(salary.getText().toString());
                int peop = Integer.parseInt(people.getText().toString());
                double res = 0;
                if (Integer.parseInt(month.getSelectedItem().toString()) < 7
                        && Double.parseDouble(String.valueOf(year.getSelectedItemPosition())) < 2020) {
//                    if (Double.parseDouble(String.valueOf(year.getSelectedItemPosition())) < 2020) {
                    res = sal - 9 * Math.pow(10, 6) - (peop * 3.6 * Math.pow(10, 6)) * 1.0;

                    if (res <= 0)
                        txtSalaryTax.setText("Thu nhập quá thấp, không cần nộp thuế TNCN!!!");
                    else if (res <= 5 * Math.pow(10, 6)){
                        txtSalaryTax.setText(new DecimalFormat("###,###,###.###").format(res) + " Đ");
                    }
                }

                else{
//                    if (Double.parseDouble(String.valueOf(year.getSelectedItemPosition())) >= 2020) {
                res = sal - 11 * Math.pow(10, 6) - (peop * 4.4 * Math.pow(10, 6)) * 1.0;
                if (res <= 0)
                    txtSalaryTax.setText("Thu nhập quá thấp, không cần nộp thuế TNCN!!!");
                else
                    txtSalaryTax.setText(new DecimalFormat("###,###,###.###").format(res) + " Đ");
            }
        }
    });
}

    public void Initial() {
        salary = findViewById(R.id.salary);
        people = findViewById(R.id.people);
        month = findViewById(R.id.month);
        year = findViewById(R.id.year);
        btnCalc = findViewById(R.id.btnCalculate);
        txtSalaryTax = findViewById(R.id.salaryTax);
        txtTaxValue = findViewById(R.id.taxValue);
    }
}