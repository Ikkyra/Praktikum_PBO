package com.precisionwatchcare;

public class Watch {
    private String brand; // private
    protected String model; // protected
    int year; // default
    public String complication; // public
    private String type; // private

    public Watch(String brand, String model, int year, String complication, String type) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.complication = complication;
        this.type = type;
    }

    // Getter dan Setter untuk private dan protected
    public String getBrand() {
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

    @Override
    public String toString() {
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