package lk.kns.school.teacherSidePanels;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.io.File;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.kns.school.connection.MySQL;
import lk.kns.school.util.Session;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentPanel extends javax.swing.JPanel {
    
    private static final Logger LOGGER = Logger.getLogger(StudentPanel.class.getName());

    public StudentPanel() {
        initComponents();
        init();
        loadStudentData();
        loadClassName();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchTextInput = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        refreshLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        reportBtn = new javax.swing.JButton();
        gradeLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(43, 43, 43));

        searchTextInput.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        searchBtn.setText("Search");
        searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        refreshLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshLabelMouseClicked(evt);
            }
        });

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "First Name", "Last Name", "Admission No", "Email", "Mobile", "Class", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(studentTable);

        reportBtn.setText("Generate Report");
        reportBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportBtnActionPerformed(evt);
            }
        });

        gradeLabel.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        gradeLabel.setForeground(new java.awt.Color(170, 170, 160));
        gradeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchTextInput, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                        .addComponent(gradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(refreshLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(reportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(refreshLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchTextInput)
                    .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(gradeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void init() {
        refreshLabel.setIcon(new FlatSVGIcon("lk/kns/school/image/refresh.svg", 20, 20));

        searchTextInput.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        searchBtn.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        reportBtn.putClientProperty(FlatClientProperties.STYLE, "arc:20");

        searchTextInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "search by student name or admission number");
    }

    private void loadClassName() {
        try {
            ResultSet rs = MySQL.execute("SELECT `class_name` FROM `class` WHERE `class_id` = '" + Session.classId + "'");
            if (rs.next()) {
                gradeLabel.setText(rs.getString("class_name"));
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error loading class name. ", e);
        }
    }

    public void loadStudentData() {
        try {
            int classId = Session.classId;

            ResultSet rs = MySQL.execute("SELECT * FROM `student` INNER JOIN `user` ON `student`.`user_id` = `user`.`user_id` "
                    + "INNER JOIN `class` ON `student`.`class_id` = `class`.`class_id`"
                    + "INNER JOIN `status` ON `student`.`status_id` = `status`.`status_id` "
                    + "WHERE `student`.`class_id` = '" + classId + "'");

            gradeLabel.setText("");
            DefaultTableModel dtm = (DefaultTableModel) studentTable.getModel();
            dtm.setRowCount(0);

            int rowCount = 1;
            while (rs.next()) {
                Vector<String> v = new Vector();
                v.add(String.valueOf(rowCount));

                v.add(rs.getString("f_name"));
                v.add(rs.getString("l_name"));
                v.add(rs.getString("admission_no"));
                v.add(rs.getString("student.email"));
                v.add(rs.getString("mobile"));
                v.add(rs.getString("class.class_name"));
                v.add(rs.getString("status.status_name"));

                dtm.addRow(v);
                rowCount++;
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error loading student data. ", e);
        }
    }

    private void refreshLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshLabelMouseClicked
        loadStudentData();
        loadClassName();
    }//GEN-LAST:event_refreshLabelMouseClicked

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String searchText = searchTextInput.getText().trim();

        try {
            String query;
            if (searchText.isEmpty()) {
                query = "SELECT * FROM `student` INNER JOIN `user` ON `student`.`user_id` = `user`.`user_id` "
                        + "INNER JOIN `class` ON `student`.`class_id` = `class`.`class_id`"
                        + "INNER JOIN `status` ON `student`.`status_id` = `status`.`status_id` "
                        + "WHERE `student`.`class_id` = '" + Session.classId + "'";
            } else {
                query = "SELECT * FROM `user` "
                        + "INNER JOIN `student` ON `student`.`user_id` = `user`.`user_id` "
                        + "INNER JOIN `class` ON `student`.`class_id` = `class`.`class_id` "
                        + "INNER JOIN `status` ON `student`.`status_id` = `status`.`status_id` "
                        + "WHERE (`student`.`admission_no` = '" + searchText + "' "
                        + "OR `student`.`f_name` LIKE '%" + searchText + "%' "
                        + "OR `student`.`l_name` LIKE '%" + searchText + "%') AND`student`.`class_id` = '" + Session.classId + "'";
            }

            ResultSet rs = MySQL.execute(query);
            DefaultTableModel dtm = (DefaultTableModel) studentTable.getModel();
            dtm.setRowCount(0);

            int rowCount = 1;
            while (rs.next()) {
                Vector<String> v = new Vector();
                v.add(String.valueOf(rowCount));

                v.add(rs.getString("f_name"));
                v.add(rs.getString("l_name"));
                v.add(rs.getString("admission_no"));
                v.add(rs.getString("student.email"));
                v.add(rs.getString("student.mobile"));
                v.add(rs.getString("class.class_name"));
                v.add(rs.getString("status.status_name"));

                dtm.addRow(v);
                rowCount++;
            }

        } catch (SQLException e) {
           LOGGER.log(Level.SEVERE, "Error searching data. ", e);
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void reportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Excel Report");
        javax.swing.filechooser.FileNameExtensionFilter filter = new javax.swing.filechooser.FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();

            if (!filePath.toLowerCase().endsWith(".xlsx")) {
                filePath += ".xlsx";
            }

            try {
                // Create a new Workbook and Sheet
                org.apache.poi.ss.usermodel.Workbook workbook = new org.apache.poi.xssf.usermodel.XSSFWorkbook();
                org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Student Details");

                DefaultTableModel dtm = (DefaultTableModel) studentTable.getModel();

                // Create the Header Row
                org.apache.poi.ss.usermodel.Row headerRow = sheet.createRow(0);
                for (int i = 0; i < dtm.getColumnCount(); i++) {
                    org.apache.poi.ss.usermodel.Cell cell = headerRow.createCell(i);
                    cell.setCellValue(dtm.getColumnName(i));
                }

                // Extract Data from JTable to Excel Sheet
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    org.apache.poi.ss.usermodel.Row row = sheet.createRow(i + 1);
                    for (int j = 0; j < dtm.getColumnCount(); j++) {
                        org.apache.poi.ss.usermodel.Cell cell = row.createCell(j);
                        Object value = dtm.getValueAt(i, j);
                        if (value != null) {
                            cell.setCellValue(value.toString());
                        }
                    }
                }

                // Write the output to a file
                try (java.io.FileOutputStream out = new java.io.FileOutputStream(filePath)) {
                    workbook.write(out);
                }
                workbook.close();
                JOptionPane.showMessageDialog(this, "Excel Report Generated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                LOGGER.info("Excel Report Generated Successfully!");
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error generating report:. ", e);
                JOptionPane.showMessageDialog(this, "Error generating report: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_reportBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gradeLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel refreshLabel;
    private javax.swing.JButton reportBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchTextInput;
    private javax.swing.JTable studentTable;
    // End of variables declaration//GEN-END:variables
}
