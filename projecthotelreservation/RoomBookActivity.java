package com.example.projecthotelreservation;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.projecthotelreservation.constant.ConstantData;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class RoomBookActivity extends AppCompatActivity {

    EditText edName, edPhn, edEmail, edRoomPrice, edRoomType;
    TextView edCheckin, edCheckout;
    Button btnbook;
    DatePickerDialog.OnDateSetListener mDateSetListener, mDateSetListener2;
    String name,phn,email,price,cidate,codate,room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_book);
        
        
        edName = findViewById(R.id.edName);
        edPhn  = findViewById(R.id.edPhn);
        edEmail = findViewById(R.id.edEmail);
        edRoomPrice = findViewById(R.id.edRoomPrice);
        edRoomType = findViewById(R.id.edRoomType);

        edCheckin = findViewById(R.id.txtCheckin);
        edCheckout = findViewById(R.id.txtCheckout);
        btnbook = findViewById(R.id.btnBook);

        price = getIntent().getStringExtra("price");
        edRoomPrice.setText(price);

        room = getIntent().getStringExtra("rtype");
        edRoomType.setText(room);

        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name =   edName.getText().toString();
                phn= edPhn.getText().toString();
                email = edEmail.getText().toString();
                price = edRoomPrice.getText().toString();
                cidate = edCheckin.getText().toString();
                codate = edCheckout.getText().toString();

                bookingProcess();
            }
        });
    }

    public void openDateCal(View view){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        final int day = cal.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(RoomBookActivity.this, android.R.style.Theme_Holo_Light_Dialog,
                (DatePickerDialog.OnDateSetListener) mDateSetListener, year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String udate = dayOfMonth + "/" + month + "/" + year;
                edCheckin.setText(udate);
            }
        };
    }

    public void openDateCal2(View view){
        Calendar cal2 = Calendar.getInstance();
        int year = cal2.get(Calendar.YEAR);
        int month = cal2.get(Calendar.MONTH);
        final int day = cal2.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog2 = new DatePickerDialog(RoomBookActivity.this, android.R.style.Theme_Holo_Light_Dialog,
                (DatePickerDialog.OnDateSetListener) mDateSetListener2, year, month, day);
        dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog2.show();

        mDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String udate2 = dayOfMonth + "/" + month + "/" + year;
                edCheckout.setText(udate2);
            }
        };
    }

    private void bookingProcess() {

        StringRequest request = new StringRequest(Request.Method.POST, ConstantData.ROOM_BOOK_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.equalsIgnoreCase("Inserted")) {
                            Toast.makeText(RoomBookActivity.this, "Room Booked successfully", Toast.LENGTH_SHORT).show();
                            Intent in = new Intent(RoomBookActivity.this,FoodActivity.class);
                            startActivity(in);
                        }
                        else{
                            Toast.makeText(RoomBookActivity.this, "Failed, try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RoomBookActivity.this, "Network problem "+error, Toast.LENGTH_SHORT).show();
                    }
                })
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> mapData = new HashMap<>();
                mapData.put(ConstantData.U_NAME, name);
                mapData.put(ConstantData.U_EMAIL, email);
                mapData.put(ConstantData.U_PHONE, phn);
                mapData.put(ConstantData.U_PRICE, price);
                mapData.put(ConstantData.U_CHECKIN, cidate);
                mapData.put(ConstantData.U_CHECKOUT, codate);
                return mapData;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(RoomBookActivity.this);
        queue.add(request);
    }
}
