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

        String sql = "SELECT c.class_name, COUNT(s.student_id) AS student_count "
                + "FROM class_has_teacher cht "
                + "INNER JOIN class c ON cht.class_id = c.class_id "
                + "LEFT JOIN student s ON s.class_id = c.class_id "
                + "WHERE cht.teacher_id = '" + Session.teacherId + "' "
                + "GROUP BY c.class_name";

        try {
            ResultSet rs = MySQL.execute(sql);
            while (rs.next()) {
                String cls = rs.getString("class_name");
                int count = rs.getInt("student_count");
                dataset.addValue(count, "Students", cls);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataset;
    }

    private void initLineChart() {
        DefaultCategoryDataset lineDs = loadLineDataset();

        JFreeChart lineChart = ChartFactory.createLineChart(
                "Student Count for Your Class",
                "Class",
                "Students",
                lineDs
        );

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

        org.jfree.chart.renderer.category.LineAndShapeRenderer renderer
                = (org.jfree.chart.renderer.category.LineAndShapeRenderer) plot.getRenderer();

        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(0, true);

        renderer.setSeriesPaint(0, accent);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.getDomainAxis().setTickLabelPaint(fg);
        plot.getDomainAxis().setLabelPaint(fg);
        plot.getRangeAxis().setTickLabelPaint(fg);
        plot.getRangeAxis().setLabelPaint(fg);

        ChartPanel lineChartCP = new ChartPanel(lineChart);
        lineChartPanel.removeAll();
        lineChartPanel.setLayout(new BorderLayout());
        lineChartPanel.add(lineChartCP, BorderLayout.CENTER);
        lineChartPanel.revalidate();
        lineChartPanel.repaint();
    }

    public void loadDashboardData() {
        try {
            ResultSet rs = MySQL.execute(
                    "SELECT COUNT(`student`.`student_id`) AS student_count "
                    + "FROM `student` "
                    + "INNER JOIN `class_has_teacher` ON `student`.`class_id` = `class_has_teacher`.`class_id` "
                    + "WHERE `class_has_teacher`.`teacher_id` = '" + Session.teacherId + "'"
            );

            if (rs.next()) {
                studentCount.setText(String.format("%04d", rs.getInt("student_count")));
            } else {
                studentCount.setText("0000");
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
        studentCount = new javax.swing.JLabel();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        clsLogo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        teacherLogo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        teachersCount = new javax.swing.JLabel();
        jLayeredPane7 = new javax.swing.JLayeredPane();
        subjectLogo = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lineChartPanel = new javax.swing.JPanel();

        jLayeredPane1.setBackground(new java.awt.Color(67, 69, 74));
        jLayeredPane1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(217, 214, 214));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Total Students");

        studentCount.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        studentCount.setForeground(new java.awt.Color(233, 231, 231));
        studentCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentCount.setText("2000");

        jLayeredPane1.setLayer(studentLogo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(studentCount, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(studentLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(studentCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(studentCount, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane5.setBackground(new java.awt.Color(67, 69, 74));
        jLayeredPane5.setOpaque(true);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(217, 214, 214));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Total Classes");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(233, 231, 231));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("0013");

        jLayeredPane5.setLayer(clsLogo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(clsLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane6.setBackground(new java.awt.Color(67, 69, 74));
        jLayeredPane6.setOpaque(true);
        jLayeredPane6.setPreferredSize(new java.awt.Dimension(293, 102));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(217, 214, 214));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Total Teachers");

        teachersCount.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        teachersCount.setForeground(new java.awt.Color(233, 231, 231));
        teachersCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        teachersCount.setText("0200");

        jLayeredPane6.setLayer(teacherLogo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(teachersCount, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
                    .addComponent(teachersCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(teachersCount, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jLayeredPane7.setBackground(new java.awt.Color(67, 69, 74));
        jLayeredPane7.setOpaque(true);
        jLayeredPane7.setPreferredSize(new java.awt.Dimension(293, 102));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(217, 214, 214));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Total Subjects");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(233, 231, 231));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("0020");

        jLayeredPane7.setLayer(subjectLogo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane7Layout = new javax.swing.GroupLayout(jLayeredPane7);
        jLayeredPane7.setLayout(jLayeredPane7Layout);
        jLayeredPane7Layout.setHorizontalGroup(
            jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(subjectLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
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
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
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
    private javax.swing.JLabel clsLogo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JPanel lineChartPanel;
    private javax.swing.JLabel studentCount;
    private javax.swing.JLabel studentLogo;
    private javax.swing.JLabel subjectLogo;
    private javax.swing.JLabel teacherLogo;
    private javax.swing.JLabel teachersCount;
    // End of variables declaration//GEN-END:variables
}
