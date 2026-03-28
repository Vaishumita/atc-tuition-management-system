/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package tuition;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.nio.file.StandardCopyOption;
import static tuition.Utils.writeToFile;
import static tuition.Utils.deleteFromFile;



public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Register Tutor");
            System.out.println("2. Delete Tutor");
            System.out.println("3. Register Receptionist");
            System.out.println("4. Delete Receptionist");
            System.out.println("5. View Monthly Income Report");
            System.out.println("6. Update Profile");
            System.out.println("7. Register Student");
            System.out.println("8. Delete Student");
            System.out.println("0. Logout");
            System.out.print("Choose: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> registerTutor(sc);
                case 2 -> deleteTutor(sc);
                case 3 -> registerReceptionist(sc);
                case 4 -> deleteReceptionist(sc);
                case 5 -> viewMonthlyIncome();
                case 6 -> updateProfile(sc);
                case 7 -> registerStudent (sc);
                case 8 -> deleteStudent(sc);
                case 0 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid option.");
            }

        } while (choice != 0);
    }

    private void registerTutor(Scanner sc) {
        System.out.print("Enter tutor userid: ");
        String tUserID = sc.nextLine();
        System.out.print("Enter tutor username: ");
        String tUsername = sc.nextLine();
        System.out.print("Enter tutor full name: ");
        String tFullName = sc.nextLine();
        System.out.print("Enter tutor password: ");
        String tPassword = sc.nextLine();
        System.out.print("Enter email: ");
        String tEmail = sc.nextLine();
        System.out.print("Enter phone number: ");
        String tPhone = sc.nextLine();

        String record = tUserID + "," + tUsername + "," + tFullName + "," + tPassword + "," + tEmail + "," + tPhone;
        writeToFile("data/tutors.txt", record);
        writeToFile("data/users.txt", tUsername + "," + tPassword + ",Tutor");
        System.out.println("Tutor registered successfully!");
    }

    private void deleteTutor(Scanner sc) {
        System.out.print("Enter tutor username to delete: ");
        String delUsername = sc.nextLine();

        boolean tutorDeleted = deleteFromFile("data/tutors.txt", delUsername, 1);
        boolean userDeleted = deleteFromFile("data/users.txt", delUsername, 0);

        if (tutorDeleted) {
            System.out.println("Tutor deleted from tutors.txt.");
        } else {
            System.out.println("Tutor not found in tutors.txt.");
        }

        if (userDeleted) {
            System.out.println("Tutor login deleted from users.txt.");
        } else {
            System.out.println("Tutor login not found in users.txt.");
        }
    }

    private void registerReceptionist(Scanner sc) {
        System.out.print("Enter receptionist ID: ");
        String rID = sc.nextLine();
        System.out.print("Enter receptionist username: ");
        String rUsername = sc.nextLine();
        System.out.print("Enter receptionist Full name: ");
        String rName = sc.nextLine();
        System.out.print("Enter receptionist password: ");
        String rPassword = sc.nextLine();
        System.out.print("Enter receptionist IC: ");
        String rIC = sc.nextLine();
        System.out.print("Enter receptionist email: ");
        String rEmail = sc.nextLine();
        System.out.print("Enter receptionist Phone: ");
        String rPhone = sc.nextLine();
        System.out.print("Enter receptionist address: ");
        String rAddress = sc.nextLine();

        String record = rID + "," + rUsername + "," + rName + "," + rPassword + "," + rIC + "," + rEmail + "," + rPhone + "," + rAddress + ",Receptionist";
        writeToFile("data/receptionists.txt", record);
        writeToFile("data/users.txt", rUsername + "," + rPassword + ",Receptionist");
        System.out.println("Receptionist registered successfully!");
    }

    private void deleteReceptionist(Scanner sc) {
        System.out.print("Enter receptionist username to delete: ");
        String delUsername = sc.nextLine();
        deleteFromFile("data/receptionists.txt", delUsername, 1);
        deleteFromFile("data/users.txt", delUsername, 0);
        
    }

    private void viewMonthlyIncome() {
        try (BufferedReader reader = new BufferedReader(new FileReader("data/payments.txt"))) {
            LocalDate currentDate = LocalDate.now();
            int currentMonth = currentDate.getMonthValue();
            int currentYear = currentDate.getYear();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            double totalIncome = 0;
            String line;

            reader.readLine(); // skip header

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    LocalDate date = LocalDate.parse(parts[3], formatter);
                    if (date.getMonthValue() == currentMonth && date.getYear() == currentYear) {
                        double amount = Double.parseDouble(parts[1]);
                        totalIncome += amount;
                        System.out.println("Username: " + parts[0] + " | Amount: RM " + parts[1] + " | Date: " + parts[3]);
                    }
                }
            }
            System.out.printf("\nTotal Monthly Income for %d/%d is: RM %.2f\n", currentMonth, currentYear, totalIncome);
        } catch (IOException | DateTimeParseException e) {
            System.out.println("Error reading payment records: " + e.getMessage());
        }
    }

    private void updateProfile(Scanner sc) {
    System.out.print("Enter current username: ");
    String username = sc.nextLine().trim();
    System.out.print("Enter current password: ");
    String currentPassword = sc.nextLine().trim();
    System.out.print("Enter new password: ");
    String newPassword = sc.nextLine().trim();

    File inputFile = new File("data/users.txt");
    File tempFile = new File("data/users_temp.txt");
    boolean updated = false;

    try (
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
    ) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");

            if (parts.length >= 2 && parts[0].trim().equals(username) && parts[1].trim().equals(currentPassword)) {
                // Update password, keep role if exists
                if (parts.length == 3) {
                    writer.write(parts[0] + "," + newPassword + "," + parts[2]);
                } else {
                    writer.write(parts[0] + "," + newPassword);
                }
                updated = true;
            } else {
                writer.write(line);
            }
            writer.newLine();
        }
    } catch (IOException e) {
        System.out.println("Error updating profile.");
        return;
    }

    // ✅ Replace original users.txt with temp file
    if (updated) {
        try {
            FileOutputStream fos = new FileOutputStream(inputFile);
            fos.write(Files.readAllBytes(tempFile.toPath()));
            fos.close();
            System.out.println("Password updated successfully!");
        } catch (IOException e) {
            System.out.println("Failed to overwrite users.txt file.");
        }
    } else {
        System.out.println("Invalid username or password.");
        tempFile.delete(); // Clean up temp file
    }
   }

    private void registerStudent(Scanner sc) {
    System.out.print("Enter student ID: ");
    String sID = sc.nextLine().trim();
    System.out.print("Enter student username: ");
    String sUsername = sc.nextLine().trim();
    System.out.print("Enter password: ");
    String sPassword = sc.nextLine().trim();
    System.out.print("Enter full name: ");
    String sFullName = sc.nextLine().trim();
    System.out.print("Enter IC: ");
    String sIC = sc.nextLine().trim();
    System.out.print("Enter email: ");
    String sEmail = sc.nextLine().trim();
    System.out.print("Enter phone number: ");
    String sPhone = sc.nextLine().trim();
    System.out.print("Enter address: ");
    String sAddress = sc.nextLine().trim();
    System.out.print("Enter level (e.g. Form 4): ");
    String sLevel = sc.nextLine();
    System.out.print("Enter subject 1: ");
    String sub1 = sc.nextLine();
    System.out.print("Enter subject 2: ");
    String sub2 = sc.nextLine();
    System.out.print("Enter subject 3: ");
    String sub3 = sc.nextLine();
    System.out.print("Enter enrollment month: ");
    String sMonth = sc.nextLine();

    try (
        FileWriter studentWriter = new FileWriter("data/students.txt", true);
        FileWriter userWriter = new FileWriter("data/users.txt", true)
    ) {
        String studentRecord = sID + "," + sUsername + "," + sPassword + "," + sFullName + "," + sIC + "," + sEmail + "," + sPhone + "," + sAddress + "," + sLevel + "," + sub1 + "," + sub2 + "," + sub3 + "," + sMonth;
        studentWriter.write(studentRecord + "\n");

        String userRecord = sUsername + "," + sPassword + ",Student";
        userWriter.write(userRecord + "\n");

        System.out.println("Student registered successfully!");
    } catch (IOException e) {
        System.out.println("Error writing student/user files: " + e.getMessage());
    }
  }

    private void deleteStudent(Scanner sc) {
        
                System.out.print("Enter tutor username to delete: ");
        String delUsername = sc.nextLine();

        boolean tutorDeleted = deleteFromFile("data/students.txt", delUsername, 1);
        boolean userDeleted = deleteFromFile("data/users.txt", delUsername, 0);

        if (tutorDeleted) {
            System.out.println("Tutor deleted from student.txt.");
        } else {
            System.out.println("Tutor not found in student.txt.");
        }

        if (userDeleted) {
            System.out.println("Tutor login deleted from users.txt.");
        } else {
            System.out.println("Tutor login not found in users.txt.");
        }
      }
   }

