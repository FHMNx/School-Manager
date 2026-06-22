package lk.kns.school.teacherSidePanels;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.kns.school.connection.MySQL;
import lk.kns.school.util.Session;
import raven.toast.Notifications;

public class ClassManagementPanel extends javax.swing.JPanel {

    public ClassManagementPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        dateChoose = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        attendanceTable = new javax.swing.JTable();
        saveAttentanceBtn = new javax.swing.JButton();
        loadStudentBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        noticeTitleInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        noticeMessageInput = new javax.swing.JTextArea();
        publishNoticeBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(43, 43, 43));

        jLabel1.setText("Choose Date");

        attendanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Student ID", "Student Name", "Present"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(attendanceTable);

        saveAttentanceBtn.setText("Save Attendance");
        saveAttentanceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAttentanceBtnActionPerformed(evt);
            }
        });

        loadStudentBtn.setText("Load Students");
        loadStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadStudentBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveAttentanceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dateChoose, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(loadStudentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1034, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loadStudentBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateChoose, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveAttentanceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Daily Attendance Tracker", jPanel1);

        jLabel2.setText("Announcement Title:");

        jLabel3.setText("Message / Details:");

        noticeMessageInput.setColumns(20);
        noticeMessageInput.setRows(5);
        jScrollPane2.setViewportView(noticeMessageInput);

        publishNoticeBtn.setText("Publish Announcement");
        publishNoticeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publishNoticeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(publishNoticeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
                            .addComponent(noticeTitleInput))))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(noticeTitleInput, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(publishNoticeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Class Announcements & Materials", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadStudentBtnActionPerformed
        Date selectedDate = dateChoose.getDate();

        if (selectedDate == null) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 2000, "Please choose a date first.");
            return;
        }

        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(selectedDate);

        try {
            ResultSet rs = MySQL.execute("SELECT `student_id`, `f_name`, `l_name` FROM `student` WHERE `class_id` = '" + Session.classId + "'");
            DefaultTableModel dtm = (DefaultTableModel) attendanceTable.getModel();
            dtm.setRowCount(0);

            int rowCount = 1;

            while (rs.next()) {
                String sId = rs.getString("student_id");
                String sName = rs.getString("f_name") + " " + rs.getString("l_name");
                boolean isPresent = false;

                ResultSet attRs = MySQL.execute("SELECT `status` FROM `attendance` WHERE `student_id` = '" + sId + "' AND `date` = '" + formattedDate + "'");
                if (attRs.next()) {
                    if (attRs.getString("status").equals("Present")) {
                        isPresent = true;
                    }
                }
                Vector v = new Vector();
                v.add(rowCount++);
                v.add(sId);
                v.add(sName);
                v.add(isPresent);
                dtm.addRow(v);
            }

            if (dtm.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No students found in your class.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_loadStudentBtnActionPerformed

    private void saveAttentanceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAttentanceBtnActionPerformed
        Date selectedDate = dateChoose.getDate();
        if (selectedDate == null) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 2000, "Please choose a date first.");
            return;
        }

        DefaultTableModel dtm = (DefaultTableModel) attendanceTable.getModel();
        if (dtm.getRowCount() == 0) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 2000, "Please load students first.");
            return;
        }

        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(selectedDate);

        try {
            for (int i = 0; i < dtm.getRowCount(); i++) {
                String sId = dtm.getValueAt(i, 1).toString();
                boolean isPresent = (boolean) dtm.getValueAt(i, 3);
                String status = isPresent ? "Present" : "Absent";

                // Check if a record already exists so we know whether to UPDATE or INSERT
                ResultSet rs = MySQL.execute("SELECT * FROM `attendance` WHERE `student_id` = '" + sId + "' AND `date` = '" + formattedDate + "'");

                if (rs.next()) {
                    MySQL.execute("UPDATE `attendance` SET `status` = '" + status + "' WHERE `student_id` = '" + sId + "' AND `date` = '" + formattedDate + "'");
                } else {
                    MySQL.execute("INSERT INTO `attendance` (`student_id`, `date`, `status`) VALUES ('" + sId + "', '" + formattedDate + "', '" + status + "')");
                }
            }

            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 2000, "Attendance saved successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveAttentanceBtnActionPerformed

    private void publishNoticeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishNoticeBtnActionPerformed
        String title = noticeTitleInput.getText().trim();
        String message = noticeMessageInput.getText().trim();

        if (title.isEmpty() || message.isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 2000, "Please fill in both title and message.");
            return;
        }

        String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        try {
            MySQL.execute("INSERT INTO `announcement` (`teacher_id`, `class_id`, `title`, `message`, `date_posted`) VALUES ('"
                    + Session.teacherId + "', '" + Session.classId + "', '" + title + "', '" + message + "', '" + todayDate + "')");

            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 2000, "Announcement published to class!");
            noticeTitleInput.setText("");
            noticeMessageInput.setText("");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_publishNoticeBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable attendanceTable;
    private com.toedter.calendar.JDateChooser dateChoose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton loadStudentBtn;
    private javax.swing.JTextArea noticeMessageInput;
    private javax.swing.JTextField noticeTitleInput;
    private javax.swing.JButton publishNoticeBtn;
    private javax.swing.JButton saveAttentanceBtn;
    // End of variables declaration//GEN-END:variables
}
