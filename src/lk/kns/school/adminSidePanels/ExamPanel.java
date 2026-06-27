package lk.kns.school.adminSidePanels;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.Year;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.kns.school.connection.MySQL;
import lk.kns.school.adminDialog.deleteExamDialog;
import lk.kns.school.validation.Validator;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import raven.toast.Notifications;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

public class ExamPanel extends javax.swing.JPanel {

    private static final Logger LOGGER = Logger.getLogger(ExamPanel.class.getName());

    HashMap<String, Integer> classMap = new HashMap();
    HashMap<String, Integer> subjectMap = new HashMap();
    HashMap<String, Integer> termMap = new HashMap();

    private int selectedExamId;
    private String selectedCls;
    private String selectedSubject;
    private String selectedTerm;
    private String selectedDate;
    private String selectedStartTime;
    private String selectedEndTime;
    private String selectedVanue;

    public ExamPanel() {
        initComponents();
        init();
        classLoad();
        subjectLoad();
        termLoad();
        loadYears();
        loadExamTable();
        getTableRow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        classSelect = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        subjectSelect = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        dateChoose = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        termSelect = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        venueInput = new javax.swing.JTextField();
        sheduleExmBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        examTable = new javax.swing.JTable();
        endTimeInput = new javax.swing.JFormattedTextField();
        startTimeInput = new javax.swing.JFormattedTextField();
        deleteLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        searchStudent = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        selectClass = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        selectTerm = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        examTermLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        totalMarksLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        averageLabel = new javax.swing.JLabel();
        studentResultsReportBtn = new javax.swing.JButton();
        resultLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        selectYr = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        selectTrm = new javax.swing.JComboBox<>();
        selectCls = new javax.swing.JComboBox<>();
        selectYear = new javax.swing.JComboBox<>();
        loadClassResultsBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        JscrollPane = new javax.swing.JScrollPane();
        classResultsTable = new javax.swing.JTable();
        classResultsReportBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(43, 43, 43));

        jLabel1.setText("Select Class");

        jLabel2.setText("Select Subject");

        jLabel3.setText("Shedule a Date");

        jLabel4.setText("Select Term");

        jLabel5.setText("Start Time");

        jLabel6.setText("End Time");

        jLabel7.setText("Exam Venue");

