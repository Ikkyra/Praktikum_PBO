// Rifki Abiyan
// 2309106030
// A2 23
public class Watch {
    private String brand;
    private String model;
    private int year;
    private String complication; 
    private String type; 

    public Watch(String brand, String model, int year, String complication, String type) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.complication = complication;
        this.type = type;
    }

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getComplication() {
        return complication;
    }

    public void setComplication(String complication) {
        this.complication = complication;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Watch [Brand: " + brand + ", Model: " + model + ", Year: " + year + ", Complication: " + complication + ", Type: " + type + "]";
    }
}