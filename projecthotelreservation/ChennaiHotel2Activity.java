package com.example.projecthotelreservation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.print.PrinterId;

import com.example.projecthotelreservation.adapters.AdapterChe2;

public class ChennaiHotel2Activity extends AppCompatActivity {

    private RecyclerView rView;
    private LinearLayoutManager layoutManager;
    AdapterChe2 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chennai_hotel2);
        rView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        rView.setLayoutManager(layoutManager);

        adapter = new AdapterChe2(this);
        rView.setAdapter(adapter);
    }
}