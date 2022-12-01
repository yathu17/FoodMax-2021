package com.example.foodmax.Payments;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.foodmax.R;
import com.example.foodmax.Restaurant_food_details.MenuActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Payment_method extends AppCompatActivity {
    TextView meth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_200)));

        RadioGroup radioGroup = findViewById(R.id.Radio_group);
        RadioButton cashon = findViewById(R.id.radioButton);
        RadioButton card = findViewById(R.id.radioButton2);
        final ConstraintLayout constraintLayout = findViewById(R.id.radio);
        meth=(TextView)findViewById(R.id.meth);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        Intent intent= new Intent(Payment_method.this,Card.class);
                        startActivity(intent);
                        meth.setText("Card payment method");
                        Toast.makeText(getApplicationContext(),"Card payment method selected",Toast.LENGTH_SHORT).show();
                        break;


                    case R.id.radioButton2:
                        Intent intent2= new Intent(Payment_method.this,Cash_on.class);
                        startActivity(intent2);
                        meth.setText("Cash On Delivery Method");
                        Toast.makeText(getApplicationContext(),"Cash On Delivery",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}



