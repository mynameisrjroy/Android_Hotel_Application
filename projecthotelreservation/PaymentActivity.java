package com.example.projecthotelreservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {


    EditText name, phone, email, checkin, checkout, cuisine, dish;
    TextView txtPrice;
    Button btnPay;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        name = findViewById(R.id.edName);
        phone = findViewById(R.id.edPhn);
        email = findViewById(R.id.edEmail);
        checkin = findViewById(R.id.edCheckin);
        checkout = findViewById(R.id.edCheckout);
        cuisine = findViewById(R.id.edCuisine);
        dish = findViewById(R.id.edDish);
        txtPrice = findViewById(R.id.txtPrice);
        btnPay = findViewById(R.id.btnPay);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.payment_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_exit:
                exitUser();
                break;
            case R.id.item_rate_us:
                startActivity(new Intent(PaymentActivity.this, RatingActivity.class));
                break;
            case R.id.item_home:
                startActivity(new Intent(PaymentActivity.this, RoomViewActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void exitUser() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(PaymentActivity.this);
        alertBuilder.create();
        alertBuilder.setCancelable(false);
        alertBuilder.setMessage("Do you really want to logout?");
        alertBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                editor.clear();
                editor.commit();
                startActivity(new Intent(PaymentActivity.this, MainActivity.class));
                PaymentActivity.this.finish();
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
}