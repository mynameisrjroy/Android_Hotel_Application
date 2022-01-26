package com.example.projecthotelreservation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projecthotelreservation.adapters.AdapterKol1;
import com.example.projecthotelreservation.adapters.AdapterKol3;

public class KolkataHotel3Activity extends AppCompatActivity {

    private RecyclerView rView;
    private LinearLayoutManager layoutManager;
    AdapterKol3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolkata_hotel3);
        rView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        rView.setLayoutManager(layoutManager);

        adapter = new AdapterKol3(this);
        rView.setAdapter(adapter);
    }
}