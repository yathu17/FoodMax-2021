package com.example.foodmax.Restaurant_food_details;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.foodmax.One_time_password.Dashboard;
import com.example.foodmax.Payments.Payment_method;
import com.example.foodmax.R;


public class
MenuActivity<context> extends AppCompatActivity  {
    //inputing variable for two image button kfc resta and pizza rasta
    private Button kfc;
    private Button pizza;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        // nav bar color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_200)));
        //all are for two different resta to move it's food gridview
        Button kfc = findViewById(R.id.Kfc);
        Button pizza = findViewById(R.id.Pizza);

        kfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, com.example.foodmax.Restaurant_food_details.kfc.class);
                startActivity(intent);
            }
        });

        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, com.example.foodmax.Restaurant_food_details.pizza.class);
                startActivity(intent);
            }
        });
    }
}


