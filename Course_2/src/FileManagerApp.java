import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileManagerApp {

    private static List<String> directoryList = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            displayMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            
            switch (choice) {
                case 1:
                    displayFileNames();
                    break;
                case 2:
                    displayDirectoryOptions(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 3);
        
        scanner.close();
    }
    
    private static void displayMainMenu() {
        System.out.println("Welcome to FileManagerApp");
        System.out.println("1. List Files in Ascending Order");
        System.out.println("2. Directory Options");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }
    
    private static void displayFileNames() {
        if (directoryList.isEmpty()) {
            System.out.println("No files in the directory.");
            return;
        }
        
        Collections.sort(directoryList);
        System.out.println("Files in Ascending Order:");
        for (String fileName : directoryList) {
            System.out.println(fileName);
        }
    }
    
    private static void displayDirectoryOptions(Scanner scanner) {
        int choice;
        
        do {
            System.out.println("Directory Options:");
            System.out.println("1. Add a File");
            System.out.println("2. Delete a File");
            System.out.println("3. Search for a File");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            
            switch (choice) {
                case 1:
                    addFile(scanner);
                    break;
                case 2:
                    deleteFile(scanner);
                    break;
                case 3:
                    searchFile(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (true);
    }
    
    private static void addFile(Scanner scanner) {
        System.out.print("Enter the file name to add: ");
        String fileName = scanner.nextLine();
        directoryList.add(fileName);
        System.out.println("File added successfully.");
    }
    
    private static void deleteFile(Scanner scanner) {
        System.out.print("Enter the file name to delete: ");
        String fileName = scanner.nextLine();
        
        if (directoryList.remove(fileName)) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("File not found.");
        }
    }
    
    private static void searchFile(Scanner scanner) {
        System.out.print("Enter the file name to search: ");
        String fileName = scanner.nextLine();
        
        if (directoryList.contains(fileName)) {
            System.out.println("File found.");
        } else {
            System.out.println("File not found.");
        }
    }
}