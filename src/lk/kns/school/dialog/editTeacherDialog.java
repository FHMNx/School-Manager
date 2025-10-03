package lk.kns.school.dialog;

import java.awt.Image;
import javax.swing.JCheckBox;
import lk.kns.school.connection.MySQL;
import lk.kns.school.validation.Validator;
import raven.toast.Notifications;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import lk.kns.school.adminSidePanels.TeacherPanel;

public class editTeacherDialog extends javax.swing.JDialog {

    private TeacherPanel parntPanel;
    private final ArrayList<JCheckBox> empCheckBox = new ArrayList();
    private HashMap<String, Integer> classMap = new HashMap();
    private HashMap<String, Integer> statusMap = new HashMap();

    public editTeacherDialog(java.awt.Frame parent, boolean modal, TeacherPanel panel) {
        super(parent, modal);
        initComponents();
        this.parntPanel = panel;
        init();
        loadstatus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fnameInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nicInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        passwordInput = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        mobileInput = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        classSelect = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        permenentBox = new javax.swing.JCheckBox();
        temporaryBox = new javax.swing.JCheckBox();
        updateBtn = new javax.swing.JButton();
        knslogo = new javax.swing.JLabel();
        lnameInput = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        statusSelect = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update Teacher Account");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("First Name");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NIC");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email Address");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Portal Password");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Assigned Class");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Employment Type");

        classSelect.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Contact Number");

        permenentBox.setForeground(new java.awt.Color(255, 255, 255));
        permenentBox.setText("Permenent");

        temporaryBox.setForeground(new java.awt.Color(255, 255, 255));
        temporaryBox.setText("Temporary");

        updateBtn.setBackground(new java.awt.Color(59, 89, 152));
        updateBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("Update Account");
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Last Name");

        statusSelect.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Status");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(knslogo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fnameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lnameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nicInput, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(classSelect, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passwordInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(mobileInput)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(statusSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(temporaryBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(permenentBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(knslogo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fnameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lnameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nicInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mobileInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(classSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(permenentBox)
                .addGap(16, 16, 16)
                .addComponent(temporaryBox)
                .addGap(18, 18, 18)
                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void init() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/lk/kns/school/image/knslogo.png"));
        Image image = icon.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        knslogo.setIcon(new ImageIcon(image));
    }

    private void loadstatus() {
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `status`");
            while (rs.next()) {
                int id = rs.getInt("status_id");
                String name = rs.getString("status_name");

                statusMap.putIfAbsent(name, id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        String fname = fnameInput.getText().trim();
        String lname = lnameInput.getText().trim();
        String nic = nicInput.getText().trim();
        String email = emailInput.getText().trim();
        String password = passwordInput.getText().trim();
        String mobile = mobileInput.getText().trim();
        int cls = classSelect.getSelectedIndex();

        if (!Validator.isInputFieldsValid(fname, lname, nic, email, password)) {
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

        String selectedEmpType = null;
        int empTypeId = 0;
//        for (JCheckBox checkBox : empCheckBox) {
//            if (checkBox.isSelected()) {
//                selectedEmpType = checkBox.getText().trim();
//
//                if (selectedEmpType.equalsIgnoreCase("Permenent")) {
//                    empTypeId = 1;
//                } else if(selectedEmpType.equalsIgnoreCase("Temporary")) {
//                    empTypeId = 2;
//                }
//                break;
//            }
//        }

        if (selectedEmpType == null) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 2000, "Please select a Employment Type");
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

            ResultSet rsRole = MySQL.execute("SELECT `role_id` FROM `role` WHERE `role_name` = 'Teachers'");
            int roleId = 0;
            if (rsRole.next()) {
                roleId = rsRole.getInt("role_id");
            } else {
                Notifications.getInstance().show(Notifications.Type.WARNING,
                        Notifications.Location.TOP_RIGHT,
                        2000,
                        "Teacher role not found");
                return;
            }

            MySQL.execute("INSERT INTO `user`(`email`,`password`,`role_Id`)VALUES('" + email + "','" + password + "','" + roleId + "')");

            ResultSet rsId = MySQL.execute("SELECT LAST_INSERT_ID() AS id");
            int userId = 0;
            if (rsId.next()) {
                userId = rsId.getInt("id");
            }

            MySQL.execute("INSERT INTO `teacher`(`f_name`,`l_name`,`email`,`password`,`nic`,`mobile`,`class_id`,`empType_id`,`user_id`,`status_id`)"
                    + "VALUES ('" + fname + "','" + lname + "','" + email + "','" + password + "','" + nic + "','" + mobile + "','" + cls + "' ,'" + empTypeId + "' , '" + userId + "' ,'" + statusId + "')");

            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 2000, "Teacher created successfully");
            parntPanel.loadTeacherTable();
            this.dispose();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                editTeacherDialog dialog = new editTeacherDialog(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JComboBox<String> classSelect;
    private javax.swing.JTextField emailInput;
    private javax.swing.JTextField fnameInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel knslogo;
    private javax.swing.JTextField lnameInput;
    private javax.swing.JTextField mobileInput;
    private javax.swing.JTextField nicInput;
    private javax.swing.JTextField passwordInput;
    private javax.swing.JCheckBox permenentBox;
    private javax.swing.JComboBox<String> statusSelect;
    private javax.swing.JCheckBox temporaryBox;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
