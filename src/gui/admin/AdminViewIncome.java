/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.admin;
import gui.admin.AdminPage;
import gui.admin.AdminCalendar;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import javax.swing.*;
import java.awt.*;
import tuition.UserSession;
import java.awt.event.*;
import java.util.*;
//import gui.admin.AdminViewIncome;
import gui.admin.AdminViewIncome;


public class AdminViewIncome extends javax.swing.JFrame {
           private String loggedInUser;
          private String currentUsername;

    AdminViewIncome(String username) {
            initComponents(); // sets up the GUI
            this.loggedInUser = username;
            lblName.setText(UserSession.getUsername());
            displayTotalIncome();
            displayTotalPayments();
            displayTotalStudents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        Welcome = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        btnCalender = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblViewIncome = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        btnGenerate = new javax.swing.JButton();
        levelComboBox = new javax.swing.JComboBox<>();
        incomeClearbutton = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        lblPaymentList = new javax.swing.JLabel();
        lblNoPayment = new javax.swing.JLabel();
        btnPaymentList = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        lblTotalStudents = new javax.swing.JLabel();
        lblNoStudents = new javax.swing.JLabel();
        btnTotalStudent = new javax.swing.JButton();
        ChartPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtIncomeDetails = new javax.swing.JTextArea();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(47, 65, 88));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(175, 221, 255));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/ATC_LOGO-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        Welcome.setFont(new java.awt.Font("Rockwell Extra Bold", 3, 35)); // NOI18N
        Welcome.setForeground(new java.awt.Color(221, 168, 83));
        Welcome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Welcome.setText("Welcome,");

        lblName.setFont(new java.awt.Font("Segoe UI Variable", 2, 24)); // NOI18N
        lblName.setForeground(new java.awt.Color(199, 138, 59));
        lblName.setText("Name");

        btnCalender.setBackground(new java.awt.Color(102, 102, 102));
        btnCalender.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnCalender.setForeground(new java.awt.Color(255, 255, 255));
        btnCalender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/admin/icons8-desk-calender-16.png"))); // NOI18N
        btnCalender.setText("Calender");
        btnCalender.setBorder(null);
        btnCalender.setContentAreaFilled(false);
        btnCalender.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCalender.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCalender.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnCalender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalenderActionPerformed(evt);
            }
        });

        btnHome.setBackground(new java.awt.Color(102, 102, 102));
        btnHome.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setText("Home");
        btnHome.setBorder(null);
        btnHome.setContentAreaFilled(false);
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Welcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCalender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(Welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnHome)
                .addGap(30, 30, 30)
                .addComponent(btnCalender)
                .addGap(0, 183, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(161, 179, 203));

        jPanel2.setBackground(new java.awt.Color(28, 96, 129));

        lblViewIncome.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        lblViewIncome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblViewIncome.setText("View Monthly Income");

        lblAmount.setFont(new java.awt.Font("Rockwell", 0, 35)); // NOI18N
        lblAmount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnGenerate.setBackground(new java.awt.Color(88, 160, 200));
        btnGenerate.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        btnGenerate.setText("Generate ➡️");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        levelComboBox.setBackground(new java.awt.Color(109, 147, 178));
        levelComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1","Form 2","Form 3","Form 4","Form 5"}));
        levelComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelComboBoxActionPerformed(evt);
            }
        });

        incomeClearbutton.setBackground(new java.awt.Color(88, 160, 200));
        incomeClearbutton.setText("Clear");
        incomeClearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incomeClearbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(levelComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lblViewIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(incomeClearbutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblViewIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(levelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerate)
                    .addComponent(incomeClearbutton))
                .addContainerGap())
        );

        btnBack.setBackground(new java.awt.Color(161, 179, 203));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons8-go-back.gif"))); // NOI18N
        btnBack.setBorder(null);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(28, 96, 129));

        lblPaymentList.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        lblPaymentList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPaymentList.setText("Payment List");

        lblNoPayment.setFont(new java.awt.Font("Rockwell", 0, 60)); // NOI18N
        lblNoPayment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnPaymentList.setBackground(new java.awt.Color(88, 160, 200));
        btnPaymentList.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        btnPaymentList.setText("More Details ➡️");
        btnPaymentList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNoPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPaymentList, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(btnPaymentList, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPaymentList, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lblNoPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPaymentList)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(28, 96, 129));

        lblTotalStudents.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        lblTotalStudents.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalStudents.setText("Total Students");

        lblNoStudents.setFont(new java.awt.Font("Rockwell", 0, 60)); // NOI18N
        lblNoStudents.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnTotalStudent.setBackground(new java.awt.Color(88, 160, 200));
        btnTotalStudent.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        btnTotalStudent.setText("More Details ➡️");
        btnTotalStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lblNoStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(lblTotalStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(btnTotalStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotalStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNoStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTotalStudent)
                .addContainerGap())
        );

        txtIncomeDetails.setColumns(20);
        txtIncomeDetails.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtIncomeDetails.setRows(5);
        jScrollPane1.setViewportView(txtIncomeDetails);

        javax.swing.GroupLayout ChartPanelLayout = new javax.swing.GroupLayout(ChartPanel);
        ChartPanel.setLayout(ChartPanelLayout);
        ChartPanelLayout.setHorizontalGroup(
            ChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChartPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(442, Short.MAX_VALUE))
        );
        ChartPanelLayout.setVerticalGroup(
            ChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChartPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ChartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnBack))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnBack)
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ChartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        new AdminPage().setVisible(true); // Go back to Admin Dashboard
        this.dispose(); // Close the current Tutor page
    }//GEN-LAST:event_btnBackActionPerformed

    
    private void displayTotalIncome() {
                try (BufferedReader reader = new BufferedReader(new FileReader("data/view_income_reports.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.startsWith("Total Income:")) {
                            String[] parts = line.split("RM");
                            if (parts.length > 1) {
                                lblAmount.setText("RM " + parts[1].trim());
                            }
                            break;
                        }
                    }
                } catch (IOException e) {
                    lblAmount.setText("Error");
                    e.printStackTrace();
                }
            }


                private void drawChart(String getSelectedItem) {
                        String selectedLevel = (String) levelComboBox.getSelectedItem();
                            Map<String, Integer> subjectIncome = readIncomeData(selectedLevel);

                ChartPanel.removeAll();
                System.out.println("Selected Level: " + selectedLevel);
                System.out.println("Income Data: " + subjectIncome);

                for (Map.Entry<String, Integer> entry : subjectIncome.entrySet()) {
                    // your chart code here

            }
//            Map<String, Integer> subjectIncome = readIncomeData(selectedLevel);
//
//            ChartPanel.removeAll();
//            System.out.println("Selected Level: " + selectedLevel);
//            System.out.println("Income Data: " + subjectIncome);
//            for (Map.Entry<String, Integer> entry : subjectIncome.entrySet()) {
//                String subject = entry.getKey();
//                int income = entry.getValue();
//
//                JPanel barPanel = new JPanel(new BorderLayout());
//
//                JLabel bar = new JLabel();
//                bar.setPreferredSize(new Dimension(40, income / 2)); // scale height
//                bar.setOpaque(true);
//                bar.setBackground(Color.BLUE);
//
//                JLabel label = new JLabel(subject, SwingConstants.CENTER);
//
//                barPanel.add(bar, BorderLayout.CENTER);
//                barPanel.add(label, BorderLayout.SOUTH);
//
//                ChartPanel.add(barPanel);
//            }
//
//            ChartPanel.revalidate();
//            ChartPanel.repaint();
        }

            public Map<String, Integer> readIncomeData(String selectedLevel) {
            Map<String, Integer> subjectIncome = new LinkedHashMap<>();
            boolean levelMatched = false;

            try (BufferedReader br = new BufferedReader(new FileReader("data/income_by_level_subject.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    line = line.trim();

                    // Check for level match
                    if (line.equalsIgnoreCase("Level: " + selectedLevel)) {
                        levelMatched = true;
                        continue;
                    }

                    // Stop if another level starts
                    if (levelMatched && line.startsWith("Level: ")) {
                        break;
                    }

                    // Read subjects under the matched level
                    if (levelMatched && line.startsWith("Subject:")) {
                        String[] parts = line.split(",");
                        if (parts.length == 2) {
                            String subject = parts[0].replace("Subject:", "").trim();
                            int income = Integer.parseInt(parts[1].replace("Total Income:", "").trim());
                            subjectIncome.put(subject, income);
                        }
                    }
                }
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }

            return subjectIncome;
        }
            
            
    private void updateIncomeReport() {
    String selectedForm = (String) levelComboBox.getSelectedItem();
    if (selectedForm == null) return;

    StringBuilder report = new StringBuilder();
    boolean isInSelectedLevel = false;

    try (BufferedReader reader = new BufferedReader(new FileReader("data/income_by_level_subject.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();

            if (line.startsWith("Level: ")) {
                isInSelectedLevel = line.contains(selectedForm);
                continue;
            }

            if (line.startsWith("Subject:") && isInSelectedLevel) {
                report.append(line).append("\n");
            }

            // Optional: stop reading once next level starts
            if (line.startsWith("Level: ") && !line.contains(selectedForm) && isInSelectedLevel) {
                break;
            }
        }
    } catch (IOException e) {
        report.append("Error reading income data: ").append(e.getMessage());
    }

    txtIncomeDetails.setText(report.toString());
}

    
    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        String selectedForm = levelComboBox.getSelectedItem().toString(); // e.g., "Form 2"
        StringBuilder report = new StringBuilder();
        int totalIncome = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/income_by_level_subject.txt"));
            String line;
            String currentMonth = "N/A";
            boolean inSelectedLevel = false;
            boolean formFound = false;
            boolean headerAdded = false;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                // Skip empty lines
                if (line.isEmpty()) {
                    continue;
                }

                if (line.startsWith("Month:")) {
                    currentMonth = line.substring("Month:".length()).trim();
                    continue;
                }

                if (line.startsWith("Level:")) {
                    // Extract the level from the line
                    String currentLevel = line.substring("Level:".length()).trim();

                    if (currentLevel.equalsIgnoreCase(selectedForm)) {
                        inSelectedLevel = true;
                        formFound = true;

                        // Add header only once when we first find the selected form
                        if (!headerAdded) {
                            report.append("Income Report for ").append(selectedForm)
                                  .append(" – Month: ").append(currentMonth).append("\n\n");
                            headerAdded = true;
                        }
                    } else {
                        // If we were processing the selected level and now found a different level,
                        // we can stop processing since we've found all data for our selected form
                        if (inSelectedLevel && formFound) {
                            break;
                        }
                        inSelectedLevel = false;
                    }
                    continue;
                }

                // Only process subject lines if we're in the correct level
                if (inSelectedLevel && line.startsWith("Subject:")) {
                    try {
                        // Handle both formats: "Subject: Math, Total Income: 360" or "Subject: Math | Total Income: 360"
                        String[] parts;
                        if (line.contains("|")) {
                            parts = line.split("\\|");
                        } else if (line.contains(",")) {
                            parts = line.split(",");
                        } else {
                            continue; // Skip malformed lines
                        }

                        if (parts.length >= 2) {
                            String subject = parts[0].replace("Subject:", "").trim();
                            String incomeStr = parts[1].replace("Total Income:", "").trim();
                            int income = Integer.parseInt(incomeStr);

                            report.append("Subject: ").append(subject)
                                  .append(" – RM ").append(income).append(".00\n");
                            totalIncome += income;
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing income for line: " + line);
                        continue;
                    }
                }
            }
            reader.close();

            if (formFound && totalIncome > 0) {
                report.append("\nTotal: RM ").append(totalIncome).append(".00");
                txtIncomeDetails.setText(report.toString());
            } else {
                txtIncomeDetails.setText("No income data found for " + selectedForm);
            }

        } catch (IOException e) {
            txtIncomeDetails.setText("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGenerateActionPerformed

    //    ChartPanel.removeAll();
//    ChartPanel.repaint();
//   ChartPanel.revalidate();
//   
//    // Get selected level from combo box
//    String selectedLevel = levelComboBox.getSelectedItem().toString(); // Replace comboBoxLevel with your actual combo box name
//
//    // File path of your income data
//    String filePath = "data/income_by_level_subject.txt";
//
//    // Create and add chart panel
//    adminChart chart = new adminChart(filePath, selectedLevel);
//    JPanel chartPanel = chart.getChartPanel();
//
//    ChartPanel.setLayout(new java.awt.BorderLayout());
//    ChartPanel.add(chartPanel, java.awt.BorderLayout.CENTER);
//    ChartPanel.validate();
    
    // Returns a cute random color for each subject bar
        private Color getRandomColor() {
            Color[] colors = {
                new Color(135, 206, 235), // sky blue
                new Color(255, 182, 193), // pink
                new Color(144, 238, 144), // light green
                new Color(255, 165, 0),   // orange
                new Color(221, 160, 221), // plum
                new Color(255, 255, 102)  // yellow
            };
            Random rand = new Random();
            return colors[rand.nextInt(colors.length)];
        }


    
    private void btnTotalStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalStudentActionPerformed
        // TODO add your handling code here:
            showStudentDetails();
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("data/monthly_student_registration.txt"));
//            StringBuilder content = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                content.append(line).append("\n");
//            }
//            reader.close();
//
//            // Show in a dialog box
//            JTextArea textArea = new JTextArea(content.toString());
//            textArea.setEditable(false);
//            JScrollPane scrollPane = new JScrollPane(textArea);
//            scrollPane.setPreferredSize(new Dimension(500, 300));
//
//            JOptionPane.showMessageDialog(null, scrollPane, "Monthly Student Registration", JOptionPane.INFORMATION_MESSAGE);
//
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, "Unable to read report file.", "Error", JOptionPane.ERROR_MESSAGE);
//            ex.printStackTrace();
//        };
    }//GEN-LAST:event_btnTotalStudentActionPerformed

    private void showStudentDetails() {
    JFrame frame = new JFrame("Monthly Student Registration Report");
    frame.setSize(500, 400);

    JTextArea textArea = new JTextArea();
    textArea.setEditable(false);
    textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));

    try (BufferedReader reader = new BufferedReader(new FileReader("data/monthly_student_report.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            textArea.append(line + "\n");
        }
    } catch (IOException e) {
        textArea.setText("Error reading student report.");
        e.printStackTrace();
    }

    JScrollPane scrollPane = new JScrollPane(textArea);
    frame.add(scrollPane);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}

    
    private void displayTotalStudents() {
    try (BufferedReader reader = new BufferedReader(new FileReader("data/monthly_student_report.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("July:")) {
                String[] parts = line.split("students");
                if (parts.length > 0) {
                    String number = parts[0].replace("July:", "").trim();
                    lblNoStudents.setText(number);
                }
                break;
            }
        }
    } catch (IOException e) {
        lblNoStudents.setText("Error");
        e.printStackTrace();
    }
}

    
    
    private void btnCalenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalenderActionPerformed
        // TODO add your handling code here:
        new AdminCalendar().setVisible(true);
    }//GEN-LAST:event_btnCalenderActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHomeActionPerformed

    private void levelComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelComboBoxActionPerformed
        updateIncomeReport(); 
    }//GEN-LAST:event_levelComboBoxActionPerformed

    private void incomeClearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incomeClearbuttonActionPerformed
       txtIncomeDetails.setText("");
    }//GEN-LAST:event_incomeClearbuttonActionPerformed

    private void btnPaymentListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentListActionPerformed
        // TODO add your handling code here:
    showPaymentDetails();
    }//GEN-LAST:event_btnPaymentListActionPerformed

