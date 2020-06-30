package com.example.de4;

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
    Spinner spnLeft, spnRight;
    EditText input;
    Button btnTrasfer, btnSwap;
    TextView result, value;

    int left = 0, right = 0;
    double i = 0, r = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initial();

        btnSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swap();
            }
        });

        btnTrasfer.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View v) {
                int a = spnLeft.getSelectedItemPosition();
                int b = spnRight.getSelectedItemPosition();
                i = Double.parseDouble(input.getText().toString());

                if (a == b){
                    value.setText(input.getText() + " " + spnLeft.getSelectedItem().toString());
                    result.setText(input.getText() + " " + spnRight.getSelectedItem().toString());
                } else if (a == 0){
                    r = Exchange(i, b);
                    value.setText(input.getText() + " " + spnLeft.getSelectedItem().toString());
                    result.setText("=" + " " + new DecimalFormat("###,###,###.###").format(r) + " " + spnRight.getSelectedItem().toString());
                } else if(a == 1){
                    r = Exchange2(i, b);
                    value.setText(input.getText() + " " + spnLeft.getSelectedItem().toString());
                    result.setText("=" + " " + new DecimalFormat("###,###,###.###").format(r) + " " + spnRight.getSelectedItem().toString());
                } else if(a == 2){
                    r = Exchange3(i, b);
                    value.setText(input.getText() + " " + spnLeft.getSelectedItem().toString());
                    result.setText("=" + " " + new DecimalFormat("###,###,###.###").format(r) + " " + spnRight.getSelectedItem().toString());
                } else if(a == 3){
                    r = Exchange4(i, b);
                    value.setText(input.getText() + " " + spnLeft.getSelectedItem().toString());
                    result.setText("=" + " " + new DecimalFormat("###,###,###.###").format(r) + " " + spnRight.getSelectedItem().toString());
                }
            }
        });
    }

    public void swap(){
        left = spnLeft.getSelectedItemPosition();
        right = spnRight.getSelectedItemPosition();
        spnLeft.setSelection(right);
        spnRight.setSelection(left);
    }

    public double Exchange(double money, int currency){
        double result = 0;
        switch (currency)
        {
            case 1:
                result = money / 23000;
                break;
            case 2:
                result = money / 26090;
                break;
            case 3:
                result = money / 15960;
                break;
        }
        return result;
    }

    public double Exchange2(double money, int currency){
        double result = 0;
        switch (currency)
        {
            case 0:
                result = money * 23000;
                break;
            case 2:
                result = money * 0.891315;
                break;
            case 3:
                result = money * 1.45707;
                break;
        }
        return result;
    }

    public double Exchange3(double money, int currency){
        double result = 0;
        switch (currency)
        {
            case 0:
                result = money * 26090;
                break;
            case 1:
                result = money * 1.12191;
                break;
            case 3:
                result = money * 1.63472;
                break;
        }
        return result;
    }

    public double Exchange4(double money, int currency){
        double result = 0;
        switch (currency)
        {
            case 0:
                result = money * 15959.83;
                break;
            case 1:
                result = money * 0.686302;
                break;
            case 2:
                result = money * 0.611726;
                break;
        }
        return result;
    }


    public void Initial(){
        spnLeft = findViewById(R.id.spnLeft);
        spnRight = findViewById(R.id.spnRight);
        input = findViewById(R.id.inputValue);
        btnTrasfer = findViewById(R.id.btnTrasfer);
        btnSwap = findViewById(R.id.btnSwap);
        result = findViewById(R.id.txtResult);
        value = findViewById(R.id.txtValue);
    }
}
