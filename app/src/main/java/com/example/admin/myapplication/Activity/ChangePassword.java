package com.example.admin.myapplication.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.myapplication.MainActivity;
import com.example.admin.myapplication.R;

public class ChangePassword extends AppCompatActivity {
    EditText NPwd,ComPwd;
    Button ChgPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        NPwd=findViewById(R.id.NewPwd);
        ComPwd=findViewById(R.id.ConPwd);
        ChgPwd=findViewById(R.id.ChngPwd);


        ChgPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newPassword=NPwd.getText().toString();
                String conPassword=ComPwd.getText().toString();
                if(newPassword.equals(conPassword)){
                    Intent i=new Intent(ChangePassword.this, LoginActivity.class);
                    startActivity(i);
                }else if(ComPwd.equals(null) && ChgPwd.equals(null)){
                    Toast.makeText(getApplicationContext(),"Please Write Same Passwords",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(ChangePassword.this, ChangePassword.class);
                    startActivity(i);
                }else
                {
                    Toast.makeText(getApplicationContext(),"Please Write Same Passwords",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(ChangePassword.this, ChangePassword.class);
                    startActivity(i);
                }
            }
        });
    }
}
