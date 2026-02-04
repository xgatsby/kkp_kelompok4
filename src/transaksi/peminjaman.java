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


public class peminjaman extends javax.swing.JFrame {
    private Connection conn;

    public peminjaman() {
        initComponents();
        
        // Initialize connection with error handling
        try {
            conn = new koneksi().connect();
            if (conn == null) {
                JOptionPane.showMessageDialog(this, 
                    "Gagal koneksi ke database!\n\n" +
                    "Pastikan:\n" +
                    "1. MySQL/Laragon sudah berjalan\n" +
                    "2. Database 'inventaris_aset' sudah dibuat\n" +
                    "3. User 'inventaris' dengan password 'inventaris123' sudah ada\n\n" +
                    "Aplikasi akan tetap berjalan tapi fitur database tidak akan bekerja.",
                    "Error Koneksi Database",
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error saat koneksi database: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
        
        tampilkanTanggal();
        if (conn != null) {
            tampilData();
            loadComboBoxMember();
            loadComboBoxAset();
        }
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
    model.addColumn("ID Peminjam");
    model.addColumn("Nama Member");
    model.addColumn("Status");
    model.addColumn("Tanggal Masuk");
    model.addColumn("Tanggal Keluar");
    model.addColumn("ID Aset");

    try {
        String url = "jdbc:mysql://localhost:3306/inventaris_aset";
        String user = "inventaris";
        String pass = "inventaris123";
        Connection conn = DriverManager.getConnection(url, user, pass);

        String sql = "SELECT * FROM peminjaman";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("id_peminjaman"),
                rs.getString("nama_member"),
                rs.getString("status"),
                rs.getDate("tanggal_masuk"),
                rs.getDate("tanggal_keluar"),
                rs.getString("id_aset")
            });
        }

        tabelpeminjaman.setModel(model);

        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal load data: " + e.getMessage());
}}
    
    
        private void loadComboBoxMember() {
    if (conn == null) {
        namamember.removeAllItems();
        namamember.addItem("-- Database tidak terhubung --");
        return;
    }
    
    try {
        String sql = "SELECT nama_member FROM member";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        namamember.removeAllItems();
        namamember.addItem("-- Pilih Nama Member --");

        while (rs.next()) {
            namamember.addItem(rs.getString("nama_member"));
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal memuat Nama Member: " + e.getMessage());
    }
}
        
        private void loadComboBoxAset() {
    if (conn == null) {
        idaset.removeAllItems();
        idaset.addItem("-- Database tidak terhubung --");
        return;
    }
    
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
        idpeminjaman = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpeminjaman = new javax.swing.JTable();
        simpan = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        bersikan1 = new javax.swing.JButton();
        cariteks = new javax.swing.JTextField();
        cari = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        tanggalmasuk = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        status = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tanggalkeluar = new com.toedter.calendar.JDateChooser();
        namamember = new javax.swing.JComboBox<>();
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
        jLabel7.setText("Form Data Peminjaman");
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
        jLabel10.setText("ID Aset");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("ID Peminjam");

        idpeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idpeminjamanActionPerformed(evt);
            }
        });

        tabelpeminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelpeminjaman.setGridColor(new java.awt.Color(204, 204, 204));
        tabelpeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpeminjamanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelpeminjaman);

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
        jLabel12.setText("Tanggal Masuk");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Status");

        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Tanggal Keluar");

        namamember.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        idaset.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        laporan.setBackground(new java.awt.Color(255, 255, 255));
        laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/LAPORAN.png"))); // NOI18N
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel9))
                                        .addGap(60, 60, 60)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(idpeminjaman)
                                            .addComponent(namamember, 0, 174, Short.MAX_VALUE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tanggalkeluar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tanggalmasuk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(idaset, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 182, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(373, 373, 373))
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(idpeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel14)
                            .addComponent(namamember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tanggalmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tanggalkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(idaset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(laporan))
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

    private void idpeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idpeminjamanActionPerformed

    }//GEN-LAST:event_idpeminjamanActionPerformed

    private void tabelpeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpeminjamanMouseClicked
        int baris = tabelpeminjaman.rowAtPoint(evt.getPoint());

        String ID = tabelpeminjaman.getValueAt(baris, 0).toString();
        String Nama = tabelpeminjaman.getValueAt(baris, 1).toString();
        String Status = tabelpeminjaman.getValueAt(baris, 2).toString();
        String tgl = tabelpeminjaman.getValueAt(baris, 3).toString();
        String tgl2 = tabelpeminjaman.getValueAt(baris, 4).toString();
        String IDASET = tabelpeminjaman.getValueAt(baris, 5).toString();

        idpeminjaman.setText(ID);
        namamember.setSelectedItem(Nama);
        status.setText(Status);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(tgl);
            tanggalmasuk.setDate(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(tgl2);
            tanggalkeluar.setDate(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        idaset.setSelectedItem(IDASET);
    }//GEN-LAST:event_tabelpeminjamanMouseClicked

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        String ID = idpeminjaman.getText();
        String Nama = (String) namamember.getSelectedItem();
        String Status = status.getText();
        Date TGL = tanggalmasuk.getDate();
        Date TGL2 = tanggalkeluar.getDate();
        String IDASET = (String) idaset.getSelectedItem();

        if (ID.isEmpty() || Nama.isEmpty() ||Status.isEmpty() || TGL == null ||TGL2 == null || IDASET.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi.");
            return;
        }

        try {
            String url = "jdbc:mysql://localhost:3306/inventaris_aset";
            String user = "inventaris";
            String pass = "inventaris123";

            Connection conn = DriverManager.getConnection(url, user, pass);

            String sql = "INSERT INTO peminjaman (id_peminjaman, nama_member, status, tanggal_masuk, tanggal_keluar, id_aset) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, ID);
            pst.setString(2, Nama);
            pst.setString(3, Status);
            java.sql.Date sqlDate = new java.sql.Date(TGL.getTime());
            pst.setDate(4, sqlDate);
            java.sql.Date sqlDate2 = new java.sql.Date(TGL2.getTime());
            pst.setDate(5, sqlDate2);
            pst.setString(6, IDASET);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");

            idpeminjaman.setText("");
            namamember.setSelectedItem(Nama);
            status.setText(Status);
            tanggalmasuk.setDate(null);
            tanggalkeluar.setDate(null);
            idaset.setSelectedItem(IDASET);

            conn.close();
            tampilData();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Data gagal disimpan : " + e.getMessage());
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        String ID = idpeminjaman.getText();
        String Nama = (String) namamember.getSelectedItem();
        String Status = status.getText();
        Date TGL = tanggalmasuk.getDate();
        Date TGL2 = tanggalkeluar.getDate();
        String IDASET = (String) idaset.getSelectedItem();

        if (ID.isEmpty() || Nama.isEmpty() ||Status.isEmpty() || TGL == null ||TGL2 == null || IDASET.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi.");
            return;
        }

        try {
            String url = "jdbc:mysql://localhost:3306/inventaris_aset";
            String user = "inventaris";
            String pass = "inventaris123";
            Connection conn = DriverManager.getConnection(url, user, pass);

            String sql = "UPDATE peminjaman SET nama_member=?, status=?, tanggal_masuk=?, tanggal_keluar=?, id_aset=? WHERE id_peminjaman=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, ID);
            pst.setString(2, Nama);
            pst.setString(3, Status);
            java.sql.Date sqlDate = new java.sql.Date(TGL.getTime());
            pst.setDate(4, sqlDate);
            java.sql.Date sqlDate2 = new java.sql.Date(TGL2.getTime());
            pst.setDate(5, sqlDate2);
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
        int baris = tabelpeminjaman.getSelectedRow();

        if (baris == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang mau dihapus dulu.");
            return;
        }

        String id = tabelpeminjaman.getValueAt(baris, 0).toString();

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

                String sql = "DELETE FROM peminjaman WHERE id_peminjaman = ?";
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
        idpeminjaman.setText("");
        namamember.setSelectedIndex(0);
        status.setText("");
        tanggalmasuk.setDate(null);
        tanggalkeluar.setDate(null);
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
            String sql = "SELECT * FROM peminjaman WHERE id_peminjaman LIKE ? OR nama_member LIKE ? OR status LIKE ? OR tanggal_masuk LIKE ? OR tanggal_keluar LIKE ?OR id_aset LIKE ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + key + "%");
            pst.setString(2, "%" + key + "%");
            pst.setString(3, "%" + key + "%");
            pst.setString(4, "%" + key + "%");
            pst.setString(5, "%" + key + "%");
            pst.setString(6, "%" + key + "%");

            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tabelpeminjaman.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                    rs.getString("id_peminjaman"),
                    rs.getString("nama_member"),
                    rs.getString("status"),
                    rs.getString("tanggal_masuk"),
                    rs.getString("tanggal_keluar"),
                    rs.getString("id_aset")
                    
                };
                model.addRow(row);
            }

            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Pencarian gagal: " + e.getMessage());
        }
    }//GEN-LAST:event_cariActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanActionPerformed
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/inventaris_aset",
                "inventaris", "inventaris123"
            );
            
            // Try to load .jasper file first
            InputStream report = getClass().getResourceAsStream("/laporan/LaporanDataPeminjaman.jasper");
            
            // If .jasper doesn't exist, compile from .jrxml
            if (report == null) {
                InputStream jrxmlStream = getClass().getResourceAsStream("/laporan/LaporanDataPeminjaman.jrxml");
                if (jrxmlStream == null) {
                    JOptionPane.showMessageDialog(null, "File laporan (.jrxml) tidak ditemukan");
                    return;
                }
                // Compile .jrxml to .jasper in memory
                net.sf.jasperreports.engine.JasperReport jasperReport = 
                    net.sf.jasperreports.engine.JasperCompileManager.compileReport(jrxmlStream);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, new HashMap<>(), conn);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setTitle("Laporan Data Peminjaman");
                viewer.setVisible(true);
            } else {
                // Use pre-compiled .jasper file
                JasperPrint print = JasperFillManager.fillReport(report, new HashMap<>(), conn);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setTitle("Laporan Data Peminjaman");
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
                new peminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bersikan1;
    private javax.swing.JButton cari;
    private javax.swing.JTextField cariteks;
    private javax.swing.JButton hapus;
    private javax.swing.JComboBox<String> idaset;
    private javax.swing.JTextField idpeminjaman;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton laporan;
    private javax.swing.JButton mutasi;
    private javax.swing.JComboBox<String> namamember;
    private javax.swing.JButton simpan;
    private javax.swing.JTextField status;
    private javax.swing.JTable tabelpeminjaman;
    private javax.swing.JLabel tanggal;
    private com.toedter.calendar.JDateChooser tanggalkeluar;
    private com.toedter.calendar.JDateChooser tanggalmasuk;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
