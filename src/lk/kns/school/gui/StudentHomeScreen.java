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
import lk.kns.school.appIcon.Icon;
import lk.kns.school.studentSidePanels.DashboardPanel;
import lk.kns.school.studentSidePanels.ExamAdmissionsPanel;
import lk.kns.school.studentSidePanels.MyResultsPanel;
import lk.kns.school.studentSidePanels.NoticeBoardPanel;
import lk.kns.school.studentSidePanels.ProfileSettingsPanel;
import lk.kns.school.util.Session;

public class StudentHomeScreen extends javax.swing.JFrame {
    
    private CardLayout contentPanelLayout;
    private DashboardPanel dashboardPanel;
    private NoticeBoardPanel noticeBoardPanel;
    private ExamAdmissionsPanel examAdmissionsPanel;
    private MyResultsPanel resultsPanel;
    private ProfileSettingsPanel settingsPanel;

    public StudentHomeScreen() {
        initComponents();
        init();
        loadPanels();
    }
    
    
    private void init() {
        // App Icon and Logos
        ImageIcon icon = new ImageIcon(getClass().getResource("/lk/kns/school/image/knslogo.png"));
        Image image = icon.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        knsLogo.setIcon(new ImageIcon(image));
        messageLogo.setIcon(new FlatSVGIcon("lk/kns/school/image/message.svg", 20, 20));
        notifyLogo.setIcon(new FlatSVGIcon("lk/kns/school/image/notification.svg", 20, 20));
        
        // SetUser Name from Session
        userBtn.setIcon(new FlatSVGIcon("lk/kns/school/image/student.svg", 40, 40));
        userBtn.setText(Session.studentName != null ? Session.studentName : "Student");

        // Button Icons
        dashboardBtn.setIcon(new FlatSVGIcon("lk/kns/school/image/dashboard.svg", 20, 20));
        noticeBtn.setIcon(new FlatSVGIcon("lk/kns/school/image/message.svg", 20, 20));
        admissionBtn.setIcon(new FlatSVGIcon("lk/kns/school/image/exam.svg", 20, 20));
        resultsBtn.setIcon(new FlatSVGIcon("lk/kns/school/image/subject.svg", 20, 20));
        settingBtn.setIcon(new FlatSVGIcon("lk/kns/school/image/settings.svg", 20, 20));
        logOutBtn.setIcon(new FlatSVGIcon("lk/kns/school/image/logOut.svg", 20, 20));

        // FlatLaf Styling
        dashboardBtn.putClientProperty(FlatClientProperties.STYLE, "arc:30");
        noticeBtn.putClientProperty(FlatClientProperties.STYLE, "arc:30");
        admissionBtn.putClientProperty(FlatClientProperties.STYLE, "arc:30");
        resultsBtn.putClientProperty(FlatClientProperties.STYLE, "arc:30");
        settingBtn.putClientProperty(FlatClientProperties.STYLE, "arc:30");
        logOutBtn.putClientProperty(FlatClientProperties.STYLE, "arc:30");

        logoPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        headerPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        menuItemPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        contentPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    
    private void loadPanels() {
        Icon.applyIcon(this);
        if (contentPanelLayout == null && contentPanel.getLayout() instanceof CardLayout) {
            this.contentPanelLayout = (CardLayout) contentPanel.getLayout();
        }

        // Initialize Student Panels
        this.dashboardPanel = new DashboardPanel();
         this.noticeBoardPanel = new NoticeBoardPanel();
         this.examAdmissionsPanel = new ExamAdmissionsPanel();
         this.resultsPanel = new MyResultsPanel();
         this.settingsPanel = new ProfileSettingsPanel();

        this.dashboardPanel.putClientProperty(FlatClientProperties.STYLE, "arc:20");

        // Add to CardLayout
        this.contentPanel.add(dashboardPanel, "dashboard_panel");
         this.contentPanel.add(noticeBoardPanel, "notice_panel");
         this.contentPanel.add(examAdmissionsPanel, "admission_panel");
         this.contentPanel.add(resultsPanel, "results_panel");
         this.contentPanel.add(settingsPanel, "settings_panel");

        SwingUtilities.updateComponentTreeUI(contentPanel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        notifyLogo = new javax.swing.JLabel();
        userBtn = new javax.swing.JButton();
        messageLogo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        menuItemPanel = new javax.swing.JPanel();
        logOutBtn = new javax.swing.JButton();
        dashboardBtn = new javax.swing.JButton();
        noticeBtn = new javax.swing.JButton();
        admissionBtn = new javax.swing.JButton();
        resultsBtn = new javax.swing.JButton();
        settingBtn = new javax.swing.JButton();
        logoPanel = new javax.swing.JPanel();
        knsLogo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerPanel.setBackground(new java.awt.Color(43, 43, 43));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(246, 246, 246));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Kekunagolla National School");

        userBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        userBtn.setText("Student");
        userBtn.setBorder(null);
        userBtn.setBorderPainted(false);
        userBtn.setContentAreaFilled(false);
        userBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        userBtn.setIconTextGap(8);
        userBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userBtnActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(50, 54, 60));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(messageLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(notifyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2)
                            .addComponent(messageLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(notifyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        menuItemPanel.setBackground(new java.awt.Color(43, 43, 43));

        logOutBtn.setBackground(new java.awt.Color(60, 63, 65));
        logOutBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        logOutBtn.setForeground(new java.awt.Color(246, 246, 246));
        logOutBtn.setText("LogOut");
        logOutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logOutBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });

        dashboardBtn.setBackground(new java.awt.Color(60, 63, 65));
        dashboardBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        dashboardBtn.setForeground(new java.awt.Color(246, 246, 246));
        dashboardBtn.setText("Dashboard");
        dashboardBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboardBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dashboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnActionPerformed(evt);
            }
        });

        noticeBtn.setBackground(new java.awt.Color(60, 63, 65));
        noticeBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        noticeBtn.setForeground(new java.awt.Color(246, 246, 246));
        noticeBtn.setText("Notice Board");
        noticeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        noticeBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        noticeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noticeBtnActionPerformed(evt);
            }
        });

        admissionBtn.setBackground(new java.awt.Color(60, 63, 65));
        admissionBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        admissionBtn.setForeground(new java.awt.Color(246, 246, 246));
        admissionBtn.setText("Exam Admissions");
        admissionBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admissionBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        admissionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admissionBtnActionPerformed(evt);
            }
        });

        resultsBtn.setBackground(new java.awt.Color(60, 63, 65));
        resultsBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        resultsBtn.setForeground(new java.awt.Color(246, 246, 246));
        resultsBtn.setText("My Results");
        resultsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resultsBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        resultsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultsBtnActionPerformed(evt);
            }
        });

        settingBtn.setBackground(new java.awt.Color(60, 63, 65));
        settingBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        settingBtn.setForeground(new java.awt.Color(246, 246, 246));
        settingBtn.setText("Profile Settings");
        settingBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settingBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        settingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuItemPanelLayout = new javax.swing.GroupLayout(menuItemPanel);
        menuItemPanel.setLayout(menuItemPanelLayout);
        menuItemPanelLayout.setHorizontalGroup(
            menuItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuItemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(admissionBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logOutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resultsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dashboardBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(noticeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(settingBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        menuItemPanelLayout.setVerticalGroup(
            menuItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuItemPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(dashboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(noticeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(admissionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(resultsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(settingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

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

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Confirm Logout", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            new LoginScreen().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void dashboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnActionPerformed
        this.contentPanelLayout.show(contentPanel, "dashboard_panel");
    }//GEN-LAST:event_dashboardBtnActionPerformed

    private void noticeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noticeBtnActionPerformed
        this.contentPanelLayout.show(contentPanel, "notice_panel");
    }//GEN-LAST:event_noticeBtnActionPerformed

    private void admissionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admissionBtnActionPerformed
        this.contentPanelLayout.show(contentPanel, "admission_panel");
    }//GEN-LAST:event_admissionBtnActionPerformed

    private void resultsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultsBtnActionPerformed
        this.contentPanelLayout.show(contentPanel, "results_panel");
    }//GEN-LAST:event_resultsBtnActionPerformed

    private void settingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingBtnActionPerformed
        this.contentPanelLayout.show(contentPanel, "settings_panel");
    }//GEN-LAST:event_settingBtnActionPerformed

    private void userBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userBtnActionPerformed

    }//GEN-LAST:event_userBtnActionPerformed

   public static void main(String args[]) {
        FlatDarkLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentHomeScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton admissionBtn;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton dashboardBtn;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel knsLogo;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JPanel menuItemPanel;
    private javax.swing.JLabel messageLogo;
    private javax.swing.JButton noticeBtn;
    private javax.swing.JLabel notifyLogo;
    private javax.swing.JButton resultsBtn;
    private javax.swing.JButton settingBtn;
    private javax.swing.JButton userBtn;
    // End of variables declaration//GEN-END:variables
}
