package com.example.foodmax.Restaurant_food_details;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.foodmax.MainAdapter;
import com.example.foodmax.R;
import com.example.foodmax.food_details;

public class pizza extends AppCompatActivity {
    GridView gridView;
    // set values for grid view content for pizza resta
    String[] foodlist = {"Butter Masala-JF001", "Cheese Lovers-JF002", "Chicken Bacon-JF003",
            "Devilled Chicken-JF004", "Popcorn Veggie-JF005", "Sausagede Light-JF006", "Veggie With Paneer-JF007",
            "Veggie Supreme-JF008", "Chicken Biryani-JF009", "Chicken Kothu-JF010", "Chicken Noodles-JF011",
            "Dum Biryani-JF012", "Paratha-JF013", "Vegetable Noodles-JF014", "Veg Kothu-JF014"};

    String[] pricelist = {"650/=", "500/=", "675/=", "700/=", "600/=", "650/=", "550/=", "500/=", "650/=", "700/=", "600/=", "1000/=", "350/=", "400/=", "250/="};


    int[] foodImg = {R.drawable.butterchickenmasala, R.drawable.cheeselovers, R.drawable.chickenbacon, R.drawable.devilledchicken,
            R.drawable.popcornveggie, R.drawable.sausagedelight, R.drawable.spicyveggiewithpaneer, R.drawable.veggiesupreme,
            R.drawable.chickenbiryani, R.drawable.chickenkothu, R.drawable.chickennoodles, R.drawable.dumbiryani,
            R.drawable.paratha, R.drawable.vegetablenoodles, R.drawable.vegkothu};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);
        //nav bar color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_200)));
//gridview assigning pizza view
        gridView = findViewById(R.id.grid_View);


        MainAdapter adapter = new MainAdapter(pizza.this, foodlist, pricelist, foodImg);
        gridView.setAdapter(adapter);



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
//when click gridview items automatically show item name for a 2 sec in next activity
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "You Clicked " + foodlist[+
                        position], Toast.LENGTH_SHORT).show();
//show items with it's details  in food detail activity
                Intent intent=new Intent(getApplicationContext(), food_details.class);
                intent.putExtra("name",foodlist[position]);
                intent.putExtra("image",foodImg[position]);
                intent.putExtra("price",pricelist[position]);
                startActivity(intent
                );

            }

        });

    }
}