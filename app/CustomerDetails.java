package com.example.foodmax;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class CustomerDetails extends AppCompatActivity {

    //input variables  for gethering item customer information from customer details and moving button-when click button it move next page
    private Button btn;
    private EditText inputName, inputAddress, inputCity, inputState, inputZip, inputCardNumber, inputCardExpiry,inputCardExpiryYY,
            inputCardPin, inputCustomername, telephonenumber;
    private TextView buttonPlaceYourOrder,CardExpirydate,textViewslaz, AddressDetails, tvCardDetails;
    private SwitchCompat switchDelivery;
    private boolean isDeliveryOn;
    private CustomerDetails ButtonPlaceYourOrderAdapter;
    private Object Editable;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);


        // Nav bar color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_200)));


// gethering customer information grom customer detail.xml
        inputCustomername = findViewById(R.id.inputCustomerName);
        telephonenumber = findViewById(R.id.telephonenumber);
        inputName = findViewById(R.id.inputName);
        inputCardNumber = findViewById(R.id.inputCardNumber);
        inputCardExpiry = findViewById(R.id.inputCardExpiry);
        inputCardPin = findViewById(R.id.inputCardPin);
        //for buttons
        buttonPlaceYourOrder = findViewById(R.id.buttonPlaceYourOrder);
        switchDelivery = findViewById(R.id.switchDelivery);
        //gone list
        inputAddress = findViewById(R.id.inputAddress);
        inputCity = findViewById(R.id.inputCity);
        inputState = findViewById(R.id.inputState);
        inputZip = findViewById(R.id.inputZip);
        textViewslaz=findViewById(R.id.textViewslaz);
        CardExpirydate=findViewById(R.id.CardExpirydate);
        inputCardExpiryYY=findViewById(R.id.inputCardExpiryYY);
        AddressDetails=findViewById(R.id.AddressDetails);
        tvCardDetails=findViewById(R.id.tvCardDetails);

//when customer click place your order button it moves to last page
        buttonPlaceYourOrder.setOnClickListener(new View.OnClickListener() {
            private CustomerDetails CustomerDetails;

            @Override
            public void onClick(View v) {
                onbuttonPlaceYourOrderButtonClick(CustomerDetails);

            }
        });

// this is for switch button view because of when customer click it it will show cash on deliver option

        switchDelivery.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    telephonenumber.setVisibility(View.VISIBLE);
                    inputCustomername.setVisibility(View.VISIBLE);
                    inputAddress.setVisibility(View.VISIBLE);
                    inputCity.setVisibility(View.VISIBLE);
                    inputState.setVisibility(View.VISIBLE);
                    inputZip.setVisibility(View.VISIBLE);
                    inputCardNumber.setVisibility(View.GONE);
                    inputName.setVisibility(View.GONE);
                    inputCardExpiry.setVisibility(View.GONE);
                    inputCardPin.setVisibility(View.GONE);
                    textViewslaz.setVisibility(View.GONE);
                    CardExpirydate.setVisibility(View.GONE);
                    inputCardExpiryYY.setVisibility(View.GONE);
                    tvCardDetails.setVisibility(View.GONE);
                    AddressDetails.setVisibility(View.VISIBLE);
                    isDeliveryOn = true;

                } else {
                    telephonenumber.setVisibility(View.VISIBLE);
                    inputCustomername.setVisibility(View.VISIBLE);
                    inputAddress.setVisibility(View.VISIBLE);
                    inputCity.setVisibility(View.VISIBLE);
                    inputState.setVisibility(View.VISIBLE);
                    inputZip.setVisibility(View.VISIBLE);
                    inputCardNumber.setVisibility(View.VISIBLE);
                    inputName.setVisibility(View.VISIBLE);
                    inputCardExpiry.setVisibility(View.VISIBLE);
                    inputCardPin.setVisibility(View.VISIBLE);
                    textViewslaz.setVisibility(View.VISIBLE);
                    CardExpirydate.setVisibility(View.VISIBLE);
                    inputCardExpiryYY.setVisibility(View.VISIBLE);
                    AddressDetails.setVisibility(View.VISIBLE);
                    tvCardDetails.setVisibility(View.VISIBLE);
                    isDeliveryOn = false;

                }
            }
        });





    }


//this for when customer press the back button on default navigation pane in mobile it will reset these textareas automatically

    // this is for customer details form if empty it shows error msg using if else statement
    private void onbuttonPlaceYourOrderButtonClick(CustomerDetails customerDetails) {
        if (TextUtils.isEmpty(inputCustomername.getText().toString())) {
            inputCustomername.setError("Please enter your name ");
            return;
        } else if (TextUtils.isEmpty(telephonenumber.getText().toString())) {
            telephonenumber.setError("Please enter your phone number ");
            return;
        }else if(TextUtils.isEmpty(inputName.getText().toString())){
            inputName.setError("Please enter name ");
            return;
        } else if( TextUtils.isEmpty(inputAddress.getText().toString())) {
            inputAddress.setError("Please enter address ");
            return;
        }else if(TextUtils.isEmpty(inputCity.getText().toString())) {
            inputCity.setError("Please enter city ");
            return;
        }else if( TextUtils.isEmpty(inputState.getText().toString())) {
            inputState.setError("Please enter state ");
        }else if(TextUtils.isEmpty(inputZip.getText().toString())){
            inputZip.setError("please enter your state");
            return;
        }else if( TextUtils.isEmpty(inputCardNumber.getText().toString())) {
            inputCardNumber.setError("Please enter card number ");
            return;
        }else if( TextUtils.isEmpty(inputCardExpiry.getText().toString())) {
            inputCardExpiry.setError("Please enter card expiry ");
            return;
        }else if( TextUtils.isEmpty(inputCardPin.getText().toString())) {
            inputCardPin.setError("Please enter card pin/cvv ");
            return;
        }
//I put this part off place your order button intent for (when customer have not fill any single form form the entire form the activity doesn't move for next activity
        Intent intent = new Intent(CustomerDetails.this, Appmessage.class);
        startActivity(intent);


        //when customer click on place your b button succeed automatically visible in appmessage activity for a 2 sec
        Toast.makeText(getApplicationContext(), "Your Order Placed Successfully", Toast.LENGTH_SHORT).show();
    }









}





