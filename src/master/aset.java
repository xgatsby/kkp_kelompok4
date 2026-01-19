package master;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class aset extends javax.swing.JFrame {

    public aset() {
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
    model.addColumn("ID Aset");
    model.addColumn("Nama Aset");
    model.addColumn("Tanggal Masuk");
    model.addColumn("Kondisi");

    try {
        String url = "jdbc:mysql://localhost:3306/inventaris_aset";
        String user = "inventaris";
        String pass = "inventaris123";
        Connection conn = DriverManager.getConnection(url, user, pass);

        String sql = "SELECT * FROM aset";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("id_aset"),
                rs.getString("nama_aset"),
                rs.getDate("tanggal_masuk"),
                rs.getString("kondisi")
            });
        }

        tabelaset.setModel(model);

        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal load data: " + e.getMessage());
}}
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
        idaset = new javax.swing.JTextField();
        namaaset = new javax.swing.JTextField();
        kondisi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaset = new javax.swing.JTable();
        simpan = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        bersikan1 = new javax.swing.JButton();
        cariteks = new javax.swing.JTextField();
        cari = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        tanggalmasuk = new com.toedter.calendar.JDateChooser();
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
        jLabel7.setText("Form Data Aset");
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
        jLabel9.setText("Nama Aset");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Kondisi");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("ID Aset");

        idaset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idasetActionPerformed(evt);
            }
        });

        namaaset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaasetActionPerformed(evt);
            }
        });

        kondisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kondisiActionPerformed(evt);
            }
        });

        tabelaset.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaset.setGridColor(new java.awt.Color(204, 204, 204));
        tabelaset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelasetMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaset);

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

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Tanggal");

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
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(435, 435, 435)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel9))
                            .addGap(47, 47, 47)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(namaaset, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                .addComponent(idaset))
                            .addGap(65, 65, 65)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel10))
                            .addGap(49, 49, 49)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tanggalmasuk, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                .addComponent(kondisi)))
                        .addComponent(jScrollPane1)))
                .addGap(0, 230, Short.MAX_VALUE))
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(idaset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addComponent(tanggalmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(namaaset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(kondisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(laporan)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
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
                .addContainerGap()
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1184, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            String sql = "SELECT * FROM aset WHERE id_aset LIKE ? OR nama_aset LIKE ? OR tanggal_masuk LIKE ?OR kondisi LIKE ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + key + "%");
            pst.setString(2, "%" + key + "%");
            pst.setString(3, "%" + key + "%");
            pst.setString(4, "%" + key + "%");

            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tabelaset.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getString("id_aset"),
                    rs.getString("nama_aset"),
                    rs.getString("tanggal_masuk"),
                    rs.getString("kondisi")
                };
                model.addRow(row);
            }

            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Pencarian gagal: " + e.getMessage());
        }
    }//GEN-LAST:event_cariActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        int baris = tabelaset.getSelectedRow();

        if (baris == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang mau dihapus dulu.");
            return;
        }

        String id = tabelaset.getValueAt(baris, 0).toString();

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

                String sql = "DELETE FROM aset WHERE id_aset = ?";
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

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        String ID = idaset.getText();
        String Nama = namaaset.getText();
        Date TGL = tanggalmasuk.getDate();
        String Kondisi = kondisi.getText();

        if (ID.isEmpty() || Nama.isEmpty() || TGL == null || Kondisi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi.");
            return;
        }

        try {
            String url = "jdbc:mysql://localhost:3306/inventaris_aset";
            String user = "inventaris";
            String pass = "inventaris123";
            Connection conn = DriverManager.getConnection(url, user, pass);

            String sql = "UPDATE aset SET nama_aset=?, tanggal_masuk=?, kondisi=? WHERE id_aset=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, Nama);
            java.sql.Date sqlDate = new java.sql.Date(TGL.getTime());
            pst.setDate(2, sqlDate);
            pst.setString(3, Kondisi);
            pst.setString(4, ID);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data berhasil diubah!");

            conn.close();
            tampilData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengubah data: " + e.getMessage());
        }
    }//GEN-LAST:event_ubahActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        String ID = idaset.getText();
        String Nama = namaaset.getText();
        Date TGL = tanggalmasuk.getDate();
        String Kondisi = kondisi.getText();

        if (ID.isEmpty() || Nama.isEmpty() || TGL == null || Kondisi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi.");
            return;
        }

        try {
            String url = "jdbc:mysql://localhost:3306/inventaris_aset";
            String user = "inventaris";
            String pass = "inventaris123";

            Connection conn = DriverManager.getConnection(url, user, pass);

            String sql = "INSERT INTO aset (id_aset, nama_aset, tanggal_masuk, kondisi) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, ID);
            pst.setString(2, Nama);
            java.sql.Date sqlDate = new java.sql.Date(TGL.getTime());
            pst.setDate(3, sqlDate);
            pst.setString(4, Kondisi);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");

            idaset.setText("");
            namaaset.setText("");
            tanggalmasuk.setDate(null);
            kondisi.setText("");

            conn.close();
            tampilData();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Data gagal disimpan : " + e.getMessage());
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void tabelasetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelasetMouseClicked
        int baris = tabelaset.rowAtPoint(evt.getPoint());

        String ID = tabelaset.getValueAt(baris, 0).toString();
        String Nama = tabelaset.getValueAt(baris, 1).toString();
        String tgl = tabelaset.getValueAt(baris, 2).toString();
        String Kontak = tabelaset.getValueAt(baris, 3).toString();

        idaset.setText(ID);
        namaaset.setText(Nama);
        kondisi.setText(Kontak);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(tgl);
            tanggalmasuk.setDate(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tabelasetMouseClicked

    private void kondisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kondisiActionPerformed

    }//GEN-LAST:event_kondisiActionPerformed

    private void namaasetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaasetActionPerformed

    }//GEN-LAST:event_namaasetActionPerformed

    private void idasetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idasetActionPerformed

    }//GEN-LAST:event_idasetActionPerformed

    private void mutasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mutasiActionPerformed
        new branda().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mutasiActionPerformed

    private void bersikan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bersikan1ActionPerformed
        cariteks.setText("");
        idaset.setText("");
        namaaset.setText("");
        tanggalmasuk.setDate(null);
        kondisi.setText("");
    }//GEN-LAST:event_bersikan1ActionPerformed

    private void laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanActionPerformed
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/inventaris_aset",
                "inventaris", "inventaris123"
            );
            InputStream report = getClass().getResourceAsStream("/laporan/LaporanDataAset.jasper");
            if (report == null) {
                JOptionPane.showMessageDialog(null, "Laporan tidak ditemukan");
                return;
            }
            JasperPrint print = JasperFillManager.fillReport(report, new HashMap<>(), conn);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setTitle("Laporan Data Aset");
            viewer.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal mencetak laporan: " + e.getMessage());
        }
    }//GEN-LAST:event_laporanActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new aset().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bersikan1;
    private javax.swing.JButton cari;
    private javax.swing.JTextField cariteks;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField idaset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kondisi;
    private javax.swing.JButton laporan;
    private javax.swing.JButton mutasi;
    private javax.swing.JTextField namaaset;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabelaset;
    private javax.swing.JLabel tanggal;
    private com.toedter.calendar.JDateChooser tanggalmasuk;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
