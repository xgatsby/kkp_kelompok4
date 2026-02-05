package master;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import ui.ModernTheme;
import transaksi.mutasi;
import transaksi.peminjaman;

/**
 * Dashboard Utama - Sistem Inventaris Aset SMA Negeri 62 Jakarta
 * 
 * Dashboard modern dengan sidebar navigation, top bar, dan content area.
 * Menggunakan ModernTheme untuk konsistensi visual.
 * 
 * @author Sistem Inventaris Aset
 * @version 2.0 (Modernized)
 */
public class branda extends JFrame {
    
    // Components
    private JPanel topBar;
    private JPanel sidebar;
    private JPanel contentArea;
    private JLabel lblTanggal;
    
    // Menu buttons
    private JButton btnBeranda;
    private JButton btnMember;
    private JButton btnAset;
    private JButton btnKategori;
    private JButton btnLokasi;
    private JButton btnPeminjaman;
    private JButton btnMutasi;
    private JButton btnLogout;
    
    public branda() {
        ModernTheme.applyTheme();
        initComponents();
        setLocationRelativeTo(null);
        tampilkanTanggal();
    }
    
    private void initComponents() {
        setTitle("Dashboard - Sistem Inventaris Aset");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLayout(new BorderLayout());
        
        // Create main components
        createTopBar();
        createSidebar();
        createContentArea();
        
        // Add to frame
        add(topBar, BorderLayout.NORTH);
        add(sidebar, BorderLayout.WEST);
        add(contentArea, BorderLayout.CENTER);
    }
    
    /**
     * Membuat top bar dengan title, search, dan user info
     */
    private void createTopBar() {
        topBar = new JPanel(new BorderLayout());
        topBar.setBackground(ModernTheme.BIRU_UTAMA);
        topBar.setPreferredSize(new Dimension(getWidth(), ModernTheme.TOPBAR_HEIGHT));
        topBar.setBorder(BorderFactory.createEmptyBorder(0, ModernTheme.SPACING_L, 0, ModernTheme.SPACING_L));
        
        // Left section - Title
        JLabel lblTitle = new JLabel("SISTEM INVENTARIS ASET");
        lblTitle.setFont(ModernTheme.FONT_H3);
        lblTitle.setForeground(Color.WHITE);
        
        // Center section - Search box (placeholder)
        JTextField txtSearch = new JTextField();
        txtSearch.setPreferredSize(new Dimension(300, 36));
        txtSearch.setFont(ModernTheme.FONT_BODY);
        txtSearch.setForeground(Color.WHITE);
        txtSearch.setBackground(new Color(255, 255, 255, 40)); // Semi-transparent white
        txtSearch.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 255, 255, 80), 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        searchPanel.setOpaque(false);
        searchPanel.add(txtSearch);
        
