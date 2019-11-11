package com.example.admin.myapplication.Activity;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.myapplication.R;

public class LoginActivity extends AppCompatActivity {
    TextView txtRegis,TxtEmailError,TxtPwdError;
    Button btnLogin;
    EditText edEmail,edPwd;
    ImageView ImageProfile;
    TextInputLayout TxtEmailEd,TxtPwdEd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        txtRegis=findViewById(R.id.txt_register);
        btnLogin=findViewById(R.id.BtnLogin);
        edEmail=findViewById(R.id.etLoginMobile_Email);
        edPwd=findViewById(R.id.etLoginPassword);
        TxtEmailEd=findViewById(R.id.input_LoginMobileEmail);
        TxtPwdEd=findViewById(R.id.input_LoginPassword);
        TxtEmailError=findViewById(R.id.TxtEmailError);
        TxtPwdError=findViewById(R.id.TxtPwdError);

        txtRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edEmail.getText().toString().trim().isEmpty()) {

//                    Snackbar snackbar = Snackbar.make(v, "Please fill out these fields",
//                            Snackbar.LENGTH_LONG);
//                    View snackbarView = snackbar.getView();
//                    snackbarView.setBackgroundColor(getResources().getColor(R.color.red_50));
//                    snackbar.show();
//                    TxtEmailError.setText("Username should not be empty");

                    Toast.makeText(getApplicationContext(),"email should not be empty",Toast.LENGTH_SHORT).show();

                } else {
                    //Here you can write the codes for checking username
                    Intent i=new Intent(LoginActivity.this, HomePage.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"Welcome To Home Page",Toast.LENGTH_SHORT).show();
                }
                if (edPwd.getText().toString().trim().isEmpty()) {
//                    Snackbar snackbar = Snackbar.make(v, "Please fill out these fields",
//                            Snackbar.LENGTH_LONG);
//                    View snackbarView = snackbar.getView();
//                    snackbarView.setBackgroundColor(getResources().getColor(R.color.red_50));
//                    snackbar.show();
//                    TxtPwdError.setError("Password should not be empty");
                    Toast.makeText(getApplicationContext(),"Password should not be empty", Toast.LENGTH_SHORT).show();
                } else {
                    //Here you can write the codes for checking password
                    Intent i=new Intent(LoginActivity.this, HomePage.class);
                    startActivity(i);
                }

//                if (rememberMe.isChecked()) {
//                    //Here you can write the codes if box is checked
//                } else {
//                    //Here you can write the codes if box is not checked
//                }




            }
        });
    }
}
