package transaksi;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import com.toedter.calendar.JDateChooser;
import ui.ModernTheme;
import koneksi.koneksi;
import master.branda;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Form Data Mutasi - Modernized Version
 * Sistem Inventaris Aset SMA Negeri 62 Jakarta
 * 
 * @author Sistem Inventaris Aset
 * @version 2.0 (Modernized with ModernTheme - Phase 5)
 */
public class mutasi extends JFrame {
    
    // Components
    private JTextField txtIDMutasi;
    private JDateChooser dateTanggalMutasi;
    private JComboBox<String> cmbLokasiAsal;
    private JComboBox<String> cmbLokasiTujuan;
    private JComboBox<String> cmbIDAset;
    private JTextField txtSearch;
    private JButton btnSimpan;
    private JButton btnUbah;
    private JButton btnHapus;
    private JButton btnBersihkan;
    private JButton btnCari;
    private JButton btnCetak;
    private JButton btnKembali;
    private JTable tableMutasi;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    
    // Database connection
    private Connection conn;
    
    /**
     * Constructor - Initialize form and apply modern theme
     */
    public mutasi() {
        ModernTheme.applyTheme();
        initComponents();
        setLocationRelativeTo(null);
        loadComboBoxLokasi();
        loadComboBoxAset();
        tampilData();
        generateNextID();
    }
    
    /**
     * Initialize all components with modern styling
     */
    private void initComponents() {
        // Frame setup
        setTitle("Form Data Mutasi - Sistem Inventaris Aset");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200, 750);
        setLayout(new BorderLayout());
        getContentPane().setBackground(ModernTheme.LATAR_UTAMA);
        
