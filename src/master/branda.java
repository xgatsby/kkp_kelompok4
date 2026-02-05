package master;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import ui.ModernTheme;
import ui.IconManager;
import javax.swing.Icon;
import transaksi.mutasi;
import transaksi.peminjaman;

/**
 * Dashboard Utama - Sistem Inventaris Aset SMA Negeri 62 Jakarta
 * 
 * Dashboard modern dengan sidebar navigation, top bar, dan content area.
 * Menggunakan ModernTheme untuk konsistensi visual.
 * Mendukung Light Mode dan Dark Mode.
 * 
 * @author Sistem Inventaris Aset
 * @version 3.0 (Dark Mode Support)
 */
public class branda extends JFrame {
    
    // Components
    private JPanel topBar;
    private JPanel sidebar;
    private JPanel contentArea;
    private JLabel lblTanggal;
    private JButton btnDarkMode;
    
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
        
        // Register theme change listener untuk refresh UI
        ModernTheme.addThemeChangeListener(() -> {
            SwingUtilities.invokeLater(() -> refreshTheme());
        });
    }
    
    /**
     * Refresh semua komponen UI saat theme berubah
     */
    private void refreshTheme() {
        // Rebuild UI dengan warna baru
        getContentPane().removeAll();
        createTopBar();
        createSidebar();
        createContentArea();
        add(topBar, BorderLayout.NORTH);
        add(sidebar, BorderLayout.WEST);
        add(contentArea, BorderLayout.CENTER);
        
        // Update window
        SwingUtilities.updateComponentTreeUI(this);
        revalidate();
        repaint();
        
        // Update tanggal
        updateTanggal();
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
     * Membuat top bar modern dengan shadow, rounded search, avatar dropdown, dan dark mode toggle
     * Redesign 2025: Mendukung Light/Dark theme
     */
    private void createTopBar() {
        // Modern top bar dengan shadow effect
        topBar = ModernTheme.createModernTopBar(ModernTheme.TOPBAR_HEIGHT);
        topBar.setLayout(new BorderLayout());
        topBar.setBackground(ModernTheme.getBgTopBar());
        topBar.setPreferredSize(new Dimension(getWidth(), ModernTheme.TOPBAR_HEIGHT));
        topBar.setBorder(BorderFactory.createEmptyBorder(0, ModernTheme.SPACING_L, 0, ModernTheme.SPACING_L));
        
        // Left section - Title dengan warna dinamis
        JLabel lblTitle = new JLabel("SISTEM INVENTARIS ASET");
        lblTitle.setFont(ModernTheme.FONT_H3);
        lblTitle.setForeground(ModernTheme.getTextPrimary());
        
        // Center section - Rounded search box dengan ikon
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        searchPanel.setOpaque(false);
        
        // Search container dengan icon
        JPanel searchContainer = new JPanel(new BorderLayout());
        searchContainer.setOpaque(false);
        
        JTextField txtSearch = ModernTheme.createRoundedSearchField("🔍 Cari aset, member, transaksi...");
        searchContainer.add(txtSearch, BorderLayout.CENTER);
        searchPanel.add(searchContainer);
        
        // Right section - Dark mode toggle, Avatar, dan dropdown
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, ModernTheme.SPACING_S, 0));
        rightPanel.setOpaque(false);
        
        // Dark Mode Toggle Button
        btnDarkMode = new JButton(ModernTheme.isDarkMode() ? "☀️" : "🌙");
        btnDarkMode.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        btnDarkMode.setPreferredSize(new Dimension(40, 40));
        btnDarkMode.setFocusPainted(false);
        btnDarkMode.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDarkMode.setContentAreaFilled(false);
        btnDarkMode.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        btnDarkMode.setToolTipText(ModernTheme.isDarkMode() ? "Switch to Light Mode" : "Switch to Dark Mode");
        btnDarkMode.addActionListener(e -> {
            ModernTheme.toggleDarkMode();
            btnDarkMode.setText(ModernTheme.isDarkMode() ? "☀️" : "🌙");
            btnDarkMode.setToolTipText(ModernTheme.isDarkMode() ? "Switch to Light Mode" : "Switch to Dark Mode");
        });
        
        // Avatar dengan background bulat
        JPanel avatarPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(ModernTheme.getAccentBlueBg());
                g2d.fillOval(0, 0, 40, 40);
                g2d.dispose();
            }
            
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(40, 40);
            }
        };
        avatarPanel.setLayout(new GridBagLayout());
        avatarPanel.setOpaque(false);
        JLabel avatarIcon = new JLabel("👤");
        avatarIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
        avatarPanel.add(avatarIcon);
        
        // User name label
        JLabel lblUser = new JLabel("Admin");
        lblUser.setFont(ModernTheme.FONT_BODY);
        lblUser.setForeground(ModernTheme.getTextPrimary());
        
        // Dropdown button
        btnLogout = new JButton("▼");
        btnLogout.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        btnLogout.setForeground(ModernTheme.getTextSecondary());
        btnLogout.setBackground(ModernTheme.getBgTopBar());
        btnLogout.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnLogout.setFocusPainted(false);
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogout.setContentAreaFilled(false);
        
        // Popup menu untuk dropdown
        JPopupMenu userMenu = new JPopupMenu();
        userMenu.setBackground(ModernTheme.getBgCard());
        userMenu.setBorder(BorderFactory.createLineBorder(ModernTheme.getBorderColor(), 1));
        
        JMenuItem menuProfile = new JMenuItem("👤 Profile");
        menuProfile.setFont(ModernTheme.FONT_BODY);
        menuProfile.setBackground(ModernTheme.getBgCard());
        menuProfile.setForeground(ModernTheme.getTextPrimary());
        
        JMenuItem menuSettings = new JMenuItem("⚙️ Settings");
        menuSettings.setFont(ModernTheme.FONT_BODY);
        menuSettings.setBackground(ModernTheme.getBgCard());
        menuSettings.setForeground(ModernTheme.getTextPrimary());
        
        JMenuItem menuLogout = new JMenuItem("🚪 Keluar");
        menuLogout.setFont(ModernTheme.FONT_BODY);
        menuLogout.setBackground(ModernTheme.getBgCard());
        menuLogout.setForeground(ModernTheme.getTextPrimary());
        menuLogout.addActionListener(e -> {
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
        
        userMenu.add(menuProfile);
        userMenu.add(menuSettings);
        userMenu.addSeparator();
        userMenu.add(menuLogout);
        
        btnLogout.addActionListener(e -> {
            userMenu.show(btnLogout, 0, btnLogout.getHeight());
        });
        
        rightPanel.add(btnDarkMode);
        rightPanel.add(Box.createHorizontalStrut(8));
        rightPanel.add(avatarPanel);
        rightPanel.add(Box.createHorizontalStrut(8));
        rightPanel.add(lblUser);
        rightPanel.add(btnLogout);
        
        topBar.add(lblTitle, BorderLayout.WEST);
        topBar.add(searchPanel, BorderLayout.CENTER);
        topBar.add(rightPanel, BorderLayout.EAST);
    }
    
    /**
     * Membuat sidebar dengan menu navigasi (Dark Mode Support)
     * Modern dividers, improved hover effect, dynamic colors
     */
    private void createSidebar() {
        sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(ModernTheme.getBgSidebar());
        sidebar.setPreferredSize(new Dimension(ModernTheme.SIDEBAR_WIDTH, getHeight()));
        sidebar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, ModernTheme.getBorderColor()));
        
        // Add spacing at top
        sidebar.add(Box.createVerticalStrut(ModernTheme.SPACING_L));
        
        // Beranda menu
        btnBeranda = createMenuButton("Beranda", IconManager.getMenuIcon("home", true), true);
        btnBeranda.addActionListener(e -> setActiveMenu(btnBeranda));
        sidebar.add(btnBeranda);
        
        // Divider tipis
        sidebar.add(Box.createVerticalStrut(ModernTheme.SPACING_M));
        sidebar.add(createDivider());
        
        // DATA MASTER section header
        sidebar.add(Box.createVerticalStrut(ModernTheme.SPACING_M));
        JLabel lblMaster = new JLabel("DATA MASTER");
        lblMaster.setFont(new Font("Segoe UI", Font.BOLD, 11));
        lblMaster.setForeground(ModernTheme.getTextMuted());
        lblMaster.setBorder(BorderFactory.createEmptyBorder(0, ModernTheme.SPACING_M, ModernTheme.SPACING_S, 0));
        lblMaster.setAlignmentX(Component.LEFT_ALIGNMENT);
        sidebar.add(lblMaster);
        
        btnMember = createMenuButton("Data Member", IconManager.getMenuIcon("people", false), false);
        btnMember.addActionListener(e -> memberActionPerformed(null));
        sidebar.add(btnMember);
        
        btnAset = createMenuButton("Data Aset", IconManager.getMenuIcon("inventory", false), false);
        btnAset.addActionListener(e -> asetActionPerformed(null));
        sidebar.add(btnAset);
        
        btnKategori = createMenuButton("Data Kategori", IconManager.getMenuIcon("category", false), false);
        btnKategori.addActionListener(e -> kategoriActionPerformed(null));
        sidebar.add(btnKategori);
        
        btnLokasi = createMenuButton("Data Lokasi", IconManager.getMenuIcon("location", false), false);
        btnLokasi.addActionListener(e -> lokasiActionPerformed(null));
        sidebar.add(btnLokasi);
        
        // Divider tipis
        sidebar.add(Box.createVerticalStrut(ModernTheme.SPACING_M));
        sidebar.add(createDivider());
        
        // TRANSAKSI section header
        sidebar.add(Box.createVerticalStrut(ModernTheme.SPACING_M));
        JLabel lblTransaksi = new JLabel("TRANSAKSI");
        lblTransaksi.setFont(new Font("Segoe UI", Font.BOLD, 11));
        lblTransaksi.setForeground(ModernTheme.getTextMuted());
        lblTransaksi.setBorder(BorderFactory.createEmptyBorder(0, ModernTheme.SPACING_M, ModernTheme.SPACING_S, 0));
        lblTransaksi.setAlignmentX(Component.LEFT_ALIGNMENT);
        sidebar.add(lblTransaksi);
        
        btnPeminjaman = createMenuButton("Peminjaman Aset", IconManager.getMenuIcon("swap", false), false);
        btnPeminjaman.addActionListener(e -> peminjamanActionPerformed(null));
        sidebar.add(btnPeminjaman);
        
        btnMutasi = createMenuButton("Mutasi Aset", IconManager.getMenuIcon("transfer", false), false);
        btnMutasi.addActionListener(e -> mutasiActionPerformed(null));
        sidebar.add(btnMutasi);
        
        // Push remaining space to bottom
        sidebar.add(Box.createVerticalGlue());
    }
    
    /**
     * Membuat divider horizontal untuk sidebar (Dark Mode Support)
     */
    private JPanel createDivider() {
        JPanel divider = new JPanel();
        divider.setBackground(ModernTheme.isDarkMode() ? new Color(255, 255, 255, 15) : new Color(0, 0, 0, 8));
        divider.setMaximumSize(new Dimension(ModernTheme.SIDEBAR_WIDTH - 32, 1));
        divider.setPreferredSize(new Dimension(ModernTheme.SIDEBAR_WIDTH - 32, 1));
        divider.setAlignmentX(Component.CENTER_ALIGNMENT);
        return divider;
    }
    
    /**
     * Membuat button menu untuk sidebar (Dark Mode Support)
     * Menggunakan SVG icons dari IconManager
     */
    private JButton createMenuButton(String text, Icon icon, boolean isActive) {
        JButton button = new JButton(text, icon);
        button.setFont(ModernTheme.FONT_BODY);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setIconTextGap(12);
        button.setMaximumSize(new Dimension(ModernTheme.SIDEBAR_WIDTH, 44));
        button.setPreferredSize(new Dimension(ModernTheme.SIDEBAR_WIDTH, 44));
        button.setBorder(BorderFactory.createEmptyBorder(10, ModernTheme.SPACING_M, 10, ModernTheme.SPACING_M));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        
        Color activeBg = ModernTheme.getAccentBlueBg();
        Color normalBg = ModernTheme.getBgSidebar();
        Color hoverBg = ModernTheme.getBgHover();
        
        if (isActive) {
            button.setBackground(activeBg);
            button.setForeground(ModernTheme.getAccentBlue());
            button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 3, 0, 0, ModernTheme.getAccentBlue()),
                BorderFactory.createEmptyBorder(10, 13, 10, ModernTheme.SPACING_M)
            ));
        } else {
            button.setBackground(normalBg);
            button.setForeground(ModernTheme.getTextSecondary());
        }
        
        // Improved hover effect dengan dynamic colors
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!isMenuActive(button)) {
                    button.setBackground(hoverBg);
                    button.setForeground(ModernTheme.getTextPrimary());
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                if (!isMenuActive(button)) {
                    button.setBackground(normalBg);
                    button.setForeground(ModernTheme.getTextSecondary());
                }
            }
        });
        
        return button;
    }
    
    /**
     * Set menu sebagai active dan reset yang lain (Dark Mode Support)
     */
    private void setActiveMenu(JButton activeButton) {
        JButton[] allButtons = {btnBeranda, btnMember, btnAset, btnKategori, btnLokasi, btnPeminjaman, btnMutasi};
        
        for (JButton btn : allButtons) {
            if (btn == activeButton) {
                btn.setBackground(ModernTheme.getAccentBlueBg());
                btn.setForeground(ModernTheme.getAccentBlue());
                btn.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(0, 3, 0, 0, ModernTheme.getAccentBlue()),
                    BorderFactory.createEmptyBorder(10, 13, 10, ModernTheme.SPACING_M)
                ));
            } else {
                btn.setBackground(ModernTheme.getBgSidebar());
                btn.setForeground(ModernTheme.getTextSecondary());
                btn.setBorder(BorderFactory.createEmptyBorder(10, ModernTheme.SPACING_M, 10, ModernTheme.SPACING_M));
            }
        }
    }
    
    /**
     * Check apakah menu sedang active
     */
    private boolean isMenuActive(JButton button) {
        return button.getBackground().equals(ModernTheme.getAccentBlueBg());
    }
    
    /**
     * Membuat content area dengan welcome card dan statistics (Dark Mode Support)
     */
    private void createContentArea() {
        contentArea = new JPanel();
        contentArea.setLayout(new BorderLayout());
        contentArea.setBackground(ModernTheme.getBgPrimary());
        contentArea.setBorder(BorderFactory.createEmptyBorder(ModernTheme.SPACING_L, ModernTheme.SPACING_L, ModernTheme.SPACING_L, ModernTheme.SPACING_L));
        
        // Main content panel with vertical layout
        JPanel mainContent = new JPanel();
        mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
        mainContent.setBackground(ModernTheme.getBgPrimary());
        
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
     * Membuat welcome card (Dark Mode Support)
     * Typography hierarchy yang lebih baik dengan dynamic colors
     */
    private JPanel createWelcomeCard() {
        JPanel card = ModernTheme.createElevatedCardDynamic(16);
        card.setLayout(new BorderLayout());
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 140));
        card.setOpaque(false);
        
        // Left section - Welcome text dengan hierarchy
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setOpaque(false);
        
        // "Halo, Selamat Datang!" - besar dan bold
        JLabel lblWelcome = new JLabel("Halo, Selamat Datang!");
        lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblWelcome.setForeground(ModernTheme.getTextPrimary());
        lblWelcome.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Subtitle - medium
        JLabel lblSubtitle = new JLabel("Sistem Inventaris Aset SMA Negeri 62 Jakarta");
        lblSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblSubtitle.setForeground(ModernTheme.getTextSecondary());
        lblSubtitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Description - kecil
        JLabel lblDescription = new JLabel("Aplikasi Berbasis Desktop");
        lblDescription.setFont(ModernTheme.FONT_CAPTION);
        lblDescription.setForeground(ModernTheme.getTextMuted());
        lblDescription.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        leftPanel.add(lblWelcome);
        leftPanel.add(Box.createVerticalStrut(ModernTheme.SPACING_S));
        leftPanel.add(lblSubtitle);
        leftPanel.add(Box.createVerticalStrut(ModernTheme.SPACING_XS));
        leftPanel.add(lblDescription);
        
        // Right section - Date dengan ikon kalender
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setOpaque(false);
        
        JLabel lblDateIcon = new JLabel("📅");
        lblDateIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));
        lblDateIcon.setAlignmentX(Component.RIGHT_ALIGNMENT);
        
        lblTanggal = new JLabel();
        lblTanggal.setFont(ModernTheme.FONT_BODY);
        lblTanggal.setForeground(ModernTheme.getTextSecondary());
        lblTanggal.setAlignmentX(Component.RIGHT_ALIGNMENT);
        
        rightPanel.add(lblDateIcon);
        rightPanel.add(Box.createVerticalStrut(4));
        rightPanel.add(lblTanggal);
        
        card.add(leftPanel, BorderLayout.WEST);
        card.add(rightPanel, BorderLayout.EAST);
        
        return card;
    }
    
    /**
     * Membuat panel statistics cards (Dark Mode Support)
     * Elevated cards dengan dynamic colors
     */
    private JPanel createStatisticsPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 3, ModernTheme.SPACING_L, 0));
        panel.setOpaque(false);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 140));
        
        // Total Aset card - Biru
        JPanel asetCard = ModernTheme.createStatisticsCardDynamic(
            "📦", "Total Aset", "125", 
            ModernTheme.getAccentBlue(), ModernTheme.getAccentBlueBg()
        );
        panel.add(asetCard);
        
        // Total Member card - Hijau
        JPanel memberCard = ModernTheme.createStatisticsCardDynamic(
            "👥", "Total Member", "45", 
            ModernTheme.getAccentGreen(), ModernTheme.getAccentGreenBg()
        );
        panel.add(memberCard);
        
        // Peminjaman Aktif card - Oranye
        JPanel peminjamanCard = ModernTheme.createStatisticsCardDynamic(
            "🔄", "Peminjaman Aktif", "23", 
            ModernTheme.getAccentOrange(), ModernTheme.getAccentOrangeBg()
        );
        panel.add(peminjamanCard);
        
        return panel;
    }
    
    /**
     * Membuat activity feed card (Dark Mode Support)
     * List card dengan dynamic colors
     */
    private JPanel createActivityCard() {
        JPanel card = ModernTheme.createElevatedCardDynamic(16);
        card.setLayout(new BorderLayout());
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 280));
        card.setOpaque(false);
        
        // Header dengan title dan "Lihat Semua" button
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, ModernTheme.SPACING_M, 0));
        
        JLabel lblTitle = new JLabel("📋 Aktivitas Terbaru");
        lblTitle.setFont(ModernTheme.FONT_H3);
        lblTitle.setForeground(ModernTheme.getTextPrimary());
        
        JButton btnViewAll = new JButton("Lihat Semua →");
        btnViewAll.setFont(ModernTheme.FONT_CAPTION);
        btnViewAll.setForeground(ModernTheme.getAccentBlue());
        btnViewAll.setBackground(ModernTheme.getBgCard());
        btnViewAll.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
        btnViewAll.setFocusPainted(false);
        btnViewAll.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnViewAll.setContentAreaFilled(false);
        btnViewAll.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnViewAll.setForeground(ModernTheme.MODERN_BLUE_HOVER);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnViewAll.setForeground(ModernTheme.getAccentBlue());
            }
        });
        
        headerPanel.add(lblTitle, BorderLayout.WEST);
        headerPanel.add(btnViewAll, BorderLayout.EAST);
        
        // Activity list dengan modern items
        JPanel activityList = new JPanel();
        activityList.setLayout(new BoxLayout(activityList, BoxLayout.Y_AXIS));
        activityList.setBackground(ModernTheme.getBgCard());
        
        // Activity items dengan ikon, teks, dan timestamp
        activityList.add(ModernTheme.createActivityItemDynamic("💻", "Peminjaman Laptop Dell XPS 15", "2 jam lalu"));
        activityList.add(ModernTheme.createActivityItemDynamic("📽️", "Mutasi Proyektor ke Ruang Rapat", "5 jam lalu"));
        activityList.add(ModernTheme.createActivityItemDynamic("➕", "Tambah Aset Baru - Printer HP", "1 hari lalu"));
        activityList.add(ModernTheme.createActivityItemDynamic("📦", "Pengembalian Scanner Epson", "2 hari lalu"));
        
        card.add(headerPanel, BorderLayout.NORTH);
        card.add(activityList, BorderLayout.CENTER);
        
        return card;
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
