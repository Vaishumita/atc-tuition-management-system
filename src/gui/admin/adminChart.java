/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;



/**
 *
 * @author 60193
 */
        public class adminChart {
            private String filePath;
            private String selectedLevel;

    public adminChart(String filePath, String selectedLevel) {
        this.filePath = filePath;
       this.selectedLevel = selectedLevel;
    }

    public JPanel getChartPanel() {
        DefaultCategoryDataset dataset = loadData();

        JFreeChart chart = ChartFactory.createBarChart(
                "Income by Level and Subject",
                "Level - Subject",
                "Amount (RM)",
                dataset
        );

        chart.setBackgroundPaint(Color.white);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(600, 300));
        chartPanel.setBackground(Color.white);

        return chartPanel;
    }

    private DefaultCategoryDataset loadData() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<String, Double> incomeData = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String level = parts[0].trim();
                    String subject = parts[1].trim();
                    double income = Double.parseDouble(parts[2].trim());

                        if (level.equalsIgnoreCase(selectedLevel)) {
                        incomeData.put(subject, income);
                    
//                    String key = level + " - " + subject;
//                    incomeData.put(key, income);
                }
            }
            }
            for (Map.Entry<String, Double> entry : incomeData.entrySet()) {
                dataset.addValue(entry.getValue(), "Income", entry.getKey());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataset;
    }
}
