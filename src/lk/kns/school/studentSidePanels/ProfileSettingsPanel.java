package lk.kns.school.studentSidePanels;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import lk.kns.school.connection.MySQL;
import lk.kns.school.util.Session;
import lk.kns.school.validation.Validator;

public class ProfileSettingsPanel extends javax.swing.JPanel {

    public ProfileSettingsPanel() {
        initComponents();
        init();
        loadStudentData();
        loadProfileImage();
    }

    private void init() {
        fnameInput.setEditable(false);
        lnameInput.setEditable(false);

        fnameInput.setToolTipText("Please contact an Administrator to change your legal name.");
        lnameInput.setToolTipText("Please contact an Administrator to change your legal name.");
    }

    private void loadStudentData() {
        try {
            ResultSet rs = MySQL.execute("SELECT s.f_name, s.l_name, u.email FROM `student` s "
                    + "INNER JOIN `user` u ON s.user_id = u.user_id "
                    + "WHERE u.user_id = '" + Session.userId + "'");

            if (rs.next()) {
                fnameInput.setText(rs.getString("f_name"));
                lnameInput.setText(rs.getString("l_name"));
                emailInput.setText(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadProfileImage() {
        try {
            ResultSet rs = MySQL.execute("SELECT `image_path` FROM `userProfile` "
                    + "WHERE `user_id` = '" + Session.userId + "' AND `role_id` = '" + Session.roleId + "'");

            if (rs.next()) {
                String imagePath = rs.getString("image_path");
                if (imagePath != null && !imagePath.isEmpty()) {
                    String projectDir = new File("").getAbsolutePath();
                    File imgFile = new File(projectDir, imagePath);

                    if (imgFile.exists()) {
                        setProfileImage(imgFile.getAbsolutePath());
                        return;
                    }
                }
            }
            studentImage.setIcon(new FlatSVGIcon("lk/kns/school/image/student.svg", 142, 142));

        } catch (SQLException e) {
            e.printStackTrace();
            studentImage.setIcon(new FlatSVGIcon("lk/kns/school/image/student.svg", 142, 142));
        }
    }

    private void setProfileImage(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage().getScaledInstance(142, 142, Image.SCALE_SMOOTH);
        studentImage.setIcon(new ImageIcon(img));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fnameInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        profileBtn = new javax.swing.JButton();
        passwordBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lnameInput = new javax.swing.JTextField();
        studentImage = new javax.swing.JLabel();
        emailInput = new javax.swing.JTextField();
        confirmPasswordInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        newPasswordInput = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        currentPasswordInput = new javax.swing.JTextField();

        setBackground(new java.awt.Color(43, 43, 43));

        jLabel3.setText("Student Email Address :");

        jLabel5.setText("New Password :");

        jLabel4.setText("Current Password :");

        profileBtn.setText("Change Profile");
        profileBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileBtnActionPerformed(evt);
            }
        });

        passwordBtn.setText("Change Password");
        passwordBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        passwordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordBtnActionPerformed(evt);
            }
        });

        jLabel6.setText("Confirm Password :");

        jLabel2.setText("Student Last Name :");

        jLabel1.setText("Student First Name :");

        updateBtn.setText("update");
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(studentImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(profileBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(updateBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fnameInput)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lnameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(passwordBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(currentPasswordInput)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(newPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(14, 14, 14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                .addComponent(confirmPasswordInput)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(studentImage, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fnameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lnameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(currentPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(confirmPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(passwordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void profileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileBtnActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images (.png, .jpeg, .jpg)", "png", "jpeg", "jpg");
        chooser.setFileFilter(filter);

        int option = chooser.showOpenDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            try {
                // FIXED: Changed folder to student_image
                String projectDir = new File("").getAbsolutePath();
                File imageFolder = new File(projectDir, "student_image");
                if (!imageFolder.exists()) {
                    imageFolder.mkdir();
                }

                String fileName = System.currentTimeMillis() + "_" + selectedFile.getName();
                File destinationFile = new File(imageFolder, fileName);
                String relativePath = "student_image/" + fileName;
                Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                ResultSet rs = MySQL.execute("SELECT `profile_id` FROM `userProfile` WHERE `user_id` = '" + Session.userId + "' AND `role_id` = '" + Session.roleId + "'");

                if (rs.next()) {
                    MySQL.execute("UPDATE `userProfile` SET `image_path` = '" + relativePath + "' WHERE `user_id` = '" + Session.userId + "' AND `role_id` = '" + Session.roleId + "'");
                } else {
                    MySQL.execute("INSERT INTO `userProfile` (`image_path`, `user_id`, `role_id`) VALUES ('" + relativePath + "', '" + Session.userId + "', '" + Session.roleId + "')");
                }

                setProfileImage(destinationFile.getAbsolutePath());
                JOptionPane.showMessageDialog(this, "Profile image updated successfully!");

            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error copying image: " + e.getMessage());
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_profileBtnActionPerformed

    private void passwordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordBtnActionPerformed
        String currentPassword = currentPasswordInput.getText().trim();
        String newPassword = newPasswordInput.getText().trim();
        String confirmPassword = confirmPasswordInput.getText().trim();

        if (!Validator.isInputFieldsValid(currentPassword, newPassword, confirmPassword)) {
            return;
        }

        try {
            ResultSet rs = MySQL.execute("SELECT `password` FROM `user` WHERE `user_id` = '" + Session.userId + "'");
            if (rs.next()) {
                String dbPassword = rs.getString("password");

                if (!currentPassword.equals(dbPassword)) {
                    JOptionPane.showMessageDialog(this, "Your current password is incorrect.");
                    return;
                }

                if (!newPassword.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(this, "New password and confirm password do not match.");
                    return;
                }

                // FIXED: Now specifically targets the student table!
                MySQL.execute("UPDATE `user` SET `password` = '" + confirmPassword + "' WHERE `user_id` = '" + Session.userId + "'");
                MySQL.execute("UPDATE `student` SET `password` = '" + confirmPassword + "' WHERE `user_id` = '" + Session.userId + "'");

                JOptionPane.showMessageDialog(this, "Student password updated successfully!");

                currentPasswordInput.setText("");
                newPasswordInput.setText("");
                confirmPasswordInput.setText("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        }
    }//GEN-LAST:event_passwordBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        String email = emailInput.getText().trim();

        if (!Validator.isEmailValid(email)) {
            return;
        }

        try {
            MySQL.execute("UPDATE `user` SET `email` = '" + email + "' WHERE `user_id` = '" + Session.userId + "'");
            
            JOptionPane.showMessageDialog(this, "Email address updated successfully");
            Session.email = email; 

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField confirmPasswordInput;
    private javax.swing.JTextField currentPasswordInput;
    private javax.swing.JTextField emailInput;
    private javax.swing.JTextField fnameInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField lnameInput;
    private javax.swing.JTextField newPasswordInput;
    private javax.swing.JButton passwordBtn;
    private javax.swing.JButton profileBtn;
    private javax.swing.JLabel studentImage;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
