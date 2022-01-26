package com.example.projecthotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FoodActivity extends AppCompatActivity {

    Spinner spinner, spinner2;
    TextView showText, showText2, showText3;
    EditText edCuisine, edDish;
    Button btn;

    private String []arr = new String[] {"Select Cuisine", "Indian", "Italian", };
    private String []IndianArr = new String[] {"Select Food", "Biryani", "Dosa", "Chole Bature", "Gujrati Thali"};
    private String []ItalianArr = new String[] {"Select Food", "Pizza", "Calzone", "Acquacotta", "Cannoli"};

    ArrayAdapter adapter, adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        spinner = findViewById(R.id.itemSpin);
        edCuisine = findViewById(R.id.edCuisine);

        spinner2 = findViewById(R.id.itemSpin2);
        edDish = findViewById(R.id.edDish);

        showText3 = findViewById(R.id.itemTxt3);
        btn = findViewById(R.id.btn);


        adapter = new ArrayAdapter(FoodActivity.this, R.layout.support_simple_spinner_dropdown_item, arr);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    adapter2 = new ArrayAdapter(FoodActivity.this, R.layout.support_simple_spinner_dropdown_item, IndianArr);
                    spinner2.setVisibility(View.VISIBLE);
                    edDish.setVisibility(View.VISIBLE);
                    edCuisine.setText(spinner.getSelectedItem().toString());
                }
                if (position == 2) {
                    adapter2 = new ArrayAdapter(FoodActivity.this, R.layout.support_simple_spinner_dropdown_item, ItalianArr);
                    spinner2.setVisibility(View.VISIBLE);
                    edDish.setVisibility(View.VISIBLE);
                    edCuisine.setText(spinner.getSelectedItem().toString());
                }
                spinner2.setAdapter(adapter2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Keep it as empty
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0) {
                    String cuisine = spinner.getSelectedItem().toString();
                    String food = spinner2.getSelectedItem().toString();
                    Toast.makeText(FoodActivity.this, cuisine + " : " + food, Toast.LENGTH_LONG)
                            .show();

                    edDish.setText(spinner2.getSelectedItem().toString());
                    showText3.setText(cuisine+ " : " +spinner2.getSelectedItem().toString());
                    //showText2.setText(cuisine+ " : " +parent.getSelectedItem().toString());  | Can use parent instead of spinner2 as well since spinner2 is the parent.
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Keep it as empty
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(FoodActivity.this, PaymentActivity.class);
                startActivity(in);
            }
        });
    }
}