        // Create main panel
        JPanel mainPanel = new JPanel(new BorderLayout(0, ModernTheme.SPACING_M));
        mainPanel.setBackground(ModernTheme.LATAR_UTAMA);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(
            ModernTheme.SPACING_L, ModernTheme.SPACING_L, 
            ModernTheme.SPACING_L, ModernTheme.SPACING_L
        ));
        
        // Create title panel
        JPanel titlePanel = createTitlePanel();
        
        // Create input card
        JPanel inputCard = createInputCard();
        
        // Create button panel
        JPanel buttonPanel = createButtonPanel();
        
        // Create table panel
        JPanel tablePanel = createTablePanel();
        
        // Assemble layout
        JPanel topPanel = new JPanel(new BorderLayout(0, ModernTheme.SPACING_M));
        topPanel.setBackground(ModernTheme.LATAR_UTAMA);
        topPanel.add(titlePanel, BorderLayout.NORTH);
        topPanel.add(inputCard, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        
        add(mainPanel);
    }
    
    /**
     * Create title panel with form heading
     */
    private JPanel createTitlePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(ModernTheme.LATAR_UTAMA);
        
        JLabel lblTitle = ModernTheme.createStyledLabel("FORM DATA MUTASI", "h2");
        panel.add(lblTitle, BorderLayout.WEST);
        
        // Add back button
        btnKembali = ModernTheme.createStyledButton("← KEMBALI", "secondary");
        btnKembali.addActionListener(e -> kembaliActionPerformed());
        panel.add(btnKembali, BorderLayout.EAST);
        
        return panel;
    }
    
    /**
     * Create input card with form fields
     */
    private JPanel createInputCard() {
        JPanel card = ModernTheme.createStyledPanel();
        ModernTheme.applyCardStyle(card);
        card.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(ModernTheme.SPACING_S, ModernTheme.SPACING_S, 
                                ModernTheme.SPACING_S, ModernTheme.SPACING_S);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Row 0: ID Mutasi
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
        JLabel lblID = ModernTheme.createStyledLabel("ID Mutasi", "label");
        card.add(lblID, gbc);
        
        gbc.gridx = 1; gbc.weightx = 1;
        txtIDMutasi = ModernTheme.createStyledTextField();
        txtIDMutasi.setEnabled(false);
        txtIDMutasi.setToolTipText("ID Mutasi (Auto-generated)");
        card.add(txtIDMutasi, gbc);
        
        // Spacer
        gbc.gridx = 2; gbc.weightx = 0.1;
        card.add(Box.createHorizontalStrut(ModernTheme.SPACING_M), gbc);
        
        // Row 0 Right: Tanggal Mutasi
        gbc.gridx = 3; gbc.weightx = 0;
        JLabel lblTanggal = ModernTheme.createStyledLabel("Tanggal Mutasi *", "label");
        card.add(lblTanggal, gbc);
        
        gbc.gridx = 4; gbc.weightx = 1;
        dateTanggalMutasi = new JDateChooser();
        dateTanggalMutasi.setDateFormatString("yyyy-MM-dd");
        dateTanggalMutasi.setFont(ModernTheme.FONT_BODY);
        dateTanggalMutasi.setPreferredSize(new Dimension(200, 35));
        dateTanggalMutasi.setToolTipText("Pilih tanggal mutasi");
        card.add(dateTanggalMutasi, gbc);
        
        // Row 1: Lokasi Asal
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        JLabel lblLokasiAsal = ModernTheme.createStyledLabel("Lokasi Asal *", "label");
        card.add(lblLokasiAsal, gbc);
        
        gbc.gridx = 1; gbc.weightx = 1;
        cmbLokasiAsal = new JComboBox<>();
        cmbLokasiAsal.setFont(ModernTheme.FONT_BODY);
        cmbLokasiAsal.setPreferredSize(new Dimension(200, 35));
        cmbLokasiAsal.setBackground(Color.WHITE);
        cmbLokasiAsal.setToolTipText("Pilih lokasi asal aset");
        card.add(cmbLokasiAsal, gbc);
        
        // Spacer
        gbc.gridx = 2; gbc.weightx = 0.1;
        card.add(Box.createHorizontalStrut(ModernTheme.SPACING_M), gbc);
        
        // Row 1 Right: Lokasi Tujuan
        gbc.gridx = 3; gbc.weightx = 0;
        JLabel lblLokasiTujuan = ModernTheme.createStyledLabel("Lokasi Tujuan *", "label");
        card.add(lblLokasiTujuan, gbc);
        
        gbc.gridx = 4; gbc.weightx = 1;
        cmbLokasiTujuan = new JComboBox<>();
        cmbLokasiTujuan.setFont(ModernTheme.FONT_BODY);
        cmbLokasiTujuan.setPreferredSize(new Dimension(200, 35));
        cmbLokasiTujuan.setBackground(Color.WHITE);
        cmbLokasiTujuan.setToolTipText("Pilih lokasi tujuan aset");
        card.add(cmbLokasiTujuan, gbc);
        
        // Row 2: ID Aset
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        JLabel lblIDAset = ModernTheme.createStyledLabel("ID Aset *", "label");
        card.add(lblIDAset, gbc);
        
        gbc.gridx = 1; gbc.weightx = 1;
        cmbIDAset = new JComboBox<>();
        cmbIDAset.setFont(ModernTheme.FONT_BODY);
        cmbIDAset.setPreferredSize(new Dimension(200, 35));
        cmbIDAset.setBackground(Color.WHITE);
        cmbIDAset.setToolTipText("Pilih ID aset yang akan dimutasi");
        card.add(cmbIDAset, gbc);
        
        return card;
    }
    
    /**
     * Create button panel with CRUD and search buttons
     */
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new BorderLayout(ModernTheme.SPACING_M, 0));
        panel.setBackground(ModernTheme.LATAR_UTAMA);
        
        // Left side - CRUD buttons
        JPanel leftButtons = new JPanel(new FlowLayout(FlowLayout.LEFT, ModernTheme.SPACING_S, 0));
        leftButtons.setBackground(ModernTheme.LATAR_UTAMA);
        
        // Back button
        JButton btnKembali = ModernTheme.createStyledButton("← KEMBALI", "secondary");
        btnKembali.addActionListener(e -> this.dispose());
        btnKembali.setToolTipText("Kembali ke Dashboard");
        
        btnSimpan = ModernTheme.createStyledButton("💾 SIMPAN", "success");
        btnSimpan.addActionListener(e -> simpanActionPerformed());
        
        btnUbah = ModernTheme.createStyledButton("✏️ UBAH", "primary");
        btnUbah.addActionListener(e -> ubahActionPerformed());
        
        btnHapus = ModernTheme.createStyledButton("🗑️ HAPUS", "danger");
        btnHapus.addActionListener(e -> hapusActionPerformed());
        
        btnBersihkan = ModernTheme.createStyledButton("🧹 BERSIHKAN", "secondary");
        btnBersihkan.addActionListener(e -> bersihkanActionPerformed());
        
        leftButtons.add(btnKembali);
        leftButtons.add(btnSimpan);
        leftButtons.add(btnUbah);
        leftButtons.add(btnHapus);
        leftButtons.add(btnBersihkan);
        
        // Right side - Search and Print
        JPanel rightButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT, ModernTheme.SPACING_S, 0));
        rightButtons.setBackground(ModernTheme.LATAR_UTAMA);
        
        txtSearch = ModernTheme.createStyledTextField();
        txtSearch.setPreferredSize(new Dimension(250, 35));
        txtSearch.setToolTipText("Cari berdasarkan ID, lokasi, atau aset (tekan Enter)");
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    cariActionPerformed();
                }
            }
        });
        
        btnCari = ModernTheme.createStyledButton("🔍 CARI", "primary");
        btnCari.addActionListener(e -> cariActionPerformed());
        
        btnCetak = ModernTheme.createStyledButton("🖨️ CETAK", "primary");
        btnCetak.addActionListener(e -> cetakActionPerformed());
        
        rightButtons.add(new JLabel("Pencarian: "));
        rightButtons.add(txtSearch);
        rightButtons.add(btnCari);
        rightButtons.add(btnCetak);
        
        panel.add(leftButtons, BorderLayout.WEST);
        panel.add(rightButtons, BorderLayout.EAST);
        
        return panel;
    }
    
    /**
     * Create table panel with data display
     */
    private JPanel createTablePanel() {
        JPanel panel = ModernTheme.createStyledPanel();
        ModernTheme.applyCardStyle(panel);
        panel.setLayout(new BorderLayout());
        
        // Table model
        tableModel = new DefaultTableModel(
            new Object[]{"ID Mutasi", "Tanggal Mutasi", "Lokasi Asal", "Lokasi Tujuan", "ID Aset"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        // Create table
        tableMutasi = ModernTheme.createStyledTable(tableModel);
        
        // Add mouse listener for row selection
        tableMutasi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableMutasi.getSelectedRow();
                if (row != -1) {
                    txtIDMutasi.setText(tableMutasi.getValueAt(row, 0).toString());
                    
                    // Parse date
                    try {
                        String dateStr = tableMutasi.getValueAt(row, 1).toString();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = sdf.parse(dateStr);
                        dateTanggalMutasi.setDate(date);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    
                    cmbLokasiAsal.setSelectedItem(tableMutasi.getValueAt(row, 2).toString());
                    cmbLokasiTujuan.setSelectedItem(tableMutasi.getValueAt(row, 3).toString());
                    cmbIDAset.setSelectedItem(tableMutasi.getValueAt(row, 4).toString());
                }
            }
        });
        
        scrollPane = new JScrollPane(tableMutasi);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    /**
     * Generate next ID for new mutasi
     */
    private void generateNextID() {
        try {
            conn = new koneksi().connect();
            String sql = "SELECT id_mutasi FROM mutasi ORDER BY id_mutasi DESC LIMIT 1";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()) {
                String lastID = rs.getString("id_mutasi");
                int num = Integer.parseInt(lastID.substring(3)) + 1;
                txtIDMutasi.setText(String.format("MUT%03d", num));
            } else {
                txtIDMutasi.setText("MUT001");
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            txtIDMutasi.setText("MUT001");
            e.printStackTrace();
        }
    }
    
    /**
     * Load lokasi data to combo boxes
     */
    private void loadComboBoxLokasi() {
        try {
            conn = new koneksi().connect();
            String sql = "SELECT nama_lokasi FROM lokasi ORDER BY nama_lokasi";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            cmbLokasiAsal.removeAllItems();
            cmbLokasiTujuan.removeAllItems();
            cmbLokasiAsal.addItem("-- Pilih Lokasi Asal --");
            cmbLokasiTujuan.addItem("-- Pilih Lokasi Tujuan --");
            
            while (rs.next()) {
                String lokasi = rs.getString("nama_lokasi");
                cmbLokasiAsal.addItem(lokasi);
                cmbLokasiTujuan.addItem(lokasi);
            }
            
            rs.close();
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Gagal memuat data lokasi: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Load aset data to combo box
     */
    private void loadComboBoxAset() {
        try {
            conn = new koneksi().connect();
            String sql = "SELECT id_aset FROM aset ORDER BY id_aset";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            cmbIDAset.removeAllItems();
            cmbIDAset.addItem("-- Pilih ID Aset --");
            
            while (rs.next()) {
                cmbIDAset.addItem(rs.getString("id_aset"));
            }
            
            rs.close();
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Gagal memuat data aset: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Display all mutasi data in table
     */
    private void tampilData() {
        tableModel.setRowCount(0);
        
        try {
            conn = new koneksi().connect();
            String sql = "SELECT * FROM mutasi ORDER BY id_mutasi DESC";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getString("id_mutasi"),
                    rs.getDate("tanggal_mutasi"),
                    rs.getString("lokasi_asal"),
                    rs.getString("lokasi_tujuan"),
                    rs.getString("id_aset")
                });
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Gagal memuat data: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Clear all input fields
     */
    private void kosongkanForm() {
        txtIDMutasi.setText("");
        dateTanggalMutasi.setDate(null);
        cmbLokasiAsal.setSelectedIndex(0);
        cmbLokasiTujuan.setSelectedIndex(0);
        cmbIDAset.setSelectedIndex(0);
        txtSearch.setText("");
        tableMutasi.clearSelection();
        generateNextID();
    }
    
    /**
     * Validate input before save/update
     */
    private boolean validateInput() {
        if (txtIDMutasi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "ID Mutasi tidak boleh kosong!",
                "Validasi Error",
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (dateTanggalMutasi.getDate() == null) {
            JOptionPane.showMessageDialog(this, 
                "Tanggal Mutasi harus diisi!",
                "Validasi Error",
                JOptionPane.WARNING_MESSAGE);
            dateTanggalMutasi.requestFocus();
            return false;
        }
        
        if (cmbLokasiAsal.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, 
                "Lokasi Asal harus dipilih!",
                "Validasi Error",
                JOptionPane.WARNING_MESSAGE);
            cmbLokasiAsal.requestFocus();
            return false;
        }
        
        if (cmbLokasiTujuan.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, 
                "Lokasi Tujuan harus dipilih!",
                "Validasi Error",
                JOptionPane.WARNING_MESSAGE);
            cmbLokasiTujuan.requestFocus();
            return false;
        }
        
        // Validate lokasi asal != lokasi tujuan
        String lokasiAsal = cmbLokasiAsal.getSelectedItem().toString();
        String lokasiTujuan = cmbLokasiTujuan.getSelectedItem().toString();
        if (lokasiAsal.equals(lokasiTujuan)) {
            JOptionPane.showMessageDialog(this, 
                "Lokasi Asal dan Lokasi Tujuan tidak boleh sama!",
                "Validasi Error",
                JOptionPane.WARNING_MESSAGE);
            cmbLokasiTujuan.requestFocus();
            return false;
        }
        
        if (cmbIDAset.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, 
                "ID Aset harus dipilih!",
                "Validasi Error",
                JOptionPane.WARNING_MESSAGE);
            cmbIDAset.requestFocus();
            return false;
        }
        
        return true;
    }
    
    /**
     * Save new mutasi data
     */
    private void simpanActionPerformed() {
        if (!validateInput()) {
            return;
        }
        
        String id = txtIDMutasi.getText().trim();
        Date tanggal = dateTanggalMutasi.getDate();
        String lokasiAsal = cmbLokasiAsal.getSelectedItem().toString();
        String lokasiTujuan = cmbLokasiTujuan.getSelectedItem().toString();
        String idAset = cmbIDAset.getSelectedItem().toString();
        
        // Confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(this,
            "Simpan data mutasi berikut?\n\n" +
            "ID Mutasi: " + id + "\n" +
            "Tanggal: " + new SimpleDateFormat("dd-MM-yyyy").format(tanggal) + "\n" +
            "Lokasi Asal: " + lokasiAsal + "\n" +
            "Lokasi Tujuan: " + lokasiTujuan + "\n" +
            "ID Aset: " + idAset,
            "Konfirmasi Simpan",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        
        try {
            conn = new koneksi().connect();
            String sql = "INSERT INTO mutasi (id_mutasi, tanggal_mutasi, lokasi_asal, lokasi_tujuan, id_aset) " +
                        "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, id);
            pst.setDate(2, new java.sql.Date(tanggal.getTime()));
            pst.setString(3, lokasiAsal);
            pst.setString(4, lokasiTujuan);
            pst.setString(5, idAset);
            
            pst.executeUpdate();
            pst.close();
            
            JOptionPane.showMessageDialog(this,
                "✓ Data mutasi berhasil disimpan!",
                "Sukses",
                JOptionPane.INFORMATION_MESSAGE);
            
            kosongkanForm();
            tampilData();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                "Gagal menyimpan data: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Update existing mutasi data
     */
    private void ubahActionPerformed() {
        if (tableMutasi.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this,
                "Pilih data yang akan diubah terlebih dahulu!",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!validateInput()) {
            return;
        }
        
        String id = txtIDMutasi.getText().trim();
        Date tanggal = dateTanggalMutasi.getDate();
        String lokasiAsal = cmbLokasiAsal.getSelectedItem().toString();
        String lokasiTujuan = cmbLokasiTujuan.getSelectedItem().toString();
        String idAset = cmbIDAset.getSelectedItem().toString();
        
        // Confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(this,
            "Ubah data mutasi berikut?\n\n" +
            "ID Mutasi: " + id + "\n" +
            "Tanggal: " + new SimpleDateFormat("dd-MM-yyyy").format(tanggal) + "\n" +
            "Lokasi Asal: " + lokasiAsal + "\n" +
            "Lokasi Tujuan: " + lokasiTujuan + "\n" +
            "ID Aset: " + idAset,
            "Konfirmasi Ubah",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        
        try {
            conn = new koneksi().connect();
            String sql = "UPDATE mutasi SET tanggal_mutasi=?, lokasi_asal=?, lokasi_tujuan=?, id_aset=? " +
                        "WHERE id_mutasi=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setDate(1, new java.sql.Date(tanggal.getTime()));
            pst.setString(2, lokasiAsal);
            pst.setString(3, lokasiTujuan);
            pst.setString(4, idAset);
            pst.setString(5, id);
            
            pst.executeUpdate();
            pst.close();
            
            JOptionPane.showMessageDialog(this,
                "✓ Data mutasi berhasil diubah!",
                "Sukses",
                JOptionPane.INFORMATION_MESSAGE);
            
            kosongkanForm();
            tampilData();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                "Gagal mengubah data: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Delete mutasi data
     */
    private void hapusActionPerformed() {
        if (tableMutasi.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this,
                "Pilih data yang akan dihapus terlebih dahulu!",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String id = txtIDMutasi.getText().trim();
        String lokasiAsal = cmbLokasiAsal.getSelectedItem().toString();
        String lokasiTujuan = cmbLokasiTujuan.getSelectedItem().toString();
        String idAset = cmbIDAset.getSelectedItem().toString();
        
        // Confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(this,
            "Hapus data mutasi berikut?\n\n" +
            "ID Mutasi: " + id + "\n" +
            "Lokasi Asal: " + lokasiAsal + "\n" +
            "Lokasi Tujuan: " + lokasiTujuan + "\n" +
            "ID Aset: " + idAset + "\n\n" +
            "Data yang dihapus tidak dapat dikembalikan!",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
        
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        
        try {
            conn = new koneksi().connect();
            String sql = "DELETE FROM mutasi WHERE id_mutasi = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            
            int affected = pst.executeUpdate();
            pst.close();
            
            if (affected > 0) {
                JOptionPane.showMessageDialog(this,
                    "✓ Data mutasi berhasil dihapus!",
                    "Sukses",
                    JOptionPane.INFORMATION_MESSAGE);
                
                kosongkanForm();
                tampilData();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Data tidak ditemukan!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                "Gagal menghapus data: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Clear all fields
     */
    private void bersihkanActionPerformed() {
        int confirm = JOptionPane.showConfirmDialog(this,
            "Bersihkan semua field input?",
            "Konfirmasi Bersihkan",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirm == JOptionPane.YES_OPTION) {
            kosongkanForm();
        }
    }
    
    /**
     * Search mutasi data
     */
    private void cariActionPerformed() {
        String keyword = txtSearch.getText().trim();
        
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Masukkan kata kunci pencarian!",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE);
            txtSearch.requestFocus();
            return;
        }
        
        tableModel.setRowCount(0);
        
        try {
            conn = new koneksi().connect();
            String sql = "SELECT * FROM mutasi WHERE " +
                        "id_mutasi LIKE ? OR " +
                        "lokasi_asal LIKE ? OR " +
                        "lokasi_tujuan LIKE ? OR " +
                        "id_aset LIKE ? " +
                        "ORDER BY id_mutasi DESC";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            String searchPattern = "%" + keyword + "%";
            pst.setString(1, searchPattern);
            pst.setString(2, searchPattern);
            pst.setString(3, searchPattern);
            pst.setString(4, searchPattern);
            
            ResultSet rs = pst.executeQuery();
            
            int count = 0;
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getString("id_mutasi"),
                    rs.getDate("tanggal_mutasi"),
                    rs.getString("lokasi_asal"),
                    rs.getString("lokasi_tujuan"),
                    rs.getString("id_aset")
                });
                count++;
            }
            
            rs.close();
            pst.close();
            
            if (count == 0) {
                JOptionPane.showMessageDialog(this,
                    "Data tidak ditemukan untuk kata kunci: " + keyword,
                    "Hasil Pencarian",
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                    "Ditemukan " + count + " data mutasi",
                    "Hasil Pencarian",
                    JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                "Gagal melakukan pencarian: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Print mutasi report
     */
    private void cetakActionPerformed() {
        try {
            conn = new koneksi().connect();
            
            // Try to load .jasper file first
            InputStream report = getClass().getResourceAsStream("/laporan/LaporanDataMutasi.jasper");
            
            // If .jasper doesn't exist, compile from .jrxml
            if (report == null) {
                InputStream jrxmlStream = getClass().getResourceAsStream("/laporan/LaporanDataMutasi.jrxml");
                if (jrxmlStream == null) {
                    JOptionPane.showMessageDialog(this, 
                        "File laporan tidak ditemukan!\n" +
                        "Pastikan file LaporanDataMutasi.jrxml ada di folder laporan.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(this,
                "Gagal mencetak laporan: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Back to dashboard
     */
    private void kembaliActionPerformed() {
        int confirm = JOptionPane.showConfirmDialog(this,
            "Kembali ke dashboard?",
            "Konfirmasi",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirm == JOptionPane.YES_OPTION) {
            new branda().setVisible(true);
            this.dispose();
        }
    }
    
    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new mutasi().setVisible(true);
        });
    }
}
