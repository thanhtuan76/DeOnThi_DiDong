package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txtName, txtUser, txtPass, txtDate;
    Button btnCreate;
    RadioButton rdMan, rdWoman;
    TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initial();

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isName = checkName();
                boolean isDate = checkDate();
                boolean isUser = checkUser();
                boolean isPass = checkPass();
                boolean checkAll = isName && isDate && isPass && isUser;

                if (checkAll){
                    Intent intent = new Intent(getApplicationContext(), Introduction.class);
                    intent.putExtra("username", txtName.getText().toString());
                    startActivity(intent);
                }
            }
        });


    }

    public boolean checkName() {
        String name = txtName.getText().toString();
        if (name.length() == 0) {
            txtName.setError("Họ tên không được bỏ trống!!!");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkDate() {
        String date = txtDate.getText().toString();
        if (date.length() == 0) {
            txtDate.setError("Ngày sinh không được bỏ trống!!!");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkUser() {
        String user = txtUser.getText().toString();
        if (user.length() == 0) {
            txtUser.setError("Tên đăng nhập không được bỏ trống!!!");
            return false;
        } else {
            if (user.contains(" ")) {
                txtUser.setError("Tên đăng nhập không thêm khoảng trắng!!!");
            } else {
                if (user.length() > 128) {
                    txtUser.setError("Tên đăng nhập không dài quá 128 ký tự!!!");
                }
            }
        }
        return true;
    }

    public boolean checkPass() {
        String pass = txtPass.getText().toString();
        if (pass.length() == 0) {
            txtPass.setError("Mật khẩu không được bỏ trống!!!");
            return false;
        } else {
            if (pass.length() <= 8) {
                txtPass.setError("Mật khẩu phải có ít nhất 8 ký tự!!!");
                return false;
            } else {
                if (pass.matches(".*\\d.*")){
                    txtPass.setError("Mật khẩu phải có ít 1 ký tự số!!!");
                    return false;
                } else {
                    if (pass.matches("[a-zA-Z0-9]*")) {
                        txtPass.setError("Mật khẩu phải có ít 1 ký tự đặc biệt!!!");
                        return false;
                    } else {
                        boolean hasLowercase = !pass.equals(pass.toLowerCase());
                        if (!hasLowercase){
                            txtPass.setError("Mật khẩu phải có ít 1 ký tự hoa!!!");
                            return false;
                        } else {
                            boolean hasUppercase = !pass.equals(pass.toUpperCase());
                            if (!hasUppercase){
                                txtPass.setError("Mật khẩu phải có ít 1 ký tự thường!!!");
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public void Initial() {
        txtName = findViewById(R.id.editName);
        txtUser = findViewById(R.id.editUserName);
        txtPass = findViewById(R.id.editPass);
        txtDate = findViewById(R.id.editDOB);
        btnCreate = findViewById(R.id.btnCreate);
        rdMan = findViewById(R.id.radMan);
        rdWoman = findViewById(R.id.radWoman);
        userName = findViewById(R.id.userName);
    }
}
