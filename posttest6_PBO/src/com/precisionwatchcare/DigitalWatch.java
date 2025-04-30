package com.precisionwatchcare;

public class DigitalWatch extends Watch {
    public DigitalWatch(String brand, String model, int year, String features) {
        super(brand, model, year, features, "Digital");
    }

    @Override
    public void displaySpecialFeature() {
        System.out.println("Special Feature: Electronic display with " + getComplication() + " features");
    }
}