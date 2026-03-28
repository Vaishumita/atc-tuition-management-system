/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.admin;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 *
 * @author 60193
 */
    
public class AdminCalendar extends JFrame {
    
    
    public AdminCalendar() {
        setTitle("Calendar");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        repaint();


        LocalDate today = LocalDate.now();
        String month = today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        int year = today.getYear();

        JLabel label = new JLabel(month + " " + year, JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.NORTH);

        String[] days = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
        JPanel panel = new JPanel(new GridLayout(0, 7));

        for (String d : days) {
            panel.add(new JLabel(d, JLabel.CENTER));
        }

        LocalDate firstDay = today.withDayOfMonth(1);
        int dayOfWeek = firstDay.getDayOfWeek().getValue(); // 1 = Monday

        int skip = dayOfWeek % 7;
        for (int i = 0; i < skip; i++) {
            panel.add(new JLabel(""));
        }

        int daysInMonth = today.lengthOfMonth();
        JLabel[] labels = new JLabel[daysInMonth];
for (int i = 1; i <= daysInMonth; i++) {
    panel.add(new JLabel(String.valueOf(i), JLabel.CENTER));
//        for (int i = 0; i < daysInMonth; i++) {
//            labels[i] = new JLabel(String.valueOf(i + 1), JLabel.CENTER);
//            panel.add(labels[i]);
        }

        add(panel, BorderLayout.CENTER);
    }
    
//    JLabel[] labels = new JLabel[31]; // 31 days in July
//
//    
//    LocalDate today = LocalDate.now();
//int currentDay = today.getDayOfMonth();
//int currentMonth = today.getMonthValue();
//int currentYear = today.getYear();
//
//if (currentMonth == 7 && currentYear == 2025) { // your calendar is fixed to July 2025
//    JLabel lblToday = labels[currentDay - 1]; // subtract 1 since index starts at 0
//    lblToday.setOpaque(true);
//    lblToday.setBackground(Color.BLUE); // or Color.RED
//    lblToday.setForeground(Color.WHITE); // make text visible
//}
//
//if (currentMonth == 7 && currentYear == 2025) {
//    switch (currentDay) {
//        case 1: lbl1.setOpaque(true); lbl1.setBackground(Color.BLUE); lbl1.setForeground(Color.WHITE); break;
//        case 2: lbl2.setOpaque(true); lbl2.setBackground(Color.BLUE); lbl2.setForeground(Color.WHITE); break;
//        // ... repeat till 31
//    }
//}
}
