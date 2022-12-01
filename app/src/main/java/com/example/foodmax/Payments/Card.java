

package com.example.foodmax.Payments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodmax.CustomerDetails;
import com.example.foodmax.R;
import com.example.foodmax.Restaurant_food_details.MenuActivity;

public class Card extends AppCompatActivity {
    EditText name, cardnumber, cardexpirymonth, cardexpiryyear, cardpin, phoneumber, otp;
    Button orderbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        getSupportActionBar().hide();

        name=findViewById(R.id.inputName);
        cardnumber=findViewById(R.id.inputCardNumber);
        cardexpirymonth=findViewById(R.id.inputCardExpiry);
        cardexpiryyear=findViewById(R.id.inputCardExpiryYY);
        cardpin=findViewById(R.id.inputCardPin);
        phoneumber=findViewById(R.id.phonenumber);
        otp=findViewById(R.id.otp);
        orderbtn=findViewById(R.id.BTOrder);

        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(name.getText().toString())){
                    name.setError("Please Enter Name on card");
                    return;
                }else if(TextUtils.isEmpty(cardnumber.getText().toString())){
                    cardnumber.setError("Enter Card number");
                    return;
                }else if (phoneumber.length() < 16) {
                    phoneumber.setError("Please enter valid Card number");
                    return;
                }else if(TextUtils.isEmpty(cardexpirymonth.getText().toString())) {
                    cardexpirymonth.setError("Enter Card number");
                    return;
                }else if(TextUtils.isEmpty(cardexpiryyear.getText().toString())){
                    cardexpiryyear.setError("Enter Card number");
                    return;
                }else if(TextUtils.isEmpty(cardpin.getText().toString())){
                    cardpin.setError("Enter Card number");
                    return;
                }else if (cardpin.length() < 3) {
                    phoneumber.setError("Please Enter valid CVC number");
                    return;
                }else if(TextUtils.isEmpty(phoneumber.getText().toString())){
                    phoneumber.setError("Enter Card number");
                    return;
                }else if (phoneumber.length() < 10) {
                    phoneumber.setError("Please Enter valid phone number");
                    return;
                }

                Toast.makeText(getApplicationContext(),"Payment succesfull", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Card.this, MenuActivity.class);
                startActivity(intent);

            }
        });

    }
}