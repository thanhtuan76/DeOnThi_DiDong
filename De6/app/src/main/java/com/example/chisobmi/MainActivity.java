package com.example.chisobmi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText weight, height;
    Button btnCaculate;
    TextView txtRe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initial();
        calculate();
    }

    private void calculate(){
        btnCaculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double w = Double.parseDouble(weight.getText().toString());
                double h = Double.parseDouble(height.getText().toString());

                double r = w / Math.pow(h, 2);
                txtRe.setText(String.valueOf(r));

            }
        });
    }

    public void Initial(){
        weight = (EditText) findViewById(R.id.weight);
        height = (EditText) findViewById(R.id.height);
        btnCaculate = findViewById(R.id.btnCalculate);
        txtRe = findViewById(R.id.result);
    }
}