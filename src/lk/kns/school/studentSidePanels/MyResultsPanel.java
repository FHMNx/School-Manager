package lk.kns.school.studentSidePanels;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.kns.school.connection.MySQL;
import lk.kns.school.util.Session;
import raven.toast.Notifications;

public class MyResultsPanel extends javax.swing.JPanel {

    private HashMap<String, Integer> termMap = new HashMap<>();

    public MyResultsPanel() {
        initComponents();
        init();
        loadTerms();
    }

    private void init() {
        downloadReportBtn.setEnabled(false);
        downloadReportBtn.setToolTipText("Report downloading will be available soon.");
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
            termFilterCombo.setModel(new DefaultComboBoxModel<>(v));

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        termFilterCombo = new javax.swing.JComboBox<>();
        filterBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultsTable = new javax.swing.JTable();
        downloadReportBtn = new javax.swing.JButton();

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
                    .addComponent(downloadReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                .addComponent(termFilterCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(filterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filterBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(termFilterCombo))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(downloadReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBtnActionPerformed
        String selectedTerm = termFilterCombo.getSelectedItem().toString();

        if (selectedTerm.equals("Select a Term")) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 2000, "Please select a term to view results.");
            return;
        }

        int termId = termMap.get(selectedTerm);

        try {
            String query = "SELECT s.subject_name, t.term_name, sr.marks "
                    + "FROM `student_result` sr "
                    + "INNER JOIN `subject` s ON sr.subject_id = s.subject_id "
                    + "INNER JOIN `term` t ON sr.term_id = t.term_id "
                    + "WHERE sr.student_id = '" + Session.studentId + "' AND sr.term_id = '" + termId + "'";

            ResultSet rs = MySQL.execute(query);

            DefaultTableModel dtm = (DefaultTableModel) resultsTable.getModel();
            dtm.setRowCount(0);

            int rowCount = 1;
            while (rs.next()) {
                Vector<String> v = new Vector<>();
                v.add(String.valueOf(rowCount++));
                v.add(rs.getString("subject_name"));
                v.add(rs.getString("term_name"));

                double marks = rs.getDouble("marks");
                v.add(String.valueOf(marks));
                v.add(calculateGrade(marks));

                dtm.addRow(v);
            }

            if (dtm.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No results found for " + selectedTerm + ".", "No Data", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error loading results.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_filterBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton downloadReportBtn;
    private javax.swing.JButton filterBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable resultsTable;
    private javax.swing.JComboBox<String> termFilterCombo;
    // End of variables declaration//GEN-END:variables
}
