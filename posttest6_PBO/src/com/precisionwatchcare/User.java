// Rifki Abiyan
// 2309106030
// A2 23
package com.precisionwatchcare;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private static ArrayList<Watch> watchList = new ArrayList<>();
    private static ArrayList<Service> serviceList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void userMenu() {
        while (true) {
            System.out.println("\n=== User Menu ===");
            System.out.println("1. Add Watch");
            System.out.println("2. View My Watches");
            System.out.println("3. Request Service");
            System.out.println("4. Logout");
            System.out.println("\n=================");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addWatch();
                    break;
                case 2:
                    viewMyWatches();
                    break;
                case 3:
                    requestService();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method Add Watch
    private static void addWatch() {
        try {
            System.out.print("Enter brand: ");
            String brand = scanner.nextLine();
            if (brand.isEmpty()) {
                throw new IllegalArgumentException("Brand cannot be empty");
            }
    
            System.out.print("Enter model: ");
            String model = scanner.nextLine();
            if (model.isEmpty()) {
                throw new IllegalArgumentException("Model cannot be empty");
            }
    
            System.out.print("Enter year: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            if (year < 1900 || year > java.time.Year.now().getValue()) {
                throw new IllegalArgumentException("Invalid year");
            }
    
            System.out.print("Enter complication/features: ");
            String complication = scanner.nextLine();
            System.out.print("Enter type (Analog/Digital): ");
            String type = scanner.nextLine();
    
            Watch watch;
            if (type.equalsIgnoreCase("Analog")) {
                watch = new AnalogWatch(brand, model, year, complication);
            } else if (type.equalsIgnoreCase("Digital")) {
                watch = new DigitalWatch(brand, model, year, complication);
            } else {
                System.out.println("Invalid type. Defaulting to Analog.");
                watch = new AnalogWatch(brand, model, year, complication);
            }
    
            watchList.add(watch);
            watch.displaySpecialFeature();
            watch.displayWatchDetails(); // Using interface method
            watch.performMaintenance(); // Using interface method
            System.out.println("Total watches in system: " + Watch.getTotalWatches()); // Using static method
            System.out.println("Watch added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    // Method View Watch
    private static void viewMyWatches() {
        if (watchList.isEmpty()) {
            System.out.println("No watches available.");
        } else {
            for (Watch watch : watchList) {
                System.out.println(watch);
            }
        }
    }

    private static void requestService() {
        viewMyWatches();
        if (!watchList.isEmpty()) {
            System.out.print("Enter the index of the watch to service: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            if (index >= 0 && index < watchList.size()) {
                System.out.print("Enter service type (Cleaning/Repair/Battery Change/Custom): ");
                String serviceType = scanner.nextLine();
                
                Service service;
                System.out.print("Use courier? (y/n): ");
                String courierChoice = scanner.nextLine();
                
                if (courierChoice.equalsIgnoreCase("y")) {
                    service = new Service("SERV" + (serviceList.size() + 1), serviceType, true);
                } else {
                    service = new Service("SERV" + (serviceList.size() + 1), serviceType);
                }
                
                serviceList.add(service);
                System.out.println("Service requested successfully! Service ID: " + service.getServiceId());
            } else {
                System.out.println("Invalid index.");
            }
        }
    }

    public static ArrayList<Service> getServiceList() {
        return serviceList;
    }
}