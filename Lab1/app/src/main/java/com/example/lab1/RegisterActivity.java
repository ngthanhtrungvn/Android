package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegister, btnCancel;
    EditText txtEmail, txtUserName, txtPassword, txtConfirmPW;
    public static final String EMAIL_VERIFICATION = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mapping();
        eventClick();
    }

    private boolean validateEditText(EditText txt) {
        boolean check = txt.getText().toString().isEmpty();
        if (check) {
            txt.setError(txt.getTag() + " không được rỗng.");
            txt.requestFocus();
        }
        return check;
    }

    private void eventClick() {
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivty.class);
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtEmail.setError(null);
                txtUserName.setError(null);
                txtPassword.setError(null);
                txtConfirmPW.setError(null);

                if (validateEditText(txtEmail) || validateEditText(txtUserName)
                        || validateEditText(txtPassword) || validateEditText(txtConfirmPW))
                    return;

                if (!isEmailValid(txtEmail.getText().toString())) {
                    txtEmail.setError("Email không đúng định dạng.");
                    txtEmail.requestFocus();
                    return;
                }
                if (!txtPassword.getText().toString().equals(txtConfirmPW.getText().toString())) {
                    txtConfirmPW.setError("Xác nhận mật khẩu không chính xác.");
                    txtConfirmPW.requestFocus();
                    return;
                }
                Toast.makeText(RegisterActivity.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=getIntent();
                        intent.putExtra("US",txtUserName.getText().toString());
                        intent.putExtra("PW",txtPassword.getText().toString());
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                }, 1000);
            }
        });
    }

    private void mapping() {
        btnRegister = (Button) findViewById(R.id.btnRegister_Register);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        txtEmail = (EditText) findViewById(R.id.email);
        txtUserName = (EditText) findViewById(R.id.username_register);
        txtPassword = (EditText) findViewById(R.id.password_register);
        txtConfirmPW = (EditText) findViewById(R.id.confirm_password);
    }

    public static boolean isEmailValid(String email) {
        final Pattern EMAIL_REGEX = Pattern.compile(EMAIL_VERIFICATION, Pattern.CASE_INSENSITIVE);
        return EMAIL_REGEX.matcher(email).matches();
    }
}