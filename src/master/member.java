/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
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
        
        // Auto-generate ID pertama kali
        String nextID = generateNextID();
        idmember.setText(nextID);
        
        // Set tooltip untuk membantu user
        idmember.setToolTipText("Format: MBR001, MBR002, dst. (Auto-generated)");
        namamember.setToolTipText("Nama lengkap member (2-100 karakter, hanya huruf)");
        kontak.setToolTipText("Nomor telepon (8-15 digit). Contoh: 081234567890");
        
        // Setup Enter key listener untuk search field
        setupSearchEnterKey();
        
        // Setup table highlighting
        setupTableHighlight();
        
        // Focus ke nama member (ID sudah auto-fill)
        namamember.requestFocus();
    }
    
    /**
     * Setup Enter key untuk trigger search
     */
    private void setupSearchEnterKey() {
        cariteks.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Trigger search button click
                    cari.doClick();
                }
            }
        });
        
        // Tambahkan tooltip
        cariteks.setToolTipText("Ketik kata kunci dan tekan Enter untuk mencari");
    }
    
    /**
     * Setup table untuk highlight hasil pencarian
     */
    private void setupTableHighlight() {
        // Set default renderer untuk semua kolom
        tabelmember.setDefaultRenderer(Object.class, new HighlightTableCellRenderer());
        
        // Set row height untuk readability
        tabelmember.setRowHeight(25);
        
        // Set font
        tabelmember.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tabelmember.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
    }
    
    /**
     * Custom cell renderer untuk highlight hasil pencarian
     */
    private class HighlightTableCellRenderer extends DefaultTableCellRenderer {
        private String searchKeyword = "";
        private Color highlightColor = new Color(173, 216, 230); // Light blue (biru muda)
        private Color matchTextColor = new Color(0, 51, 102); // Dark blue
        private java.util.Set<Integer> highlightedRows = new java.util.HashSet<>();
        
        public void setSearchKeyword(String keyword) {
            this.searchKeyword = keyword.toLowerCase();
            updateHighlightedRows();
        }
        
        private void updateHighlightedRows() {
            highlightedRows.clear();
            
            if (searchKeyword.isEmpty()) {
                return;
            }
            
            // Cari semua baris yang mengandung keyword di salah satu kolom
            DefaultTableModel model = (DefaultTableModel) tabelmember.getModel();
            for (int row = 0; row < model.getRowCount(); row++) {
                boolean found = false;
                
                // Cek semua kolom (ID, Nama, Kontak)
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Object value = model.getValueAt(row, col);
                    if (value != null) {
                        String cellValue = value.toString().toLowerCase();
                        if (cellValue.contains(searchKeyword)) {
                            found = true;
                            break;
                        }
                    }
                }
                
                if (found) {
                    highlightedRows.add(row);
                }
            }
        }
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            // Jika baris ini ada di highlightedRows, highlight SEMUA CELL di baris ini
            if (highlightedRows.contains(row)) {
                if (!isSelected) {
                    c.setBackground(highlightColor);
                    c.setForeground(matchTextColor);
                    setFont(getFont().deriveFont(Font.BOLD));
                } else {
                    // Jika row selected, gunakan warna selection tapi bold
                    setFont(getFont().deriveFont(Font.BOLD));
                }
            } else {
                if (!isSelected) {
                    c.setBackground(Color.WHITE);
                    c.setForeground(Color.BLACK);
                    setFont(getFont().deriveFont(Font.PLAIN));
                }
            }
            
            return c;
        }
    }
    
    /**
     * Apply highlight ke tabel berdasarkan keyword
     */
    private void applyTableHighlight(String keyword) {
        HighlightTableCellRenderer renderer = (HighlightTableCellRenderer) tabelmember.getDefaultRenderer(Object.class);
        renderer.setSearchKeyword(keyword);
        tabelmember.repaint();
    }
    
    /**
     * Clear highlight dari tabel
     */
    private void clearTableHighlight() {
        HighlightTableCellRenderer renderer = (HighlightTableCellRenderer) tabelmember.getDefaultRenderer(Object.class);
        renderer.setSearchKeyword("");
        tabelmember.repaint();
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
    
    // ========== PROFESSIONAL HELPER METHODS ==========
    
    /**
     * Auto-generate ID Member berikutnya (MBR001, MBR002, dst)
     */
    private String generateNextID() {
        String nextID = "MBR001"; // Default ID pertama
        try {
            String url = "jdbc:mysql://localhost:3306/inventaris_aset";
            String user = "inventaris";
            String pass = "inventaris123";
            Connection conn = DriverManager.getConnection(url, user, pass);
            
            String sql = "SELECT id_member FROM member ORDER BY id_member DESC LIMIT 1";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()) {
                String lastID = rs.getString("id_member");
                // Extract angka dari ID (contoh: MBR001 -> 001)
                String numPart = lastID.replaceAll("[^0-9]", "");
                if (!numPart.isEmpty()) {
                    int num = Integer.parseInt(numPart) + 1;
                    nextID = String.format("MBR%03d", num); // Format: MBR001, MBR002, dst
                }
            }
            
            conn.close();
        } catch (Exception e) {
            System.out.println("Error generating ID: " + e.getMessage());
        }
        return nextID;
    }
    
    /**
     * Cek apakah ID sudah ada di database
     */
    private boolean isIDExists(String id) {
        try {
            String url = "jdbc:mysql://localhost:3306/inventaris_aset";
            String user = "inventaris";
            String pass = "inventaris123";
            Connection conn = DriverManager.getConnection(url, user, pass);
            
            String sql = "SELECT COUNT(*) FROM member WHERE id_member = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                int count = rs.getInt(1);
                conn.close();
                return count > 0;
            }
            
            conn.close();
        } catch (Exception e) {
            System.out.println("Error checking ID: " + e.getMessage());
        }
        return false;
    }
    
    /**
     * Validasi format nama (hanya huruf, spasi, dan tanda baca umum)
     */
    private boolean isValidName(String name) {
        // Nama harus mengandung minimal 1 huruf dan hanya boleh huruf, spasi, titik, koma, apostrof
        return name.matches("^[a-zA-Z\\s.',-]+$") && name.trim().length() >= 2;
    }
    
    /**
     * Validasi format kontak (hanya angka, +, -, spasi, kurung)
     */
    private boolean isValidContact(String contact) {
        // Format: angka, +, -, spasi, kurung
        // Contoh valid: 081234567890, +62 812-3456-7890, (021) 1234567
        String cleaned = contact.replaceAll("[\\s\\-\\(\\)\\+]", "");
        return cleaned.matches("^[0-9]{8,15}$"); // 8-15 digit angka
    }
    
    /**
     * Format kontak ke format standar Indonesia
     */
    private String formatContact(String contact) {
        // Hapus semua karakter non-digit
        String cleaned = contact.replaceAll("[^0-9]", "");
        
        // Jika dimulai dengan 0, ganti dengan +62
        if (cleaned.startsWith("0")) {
            cleaned = "62" + cleaned.substring(1);
        }
        
        // Jika belum ada kode negara, tambahkan +62
        if (!cleaned.startsWith("62")) {
            cleaned = "62" + cleaned;
        }
        
        return "+" + cleaned;
    }
    
    /**
     * Bersihkan input dari whitespace berlebih
     */
    private String cleanInput(String input) {
        if (input == null) return "";
        // Trim dan replace multiple spaces dengan single space
        return input.trim().replaceAll("\\s+", " ");
    }
    
    /**
     * Validasi lengkap sebelum simpan
     */
    private String validateInput(String id, String nama, String kontak) {
        // Bersihkan input
        id = cleanInput(id).toUpperCase();
        nama = cleanInput(nama);
        kontak = cleanInput(kontak);
        
        // Cek field kosong
        if (id.isEmpty() || nama.isEmpty() || kontak.isEmpty()) {
            return "Semua field harus diisi!";
        }
        
        // Validasi panjang ID
        if (id.length() > 20) {
            return "ID Member terlalu panjang! Maksimal 20 karakter.\nFormat yang disarankan: MBR001";
        }
        
        // Validasi format ID (harus dimulai dengan huruf)
        if (!id.matches("^[A-Z]{3}[0-9]{3,}$")) {
            return "Format ID tidak valid!\nFormat yang benar: MBR001, MBR002, dst.\n(3 huruf + minimal 3 angka)";
        }
        
        // Validasi panjang Nama
        if (nama.length() > 100) {
            return "Nama Member terlalu panjang! Maksimal 100 karakter.";
        }
        
        // Validasi format nama
        if (!isValidName(nama)) {
            return "Nama tidak valid!\nNama hanya boleh mengandung huruf, spasi, dan tanda baca umum.\nMinimal 2 karakter.";
        }
        
        // Validasi panjang Kontak
        if (kontak.length() > 20) {
            return "Kontak terlalu panjang! Maksimal 20 karakter.";
        }
        
        // Validasi format kontak
        if (!isValidContact(kontak)) {
            return "Format kontak tidak valid!\nKontak harus berupa nomor telepon (8-15 digit).\nContoh: 081234567890 atau +62 812-3456-7890";
        }
        
        return null; // Tidak ada error
    }
    
    /**
     * Clear semua input field
     */
    private void clearFields() {
        idmember.setText("");
        namamember.setText("");
        kontak.setText("");
        idmember.requestFocus();
    }
    
    /**
     * Search dengan highlight hasil
     */
    private void performSearch(String keyword) {
        if (keyword.trim().isEmpty()) {
            tampilData();
            return;
        }
        
        try {
            String url = "jdbc:mysql://localhost:3306/inventaris_aset";
            String user = "inventaris";
            String pass = "inventaris123";
            Connection conn = DriverManager.getConnection(url, user, pass);
            
            String sql = "SELECT * FROM member WHERE id_member LIKE ? OR nama_member LIKE ? OR kontak LIKE ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            String searchPattern = "%" + keyword + "%";
            pst.setString(1, searchPattern);
            pst.setString(2, searchPattern);
            pst.setString(3, searchPattern);
            
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tabelmember.getModel();
            model.setRowCount(0);
            
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_member"),
                    rs.getString("nama_member"),
                    rs.getString("kontak")
                });
            }
            
            conn.close();
        } catch (SQLException e) {
            System.out.println("Search error: " + e.getMessage());
        }
    }
    
    /**
     * Deteksi tipe pencarian berdasarkan pattern
     */
    private String detectSearchType(String keyword) {
        keyword = keyword.trim().toUpperCase();
        
        // Deteksi ID (format: 3 huruf + angka, contoh: MBR001)
        if (keyword.matches("^[A-Z]{3}[0-9]+$")) {
            return "ID";
        }
        
        // Deteksi Kontak (dimulai dengan angka, +, atau 0)
        if (keyword.matches("^[+0-9].*")) {
            return "KONTAK";
        }
        
        // Deteksi Nama (mengandung huruf)
        if (keyword.matches(".*[A-Z].*")) {
            return "NAMA";
        }
        
        return "UMUM";
    }
    
    /**
     * Smart search dengan auto-detection dan optimized query
     */
    private SearchResult smartSearch(String keyword) {
        SearchResult result = new SearchResult();
        result.keyword = keyword;
        result.searchType = detectSearchType(keyword);
        
        try {
            String url = "jdbc:mysql://localhost:3306/inventaris_aset";
            String user = "inventaris";
            String pass = "inventaris123";
            Connection conn = DriverManager.getConnection(url, user, pass);
            
            String sql;
            PreparedStatement pst;
            
            // Optimized query berdasarkan tipe pencarian
            switch (result.searchType) {
                case "ID":
                    // Prioritas pencarian ID
                    sql = "SELECT * FROM member WHERE id_member LIKE ? " +
                          "UNION " +
                          "SELECT * FROM member WHERE nama_member LIKE ? OR kontak LIKE ?";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, "%" + keyword + "%");
                    pst.setString(2, "%" + keyword + "%");
                    pst.setString(3, "%" + keyword + "%");
                    break;
                    
                case "KONTAK":
                    // Prioritas pencarian kontak
                    sql = "SELECT * FROM member WHERE kontak LIKE ? " +
                          "UNION " +
                          "SELECT * FROM member WHERE id_member LIKE ? OR nama_member LIKE ?";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, "%" + keyword + "%");
                    pst.setString(2, "%" + keyword + "%");
                    pst.setString(3, "%" + keyword + "%");
                    break;
                    
                case "NAMA":
                    // Prioritas pencarian nama
                    sql = "SELECT * FROM member WHERE nama_member LIKE ? " +
                          "UNION " +
                          "SELECT * FROM member WHERE id_member LIKE ? OR kontak LIKE ?";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, "%" + keyword + "%");
                    pst.setString(2, "%" + keyword + "%");
                    pst.setString(3, "%" + keyword + "%");
                    break;
                    
                default:
                    // Pencarian umum
                    sql = "SELECT * FROM member WHERE id_member LIKE ? OR nama_member LIKE ? OR kontak LIKE ?";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, "%" + keyword + "%");
                    pst.setString(2, "%" + keyword + "%");
                    pst.setString(3, "%" + keyword + "%");
                    break;
            }
            
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                String[] row = {
                    rs.getString("id_member"),
                    rs.getString("nama_member"),
                    rs.getString("kontak")
                };
                result.addResult(row);
            }
            
            conn.close();
            result.success = true;
            
        } catch (SQLException e) {
            result.success = false;
            result.errorMessage = e.getMessage();
        }
        
        return result;
    }
    
    /**
     * Generate search suggestions berdasarkan keyword
     */
    private String[] generateSearchSuggestions(String keyword, String searchType) {
        java.util.List<String> suggestions = new java.util.ArrayList<>();
        
        switch (searchType) {
            case "ID":
                suggestions.add("Coba format lengkap: MBR001, MBR002, dst");
                suggestions.add("Coba hanya angka: 001, 002, dst");
                suggestions.add("Periksa apakah ID sudah benar");
                break;
                
            case "KONTAK":
                suggestions.add("Coba tanpa kode negara: 081234567890");
                suggestions.add("Coba dengan +62: +6281234567890");
                suggestions.add("Coba hanya beberapa digit awal: 0812");
                break;
                
            case "NAMA":
                suggestions.add("Coba nama depan saja: Andi");
                suggestions.add("Coba nama belakang: Pratama");
                suggestions.add("Periksa ejaan nama");
                break;
                
            default:
                suggestions.add("Coba kata kunci lebih spesifik");
                suggestions.add("Coba kata kunci lebih pendek");
                suggestions.add("Periksa ejaan");
                break;
        }
        
        return suggestions.toArray(new String[0]);
    }
    
    /**
     * Inner class untuk menyimpan hasil pencarian
     */
    private class SearchResult {
        String keyword;
        String searchType;
        java.util.List<String[]> results;
        boolean success;
        String errorMessage;
        
        SearchResult() {
            results = new java.util.ArrayList<>();
            success = false;
        }
        
        void addResult(String[] row) {
            results.add(row);
        }
        
        int getCount() {
            return results.size();
        }
        
        String[][] getResultsArray() {
            return results.toArray(new String[0][]);
        }
    }
    
    // ========== END HELPER METHODS ==========
    
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
        // Ambil dan bersihkan input
        String ID = cleanInput(idmember.getText()).toUpperCase();
        String Nama = cleanInput(namamember.getText());
        String Kontak = cleanInput(kontak.getText());
        
        // Validasi input
        String errorMsg = validateInput(ID, Nama, Kontak);
        if (errorMsg != null) {
            JOptionPane.showMessageDialog(this, errorMsg, "Validasi Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Cek duplikasi ID
        if (isIDExists(ID)) {
            int response = JOptionPane.showConfirmDialog(this, 
                "ID Member '" + ID + "' sudah ada!\n\nApakah Anda ingin menggunakan ID otomatis berikutnya?",
                "ID Duplikat", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
            
            if (response == JOptionPane.YES_OPTION) {
                ID = generateNextID();
                idmember.setText(ID);
                JOptionPane.showMessageDialog(this, "ID otomatis: " + ID, "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                return;
            }
        }
        
        // Format kontak ke standar Indonesia
        String formattedKontak = formatContact(Kontak);
        
        // Konfirmasi sebelum simpan
        int confirm = JOptionPane.showConfirmDialog(this,
            "Simpan data berikut?\n\n" +
            "ID Member: " + ID + "\n" +
            "Nama: " + Nama + "\n" +
            "Kontak: " + formattedKontak,
            "Konfirmasi Simpan",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirm != JOptionPane.YES_OPTION) {
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
            pst.setString(3, formattedKontak);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, 
                "✓ Data berhasil disimpan!\n\n" +
                "ID: " + ID + "\n" +
                "Nama: " + Nama + "\n" +
                "Kontak: " + formattedKontak,
                "Sukses",
                JOptionPane.INFORMATION_MESSAGE);

            clearFields();
            conn.close();
            tampilData();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "❌ Data gagal disimpan!\n\n" +
                "Error: " + e.getMessage() + "\n\n" +
                "Silakan cek kembali data Anda.",
                "Error Database",
                JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(this, 
                "⚠ Pilih data yang ingin dihapus terlebih dahulu!\n\nKlik pada baris data di tabel.",
                "Tidak Ada Data Dipilih",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = tabelmember.getValueAt(baris, 0).toString();
        String nama = tabelmember.getValueAt(baris, 1).toString();
        String kontak = tabelmember.getValueAt(baris, 2).toString();

        // Konfirmasi dengan detail data
        int konfirmasi = JOptionPane.showConfirmDialog(
            this,
            "⚠ PERHATIAN: Data yang dihapus tidak dapat dikembalikan!\n\n" +
            "Apakah Anda yakin ingin menghapus data berikut?\n\n" +
            "ID Member: " + id + "\n" +
            "Nama: " + nama + "\n" +
            "Kontak: " + kontak,
            "Konfirmasi Hapus Data",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
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
                    JOptionPane.showMessageDialog(this, 
                        "✓ Data berhasil dihapus!\n\n" +
                        "ID: " + id + "\n" +
                        "Nama: " + nama,
                        "Sukses",
                        JOptionPane.INFORMATION_MESSAGE);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "❌ Data tidak ditemukan atau gagal dihapus!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
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

        // Jika kosong, tampilkan semua data tanpa highlight
        if (key.isEmpty()) {
            clearTableHighlight();
            tampilData();
            return;
        }

        // Perform smart search
        SearchResult result = smartSearch(key);
        
        if (!result.success) {
            JOptionPane.showMessageDialog(this, 
                "Pencarian gagal: " + result.errorMessage,
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Update tabel dengan hasil
        DefaultTableModel model = (DefaultTableModel) tabelmember.getModel();
        model.setRowCount(0);
        
        for (String[] row : result.results) {
            model.addRow(row);
        }
        
        // Apply highlight BIRU MUDA ke hasil pencarian
        applyTableHighlight(key);
        
        // Jika tidak ada hasil, tampilkan pesan singkat
        if (result.getCount() == 0) {
            JOptionPane.showMessageDialog(this,
                "Tidak ada data ditemukan untuk: \"" + key + "\"",
                "Tidak Ada Hasil",
                JOptionPane.INFORMATION_MESSAGE);
            
            // Tawarkan untuk menampilkan semua data
            int response = JOptionPane.showConfirmDialog(this,
                "Tampilkan semua data?",
                "Opsi",
                JOptionPane.YES_NO_OPTION);
            
            if (response == JOptionPane.YES_OPTION) {
                clearTableHighlight();
                tampilData();
                cariteks.setText("");
            }
        }
        // Jika ada hasil, TIDAK ADA DIALOG - langsung highlight saja!
    }//GEN-LAST:event_cariActionPerformed

    private void bersikan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bersikan1ActionPerformed
        // Konfirmasi sebelum clear jika ada data di field
        if (!idmember.getText().trim().isEmpty() || 
            !namamember.getText().trim().isEmpty() || 
            !kontak.getText().trim().isEmpty()) {
            
            int confirm = JOptionPane.showConfirmDialog(this,
                "Hapus semua input yang sedang diisi?",
                "Konfirmasi Clear",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
        }
        
        cariteks.setText("");
        clearFields();
        clearTableHighlight(); // Clear highlight
        tampilData(); // Tampilkan semua data
        
        // Auto-generate ID baru
        String nextID = generateNextID();
        idmember.setText(nextID);
        
        JOptionPane.showMessageDialog(this,
            "✓ Form berhasil dibersihkan!\n\n" +
            "ID otomatis berikutnya: " + nextID + "\n" +
            "Highlight pencarian: Dihapus\n" +
            "Tabel: Menampilkan semua data",
            "Info",
            JOptionPane.INFORMATION_MESSAGE);
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

