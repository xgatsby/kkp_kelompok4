/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author audre
 */
public class member extends javax.swing.JFrame {


    public member() {
        initComponents();
        tampilkanTanggal();
        tampilData();
        
    }

    private void tampilkanTanggal() {
        javax.swing.Timer timer = new javax.swing.Timer(60000, (e) -> {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("EEEE, dd MMMM yyyy");
            String tgl = sdf.format(new java.util.Date());
            tanggal.setText(tgl);
        });
        timer.start();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("EEEE, dd MMMM yyyy");
        String tgl = sdf.format(new java.util.Date());
        tanggal.setText(tgl);
    }
    
        private void tampilData() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID Member");
    model.addColumn("Nama Member");
    model.addColumn("Kontak");

    try {
        String url = "jdbc:mysql://localhost:3306/inventaris_aset";
        String user = "inventaris";
        String pass = "inventaris123";
        Connection conn = DriverManager.getConnection(url, user, pass);

        String sql = "SELECT * FROM member";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("id_member"),
                rs.getString("nama_member"),
                rs.getString("kontak")
            });
        }

        tabelmember.setModel(model);

        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal load data: " + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        mutasi = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        idmember = new javax.swing.JTextField();
        namamember = new javax.swing.JTextField();
        kontak = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelmember = new javax.swing.JTable();
        simpan = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        bersikan1 = new javax.swing.JButton();
        cariteks = new javax.swing.JTextField();
        cari = new javax.swing.JButton();
        laporan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(1315, 700));
        jPanel1.setMinimumSize(new java.awt.Dimension(1315, 700));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Halo, Selamat Datang !");

        tanggal.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tanggal.setText("Tanggal Hari ini");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel7.setText("Form Data Member");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel8.setText("______________________________________");

        mutasi.setBackground(new java.awt.Color(255, 255, 255));
        mutasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BRANDA.png"))); // NOI18N
        mutasi.setText("Branda");
        mutasi.setBorderPainted(false);
        mutasi.setContentAreaFilled(false);
        mutasi.setFocusPainted(false);
        mutasi.setMaximumSize(new java.awt.Dimension(96, 28));
        mutasi.setMinimumSize(new java.awt.Dimension(96, 28));
        mutasi.setOpaque(true);
        mutasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mutasiActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Nama Member");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Kontak");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("ID Member");

        idmember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idmemberActionPerformed(evt);
            }
        });

        namamember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namamemberActionPerformed(evt);
            }
        });

        kontak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontakActionPerformed(evt);
            }
        });

        tabelmember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelmember.setGridColor(new java.awt.Color(204, 204, 204));
        tabelmember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelmemberMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelmember);

        simpan.setBackground(new java.awt.Color(204, 204, 204));
        simpan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        simpan.setText("SIMPAN");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        ubah.setBackground(new java.awt.Color(204, 204, 204));
        ubah.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ubah.setText("UBAH");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        hapus.setBackground(new java.awt.Color(204, 204, 204));
        hapus.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        hapus.setText("HAPUS");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        bersikan1.setBackground(new java.awt.Color(204, 204, 204));
        bersikan1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        bersikan1.setText("BERSIKAN");
        bersikan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bersikan1ActionPerformed(evt);
            }
        });

        cari.setBackground(new java.awt.Color(255, 255, 255));
        cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/CARI.png"))); // NOI18N
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        laporan.setBackground(new java.awt.Color(255, 255, 255));
        laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/LAPORAN.png"))); // NOI18N
        laporan.setBorderPainted(false);
        laporan.setContentAreaFilled(false);
        laporan.setFocusPainted(false);
        laporan.setOpaque(true);
        laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(404, 404, 404)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(bersikan1))
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(96, 96, 96)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(namamember, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(idmember, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(kontak, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(0, 230, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cariteks, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cari)
                        .addGap(64, 64, 64)
                        .addComponent(mutasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tanggal)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mutasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cariteks, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(cari))
                .addGap(10, 10, 10)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(idmember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(namamember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(kontak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(laporan)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan)
                    .addComponent(ubah)
                    .addComponent(hapus)
                    .addComponent(bersikan1))
                .addGap(21, 21, 21)
                .addComponent(tanggal)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1184, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mutasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mutasiActionPerformed
        new branda().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mutasiActionPerformed

    private void idmemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idmemberActionPerformed

    }//GEN-LAST:event_idmemberActionPerformed

    private void namamemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namamemberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namamemberActionPerformed

    private void kontakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kontakActionPerformed

    private void tabelmemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelmemberMouseClicked
        int baris = tabelmember.rowAtPoint(evt.getPoint());

        String ID = tabelmember.getValueAt(baris, 0).toString();
        String Nama = tabelmember.getValueAt(baris, 1).toString();
        String Kontak = tabelmember.getValueAt(baris, 2).toString();
        idmember.setText(ID);
        namamember.setText(Nama);
        kontak.setText(Kontak);
    }//GEN-LAST:event_tabelmemberMouseClicked

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        String ID = idmember.getText();
        String Nama = namamember.getText();
        String Kontak = kontak.getText();

        if (ID.isEmpty() || Nama.isEmpty()|| Kontak.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi.");
            return;
        }

        try {
            String url = "jdbc:mysql://localhost:3306/inventaris_aset";
            String user = "inventaris";
            String pass = "inventaris123";

            Connection conn = DriverManager.getConnection(url, user, pass);

            String sql = "INSERT INTO member (id_member, nama_member, kontak) VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, ID);
            pst.setString(2, Nama);
            pst.setString(3, Kontak);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");

            idmember.setText("");
            namamember.setText("");
            kontak.setText("");

            conn.close();
            tampilData();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Data gagal disimpan : " + e.getMessage());
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        String ID = idmember.getText();
        String Nama = namamember.getText();
        String Kontak = kontak.getText();

        if (ID.isEmpty() || Nama.isEmpty()|| Kontak.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi untuk update.");
            return;
        }

        try {
            String url = "jdbc:mysql://localhost:3306/inventaris_aset";
            String user = "inventaris";
            String pass = "inventaris123";
            Connection conn = DriverManager.getConnection(url, user, pass);

            String sql = "UPDATE member SET nama_member=?, kontak=? WHERE id_member=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, ID);
            pst.setString(2, Nama);
            pst.setString(3, Kontak);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data berhasil diubah!");

            conn.close();
            tampilData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengubah data: " + e.getMessage());
        }
    }//GEN-LAST:event_ubahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        int baris = tabelmember.getSelectedRow();

        if (baris == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang mau dihapus dulu.");
            return;
        }

        String id = tabelmember.getValueAt(baris, 0).toString();

        int konfirmasi = JOptionPane.showConfirmDialog(
            this,
            "Yakin mau hapus data dengan ID " + id + "?",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION
        );

        if (konfirmasi == JOptionPane.YES_OPTION) {
            try {
                String url = "jdbc:mysql://localhost:3306/inventaris_aset";
                String user = "inventaris";
                String pass = "inventaris123";

                Connection conn = DriverManager.getConnection(url, user, pass);

                String sql = "DELETE FROM member WHERE id_member = ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, id);

                int affected = pst.executeUpdate();
                if (affected > 0) {
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
                } else {
                    JOptionPane.showMessageDialog(this, "Data tidak ditemukan / gagal dihapus!");
                }

                tampilData();

                conn.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Data gagal dihapus: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        String key = cariteks.getText().trim();

        if (key.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan kata kunci pencarian!");
            return;
        }

        try {
            String url = "jdbc:mysql://localhost:3306/inventaris_aset";
            String user = "inventaris";
            String pass = "inventaris123";

            Connection conn = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT * FROM member WHERE id_member LIKE ? OR nama_member LIKE ?OR kontak LIKE ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + key + "%");
            pst.setString(2, "%" + key + "%");
            pst.setString(3, "%" + key + "%");

            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tabelmember.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getString("id_member"),
                    rs.getString("nama_member"),
                    rs.getString("kontak")
                };
                model.addRow(row);
            }

            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Pencarian gagal: " + e.getMessage());
        }
    }//GEN-LAST:event_cariActionPerformed

    private void bersikan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bersikan1ActionPerformed
        cariteks.setText("");
        idmember.setText("");
        namamember.setText("");
        kontak.setText("");
    }//GEN-LAST:event_bersikan1ActionPerformed

    private void laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanActionPerformed
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/inventaris_aset",
                "inventaris", "inventaris123"
            );
            
            // Try to load .jasper file first
            InputStream report = getClass().getResourceAsStream("/laporan/LaporanDataMember.jasper");
            
            // If .jasper doesn't exist, compile from .jrxml
            if (report == null) {
                InputStream jrxmlStream = getClass().getResourceAsStream("/laporan/LaporanDataMember.jrxml");
                if (jrxmlStream == null) {
                    JOptionPane.showMessageDialog(null, "File laporan (.jrxml) tidak ditemukan");
                    return;
                }
                // Compile .jrxml to .jasper in memory
                net.sf.jasperreports.engine.JasperReport jasperReport = 
                    net.sf.jasperreports.engine.JasperCompileManager.compileReport(jrxmlStream);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, new HashMap<>(), conn);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setTitle("Laporan Data Member");
                viewer.setVisible(true);
            } else {
                // Use pre-compiled .jasper file
                JasperPrint print = JasperFillManager.fillReport(report, new HashMap<>(), conn);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setTitle("Laporan Data Member");
                viewer.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal mencetak laporan: " + e.getMessage());
        }
    }//GEN-LAST:event_laporanActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bersikan1;
    private javax.swing.JButton cari;
    private javax.swing.JTextField cariteks;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField idmember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kontak;
    private javax.swing.JButton laporan;
    private javax.swing.JButton mutasi;
    private javax.swing.JTextField namamember;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabelmember;
    private javax.swing.JLabel tanggal;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
