package com.example.spc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText_username;
    private EditText editText_password;
    private Button btn_login;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        editText_password = (EditText) findViewById(R.id.text_username);
        editText_password = (EditText) findViewById(R.id.text_password);
        btn_login = (Button) findViewById(R.id.button_login);
        btn_login.setOnClickListener(this);
        btn_register = (Button) findViewById(R.id.button_register);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:
                Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.button_register:
                Intent intent2 = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent2);
                break;
        }
    }
}