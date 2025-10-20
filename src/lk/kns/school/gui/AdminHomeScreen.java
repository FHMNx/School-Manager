package lk.kns.school.gui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import lk.kns.school.adminSidePanels.ClassPanel;
import lk.kns.school.adminSidePanels.DashboardPanel;
import lk.kns.school.adminSidePanels.ExamPanel;
import lk.kns.school.adminSidePanels.ProfileSettingsPanel;
import lk.kns.school.adminSidePanels.SystemSettingsPanel;
import lk.kns.school.adminSidePanels.StudentPanel;
import lk.kns.school.adminSidePanels.TeacherPanel;
import lk.kns.school.appIcon.Icon;

public class AdminHomeScreen extends javax.swing.JFrame {

    private CardLayout contentPanelLayout;

    private DashboardPanel dashboardPanel;
    private TeacherPanel teacherPanel;
    private StudentPanel studentPanel;
    private ClassPanel classPanel;
    private ExamPanel examPanel;
    private SystemSettingsPanel systemSettingsPanel;
    private ProfileSettingsPanel profileSettingsPanel;

    public AdminHomeScreen() {
        initComponents();
        init();
        loadPanels();
    }

    private void loadPanels() {
        Icon.applyIcon(this);
        if (contentPanelLayout == null && contentPanel.getLayout() instanceof CardLayout) {
            this.contentPanelLayout = (CardLayout) contentPanel.getLayout();
        }

        this.dashboardPanel = new DashboardPanel();
        this.teacherPanel = new TeacherPanel();
        this.studentPanel = new StudentPanel();
        this.classPanel = new ClassPanel();
        this.examPanel = new ExamPanel();
        this.systemSettingsPanel = new SystemSettingsPanel();
        this.profileSettingsPanel = new ProfileSettingsPanel();

        this.dashboardPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        this.teacherPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        this.studentPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        this.classPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        this.examPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        this.systemSettingsPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        this.profileSettingsPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");

        this.contentPanel.add(dashboardPanel, "dashboard_panel");
        this.contentPanel.add(teacherPanel, "teacher_panel");
        this.contentPanel.add(studentPanel, "student_panel");
        this.contentPanel.add(classPanel, "class_panel");
        this.contentPanel.add(examPanel, "exam_panel");
        this.contentPanel.add(systemSettingsPanel, "systemSettings_panel");
        this.contentPanel.add(profileSettingsPanel, "profileSettings_panel");

        SwingUtilities.updateComponentTreeUI(contentPanel);
    }

    private void init() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/lk/kns/school/image/knslogo.png"));
        Image image = icon.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        knsLogo.setIcon(new ImageIcon(image));
        messageLogo.setIcon(new FlatSVGIcon("lk/kns/school/image/message.svg", 20, 20));
        notifyLogo.setIcon(new FlatSVGIcon("lk/kns/school/image/notification.svg", 20, 20));
        userBtn.setIcon(new FlatSVGIcon("lk/kns/school/image/user.svg", 40, 40));

        dashboardBtn.setIcon(new FlatSVGIcon("lk/kns/school/image/dashboard.svg", 20, 20));
        teacherBtn.setIcon(new FlatSVGIcon("lk/kns/school/image/teacher_1.svg", 20, 20));
        studentBtn.setIcon(new FlatSVGIcon("lk/kns/school/image/student_1.svg", 20, 20));
        classBtn.setIcon(new FlatSVGIcon("lk/kns/school/image/class.svg", 20, 20));
        examBtn.setIcon(new FlatSVGIcon("lk/kns/school/image/exam.svg", 20, 20));
        systemSettingBtn.setIcon(new FlatSVGIcon("lk/kns/school/image/settings.svg", 20, 20));
        profileSettingBtn.setIcon(new FlatSVGIcon("lk/kns/school/image/user1.svg", 20, 20));
        logOutBtn.setIcon(new FlatSVGIcon("lk/kns/school/image/logOut.svg", 20, 20));