        // Right section - User info and logout
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, ModernTheme.SPACING_M, 0));
        rightPanel.setOpaque(false);
        
        JLabel lblUser = new JLabel("👤 Admin");
        lblUser.setFont(ModernTheme.FONT_BODY);
        lblUser.setForeground(Color.WHITE);
        
        btnLogout = new JButton("🚪 Keluar");
        btnLogout.setFont(ModernTheme.FONT_BUTTON);
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setBackground(new Color(255, 255, 255, 40));
        btnLogout.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 255, 255, 80), 1),
            BorderFactory.createEmptyBorder(8, 16, 8, 16)
        ));
        btnLogout.setFocusPainted(false);
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogout.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Apakah Anda yakin ingin keluar?",
                "Konfirmasi Keluar",
                JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                new login().setVisible(true);
                dispose();
            }
        });
        
        // Hover effect for logout button
        btnLogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogout.setBackground(new Color(255, 255, 255, 60));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                btnLogout.setBackground(new Color(255, 255, 255, 40));
            }
        });
        
        rightPanel.add(lblUser);
        rightPanel.add(btnLogout);
        
        topBar.add(lblTitle, BorderLayout.WEST);
        topBar.add(searchPanel, BorderLayout.CENTER);
        topBar.add(rightPanel, BorderLayout.EAST);
    }
    
    /**
     * Membuat sidebar dengan menu navigasi
     */
    private void createSidebar() {
        sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(ModernTheme.LATAR_SIDEBAR);
        sidebar.setPreferredSize(new Dimension(ModernTheme.SIDEBAR_WIDTH, getHeight()));
        sidebar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, ModernTheme.BORDER));
        
        // Add spacing at top
        sidebar.add(Box.createVerticalStrut(ModernTheme.SPACING_L));
        
        // Beranda menu
        btnBeranda = createMenuButton("🏠 Beranda", true);
        btnBeranda.addActionListener(e -> setActiveMenu(btnBeranda));
        sidebar.add(btnBeranda);
        
        // DATA MASTER section
        sidebar.add(Box.createVerticalStrut(ModernTheme.SPACING_L));
        JLabel lblMaster = ModernTheme.createStyledLabel("DATA MASTER", "label");
        lblMaster.setBorder(BorderFactory.createEmptyBorder(0, ModernTheme.SPACING_M, ModernTheme.SPACING_S, 0));
        sidebar.add(lblMaster);
        
        btnMember = createMenuButton("👥 Data Member", false);
        btnMember.addActionListener(e -> memberActionPerformed(null));
        sidebar.add(btnMember);
        
        btnAset = createMenuButton("📦 Data Aset", false);
        btnAset.addActionListener(e -> asetActionPerformed(null));
        sidebar.add(btnAset);
        
        btnKategori = createMenuButton("🏷️ Data Kategori", false);
        btnKategori.addActionListener(e -> kategoriActionPerformed(null));
        sidebar.add(btnKategori);
        
        btnLokasi = createMenuButton("📍 Data Lokasi", false);
        btnLokasi.addActionListener(e -> lokasiActionPerformed(null));
        sidebar.add(btnLokasi);
        
        // TRANSAKSI section
        sidebar.add(Box.createVerticalStrut(ModernTheme.SPACING_L));
        JLabel lblTransaksi = ModernTheme.createStyledLabel("TRANSAKSI", "label");
        lblTransaksi.setBorder(BorderFactory.createEmptyBorder(0, ModernTheme.SPACING_M, ModernTheme.SPACING_S, 0));
        sidebar.add(lblTransaksi);
        
        btnPeminjaman = createMenuButton("🔄 Peminjaman Aset", false);
        btnPeminjaman.addActionListener(e -> peminjamanActionPerformed(null));
        sidebar.add(btnPeminjaman);
        
        btnMutasi = createMenuButton("↔️ Mutasi Aset", false);
        btnMutasi.addActionListener(e -> mutasiActionPerformed(null));
        sidebar.add(btnMutasi);
        
        // Push remaining space to bottom
        sidebar.add(Box.createVerticalGlue());
    }
    
    /**
     * Membuat button menu untuk sidebar
     */
    private JButton createMenuButton(String text, boolean isActive) {
        JButton button = new JButton(text);
        button.setFont(ModernTheme.FONT_BODY);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setMaximumSize(new Dimension(ModernTheme.SIDEBAR_WIDTH, 48));
        button.setPreferredSize(new Dimension(ModernTheme.SIDEBAR_WIDTH, 48));
        button.setBorder(BorderFactory.createEmptyBorder(12, ModernTheme.SPACING_M, 12, ModernTheme.SPACING_M));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        
        if (isActive) {
            button.setBackground(new Color(227, 242, 253)); // #E3F2FD
            button.setForeground(ModernTheme.BIRU_UTAMA);
            button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 4, 0, 0, ModernTheme.BIRU_UTAMA),
                BorderFactory.createEmptyBorder(12, 12, 12, ModernTheme.SPACING_M)
            ));
        } else {
            button.setBackground(ModernTheme.LATAR_SIDEBAR);
            button.setForeground(new Color(97, 97, 97)); // #616161
        }
        
        // Hover effect
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!isMenuActive(button)) {
                    button.setBackground(new Color(238, 238, 238)); // #EEEEEE
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                if (!isMenuActive(button)) {
                    button.setBackground(ModernTheme.LATAR_SIDEBAR);
                }
            }
        });
        
        return button;
    }
    
    /**
     * Set menu sebagai active dan reset yang lain
     */
    private void setActiveMenu(JButton activeButton) {
        JButton[] allButtons = {btnBeranda, btnMember, btnAset, btnKategori, btnLokasi, btnPeminjaman, btnMutasi};
        
        for (JButton btn : allButtons) {
            if (btn == activeButton) {
                btn.setBackground(new Color(227, 242, 253)); // #E3F2FD
                btn.setForeground(ModernTheme.BIRU_UTAMA);
                btn.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(0, 4, 0, 0, ModernTheme.BIRU_UTAMA),
                    BorderFactory.createEmptyBorder(12, 12, 12, ModernTheme.SPACING_M)
                ));
            } else {
                btn.setBackground(ModernTheme.LATAR_SIDEBAR);
                btn.setForeground(new Color(97, 97, 97));
                btn.setBorder(BorderFactory.createEmptyBorder(12, ModernTheme.SPACING_M, 12, ModernTheme.SPACING_M));
            }
        }
    }
    
    /**
     * Check apakah menu sedang active
     */
    private boolean isMenuActive(JButton button) {
        return button.getBackground().equals(new Color(227, 242, 253));
    }
    
    /**
     * Membuat content area dengan welcome card dan statistics
     */
    private void createContentArea() {
        contentArea = new JPanel();
        contentArea.setLayout(new BorderLayout());
        contentArea.setBackground(ModernTheme.LATAR_UTAMA);
        contentArea.setBorder(BorderFactory.createEmptyBorder(ModernTheme.SPACING_L, ModernTheme.SPACING_L, ModernTheme.SPACING_L, ModernTheme.SPACING_L));
        
        // Main content panel with vertical layout
        JPanel mainContent = new JPanel();
        mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
        mainContent.setBackground(ModernTheme.LATAR_UTAMA);
        
        // Welcome card
        JPanel welcomeCard = createWelcomeCard();
        mainContent.add(welcomeCard);
        mainContent.add(Box.createVerticalStrut(ModernTheme.SPACING_L));
        
        // Statistics cards
        JPanel statsPanel = createStatisticsPanel();
        mainContent.add(statsPanel);
        mainContent.add(Box.createVerticalStrut(ModernTheme.SPACING_L));
        
        // Activity feed
        JPanel activityCard = createActivityCard();
        mainContent.add(activityCard);
        
        contentArea.add(mainContent, BorderLayout.NORTH);
    }
    
    /**
     * Membuat welcome card
     */
    private JPanel createWelcomeCard() {
        JPanel card = ModernTheme.createStyledPanel();
        ModernTheme.applyCardStyle(card);
        card.setLayout(new BorderLayout());
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
        
        // Left section - Welcome text
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setOpaque(false);
        
        JLabel lblWelcome = ModernTheme.createStyledLabel("Halo, Selamat Datang!", "h1");
        JLabel lblSubtitle = ModernTheme.createStyledLabel("Sistem Inventaris Aset SMA Negeri 62 Jakarta", "body");
        JLabel lblDescription = ModernTheme.createStyledLabel("Aplikasi Berbasis Desktop", "caption");
        
        leftPanel.add(lblWelcome);
        leftPanel.add(Box.createVerticalStrut(ModernTheme.SPACING_S));
        leftPanel.add(lblSubtitle);
        leftPanel.add(Box.createVerticalStrut(ModernTheme.SPACING_XS));
        leftPanel.add(lblDescription);
        
        // Right section - Date
        lblTanggal = ModernTheme.createStyledLabel("", "body");
        lblTanggal.setForeground(ModernTheme.TEKS_SEKUNDER);
        
        card.add(leftPanel, BorderLayout.WEST);
        card.add(lblTanggal, BorderLayout.EAST);
        
        return card;
    }
    
    /**
     * Membuat panel statistics cards
     */
    private JPanel createStatisticsPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 3, ModernTheme.SPACING_M, 0));
        panel.setOpaque(false);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
        
        // Total Aset card
        JPanel asetCard = createStatCard("📦", "Total Aset", "125", ModernTheme.BIRU_UTAMA);
        panel.add(asetCard);
        
        // Total Member card
        JPanel memberCard = createStatCard("👥", "Total Member", "45", ModernTheme.HIJAU_SEKUNDER);
        panel.add(memberCard);
        
        // Peminjaman Aktif card
        JPanel peminjamanCard = createStatCard("🔄", "Peminjaman Aktif", "23", ModernTheme.PERINGATAN);
        panel.add(peminjamanCard);
        
        return panel;
    }
    
    /**
     * Membuat single statistics card
     */
    private JPanel createStatCard(String icon, String label, String value, Color accentColor) {
        JPanel card = ModernTheme.createStyledPanel();
        ModernTheme.applyCardStyle(card);
        card.setLayout(new BorderLayout());
        
        // Icon
        JLabel lblIcon = new JLabel(icon);
        lblIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 32));
        lblIcon.setForeground(accentColor);
        
        // Value and label
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);
        
        JLabel lblValue = new JLabel(value);
        lblValue.setFont(new Font("Segoe UI", Font.BOLD, 36));
        lblValue.setForeground(ModernTheme.TEKS_UTAMA);
        
        JLabel lblLabel = ModernTheme.createStyledLabel(label, "body");
        lblLabel.setForeground(ModernTheme.TEKS_SEKUNDER);
        
        textPanel.add(lblValue);
        textPanel.add(lblLabel);
        
        card.add(lblIcon, BorderLayout.WEST);
        card.add(textPanel, BorderLayout.CENTER);
        
        return card;
    }
    
    /**
     * Membuat activity feed card
     */
    private JPanel createActivityCard() {
        JPanel card = ModernTheme.createStyledPanel();
        ModernTheme.applyCardStyle(card);
        card.setLayout(new BorderLayout());
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));
        
        JLabel lblTitle = ModernTheme.createStyledLabel("📋 Aktivitas Terbaru", "h3");
        
        JPanel activityList = new JPanel();
        activityList.setLayout(new BoxLayout(activityList, BoxLayout.Y_AXIS));
        activityList.setOpaque(false);
        
        activityList.add(createActivityItem("• Peminjaman Laptop - 2 jam lalu"));
        activityList.add(Box.createVerticalStrut(ModernTheme.SPACING_S));
        activityList.add(createActivityItem("• Mutasi Proyektor - 5 jam lalu"));
        activityList.add(Box.createVerticalStrut(ModernTheme.SPACING_S));
        activityList.add(createActivityItem("• Tambah Aset Baru - 1 hari lalu"));
        
        card.add(lblTitle, BorderLayout.NORTH);
        card.add(Box.createVerticalStrut(ModernTheme.SPACING_M), BorderLayout.CENTER);
        card.add(activityList, BorderLayout.SOUTH);
        
        return card;
    }
    
    /**
     * Membuat single activity item
     */
    private JLabel createActivityItem(String text) {
        JLabel label = ModernTheme.createStyledLabel(text, "body");
        label.setForeground(ModernTheme.TEKS_SEKUNDER);
        return label;
    }
    
    /**
     * Menampilkan tanggal dengan format Indonesia dan auto-update setiap menit
     */
    private void tampilkanTanggal() {
        Timer timer = new Timer(60000, e -> updateTanggal());
        timer.start();
        updateTanggal();
    }
    
    /**
     * Update label tanggal
     */
    private void updateTanggal() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        String tgl = sdf.format(new Date());
        lblTanggal.setText(tgl);
    }
    
    // ===== EVENT HANDLERS (PRESERVED FROM ORIGINAL) =====
    
    private void memberActionPerformed(java.awt.event.ActionEvent evt) {
        new member().setVisible(true);
        this.dispose();
    }
    
    private void asetActionPerformed(java.awt.event.ActionEvent evt) {
        new aset().setVisible(true);
        this.dispose();
    }
    
    private void kategoriActionPerformed(java.awt.event.ActionEvent evt) {
        new kategori().setVisible(true);
        this.dispose();
    }
    
    private void lokasiActionPerformed(java.awt.event.ActionEvent evt) {
        new lokasi().setVisible(true);
        this.dispose();
    }
    
    private void peminjamanActionPerformed(java.awt.event.ActionEvent evt) {
        new peminjaman().setVisible(true);
        this.dispose();
    }
    
    private void mutasiActionPerformed(java.awt.event.ActionEvent evt) {
        new mutasi().setVisible(true);
        this.dispose();
    }
    
    /**
     * Main method untuk testing
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new branda().setVisible(true);
        });
    }
}
