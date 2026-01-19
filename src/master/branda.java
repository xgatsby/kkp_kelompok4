package master;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import transaksi.mutasi;
import transaksi.peminjaman;

public class branda extends javax.swing.JFrame {

    public branda() {
        initComponents();
        tampilkanTanggal();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        member = new javax.swing.JButton();
        aset = new javax.swing.JButton();
        kategori = new javax.swing.JButton();
        lokasi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        peminjaman = new javax.swing.JButton();
        mutasi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(1315, 700));
        jPanel1.setMinimumSize(new java.awt.Dimension(1315, 700));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Halo, Selamat Datang !");

        tanggal.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tanggal.setText("Tanggal Hari ini");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel5.setText("DI SMA NEGERI 62 JAKARTA ");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel6.setText("PERANCANGAN  SISTEM  INVENTARIS ASET ");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel7.setText("Aplikasi Berbasis Desktop");

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Form Data Master");

        member.setBackground(new java.awt.Color(255, 255, 255));
        member.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/USER.png"))); // NOI18N
        member.setText("Data Member");
        member.setBorderPainted(false);
        member.setContentAreaFilled(false);
        member.setFocusPainted(false);
        member.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        member.setMaximumSize(new java.awt.Dimension(96, 28));
        member.setMinimumSize(new java.awt.Dimension(96, 28));
        member.setOpaque(true);
        member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberActionPerformed(evt);
            }
        });

        aset.setBackground(new java.awt.Color(255, 255, 255));
        aset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/CETAK.png"))); // NOI18N
        aset.setText("Data Aset");
        aset.setBorderPainted(false);
        aset.setContentAreaFilled(false);
        aset.setFocusPainted(false);
        aset.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        aset.setMaximumSize(new java.awt.Dimension(96, 28));
        aset.setMinimumSize(new java.awt.Dimension(96, 28));
        aset.setOpaque(true);
        aset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asetActionPerformed(evt);
            }
        });

        kategori.setBackground(new java.awt.Color(255, 255, 255));
        kategori.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/KRITERIA.png"))); // NOI18N
        kategori.setText("Data Kategori");
        kategori.setBorderPainted(false);
        kategori.setContentAreaFilled(false);
        kategori.setFocusPainted(false);
        kategori.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kategori.setMaximumSize(new java.awt.Dimension(96, 28));
        kategori.setMinimumSize(new java.awt.Dimension(96, 28));
        kategori.setOpaque(true);
        kategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kategoriActionPerformed(evt);
            }
        });

        lokasi.setBackground(new java.awt.Color(255, 255, 255));
        lokasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/CETAK.png"))); // NOI18N
        lokasi.setText("Data Lokasi");
        lokasi.setBorderPainted(false);
        lokasi.setContentAreaFilled(false);
        lokasi.setFocusPainted(false);
        lokasi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lokasi.setMaximumSize(new java.awt.Dimension(96, 28));
        lokasi.setMinimumSize(new java.awt.Dimension(96, 28));
        lokasi.setOpaque(true);
        lokasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lokasiActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Form Data Transaksi");

        peminjaman.setBackground(new java.awt.Color(255, 255, 255));
        peminjaman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/PENILAIAN.png"))); // NOI18N
        peminjaman.setText("Peminjaman Aset");
        peminjaman.setBorderPainted(false);
        peminjaman.setContentAreaFilled(false);
        peminjaman.setFocusPainted(false);
        peminjaman.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        peminjaman.setMaximumSize(new java.awt.Dimension(96, 28));
        peminjaman.setMinimumSize(new java.awt.Dimension(96, 28));
        peminjaman.setOpaque(true);
        peminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peminjamanActionPerformed(evt);
            }
        });

        mutasi.setBackground(new java.awt.Color(255, 255, 255));
        mutasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/EDIT.png"))); // NOI18N
        mutasi.setText("Mutasi Aset");
        mutasi.setBorderPainted(false);
        mutasi.setContentAreaFilled(false);
        mutasi.setFocusPainted(false);
        mutasi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mutasi.setMaximumSize(new java.awt.Dimension(96, 28));
        mutasi.setMinimumSize(new java.awt.Dimension(96, 28));
        mutasi.setOpaque(true);
        mutasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mutasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mutasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lokasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(peminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(kategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(member, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(member, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(peminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mutasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(172, 172, 172))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(238, 238, 238))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(tanggal)
                                .addContainerGap())))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tanggal))))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1133, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kategoriActionPerformed
    new kategori().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_kategoriActionPerformed

    private void lokasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lokasiActionPerformed
    new lokasi().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_lokasiActionPerformed

    private void mutasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mutasiActionPerformed
    new mutasi().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_mutasiActionPerformed

    private void peminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peminjamanActionPerformed
    new peminjaman().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_peminjamanActionPerformed

    private void memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberActionPerformed
    new member().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_memberActionPerformed

    private void asetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asetActionPerformed
    new aset().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_asetActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new branda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton kategori;
    private javax.swing.JButton lokasi;
    private javax.swing.JButton member;
    private javax.swing.JButton mutasi;
    private javax.swing.JButton peminjaman;
    private javax.swing.JLabel tanggal;
    // End of variables declaration//GEN-END:variables
}
