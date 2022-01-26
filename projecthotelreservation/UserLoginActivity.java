package com.example.projecthotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

public class UserLoginActivity extends AppCompatActivity {

    private EditText edUser, edPass;
    private Button btnLogin;
    String email_user,pass_user;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        edUser = findViewById(R.id.edUser);
        edPass = findViewById(R.id.edPass);
        btnLogin = findViewById(R.id.btnLogin);

        preferences = PreferenceManager.getDefaultSharedPreferences(UserLoginActivity.this);
        editor = preferences.edit();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email_user = edUser.getText().toString().trim();
                pass_user = edPass.getText().toString().trim();
                if (!email_user.isEmpty()||!pass_user.isEmpty()){
                    Login(email_user, pass_user);
                }else{
                    edUser.setError("Please Insert Your Email or Phone Number");
                    edPass.setError("Please Insert Your Password");
                }
            }
        });
    }

    private void Login(final String email, final String pass) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, ConstantData.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       if (response.equalsIgnoreCase("Login Successful")){
                           Toast.makeText(UserLoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();

                           editor.putString("User_Email", email_user);
                           editor.apply();
                           Intent in = new Intent(UserLoginActivity.this, RoomViewActivity.class);
                           startActivity(in);
                           UserLoginActivity.this.finish();

                       }else{
                            Toast.makeText(UserLoginActivity.this, "Failed, try again", Toast.LENGTH_SHORT).show();
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
                mapData.put(ConstantData.U_EMAIL, email_user);
                mapData.put(ConstantData.U_PASS, pass_user);
                return mapData;
            }
        };

         RequestQueue queue = Volley.newRequestQueue(UserLoginActivity.this);
         queue.add(stringRequest);

    }
}
