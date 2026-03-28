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
import java.io.PrintWriter;
import java.nio.file.Files;


public class Student extends User {
  public Student(String username, String password) {
    super(username, password);
  }

  @Override
  public void showMenu() {
    Scanner sc = new Scanner(System.in);
    int choice;

    do {
        
      System.out.println("\n--- Student Menu ---");
      System.out.println("1. View Class Schedule");
      System.out.println("2. Request Subject Change");
      System.out.println("3. Remove Pending Request");
      System.out.println("4. View Payment Status");
      System.out.println("5. Update Profile");
      System.out.println("0. Logout");
      System.out.print("Enter your choice: ");
      choice = Integer.parseInt(sc.nextLine());

      switch (choice) {
        case 1: viewSchedule(); break;
        case 2: sendChangeRequest(); break;
        case 3: deletePendingRequest(); break;
        case 4: viewPaymentStatus(); break;
        case 5: updateProfile(); break;
        case 0: System.out.println("Logging out..."); break;
        default: System.out.println("Invalid option.");
      }
    } while (choice != 0);
  }


    private void viewSchedule() {
        System.out.println("\n Your Class Schedule:");
        String subject = "";
        boolean found;

        try (BufferedReader br = new BufferedReader(new FileReader("data/classes.txt"))) {
            String line;
                         
            while ((line = br.readLine()) != null) {
                System.out.println(line);
//                String[] parts = line.split(",");
//                if (parts.length >= 1 && parts[5].trim().equals(getUsername())) {
//                    subject = parts[4].trim();
//                    break;
//                }
            }
        } catch (IOException e) {
            System.out.println("Error reading student info.");
            return;
        }

//        if (subject.isEmpty()) {
//            System.out.println("No subject found for your account.");
//            return;
//        }

        try (BufferedReader br = new BufferedReader(new FileReader("data/classes.txt"))) {
            String line;
            found = true;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5 && parts[1].trim().equalsIgnoreCase(subject)) {
                    System.out.println("Class ID: " + parts[0] +
                            " | Subject: " + parts[1] +
                            " | Tutor: " + parts[2] +
                            " | Time: " + parts[3] +
                            " | Day: " + parts[4]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No class found for your subject.");
            }
        } catch (IOException e) {
            System.out.println("Error reading class schedule.");
        }
    }
  
  private void sendChangeRequest() {
    String currentSubject = "";
    String studentID= "";
    
    // Step 1: Get current subject of logged-in student
    try (BufferedReader br = new BufferedReader(new FileReader("data/students.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            // parts[0] = student ID
            // parts[1] = student name
            // parts[2] = phone
            // parts[3] = form
            // parts[4] = subject
            
            if (parts.length >= 4 && parts[1].trim().equals(getUsername())) {
                currentSubject = parts[4].trim();
                studentID=parts[0].trim();
                break;
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading student info.");
        return;
    }

    if (currentSubject.isEmpty()) {
        System.out.println("Cannot find your subject in the system.");
        return;
    }

    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the new subject you want to request: ");
    String newSubject = sc.nextLine().trim();

    // Step 2: Save the request into subject_change_requests.txt
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/requests.txt", true))) {
//         bw.newLine();
        bw.write(studentID +","+ getUsername() + "," + currentSubject + "," + newSubject + ",PENDING");
        bw.newLine();
        System.out.println("Your request has been submitted and is now pending.");
    } catch (IOException e) {
        System.out.println("Error writing your request.");
    }
  }  

  private void deletePendingRequest() {
    File inputFile = new File("data/requests.txt");
    File tempFile = new File("data/requests_temp.txt");

    boolean found = false;

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 4 && parts[1].trim().equals(getUsername()) && parts[4].trim().equalsIgnoreCase("PENDING")) {
                found = true; // Skip this line (deleting it)
            } else {
                writer.write(line);
                writer.newLine();
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading or writing file.");
        return;
    }

    if (inputFile.delete()) {
        tempFile.renameTo(inputFile);
        if (found) {
            System.out.println("Your pending request has been deleted.");
        } else {
            System.out.println("No pending request found to delete.");
        }
    } else {
        System.out.println("Could not delete original file.");
    }
}
         
  private void viewPaymentStatus() {
    File paymentFile = new File("data/payments.txt");
    double totalPaid = 0;
    double totalUnpaid = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader(paymentFile))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 3 && parts[0].trim().equals(getUsername())) {
                double amount = Double.parseDouble(parts[1].trim());
                String status = parts[2].trim().toLowerCase();

                if (status.equals("paid")) {
                    totalPaid += amount;
                } else if (status.equals("unpaid")) {
                    totalUnpaid += amount;
                }
            }
        }

        System.out.println("\n--- Payment Summary ---");
        System.out.println("Total Paid: RM " + totalPaid);
        System.out.println("Total Unpaid: RM " + totalUnpaid);
        if (totalUnpaid > 0) {
            System.out.println("You still have a balance to pay.");
        } else {
            System.out.println("All fees are settled.");
        }

    } catch (IOException e) {
        System.out.println("Error reading payment file.");
    }
}
              
  private void updateProfile() {
    File studentFile = new File("data/students.txt");
    File tempFile = new File("data/students_temp.txt");

    Scanner sc = new Scanner(System.in);
    boolean updated = false;

    try (BufferedReader reader = new BufferedReader(new FileReader(studentFile));
         PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 12 && parts[1].trim().equals(getUsername())) {
                System.out.println("Current Username: " + parts[1].trim());
                System.out.println("Current Phone: " + parts[6].trim());

                System.out.print("Enter new Username: ");
                String newUsername = sc.nextLine().trim();

                System.out.print("Enter new phone number: ");
                String newPhone = sc.nextLine().trim();

                String newLine = parts[0].trim() + ", " + newUsername + ", " + parts[2].trim() + ", " + parts[3].trim() + ", " + parts[4].trim() + "," + parts[5].trim() + "," + newPhone ;
                writer.println(newLine);
                updated = true;
                System.out.println("Profile updated successfully.");
            } else {
                writer.println(line);
            }
        }

        } catch (IOException e) {
            System.out.println("Error updating profile.");
            return;
        }
    
        if (updated) {
        try {
            Files.move(tempFile.toPath(), studentFile.toPath(), 
            java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            
            System.out.println("Profile updated successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save updated profile: " + e.getMessage());
        }
    } else {
        System.out.println("Could not find your profile.");
        tempFile.delete(); // clean up
    }
            }

  }
  


