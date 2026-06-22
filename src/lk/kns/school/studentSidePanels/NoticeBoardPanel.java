package lk.kns.school.studentSidePanels;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import lk.kns.school.connection.MySQL;
import lk.kns.school.util.Session;

public class NoticeBoardPanel extends javax.swing.JPanel {

    public NoticeBoardPanel() {
        initComponents();
        init();
        loadNotices();
    }

    private void init() {
        noticeTable.getColumnModel().getColumn(3).setMinWidth(0);
        noticeTable.getColumnModel().getColumn(3).setMaxWidth(0);
        noticeTable.getColumnModel().getColumn(3).setWidth(0);

        refreshBtn.addActionListener(evt -> {
            loadNotices();
            messageDetailsBox.setText("");
        });

        noticeTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && noticeTable.getSelectedRow() != -1) {

                    String fullMessage = noticeTable.getValueAt(noticeTable.getSelectedRow(), 3).toString();

                    messageDetailsBox.setText(fullMessage);
                    messageDetailsBox.setCaretPosition(0);
                }
            }
        });
    }

    private void loadNotices() {
        try {
            ResultSet rs = MySQL.execute("SELECT `date_posted`, `title`, `message` FROM `announcement` "
                    + "WHERE `class_id` = '" + Session.classId + "' "
                    + "ORDER BY `date_posted` DESC");

            DefaultTableModel dtm = (DefaultTableModel) noticeTable.getModel();
            dtm.setRowCount(0);

            int rowCount = 1;
            while (rs.next()) {
                Vector<String> v = new Vector<>();
                v.add(String.valueOf(rowCount++));
                v.add(rs.getString("date_posted"));
                v.add(rs.getString("title"));
                v.add(rs.getString("message"));

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
        refreshBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        noticeTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageDetailsBox = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(43, 43, 43));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Class Notice Board");

        refreshBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        refreshBtn.setText("Refresh Notices");

        noticeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Date Posted", "Announcement Title", "Hidden Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(noticeTable);

        jLabel2.setText("Message Details:");

        messageDetailsBox.setEditable(false);
        messageDetailsBox.setColumns(20);
        messageDetailsBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        messageDetailsBox.setLineWrap(true);
        messageDetailsBox.setRows(5);
        messageDetailsBox.setWrapStyleWord(true);
        jScrollPane2.setViewportView(messageDetailsBox);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 540, Short.MAX_VALUE)
                        .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea messageDetailsBox;
    private javax.swing.JTable noticeTable;
    private javax.swing.JButton refreshBtn;
    // End of variables declaration//GEN-END:variables
}
