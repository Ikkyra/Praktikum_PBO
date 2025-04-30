package com.precisionwatchcare;

public class AnalogWatch extends Watch {
    public AnalogWatch(String brand, String model, int year, String complication) {
        super(brand, model, year, complication, "Analog");
    }

    @Override
    public void displaySpecialFeature() {
        System.out.println("Special Feature: Mechanical movement with " + getComplication() + " complication");
    }
}