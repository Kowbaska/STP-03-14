package com.example.test;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.MainActivityPhoneModel;

public class MainActivity2 extends AppCompatActivity {

    private TextView brandTextView, modelTextView, priceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        brandTextView = findViewById(R.id.brandTextView);
        modelTextView = findViewById(R.id.modelTextView);
        priceTextView = findViewById(R.id.priceTextView);

        // Отримання даних з Intent
        MainActivityPhoneModel phoneModel = (MainActivityPhoneModel) getIntent().getSerializableExtra("phoneModel");

        if (phoneModel != null) {
            brandTextView.setText("Brand: " + phoneModel.getBrand());
            modelTextView.setText("Model: " + phoneModel.getModel());
            priceTextView.setText("Price: $" + phoneModel.getPrice());
        }
    }
}