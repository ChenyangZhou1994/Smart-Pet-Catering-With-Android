package org.pytorch.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.pytorch.helloworld.bean.User;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText_username;
    private EditText editText_password;
    private EditText editText_password_retry;
    private EditText editText_telephone;
    private EditText editText_email;
    private EditText editText_age;
    private RadioButton radioButton_man;
    private RadioButton radioButton_woman;
    private RadioButton radioButton_unknown;
    private Button btn_register;
    RegisterDatabaseAdapter registerDataBaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    private void init() {
        editText_username = (EditText) findViewById(R.id.text_username);
        editText_password = (EditText) findViewById(R.id.text_password);
        editText_password_retry = (EditText) findViewById(R.id.text_password_retry);
        editText_telephone = (EditText) findViewById(R.id.text_telephone);
        editText_email = (EditText) findViewById(R.id.text_email);
        editText_age = (EditText) findViewById(R.id.text_age);
        radioButton_man = (RadioButton) findViewById(R.id.man);
        radioButton_woman = (RadioButton) findViewById(R.id.woman);
        radioButton_unknown = (RadioButton) findViewById(R.id.unknown);
        btn_register = (Button) findViewById(R.id.button_register);
        btn_register.setOnClickListener(this);
    }


    public void insert() {
        registerDataBaseAdapter = new RegisterDatabaseAdapter(getApplicationContext());
        registerDataBaseAdapter = registerDataBaseAdapter.open();
        String username = editText_username.getText().toString().trim();
        String password = editText_password.getText().toString().trim();
        String password_retry = editText_password_retry.getText().toString().trim();
        String telephone = editText_telephone.getText().toString().trim();
        String email = editText_email.getText().toString().trim();
        String age = editText_age.getText().toString().trim();
        String sex = "";
        if(radioButton_man.isChecked()) {
            sex = "男";
        } else if(radioButton_woman.isChecked()) {
            sex = "女";
        } else if(radioButton_unknown.isChecked()) {
            sex = "未知";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setTelephone(telephone);
        user.setEmail(email);
        user.setAge(age);
        user.setSex(sex);

        String msg = registerDataBaseAdapter.insertEntry(user);
        if(msg.equals("OK")) {
            Toast.makeText(this,"注册成功!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"注册失败!", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View v) {
            insert();
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
    }
}