// Rifki Abiyan
// 2309106030
// A2 23
package com.precisionwatchcare;

public class Service {
    private String serviceId;
    private String serviceType;
    private double cost;
    private String status; 
    private boolean useCourier; 

    public Service(String serviceId, String serviceType, double cost, boolean useCourier) {
        this.serviceId = serviceId;
        this.serviceType = serviceType;
        this.cost = cost;
        this.status = "Pending"; // Default
        this.useCourier = useCourier;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isUseCourier() {
        return useCourier;
    }

    public void setUseCourier(boolean useCourier) {
        this.useCourier = useCourier;
    }

    @Override
    public String toString() {
        return "Service [ID: " + serviceId + ", Type: " + serviceType + ", Cost: Rp" + cost + ", Status: " + status + ", Use Courier: " + useCourier + "]";
    }
}