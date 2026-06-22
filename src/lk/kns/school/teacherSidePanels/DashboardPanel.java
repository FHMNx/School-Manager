package lk.kns.school.teacherSidePanels;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.UIManager;
import lk.kns.school.connection.MySQL;
import lk.kns.school.util.Session;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

public class DashboardPanel extends javax.swing.JPanel {

    public DashboardPanel() {
        initComponents();
        init();
        initLineChart();
        loadDashboardData();
    }

    private final void init() {
        studentLogo.setIcon(new FlatSVGIcon("lk/kns/school/image/student.svg", 65, 65));
        teacherLogo.setIcon(new FlatSVGIcon("lk/kns/school/image/teacher.svg", 62, 62));
        clsLogo.setIcon(new FlatSVGIcon("lk/kns/school/image/class.svg", 70, 70));
        subjectLogo.setIcon(new FlatSVGIcon("lk/kns/school/image/subject.svg", 60, 60));
    }

private DefaultCategoryDataset loadLineDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // SQL: Count 'Present' students per day for the last 7 recorded days for this teacher's classes
        String sql = "SELECT a.date, COUNT(a.student_id) AS present_count "
                   + "FROM attendance a "
                   + "INNER JOIN student s ON a.student_id = s.student_id "
                   + "WHERE a.status = 'Present' "
                   + "AND s.class_id IN (SELECT class_id FROM class_has_teacher WHERE teacher_id = '" + Session.teacherId + "') "
                   + "GROUP BY a.date "
                   + "ORDER BY a.date ASC "
                   + "LIMIT 7";

