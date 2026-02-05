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
 * Form Data Peminjaman - Modernized Version
 * Sistem Inventaris Aset SMA Negeri 62 Jakarta
 * 
 * @author Sistem Inventaris Aset
 * @version 2.0 (Modernized with ModernTheme - Phase 5)
 */
public class peminjaman extends JFrame {
    
    // Components
    private JTextField txtIDPeminjaman;
    private JComboBox<String> cmbNamaMember;
    private JComboBox<String> cmbIDAset;
    private JDateChooser dateTanggalPinjam;
    private JDateChooser dateTanggalKembali;
    private JComboBox<String> cmbStatus;
    private JTextField txtSearch;
    private JButton btnSimpan;
    private JButton btnUbah;
    private JButton btnHapus;
    private JButton btnBersihkan;
    private JButton btnCari;
    private JButton btnCetak;
    private JButton btnKembali;
    private JTable tablePeminjaman;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    
    // Database connection
    private Connection conn;
    
    // Status options
    private final String[] statusOptions = {"Dipinjam", "Dikembalikan"};
    
    /**
     * Constructor - Initialize form and apply modern theme
     */
    public peminjaman() {
        ModernTheme.applyTheme();
        initComponents();
        setLocationRelativeTo(null);
        loadComboBoxMember();
        loadComboBoxAset();
        tampilData();
        generateNextID();
    }
    
