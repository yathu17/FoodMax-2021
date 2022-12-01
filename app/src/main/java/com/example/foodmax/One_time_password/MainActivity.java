package com.example.foodmax.One_time_password;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.foodmax.R;
import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity {
    CountryCodePicker ccp;
    EditText getphonenum;
    Button getotp1;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //for nav color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_200)));
    }
    public void process(View view)
    {

        getphonenum = (EditText) findViewById(R.id.getphonenum);
        ccp = (CountryCodePicker) findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(getphonenum);
        getotp1 = (Button) findViewById(R.id.getotp1);




        getotp1.setOnClickListener(new View.OnClickListener() {
            private MainActivity mainActivity;

            @Override
            public void onClick(View view) {
                ongetotp1ButtonClick(mainActivity);


            }
        });

    }


    private void ongetotp1ButtonClick(MainActivity mainActivity) {
        if (TextUtils.isEmpty(getphonenum.getText().toString())){
            getphonenum.setError("Please enter your PHONENUMBER");
        }

        Intent intent = new Intent(MainActivity.this, Manageotp.class);
        intent.putExtra("mobile", ccp.getFullNumberWithPlus().replace(" ", ""));
        startActivity(intent);

    }
}
