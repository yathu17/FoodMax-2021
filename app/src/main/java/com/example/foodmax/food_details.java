package com.example.foodmax;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class food_details extends AppCompatActivity {
    //for single pic and it's food name t show on fooddetails activity
    public Button CheckoutBtn;
    TextView name,sumprice,price;
    ImageView image;
    Button calculate;
    private food_details checkoutbtnAdapter;
    private int dchargerate=200;
    private EditText foodcount;
    int total = 0;
    int subtotal = 0;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        //for nav color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_200)));


//for grid view & and show image price food name in grid view when click gridview it show every foods detail unique
        name = (TextView) findViewById(R.id.textView5);
        image = findViewById(R.id.showtext);
        price = (TextView) findViewById(R.id.price);
        sumprice=(TextView) findViewById(R.id.sumprice);
        foodcount=(EditText)findViewById(R.id.foodcount) ;
        calculate=findViewById(R.id.calculate);


        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        image.setImageResource(intent.getIntExtra("image", 0));
        price.setText(intent.getStringExtra("price"));



//calculate the bill amount
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(foodcount.getText().toString())) {
                    foodcount.setError("Please enter the count ");
                    return;}
                int Foodcount = Integer.parseInt(foodcount.getText().toString());
                String priceWithText = price.getText().toString();
                String priceOnly = priceWithText.replaceAll("[^0-9]", "");
                int Price = Integer.parseInt(priceOnly);
                subtotal = Price * Foodcount;
                total= subtotal+dchargerate;
                sumprice.setText(String.valueOf(total +" Rs"));

            }

        });
        //checkout button foood single view checkout button when click this button it's move to customer detail gethering activity
        CheckoutBtn = findViewById(R.id.checkoutbtn);
        CheckoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(foodcount.getText().toString())) {
                    foodcount.setError("Please enter the count ");
                    return;}
                if (TextUtils.isEmpty(sumprice.getText().toString())){
                    calculate.setError("Please click calculate button");
                    Toast.makeText(getApplicationContext(),"Please calculate bill",Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getApplicationContext(),"Basketed",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(food_details.this, CustomerDetails.class);
                String value = name.getText().toString();
                intent.putExtra("txt",value);
                String val = sumprice.getText().toString();
                intent.putExtra("ftxt",val);
                startActivity(intent);
            }
        });
    }
}
