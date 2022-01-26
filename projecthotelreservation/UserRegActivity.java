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

public class UserRegActivity extends AppCompatActivity {

    EditText edName, edPhn, edEmail, edPass;
    Button btnSignup;
    String name,phn,email,pass;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_reg);
        edName = findViewById(R.id.edName);
        edPhn = findViewById(R.id.edPhn);
        edEmail = findViewById(R.id.edEmail);
        edPass = findViewById(R.id.edPass);
        btnSignup = findViewById(R.id.btnSign);

        preferences = PreferenceManager.getDefaultSharedPreferences(UserRegActivity.this);
        editor = preferences.edit();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              name =   edName.getText().toString();
              phn = edPhn.getText().toString();
              email = edEmail.getText().toString();
              pass = edPass.getText().toString();
              registerProcess();
            }
        });
    }

    private void registerProcess() {

        StringRequest request = new StringRequest(Request.Method.POST, ConstantData.USER_REG_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("Inserted")){
                            Toast.makeText(UserRegActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();

                            editor.putString("User_Email", email);
                            editor.apply();
                            Intent in = new Intent(UserRegActivity.this,RoomViewActivity.class);
                            startActivity(in);
                            UserRegActivity.this.finish();


                        }else if(response.equalsIgnoreCase("exist")){
                            Toast.makeText(UserRegActivity.this, "Email or phone already found, try again", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(UserRegActivity.this, "Failed, try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UserRegActivity.this, "Network problem "+error, Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> mapData = new HashMap<>();
                mapData.put(ConstantData.U_NAME, name);
                mapData.put(ConstantData.U_EMAIL, email);
                mapData.put(ConstantData.U_PHONE, phn);
                mapData.put(ConstantData.U_PASS, pass);
                return mapData;
            }
        };


        RequestQueue queue = Volley.newRequestQueue(UserRegActivity.this);
        queue.add(request);

    }
}
