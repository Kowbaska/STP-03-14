package com.example.test;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.test.MainActivityPhoneModel;

public class MainActivityViewModel extends ViewModel {
    public MutableLiveData<MainActivityPhoneModel> phoneModel = new MutableLiveData<>(new MainActivityPhoneModel());

    // Обробник натискання кнопки
    public void onNextButtonClicked(View v) {
        MainActivityPhoneModel currentModel = phoneModel.getValue();
        if (currentModel != null) {
            if (currentModel.getBrand().isEmpty() || currentModel.getModel().isEmpty() || currentModel.getPrice().isEmpty()) {
                currentModel.setShowError(true);  // Вивести повідомлення про помилку
            } else {
                currentModel.setNavigateToNext(true);  // Переходити до наступної активності
            }
            phoneModel.setValue(currentModel);
        }
    }
}