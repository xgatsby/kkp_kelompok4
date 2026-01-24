package transaksi;

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
import koneksi.koneksi;
import master.branda;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class mutasi extends javax.swing.JFrame {
private Connection conn = new koneksi().connect();
    public mutasi() {
        initComponents();
        tampilkanTanggal();
        tampilData();
        loadComboBoxLokasi();
        loadComboBoxAset();
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
    model.addColumn("ID Mutasi");
    model.addColumn("Tanggal Mutasi");
    model.addColumn("Lokasi Asal");
    model.addColumn("Lokasi Tujuan");
    model.addColumn("ID Aset");

    try {
        String url = "jdbc:mysql://localhost:3306/inventaris_aset";
        String user = "inventaris";
        String pass = "inventaris123";
        Connection conn = DriverManager.getConnection(url, user, pass);

        String sql = "SELECT * FROM mutasi";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("id_mutasi"),
                rs.getDate("tanggal_mutasi"),
                rs.getString("lokasi_asal"),
                rs.getString("lokasi_tujuan"),
                rs.getString("id_aset")
            });
        }

        tabelmutasi.setModel(model);

        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal load data: " + e.getMessage());
}}
    
    
        private void loadComboBoxLokasi() {
    try {
        String sql = "SELECT nama_lokasi FROM lokasi";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        lokasiasal.removeAllItems();
        lokasiasal.addItem("-- Pilih Lokasi Asal --");

        while (rs.next()) {
            lokasiasal.addItem(rs.getString("nama_lokasi"));
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal memuat Nama Member: " + e.getMessage());
    }
}
        
        private void loadComboBoxAset() {
    try {
        String sql = "SELECT id_aset FROM aset";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        idaset.removeAllItems();
        idaset.addItem("-- Pilih ID Aset --");

        while (rs.next()) {
            idaset.addItem(rs.getString("id_aset"));
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal memuat ID Aset: " + e.getMessage());
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
        idmutasi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelmutasi = new javax.swing.JTable();
        simpan = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        bersikan1 = new javax.swing.JButton();
        cariteks = new javax.swing.JTextField();
        cari = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        tanggalmutasi = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        lokasitujuan = new javax.swing.JTextField();
        lokasiasal = new javax.swing.JComboBox<>();
        idaset = new javax.swing.JComboBox<>();
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
        jLabel7.setText("Form Data Mutasi");
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
        jLabel9.setText("Lokasi Asal");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("ID Aset");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("ID Mutasi");

        idmutasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idmutasiActionPerformed(evt);
            }
        });

        tabelmutasi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelmutasi.setGridColor(new java.awt.Color(204, 204, 204));
        tabelmutasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelmutasiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelmutasi);

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
        jLabel12.setText("Tanggal Mutasi");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Lokasi Tujuan");

        lokasitujuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lokasitujuanActionPerformed(evt);
            }
        });

        lokasiasal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        idaset.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                .addGap(194, 194, 194)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(bersikan1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel12))
                                .addGap(58, 58, 58)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idmutasi)
                                    .addComponent(lokasiasal, 0, 174, Short.MAX_VALUE)
                                    .addComponent(tanggalmutasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(idaset, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lokasitujuan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(253, 253, 253)))
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(399, 399, 399)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(idmutasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(lokasitujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(tanggalmutasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idaset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lokasiasal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(laporan)
                        .addGap(1, 1, 1)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1165, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void idmutasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idmutasiActionPerformed

    }//GEN-LAST:event_idmutasiActionPerformed

    private void tabelmutasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelmutasiMouseClicked
        int baris = tabelmutasi.rowAtPoint(evt.getPoint());

        String ID = tabelmutasi.getValueAt(baris, 0).toString();
        String tgl = tabelmutasi.getValueAt(baris, 1).toString();
        String Lok1 = tabelmutasi.getValueAt(baris, 3).toString();
        String Lok2 = tabelmutasi.getValueAt(baris, 4).toString();
        String IDASET = tabelmutasi.getValueAt(baris, 5).toString();

        idmutasi.setText(ID);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(tgl);
            tanggalmutasi.setDate(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        lokasiasal.setSelectedItem(Lok1);
        lokasitujuan.setText(Lok2);
        idaset.setSelectedItem(IDASET);
    }//GEN-LAST:event_tabelmutasiMouseClicked

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        String ID = idmutasi.getText();
        Date TGL = tanggalmutasi.getDate();
        String Lok1 = (String) lokasiasal.getSelectedItem();
        String Lok2 = lokasitujuan.getText();
        String IDASET = (String) idaset.getSelectedItem();

        if (ID.isEmpty() || TGL == null||  Lok1.isEmpty() ||Lok2.isEmpty() || IDASET.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi.");
            return;
        }

        try {
            String url = "jdbc:mysql://localhost:3306/inventaris_aset";
            String user = "inventaris";
            String pass = "inventaris123";

            Connection conn = DriverManager.getConnection(url, user, pass);

            String sql = "INSERT INTO mutasi (id_mutasi, tanggal_mutasi, lokasi_asal, lokasi_tujuan, id_aset) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, ID);
            java.sql.Date sqlDate = new java.sql.Date(TGL.getTime());
            pst.setDate(4, sqlDate);
            pst.setString(2, Lok1);
            pst.setString(3, Lok2);
            pst.setString(6, IDASET);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");

            idmutasi.setText("");
            tanggalmutasi.setDate(null);
            lokasiasal.setSelectedItem(Lok1);
            lokasitujuan.setText(Lok2);
            idaset.setSelectedItem(IDASET);

            conn.close();
            tampilData();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Data gagal disimpan : " + e.getMessage());
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        String ID = idmutasi.getText();
        Date TGL = tanggalmutasi.getDate();
        String Lok1 = (String) lokasiasal.getSelectedItem();
        String Lok2 = lokasitujuan.getText();
        String IDASET = (String) idaset.getSelectedItem();

        if (ID.isEmpty() || TGL == null||  Lok1.isEmpty() ||Lok2.isEmpty() || IDASET.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi.");
            return;
        }
        try {
            String url = "jdbc:mysql://localhost:3306/inventaris_aset";
            String user = "inventaris";
            String pass = "inventaris123";
            Connection conn = DriverManager.getConnection(url, user, pass);

            String sql = "UPDATE mutasi SET tanggal_mutasi=?, lokasi_asal=?, lokasi_tujuan=?, id_aset=? WHERE id_mutasi=?";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, ID);
            java.sql.Date sqlDate = new java.sql.Date(TGL.getTime());
            pst.setDate(4, sqlDate);
            pst.setString(2, Lok1);
            pst.setString(3, Lok2);
            pst.setString(6, IDASET);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data berhasil diubah!");

            conn.close();
            tampilData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengubah data: " + e.getMessage());
        }
    }//GEN-LAST:event_ubahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        int baris = tabelmutasi.getSelectedRow();

        if (baris == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang mau dihapus dulu.");
            return;
        }

        String id = tabelmutasi.getValueAt(baris, 0).toString();

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

                String sql = "DELETE FROM mutasi WHERE id_mutasi = ?";
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

    private void bersikan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bersikan1ActionPerformed
        cariteks.setText("");
        tanggalmutasi.setDate(null);
        idmutasi.setText("");
        lokasiasal.setSelectedIndex(0);
        lokasitujuan.setText("");
        idaset.setSelectedIndex(0);
    }//GEN-LAST:event_bersikan1ActionPerformed

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
            String sql = "SELECT * FROM mutasi WHERE id_mutasi LIKE ? OR tanggal_mutasi LIKE ? OR lokasi_asal LIKE ? OR lokasi_tujuan LIKE ? OR id_aset LIKE ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + key + "%");
            pst.setString(2, "%" + key + "%");
            pst.setString(3, "%" + key + "%");
            pst.setString(4, "%" + key + "%");
            pst.setString(5, "%" + key + "%");
            pst.setString(6, "%" + key + "%");

            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tabelmutasi.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getString("id_mutasi"),
                    rs.getString("tanggal_mutasi"),
                    rs.getString("lokasi_asal"),
                    rs.getString("lokasi_tujuan"),
                    rs.getString("id_aset")

                };
                model.addRow(row);
            }

            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Pencarian gagal: " + e.getMessage());
        }
    }//GEN-LAST:event_cariActionPerformed

    private void lokasitujuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lokasitujuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lokasitujuanActionPerformed

    private void laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanActionPerformed
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/inventaris_aset",
                "inventaris", "inventaris123"
            );
            
            // Try to load .jasper file first
            InputStream report = getClass().getResourceAsStream("/laporan/LaporanDataMutasi.jasper");
            
            // If .jasper doesn't exist, compile from .jrxml
            if (report == null) {
                InputStream jrxmlStream = getClass().getResourceAsStream("/laporan/LaporanDataMutasi.jrxml");
                if (jrxmlStream == null) {
                    JOptionPane.showMessageDialog(null, "File laporan (.jrxml) tidak ditemukan");
                    return;
                }
                // Compile .jrxml to .jasper in memory
                net.sf.jasperreports.engine.JasperReport jasperReport = 
                    net.sf.jasperreports.engine.JasperCompileManager.compileReport(jrxmlStream);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, new HashMap<>(), conn);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setTitle("Laporan Data Mutasi");
                viewer.setVisible(true);
            } else {
                // Use pre-compiled .jasper file
                JasperPrint print = JasperFillManager.fillReport(report, new HashMap<>(), conn);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setTitle("Laporan Data Mutasi");
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
                new mutasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bersikan1;
    private javax.swing.JButton cari;
    private javax.swing.JTextField cariteks;
    private javax.swing.JButton hapus;
    private javax.swing.JComboBox<String> idaset;
    private javax.swing.JTextField idmutasi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton laporan;
    private javax.swing.JComboBox<String> lokasiasal;
    private javax.swing.JTextField lokasitujuan;
    private javax.swing.JButton mutasi;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabelmutasi;
    private javax.swing.JLabel tanggal;
    private com.toedter.calendar.JDateChooser tanggalmutasi;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
