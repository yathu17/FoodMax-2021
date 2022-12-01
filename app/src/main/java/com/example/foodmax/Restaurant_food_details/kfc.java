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

public class kfc extends AppCompatActivity {
    GridView gridView;
    // set values for grid view content for kfc resta
    String[] foodlist =  {"Butter Masala-SF001", "Cheese Lovers-SF002", "Chicken Bacon-SF003",
            "Devilled Chicken-SF004", "Popcorn Veggie-SF005", "Sausagede Light-SF006", "Veggie With Paneer-SF007",
            "Veggie Supreme-SF008", "Chicken Biryani-SF009", "Chicken Kothu-SF010", "Chicken Noodles-SF011",
            "Dum Biryani-SF012", "Paratha-SF013", "Vegetable Noodles-SF014", "Veg Kothu-SF014"};


    String[] pricelist = {"650/=", "525/=", "700/=", "650/=", "650/=", "600/=","600/=", "500/=", "650/=", "750/=", "600/=", "950/=", "350/=", "400/=", "300/="};


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

//gridview assigning resturant kfc
        gridView = findViewById(R.id.grid_View);

        MainAdapter adapter = new MainAdapter(kfc.this, foodlist, pricelist, foodImg);
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