        dashboardBtn.putClientProperty(FlatClientProperties.STYLE, "arc:30");
        teacherBtn.putClientProperty(FlatClientProperties.STYLE, "arc:30");
        studentBtn.putClientProperty(FlatClientProperties.STYLE, "arc:30");
        classBtn.putClientProperty(FlatClientProperties.STYLE, "arc:30");
        examBtn.putClientProperty(FlatClientProperties.STYLE, "arc:30");
        systemSettingBtn.putClientProperty(FlatClientProperties.STYLE, "arc:30");
        profileSettingBtn.putClientProperty(FlatClientProperties.STYLE, "arc:30");
        logOutBtn.putClientProperty(FlatClientProperties.STYLE, "arc:30");

        logoPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        headerPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        menuItemPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        contentPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoPanel = new javax.swing.JPanel();
        knsLogo = new javax.swing.JLabel();
        menuItemPanel = new javax.swing.JPanel();
        profileSettingBtn = new javax.swing.JButton();
        dashboardBtn = new javax.swing.JButton();
        teacherBtn = new javax.swing.JButton();
        studentBtn = new javax.swing.JButton();
        classBtn = new javax.swing.JButton();
        examBtn = new javax.swing.JButton();
        systemSettingBtn = new javax.swing.JButton();
        logOutBtn = new javax.swing.JButton();
        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        messageLogo = new javax.swing.JLabel();
        notifyLogo = new javax.swing.JLabel();
        userBtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("School Management System – Kekunagolla National School");
        setFont(new java.awt.Font("AGA Arabesque", 1, 10)); // NOI18N
        setLocation(new java.awt.Point(20, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        logoPanel.setBackground(new java.awt.Color(43, 43, 43));

        javax.swing.GroupLayout logoPanelLayout = new javax.swing.GroupLayout(logoPanel);
        logoPanel.setLayout(logoPanelLayout);
        logoPanelLayout.setHorizontalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(knsLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logoPanelLayout.setVerticalGroup(
            logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(knsLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuItemPanel.setBackground(new java.awt.Color(43, 43, 43));

        profileSettingBtn.setBackground(new java.awt.Color(60, 63, 65));
        profileSettingBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        profileSettingBtn.setForeground(new java.awt.Color(246, 246, 246));
        profileSettingBtn.setText("Profile Settings");
        profileSettingBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profileSettingBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        profileSettingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileSettingBtnActionPerformed(evt);
            }
        });

        dashboardBtn.setBackground(new java.awt.Color(60, 63, 65));
        dashboardBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        dashboardBtn.setForeground(new java.awt.Color(246, 246, 246));
        dashboardBtn.setText(" Dashboard");
        dashboardBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboardBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dashboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnActionPerformed(evt);
            }
        });

        teacherBtn.setBackground(new java.awt.Color(60, 63, 65));
        teacherBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        teacherBtn.setForeground(new java.awt.Color(246, 246, 246));
        teacherBtn.setText(" Teacher Management");
        teacherBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        teacherBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        teacherBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherBtnActionPerformed(evt);
            }
        });

        studentBtn.setBackground(new java.awt.Color(60, 63, 65));
        studentBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        studentBtn.setForeground(new java.awt.Color(246, 246, 246));
        studentBtn.setText(" Student Management");
        studentBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        studentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentBtnActionPerformed(evt);
            }
        });

        classBtn.setBackground(new java.awt.Color(60, 63, 65));
        classBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        classBtn.setForeground(new java.awt.Color(246, 246, 246));
        classBtn.setText(" Class Management");
        classBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        classBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        classBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classBtnActionPerformed(evt);
            }
        });

        examBtn.setBackground(new java.awt.Color(60, 63, 65));
        examBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        examBtn.setForeground(new java.awt.Color(246, 246, 246));
        examBtn.setText(" Exams & Results");
        examBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        examBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        examBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examBtnActionPerformed(evt);
            }
        });

        systemSettingBtn.setBackground(new java.awt.Color(60, 63, 65));
        systemSettingBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        systemSettingBtn.setForeground(new java.awt.Color(246, 246, 246));
        systemSettingBtn.setText("System Settings");
        systemSettingBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        systemSettingBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        systemSettingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                systemSettingBtnActionPerformed(evt);
            }
        });

        logOutBtn.setBackground(new java.awt.Color(60, 63, 65));
        logOutBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        logOutBtn.setForeground(new java.awt.Color(246, 246, 246));
        logOutBtn.setText(" LogOut");
        logOutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logOutBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuItemPanelLayout = new javax.swing.GroupLayout(menuItemPanel);
        menuItemPanel.setLayout(menuItemPanelLayout);
        menuItemPanelLayout.setHorizontalGroup(
            menuItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuItemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileSettingBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(classBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dashboardBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(teacherBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(examBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(systemSettingBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logOutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        menuItemPanelLayout.setVerticalGroup(
            menuItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuItemPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(dashboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(teacherBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(studentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(classBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(examBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(systemSettingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profileSettingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        headerPanel.setBackground(new java.awt.Color(43, 43, 43));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(246, 246, 246));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Kekunagolla National School");

        userBtn.setText("Admin");
        userBtn.setBorder(null);
        userBtn.setBorderPainted(false);
        userBtn.setContentAreaFilled(false);
        userBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        userBtn.setIconTextGap(8);

        jSeparator2.setForeground(new java.awt.Color(50, 54, 60));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(messageLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(notifyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userBtn)
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(userBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(messageLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(notifyLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jSeparator2)))
                .addContainerGap())
        );

        jScrollPane1.setBackground(new java.awt.Color(43, 43, 43));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        contentPanel.setBackground(new java.awt.Color(255, 255, 153));
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new java.awt.CardLayout());
        jScrollPane1.setViewportView(contentPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuItemPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(menuItemPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened

    private void teacherBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherBtnActionPerformed
        this.contentPanelLayout.show(contentPanel, "teacher_panel");
    }//GEN-LAST:event_teacherBtnActionPerformed

    private void dashboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnActionPerformed
        this.contentPanelLayout.show(contentPanel, "dashboard_panel");
    }//GEN-LAST:event_dashboardBtnActionPerformed

    private void studentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentBtnActionPerformed
        this.contentPanelLayout.show(contentPanel, "student_panel");
    }//GEN-LAST:event_studentBtnActionPerformed

    private void classBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classBtnActionPerformed
        this.contentPanelLayout.show(contentPanel, "class_panel");
    }//GEN-LAST:event_classBtnActionPerformed

    private void examBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examBtnActionPerformed
        this.contentPanelLayout.show(contentPanel, "exam_panel");
    }//GEN-LAST:event_examBtnActionPerformed

    private void systemSettingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_systemSettingBtnActionPerformed
        this.contentPanelLayout.show(contentPanel, "systemSettings_panel");
    }//GEN-LAST:event_systemSettingBtnActionPerformed

    private void profileSettingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileSettingBtnActionPerformed
        this.contentPanelLayout.show(contentPanel, "profileSettings_panel");
    }//GEN-LAST:event_profileSettingBtnActionPerformed

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Confirm Logout", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
            new LoginScreen().setVisible(true);
        }
    }//GEN-LAST:event_logOutBtnActionPerformed

    public static void main(String args[]) {

        FlatDarkLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHomeScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton classBtn;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton dashboardBtn;
    private javax.swing.JButton examBtn;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel knsLogo;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JPanel menuItemPanel;
    private javax.swing.JLabel messageLogo;
    private javax.swing.JLabel notifyLogo;
    private javax.swing.JButton profileSettingBtn;
    private javax.swing.JButton studentBtn;
    private javax.swing.JButton systemSettingBtn;
    private javax.swing.JButton teacherBtn;
    private javax.swing.JButton userBtn;
    // End of variables declaration//GEN-END:variables
}
