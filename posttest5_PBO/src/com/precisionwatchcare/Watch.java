package com.precisionwatchcare;

public abstract class Watch {  // Changed to abstract
    private String brand;
    protected String model;
    final int year; 
    public String complication;
    private String type;

    public Watch(String brand, String model, int year, String complication, String type) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.complication = complication;
        this.type = type;
    }

    // Added abstract method
    public abstract void displaySpecialFeature();

    // Getter dan Setter 
    public final String getBrand() {  
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }   

    public String getComplication() {
        return complication;
    }

    @Override
    public String toString() {
        displaySpecialFeature();  
        if (type.equalsIgnoreCase("Analog")) {
            return "Analog Watch [Brand: " + brand + ", Model: " + model + 
                   ", Year: " + year + ", Complication: " + complication + "]";
        } else if (type.equalsIgnoreCase("Digital")) {
            return "Digital Watch [Brand: " + brand + ", Model: " + model + 
                   ", Year: " + year + ", Features: " + complication + "]";
        }
        return "Watch [Brand: " + brand + ", Model: " + model + 
               ", Year: " + year + ", Complication: " + complication + ", Type: " + type + "]";
    }
}