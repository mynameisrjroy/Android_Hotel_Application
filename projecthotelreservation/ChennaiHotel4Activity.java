package com.example.projecthotelreservation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.projecthotelreservation.adapters.AdapterChe4;

public class ChennaiHotel4Activity extends AppCompatActivity {

    private RecyclerView rView;
    private LinearLayoutManager layoutManager;
    AdapterChe4 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chennai_hotel4);
        rView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        rView.setLayoutManager(layoutManager);

        adapter = new AdapterChe4(this);
        rView.setAdapter(adapter);
    }
}