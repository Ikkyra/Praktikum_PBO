// Rifki Abiyan
// 2309106030
// A2 23
package com.precisionwatchcare;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<UserAccount> userAccounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        userAccounts.add(new UserAccount("admin", "admin123", "admin"));
        // admin acc = admin | admin123
        while (true) {
            System.out.println("\n=== Precision Watch Care ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("\n============================");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method Register
    private static void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (UserAccount account : userAccounts) {
            if (account.getUsername().equals(username)) {
                System.out.println("Username already exists. Please choose another username.");
                return;
            }
        }

        userAccounts.add(new UserAccount(username, password, "user"));
        System.out.println("Registration successful! You can now login.");
    }

    // Method Login
    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (UserAccount account : userAccounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                System.out.println("Login successful! Welcome, " + username + ".");
                if (account.getRole().equals("admin")) {
                    Admin.adminMenu();
                } else {
                    User.userMenu();
                }
                return;
            }
        }

        System.out.println("Invalid username or password. Please try again.");
    }
}