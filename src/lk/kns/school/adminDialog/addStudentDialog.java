package lk.kns.school.adminDialog;

import java.awt.Image;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import lk.kns.school.adminSidePanels.StudentPanel;
import lk.kns.school.connection.MySQL;
import lk.kns.school.validation.Validator;
import raven.toast.Notifications;

public class addStudentDialog extends javax.swing.JDialog {

    private StudentPanel parentPanel;

    public addStudentDialog(java.awt.Frame parent, boolean modal, StudentPanel panel) {
        super(parent, modal);
        initComponents();
        this.parentPanel = panel;
        init();
        loadClass();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        fnameInput = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        admissionInput = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        emailInput = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        passwordInput = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        mobileInput = new javax.swing.JTextField();
        classSelect = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        createBtn = new javax.swing.JButton();
        knslogo = new javax.swing.JLabel();
        lnameInput = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Create A New Student Account");

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("First Name");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Admission Number");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Email Address");

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Portal Password");

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Class");

        classSelect.setForeground(new java.awt.Color(255, 255, 255));

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Contact Number");

        createBtn.setBackground(new java.awt.Color(59, 89, 152));
        createBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        createBtn.setForeground(new java.awt.Color(255, 255, 255));
        createBtn.setText("Create Account");
        createBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Last Name");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fnameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lnameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(classSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(244, 244, 244))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mobileInput)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(admissionInput, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(knslogo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(knslogo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fnameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lnameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(admissionInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mobileInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(classSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void init() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/lk/kns/school/image/knslogo.png"));
        Image image = icon.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        knslogo.setIcon(new ImageIcon(image));
    }

    private void loadClass() {
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `class`");

            Vector<String> v = new Vector();
            v.add("select a class");

            while (rs.next()) {
                String name = rs.getString("class_name");
                v.add(name);
            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            classSelect.setModel(dcm);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        String fname = fnameInput.getText().trim();
        String lname = lnameInput.getText().trim();
        String admission = admissionInput.getText().trim();
        String email = emailInput.getText().trim();
        String password = passwordInput.getText().trim();
        String mobile = mobileInput.getText().trim();
        int cls = classSelect.getSelectedIndex();

        if (!Validator.isInputFieldsValid(fname, lname, admission, password)) {
            return;
        } else if (!Validator.isEmailValid(email)) {
            return;
        } else if (password.length() < 4) {
            Notifications.getInstance().show(Notifications.Type.WARNING,
                    Notifications.Location.TOP_RIGHT,
                    2000,
                    "create a strong password");
            return;
        } else if (!Validator.isMobileValid(mobile)) {
            return;
        } else if (cls == 0) {
            Notifications.getInstance().show(Notifications.Type.WARNING,
                    Notifications.Location.TOP_RIGHT,
                    2000,
                    "please select a class");
            return;
        }

        try {

            int statusId = 1;
            ResultSet statusRs = MySQL.execute("SELECT * FROM `status`");
            if (statusRs.next()) {
                statusId = statusRs.getInt("status_id");
            }

            ResultSet userRs = MySQL.execute("SELECT * FROM `user` WHERE `email` = '" + email + "'");
            if (userRs.next()) {
                Notifications.getInstance().show(Notifications.Type.WARNING,
                        Notifications.Location.TOP_RIGHT,
                        2000,
                        "Email Already Exists");
                return;
            }

            ResultSet rsRole = MySQL.execute("SELECT `role_id` FROM `role` WHERE `role_name` = 'Students'");
            int roleId = 0;
            if (rsRole.next()) {
                roleId = rsRole.getInt("role_id");
            } else {
                Notifications.getInstance().show(Notifications.Type.WARNING,
                        Notifications.Location.TOP_RIGHT,
                        2000,
                        "Student role not found");
                return;
            }

            MySQL.execute("INSERT INTO `user`(`email`,`password`,`role_Id`)VALUES('" + email + "','" + password + "','" + roleId + "')");

            ResultSet rsId = MySQL.execute("SELECT LAST_INSERT_ID() AS id");
            int userId = 0;
            if (rsId.next()) {
                userId = rsId.getInt("id");
            }

            MySQL.execute("INSERT INTO `student`(`f_name`,`l_name`,`admission_no`,`email`,`password`,`mobile`,`user_id`,`status_id`,`class_id`)"
                    + "VALUES ('" + fname + "','" + lname + "','" + admission + "','" + email + "','" + password + "','" + mobile + "','" + userId + "' , '" + statusId + "' ,'" + cls + "')");

            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 2000, "Student account created successfully");
            parentPanel.loadStudentData();
            this.dispose();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_createBtnActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                addStudentDialog dialog = new addStudentDialog(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField admissionInput;
    private javax.swing.JComboBox<String> classSelect;
    private javax.swing.JButton createBtn;
    private javax.swing.JTextField emailInput;
    private javax.swing.JTextField fnameInput;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel knslogo;
    private javax.swing.JTextField lnameInput;
    private javax.swing.JTextField mobileInput;
    private javax.swing.JTextField passwordInput;
    // End of variables declaration//GEN-END:variables
}
