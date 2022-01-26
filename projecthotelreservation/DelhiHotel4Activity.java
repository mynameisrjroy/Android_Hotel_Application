package com.example.projecthotelreservation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projecthotelreservation.adapters.AdapterDel4;

public class DelhiHotel4Activity extends AppCompatActivity {

    private RecyclerView rView;
    private LinearLayoutManager layoutManager;
    AdapterDel4 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delhi_hotel4);
        rView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        rView.setLayoutManager(layoutManager);

        adapter = new AdapterDel4(this);
        rView.setAdapter(adapter);
    }
}