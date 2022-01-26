package com.example.projecthotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class UserDataActivity extends AppCompatActivity {

    Button btnFetch;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        btnFetch = findViewById(R.id.btnFetch);
        listView = findViewById(R.id.listView);
    }
}