// Rifki Abiyan
// 2309106030
// A2 23
import java.util.ArrayList;
import java.util.Scanner;
// admin acc = admin | admin123
public class Admin {
    private static Scanner scanner = new Scanner(System.in);

    public static void adminMenu() {
        while (true) {
            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. View All Services");
            System.out.println("2. Estimate Service Cost");
            System.out.println("3. Update Service Status");
            System.out.println("4. Return Watch");
            System.out.println("5. Logout");
            System.out.println("\n======================");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    viewAllServices();
                    break;
                case 2:
                    estimateServiceCost();
                    break;
                case 3:
                    updateServiceStatus();
                    break;
                case 4:
                    returnWatch();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method Service
    private static void viewAllServices() {
        ArrayList<Service> serviceList = User.getServiceList();
        if (serviceList.isEmpty()) {
            System.out.println("No services available.");
        } else {
            for (Service service : serviceList) {
                System.out.println(service);
            }
        }
    }

    // Method Service Cost
    private static void estimateServiceCost() {
        viewAllServices();
        if (!User.getServiceList().isEmpty()) {
            System.out.print("Enter the service ID to estimate cost: ");
            String serviceId = scanner.nextLine();
            System.out.print("Enter estimated cost: Rp");
            double cost = scanner.nextDouble();
            scanner.nextLine(); 

            for (Service service : User.getServiceList()) {
                if (service.getServiceId().equals(serviceId)) {
                    service.setCost(cost);
                    System.out.println("Cost estimated successfully!");
                    return;
                }
            }
            System.out.println("Service ID not found.");
        }
    }

    // Method Status Update
    private static void updateServiceStatus() {
        viewAllServices();
        if (!User.getServiceList().isEmpty()) {
            System.out.print("Enter the service ID to update status: ");
            String serviceId = scanner.nextLine();
            System.out.print("Enter new status (Pending/In Progress/Completed): ");
            String status = scanner.nextLine();

            for (Service service : User.getServiceList()) {
                if (service.getServiceId().equals(serviceId)) {
                    service.setStatus(status);
                    System.out.println("Status updated successfully!");
                    return;
                }
            }
            System.out.println("Service ID not found.");
        }
    }

    // Method Return Watch
    private static void returnWatch() {
        viewAllServices();
        if (!User.getServiceList().isEmpty()) {
            System.out.print("Enter the service ID to return watch: ");
            String serviceId = scanner.nextLine();

            for (Service service : User.getServiceList()) {
                if (service.getServiceId().equals(serviceId)) {
                    if (service.getStatus().equals("Completed")) {
                        System.out.println("Watch returned successfully!");
                        User.getServiceList().remove(service);
                    } else {
                        System.out.println("Service is not yet completed.");
                    }
                    return;
                }
            }
            System.out.println("Service ID not found.");
        }
    }
}