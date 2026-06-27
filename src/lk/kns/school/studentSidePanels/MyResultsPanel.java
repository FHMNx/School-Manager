package lk.kns.school.studentSidePanels;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.kns.school.connection.MySQL;
import lk.kns.school.util.Session;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import raven.toast.Notifications;

public class MyResultsPanel extends javax.swing.JPanel {

    private HashMap<String, Integer> termMap = new HashMap<>();

    public MyResultsPanel() {
        initComponents();
        loadTerms();
        loadYears();
    }

    private void loadTerms() {
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `term`");
            Vector<String> v = new Vector<>();
            v.add("Select a Term");
            termMap.clear();

            while (rs.next()) {
                String name = rs.getString("term_name");
                v.add(name);
                termMap.put(name, rs.getInt("term_id"));
            }
            termFilterCombo1.setModel(new DefaultComboBoxModel<>(v));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadYears() {
        int currentYear = Year.now().getValue();
        Vector<String> years = new Vector<>();
        years.add("Select Year");
        for (int i = currentYear - 5; i <= currentYear + 5; i++) {
            years.add(String.valueOf(i));
        }
        selectYear.setModel(new DefaultComboBoxModel<>(years));
    }

    private String calculateGrade(double marks) {
        if (marks >= 75) {
            return "A";
        }
        if (marks >= 65) {
            return "B";
        }
        if (marks >= 50) {
            return "C";
        }
        if (marks >= 35) {
            return "S";
        }
        return "F";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        selectYear = new javax.swing.JComboBox<>();
        filterBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultsTable = new javax.swing.JTable();
        downloadReportBtn = new javax.swing.JButton();
        termFilterCombo1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        totalMarksLabel = new javax.swing.JLabel();
        averageLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(43, 43, 43));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MY ACADEMIC RESULTS");

        filterBtn.setText("View Results");
        filterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Select The Term");

        resultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Subject", "Term", "Marks", "Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(resultsTable);

        downloadReportBtn.setText("Download PDF Report Card");
        downloadReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadReportBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Select The Year");

        statusLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(380, 380, 380))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(totalMarksLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(averageLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(statusLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(downloadReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(termFilterCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(29, 29, 29)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(selectYear, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(462, 462, 462)
                            .addComponent(filterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(termFilterCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectYear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filterBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalMarksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(averageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(downloadReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBtnActionPerformed
        String selectedTerm = termFilterCombo1.getSelectedItem().toString();
        String selectedYear = selectYear.getSelectedItem().toString();

        if (selectedTerm.equals("Select a Term") || selectedYear.equals("Select Year")) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 2000, "Please select both a term and a year to view results.");
            return;
        }

        int termId = termMap.get(selectedTerm);

        try {
            String query = "SELECT s.subject_name, t.term_name, sr.marks "
                    + "FROM `student_result` sr "
                    + "INNER JOIN `subject` s ON sr.subject_id = s.subject_id "
                    + "INNER JOIN `term` t ON sr.term_id = t.term_id "
                    + "WHERE sr.student_id = '" + Session.studentId + "' "
                    + "AND sr.term_id = '" + termId + "' "
                    + "AND sr.exam_year = '" + selectedYear + "'";

            ResultSet rs = MySQL.execute(query);

            DefaultTableModel dtm = (DefaultTableModel) resultsTable.getModel();
            dtm.setRowCount(0);

            int rowCount = 1;
            double totalMarks = 0;
            int subjectCount = 0;
            boolean hasFailedSubject = false;

            while (rs.next()) {
                Vector<String> v = new Vector<>();
                v.add(String.valueOf(rowCount++));
                v.add(rs.getString("subject_name"));
                v.add(rs.getString("term_name"));

                double marks = rs.getDouble("marks");

                totalMarks += marks;
                subjectCount++;

                String grade = calculateGrade(marks);
                if (grade.equals("F")) {
                    hasFailedSubject = true;
                }

                v.add(String.valueOf(marks));
                v.add(grade);

                dtm.addRow(v);
            }

            if (dtm.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No results found for " + selectedTerm + " in " + selectedYear + ".", "No Data", JOptionPane.INFORMATION_MESSAGE);

                totalMarksLabel.setText("Total Marks : 0.00");
                averageLabel.setText("Average : 0.00");

            } else {
                double average = totalMarks / subjectCount;
                String status = (average >= 35 && !hasFailedSubject) ? "PASSED" : "FAILED";

                totalMarksLabel.setText(String.format("Total Marks : %.2f", totalMarks));
                averageLabel.setText(String.format("Average : %.2f", average));

                if (statusLabel != null) {
                    statusLabel.setText(status);
                    if (status.equals("PASSED")) {
                        statusLabel.setForeground(java.awt.Color.GREEN);
                    } else {
                        statusLabel.setForeground(java.awt.Color.RED);
                    }
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error loading results.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_filterBtnActionPerformed

    private void downloadReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadReportBtnActionPerformed
        try {
            InputStream filePath = getClass().getClassLoader().getResourceAsStream("report/my_results_report.jrxml");
            JasperReport report = JasperCompileManager.compileReport(filePath);

            HashMap<String, Object> parameters = new HashMap<>();

            parameters.put("TERM", termFilterCombo1.getSelectedItem().toString());
            parameters.put("YEAR", selectYear.getSelectedItem().toString());
            parameters.put("TOTAL", totalMarksLabel.getText().trim());
            parameters.put("AVERAGE", averageLabel.getText().trim());
            parameters.put("STATUS", statusLabel.getText().trim());

            JRTableModelDataSource jRTableModelDataSource = new JRTableModelDataSource(resultsTable.getModel());
            JasperPrint fillReport = JasperFillManager.fillReport(report, parameters, jRTableModelDataSource);

            JasperViewer.viewReport(fillReport, false);

        } catch (JRException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_downloadReportBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel averageLabel;
    private javax.swing.JButton downloadReportBtn;
    private javax.swing.JButton filterBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable resultsTable;
    private javax.swing.JComboBox<String> selectYear;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JComboBox<String> termFilterCombo1;
    private javax.swing.JLabel totalMarksLabel;
    // End of variables declaration//GEN-END:variables
}
