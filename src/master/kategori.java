package master;

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
import ui.ModernTheme;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Form Data Kategori - Modernized Version
 * Sistem Inventaris Aset SMA Negeri 62 Jakarta
 * 
 * @author Sistem Inventaris Aset
 * @version 2.0 (Modernized with ModernTheme - Phase 4)
 */
public class kategori extends JFrame {
    
    // Components
    private JTextField txtIDKategori;
    private JTextField txtNamaKategori;
    private JTextArea txtKeterangan;
    private JTextField txtSearch;
    private JButton btnSimpan;
    private JButton btnUbah;
    private JButton btnHapus;
    private JButton btnBersihkan;
    private JButton btnCari;
    private JButton btnCetak;
    private JTable tableKategori;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    
    // Database connection
    private Connection conn;
    
    /**
     * Constructor - Initialize form and apply modern theme
     */
    public kategori() {
        ModernTheme.applyTheme();
        initComponents();
        setLocationRelativeTo(null);
        tampilData();
        generateNextID();
    }
    
    /**
     * Initialize all components with modern styling
     */
    private void initComponents() {
        // Frame setup
        setTitle("Form Data Kategori - Sistem Inventaris Aset");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200, 700);
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
        
        JLabel lblTitle = ModernTheme.createStyledLabel("FORM DATA KATEGORI", "h2");
        panel.add(lblTitle, BorderLayout.WEST);
        
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
        
        // Row 0: ID Kategori
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
        JLabel lblID = ModernTheme.createStyledLabel("ID Kategori", "label");
        card.add(lblID, gbc);
        
        gbc.gridx = 1; gbc.weightx = 1;
        txtIDKategori = ModernTheme.createStyledTextField();
        txtIDKategori.setEnabled(false);
        txtIDKategori.setToolTipText("ID Kategori (Auto-generated)");
        card.add(txtIDKategori, gbc);
        
        // Row 1: Nama Kategori
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        JLabel lblNama = ModernTheme.createStyledLabel("Nama Kategori *", "label");
        card.add(lblNama, gbc);
        
        gbc.gridx = 1; gbc.weightx = 1;
        txtNamaKategori = ModernTheme.createStyledTextField();
        txtNamaKategori.setToolTipText("Nama kategori (minimal 3 karakter)");
        card.add(txtNamaKategori, gbc);
        
        // Row 2: Keterangan
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        JLabel lblKeterangan = ModernTheme.createStyledLabel("Keterangan", "label");
        card.add(lblKeterangan, gbc);
        