    /**
     * Initialize all components with modern styling
     */
    private void initComponents() {
        // Frame setup
        setTitle("Form Data Peminjaman - Sistem Inventaris Aset");
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
        
        JLabel lblTitle = ModernTheme.createStyledLabel("FORM DATA PEMINJAMAN", "h2");
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
        
        // Row 0: ID Peminjaman
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
        JLabel lblID = ModernTheme.createStyledLabel("ID Peminjaman", "label");
        card.add(lblID, gbc);
        
        gbc.gridx = 1; gbc.weightx = 1;
        txtIDPeminjaman = ModernTheme.createStyledTextField();
        txtIDPeminjaman.setEnabled(false);
        txtIDPeminjaman.setToolTipText("ID Peminjaman (Auto-generated)");
        card.add(txtIDPeminjaman, gbc);
        
        // Spacer
        gbc.gridx = 2; gbc.weightx = 0.1;
        card.add(Box.createHorizontalStrut(ModernTheme.SPACING_M), gbc);
        
        // Row 0 Right: Nama Member
        gbc.gridx = 3; gbc.weightx = 0;
        JLabel lblMember = ModernTheme.createStyledLabel("Nama Member *", "label");
        card.add(lblMember, gbc);
        
        gbc.gridx = 4; gbc.weightx = 1;
        cmbNamaMember = new JComboBox<>();
        cmbNamaMember.setFont(ModernTheme.FONT_BODY);
        cmbNamaMember.setPreferredSize(new Dimension(200, 35));
        cmbNamaMember.setBackground(Color.WHITE);
        cmbNamaMember.setToolTipText("Pilih nama member peminjam");
        card.add(cmbNamaMember, gbc);
        
        // Row 1: ID Aset
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        JLabel lblAset = ModernTheme.createStyledLabel("ID Aset *", "label");
        card.add(lblAset, gbc);
        
        gbc.gridx = 1; gbc.weightx = 1;
        cmbIDAset = new JComboBox<>();
        cmbIDAset.setFont(ModernTheme.FONT_BODY);
        cmbIDAset.setPreferredSize(new Dimension(200, 35));
        cmbIDAset.setBackground(Color.WHITE);
        cmbIDAset.setToolTipText("Pilih ID aset yang dipinjam");
        card.add(cmbIDAset, gbc);
        
        // Spacer
        gbc.gridx = 2; gbc.weightx = 0.1;
        card.add(Box.createHorizontalStrut(ModernTheme.SPACING_M), gbc);
        
        // Row 1 Right: Status
        gbc.gridx = 3; gbc.weightx = 0;
        JLabel lblStatus = ModernTheme.createStyledLabel("Status *", "label");
        card.add(lblStatus, gbc);
        
        gbc.gridx = 4; gbc.weightx = 1;
        cmbStatus = new JComboBox<>(statusOptions);
        cmbStatus.setFont(ModernTheme.FONT_BODY);
        cmbStatus.setPreferredSize(new Dimension(200, 35));
        cmbStatus.setBackground(Color.WHITE);
        cmbStatus.setToolTipText("Pilih status peminjaman");
        card.add(cmbStatus, gbc);
        
        // Row 2: Tanggal Pinjam
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        JLabel lblTanggalPinjam = ModernTheme.createStyledLabel("Tanggal Pinjam *", "label");
        card.add(lblTanggalPinjam, gbc);
        
        gbc.gridx = 1; gbc.weightx = 1;
        dateTanggalPinjam = new JDateChooser();
        dateTanggalPinjam.setDateFormatString("yyyy-MM-dd");
        dateTanggalPinjam.setFont(ModernTheme.FONT_BODY);
        dateTanggalPinjam.setPreferredSize(new Dimension(200, 35));
        dateTanggalPinjam.setToolTipText("Pilih tanggal peminjaman");
        card.add(dateTanggalPinjam, gbc);
        
        // Spacer
        gbc.gridx = 2; gbc.weightx = 0.1;
        card.add(Box.createHorizontalStrut(ModernTheme.SPACING_M), gbc);
        
        // Row 2 Right: Tanggal Kembali
        gbc.gridx = 3; gbc.weightx = 0;
        JLabel lblTanggalKembali = ModernTheme.createStyledLabel("Tanggal Kembali", "label");
        card.add(lblTanggalKembali, gbc);
        
        gbc.gridx = 4; gbc.weightx = 1;
        dateTanggalKembali = new JDateChooser();
        dateTanggalKembali.setDateFormatString("yyyy-MM-dd");
        dateTanggalKembali.setFont(ModernTheme.FONT_BODY);
        dateTanggalKembali.setPreferredSize(new Dimension(200, 35));
        dateTanggalKembali.setToolTipText("Pilih tanggal pengembalian (opsional)");
        card.add(dateTanggalKembali, gbc);
        
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
        txtSearch.setToolTipText("Cari berdasarkan ID, member, atau aset (tekan Enter)");
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
    
    private JPanel createTablePanel() {
        JPanel panel = ModernTheme.createStyledPanel();
        ModernTheme.applyCardStyle(panel);
        panel.setLayout(new BorderLayout());
        
        tableModel = new DefaultTableModel(
            new Object[]{"ID Peminjaman", "Nama Member", "ID Aset", "Tanggal Pinjam", "Tanggal Kembali", "Status"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tablePeminjaman = ModernTheme.createStyledTable(tableModel);
        
        tablePeminjaman.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tablePeminjaman.getSelectedRow();
                if (row != -1) {
                    txtIDPeminjaman.setText(tablePeminjaman.getValueAt(row, 0).toString());
                    cmbNamaMember.setSelectedItem(tablePeminjaman.getValueAt(row, 1).toString());
                    cmbIDAset.setSelectedItem(tablePeminjaman.getValueAt(row, 2).toString());
                    
                    try {
                        String dateStr = tablePeminjaman.getValueAt(row, 3).toString();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = sdf.parse(dateStr);
                        dateTanggalPinjam.setDate(date);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    
                    try {
                        Object dateObj = tablePeminjaman.getValueAt(row, 4);
                        if (dateObj != null && !dateObj.toString().isEmpty()) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = sdf.parse(dateObj.toString());
                            dateTanggalKembali.setDate(date);
                        } else {
                            dateTanggalKembali.setDate(null);
                        }
                    } catch (Exception ex) {
                        dateTanggalKembali.setDate(null);
                    }
                    
                    cmbStatus.setSelectedItem(tablePeminjaman.getValueAt(row, 5).toString());
                }
            }
        });
        
        scrollPane = new JScrollPane(tablePeminjaman);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private void generateNextID() {
        try {
            conn = new koneksi().connect();
            String sql = "SELECT id_peminjaman FROM peminjaman ORDER BY id_peminjaman DESC LIMIT 1";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()) {
                String lastID = rs.getString("id_peminjaman");
                int num = Integer.parseInt(lastID.substring(3)) + 1;
                txtIDPeminjaman.setText(String.format("PJM%03d", num));
            } else {
                txtIDPeminjaman.setText("PJM001");
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            txtIDPeminjaman.setText("PJM001");
            e.printStackTrace();
        }
    }
    
    private void loadComboBoxMember() {
        try {
            conn = new koneksi().connect();
            String sql = "SELECT nama_member FROM member ORDER BY nama_member";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            cmbNamaMember.removeAllItems();
            cmbNamaMember.addItem("-- Pilih Member --");
            
            while (rs.next()) {
                cmbNamaMember.addItem(rs.getString("nama_member"));
            }
            
            rs.close();
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Gagal memuat data member: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
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
    
    private void tampilData() {
        tableModel.setRowCount(0);
        
        try {
            conn = new koneksi().connect();
            String sql = "SELECT * FROM peminjaman ORDER BY id_peminjaman DESC";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getString("id_peminjaman"),
                    rs.getString("nama_member"),
                    rs.getString("id_aset"),
                    rs.getDate("tanggal_pinjam"),
                    rs.getDate("tanggal_kembali"),
                    rs.getString("status")
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
    
    private void kosongkanForm() {
        txtIDPeminjaman.setText("");
        cmbNamaMember.setSelectedIndex(0);
        cmbIDAset.setSelectedIndex(0);
        dateTanggalPinjam.setDate(null);
        dateTanggalKembali.setDate(null);
        cmbStatus.setSelectedIndex(0);
        txtSearch.setText("");
        tablePeminjaman.clearSelection();
        generateNextID();
    }
    
    private boolean validateInput() {
        if (txtIDPeminjaman.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "ID Peminjaman tidak boleh kosong!",
                "Validasi Error",
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (cmbNamaMember.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, 
                "Nama Member harus dipilih!",
                "Validasi Error",
                JOptionPane.WARNING_MESSAGE);
            cmbNamaMember.requestFocus();
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
        
        if (dateTanggalPinjam.getDate() == null) {
            JOptionPane.showMessageDialog(this, 
                "Tanggal Pinjam harus diisi!",
                "Validasi Error",
                JOptionPane.WARNING_MESSAGE);
            dateTanggalPinjam.requestFocus();
            return false;
        }
        
        return true;
    }
    
    private void simpanActionPerformed() {
        if (!validateInput()) {
            return;
        }
        
        String id = txtIDPeminjaman.getText().trim();
        String namaMember = cmbNamaMember.getSelectedItem().toString();
        String idAset = cmbIDAset.getSelectedItem().toString();
        Date tanggalPinjam = dateTanggalPinjam.getDate();
        Date tanggalKembali = dateTanggalKembali.getDate();
        String status = cmbStatus.getSelectedItem().toString();
        
        int confirm = JOptionPane.showConfirmDialog(this,
            "Simpan data peminjaman berikut?\n\n" +
            "ID Peminjaman: " + id + "\n" +
            "Nama Member: " + namaMember + "\n" +
            "ID Aset: " + idAset + "\n" +
            "Tanggal Pinjam: " + new SimpleDateFormat("dd-MM-yyyy").format(tanggalPinjam) + "\n" +
            "Status: " + status,
            "Konfirmasi Simpan",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        
        try {
            conn = new koneksi().connect();
            String sql = "INSERT INTO peminjaman (id_peminjaman, nama_member, id_aset, tanggal_pinjam, tanggal_kembali, status) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, id);
            pst.setString(2, namaMember);
            pst.setString(3, idAset);
            pst.setDate(4, new java.sql.Date(tanggalPinjam.getTime()));
            
            if (tanggalKembali != null) {
                pst.setDate(5, new java.sql.Date(tanggalKembali.getTime()));
            } else {
                pst.setNull(5, java.sql.Types.DATE);
            }
            
            pst.setString(6, status);
            
            pst.executeUpdate();
            pst.close();
            
            JOptionPane.showMessageDialog(this,
                "✓ Data peminjaman berhasil disimpan!",
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
    
    private void ubahActionPerformed() {
        if (tablePeminjaman.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this,
                "Pilih data yang akan diubah terlebih dahulu!",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!validateInput()) {
            return;
        }
        
        String id = txtIDPeminjaman.getText().trim();
        String namaMember = cmbNamaMember.getSelectedItem().toString();
        String idAset = cmbIDAset.getSelectedItem().toString();
        Date tanggalPinjam = dateTanggalPinjam.getDate();
        Date tanggalKembali = dateTanggalKembali.getDate();
        String status = cmbStatus.getSelectedItem().toString();
        
        int confirm = JOptionPane.showConfirmDialog(this,
            "Ubah data peminjaman berikut?\n\n" +
            "ID Peminjaman: " + id + "\n" +
            "Nama Member: " + namaMember + "\n" +
            "ID Aset: " + idAset + "\n" +
            "Status: " + status,
            "Konfirmasi Ubah",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        
        try {
            conn = new koneksi().connect();
            String sql = "UPDATE peminjaman SET nama_member=?, id_aset=?, tanggal_pinjam=?, tanggal_kembali=?, status=? " +
                        "WHERE id_peminjaman=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, namaMember);
            pst.setString(2, idAset);
            pst.setDate(3, new java.sql.Date(tanggalPinjam.getTime()));
            
            if (tanggalKembali != null) {
                pst.setDate(4, new java.sql.Date(tanggalKembali.getTime()));
            } else {
                pst.setNull(4, java.sql.Types.DATE);
            }
            
            pst.setString(5, status);
            pst.setString(6, id);
            
            pst.executeUpdate();
            pst.close();
            
            JOptionPane.showMessageDialog(this,
                "✓ Data peminjaman berhasil diubah!",
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
    
    private void hapusActionPerformed() {
        if (tablePeminjaman.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this,
                "Pilih data yang akan dihapus terlebih dahulu!",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String id = txtIDPeminjaman.getText().trim();
        String namaMember = cmbNamaMember.getSelectedItem().toString();
        String idAset = cmbIDAset.getSelectedItem().toString();
        
        int confirm = JOptionPane.showConfirmDialog(this,
            "Hapus data peminjaman berikut?\n\n" +
            "ID Peminjaman: " + id + "\n" +
            "Nama Member: " + namaMember + "\n" +
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
            String sql = "DELETE FROM peminjaman WHERE id_peminjaman = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            
            int affected = pst.executeUpdate();
            pst.close();
            
            if (affected > 0) {
                JOptionPane.showMessageDialog(this,
                    "✓ Data peminjaman berhasil dihapus!",
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
            String sql = "SELECT * FROM peminjaman WHERE " +
                        "id_peminjaman LIKE ? OR " +
                        "nama_member LIKE ? OR " +
                        "id_aset LIKE ? OR " +
                        "status LIKE ? " +
                        "ORDER BY id_peminjaman DESC";
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
                    rs.getString("id_peminjaman"),
                    rs.getString("nama_member"),
                    rs.getString("id_aset"),
                    rs.getDate("tanggal_pinjam"),
                    rs.getDate("tanggal_kembali"),
                    rs.getString("status")
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
                    "Ditemukan " + count + " data peminjaman",
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
    
    private void cetakActionPerformed() {
        try {
            conn = new koneksi().connect();
            
            InputStream report = getClass().getResourceAsStream("/laporan/LaporanDataPeminjaman.jasper");
            
            if (report == null) {
                InputStream jrxmlStream = getClass().getResourceAsStream("/laporan/LaporanDataPeminjaman.jrxml");
                if (jrxmlStream == null) {
                    JOptionPane.showMessageDialog(this, 
                        "File laporan tidak ditemukan!\n" +
                        "Pastikan file LaporanDataPeminjaman.jrxml ada di folder laporan.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                net.sf.jasperreports.engine.JasperReport jasperReport = 
                    net.sf.jasperreports.engine.JasperCompileManager.compileReport(jrxmlStream);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, new HashMap<>(), conn);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setTitle("Laporan Data Peminjaman");
                viewer.setVisible(true);
            } else {
                JasperPrint print = JasperFillManager.fillReport(report, new HashMap<>(), conn);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setTitle("Laporan Data Peminjaman");
                viewer.setVisible(true);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Gagal mencetak laporan: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
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
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new peminjaman().setVisible(true);
        });
    }
}
