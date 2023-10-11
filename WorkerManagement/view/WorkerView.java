package view;

import java.util.List;
import java.util.Scanner;
import controller.WorkerController;
import model.SalaryHistory;

public class WorkerView {
    private WorkerController controller;
    private Scanner scanner;

    public WorkerView(WorkerController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("----------------------------------------");
        System.out.println("========== Worker Management ===========");
        System.out.println("\t1. Add a Worker");
        System.out.println("\t2. Increase Salary");
        System.out.println("\t3. Decrease Salary");
        System.out.println("\t4. Display Adjusted Salary History");
        System.out.println("\t5. Quit");
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            System.out.print("\tEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addWorker();
                    break;
                case 2:
                    increaseSalary();
                    break;
                case 3:
                    decreaseSalary();
                    break;
                case 4:
                    showAdjustedSalaryHistory();
                    break;
                case 5:
                    System.out.println("Thanks. Goodbye!\nLeaving...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private void addWorker() {
        System.out.println("-------------------------------");
        System.out.println("--------- Add Worker ----------");
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Work Location: ");
        String workLocation = scanner.nextLine();

        if (controller.addWorker(id, name, age, salary, workLocation)) {
            System.out.println("Worker added successfully.");
        } else {
            System.out.println("Worker could not be added. Please check the input!");
        }
    }

    private void increaseSalary() {
        System.out.println("-------------------------------");
        System.out.println("-------Increasing Salary-------");
        System.out.print("Enter Worker ID: ");
        String workerId = scanner.nextLine();
        System.out.print("Enter Amount to Increase: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (controller.increaseSalary(workerId, amount)) {
            System.out.println("Salary increased successfully.");
        } else {
            System.out.println("Salary could not be increased. Please check the input!");
        }
    }

    private void decreaseSalary() {
        System.out.println("-------------------------------");
        System.out.println("-------Decreasing Salary-------");
        System.out.print("Enter Worker ID: ");
        String workerId = scanner.nextLine();
        System.out.print("Enter Amount to Decrease: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (controller.decreaseSalary(workerId, amount)) {
            System.out.println("Salary decreased successfully.");
        } else {
            System.out.println("Salary could not be decreased. Please check the input.");
        }
    }

    private void showAdjustedSalaryHistory() {
        System.out.println("----------------------------------------");
        System.out.println("-------Display Information Salary-------");
        List<SalaryHistory> history = controller.showAdjustedSalaryHistory();
        if (history.isEmpty()) {
            System.out.println("No salary adjustments have been made.");
        } else {
            System.out.println("Adjusted Salary History:");
            history.forEach(System.out::println);
        }
    }
}
