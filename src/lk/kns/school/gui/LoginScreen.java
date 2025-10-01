package lk.kns.school.gui;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.AlphaComposite;
import java.awt.CardLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import lk.kns.school.appIcon.Icon;
import lk.kns.school.loginPanels.AdminLoginPanel;
import lk.kns.school.loginPanels.RoleSelectionPanel;
import lk.kns.school.loginPanels.StudentLoginPanel;
import lk.kns.school.loginPanels.TeacherLoginPanel;
import raven.toast.Notifications;

public class LoginScreen extends javax.swing.JFrame {

    private RoleSelectionPanel roleSelectionPanel;
    private AdminLoginPanel adminLoginPanel;
    private TeacherLoginPanel teacherLoginPanel;
    private StudentLoginPanel studentLoginPanel;

    private CardLayout rolePanelLayout;

    private final String[] slides = {
        "/lk/kns/school/image/pic1.jpg",
        "/lk/kns/school/image/pic2.jpg",
        "/lk/kns/school/image/pic3.jpg"
    };
    private int index = 0;
    private javax.swing.Timer slideTimer, fadeTimer;
    private float alpha = 0f;
    private Image currentImg, nextImg;

    public LoginScreen() {
        initComponents();
        init();
        loadPanels();
    }

    private void init() {
        Icon.applyIcon(this);
        loadImage(0); // first slide
        
        Notifications.getInstance().setJFrame(this);

        // change slide every 5s
        slideTimer = new Timer(5000, e -> {
            int next = (index + 1) % slides.length;
            startFade(next);
        });
        slideTimer.start();
    }

    private void loadPanels() {
        if (rolePanelLayout == null && rolePanel.getLayout() instanceof CardLayout) {
            this.rolePanelLayout = (CardLayout) rolePanel.getLayout();
        }

        this.roleSelectionPanel = new RoleSelectionPanel(this);
        this.adminLoginPanel = new AdminLoginPanel();
        this.teacherLoginPanel = new TeacherLoginPanel();
        this.studentLoginPanel = new StudentLoginPanel();

        this.rolePanel.add(roleSelectionPanel, "roleSelection_panel");
        this.rolePanel.add(adminLoginPanel, "adminLogin_panel");
        this.rolePanel.add(teacherLoginPanel, "teacherLogin_panel");
        this.rolePanel.add(studentLoginPanel, "studentLogin_panel");

        SwingUtilities.updateComponentTreeUI(rolePanel);
    }

    public void showPanel(String panelName){
        rolePanelLayout.show(rolePanel, panelName);
    }
    
    private void loadImage(int i) {
        currentImg = new ImageIcon(getClass().getResource(slides[i]))
                .getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(currentImg));
        index = i;
    }

    private void startFade(int nextIdx) {
        nextImg = new ImageIcon(getClass().getResource(slides[nextIdx]))
                .getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);

        alpha = 0f;
        if (fadeTimer != null && fadeTimer.isRunning()) {
            fadeTimer.stop();
        }

        // smoother fade: ~60fps, gradual transition
        fadeTimer = new Timer(15, e -> {
            alpha += 0.01f; // smaller step = smoother
            if (alpha >= 1f) {
                ((Timer) e.getSource()).stop();
                loadImage(nextIdx); // set new as base
            } else {
                paintFade();
            }
        });
        fadeTimer.start();
    }

    private void paintFade() {
        int w = imageLabel.getWidth(), h = imageLabel.getHeight();
        BufferedImage buf = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buf.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        g2.drawImage(currentImg, 0, 0, null);
        g2.setComposite(AlphaComposite.SrcOver.derive(alpha));
        g2.drawImage(nextImg, 0, 0, null);

        g2.dispose();
        imageLabel.setIcon(new ImageIcon(buf));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        rolePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("St Sylvesters Coillege Access Portal");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        rolePanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rolePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rolePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        FlatDarkLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel rolePanel;
    // End of variables declaration//GEN-END:variables
}
