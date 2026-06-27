package lk.kns.school.studentSidePanels;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;
import lk.kns.school.connection.MySQL;
import lk.kns.school.util.Session;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DashboardPanel extends javax.swing.JPanel {
    
    private static final Logger LOGGER = Logger.getLogger(DashboardPanel.class.getName());

    public DashboardPanel() {
        initComponents();
        init();
        loadDashboardData();
        initPieChart();
    }

    private void init() {
        studentLogo.setIcon(new FlatSVGIcon("lk/kns/school/image/class.svg", 65, 65));
        teacherLogo.setIcon(new FlatSVGIcon("lk/kns/school/image/subject.svg", 62, 62));
        clsLogo.setIcon(new FlatSVGIcon("lk/kns/school/image/message.svg", 70, 70));
    }

    private void loadDashboardData() {
        try {
            int sid = Session.studentId;
            int cid = Session.classId;

            // Get Class Name
            ResultSet rsClass = MySQL.execute("SELECT `class_name` FROM `class` WHERE `class_id` = '" + cid + "'");
            if (rsClass.next()) {
                myClassText.setText(rsClass.getString("class_name"));
            }

            // Get Total Subjects for their Class
            ResultSet rsSub = MySQL.execute("SELECT COUNT(`subject_id`) AS sub_count FROM `subject_has_teacher` WHERE `class_id` = '" + cid + "'");
            if (rsSub.next()) {
                totalSubjectsText.setText(String.format("%02d", rsSub.getInt("sub_count")));
            }

            // Get Announcements Count
            ResultSet rsNotice = MySQL.execute("SELECT COUNT(`announcement_id`) AS notice_count FROM `announcement` WHERE `class_id` = '" + cid + "'");
            if (rsNotice.next()) {
                classNoticesText.setText(String.format("%02d", rsNotice.getInt("notice_count")));
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to load DashboardData", e);
        }
    }

    private void initPieChart() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        int presentCount = 0;
        int absentCount = 0;

        try {
            ResultSet rs = MySQL.execute("SELECT `status`, COUNT(`status`) AS days FROM `attendance` WHERE `student_id` = '" + Session.studentId + "' GROUP BY `status`");

            while (rs.next()) {
                if (rs.getString("status").equalsIgnoreCase("Present")) {
                    presentCount = rs.getInt("days");
                } else if (rs.getString("status").equalsIgnoreCase("Absent")) {
                    absentCount = rs.getInt("days");
                }
            }

            dataset.setValue("Days Present", presentCount);
            dataset.setValue("Days Absent", absentCount);

            if (presentCount == 0 && absentCount == 0) {
                dataset.setValue("No Data Yet", 1);
            }

        } catch (SQLException e) {
           LOGGER.log(Level.SEVERE, "error loading pie chart ", e);
        }

        // Create the Pie Chart
        JFreeChart pieChart = ChartFactory.createPieChart(
                "My Overall Attendance",
                dataset,
                true,
                true,
                false
        );

        Color bg = UIManager.getColor("Panel.background");
        Color fg = UIManager.getColor("Label.foreground");

        pieChart.setBackgroundPaint(bg);
        pieChart.getTitle().setPaint(fg);
        pieChart.getLegend().setBackgroundPaint(bg);
        pieChart.getLegend().setItemPaint(fg);

        PiePlot plot = (PiePlot) pieChart.getPlot();
        plot.setBackgroundPaint(bg);
        plot.setOutlineVisible(false);
        plot.setLabelBackgroundPaint(UIManager.getColor("Button.background"));
        plot.setLabelPaint(fg);
        plot.setLabelShadowPaint(null);
        plot.setLabelOutlinePaint(null);

        plot.setSectionPaint("Days Present", new Color(46, 204, 113)); // Green
        plot.setSectionPaint("Days Absent", new Color(231, 76, 60));   // Red
        plot.setSectionPaint("No Data Yet", new Color(149, 165, 166)); // Gray

        ChartPanel cp = new ChartPanel(pieChart);
        pieChartPanel.removeAll();
        pieChartPanel.setLayout(new BorderLayout());
        pieChartPanel.add(cp, BorderLayout.CENTER);
        pieChartPanel.revalidate();
        pieChartPanel.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        studentLogo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        myClassText = new javax.swing.JLabel();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        teacherLogo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        totalSubjectsText = new javax.swing.JLabel();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        clsLogo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        classNoticesText = new javax.swing.JLabel();
        pieChartPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(43, 43, 43));

        jLayeredPane1.setBackground(new java.awt.Color(67, 69, 74));
        jLayeredPane1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(217, 214, 214));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("My Class");

        myClassText.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        myClassText.setForeground(new java.awt.Color(233, 231, 231));
        myClassText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        myClassText.setText("Grade 10 - A");

        jLayeredPane1.setLayer(studentLogo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(myClassText, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(studentLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(myClassText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(studentLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(myClassText, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane6.setBackground(new java.awt.Color(67, 69, 74));
        jLayeredPane6.setOpaque(true);
        jLayeredPane6.setPreferredSize(new java.awt.Dimension(293, 102));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(217, 214, 214));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Total Subjects");

        totalSubjectsText.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        totalSubjectsText.setForeground(new java.awt.Color(233, 231, 231));
        totalSubjectsText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalSubjectsText.setText("0200");

        jLayeredPane6.setLayer(teacherLogo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(totalSubjectsText, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane6Layout = new javax.swing.GroupLayout(jLayeredPane6);
        jLayeredPane6.setLayout(jLayeredPane6Layout);
        jLayeredPane6Layout.setHorizontalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(teacherLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalSubjectsText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
                    .addGroup(jLayeredPane6Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(37, Short.MAX_VALUE))))
        );
        jLayeredPane6Layout.setVerticalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(teacherLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLayeredPane6Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalSubjectsText, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jLayeredPane5.setBackground(new java.awt.Color(67, 69, 74));
        jLayeredPane5.setOpaque(true);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(217, 214, 214));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Class Notices");

        classNoticesText.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        classNoticesText.setForeground(new java.awt.Color(233, 231, 231));
        classNoticesText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        classNoticesText.setText("0013");

        jLayeredPane5.setLayer(clsLogo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(classNoticesText, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(clsLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(classNoticesText, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(clsLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLayeredPane5Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(classNoticesText, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pieChartPanelLayout = new javax.swing.GroupLayout(pieChartPanel);
        pieChartPanel.setLayout(pieChartPanelLayout);
        pieChartPanelLayout.setHorizontalGroup(
            pieChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pieChartPanelLayout.setVerticalGroup(
            pieChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pieChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLayeredPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLayeredPane5)
                    .addComponent(jLayeredPane1)
                    .addComponent(jLayeredPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pieChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel classNoticesText;
    private javax.swing.JLabel clsLogo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLabel myClassText;
    private javax.swing.JPanel pieChartPanel;
    private javax.swing.JLabel studentLogo;
    private javax.swing.JLabel teacherLogo;
    private javax.swing.JLabel totalSubjectsText;
    // End of variables declaration//GEN-END:variables
}
