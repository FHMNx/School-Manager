package lk.kns.school.adminSidePanels;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import lk.kns.school.connection.MySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import lk.kns.school.validation.Validator;

public class ProfileSettingsPanel extends javax.swing.JPanel {

    public ProfileSettingsPanel() {
        initComponents();
        loadProfileImage();
        loadAdminData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminImage = new javax.swing.JLabel();
        profileBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        fnameInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lnameInput = new javax.swing.JTextField();
        emailInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        updateBtn = new javax.swing.JButton();
        currentPasswordInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        newPasswordInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        passwordBtn = new javax.swing.JButton();
        confirmPasswordInput = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(43, 43, 43));

        profileBtn.setText("Change Profile");
        profileBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Admin First Name :");

        jLabel2.setText("Admin Last Name :");

        jLabel3.setText("Admin Email Address :");

        updateBtn.setText("update");
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Current Password :");

        jLabel5.setText("New Password :");

        passwordBtn.setText("Change Password");
        passwordBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        passwordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordBtnActionPerformed(evt);
            }
        });

        jLabel6.setText("Confirm Password :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(adminImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(adminImage, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadAdminData() {
        try {
            ResultSet rs = MySQL.execute(
                    "SELECT `admin`.`f_name`, `admin`.`l_name`, `user`.`email` "
                    + "FROM `admin` "
                    + "INNER JOIN `user` ON `admin`.`user_id` = `user`.`user_id` "
                    + "LIMIT 1"
            );

            if (rs.next()) {
                String fname = rs.getString("f_name");
                String lname = rs.getString("l_name");
                String email = rs.getString("email");

                fnameInput.setText(fname);
                lnameInput.setText(lname);
                emailInput.setText(email);
            } else {
                JOptionPane.showMessageDialog(this, "No admin record found.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading admin data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void profileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileBtnActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images (.png, .jpeg, .jpg)", "png", "jpeg", "jpg");
        chooser.setFileFilter(filter);

        int option = chooser.showOpenDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            try {
                //create admin_image folder if needed
                String projectDir = new File("").getAbsolutePath();
                File imageFolder = new File(projectDir, "admin_image");
                if (!imageFolder.exists()) {
                    imageFolder.mkdir();
                }

                //unique file name & copy
                String fileName = System.currentTimeMillis() + "_" + selectedFile.getName();
                File destinationFile = new File(imageFolder, fileName);
                String relativePath = "admin_image/" + fileName;
                Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                int userId = -1;
                ResultSet userRs = MySQL.execute("SELECT * FROM `user` LIMIT 1");
                if (userRs.next()) {
                    userId = userRs.getInt("user_id");
                }

                int roleId = -1;
                ResultSet roleRs = MySQL.execute("SELECT * FROM `role` WHERE `role_id` = '1' LIMIT 1");
                if (roleRs.next()) {
                    roleId = roleRs.getInt("role_id");
                }

                if (userId == -1 || roleId == -1) {
                    JOptionPane.showMessageDialog(this, "Could not determine user or role. Aborting.");
                    return;
                }

                ResultSet rs = MySQL.execute("SELECT `profile_id` FROM `userProfile` WHERE `user_id` = " + userId + " AND `role_id` = " + roleId);
                if (rs.next()) {
                    // update
                    String updateQuery = "UPDATE `userProfile` SET `image_path` = '" + relativePath
                            + "' WHERE `user_id` = " + userId + " AND `role_id` = " + roleId;
                    MySQL.execute(updateQuery);
                } else {
                    // insert
                    String insertQuery = "INSERT INTO `userProfile` (`image_path`, `user_id`, `role_id`) VALUES ('"
                            + relativePath + "', " + userId + ", " + roleId + ")";
                    MySQL.execute(insertQuery);
                }

                setProfileImage(destinationFile.getAbsolutePath());
                JOptionPane.showMessageDialog(this, "Profile image updated successfully!");

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

    private void setProfileImage(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage().getScaledInstance(142, 142, Image.SCALE_SMOOTH);
        adminImage.setIcon(new ImageIcon(img));
    }

    private void loadProfileImage() {
        try {

            int userId = -1;
            ResultSet userRs = MySQL.execute("SELECT * FROM `user` LIMIT 1");
            if (userRs.next()) {
                userId = userRs.getInt("user_id");
            }

            int roleId = -1;
            ResultSet roleRs = MySQL.execute("SELECT * FROM `role` WHERE `role_id` = '1' LIMIT 1");
            if (roleRs.next()) {
                roleId = roleRs.getInt("role_id");
            }

            if (userId == -1 || roleId == -1) {
                adminImage.setIcon(new FlatSVGIcon("lk/kns/school/image/user.svg", 142, 142));
                return;
            }

            ResultSet rs = MySQL.execute("SELECT `image_path` FROM `userProfile` WHERE `user_id` = " + userId + " AND `role_id` = " + roleId);
            if (rs.next()) {
                String imagePath = rs.getString("image_path");
                if (imagePath != null && !imagePath.isEmpty()) {
                    String projectDir = new File("").getAbsolutePath();
                    File imgFile = new File(projectDir, imagePath);

                    if (imgFile.exists()) {
                        setProfileImage(imgFile.getAbsolutePath());
                    } else {
                        adminImage.setIcon(new FlatSVGIcon("lk/kns/school/image/user.svg", 142, 142));
                    }
                } else {
                    adminImage.setIcon(new FlatSVGIcon("lk/kns/school/image/user.svg", 142, 142));
                }
            } else {
                adminImage.setIcon(new FlatSVGIcon("lk/kns/school/image/user.svg", 142, 142));
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
            adminImage.setIcon(new FlatSVGIcon("lk/kns/school/image/user.svg", 142, 142));
        }
    }

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        String fname = fnameInput.getText().trim();
        String lname = lnameInput.getText().trim();
        String email = emailInput.getText().trim();

        if (!Validator.isInputFieldsValid(fname, lname)) {
            return;
        }
        if (!Validator.isEmailValid(email)) {
            return;
        }

        try {
            ResultSet userRs = MySQL.execute("SELECT `user_id` FROM `user` LIMIT 1");
            int userId = -1;
            if (userRs.next()) {
                userId = userRs.getInt("user_id");
            }

            MySQL.execute("UPDATE `user` SET `email` = '" + email + "' WHERE `user_id` = '" + userId + "'");

            MySQL.execute("UPDATE `admin` SET `f_name` = '" + fname + "' , `l_name` = '" + lname + "' , `email` = '" + email + "'"
                    + " WHERE `user_id` = '" + userId + "'");

            JOptionPane.showMessageDialog(this, "Admin data updated successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void passwordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordBtnActionPerformed
        String currentPassword = currentPasswordInput.getText().trim();
        String newPassword = newPasswordInput.getText().trim();
        String confirmPassword = confirmPasswordInput.getText().trim();

        if (!Validator.isInputFieldsValid(currentPassword, newPassword, confirmPassword)) {
            return;
        }

        try {
            ResultSet rs = MySQL.execute("SELECT `password`, `user_id` FROM `user` LIMIT 1");
            if (rs.next()) {
                String dbPassword = rs.getString("password");
                int userId = rs.getInt("user_id");

                if (!currentPassword.equals(dbPassword)) {
                    JOptionPane.showMessageDialog(this, "Your current password is incorrect.");
                    return;
                }

                if (!newPassword.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(this, "New password and confirm password do not match.");
                    return;
                }

                MySQL.execute("UPDATE `user` SET `password` = '" + confirmPassword + "' WHERE `user_id` = '" + userId + "'");
                MySQL.execute("UPDATE `admin` SET `password` = '" + confirmPassword + "' WHERE `user_id` = '" + userId + "'");

                JOptionPane.showMessageDialog(this, "Admin password updated successfully!");

                currentPasswordInput.setText("");
                newPasswordInput.setText("");
                confirmPasswordInput.setText("");

            } else {
                JOptionPane.showMessageDialog(this, "User not found in database.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        }
    }//GEN-LAST:event_passwordBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminImage;
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
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
