package lk.kns.school.adminSidePanels;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.kns.school.connection.MySQL;
import lk.kns.school.adminDialog.addTeacherDialog;
import lk.kns.school.adminDialog.deleteTeacherDialog;
import lk.kns.school.adminDialog.editTeacherDialog;

public class TeacherPanel extends javax.swing.JPanel {

    private int selectedUserId;
    private int selectedTeacherId;
    private String selectedFname;
    private String selectedLname;
    private String selectedNic;
    private String selectedEmail;
    private String selectedPassword;
    private String selectedMobile;
    private String selectedEmpType;
    private String selectedStatus;

    public TeacherPanel() {
        initComponents();
        init();
        loadTeacherTable();
        getTableRow();
    }

    private void init() {
        refreshLabel.setIcon(new FlatSVGIcon("lk/kns/school/image/refresh.svg", 20, 20));
        addLabel.setIcon(new FlatSVGIcon("lk/kns/school/image/add.svg", 20, 20));
        editLabel.setIcon(new FlatSVGIcon("lk/kns/school/image/edit.svg", 20, 20));
        deleteLabel.setIcon(new FlatSVGIcon("lk/kns/school/image/delete.svg", 20, 20));

        searchTextInput.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        searchBtn.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        getExcelReport.putClientProperty(FlatClientProperties.STYLE, "arc:20");

        searchTextInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search By Teacher Id or Teacher Name");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchTextInput = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        teacherTable = new javax.swing.JTable();
        deleteLabel = new javax.swing.JLabel();
        refreshLabel = new javax.swing.JLabel();
        addLabel = new javax.swing.JLabel();
        editLabel = new javax.swing.JLabel();
        getExcelReport = new javax.swing.JButton();

        setBackground(new java.awt.Color(43, 43, 43));
        setPreferredSize(new java.awt.Dimension(1213, 606));

        searchTextInput.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        searchBtn.setText("Search");
        searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        teacherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "User ID", "Teacher ID", "First Name", "Last Name", "NIC", "Email", "Portal Password", "Mobile Number", "Employment Type", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(teacherTable);

        deleteLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteLabelMouseClicked(evt);
            }
        });

        refreshLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshLabelMouseClicked(evt);
            }
        });

        addLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addLabelMouseClicked(evt);
            }
        });

        editLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editLabelMouseClicked(evt);
            }
        });

        getExcelReport.setText("Generate Report");
        getExcelReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getExcelReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getExcelReportActionPerformed(evt);
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(getExcelReport, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 933, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchTextInput)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(getExcelReport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void loadTeacherTable() {
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `teacher` INNER JOIN `status` ON `teacher`.`status_id` = `status`.`status_id` "
                    + "INNER JOIN `employment_type` ON `teacher`.`empType_id` = `employment_type`.`empType_id` "
                    + "INNER JOIN `user` ON `teacher`.`user_id` = `user`.`user_id`");

            DefaultTableModel dtm = (DefaultTableModel) teacherTable.getModel();
            dtm.setRowCount(0);

            int rowCount = 1;
            while (rs.next()) {
                Vector<String> vData = new Vector();
                vData.add(String.valueOf(rowCount));
                vData.add(rs.getString("user.user_id"));
                vData.add(rs.getString("teacher.teacher_id"));
                vData.add(rs.getString("f_name"));
                vData.add(rs.getString("l_name"));
                vData.add(rs.getString("nic"));
                vData.add(rs.getString("teacher.email"));
                vData.add(rs.getString("teacher.password"));
                vData.add(rs.getString("teacher.mobile"));
                vData.add(rs.getString("employment_type.type_name"));
                vData.add(rs.getString("status.status_name"));

                dtm.addRow(vData);
                rowCount++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getTableRow() {
        teacherTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = teacherTable.getSelectedRow();
                if (row != -1) {
                    selectedUserId = Integer.parseInt(teacherTable.getValueAt(row, 1).toString());
                    selectedTeacherId = Integer.parseInt(teacherTable.getValueAt(row, 2).toString());
                    selectedFname = teacherTable.getValueAt(row, 3).toString();
                    selectedLname = teacherTable.getValueAt(row, 4).toString();
                    selectedNic = teacherTable.getValueAt(row, 5).toString();
                    selectedEmail = teacherTable.getValueAt(row, 6).toString();
                    selectedPassword = teacherTable.getValueAt(row, 7).toString();
                    selectedMobile = teacherTable.getValueAt(row, 8).toString();
                    selectedEmpType = teacherTable.getValueAt(row, 9).toString();
                    selectedStatus = teacherTable.getValueAt(row, 10).toString();
                }
            }

        });
    }

    private void addLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addLabelMouseClicked
        addTeacherDialog dialog = new addTeacherDialog(new JFrame(), true, this);
        dialog.setVisible(true);
    }//GEN-LAST:event_addLabelMouseClicked

    private void refreshLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshLabelMouseClicked
        loadTeacherTable();
    }//GEN-LAST:event_refreshLabelMouseClicked

    private void editLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editLabelMouseClicked
        if (selectedUserId == 0) {
            JOptionPane.showMessageDialog(this, "Please select a row first.");
            return;
        }

        editTeacherDialog dialog = new editTeacherDialog(new JFrame(), true, this);
        dialog.setTeacherData(selectedUserId, selectedTeacherId, selectedFname, selectedLname, selectedNic, selectedEmail, selectedPassword, selectedMobile, selectedEmpType, selectedStatus);
        dialog.setVisible(true);
    }//GEN-LAST:event_editLabelMouseClicked

    private void deleteLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteLabelMouseClicked
        if (selectedUserId == 0) {
            JOptionPane.showMessageDialog(this, "please select a row first");
            return;
        }

        deleteTeacherDialog dialog = new deleteTeacherDialog(new JFrame(), true, this);
        dialog.setManagerData(selectedUserId, selectedTeacherId, selectedFname, selectedLname, selectedNic, selectedEmail, selectedPassword, selectedMobile, selectedEmpType, selectedStatus);
        dialog.setVisible(true);
    }//GEN-LAST:event_deleteLabelMouseClicked

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String searchText = searchTextInput.getText().trim();

        try {
            String query;
            if (searchText.isEmpty()) {
                query = "SELECT * FROM `user` "
                        + "INNER JOIN `teacher` ON `teacher`.`user_id` = `user`.`user_id` "
                        + "INNER JOIN `employment_type` ON `teacher`.`empType_id` = `employment_type`.`empType_id` "
                        + "INNER JOIN `status` ON `teacher`.`status_id` = `status`.`status_id`";
            } else {
                query = "SELECT * FROM `user` "
                        + "INNER JOIN `teacher` ON `teacher`.`user_id` = `user`.`user_id` "
                        + "INNER JOIN `employment_type` ON `teacher`.`empType_id` = `employment_type`.`empType_id` "
                        + "INNER JOIN `status` ON `teacher`.`status_id` = `status`.`status_id` "
                        + "WHERE (`teacher`.`teacher_id` = '" + searchText + "' "
                        + "OR `teacher`.`f_name` LIKE '%" + searchText + "%' "
                        + "OR `teacher`.`l_name` LIKE '%" + searchText + "%')";
            }

            ResultSet rs = MySQL.execute(query);
            DefaultTableModel dtm = (DefaultTableModel) teacherTable.getModel();
            dtm.setRowCount(0);

            int rowCount = 1;
            while (rs.next()) {
                Vector<String> v = new Vector();
                v.add(String.valueOf(rowCount));
                v.add(rs.getString("user.user_id"));
                v.add(rs.getString("teacher.teacher_id"));
                v.add(rs.getString("f_name"));
                v.add(rs.getString("l_name"));
                v.add(rs.getString("nic"));
                v.add(rs.getString("teacher.email"));
                v.add(rs.getString("teacher.password"));
                v.add(rs.getString("teacher.mobile"));
                v.add(rs.getString("employment_type.type_name"));
                v.add(rs.getString("status.status_name"));

                dtm.addRow(v);
                rowCount++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void getExcelReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getExcelReportActionPerformed
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
                org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Teacher Details");
                
                DefaultTableModel dtm = (DefaultTableModel) teacherTable.getModel();
                
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
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error generating report: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_getExcelReportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addLabel;
    private javax.swing.JLabel deleteLabel;
    private javax.swing.JLabel editLabel;
    private javax.swing.JButton getExcelReport;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel refreshLabel;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchTextInput;
    private javax.swing.JTable teacherTable;
    // End of variables declaration//GEN-END:variables
}
