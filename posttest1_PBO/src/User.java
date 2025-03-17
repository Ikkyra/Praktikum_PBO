// Rifki Abiyan
// 2309106030
// A2 23
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
        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter complication: ");
        String complication = scanner.nextLine();
        System.out.print("Enter type (Analog/Digital): ");
        String type = scanner.nextLine();

        Watch watch = new Watch(brand, model, year, complication, type);
        watchList.add(watch);
        System.out.println("Watch added successfully!");
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

    // Method Service Request
    private static void requestService() {
        viewMyWatches();
        if (!watchList.isEmpty()) {
            System.out.print("Enter the index of the watch to service: ");
            int index = scanner.nextInt();
            scanner.nextLine(); 

            if (index >= 0 && index < watchList.size()) {
                System.out.print("Enter service type (Cleaning/Repair/Battery Change/Custom): ");
                String serviceType = scanner.nextLine();
                System.out.print("Use courier? (true/false): ");
                boolean useCourier = scanner.nextBoolean();
                scanner.nextLine(); 

                String serviceId = "SERV" + (serviceList.size() + 1);
                Service service = new Service(serviceId, serviceType, 0, useCourier); 
                serviceList.add(service);
                System.out.println("Service requested successfully! Service ID: " + serviceId);
            } else {
                System.out.println("Invalid index.");
            }
        }
    }

    public static ArrayList<Service> getServiceList() {
        return serviceList;
    }
}