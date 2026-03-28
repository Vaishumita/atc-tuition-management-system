/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuition;


import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class Tutor extends User {
    public Tutor(String username, String password) {
        super(username, password);
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Tutor Menu ---");
            System.out.println("1. Add Class Information");
            System.out.println("2. Update Class Information");
            System.out.println("3. Delete Class Information");
            System.out.println("4. View Enrolled Students");
            System.out.println("5. Update Profile");
            System.out.println("0. Logout");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addClass(sc);
                case 2 -> updateClass(sc);
                case 3 -> deleteClass(sc);
                case 4 -> viewEnrolledStudents();
                case 5 -> updateProfile(sc);
                case 0 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private void addClass(Scanner sc) {
        System.out.print("Enter Subject Name: ");
        String subject = sc.nextLine();

        System.out.print("Enter Charges (RM): ");
        String charges = sc.nextLine();

        System.out.print("Enter Class Schedule (e.g., Mon 2PM-4PM): ");
        String schedule = sc.nextLine();

        try (FileWriter fw = new FileWriter("data/classes.txt", true)) {
            fw.write(subject + "," + charges + "," + schedule + "," + getUsername() + "\n");
            System.out.println("Class info added successfully!");
        } catch (IOException e) {
            System.out.println("Error writing class info." + e);
        }
    }

    private void updateClass(Scanner sc) {
        System.out.print("Enter subject name to update: ");
        String subjectToUpdate = sc.nextLine();

        File inputFile = new File("data/classes.txt");
        File tempFile = new File("data/classes_temp.txt");
        boolean found = false;

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4 && parts[0].equalsIgnoreCase(subjectToUpdate) && parts[3].equals(getUsername())) {
                    System.out.print("Enter new charges (RM): ");
                    String newCharges = sc.nextLine();
                    System.out.print("Enter new schedule: ");
                    String newSchedule = sc.nextLine();
                    writer.write(parts[0] + "," + newCharges + "," + newSchedule + "," + parts[3] + "\n");
                    found = true;
                } else {
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error updating class.");
        }

        if (found && inputFile.delete()) {
            tempFile.renameTo(inputFile);
            System.out.println("Class updated successfully!");
        } else {
            System.out.println("Subject not found or you're not the tutor.");
        }
    }

    private void deleteClass(Scanner sc) {
        System.out.print("Enter subject name to delete: ");
        String subjectToDelete = sc.nextLine();

        File inputFile = new File("data/classes.txt");
        File tempFile = new File("data/classes_temp.txt");
        boolean deleted = false;

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4 && parts[0].equalsIgnoreCase(subjectToDelete) && parts[3].equals(getUsername())) {
                    deleted = true; // skip writing this line
                } else {
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error deleting class.");
        }

        if (deleted && inputFile.delete()) {
            tempFile.renameTo(inputFile);
            System.out.println("Class deleted successfully!");
        } else {
            System.out.println("Subject not found or you're not the tutor.");
        }
    }

    private void viewEnrolledStudents() {
        System.out.println("\nYour Enrolled Students:");
        try (BufferedReader br = new BufferedReader(new FileReader("data/students.txt"))) {
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 12 && parts[1].trim().equals(getUsername())) {
                    System.out.println("- ID: " + parts[0] + 
                                       " | Name: " + parts[3] + 
                                       " | Phone: " + parts[6] + 
                                       " | Level: " + parts[8] + 
                                       " | Subjects: " + parts[9] + ", " + parts[10] + ", " + parts[11]);
                    found = true;
                }
            }
            if (!found)
                System.out.println("No students enrolled under your subjects yet.");
        } catch (IOException e) {
            System.out.println("Error reading student list.");
        }
    }

    private void updateProfile(Scanner sc) {
        System.out.print("Enter your new password: ");
        String newPassword = sc.nextLine();

        File inputFile = new File("data/tutors.txt");
        File tempFile = new File("data/tutors_temp.txt");

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[1].equals(getUsername())) {
                    writer.write(parts[0] + "," + parts[1] + "," + newPassword + "," + parts[3] + "," + parts[4] + "," + parts[5] + "," + parts[6] + "\n");
                } else {
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error updating profile.");
            return;
        }

        if (inputFile.delete()) {
            tempFile.renameTo(inputFile);
            System.out.println("Profile updated successfully!");
        } else {
            System.out.println("Failed to update file.");
        }
    }
}
