package com.example.projecthotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

import com.google.android.material.snackbar.Snackbar;

public class RatingActivity extends AppCompatActivity {

    RatingBar rBar;
    Button btnRatingSubmit;
    RelativeLayout layout;
    Snackbar sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        rBar = findViewById(R.id.rating);
        btnRatingSubmit = findViewById(R.id.btnRating);
        layout = findViewById(R.id.relative);

        btnRatingSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating;
                rating = rBar.getRating();
                sb = Snackbar.make(layout, String.valueOf(rating), Snackbar.LENGTH_LONG);
                sb.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sb.dismiss();
                    }
                }).show();
            }
        });
    }
}