package lk.kns.school.studentSidePanels;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.kns.school.connection.MySQL;
import lk.kns.school.util.Session;
import raven.toast.Notifications;

public class ExamAdmissionsPanel extends javax.swing.JPanel {

    public ExamAdmissionsPanel() {
        initComponents();
        init();
        loadExams();
    }

    private void init() {
        examTable.setRowSelectionAllowed(true);
        examTable.setColumnSelectionAllowed(false);
        examTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    }

    private void loadExams() {
        try {
            String query = "SELECT e.exam_id, s.subject_name, t.term_name, e.date, e.start_time, e.venue "
                    + "FROM `exam` e "
                    + "INNER JOIN `subject` s ON e.subject_id = s.subject_id "
                    + "INNER JOIN `term` t ON e.term_id = t.term_id "
                    + "WHERE e.class_id = '" + Session.classId + "'";

            ResultSet rs = MySQL.execute(query);

            DefaultTableModel dtm = (DefaultTableModel) examTable.getModel();
            dtm.setRowCount(0);

            int rowCount = 1;
            while (rs.next()) {
                Vector<String> v = new Vector<>();
                v.add(String.valueOf(rowCount++));
                v.add(rs.getString("exam_id"));
                v.add(rs.getString("subject_name"));
                v.add(rs.getString("term_name"));
                v.add(rs.getString("date") + " @ " + rs.getString("start_time") + " (" + rs.getString("venue") + ")");

                dtm.addRow(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        examTable = new javax.swing.JTable();
        generatePassBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(43, 43, 43));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EXAM ADMISSIONS & HALL TICKETS");

        examTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Exam ID", "Subject", "Term", "Exam Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        examTable.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(examTable);
        examTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        generatePassBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        generatePassBtn.setForeground(new java.awt.Color(102, 0, 0));
        generatePassBtn.setText("Generate QR Admission Pass");
        generatePassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatePassBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(406, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(381, 381, 381))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(generatePassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(generatePassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(314, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void generatePassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatePassBtnActionPerformed
        int selectedRow = examTable.getSelectedRow();

        if (selectedRow == -1) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, 2000, "Please select an exam from the table first!");
            return;
        }

        // Extract data from the selected row
        String examId = examTable.getValueAt(selectedRow, 1).toString();
        String subject = examTable.getValueAt(selectedRow, 2).toString();
        String term = examTable.getValueAt(selectedRow, 3).toString();
        String scheduleDetails = examTable.getValueAt(selectedRow, 4).toString();

        // Create the unique data string to embed INSIDE the QR Code
        String qrData = "VERIFIED KNS STUDENT\n"
                + "Student ID: " + Session.studentId + "\n"
                + "Name: " + Session.studentName + "\n"
                + "Exam ID: " + examId + "\n"
                + "Subject: " + subject + "\n"
                + "Term: " + term + "\n"
                + "Schedule: " + scheduleDetails;

        try {
            // Generate the QR Code using ZXing
            QRCodeWriter barcodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = barcodeWriter.encode(qrData, BarcodeFormat.QR_CODE, 250, 250);
            BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

            // Create the Digital Hall Ticket UI
            ImageIcon qrIcon = new ImageIcon(qrImage);

            String ticketMessage = "<html><body style='text-align: center; width: 250px; font-family: Arial;'>"
                    + "<h2 style='color: #2c3e50;'>KNS Hall Ticket</h2>"
                    + "<p><b>Name:</b> " + Session.studentName + "<br>"
                    + "<b>Subject:</b> " + subject + "<br>"
                    + "<b>Term:</b> " + term + "<br>"
                    + "<b style='color: #c0392b;'>" + scheduleDetails + "</b></p><br>"
                    + "<i style='font-size: 10px; color: #7f8c8d;'>Please present this QR code at the exam hall entrance.</i>"
                    + "</body></html>";

            JOptionPane.showMessageDialog(
                    this,
                    ticketMessage,
                    "Official Admission Pass",
                    JOptionPane.PLAIN_MESSAGE,
                    qrIcon
            );

        } catch (WriterException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error generating QR Code: " + e.getMessage(), "Generation Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_generatePassBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable examTable;
    private javax.swing.JButton generatePassBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
