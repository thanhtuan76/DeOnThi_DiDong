package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Introduction extends AppCompatActivity {
    TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        userName = findViewById(R.id.userName);

        Intent intent = getIntent();
        String txtUserName = (String) intent.getSerializableExtra("username");
        userName.setText(txtUserName);
    }


}