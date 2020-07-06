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
                double tax = 0;
                if (Integer.parseInt(String.valueOf(year.getSelectedItem())) < 2020
                        || (Integer.parseInt(String.valueOf(year.getSelectedItem())) == 2020 &&
                        Integer.parseInt(String.valueOf(month.getSelectedItem())) < 7)) {
//                    if (Double.parseDouble(String.valueOf(year.getSelectedItemPosition())) < 2020) {
                    res = sal - 9 * Math.pow(10, 6) - (peop * 3.6 * Math.pow(10, 6)) * 1.0;

                    if (res <= 0){
                        txtSalaryTax.setText("Thu nhập quá thấp, không cần nộp thuế thu nhập cá nhân!!!");
                        txtTaxValue.setText("0 Đ");
                    }

                    else if (res <= 5 * Math.pow(10, 6)) {
                        tax = res * 5 / 100;
                        txtSalaryTax.setText(new DecimalFormat("###,###,###.###").format(res) + " Đ");
                        txtTaxValue.setText(new DecimalFormat("###,###,###.###").format(tax) + " Đ");
                    } else if (res >= 5 * Math.pow(10, 6) && res <= 10 * Math.pow(10, 6)) {
                        tax = 0.25 * Math.pow(10, 6) + res * 5 / 100;
                        txtSalaryTax.setText(new DecimalFormat("###,###,###.###").format(res) + " Đ");
                        txtTaxValue.setText(new DecimalFormat("###,###,###.###").format(tax) + " Đ");
                    } else if (res > 10 * Math.pow(10, 6) && res <= 18 * Math.pow(10, 6)) {
                        tax = 0.75 * Math.pow(10, 6) + res * 15 / 100;
                        txtSalaryTax.setText(new DecimalFormat("###,###,###.###").format(res) + " Đ");
                        txtTaxValue.setText(new DecimalFormat("###,###,###.###").format(tax) + " Đ");
                    } else if (res > 18 * Math.pow(10, 6) && res <= 32 * Math.pow(10, 6)) {
                        tax = 1.95 * Math.pow(10, 6) + res * 20 / 100;
                        txtSalaryTax.setText(new DecimalFormat("###,###,###.###").format(res) + " Đ");
                        txtTaxValue.setText(new DecimalFormat("###,###,###.###").format(tax) + " Đ");
                    } else if (res > 32 * Math.pow(10, 6) && res <= 52 * Math.pow(10, 6)) {
                        tax = 4.75 * Math.pow(10, 6) + res * 25 / 100;
                        txtSalaryTax.setText(new DecimalFormat("###,###,###.###").format(res) + " Đ");
                        txtTaxValue.setText(new DecimalFormat("###,###,###.###").format(tax) + " Đ");
                    } else if (res > 52 * Math.pow(10, 6) && res <= 80 * Math.pow(10, 6)) {
                        tax = 9.75 * Math.pow(10, 6) + res * 30 / 100;
                        txtSalaryTax.setText(new DecimalFormat("###,###,###.###").format(res) + " Đ");
                        txtTaxValue.setText(new DecimalFormat("###,###,###.###").format(tax) + " Đ");
                    } else if (res > 80 * Math.pow(10, 6)) {
                        tax = 18.15 * Math.pow(10, 6) + res * 35 / 100;
                        txtSalaryTax.setText(new DecimalFormat("###,###,###.###").format(res) + " Đ");
                        txtTaxValue.setText(new DecimalFormat("###,###,###.###").format(tax) + " Đ");
                    }
                } else if (Double.parseDouble(String.valueOf(year.getSelectedItem())) > 2020
                        || (Integer.parseInt(String.valueOf(year.getSelectedItem())) == 2020 &&
                        Integer.parseInt(String.valueOf(month.getSelectedItem())) >= 7)) {
                    res = sal - 11 * Math.pow(10, 6) - (peop * 4.4 * Math.pow(10, 6)) * 1.0;
                    if (res <= 0){
                        txtSalaryTax.setText("Thu nhập quá thấp, không cần nộp thuế thuế thu nhập cá nhân!!!");
                        txtTaxValue.setText("0 Đ");
                    }
                    else if (res <= 5 * Math.pow(10, 6)) {
                        tax = res * 5 / 100;
                        txtSalaryTax.setText(new DecimalFormat("###,###,###.###").format(res) + " Đ");
                        txtTaxValue.setText(new DecimalFormat("###,###,###.###").format(tax) + " Đ");
                    } else if (res >= 5 * Math.pow(10, 6) && res <= 10 * Math.pow(10, 6)) {
                        tax = 0.25 * Math.pow(10, 6) + res * 5 / 100;
                        txtSalaryTax.setText(new DecimalFormat("###,###,###.###").format(res) + " Đ");
                        txtTaxValue.setText(new DecimalFormat("###,###,###.###").format(tax) + " Đ");
                    } else if (res > 10 * Math.pow(10, 6) && res <= 18 * Math.pow(10, 6)) {
                        tax = 0.75 * Math.pow(10, 6) + res * 15 / 100;
                        txtSalaryTax.setText(new DecimalFormat("###,###,###.###").format(res) + " Đ");
                        txtTaxValue.setText(new DecimalFormat("###,###,###.###").format(tax) + " Đ");
                    } else if (res > 18 * Math.pow(10, 6) && res <= 32 * Math.pow(10, 6)) {
                        tax = 1.95 * Math.pow(10, 6) + res * 20 / 100;
                        txtSalaryTax.setText(new DecimalFormat("###,###,###.###").format(res) + " Đ");
                        txtTaxValue.setText(new DecimalFormat("###,###,###.###").format(tax) + " Đ");
                    } else if (res > 32 * Math.pow(10, 6) && res <= 52 * Math.pow(10, 6)) {
                        tax = 4.75 * Math.pow(10, 6) + res * 25 / 100;
                        txtSalaryTax.setText(new DecimalFormat("###,###,###.###").format(res) + " Đ");
                        txtTaxValue.setText(new DecimalFormat("###,###,###.###").format(tax) + " Đ");
                    } else if (res > 52 * Math.pow(10, 6) && res <= 80 * Math.pow(10, 6)) {
                        tax = 9.75 * Math.pow(10, 6) + res * 30 / 100;
                        txtSalaryTax.setText(new DecimalFormat("###,###,###.###").format(res) + " Đ");
                        txtTaxValue.setText(new DecimalFormat("###,###,###.###").format(tax) + " Đ");
                    } else if (res > 80 * Math.pow(10, 6)) {
                        tax = 18.15 * Math.pow(10, 6) + res * 35 / 100;
                        txtSalaryTax.setText(new DecimalFormat("###,###,###.###").format(res) + " Đ");
                        txtTaxValue.setText(new DecimalFormat("###,###,###.###").format(tax) + " Đ");
                    }
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