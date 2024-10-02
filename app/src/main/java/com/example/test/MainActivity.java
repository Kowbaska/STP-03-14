package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import com.example.test.databinding.ActivityMainBinding;
import com.example.test.MainActivityViewModel;
import com.example.test.MainActivityPhoneModel;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Ініціалізація DataBinding
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new MainActivityViewModel();
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        // Підписка на зміни стану
        viewModel.phoneModel.observe(this, new Observer<MainActivityPhoneModel>() {
            @Override
            public void onChanged(MainActivityPhoneModel phoneModel) {
                if (phoneModel.isShowError()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    phoneModel.setShowError(false);  // Очищаємо стан помилки
                }
                if (phoneModel.isNavigateToNext()) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("phoneModel", phoneModel);
                    startActivity(intent);
                    phoneModel.setNavigateToNext(false);  // Очищаємо стан переходу
                }
            }
        });
    }
}