        try {
            ResultSet rs = MySQL.execute(sql);
            while (rs.next()) {
                // Get the date and the count
                String date = rs.getString("date");
                int count = rs.getInt("present_count");
                
                // Add to the line chart (Value, Series Name, X-Axis Label)
                dataset.addValue(count, "Students Present", date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataset;
    }


private void initLineChart() {
        DefaultCategoryDataset lineDs = loadLineDataset();

        JFreeChart lineChart = ChartFactory.createLineChart(
                "Class Attendance Trend (Past 7 Days)", // New Title
                "Date",                                 // X-Axis Label
                "Students Present",                     // Y-Axis Label
                lineDs
        );

        // Styling for FlatLaf Dark Theme
        Color bg = UIManager.getColor("Panel.background");
        Color fg = UIManager.getColor("Label.foreground");
        Color grid = UIManager.getColor("Table.gridColor");
        Color accent = UIManager.getColor("Component.focusColor");

        lineChart.setBackgroundPaint(bg);
        lineChart.getTitle().setPaint(fg);

        CategoryPlot plot = lineChart.getCategoryPlot();
        plot.setBackgroundPaint(bg);
        plot.setDomainGridlinePaint(grid);
        plot.setRangeGridlinePaint(grid);

        // Customize the Line and Data Points
        org.jfree.chart.renderer.category.LineAndShapeRenderer renderer
                = (org.jfree.chart.renderer.category.LineAndShapeRenderer) plot.getRenderer();

        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(0, true); // Shows dots on the line
        renderer.setSeriesPaint(0, accent);
        renderer.setSeriesStroke(0, new BasicStroke(3.0f)); // Made the line slightly thicker

        plot.getDomainAxis().setTickLabelPaint(fg);
        plot.getDomainAxis().setLabelPaint(fg);
        plot.getRangeAxis().setTickLabelPaint(fg);
        plot.getRangeAxis().setLabelPaint(fg);

        // Set integer ticks for the Y-Axis (You can't have 2.5 students present)
        plot.getRangeAxis().setStandardTickUnits(org.jfree.chart.axis.NumberAxis.createIntegerTickUnits());

        ChartPanel lineChartCP = new ChartPanel(lineChart);
        lineChartPanel.removeAll();
        lineChartPanel.setLayout(new BorderLayout());
        lineChartPanel.add(lineChartCP, BorderLayout.CENTER);
        lineChartPanel.revalidate();
        lineChartPanel.repaint();
    }



    public void loadDashboardData() {
        try {
            int tid = Session.teacherId;

            ResultSet rs1 = MySQL.execute("SELECT COUNT(DISTINCT s.student_id) AS count FROM `student` s "
                    + "WHERE s.class_id IN ("
                    + "SELECT class_id FROM `class_has_teacher` WHERE teacher_id = '" + tid + "' "
                    + "UNION "
                    + "SELECT class_id FROM `subject_has_teacher` WHERE teacher_id = '" + tid + "')");
            if (rs1.next()) {
                myStudentCount.setText(String.format("%04d", rs1.getInt("count")));
            }

            ResultSet rs2 = MySQL.execute("SELECT COUNT(DISTINCT subject_id) AS count FROM `subject_has_teacher` WHERE teacher_id = '" + tid + "'");
            if (rs2.next()) {
                subjectTought.setText(String.format("%02d", rs2.getInt("count")));
            }

            ResultSet rs3 = MySQL.execute("SELECT COUNT(DISTINCT class_id) AS count FROM ("
                    + "SELECT class_id FROM `class_has_teacher` WHERE teacher_id = '" + tid + "' "
                    + "UNION "
                    + "SELECT class_id FROM `subject_has_teacher` WHERE teacher_id = '" + tid + "'"
                    + ") AS combined_classes");
            if (rs3.next()) {
                assignedClasses.setText(String.format("%02d", rs3.getInt("count")));
            }

            ResultSet rs4 = MySQL.execute("SELECT COUNT(announcement_id) AS count FROM `announcement` WHERE teacher_id = '" + tid + "'");
            if (rs4.next()) {
                myAnnouncements.setText(String.format("%02d", rs4.getInt("count")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        studentLogo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        myStudentCount = new javax.swing.JLabel();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        clsLogo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        assignedClasses = new javax.swing.JLabel();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        teacherLogo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        subjectTought = new javax.swing.JLabel();
        jLayeredPane7 = new javax.swing.JLayeredPane();
        subjectLogo = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        myAnnouncements = new javax.swing.JLabel();
        lineChartPanel = new javax.swing.JPanel();

        jLayeredPane1.setBackground(new java.awt.Color(67, 69, 74));
        jLayeredPane1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(217, 214, 214));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("My Students");

        myStudentCount.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        myStudentCount.setForeground(new java.awt.Color(233, 231, 231));
        myStudentCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        myStudentCount.setText("2000");

        jLayeredPane1.setLayer(studentLogo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(myStudentCount, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(studentLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(myStudentCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
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
                        .addComponent(myStudentCount, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane5.setBackground(new java.awt.Color(67, 69, 74));
        jLayeredPane5.setOpaque(true);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(217, 214, 214));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Assigned Classes");

        assignedClasses.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        assignedClasses.setForeground(new java.awt.Color(233, 231, 231));
        assignedClasses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        assignedClasses.setText("0013");

        jLayeredPane5.setLayer(clsLogo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(assignedClasses, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(clsLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(assignedClasses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
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
                        .addComponent(assignedClasses, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane6.setBackground(new java.awt.Color(67, 69, 74));
        jLayeredPane6.setOpaque(true);
        jLayeredPane6.setPreferredSize(new java.awt.Dimension(293, 102));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(217, 214, 214));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Subjects Taught");

        subjectTought.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        subjectTought.setForeground(new java.awt.Color(233, 231, 231));
        subjectTought.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subjectTought.setText("0200");

        jLayeredPane6.setLayer(teacherLogo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(subjectTought, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane6Layout = new javax.swing.GroupLayout(jLayeredPane6);
        jLayeredPane6.setLayout(jLayeredPane6Layout);
        jLayeredPane6Layout.setHorizontalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(teacherLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(subjectTought, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
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
                        .addComponent(subjectTought, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jLayeredPane7.setBackground(new java.awt.Color(67, 69, 74));
        jLayeredPane7.setOpaque(true);
        jLayeredPane7.setPreferredSize(new java.awt.Dimension(293, 102));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(217, 214, 214));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("My Announcements");

        myAnnouncements.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        myAnnouncements.setForeground(new java.awt.Color(233, 231, 231));
        myAnnouncements.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        myAnnouncements.setText("0020");

        jLayeredPane7.setLayer(subjectLogo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(myAnnouncements, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane7Layout = new javax.swing.GroupLayout(jLayeredPane7);
        jLayeredPane7.setLayout(jLayeredPane7Layout);
        jLayeredPane7Layout.setHorizontalGroup(
            jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(subjectLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myAnnouncements, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane7Layout.setVerticalGroup(
            jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(subjectLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLayeredPane7Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(myAnnouncements, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout lineChartPanelLayout = new javax.swing.GroupLayout(lineChartPanel);
        lineChartPanel.setLayout(lineChartPanelLayout);
        lineChartPanelLayout.setHorizontalGroup(
            lineChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        lineChartPanelLayout.setVerticalGroup(
            lineChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 304, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lineChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLayeredPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jLayeredPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLayeredPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jLayeredPane5)
                    .addComponent(jLayeredPane1)
                    .addComponent(jLayeredPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lineChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel assignedClasses;
    private javax.swing.JLabel clsLogo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JPanel lineChartPanel;
    private javax.swing.JLabel myAnnouncements;
    private javax.swing.JLabel myStudentCount;
    private javax.swing.JLabel studentLogo;
    private javax.swing.JLabel subjectLogo;
    private javax.swing.JLabel subjectTought;
    private javax.swing.JLabel teacherLogo;
    // End of variables declaration//GEN-END:variables
}
