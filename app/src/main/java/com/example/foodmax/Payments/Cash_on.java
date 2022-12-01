package com.example.foodmax.Payments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.foodmax.R;
import com.example.foodmax.Restaurant_food_details.MenuActivity;

public class Cash_on extends AppCompatActivity {
    Button Book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_on);
        getSupportActionBar().hide();

        Book=findViewById(R.id.order);
        Book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Cash_on.this, MenuActivity.class);
                Toast.makeText(getApplicationContext(), "Order Confirmed", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}