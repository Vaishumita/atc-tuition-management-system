/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuition;

import java.io.*;

public class Utils {

    //Validate login and return role (admin/tutor/student/receptionist)
    public static String validateLogin(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("data/users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3 && parts[0].equals(username) && parts[1].equals(password)) {
                    return parts[2].trim(); // Role
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading users.txt");
        }
        return null; // Invalid login
    }

    //Print contents of any file
    public static void printFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        }
    }

    //Append new line to a file
    public static void appendToFile(String filePath, String data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(data);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + filePath);
        }
    }

    //Overwrite entire file with new content
    public static void overwriteFile(String filePath, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(content);
        } catch (IOException e) {
            System.out.println("Error overwriting file: " + filePath);
        }
    }

    //Delete a specific line from a file (by matching exact line content)
    public static void deleteLineFromFile(String filePath, String targetLine) {
        try {
            File inputFile = new File(filePath);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRead;
            while ((lineToRead = reader.readLine()) != null) {
                if (!lineToRead.trim().equals(targetLine.trim())) {
                    writer.write(lineToRead);
                    writer.newLine();
                }
            }

            writer.close();
            reader.close();

            if (inputFile.delete()) {
                tempFile.renameTo(inputFile);
            } else {
                System.out.println("Could not delete original file.");
            }

        } catch (IOException e) {
            System.out.println("Error deleting line from file: " + filePath);
        }
    }
    
    public static String generateNextPaymentID() {
    int lastID = 0;

    try (BufferedReader br = new BufferedReader(new FileReader("data/payments.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            if (line.startsWith("P")) {
                String idStr = line.split(",")[0].substring(1); // remove 'P'
                int id = Integer.parseInt(idStr);
                if (id > lastID) {
                    lastID = id;
                }
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading payments.txt to generate ID");
    }

    return String.format("P%03d", lastID + 1); // e.g., P001, P002
    }

    // Used for Admin.java – writes a single line to any file (append mode)
public static void writeToFile(String path, String data) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
        bw.write(data);
        bw.newLine();
    } catch (IOException e) {
        System.out.println("Error writing to file: " + path);
    }
}

// Used for Admin.java – deletes a record by matching value at specific index
public static boolean deleteFromFile(String filePath, String key, int keyIndex) {
        boolean deleted = false;
        File inputFile = new File(filePath);
        File tempFile = new File(inputFile.getParent(), "temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(",");
                if (parts.length > keyIndex && parts[keyIndex].trim().equals(key)) {
                    deleted = true;
                    continue; // skip this line
                }
                writer.write(currentLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error processing file: " + filePath);
            return false;
        }

        if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
            System.out.println("Error updating file: " + filePath);
            return false;
        }
        return deleted;
    }
  }
