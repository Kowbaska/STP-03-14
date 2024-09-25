package com.example.test;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText brandEditText, modelEditText, priceEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brandEditText = findViewById(R.id.brandEditText);
        modelEditText = findViewById(R.id.modelEditText);
        priceEditText = findViewById(R.id.priceEditText);
        Button submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String brand = brandEditText.getText().toString().trim();
                String model = modelEditText.getText().toString().trim();
                String priceStr = priceEditText.getText().toString().trim();

                if (brand.isEmpty() || model.isEmpty() || priceStr.isEmpty()) {
                    Toast toast = Toast.makeText(MainActivity.this, R.string.toast_fill_all_fields, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0); // Розташування по центру
                    toast.show();
                    return;
                }

                int price = Integer.parseInt(priceStr);

                Phone phone = new Phone(brand, model, price);

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("phone", phone);
                startActivity(intent);
            }
        });
    }
}