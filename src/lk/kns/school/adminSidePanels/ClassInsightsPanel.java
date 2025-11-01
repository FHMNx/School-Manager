package lk.kns.school.adminSidePanels;

import com.formdev.flatlaf.FlatClientProperties;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.kns.school.connection.MySQL;
import lk.kns.school.validation.Validator;

public class ClassInsightsPanel extends javax.swing.JPanel {

    public ClassInsightsPanel() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        classCombo = new javax.swing.JComboBox<>();
        subjectCombo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        teacherCombo = new javax.swing.JComboBox<>();
        addBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        subjectTeacherTable = new javax.swing.JTable();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        classSelect = new javax.swing.JComboBox<>();
        statusBtn = new javax.swing.JButton();
        teacherEmailInput = new javax.swing.JTextField();
        teacherNicInput = new javax.swing.JTextField();
        teacherMobileInput = new javax.swing.JTextField();
        teacherNameInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        reportBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(43, 43, 43));

        jLabel4.setText("Select Class");

        jLabel5.setText("Select Subject");

        jLabel6.setText("Select Teacher");

        addBtn.setText("Appoint");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        subjectTeacherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Class", "Subject", "Teacher"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(subjectTeacherTable);

        jLabel8.setText("Select Class");

        jLabel9.setText("Select Teacher");

        jButton1.setText("Appoint");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Class", "Teacher"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jLabel10.setText("CLASS TEACHER APPOINTMENT");

        jLabel11.setText("SUBJECT TEACHER APPOINTMENT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(classCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(subjectCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(teacherCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3)
                    .addComponent(jSeparator3)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE)
                    .addComponent(jSeparator3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(teacherCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subjectCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(classCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox8))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        jTabbedPane1.addTab("Teacher Allocation Panel", jPanel1);

        classSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classSelectActionPerformed(evt);
            }
        });

        statusBtn.setText("status");
        statusBtn.setEnabled(false);

        teacherEmailInput.setEnabled(false);

        teacherNicInput.setEnabled(false);

        teacherMobileInput.setEnabled(false);

        teacherNameInput.setEnabled(false);

        jLabel1.setText("Teacher Name :");

        jLabel2.setText("Teacher Mobile :");

        jLabel3.setText("Teacher NIC :");

        jLabel7.setText("Teacher Email :");

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

        reportBtn.setText("Generate Report");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(classSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(teacherNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(reportBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(statusBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(teacherEmailInput)
                                    .addComponent(teacherNicInput)
                                    .addComponent(teacherMobileInput))))))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(classSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(teacherNameInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(teacherMobileInput, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(teacherNicInput, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(teacherEmailInput, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(statusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Class Overview Panel", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

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

        classComboLoad();
        subjectComboLoad();
        teacherCombo();
        loadsubjectTeacherTable();
    }

    private void classComboLoad() {
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `class`");

            Vector<String> v = new Vector();
            v.add("select a class");

            while (rs.next()) {
                String name = rs.getString("class_name");
                v.add(name);
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            classCombo.setModel(dcm);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void subjectComboLoad() {
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `subject`");

            Vector<String> v = new Vector();
            v.add("select a subject");

            while (rs.next()) {
                String name = rs.getString("subject_name");

                v.add(name);
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            subjectCombo.setModel(dcm);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void teacherCombo() {
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `teacher`");

            Vector<String> v = new Vector();
            v.add("select a teacher");

            while (rs.next()) {
                String name = rs.getString("f_name") + " " + rs.getString("l_name");
                v.add(name);
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            teacherCombo.setModel(dcm);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadsubjectTeacherTable() {
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `subject_has_teacher` "
                    + "INNER JOIN `class` ON `subject_has_teacher`.`class_id` = `class`.`class_id` "
                    + "INNER JOIN `subject` ON `subject_has_teacher`.`subject_id` = `subject`.`subject_id` "
                    + "INNER JOIN `teacher` ON `subject_has_teacher`.`teacher_id` = `teacher`.`teacher_id`");

            DefaultTableModel dtm = (DefaultTableModel) subjectTeacherTable.getModel();
            dtm.setRowCount(0);

            int rowCount = 1;

            while (rs.next()) {
                Vector<String> vData = new Vector();
                vData.add(String.valueOf(rowCount));
                vData.add(rs.getString("class_name"));
                vData.add(rs.getString("subject_name"));
                vData.add(rs.getString("teacher.f_name") + " " + rs.getString("teacher.l_name"));

                dtm.addRow(vData);
                rowCount++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void classSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classSelectActionPerformed
//        String selectedCls = (String) classSelect.getSelectedItem();
//
//        if (selectedCls != null && !selectedCls.equals("select a class")) {
//            Integer clsId = classMap.get(selectedCls);
//            if (clsId != null) {
//                loadStudentByClass(clsId);
//            } else {
//                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_LEFT, 2000, "class data not found");
//            }
//        }
    }//GEN-LAST:event_classSelectActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        int cls = classCombo.getSelectedIndex();
        int subject = subjectCombo.getSelectedIndex();
        int teacher = teacherCombo.getSelectedIndex();

        if (!Validator.isSelectedItemValid(cls)) {
            return;
        }
        if (!Validator.isSelectedItemValid(subject)) {
            return;
        }
        if (!Validator.isSelectedItemValid(teacher)) {
            return;
        }

        try {
            MySQL.execute("INSERT INTO `subject_has_teacher` (`class_id` , `subject_id` , `teacher_id`)VALUES('" + cls + "' , '" + subject + "' , '" + teacher + "')");
            JOptionPane.showMessageDialog(this, "Data inserted successfully");
            loadsubjectTeacherTable();

            classCombo.setSelectedIndex(0);
            subjectCombo.setSelectedIndex(0);
            teacherCombo.setSelectedIndex(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addBtnActionPerformed

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

            ResultSet teacherRs = MySQL.execute("SELECT `f_name` , `l_name` , `mobile` , `nic` , `email` , `status_name` FROM `teacher` "
                    + "INNER JOIN `class` ON `class`.`class_id` = `teacher`.`class_id` "
                    + "INNER JOIN `status` ON `teacher`.`status_id` = `status`.`status_id`"
                    + "WHERE `teacher`.`class_id` = '" + clsId + "'");

            if (teacherRs.next()) {
                String teacherName = teacherRs.getString("f_name") + " " + teacherRs.getString("l_name");
                teacherNameInput.setText(teacherName);
                teacherMobileInput.setText(teacherRs.getString("mobile"));
                teacherNicInput.setText(teacherRs.getString("nic"));
                teacherEmailInput.setText(teacherRs.getString("email"));
                statusBtn.setText(teacherRs.getString("status_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JComboBox<String> classCombo;
    private javax.swing.JComboBox<String> classSelect;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton reportBtn;
    private javax.swing.JButton statusBtn;
    private javax.swing.JTable studentTable;
    private javax.swing.JComboBox<String> subjectCombo;
    private javax.swing.JTable subjectTeacherTable;
    private javax.swing.JComboBox<String> teacherCombo;
    private javax.swing.JTextField teacherEmailInput;
    private javax.swing.JTextField teacherMobileInput;
    private javax.swing.JTextField teacherNameInput;
    private javax.swing.JTextField teacherNicInput;
    // End of variables declaration//GEN-END:variables
}
