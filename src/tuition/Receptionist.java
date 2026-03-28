/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuition;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader; 
import java.io.PrintWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileOutputStream;
import java.nio.file.StandardCopyOption;


public class Receptionist extends User {
    
    Scanner sc = new Scanner(System.in);
    int choice;

    public Receptionist(String username, String password) {
        super(username, password);
    }

    public void showMenu() {
        do {
            System.out.println("\n--- Receptionist Menu ---");
            System.out.println("1. Register Student");
            System.out.println("2. View Student list");
            System.out.println("3. Update Student Subjects");
            System.out.println("4. Accept Payment & Generate Receipt");
            System.out.println("5. Delete Student (Graduated)");
            System.out.println("6. Update Your Profile");
            System.out.println("0. Logout");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // clear newline
                    System.out.print("Enter student ID: ");
                    String sStudentID = sc.nextLine();
                    System.out.print("Enter student username: ");
                    String sUsername = sc.nextLine();
                    System.out.print("Enter student password: ");
                    String sPassword = sc.nextLine();
                    System.out.print("Enter full name: ");
                    String sName = sc.nextLine();
                    System.out.print("Enter IC/Passport No: ");
                    String sIC = sc.nextLine();
                    System.out.print("Enter email: ");
                    String sEmail = sc.nextLine();
                    System.out.print("Enter phone number: ");
                    String sPhone = sc.nextLine();
                    System.out.print("Enter address: ");
                    String sAddress = sc.nextLine();
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

                    String record = sStudentID + "," + sUsername + "," + sPassword + "," + sName + "," + sIC + "," + sEmail + "," + sPhone + "," + sAddress + "," + sLevel + "," + sub1 + "," + sub2 + "," + sub3 + "," + sMonth;

                    // Save student info
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/students.txt", true))) {
                        bw.write(record);
//                        bw.newLine();
                        System.out.println("Student registered successfully!");
                    } catch (IOException e) {
                        System.out.println("Error writing to students file.");
                    }

                    // Save login info
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/users.txt", true))) {
                        bw.write(sUsername + "," + sPassword + ",student");
                        bw.newLine();
                        System.out.println("Student login added to users.txt!");
                    } catch (IOException e) {
                        System.out.println("Error updating users file.");
                    }
    break;

