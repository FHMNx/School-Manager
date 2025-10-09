package lk.kns.school.adminSidePanels;

import com.formdev.flatlaf.FlatClientProperties;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import lk.kns.school.connection.MySQL;
import raven.toast.Notifications;

public class ClassPanel extends javax.swing.JPanel {

    HashMap<String, Integer> classMap = new HashMap();

    public ClassPanel() {
        initComponents();
        init();
        classLoad();
    }

    private void init() {
        teacherNameInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "teacher name");
        teacherMobileInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "teacher mobile");
        teacherNicInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "teacher nic");
        teacherEmailInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "teacher email");

        classSelect.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        reportBtn.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        statusBtn.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        teacherNameInput.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        teacherMobileInput.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        teacherNicInput.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        teacherEmailInput.putClientProperty(FlatClientProperties.STYLE, "arc:20");
    }

    private void classLoad() {
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `class`");

            classMap.clear();
            Vector<String> v = new Vector();
            v.add("select a class");

            while (rs.next()) {
                int id = rs.getInt("class_id");
                String name = rs.getString("class_name");

                v.add(name);
                classMap.put(name, id);
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            classSelect.setModel(dcm);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        classSelect = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        teacherNameInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        teacherMobileInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        teacherNicInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        teacherEmailInput = new javax.swing.JTextField();
        statusBtn = new javax.swing.JButton();
        reportBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(43, 43, 43));

        classSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classSelectActionPerformed(evt);
            }
        });

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Student Id", "Full Name", "Admission Number", "Contact No ", "Class"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(studentTable);

        jLabel1.setText("Teacher Name :");

        teacherNameInput.setEnabled(false);

        jLabel2.setText("Teacher Mobile :");

        teacherMobileInput.setEnabled(false);

        jLabel3.setText("Teacher NIC :");

        teacherNicInput.setEnabled(false);

        jLabel4.setText("Teacher Email :");

        teacherEmailInput.setEnabled(false);

        statusBtn.setText("status");
        statusBtn.setEnabled(false);

        reportBtn.setText("Generate Report");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(classSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(teacherNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(statusBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(teacherEmailInput)
                                    .addComponent(teacherNicInput)
                                    .addComponent(teacherMobileInput)))))
                    .addComponent(reportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(classSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(teacherNameInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(teacherMobileInput, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(teacherNicInput, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(teacherEmailInput, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(statusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void classSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classSelectActionPerformed
        String selectedCls = (String) classSelect.getSelectedItem();

        if (selectedCls != null && !selectedCls.equals("select a class")) {
            Integer clsId = classMap.get(selectedCls);
            if (clsId != null) {
                loadStudentByClass(clsId);
            } else {
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_LEFT, 2000, "class data not found");
            }
        }
    }//GEN-LAST:event_classSelectActionPerformed

    private void loadStudentByClass(int clsId) {
        try {
            ResultSet rs = MySQL.execute("SELECT `student_id` , `f_name` , `l_name` , `admission_no` , `mobile` , `class_name` "
                    + "FROM `student` INNER JOIN `class` ON `student`.`class_id` = `class`.`class_id` "
                    + "WHERE `student`.`class_id` = '" + clsId + "'");

            DefaultTableModel dtm = (DefaultTableModel) studentTable.getModel();
            dtm.setRowCount(0);

            int rowCount = 1;
            while (rs.next()) {
                Vector<String> v = new Vector();
                v.add(String.valueOf(rowCount));
                v.add(rs.getString("student_id"));
                v.add(rs.getString("f_name") + " " + rs.getString("l_name"));
                v.add(rs.getString("admission_no"));
                v.add(rs.getString("mobile"));
                v.add(rs.getString("class_name"));

                dtm.addRow(v);
                rowCount++;
            }

            ResultSet teacherRs = MySQL.execute("SELECT `f_name` , `l_name` , `mobile` , `nic` , `email` FROM `teacher` "
                    + "INNER JOIN `class` ON `class`.`class_id` = `teacher`.`class_id` "
                    + "WHERE `teacher`.`class_id` = '" + clsId + "'");

            if (teacherRs.next()) {
                String teacherName = teacherRs.getString("f_name") + " " + teacherRs.getString("l_name");
                teacherNameInput.setText(teacherName);
                teacherMobileInput.setText(teacherRs.getString("mobile"));
                teacherNicInput.setText(teacherRs.getString("nic"));
                teacherEmailInput.setText(teacherRs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> classSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reportBtn;
    private javax.swing.JButton statusBtn;
    private javax.swing.JTable studentTable;
    private javax.swing.JTextField teacherEmailInput;
    private javax.swing.JTextField teacherMobileInput;
    private javax.swing.JTextField teacherNameInput;
    private javax.swing.JTextField teacherNicInput;
    // End of variables declaration//GEN-END:variables
}
