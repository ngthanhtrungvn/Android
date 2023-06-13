package com.example.lab1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivty extends AppCompatActivity {

    EditText txtUserName, txtPassWord;
    Button btnLogin;
    Button btnRegister;
    private static final int CODE_RESULT = 319;
    ActivityResultLauncher<Intent> activityResultLauncher;
    CheckBox checkBox;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //ánh xạ các control bên view
        mapping();

        eventClick();
        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                txtUserName.setText(result.getData().getStringExtra("US"));
                txtPassWord.setText(result.getData().getStringExtra("PW"));
            }
        });

        sharedPreferences=getSharedPreferences("File_share", Context.MODE_PRIVATE);

        //load thông tin đã lưu lên textbox
        boolean coluukhong =sharedPreferences.getBoolean("luuthongtin",false);
        if(coluukhong)
        {
            txtUserName.setText(sharedPreferences.getString("us",""));
            txtPassWord.setText(sharedPreferences.getString("pw",""));
        }
        checkBox.setChecked(coluukhong);


    }

    void mapping() {
        txtUserName = (EditText) findViewById(R.id.username_login);
        txtPassWord = (EditText) findViewById(R.id.password_login);
        btnLogin = (Button) findViewById(R.id.btnLogin_Login);
        btnRegister = (Button) findViewById(R.id.btnRegister_Login);
        checkBox=findViewById(R.id.checkbox);
    }

    void eventClick() {
        //xử lý sự kiện login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                if (txtUserName.getText().toString().isEmpty() || txtPassWord.getText().toString().isEmpty())
                {
                    Toast.makeText(LoginActivty.this, "Đăng nhập thất bại.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LoginActivty.this, "Đăng nhập thành công.", Toast.LENGTH_SHORT).show();
                    if (checkBox.isChecked())
                    {
                        editor.putString("us",txtUserName.getText().toString());
                        editor.putString("pw",txtPassWord.getText().toString());

                    }
                    editor.putBoolean("luuthongtin",checkBox.isChecked());
                    editor.commit();
                }

            }
        });
        //xử lý nút đăng kí
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivty.this, RegisterActivity.class);
                activityResultLauncher.launch(intent);
            }
        });
        registerForContextMenu(txtUserName);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_bottom,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.mnuhome:
                Toast.makeText(this,"Ban bam vao menu home",Toast.LENGTH_LONG).show();
                break;
            case R.id.mnudashboard:
                Toast.makeText(this,"Ban bam vao menu dashboard",Toast.LENGTH_LONG).show();
                break;

        }
        return super.onContextItemSelected(item);
    }
}