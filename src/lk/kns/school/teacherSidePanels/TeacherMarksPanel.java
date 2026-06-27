package lk.kns.school.teacherSidePanels;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.kns.school.connection.MySQL;
import lk.kns.school.util.Session;
import raven.toast.Notifications;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeacherMarksPanel extends javax.swing.JPanel {

    private static final Logger LOGGER = Logger.getLogger(TeacherMarksPanel.class.getName());

    private HashMap<String, Integer> classMap = new HashMap<>();
    private HashMap<String, Integer> subjectMap = new HashMap<>();
    private HashMap<String, Integer> termMap = new HashMap<>();

    public TeacherMarksPanel() {
        initComponents();
        classLoad();
        subjectLoad();
        termLoad();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectSubject = new javax.swing.JComboBox<>();
        selectClass = new javax.swing.JComboBox<>();
        selectTerm = new javax.swing.JComboBox<>();
        loadStudentsBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        marksTable = new javax.swing.JTable();
        saveMarksBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(43, 43, 43));

        loadStudentsBtn.setText("Load Students");
        loadStudentsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadStudentsBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Term");

        jLabel2.setText("Select Class");

        jLabel3.setText("Select Subject");

        marksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Student ID", "Student Name", "Marks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(marksTable);

        saveMarksBtn.setText("Save Marks");
        saveMarksBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMarksBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveMarksBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(selectSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(selectTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(51, 51, 51)
                            .addComponent(loadStudentsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(selectClass, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(919, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadStudentsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveMarksBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(selectClass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(519, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void classLoad() {
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `class`");

            Vector<String> v = new Vector();
            classMap.clear();
            v.add("select a class");

            while (rs.next()) {
                int id = rs.getInt("class_id");
                String name = rs.getString("class_name");

                v.add(name);
                classMap.put(name, id);
            }

            selectClass.setModel(new DefaultComboBoxModel<>(v));

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error loading class. ", e);
        }
    }

    private void subjectLoad() {
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `subject`");

            Vector<String> v = new Vector();
            subjectMap.clear();
            v.add("select a subject");

            while (rs.next()) {
                int id = rs.getInt("subject_id");
                String name = rs.getString("subject_name");

                v.add(name);
                subjectMap.put(name, id);
            }

            selectSubject.setModel(new DefaultComboBoxModel<>(v));

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error loading subject. ", e);
        }
    }

    private void termLoad() {
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `term`");

            Vector<String> v = new Vector();
            termMap.clear();
            v.add("select a term");

            while (rs.next()) {
                int id = rs.getInt("term_id");
                String name = rs.getString("term_name");

                v.add(name);
                termMap.put(name, id);
            }

            selectTerm.setModel(new DefaultComboBoxModel<>(v));

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error loading term. ", e);
        }
    }

    private void loadStudentsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadStudentsBtnActionPerformed
        String cls = selectClass.getSelectedItem().toString();
        String sub = selectSubject.getSelectedItem().toString();
        String term = selectTerm.getSelectedItem().toString();

        if (cls.equals("select a class") || sub.equals("select a subject") || term.equals("select a term")) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 2000, "Please select Class, Subject, and Term.");
            return;
        }

        int classId = classMap.get(cls);
        int subjectId = subjectMap.get(sub);
        int termId = termMap.get(term);
        String currentYear = new SimpleDateFormat("yyyy").format(new Date());

        try {
            ResultSet rs = MySQL.execute("SELECT `student_id`, `f_name`, `l_name` FROM `student` WHERE `class_id` = '" + classId + "'");

            DefaultTableModel dtm = (DefaultTableModel) marksTable.getModel();
            dtm.setRowCount(0);

            int rowCount = 1;
            while (rs.next()) {
                String studentId = rs.getString("student_id");
                String studentName = rs.getString("f_name") + " " + rs.getString("l_name");
                String existingMark = "";

                ResultSet markRs = MySQL.execute("SELECT `marks` FROM `student_result` "
                        + "WHERE `student_id` = '" + studentId + "' AND `subject_id` = '" + subjectId + "' "
                        + "AND `term_id` = '" + termId + "' AND `exam_year` = '" + currentYear + "'");

                if (markRs.next()) {
                    existingMark = String.valueOf(markRs.getDouble("marks"));
                }

                Vector<String> v = new Vector<>();
                v.add(String.valueOf(rowCount++));
                v.add(studentId);
                v.add(studentName);
                v.add(existingMark);
                dtm.addRow(v);
            }

            if (dtm.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No students found in this class.");
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error loading students. ", e);
        }
    }//GEN-LAST:event_loadStudentsBtnActionPerformed

    private void saveMarksBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMarksBtnActionPerformed
        String sub = selectSubject.getSelectedItem().toString();
        String term = selectTerm.getSelectedItem().toString();

        if (sub.equals("select a subject") || term.equals("select a term")) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 2000, "Make sure Subject and Term are selected.");
            return;
        }

        int subjectId = subjectMap.get(sub);
        int termId = termMap.get(term);
        String currentYear = new SimpleDateFormat("yyyy").format(new java.util.Date());

        DefaultTableModel dtm = (DefaultTableModel) marksTable.getModel();
        if (dtm.getRowCount() == 0) {
            return;
        }

        try {
            for (int i = 0; i < dtm.getRowCount(); i++) {
                String studentId = dtm.getValueAt(i, 1).toString();
                Object markObj = dtm.getValueAt(i, 3);

                if (markObj == null || markObj.toString().trim().isEmpty()) {
                    continue;
                }

                double marks = 0.0;
                try {
                    marks = Double.parseDouble(markObj.toString().trim());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid number format for Student ID " + studentId, "Input Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                ResultSet rs = MySQL.execute("SELECT * FROM `student_result` WHERE `student_id` = '" + studentId + "' "
                        + "AND `subject_id` = '" + subjectId + "' AND `term_id` = '" + termId + "' AND `exam_year` = '" + currentYear + "'");

                if (rs.next()) {
                    MySQL.execute("UPDATE `student_result` SET `marks` = '" + marks + "' WHERE `student_id` = '" + studentId + "' "
                            + "AND `subject_id` = '" + subjectId + "' AND `term_id` = '" + termId + "' AND `exam_year` = '" + currentYear + "'");
                } else {
                    MySQL.execute("INSERT INTO `student_result` (`student_id`, `subject_id`, `term_id`, `exam_year`, `marks`) "
                            + "VALUES ('" + studentId + "', '" + subjectId + "', '" + termId + "', '" + currentYear + "', '" + marks + "')");
                }
            }

            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 2000, "Marks successfully saved!");
            LOGGER.info("Marks successfully saved!");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database Error while saving marks. ", e);
            JOptionPane.showMessageDialog(this, "Database Error while saving marks.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveMarksBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadStudentsBtn;
    private javax.swing.JTable marksTable;
    private javax.swing.JButton saveMarksBtn;
    private javax.swing.JComboBox<String> selectClass;
    private javax.swing.JComboBox<String> selectSubject;
    private javax.swing.JComboBox<String> selectTerm;
    // End of variables declaration//GEN-END:variables
}