//    private void showPaymentDetails() {
//    JFrame frame = new JFrame("Payment Details");
//    frame.setSize(600, 400);
//    JTextArea textArea = new JTextArea();
//    textArea.setEditable(false);
//
//    try (BufferedReader reader = new BufferedReader(new FileReader("data/monthly_income.txt"))) {
//        String line;
//        while ((line = reader.readLine()) != null) {
//            textArea.append(line + "\n");
//        }
//    } catch (IOException e) {
//        textArea.setText("Error reading payment details.");
//        e.printStackTrace();
//    }
//
//    frame.add(new JScrollPane(textArea));
//    frame.setLocationRelativeTo(null);
//    frame.setVisible(true);
//}
    
    private void showPaymentDetails() {
    JFrame frame = new JFrame("Payment List Details");
    frame.setSize(600, 400);

    JTextArea textArea = new JTextArea();
    textArea.setEditable(false);
    textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

    try (BufferedReader reader = new BufferedReader(new FileReader("data/monthly_income.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            textArea.append(line + "\n");
        }
    } catch (IOException e) {
        textArea.setText("Error reading payment file.");
        e.printStackTrace();
    }

    JScrollPane scrollPane = new JScrollPane(textArea);
    frame.add(scrollPane);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}

    private void displayTotalPayments() {
    int count = 0;
    try (BufferedReader reader = new BufferedReader(new FileReader("data/monthly_income.txt"))) {
        while (reader.readLine() != null) {
            count++;
        }
        lblNoPayment.setText(String.valueOf(count));
    } catch (IOException e) {
        lblNoPayment.setText("Error");
        e.printStackTrace();
    }
}

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminViewIncome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminViewIncome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminViewIncome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminViewIncome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminViewIncome(UserSession.getUsername()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChartPanel;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Welcome;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCalender;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnPaymentList;
    private javax.swing.JButton btnTotalStudent;
    private javax.swing.JButton incomeClearbutton;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNoPayment;
    private javax.swing.JLabel lblNoStudents;
    private javax.swing.JLabel lblPaymentList;
    private javax.swing.JLabel lblTotalStudents;
    private javax.swing.JLabel lblViewIncome;
    private javax.swing.JComboBox<String> levelComboBox;
    private javax.swing.JTextArea txtIncomeDetails;
    // End of variables declaration//GEN-END:variables
}

