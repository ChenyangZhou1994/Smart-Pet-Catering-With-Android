package org.pytorch.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText_username;
    private EditText editText_password;
    LoginDatabaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginDataBaseAdapter=new LoginDatabaseAdapter(getApplicationContext());
        editText_username = (EditText) findViewById(R.id.login_username);
        editText_password = (EditText) findViewById(R.id.login_password);
        init();
    }

    public void init() {
        Button btn_login = (Button) findViewById(R.id.button_login);
        btn_login.setOnClickListener(this);
        Button btn_register = (Button) findViewById(R.id.button_to_register);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:
                Login();
                break;
            case R.id.button_to_register:
                Register();
                break;
        }
    }

    public void Login() {
        loginDataBaseAdapter = loginDataBaseAdapter.open();
        String username = editText_username.getText().toString().trim();
        String password = editText_password.getText().toString().trim();
        String storedPassword;
        if(username.equals("") || password.equals("")) {
            Toast.makeText(getApplicationContext(),"账号或密码为空!", Toast.LENGTH_SHORT).show();
        }
        else if(!username.equals("")) {
            storedPassword = loginDataBaseAdapter.getSinlgeEntry(username);
            if(password.equals(storedPassword)) {
                Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent1);
                Toast.makeText(getApplicationContext(),"登录成功!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(),"密码错误!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void Register() {
        Intent intent2 = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent2);
    }


}