        gbc.gridx = 1; gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        txtKeterangan = new JTextArea(3, 20);
        txtKeterangan.setFont(ModernTheme.FONT_BODY);
        txtKeterangan.setLineWrap(true);
        txtKeterangan.setWrapStyleWord(true);
        txtKeterangan.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(ModernTheme.BORDER, 1),
            BorderFactory.createEmptyBorder(8, 8, 8, 8)
        ));
        txtKeterangan.setToolTipText("Keterangan kategori (opsional)");
        JScrollPane scrollKeterangan = new JScrollPane(txtKeterangan);
        scrollKeterangan.setPreferredSize(new Dimension(0, 80));
        card.add(scrollKeterangan, gbc);
        
        return card;
    }
    
    /**
     * Create button panel with action buttons
     */
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new BorderLayout(ModernTheme.SPACING_M, 0));
        panel.setBackground(ModernTheme.LATAR_UTAMA);
        
        // Left side: CRUD buttons
        JPanel leftButtons = new JPanel(new FlowLayout(FlowLayout.LEFT, ModernTheme.SPACING_S, 0));
        leftButtons.setBackground(ModernTheme.LATAR_UTAMA);
        
        // Back button
        JButton btnKembali = ModernTheme.createStyledButton("← KEMBALI", "secondary");
        btnKembali.addActionListener(e -> this.dispose());
        btnKembali.setToolTipText("Kembali ke Dashboard");
        
        btnSimpan = ModernTheme.createStyledButton("💾 SIMPAN", "success");
        btnUbah = ModernTheme.createStyledButton("✏️ UBAH", "primary");
        btnHapus = ModernTheme.createStyledButton("🗑️ HAPUS", "danger");
        btnBersihkan = ModernTheme.createStyledButton("🧹 BERSIHKAN", "secondary");
        
        btnSimpan.addActionListener(e -> simpanActionPerformed());
        btnUbah.addActionListener(e -> ubahActionPerformed());
        btnHapus.addActionListener(e -> hapusActionPerformed());
        btnBersihkan.addActionListener(e -> bersihkanActionPerformed());
        
        leftButtons.add(btnKembali);
        leftButtons.add(btnSimpan);
        leftButtons.add(btnUbah);
        leftButtons.add(btnHapus);
        leftButtons.add(btnBersihkan);
        
        // Right side: Search and Print
        JPanel rightButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT, ModernTheme.SPACING_S, 0));
        rightButtons.setBackground(ModernTheme.LATAR_UTAMA);
        
        txtSearch = ModernTheme.createStyledTextField();
        txtSearch.setPreferredSize(new Dimension(250, 36));
        txtSearch.setToolTipText("Ketik kata kunci dan tekan Enter untuk mencari");
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
        
        btnCetak = ModernTheme.createStyledButton("🖨️ CETAK LAPORAN", "primary");
        btnCetak.addActionListener(e -> cetakActionPerformed());
        
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
        
        // Create table model
        String[] columns = {"ID Kategori", "Nama Kategori", "Keterangan"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        // Create table
        tableKategori = ModernTheme.createStyledTable(tableModel);
        tableKategori.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int row = tableKategori.getSelectedRow();
                    if (row != -1) {
                        txtIDKategori.setText(tableKategori.getValueAt(row, 0).toString());
                        txtNamaKategori.setText(tableKategori.getValueAt(row, 1).toString());
                        Object keterangan = tableKategori.getValueAt(row, 2);
                        txtKeterangan.setText(keterangan != null ? keterangan.toString() : "");
                    }
                }
            }
        });
        
        scrollPane = new JScrollPane(tableKategori);
        scrollPane.setBorder(BorderFactory.createLineBorder(ModernTheme.BORDER, 1));
        
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    // ==================== DATABASE METHODS ====================
    
    /**
     * Generate next ID Kategori automatically
     */
    private void generateNextID() {
        try {
            conn = koneksi.getConnection();
            String sql = "SELECT id_kategori FROM kategori ORDER BY id_kategori DESC LIMIT 1";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()) {
                String lastID = rs.getString("id_kategori");
                String numPart = lastID.substring(3); // Remove "KAT"
                int nextNum = Integer.parseInt(numPart) + 1;
                String nextID = String.format("KAT%03d", nextNum);
                txtIDKategori.setText(nextID);
            } else {
                txtIDKategori.setText("KAT001");
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            txtIDKategori.setText("KAT001");
        }
    }
    
    /**
     * Display all kategori data in table
     */
    private void tampilData() {
        try {
            conn = koneksi.getConnection();
            tableModel.setRowCount(0);
            
            String sql = "SELECT * FROM kategori ORDER BY id_kategori";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                Object[] row = {
                    rs.getString("id_kategori"),
                    rs.getString("nama_kategori"),
                    rs.getString("keterangan")
                };
                tableModel.addRow(row);
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Gagal menampilkan data: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Clear all input fields
     */
    private void kosongkanForm() {
        txtNamaKategori.setText("");
        txtKeterangan.setText("");
        generateNextID();
        txtNamaKategori.requestFocus();
    }
    
    /**
     * Validate input data
     */
    private boolean validateInput() {
        String id = txtIDKategori.getText().trim();
        String nama = txtNamaKategori.getText().trim();
        
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "ID Kategori tidak boleh kosong!",
                "Validasi Error",
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Nama Kategori tidak boleh kosong!",
                "Validasi Error",
                JOptionPane.WARNING_MESSAGE);
            txtNamaKategori.requestFocus();
            return false;
        }
        
        if (nama.length() < 3) {
            JOptionPane.showMessageDialog(this,
                "Nama Kategori minimal 3 karakter!",
                "Validasi Error",
                JOptionPane.WARNING_MESSAGE);
            txtNamaKategori.requestFocus();
            return false;
        }
        
        return true;
    }
    
    // ==================== EVENT HANDLERS ====================
    
    /**
     * Save new kategori data
     */
    private void simpanActionPerformed() {
        if (!validateInput()) {
            return;
        }
        
        String id = txtIDKategori.getText().trim();
        String nama = txtNamaKategori.getText().trim();
        String keterangan = txtKeterangan.getText().trim();
        
        // Confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(this,
            "Simpan data kategori berikut?\n\n" +
            "ID Kategori: " + id + "\n" +
            "Nama: " + nama + "\n" +
            "Keterangan: " + (keterangan.isEmpty() ? "-" : keterangan),
            "Konfirmasi Simpan",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        
        try {
            conn = koneksi.getConnection();
            
            // Check if ID already exists
            String checkSql = "SELECT id_kategori FROM kategori WHERE id_kategori = ?";
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setString(1, id);
            ResultSet rs = checkPs.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(this,
                    "ID Kategori sudah ada! Gunakan ID yang berbeda.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                rs.close();
                checkPs.close();
                return;
            }
            rs.close();
            checkPs.close();
            
            // Insert new data
            String sql = "INSERT INTO kategori (id_kategori, nama_kategori, keterangan) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, nama);
            ps.setString(3, keterangan.isEmpty() ? null : keterangan);
            
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(this,
                "✓ Data kategori berhasil disimpan!",
                "Sukses",
                JOptionPane.INFORMATION_MESSAGE);
            
            kosongkanForm();
            tampilData();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Gagal menyimpan data: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Update existing kategori data
     */
    private void ubahActionPerformed() {
        if (!validateInput()) {
            return;
        }
        
        String id = txtIDKategori.getText().trim();
        String nama = txtNamaKategori.getText().trim();
        String keterangan = txtKeterangan.getText().trim();
        
        // Confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(this,
            "Ubah data kategori berikut?\n\n" +
            "ID Kategori: " + id + "\n" +
            "Nama: " + nama + "\n" +
            "Keterangan: " + (keterangan.isEmpty() ? "-" : keterangan),
            "Konfirmasi Ubah",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        
        try {
            conn = koneksi.getConnection();
            String sql = "UPDATE kategori SET nama_kategori = ?, keterangan = ? WHERE id_kategori = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setString(2, keterangan.isEmpty() ? null : keterangan);
            ps.setString(3, id);
            
            int result = ps.executeUpdate();
            ps.close();
            
            if (result > 0) {
                JOptionPane.showMessageDialog(this,
                    "✓ Data kategori berhasil diubah!",
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
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Gagal mengubah data: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Delete kategori data
     */
    private void hapusActionPerformed() {
        String id = txtIDKategori.getText().trim();
        
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Pilih data yang akan dihapus!",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(this,
            "Hapus data kategori berikut?\n\n" +
            "ID Kategori: " + id + "\n" +
            "Nama: " + txtNamaKategori.getText() + "\n\n" +
            "Data yang dihapus tidak dapat dikembalikan!",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
        
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        
        try {
            conn = koneksi.getConnection();
            String sql = "DELETE FROM kategori WHERE id_kategori = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            
            int result = ps.executeUpdate();
            ps.close();
            
            if (result > 0) {
                JOptionPane.showMessageDialog(this,
                    "✓ Data kategori berhasil dihapus!",
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
            
        } catch (Exception e) {
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
        // Check if there's data in fields
        boolean hasData = !txtNamaKategori.getText().trim().isEmpty() || 
                         !txtKeterangan.getText().trim().isEmpty();
        
        if (hasData) {
            int confirm = JOptionPane.showConfirmDialog(this,
                "Bersihkan semua field?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
        }
        
        kosongkanForm();
        tampilData();
    }
    
    /**
     * Search kategori data
     */
    private void cariActionPerformed() {
        String keyword = txtSearch.getText().trim();
        
        if (keyword.isEmpty()) {
            tampilData();
            return;
        }
        
        try {
            conn = koneksi.getConnection();
            tableModel.setRowCount(0);
            
            String sql = "SELECT * FROM kategori WHERE " +
                        "id_kategori LIKE ? OR " +
                        "nama_kategori LIKE ? OR " +
                        "keterangan LIKE ? " +
                        "ORDER BY id_kategori";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            String searchPattern = "%" + keyword + "%";
            ps.setString(1, searchPattern);
            ps.setString(2, searchPattern);
            ps.setString(3, searchPattern);
            
            ResultSet rs = ps.executeQuery();
            
            int count = 0;
            while (rs.next()) {
                Object[] row = {
                    rs.getString("id_kategori"),
                    rs.getString("nama_kategori"),
                    rs.getString("keterangan")
                };
                tableModel.addRow(row);
                count++;
            }
            
            rs.close();
            ps.close();
            
            if (count == 0) {
                JOptionPane.showMessageDialog(this,
                    "Data tidak ditemukan untuk: " + keyword,
                    "Hasil Pencarian",
                    JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Gagal mencari data: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Print kategori report
     */
    private void cetakActionPerformed() {
        try {
            conn = koneksi.getConnection();
            
            InputStream reportStream = getClass().getResourceAsStream("/laporan/LaporanDataKategori.jasper");
            
            if (reportStream == null) {
                JOptionPane.showMessageDialog(this,
                    "File laporan tidak ditemukan!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            HashMap<String, Object> parameters = new HashMap<>();
            JasperPrint print = JasperFillManager.fillReport(reportStream, parameters, conn);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Gagal mencetak laporan: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new kategori().setVisible(true);
        });
    }
}
