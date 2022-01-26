package com.example.projecthotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AdminRegActivity extends AppCompatActivity {

    EditText edName, edPhn, edAdd, edEmail, edPass;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_reg);
        edName = findViewById(R.id.edName);
        edPhn = findViewById(R.id.edPhn);
        edAdd = findViewById(R.id.edAdd);
        edEmail = findViewById(R.id.edEmail);
        edPass = findViewById(R.id.edPass);
        btnSignUp = findViewById(R.id.btnSign);
    }
}
