package com.example.projecthotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.projecthotelreservation.constant.ConstantData;

import java.util.HashMap;
import java.util.Map;


public class AdminLoginActivity extends AppCompatActivity {

    private EditText edUser, edPass;
    private Button btnLogin;
    String email,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        edUser = findViewById(R.id.edUser);
        edPass = findViewById(R.id.edPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = edUser.getText().toString().trim();
                pass = edPass.getText().toString().trim();
                if (!email.isEmpty()||!pass.isEmpty()){
                    Login(email, pass);
                }else{
                    edUser.setError("Please Insert Your Email or Phone Number");
                    edPass.setError("Please Insert Your Password");
                }
            }
        });
    }

    private void Login(final String email, final String pass) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, ConstantData.ADMIN_LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("Login Successful")){
                            Toast.makeText(AdminLoginActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            Intent in = new Intent(AdminLoginActivity.this, AdminRoomActivity.class);
                            startActivity(in);
                        }else{
                            Toast.makeText(AdminLoginActivity.this, "Failed, try again", Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> mapData = new HashMap<>();
                mapData.put(ConstantData.U_EMAIL, email);
                mapData.put(ConstantData.U_PASS, pass);
                return super.getParams();
            }
        };

        RequestQueue queue = Volley.newRequestQueue(AdminLoginActivity.this);
        queue.add(stringRequest);

    }
}
