package com.example.test;

import java.io.Serializable;

public class MainActivityPhoneModel implements Serializable {
    private String brand = "";
    private String model = "";
    private String price = "";
    private boolean navigateToNext = false;
    private boolean showError = false;

    // Геттери та сеттери
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public boolean isNavigateToNext() { return navigateToNext; }
    public void setNavigateToNext(boolean navigateToNext) { this.navigateToNext = navigateToNext; }

    public boolean isShowError() { return showError; }
    public void setShowError(boolean showError) { this.showError = showError; }
}