package com.pharmacy.app;

import java.util.*;

public class PharmacyApplication {
	 public static void main(String[] args) {
	        Pharmacy pharmacy = new Pharmacy();
	        @SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
	        
	        pharmacy.loadMedicines();

	        int choice;
	        do {
	            System.out.println("\nPharmacy Management System:");
	            System.out.println("1. Add Medicine");
	            System.out.println("2. View Medicines");
	            System.out.println("3. Update Medicine");
	            System.out.println("4. Delete Medicine");
	            System.out.println("5. Sort Medicines by Name");
	            System.out.println("6. Sort Medicines by Type");
	            System.out.println("7. Sort Medicines by Availability");
	            System.out.println("8. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline character

	            switch (choice) {
	                case 1:
	                    addMedicine(pharmacy);
	                    break;
	                case 2:
	                    viewMedicines(pharmacy);
	                    break;
	                case 3:
	                    updateMedicine(pharmacy);
	                    break;
	                case 4:
	                    deleteMedicine(pharmacy);
	                    break;
	                case 5:
	                    pharmacy.sortByName();
	                    System.out.println("Medicines sorted by Name:");
	                    pharmacy.printMedicines();
	                    break;
	                case 6:
	                    pharmacy.sortByType();
	                    System.out.println("Medicines sorted by Type:");
	                    pharmacy.printMedicines();
	                    break;
	                case 7:
	                    pharmacy.sortByAvailability();
	                    System.out.println("Medicines sorted by Availability:");
	                    pharmacy.printMedicines();
	                    break;
	                case 8:
	                    System.out.println("Exiting the program.");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } while (choice != 8);

	        // Save medicines to a file before exiting
	        pharmacy.saveMedicines();
	    }

	    private static void addMedicine(Pharmacy pharmacy) {
	        @SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the name of the medicine: ");
	        String name = scanner.nextLine();
	        System.out.print("Enter the type of the medicine: ");
	        String type = scanner.nextLine();
	        System.out.print("Enter the available quantity: ");
	        int available = scanner.nextInt();
	        scanner.nextLine();

	        Medicine newMedicine = new Medicine(name, type, available);
	        pharmacy.addMedicine(newMedicine);
	        System.out.println("Medicine added successfully.");
	    }

	    private static void viewMedicines(Pharmacy pharmacy) {
	        System.out.println("\nMedicines in the pharmacy:");
	        pharmacy.printMedicines();
	    }

	    private static void updateMedicine(Pharmacy pharmacy) {
	        @SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the name of the medicine to update: ");
	        String name = scanner.nextLine();

	        for (Medicine medicine : pharmacy.getMedicines()) {
	            if (medicine.getName().equals(name)) {
	                System.out.print("Enter the new available quantity: ");
	                int newAvailable = scanner.nextInt();
	                scanner.nextLine();

	                medicine.setAvailable(newAvailable);
	                System.out.println("Medicine updated successfully.");
	                return;
	            }
	        }

	        System.out.println("Medicine not found.");
	    }

	    private static void deleteMedicine(Pharmacy pharmacy) {
	        @SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the name of the medicine to delete: ");
	        String name = scanner.nextLine();

	        for (Medicine medicine : pharmacy.getMedicines()) {
	            if (medicine.getName().equals(name)) {
	                pharmacy.getMedicines().remove(medicine);
	                System.out.println("Medicine deleted successfully.");
	                return;
	            }
	        }

	        System.out.println("Medicine not found.");
	    }
}
