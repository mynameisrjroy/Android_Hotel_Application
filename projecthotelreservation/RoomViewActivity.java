package com.example.projecthotelreservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.projecthotelreservation.adapters.AdapterRecyclerItems;
import com.example.projecthotelreservation.adapters.AdapterRecyclerItems2;
import com.example.projecthotelreservation.adapters.AdapterRecyclerItems3;
import com.example.projecthotelreservation.adapters.AdapterRecyclerItems4;
import com.example.projecthotelreservation.adapters.AdapterRecyclerItems5;
import com.google.android.material.snackbar.Snackbar;

public class RoomViewActivity extends AppCompatActivity {

    Spinner spinner;
    private RecyclerView rView;
    private LinearLayoutManager layoutManager;
    AdapterRecyclerItems adapter;
    AdapterRecyclerItems2 adapter2;
    AdapterRecyclerItems3 adapter3;
    AdapterRecyclerItems4 adapter4;
    AdapterRecyclerItems5 adapter5;
    ArrayAdapter arrayAdapter;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    LinearLayout layout;
    private boolean backPressed = false;

    private String []arr = new String[] {"Select City", "Kolkata", "Mumbai", "Delhi", "Chennai", "Hyderabad"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_view);
        rView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        rView.setLayoutManager(layoutManager);
        spinner = findViewById(R.id.spinner);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();

        adapter = new AdapterRecyclerItems(this);
        adapter2 = new AdapterRecyclerItems2(this);
        adapter3 = new AdapterRecyclerItems3(this);
        adapter4 = new AdapterRecyclerItems4(this);
        adapter5= new AdapterRecyclerItems5(this);
//        rView.setAdapter(adapter);

        arrayAdapter = new ArrayAdapter(RoomViewActivity.this, R.layout.support_simple_spinner_dropdown_item, arr);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position>0 && position==1){
                    rView.setAdapter(adapter);
                }
                if (position>0 && position==2){
                    rView.setAdapter(adapter2);
                }
                if (position>0 && position==3){
                    rView.setAdapter(adapter3);
                }
                if (position>0 && position==4){
                    rView.setAdapter(adapter4);
                }
                if (position>0 && position==5){
                    rView.setAdapter(adapter5);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.roomview_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_exit:
                exitUser();
                break;
            case R.id.item_rate_us:
                startActivity(new Intent(RoomViewActivity.this, RatingActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void exitUser() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(RoomViewActivity.this);
        alertBuilder.create();
        alertBuilder.setCancelable(false);
        alertBuilder.setMessage("Do you really want to logout?");
        alertBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                editor.clear();
                editor.commit();

                startActivity(new Intent(RoomViewActivity.this, MainActivity.class));
                RoomViewActivity.this.finish();
            }
        });
        alertBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertBuilder.show();
    }

    @Override
    public void onBackPressed() {
        if (backPressed) {
            super.onBackPressed();
            return;
        }
        backPressed = true;
        Snackbar.make(layout, "Press again to exit", Snackbar.LENGTH_LONG).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                backPressed = false;
            }
        }, 3000);
    }
}