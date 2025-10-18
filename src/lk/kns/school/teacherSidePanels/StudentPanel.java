package lk.kns.school.teacherSidePanels;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import lk.kns.school.connection.MySQL;
import lk.kns.school.util.Session;

public class StudentPanel extends javax.swing.JPanel {


    public StudentPanel() {
        initComponents();
        init();
        loadStudentData();
    }

    private void init() {
        refreshLabel.setIcon(new FlatSVGIcon("lk/kns/school/image/refresh.svg", 20, 20));
        
        searchTextInput.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        searchBtn.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        reportBtn.putClientProperty(FlatClientProperties.STYLE, "arc:20");

        searchTextInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "search by student name or admission number");
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
                "No", "User ID", "Student ID", "First Name", "Last Name", "Admission No", "Email", "Password", "Mobile", "Class", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, true
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                        .addComponent(gradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    public void loadStudentData() {
        try {
            int classId = Session.classId;
            
            ResultSet rs = MySQL.execute("SELECT * FROM `student` INNER JOIN `user` ON `student`.`user_id` = `user`.`user_id` "
                    + "INNER JOIN `teacher` ON `student`.`class_id` = `teacher`.`class_id` "
                    + "INNER JOIN `class` ON `student`.`class_id` = `class`.`class_id`"
                    + "INNER JOIN `status` ON `student`.`status_id` = `status`.`status_id` "
                    + "WHERE `class`.`class_id` = '"+classId+"'");

            DefaultTableModel dtm = (DefaultTableModel) studentTable.getModel();
            dtm.setRowCount(0);

            int rowCount = 1;
            while (rs.next()) {
                Vector<String> v = new Vector();
                v.add(String.valueOf(rowCount));
                v.add(rs.getString("user.user_id"));
                v.add(rs.getString("student_id"));
                v.add(rs.getString("f_name"));
                v.add(rs.getString("l_name"));
                v.add(rs.getString("admission_no"));
                v.add(rs.getString("student.email"));
                v.add(rs.getString("student.password"));
                v.add(rs.getString("mobile"));
                v.add(rs.getString("class.class_name"));
                v.add(rs.getString("status.status_name"));

                dtm.addRow(v);
                rowCount++;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void refreshLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshLabelMouseClicked
        loadStudentData();
    }//GEN-LAST:event_refreshLabelMouseClicked

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String searchText = searchTextInput.getText().trim();

        try {
            String query;
            if (searchText.isEmpty()) {
                query = "SELECT * FROM `user` "
                        + "INNER JOIN `student` ON `student`.`user_id` = `user`.`user_id` "
                        + "INNER JOIN `class` ON `student`.`class_id` = `class`.`class_id` "
                        + "INNER JOIN `status` ON `student`.`status_id` = `status`.`status_id`";
            } else {
                query = "SELECT * FROM `user` "
                        + "INNER JOIN `student` ON `student`.`user_id` = `user`.`user_id` "
                        + "INNER JOIN `class` ON `student`.`class_id` = `class`.`class_id` "
                        + "INNER JOIN `status` ON `student`.`status_id` = `status`.`status_id` "
                        + "WHERE (`student`.`admission_no` = '" + searchText + "' "
                        + "OR `student`.`f_name` LIKE '%" + searchText + "%' "
                        + "OR `student`.`l_name` LIKE '%" + searchText + "%')";
            }

            ResultSet rs = MySQL.execute(query);
            DefaultTableModel dtm = (DefaultTableModel) studentTable.getModel();
            dtm.setRowCount(0);

            int rowCount = 1;
            while (rs.next()) {
                Vector<String> v = new Vector();
                v.add(String.valueOf(rowCount));
                v.add(rs.getString("user.user_id"));
                v.add(rs.getString("student.student_id"));
                v.add(rs.getString("f_name"));
                v.add(rs.getString("l_name"));
                v.add(rs.getString("admission_no"));
                v.add(rs.getString("student.email"));
                v.add(rs.getString("student.password"));
                v.add(rs.getString("student.mobile"));
                v.add(rs.getString("class.class_name"));
                v.add(rs.getString("status.status_name"));

                dtm.addRow(v);
                rowCount++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchBtnActionPerformed


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
