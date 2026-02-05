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
import com.toedter.calendar.JDateChooser;
import ui.ModernTheme;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Form Data Aset - Modernized Version
 * Sistem Inventaris Aset SMA Negeri 62 Jakarta
 * 
 * @author Sistem Inventaris Aset
 * @version 2.0 (Modernized with ModernTheme - Phase 4)
 */
public class aset extends JFrame {
    
    // Components
    private JTextField txtIDAset;
    private JTextField txtNamaAset;
    private JDateChooser dateTanggalMasuk;
    private JComboBox<String> cmbKondisi;
    private JTextField txtSearch;
    private JButton btnSimpan;
    private JButton btnUbah;
    private JButton btnHapus;
    private JButton btnBersihkan;
    private JButton btnCari;
    private JButton btnCetak;
    private JTable tableAset;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    
    // Database connection
    private Connection conn;
    
    /**
     * Constructor - Initialize form and apply modern theme
     */
    public aset() {
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
        setTitle("Form Data Aset - Sistem Inventaris Aset");
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
        
        JLabel lblTitle = ModernTheme.createStyledLabel("FORM DATA ASET", "h2");
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
        
        // Row 0: ID Aset
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
        JLabel lblID = ModernTheme.createStyledLabel("ID Aset", "label");
        card.add(lblID, gbc);
        
        gbc.gridx = 1; gbc.weightx = 1;
        txtIDAset = ModernTheme.createStyledTextField();
        txtIDAset.setEnabled(false);
        txtIDAset.setToolTipText("ID Aset (Auto-generated)");
        card.add(txtIDAset, gbc);
        
        // Row 1: Nama Aset
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        JLabel lblNama = ModernTheme.createStyledLabel("Nama Aset *", "label");
        card.add(lblNama, gbc);
        
        gbc.gridx = 1; gbc.weightx = 1;
        txtNamaAset = ModernTheme.createStyledTextField();
        txtNamaAset.setToolTipText("Nama aset (minimal 3 karakter)");
        card.add(txtNamaAset, gbc);
        
        // Row 2: Tanggal Masuk
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        JLabel lblTanggal = ModernTheme.createStyledLabel("Tanggal Masuk *", "label");
        card.add(lblTanggal, gbc);
        
        gbc.gridx = 1; gbc.weightx = 1;
        dateTanggalMasuk = new JDateChooser();
        dateTanggalMasuk.setDateFormatString("yyyy-MM-dd");
        dateTanggalMasuk.setPreferredSize(new Dimension(0, 40));
        dateTanggalMasuk.setFont(ModernTheme.FONT_BODY);
        dateTanggalMasuk.setToolTipText("Pilih tanggal masuk aset");
        card.add(dateTanggalMasuk, gbc);
        
        // Row 3: Kondisi
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0;
        JLabel lblKondisi = ModernTheme.createStyledLabel("Kondisi *", "label");
        card.add(lblKondisi, gbc);
        
        gbc.gridx = 1; gbc.weightx = 1;
        String[] kondisiOptions = {"Baik", "Rusak Ringan", "Rusak Berat"};
        cmbKondisi = new JComboBox<>(kondisiOptions);
        cmbKondisi.setFont(ModernTheme.FONT_BODY);
        cmbKondisi.setPreferredSize(new Dimension(0, 40));
        cmbKondisi.setBackground(Color.WHITE);
        cmbKondisi.setToolTipText("Pilih kondisi aset");
        card.add(cmbKondisi, gbc);
        
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
        String[] columns = {"ID Aset", "Nama Aset", "Tanggal Masuk", "Kondisi"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        // Create table
        tableAset = ModernTheme.createStyledTable(tableModel);
        tableAset.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int row = tableAset.getSelectedRow();
                    if (row != -1) {
                        txtIDAset.setText(tableAset.getValueAt(row, 0).toString());
                        txtNamaAset.setText(tableAset.getValueAt(row, 1).toString());
                        
                        // Parse tanggal
                        try {
                            String tanggalStr = tableAset.getValueAt(row, 2).toString();
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            Date tanggal = sdf.parse(tanggalStr);
                            dateTanggalMasuk.setDate(tanggal);
                        } catch (Exception ex) {
                            dateTanggalMasuk.setDate(null);
                        }
                        
                        cmbKondisi.setSelectedItem(tableAset.getValueAt(row, 3).toString());
                    }
                }
            }
        });
        
        scrollPane = new JScrollPane(tableAset);
        scrollPane.setBorder(BorderFactory.createLineBorder(ModernTheme.BORDER, 1));
        
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    // ==================== DATABASE METHODS ====================
    
    /**
     * Generate next ID Aset automatically
     */
    private void generateNextID() {
        try {
            conn = koneksi.getConnection();
            String sql = "SELECT id_aset FROM aset ORDER BY id_aset DESC LIMIT 1";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()) {
                String lastID = rs.getString("id_aset");
                String numPart = lastID.substring(3); // Remove "AST"
                int nextNum = Integer.parseInt(numPart) + 1;
                String nextID = String.format("AST%03d", nextNum);
                txtIDAset.setText(nextID);
            } else {
                txtIDAset.setText("AST001");
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            txtIDAset.setText("AST001");
        }
    }
    
    /**
     * Display all aset data in table
     */
    private void tampilData() {
        try {
            conn = koneksi.getConnection();
            tableModel.setRowCount(0);
            
            String sql = "SELECT * FROM aset ORDER BY id_aset";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                Object[] row = {
                    rs.getString("id_aset"),
                    rs.getString("nama_aset"),
                    rs.getDate("tanggal_masuk"),
                    rs.getString("kondisi")
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
        txtNamaAset.setText("");
        dateTanggalMasuk.setDate(null);
        cmbKondisi.setSelectedIndex(0);
        generateNextID();
        txtNamaAset.requestFocus();
    }
    
    /**
     * Validate input data
     */
    private boolean validateInput() {
        String id = txtIDAset.getText().trim();
        String nama = txtNamaAset.getText().trim();
        Date tanggal = dateTanggalMasuk.getDate();
        
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "ID Aset tidak boleh kosong!",
                "Validasi Error",
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Nama Aset tidak boleh kosong!",
                "Validasi Error",
                JOptionPane.WARNING_MESSAGE);
            txtNamaAset.requestFocus();
            return false;
        }
        
        if (nama.length() < 3) {
            JOptionPane.showMessageDialog(this,
                "Nama Aset minimal 3 karakter!",
                "Validasi Error",
                JOptionPane.WARNING_MESSAGE);
            txtNamaAset.requestFocus();
            return false;
        }
        
        if (tanggal == null) {
            JOptionPane.showMessageDialog(this,
                "Tanggal Masuk tidak boleh kosong!",
                "Validasi Error",
                JOptionPane.WARNING_MESSAGE);
            dateTanggalMasuk.requestFocus();
            return false;
        }
        
        return true;
    }
    
    // ==================== EVENT HANDLERS ====================
    
    /**
     * Save new aset data
     */
    private void simpanActionPerformed() {
        if (!validateInput()) {
            return;
        }
        
        String id = txtIDAset.getText().trim();
        String nama = txtNamaAset.getText().trim();
        Date tanggal = dateTanggalMasuk.getDate();
        String kondisi = cmbKondisi.getSelectedItem().toString();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tanggalStr = sdf.format(tanggal);
        
        // Confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(this,
            "Simpan data aset berikut?\n\n" +
            "ID Aset: " + id + "\n" +
            "Nama: " + nama + "\n" +
            "Tanggal Masuk: " + tanggalStr + "\n" +
            "Kondisi: " + kondisi,
            "Konfirmasi Simpan",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        
        try {
            conn = koneksi.getConnection();
            
            // Check if ID already exists
            String checkSql = "SELECT id_aset FROM aset WHERE id_aset = ?";
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setString(1, id);
            ResultSet rs = checkPs.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(this,
                    "ID Aset sudah ada! Gunakan ID yang berbeda.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                rs.close();
                checkPs.close();
                return;
            }
            rs.close();
            checkPs.close();
            
            // Insert new data
            String sql = "INSERT INTO aset (id_aset, nama_aset, tanggal_masuk, kondisi) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, nama);
            ps.setString(3, tanggalStr);
            ps.setString(4, kondisi);
            
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(this,
                "✓ Data aset berhasil disimpan!",
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
     * Update existing aset data
     */
    private void ubahActionPerformed() {
        if (!validateInput()) {
            return;
        }
        
        String id = txtIDAset.getText().trim();
        String nama = txtNamaAset.getText().trim();
        Date tanggal = dateTanggalMasuk.getDate();
        String kondisi = cmbKondisi.getSelectedItem().toString();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tanggalStr = sdf.format(tanggal);
        
        // Confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(this,
            "Ubah data aset berikut?\n\n" +
            "ID Aset: " + id + "\n" +
            "Nama: " + nama + "\n" +
            "Tanggal Masuk: " + tanggalStr + "\n" +
            "Kondisi: " + kondisi,
            "Konfirmasi Ubah",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        
        try {
            conn = koneksi.getConnection();
            String sql = "UPDATE aset SET nama_aset = ?, tanggal_masuk = ?, kondisi = ? WHERE id_aset = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setString(2, tanggalStr);
            ps.setString(3, kondisi);
            ps.setString(4, id);
            
            int result = ps.executeUpdate();
            ps.close();
            
            if (result > 0) {
                JOptionPane.showMessageDialog(this,
                    "✓ Data aset berhasil diubah!",
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
     * Delete aset data
     */
    private void hapusActionPerformed() {
        String id = txtIDAset.getText().trim();
        
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Pilih data yang akan dihapus!",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(this,
            "Hapus data aset berikut?\n\n" +
            "ID Aset: " + id + "\n" +
            "Nama: " + txtNamaAset.getText() + "\n\n" +
            "Data yang dihapus tidak dapat dikembalikan!",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
        
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        
        try {
            conn = koneksi.getConnection();
            String sql = "DELETE FROM aset WHERE id_aset = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            
            int result = ps.executeUpdate();
            ps.close();
            
            if (result > 0) {
                JOptionPane.showMessageDialog(this,
                    "✓ Data aset berhasil dihapus!",
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
        boolean hasData = !txtNamaAset.getText().trim().isEmpty() || 
                         dateTanggalMasuk.getDate() != null;
        
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
     * Search aset data
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
            
            String sql = "SELECT * FROM aset WHERE " +
                        "id_aset LIKE ? OR " +
                        "nama_aset LIKE ? OR " +
                        "kondisi LIKE ? " +
                        "ORDER BY id_aset";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            String searchPattern = "%" + keyword + "%";
            ps.setString(1, searchPattern);
            ps.setString(2, searchPattern);
            ps.setString(3, searchPattern);
            
            ResultSet rs = ps.executeQuery();
            
            int count = 0;
            while (rs.next()) {
                Object[] row = {
                    rs.getString("id_aset"),
                    rs.getString("nama_aset"),
                    rs.getDate("tanggal_masuk"),
                    rs.getString("kondisi")
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
     * Print aset report
     */
    private void cetakActionPerformed() {
        try {
            conn = koneksi.getConnection();
            
            InputStream reportStream = getClass().getResourceAsStream("/laporan/LaporanDataAset.jasper");
            
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
            new aset().setVisible(true);
        });
    }
}
