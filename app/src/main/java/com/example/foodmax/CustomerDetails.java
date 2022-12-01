
package com.example.foodmax;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.foodmax.Payments.Card;
import com.example.foodmax.Payments.Cash_on;
import com.example.foodmax.Payments.Payment_method;
import com.example.foodmax.Payments.dataholder;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class CustomerDetails extends AppCompatActivity {
    //input variables  for gethering item customer information from customer details and moving button-when click button it move next page
    TextView Foodcode, Foodprice,foodcode, bill;
    EditText name, phone, location, address, city, paymentmethod;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_200)));

        Foodcode = findViewById(R.id.Foodcode);
        Foodprice = findViewById(R.id.Foodprice);
        btn = findViewById(R.id.buttonPlaceYourOrder);
        name=(EditText)findViewById(R.id.inputCustomerName);
        phone=(EditText)findViewById(R.id.telephonenumber);
        location=(EditText)findViewById(R.id.location);
        address=(EditText)findViewById(R.id.inputAddress);
        city=(EditText)findViewById(R.id.inputCity);
        foodcode=(TextView) findViewById(R.id.Foodcode);
        bill=(TextView) findViewById(R.id.Foodprice);

//firebase initializing
        String Name=name.getText().toString().trim();
        String Phone=phone.getText().toString().trim();
        String Location=location.getText().toString().trim();
        String Address=address.getText().toString().trim();
        String City=city.getText().toString().trim();
        String FoodCode=foodcode.getText().toString().trim();
        String Bill=bill.getText().toString().trim();


//View fooddetails data in customerdetails
        String value = getIntent().getStringExtra("txt");
        Foodcode.setText(value);

        String val = getIntent().getStringExtra("ftxt");
        Foodprice.setText(val);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(location.getText().toString())) {
                    location.setError("Please paste your location link");
                    return;
                } else if (location.length() < 15) {
                    location.setError("Link does not match! Please enter the correct link");
                    return;
                } else if (TextUtils.isEmpty(name.getText().toString())) {
                    name.setError("Please enter your name ");
                    return;
                } else if (TextUtils.isEmpty(phone.getText().toString())) {
                    phone.setError("Please enter your phone number ");
                    return;
                } else if (phone.length() < 10) {
                    phone.setError("Please Enter valid phone number");
                    return;
                } else if (TextUtils.isEmpty(address.getText().toString())) {
                    address.setError("Please enter address ");
                    return;
                } else if (TextUtils.isEmpty(city.getText().toString())) {
                    city.setError("Please enter city ");
                    return;
                }

//firebase declaring
                dataholder obj=new dataholder(Name,Phone,Location,Address,City,FoodCode,Bill);

                FirebaseDatabase db=FirebaseDatabase.getInstance();
                DatabaseReference node=db.getReference("Orders");

                node.child(Phone).setValue(obj);

                name.setText("");
                phone.setText("");
                location.setText("");
                address.setText("");
                city.setText("");

                Toast.makeText(getApplicationContext(),"Order saved",Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(CustomerDetails.this, Payment_method.class);
                startActivity(intent);
            }
        });
    }


    public void location(View view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                Toast.makeText(getApplicationContext(), "Finding your location.....", Toast.LENGTH_SHORT).show();
                startActivity(mapIntent);
            }
        }, 1000);
    }
}