                case 2:
                    System.out.println("\n--- Registered Students ---");
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("data/students.txt"));
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                        br.close(); // Don't forget to close the reader
                    } catch (IOException e) {
                        System.out.println("Error reading student list.");
                    }
    break;

                case 3:
                    sc.nextLine(); // clear newline
                    System.out.print("Enter student username to update subjects: ");
                    String targetUsername = sc.nextLine().trim();

                    File studentFile = new File("data/students.txt");
                    File tempFile = new File("data/students_temp.txt");

                    boolean found = false;

                    try (
                        BufferedReader reader = new BufferedReader(new FileReader(studentFile));
                        PrintWriter writer = new PrintWriter(new FileWriter(tempFile))
                    ) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(",");
                            if (parts.length >= 11 && parts[0].trim().equals(targetUsername)) {
                                // Show current subjects
                                System.out.println("Current Subjects:");
                                System.out.println("1. " + parts[9]);
                                System.out.println("2. " + parts[10]);
                                System.out.println("3. " + parts[11]);

                                // Ask for new subjects
                                System.out.print("Enter new subject 1: ");
                                String newSub1 = sc.nextLine().trim();
                                System.out.print("Enter new subject 2: ");
                                String newSub2 = sc.nextLine().trim();
                                System.out.print("Enter new subject 3: ");
                                String newSub3 = sc.nextLine().trim();

                                // Replace old subjects with new ones
                                parts[9] = newSub1;
                                parts[10] = newSub2;
                                parts[11] = newSub3;

                                // Rewrite updated line
                                writer.println(String.join(",", parts));
                                found = true;
                            } else {
                                writer.println(line); // unchanged
                            }
                        }

                        reader.close();
                        writer.close();

                        if (found) {
                            // Replace original file
                            studentFile.delete();
                            tempFile.renameTo(studentFile);
                            System.out.println("Subjects updated successfully!");
                        } else {
                            tempFile.delete(); // discard
                            System.out.println("Student not found.");
                        }

                    } catch (IOException e) {
                        System.out.println("Error updating subject enrollment.");
                    }
                    
                break;

                
                case 4:
                    sc.nextLine(); // clear newline
                    System.out.print("Enter student username to accept payment: ");
                    String stuUsername = sc.nextLine().trim();

                    System.out.print("Enter amount paid: RM ");
                    String amountPaid = sc.nextLine().trim();

                    System.out.print("Enter payment method (e.g. Cash/Online): ");
                    String method = sc.nextLine().trim();

                    System.out.print("Enter date (e.g. 25-06-2025): ");
                    String date = sc.nextLine().trim();

                    // Save to payments.txt
                    String paymentRecord = stuUsername + "," + amountPaid + "," + method + "," + date;

                    try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/payments.txt", true))) {
                        bw.write(paymentRecord);
                        bw.newLine();
                        System.out.println("✅ Payment recorded successfully!");
                        System.out.println("Receipt:");
                        System.out.println("-----------------------------");
                        System.out.println("Student: " + stuUsername);
                        System.out.println("Amount : RM " + amountPaid);
                        System.out.println("Method : " + method);
                        System.out.println("Date   : " + date);
                        System.out.println("-----------------------------");
                    } catch (IOException e) {
                        System.out.println("Error recording payment.");
                    }
                break;

                
                case 5:
                    sc.nextLine(); // clear newline
                    System.out.print("Enter student username to delete: ");
                    String deleteUsername = sc.nextLine().trim();

                    File originalFile = new File("data/students.txt");
                    File temp_File = new File("data/students_temp.txt");

                    boolean deleted = false;

                    try (
                        BufferedReader reader = new BufferedReader(new FileReader(originalFile));
                        BufferedWriter writer = new BufferedWriter(new FileWriter(temp_File))
                    ) {
                        String line;

                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(",");
                            if (parts.length > 1 && !parts[1].equals(deleteUsername)) {
                                
                                writer.write(line);
                                writer.newLine();
                            } else {
                                deleted = true;
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Error processing student file.");
                        break;
                    }

                    // Replace original with temp file
                    if (originalFile.delete()) {
                        temp_File.renameTo(originalFile);
                        if (deleted) {
                            System.out.println("Student deleted successfully!");
                        } else {
                            System.out.println("Username not found.");
                        }
                    } else {
                        System.out.println("Could not update student file.");
                    }

                break;

case 6:
    sc.nextLine(); // clear buffer
    System.out.println("\nUpdate Your Profile");

    System.out.print("Enter your new username: ");
    String newName    = sc.nextLine().trim();

    System.out.print("Enter new email: ");
    String newEmail   = sc.nextLine().trim();

    System.out.print("Enter new contact number: ");
    String newContact = sc.nextLine().trim();

    System.out.print("Enter new address: ");
    String newAddress = sc.nextLine().trim();

    // 1️⃣ Use the exact same filename you see in your project!
    File inputFile  = new File("data/receptionists.txt");
    File tempFileR   = new File("data/receptionists_temp.txt");
    boolean updated = false;

    try (
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFileR))
    ) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            // parts[1] is the Username column in your file:
            // R001,Navin01,Navin,recep01,0612..,navin@gmail.com,0183..,Taman..,Receptionist
            String fileUsername = parts[1].trim();
            // debug print:
             System.out.println("Comparing fileUsername=" + fileUsername + " to getUsername()=" + getUsername() + " to getUsername().trim()=" + getUsername().trim());

            // 2️⃣ Use equalsIgnoreCase so “Navin01” vs “navin01” still matches:
            System.out.println("parts.length" + parts.length);
            if (parts.length >= 7 && 
                fileUsername.equalsIgnoreCase(getUsername().trim()))
            {
                System.out.println("entering if loop, updateded value" + updated);
                
                // reconstruct the row using your new fields
                String updatedLine =
                    parts[0] + "," +           // ID
                    newName + "," +           // Username
                    parts[2]  + "," +          // Name
                    parts[3]  + "," +          // Password (unchanged)
                    parts[4]  + "," +          // IC
                    newEmail  + "," +          // Email
                    newContact+ "," +          // Phone
                    newAddress+ "," +          // Address
                    parts[7];                  // Role
                writer.write(updatedLine);
                updated = true;
            } else {
                writer.write(line);
                System.out.println("entering else loop, updateded value" + updated);
            }
            writer.newLine();
        }
    } catch (IOException e) {
        System.out.println("Error reading/writing temp file: " + e.getMessage());
        break;
    }

    // 3️⃣ Overwrite original only if we actually updated something:
    if (updated) {
        try {
            // atomic replace
            Files.move(
                tempFileR.toPath(),
                inputFile.toPath(),
                StandardCopyOption.REPLACE_EXISTING
            );
            System.out.println("Profile updated successfully!");
        } 
        catch (IOException e) {
            System.out.println("Failed to overwrite receptionists.txt: " + e.getMessage());
        }
    } else {
        System.out.println("Could not find your profile.");
        tempFileR.delete(); // clean up
    }
    break;


                case 0:
                    System.out.println("Logging out...");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 0);
    }
}
