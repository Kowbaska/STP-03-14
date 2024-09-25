package com.example.test;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private TextView brandTextView, modelTextView, priceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        brandTextView = findViewById(R.id.brandTextView);
        modelTextView = findViewById(R.id.modelTextView);
        priceTextView = findViewById(R.id.priceTextView);

        Intent intent = getIntent();
        Phone phone = (Phone) intent.getSerializableExtra("phone");

        if (phone != null) {
            brandTextView.setText("Brand: " + phone.getBrand());
            modelTextView.setText("Model: " + phone.getModel());
            priceTextView.setText("Price: $" + phone.getPrice());
        }
    }
}