package com.example.foodmax.One_time_password;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.foodmax.Payments.Payment_method;
import com.example.foodmax.Restaurant_food_details.MenuActivity;
import com.example.foodmax.R;
import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity  {
    private Button move;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();


//when click getstarted button in front page it helps to move menu activity
        move=findViewById(R.id.Move);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this, MenuActivity.class);
                startActivity(intent);
                FirebaseAuth.getInstance().signOut();
                finish();
            }
        });
    }
}
