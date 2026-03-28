/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuition;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        //Utils.printFile("data/users.txt");

        Scanner sc = new Scanner(System.in);
        int attempt = 0;
        boolean loggedIn = false;

        while (attempt < 3 && !loggedIn) {
            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();
            
            
System.out.print("Hello,");
            try (BufferedReader br = new BufferedReader(new FileReader("data/users.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    
                    if (parts[0].equals(username) && parts[1].equals(password)) {
                        String role = parts[2].toLowerCase();
                        loggedIn = true;
                        System.out.print("Welcome " + username);
                        switch (role) {
                            case "admin":
                                System.out.print("Admin");
                                new Admin(username, password).showMenu();
                                break;
                            case "receptionist":
                                new Receptionist(username, password).showMenu();
                                break;
                            case "tutor":
                                new Tutor(username, password).showMenu();
                                break;
                            case "student":
                                new Student(username, password).showMenu();
                                break;
                            default:
                                System.out.println("Unknown role.");
                        }
                        break;
                    }
                }
            } catch (IOException e) {
                  System.out.print("error in reading file");
                System.out.println("Error reading user file.");
            }

            if (!loggedIn) {
                attempt++;
                System.out.println("Invalid credentials. Attempt " + attempt + "/3.");
            }
        }

        if (!loggedIn) {
            System.out.println("Login failed 3 times. Exiting...");
        }
    }
}
