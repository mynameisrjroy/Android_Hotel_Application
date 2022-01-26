package com.example.projecthotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.widget.Spinner;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences preferences;
    private String currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        currentUser = preferences.getString("User_Email", "");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentUser.isEmpty()){
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    SplashActivity.this.finish();
                }
                else{
                    startActivity(new Intent(SplashActivity.this, RoomViewActivity.class));
                    SplashActivity.this.finish();
                }
            }
        }, 3000);
    }
}