        sheduleExmBtn.setText("Shedule Exam");
        sheduleExmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sheduleExmBtnActionPerformed(evt);
            }
        });

        examTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Exam ID", "Class", "Subject", "Term", "Date", "Start Time", "End Time", "Vanue"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(examTable);

        try {
            endTimeInput.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            startTimeInput.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        deleteLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(classSelect, 0, 216, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(subjectSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(termSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dateChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(startTimeInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(endTimeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(venueInput, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 96, Short.MAX_VALUE)))))
                            .addComponent(sheduleExmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(103, 103, 103)
                        .addComponent(deleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(classSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subjectSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(termSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startTimeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(endTimeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(venueInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(sheduleExmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(deleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Shedule Exams", jPanel1);

        jLabel14.setText("Admission Number");

        selectClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select the class" }));

        jLabel15.setText("Select Class");

        selectTerm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select the term" }));

        jLabel8.setText("Select Term");

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        examTermLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        examTermLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        examTermLabel.setText("EXAMINATION TERM NAME");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Total Marks :");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Average :");

        studentResultsReportBtn.setText("Generate Report");
        studentResultsReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentResultsReportBtnActionPerformed(evt);
            }
        });

        resultLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        resultLabel.setForeground(new java.awt.Color(0, 153, 0));
        resultLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel13.setText("Select The Year");

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Subject", "Marks"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(resultTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(searchStudent)
                                        .addGap(17, 17, 17)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(selectClass, 0, 175, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(selectTerm, 0, 182, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(selectYr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jScrollPane3))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(totalMarksLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(averageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)))
                                    .addComponent(studentResultsReportBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                    .addComponent(resultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(examTermLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(selectTerm, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(searchStudent)
                    .addComponent(selectClass)
                    .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectYr, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(examTermLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(totalMarksLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(averageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(241, 241, 241)
                        .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(studentResultsReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(165, 165, 165))
        );

        jTabbedPane1.addTab("View Results", jPanel2);

        loadClassResultsBtn.setText("Load Class Results");
        loadClassResultsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadClassResultsBtnActionPerformed(evt);
            }
        });

        jLabel9.setText("Select Year");

        jLabel10.setText("Select Class");

        jLabel16.setText("Select Term");

        classResultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Rank", "Admission No", "Student Name", "Total Marks", "Average", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JscrollPane.setViewportView(classResultsTable);

        classResultsReportBtn.setText("Generate Report");
        classResultsReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classResultsReportBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(JscrollPane)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(selectTrm, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(42, 42, 42)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(selectYear, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(33, 33, 33)
                                    .addComponent(loadClassResultsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(classResultsReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(selectCls, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(896, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loadClassResultsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selectTrm, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(selectYear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(JscrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(classResultsReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(selectCls, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(462, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("View Class Results", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteLabelMouseClicked
        if (selectedExamId == 0) {
            JOptionPane.showMessageDialog(this, "Please select a row first.");
            return;
        }
        deleteExamDialog dialog = new deleteExamDialog(new JFrame(), true, this);
        dialog.setExamData(selectedExamId, selectedCls, selectedSubject, selectedTerm, selectedDate, selectedStartTime, selectedEndTime, selectedVanue);
        dialog.setVisible(true);
    }//GEN-LAST:event_deleteLabelMouseClicked

    private void sheduleExmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sheduleExmBtnActionPerformed
        String cls = (String) classSelect.getSelectedItem();
        String subject = (String) subjectSelect.getSelectedItem();
        String term = (String) termSelect.getSelectedItem();
        Date utilDate = dateChoose.getDate();
        String startTime = startTimeInput.getText().trim();
        String endTime = endTimeInput.getText().trim();
        String venue = venueInput.getText().trim();

        if (cls == null || cls.equals("select a class")) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_RIGHT, 2000, "select a class");
            return;
        }

        if (subject == null || subject.equals("select a subject")) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_RIGHT, 2000, "select a subject");
            return;
        }

        if (term == null || term.equals("select a term")) {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_RIGHT, 2000, "select a term");
            return;
        }

        if (utilDate == null) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 2000, "provide the examination date");
            return;
        }

        if (!Validator.isInputFieldsValid(startTime, endTime, venue)) {
            return;
        }

        try {
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            int clsId = classMap.get(cls);
            int subjectId = subjectMap.get(subject);
            int termId = termMap.get(term);

            MySQL.execute("INSERT INTO `exam` (`date`, `start_time`, `end_time`, `venue`, `class_id`, `subject_id`, `term_id`) VALUES ('"
                    + sqlDate + "', '" + startTime + "', '" + endTime + "', '" + venue + "', '"
                    + clsId + "', '" + subjectId + "', '" + termId + "')");

            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 2000, "Exam scheduled successfully");
            LOGGER.info("Exam scheduled successfully");
            loadExamTable();

            classSelect.setSelectedIndex(0);
            subjectSelect.setSelectedIndex(0);
            termSelect.setSelectedIndex(0);
            dateChoose.setDate(null);
            startTimeInput.setText("");
            endTimeInput.setText("");
            venueInput.setText("");

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Exam scheduling failed", e);
        }

    }//GEN-LAST:event_sheduleExmBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String studentQuery = searchStudent.getText().trim();
        String selectedCls = selectClass.getSelectedItem().toString();
        String selectedTermName = selectTerm.getSelectedItem().toString();
        String selectedYear = selectYr.getSelectedItem().toString();

        if (studentQuery.isEmpty() || selectedCls.equals("select a class") || selectedTermName.equals("select a term") || selectedYear.equals("Select Year")) {
            JOptionPane.showMessageDialog(this, "Please fill in all search fields.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int termId = termMap.get(selectedTermName);
        int classId = classMap.get(selectedCls);

        try {
            String sql = "SELECT `s`.`subject_name`, `r`.`marks` FROM `student_result` `r` "
                    + "INNER JOIN `subject` `s` ON `r`.`subject_id` = `s`.`subject_id` "
                    + "INNER JOIN `student` `st` ON `r`.`student_id` = `st`.`student_id` "
                    + "WHERE (`st`.`admission_no` = '" + studentQuery + "' OR `st`.`f_name` LIKE '%" + studentQuery + "%' OR `st`.`l_name` LIKE '%" + studentQuery + "%') "
                    + "AND `st`.`class_id` = '" + classId + "' "
                    + "AND `r`.`term_id` = '" + termId + "' "
                    + "AND `r`.`exam_year` = '" + selectedYear + "'";

            ResultSet rs = MySQL.execute(sql);
            DefaultTableModel dtm = (DefaultTableModel) resultTable.getModel();
            dtm.setRowCount(0);

            double totalMarks = 0;
            int subjectCount = 0;
            boolean hasFailed = false;

            while (rs.next()) {
                String subject = rs.getString("subject_name");
                double marks = rs.getDouble("marks");

                totalMarks += marks;
                subjectCount++;

                if (marks < 40) {
                    hasFailed = true;
                }

                Vector<String> v = new Vector<>();
                v.add(String.valueOf(subjectCount));
                v.add(subject);
                v.add(String.valueOf(marks));
                dtm.addRow(v);
            }

            if (subjectCount > 0) {
                examTermLabel.setText(selectedTermName.toUpperCase() + " EXAMINATION - " + selectedYear);
                totalMarksLabel.setText(String.valueOf(totalMarks));
                double average = totalMarks / subjectCount;
                averageLabel.setText(String.format("%.2f", average));

                if (hasFailed) {
                    resultLabel.setText("FAILED");
                    resultLabel.setForeground(Color.RED);
                } else {
                    resultLabel.setText("PASSED");
                    resultLabel.setForeground(new Color(0, 153, 0));
                }
            } else {
                examTermLabel.setText("NO RESULTS FOUND");
                totalMarksLabel.setText("0");
                averageLabel.setText("0.00");
                resultLabel.setText("");
                JOptionPane.showMessageDialog(this, "No exam results found for this student matching these criteria.", "No Data", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
           LOGGER.log(Level.SEVERE, "search process filaed", e);
        }

    }//GEN-LAST:event_searchBtnActionPerformed

    private void loadClassResultsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadClassResultsBtnActionPerformed
        String selectedCls = selectCls.getSelectedItem().toString();
        String selectedTermName = selectTrm.getSelectedItem().toString();
        String selectedYear = selectYear.getSelectedItem().toString();

        if (selectedCls.equals("select a class") || selectedTermName.equals("select a term") || selectedYear.equals("Select Year")) {
            JOptionPane.showMessageDialog(this, "please select required fields before search", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int termId = termMap.get(selectedTermName);
        int classId = classMap.get(selectedCls);

        try {
            String sql = "SELECT st.admission_no, CONCAT(st.f_name, ' ', st.l_name) AS student_name, "
                    + "SUM(r.marks) AS total_marks, "
                    + "AVG(r.marks) AS average_marks, "
                    + "MIN(r.marks) AS lowest_mark "
                    + "FROM student_result r "
                    + "INNER JOIN student st ON r.student_id = st.student_id "
                    + "WHERE st.class_id = '" + classId + "' "
                    + "AND r.term_id = '" + termId + "' "
                    + "AND r.exam_year = '" + selectedYear + "' "
                    + "GROUP BY st.student_id, st.admission_no, st.f_name, st.l_name "
                    + "ORDER BY total_marks DESC";

            ResultSet rs = MySQL.execute(sql);
            DefaultTableModel dtm = (DefaultTableModel) classResultsTable.getModel();
            dtm.setRowCount(0);

            int rank = 1;

            int rowCount = 1;
            while (rs.next()) {
                String admissionNo = rs.getString("admission_no");
                String studentName = rs.getString("student_name");
                double totalMarks = rs.getDouble("total_marks");
                double average = rs.getDouble("average_marks");
                double lowestMark = rs.getDouble("lowest_mark");
                String status = (lowestMark < 40) ? "FAILED" : "PASSED";

                Vector<String> v = new Vector<>();
                v.add(String.valueOf(rowCount));
                v.add(String.valueOf(rank));
                v.add(admissionNo);
                v.add(studentName);
                v.add(String.valueOf(totalMarks));
                v.add(String.format("%.2f", average));
                v.add(status);

                dtm.addRow(v);
                rank++;
                rowCount++;
            }

            if (rank == 1) {
                JOptionPane.showMessageDialog(this, "No results found for this class and term for year " + selectedYear, "No Data", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "loadClassResults process filaed", e);
        }
    }//GEN-LAST:event_loadClassResultsBtnActionPerformed

    private void classResultsReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classResultsReportBtnActionPerformed
        try {
            InputStream filePath = getClass().getClassLoader().getResourceAsStream("report/class_results_table_report.jrxml");
            JasperReport report = JasperCompileManager.compileReport(filePath);

            HashMap<String, Object> parameters = new HashMap<>();

            parameters.put("CLASS", selectCls.getSelectedItem().toString());
            parameters.put("TERM", selectTrm.getSelectedItem().toString());
            parameters.put("YEAR", selectYear.getSelectedItem().toString());

            JRTableModelDataSource jRTableModelDataSource = new JRTableModelDataSource(classResultsTable.getModel());
            JasperPrint fillReport = JasperFillManager.fillReport(report, parameters, jRTableModelDataSource);

            JasperViewer.viewReport(fillReport, false);

        } catch (JRException e) {
             LOGGER.log(Level.SEVERE, "ClassResults report generate process failed", e);
        }
    }//GEN-LAST:event_classResultsReportBtnActionPerformed

    private void studentResultsReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentResultsReportBtnActionPerformed
        try {
            InputStream filePath = getClass().getClassLoader().getResourceAsStream("report/student_results_table_report.jrxml");
            JasperReport report = JasperCompileManager.compileReport(filePath);

            HashMap<String, Object> parameters = new HashMap<>();

            parameters.put("ADMISSION", searchStudent.getText().trim());
            parameters.put("CLASS", selectCls.getSelectedItem().toString());
            parameters.put("TERM", selectTrm.getSelectedItem().toString());
            parameters.put("YEAR", selectYear.getSelectedItem().toString());
            parameters.put("TOTAL", totalMarksLabel.getText().trim());
            parameters.put("AVERAGE", averageLabel.getText().trim());
            parameters.put("STATUS", resultLabel.getText().trim());

            JRTableModelDataSource jRTableModelDataSource = new JRTableModelDataSource(resultTable.getModel());
            JasperPrint fillReport = JasperFillManager.fillReport(report, parameters, jRTableModelDataSource);

            JasperViewer.viewReport(fillReport, false);

        } catch (JRException e) {
           LOGGER.log(Level.SEVERE, "Student Results report generate process failed", e);
        }
    }//GEN-LAST:event_studentResultsReportBtnActionPerformed

    private void init() {
        deleteLabel.setIcon(new FlatSVGIcon("lk/kns/school/image/delete.svg", 20, 20));
    }

    public void loadExamTable() {
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `exam` INNER JOIN `class` ON `exam`.`class_id` = `class`.`class_id` "
                    + "INNER JOIN `subject` ON `exam`.`subject_id` = `subject`.`subject_id` "
                    + "INNER JOIN `term` ON `exam`.`term_id` = `term`.`term_id`");

            DefaultTableModel dtm = (DefaultTableModel) examTable.getModel();
            dtm.setRowCount(0);

            int rowCount = 1;
            while (rs.next()) {
                Vector<String> v = new Vector();
                v.add(String.valueOf(rowCount));
                v.add(rs.getString("exam_id"));
                v.add(rs.getString("class_name"));
                v.add(rs.getString("subject_name"));
                v.add(rs.getString("term_name"));
                v.add(rs.getString("date"));
                v.add(rs.getString("start_time"));
                v.add(rs.getString("end_time"));
                v.add(rs.getString("venue"));

                dtm.addRow(v);
                rowCount++;
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "loadExamTable process failed", e);
        }
    }

    private void classLoad() {
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `class`");

            Vector<String> v = new Vector();
            classMap.clear();
            v.add("select a class");

            while (rs.next()) {
                int id = rs.getInt("class_id");
                String name = rs.getString("class_name");

                v.add(name);
                classMap.put(name, id);
            }

            classSelect.setModel(new DefaultComboBoxModel<>(v));
            this.selectClass.setModel(new DefaultComboBoxModel<>(v));
            this.selectCls.setModel(new DefaultComboBoxModel<>(v));

        } catch (SQLException e) {
           LOGGER.log(Level.SEVERE, "Failed to load class list into ComboBox", e);
        }
    }

    private void subjectLoad() {
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `subject`");

            Vector<String> v = new Vector();
            subjectMap.clear();
            v.add("select a subject");

            while (rs.next()) {
                int id = rs.getInt("subject_id");
                String name = rs.getString("subject_name");

                v.add(name);
                subjectMap.put(name, id);
            }

            subjectSelect.setModel(new DefaultComboBoxModel<>(v));

        } catch (SQLException e) {
           LOGGER.log(Level.SEVERE, "Failed to load subject list into ComboBox", e);
        }
    }

    private void termLoad() {
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `term`");

            Vector<String> v = new Vector();
            termMap.clear();
            v.add("select a term");

            while (rs.next()) {
                int id = rs.getInt("term_id");
                String name = rs.getString("term_name");

                v.add(name);
                termMap.put(name, id);
            }

            termSelect.setModel(new DefaultComboBoxModel<>(v));
            this.selectTerm.setModel(new DefaultComboBoxModel<>(v));
            this.selectTrm.setModel(new DefaultComboBoxModel<>(v));

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to load term list into ComboBox", e);
        }
    }

    private void loadYears() {
        int currentYear = Year.now().getValue();
        Vector<String> years = new Vector<>();
        years.add("Select Year");
        for (int i = currentYear - 5; i <= currentYear + 5; i++) {
            years.add(String.valueOf(i));
        }
        selectYear.setModel(new DefaultComboBoxModel<>(years));
        selectYr.setModel(new DefaultComboBoxModel<>(years));
    }

    private void getTableRow() {
        examTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = examTable.getSelectedRow();
                if (row != -1) {
                    selectedExamId = Integer.parseInt(examTable.getValueAt(row, 1).toString());
                    selectedCls = examTable.getValueAt(row, 2).toString();
                    selectedSubject = examTable.getValueAt(row, 3).toString();
                    selectedTerm = examTable.getValueAt(row, 4).toString();
                    selectedDate = examTable.getValueAt(row, 5).toString();
                    selectedStartTime = examTable.getValueAt(row, 6).toString();
                    selectedEndTime = examTable.getValueAt(row, 7).toString();
                    selectedVanue = examTable.getValueAt(row, 8).toString();
                }
            }

        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JscrollPane;
    private javax.swing.JLabel averageLabel;
    private javax.swing.JButton classResultsReportBtn;
    private javax.swing.JTable classResultsTable;
    private javax.swing.JComboBox<String> classSelect;
    private com.toedter.calendar.JDateChooser dateChoose;
    private javax.swing.JLabel deleteLabel;
    private javax.swing.JFormattedTextField endTimeInput;
    private javax.swing.JTable examTable;
    private javax.swing.JLabel examTermLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton loadClassResultsBtn;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JTable resultTable;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchStudent;
    private javax.swing.JComboBox<String> selectClass;
    private javax.swing.JComboBox<String> selectCls;
    private javax.swing.JComboBox<String> selectTerm;
    private javax.swing.JComboBox<String> selectTrm;
    private javax.swing.JComboBox<String> selectYear;
    private javax.swing.JComboBox<String> selectYr;
    private javax.swing.JButton sheduleExmBtn;
    private javax.swing.JFormattedTextField startTimeInput;
    private javax.swing.JButton studentResultsReportBtn;
    private javax.swing.JComboBox<String> subjectSelect;
    private javax.swing.JComboBox<String> termSelect;
    private javax.swing.JLabel totalMarksLabel;
    private javax.swing.JTextField venueInput;
    // End of variables declaration//GEN-END:variables
}
