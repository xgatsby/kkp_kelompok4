package ui;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ModernTheme - Tema Modern untuk Sistem Inventaris Aset
 * 
 * Class ini menyediakan konstanta warna, typography, spacing, dan factory
 * methods
 * untuk membuat komponen UI yang konsisten dengan desain modern 2025.
 * 
 * Mendukung Light Mode dan Dark Mode.
 * 
 * @author Sistem Inventaris Aset SMA Negeri 62 Jakarta
 * @version 3.0 (Dark Mode Support)
 */
public class ModernTheme {

    // ===== DARK MODE STATE =====
    private static boolean isDarkMode = false;
    private static List<Runnable> themeChangeListeners = new ArrayList<>();

    /**
     * Check apakah dark mode aktif
     */
    public static boolean isDarkMode() {
        return isDarkMode;
    }

    /**
     * Toggle dark mode on/off
     */
    public static void toggleDarkMode() {
        setDarkMode(!isDarkMode);
    }

    /**
     * Set dark mode state
     */
    public static void setDarkMode(boolean dark) {
        isDarkMode = dark;
        try {
            if (isDarkMode) {
                FlatDarkLaf.setup();
            } else {
                FlatLightLaf.setup();
            }
            // Notify all listeners
            for (Runnable listener : themeChangeListeners) {
                listener.run();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Add listener untuk theme change
     */
    public static void addThemeChangeListener(Runnable listener) {
        themeChangeListeners.add(listener);
    }

    /**
     * Remove theme change listener
     */
    public static void removeThemeChangeListener(Runnable listener) {
        themeChangeListeners.remove(listener);
    }

    // ===== DARK MODE COLORS =====
    
    // Dark mode backgrounds
    public static final Color DARK_BG_PRIMARY = new Color(18, 18, 18); // #121212
    public static final Color DARK_BG_SECONDARY = new Color(30, 30, 30); // #1E1E1E
    public static final Color DARK_BG_CARD = new Color(37, 37, 37); // #252525
    public static final Color DARK_BG_ELEVATED = new Color(45, 45, 45); // #2D2D2D
    public static final Color DARK_BG_HOVER = new Color(55, 55, 55); // #373737
    
    // Dark mode text
    public static final Color DARK_TEXT_PRIMARY = new Color(255, 255, 255); // #FFFFFF
    public static final Color DARK_TEXT_SECONDARY = new Color(179, 179, 179); // #B3B3B3
    public static final Color DARK_TEXT_MUTED = new Color(128, 128, 128); // #808080
    
    // Dark mode borders
    public static final Color DARK_BORDER = new Color(66, 66, 66); // #424242
    public static final Color DARK_BORDER_LIGHT = new Color(55, 55, 55); // #373737
    
    // Dark mode accent (lebih terang untuk kontras)
    public static final Color DARK_ACCENT_BLUE = new Color(66, 165, 245); // #42A5F5
    public static final Color DARK_ACCENT_GREEN = new Color(102, 187, 106); // #66BB6A
    public static final Color DARK_ACCENT_ORANGE = new Color(255, 167, 38); // #FFA726
    public static final Color DARK_ACCENT_BLUE_BG = new Color(33, 150, 243, 30); // Semi-transparent
    public static final Color DARK_ACCENT_GREEN_BG = new Color(76, 175, 80, 30);
    public static final Color DARK_ACCENT_ORANGE_BG = new Color(255, 152, 0, 30);

    // ===== DYNAMIC COLOR GETTERS =====
    
    /** Background utama aplikasi */
    public static Color getBgPrimary() {
        return isDarkMode ? DARK_BG_PRIMARY : LATAR_UTAMA;
    }
    
    /** Background card/panel */
    public static Color getBgCard() {
        return isDarkMode ? DARK_BG_CARD : LATAR_KARTU;
    }
    
    /** Background sidebar */
    public static Color getBgSidebar() {
        return isDarkMode ? DARK_BG_SECONDARY : LATAR_KARTU;
    }
    
    /** Background top bar */
    public static Color getBgTopBar() {
        return isDarkMode ? DARK_BG_SECONDARY : TOPBAR_BG;
    }
    
    /** Background hover */
    public static Color getBgHover() {
        return isDarkMode ? DARK_BG_HOVER : new Color(245, 247, 250);
    }
    
    /** Teks utama */
    public static Color getTextPrimary() {
        return isDarkMode ? DARK_TEXT_PRIMARY : TEKS_UTAMA;
    }
    
    /** Teks sekunder */
    public static Color getTextSecondary() {
        return isDarkMode ? DARK_TEXT_SECONDARY : TEKS_SEKUNDER;
    }
    
    /** Teks redup */
    public static Color getTextMuted() {
        return isDarkMode ? DARK_TEXT_MUTED : TEKS_REDUP;
    }
    
    /** Border color */
    public static Color getBorderColor() {
        return isDarkMode ? DARK_BORDER : BORDER;
    }
    
    /** Accent blue */
    public static Color getAccentBlue() {
        return isDarkMode ? DARK_ACCENT_BLUE : ACCENT_BLUE;
    }
    
    /** Accent green */
    public static Color getAccentGreen() {
        return isDarkMode ? DARK_ACCENT_GREEN : ACCENT_GREEN;
    }
    
    /** Accent orange */
    public static Color getAccentOrange() {
        return isDarkMode ? DARK_ACCENT_ORANGE : ACCENT_ORANGE;
    }
    
    /** Accent blue background */
    public static Color getAccentBlueBg() {
        return isDarkMode ? DARK_ACCENT_BLUE_BG : ACCENT_BLUE_LIGHT;
    }
    
    /** Accent green background */
    public static Color getAccentGreenBg() {
        return isDarkMode ? DARK_ACCENT_GREEN_BG : ACCENT_GREEN_LIGHT;
    }
    
    /** Accent orange background */
    public static Color getAccentOrangeBg() {
        return isDarkMode ? DARK_ACCENT_ORANGE_BG : ACCENT_ORANGE_LIGHT;
    }

    // ===== COLOR CONSTANTS =====

    /**
     * Warna Utama (Primary Colors)
     */
    public static final Color BIRU_UTAMA = new Color(25, 118, 210); // #1976D2
    public static final Color HIJAU_SEKUNDER = new Color(56, 142, 60); // #388E3C
    public static final Color TEAL_AKSEN = new Color(0, 137, 123); // #00897B

    /**
     * Warna Modern 2025 (Redesign Colors)
     */
    public static final Color DARK_NAVY = new Color(15, 23, 42); // #0F172A
    public static final Color DARK_GRAY = new Color(17, 24, 39); // #111827
    public static final Color MODERN_BLUE = new Color(37, 99, 235); // #2563EB
    public static final Color MODERN_BLUE_HOVER = new Color(29, 78, 216); // #1D4ED8
    public static final Color TEXT_DARK = new Color(2, 6, 23); // #020617
    public static final Color TEXT_LABEL = new Color(71, 85, 105); // #475569

    /**
     * Warna Background Gradient Modern (Redesign 2025)
     * Slate gradient: profesional dan modern untuk aplikasi institusi
     */
    public static final Color SLATE_DARK = new Color(30, 41, 59); // #1E293B - slate-800
    public static final Color SLATE_MEDIUM = new Color(51, 65, 85); // #334155 - slate-700
    public static final Color SLATE_LIGHT = new Color(71, 85, 105); // #475569 - slate-600

    /**
     * Warna Error Notification (Redesign)
     */
    public static final Color ERROR_BG = new Color(254, 226, 226); // #FEE2E2
    public static final Color ERROR_TEXT = new Color(153, 27, 27); // #991B1B
    public static final Color ERROR_BORDER = new Color(252, 165, 165); // #FCA5A5

    /**
     * Warna Success Notification (Redesign)
     */
    public static final Color SUCCESS_BG = new Color(220, 252, 231); // #DCFCE7
    public static final Color SUCCESS_TEXT = new Color(21, 128, 61); // #15803D
    public static final Color SUCCESS_BORDER = new Color(134, 239, 172); // #86EFAC

    /**
     * Warna Fungsional (Functional Colors)
     */
    public static final Color PERINGATAN = new Color(245, 124, 0); // #F57C00
    public static final Color BAHAYA = new Color(211, 47, 47); // #D32F2F
    public static final Color SUKSES = new Color(56, 142, 60); // #388E3C
    public static final Color INFO = new Color(2, 136, 209); // #0288D1

    /**
     * Warna Accent untuk Statistics Cards (Redesign 2025)
     * Sesuai spesifikasi Material Design modern
     */
    public static final Color ACCENT_GREEN = new Color(76, 175, 80); // #4CAF50 - Total Member
    public static final Color ACCENT_ORANGE = new Color(255, 152, 0); // #FF9800 - Peminjaman Aktif
    public static final Color ACCENT_BLUE = new Color(33, 150, 243); // #2196F3 - Total Aset
    public static final Color ACCENT_GREEN_LIGHT = new Color(232, 245, 233); // #E8F5E9
    public static final Color ACCENT_ORANGE_LIGHT = new Color(255, 243, 224); // #FFF3E0
    public static final Color ACCENT_BLUE_LIGHT = new Color(227, 242, 253); // #E3F2FD

    /**
     * Warna untuk Top Bar Modern (Light Theme)
     */
    public static final Color TOPBAR_BG = new Color(255, 255, 255); // #FFFFFF
    public static final Color TOPBAR_SHADOW = new Color(0, 0, 0, 20); // Subtle shadow

    /**
     * Warna Netral (Neutral Colors)
     */
    public static final Color LATAR_UTAMA = new Color(250, 250, 250); // #FAFAFA
    public static final Color LATAR_KARTU = new Color(255, 255, 255); // #FFFFFF
    public static final Color LATAR_SIDEBAR = new Color(245, 245, 245); // #F5F5F5
    public static final Color TEKS_UTAMA = new Color(33, 33, 33); // #212121
    public static final Color TEKS_SEKUNDER = new Color(117, 117, 117); // #757575
    public static final Color TEKS_REDUP = new Color(158, 158, 158); // #9E9E9E
    public static final Color BORDER = new Color(224, 224, 224); // #E0E0E0
    public static final Color BORDER_GELAP = new Color(189, 189, 189); // #BDBDBD

    /**
     * Warna Hover untuk Buttons
     */
    public static final Color BIRU_HOVER = new Color(21, 101, 192); // #1565C0
    public static final Color HIJAU_HOVER = new Color(46, 125, 50); // #2E7D32
    public static final Color MERAH_HOVER = new Color(198, 40, 40); // #C62828
    public static final Color ABU_HOVER = new Color(97, 97, 97); // #616161

    // ===== TYPOGRAPHY CONSTANTS =====

    /**
     * Font Hierarchy
     */
    public static final Font FONT_H1 = new Font("Segoe UI", Font.BOLD, 28);
    public static final Font FONT_H2 = new Font("Segoe UI", Font.BOLD, 22);
    public static final Font FONT_H3 = new Font("Segoe UI", Font.BOLD, 18);
    public static final Font FONT_BODY = new Font("Segoe UI", Font.PLAIN, 14);
    public static final Font FONT_LABEL = new Font("Segoe UI", Font.PLAIN, 13);
    public static final Font FONT_CAPTION = new Font("Segoe UI", Font.PLAIN, 12);
    public static final Font FONT_BUTTON = new Font("Segoe UI", Font.BOLD, 14);

    // ===== SPACING CONSTANTS =====

    /**
     * Grid System (8px Base)
     */
    public static final int SPACING_XS = 4;
    public static final int SPACING_S = 8;
    public static final int SPACING_M = 16;
    public static final int SPACING_L = 24;
    public static final int SPACING_XL = 32;
    public static final int SPACING_XXL = 48;

    // ===== BORDER RADIUS =====

    public static final int RADIUS_CARD = 8;
    public static final int RADIUS_CARD_LARGE = 16; // Redesign 2025 untuk login card
    public static final int RADIUS_DIALOG = 12; // Redesign 2025 untuk dialog
    public static final int RADIUS_BUTTON = 4;

    // ===== COMPONENT DIMENSIONS =====

    public static final int INPUT_HEIGHT = 40;
    public static final int BUTTON_HEIGHT = 36;
    public static final int SIDEBAR_WIDTH = 240;
    public static final int SIDEBAR_COLLAPSED_WIDTH = 64;
    public static final int TOPBAR_HEIGHT = 64;

    /**
     * Inisialisasi dan apply FlatLaf Look and Feel
     * Method ini harus dipanggil di awal aplikasi (main method)
     */
    public static void applyTheme() {
        try {
            // Setup FlatLaf Light theme
            FlatLightLaf.setup();

            // Customize UIManager properties
            UIManager.put("Button.arc", RADIUS_BUTTON);
            UIManager.put("Component.arc", RADIUS_BUTTON);
            UIManager.put("TextComponent.arc", RADIUS_BUTTON);
            UIManager.put("Button.font", FONT_BUTTON);
            UIManager.put("Label.font", FONT_BODY);
            UIManager.put("TextField.font", FONT_BODY);
            UIManager.put("Table.font", FONT_BODY);
            UIManager.put("TableHeader.font", FONT_LABEL);

        } catch (Exception e) {
            System.err.println("Gagal apply FlatLaf theme: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Factory method untuk membuat styled button
     * 
     * @param text Teks button
     * @param type Tipe button: "primary", "success", "danger", "secondary"
     * @return JButton dengan styling yang sesuai
     */
    public static JButton createStyledButton(String text, String type) {
        JButton button = new JButton(text);
        button.setFont(FONT_BUTTON);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(120, BUTTON_HEIGHT));

        // Set warna berdasarkan tipe
        switch (type.toLowerCase()) {
            case "primary":
                button.setBackground(BIRU_UTAMA);
                button.setForeground(Color.WHITE);
                applyButtonHoverEffect(button, BIRU_UTAMA, BIRU_HOVER);
                break;
            case "success":
                button.setBackground(HIJAU_SEKUNDER);
                button.setForeground(Color.WHITE);
                applyButtonHoverEffect(button, HIJAU_SEKUNDER, HIJAU_HOVER);
                break;
            case "danger":
                button.setBackground(BAHAYA);
                button.setForeground(Color.WHITE);
                applyButtonHoverEffect(button, BAHAYA, MERAH_HOVER);
                break;
            case "secondary":
                button.setBackground(TEKS_SEKUNDER);
                button.setForeground(Color.WHITE);
                applyButtonHoverEffect(button, TEKS_SEKUNDER, ABU_HOVER);
                break;
            default:
                button.setBackground(BIRU_UTAMA);
                button.setForeground(Color.WHITE);
                applyButtonHoverEffect(button, BIRU_UTAMA, BIRU_HOVER);
        }

        return button;
    }

    /**
     * Factory method untuk membuat styled text field
     * 
     * @return JTextField dengan styling modern
     */
    public static JTextField createStyledTextField() {
        JTextField textField = new JTextField();
        textField.setFont(FONT_BODY);
        textField.setPreferredSize(new Dimension(200, INPUT_HEIGHT));
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER, 1),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)));

        applyInputFocusEffect(textField);

        return textField;
    }

    /**
     * Factory method untuk membuat styled label
     * 
     * @param text Teks label
     * @param type Tipe label: "h1", "h2", "h3", "body", "label", "caption"
     * @return JLabel dengan styling yang sesuai
     */
    public static JLabel createStyledLabel(String text, String type) {
        JLabel label = new JLabel(text);

        switch (type.toLowerCase()) {
            case "h1":
                label.setFont(FONT_H1);
                label.setForeground(TEKS_UTAMA);
                break;
            case "h2":
                label.setFont(FONT_H2);
                label.setForeground(TEKS_UTAMA);
                break;
            case "h3":
                label.setFont(FONT_H3);
                label.setForeground(TEKS_UTAMA);
                break;
            case "body":
                label.setFont(FONT_BODY);
                label.setForeground(TEKS_UTAMA);
                break;
            case "label":
                label.setFont(FONT_LABEL);
                label.setForeground(TEKS_SEKUNDER);
                break;
            case "caption":
                label.setFont(FONT_CAPTION);
                label.setForeground(TEKS_REDUP);
                break;
            default:
                label.setFont(FONT_BODY);
                label.setForeground(TEKS_UTAMA);
        }

        return label;
    }

    /**
     * Factory method untuk membuat styled panel
     * 
     * @return JPanel dengan background putih
     */
    public static JPanel createStyledPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(LATAR_KARTU);
        return panel;
    }

    /**
     * Factory method untuk membuat styled table
     * 
     * @return JTable dengan styling modern
     */
    public static JTable createStyledTable(DefaultTableModel model) {
        JTable table = new JTable(model);
        table.setFont(FONT_BODY);
        table.setRowHeight(40);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setSelectionBackground(new Color(227, 242, 253)); // #E3F2FD
        table.setSelectionForeground(TEKS_UTAMA);

        // Style header
        JTableHeader header = table.getTableHeader();
        header.setFont(FONT_LABEL);
        header.setBackground(LATAR_SIDEBAR);
        header.setForeground(TEKS_UTAMA);
        header.setPreferredSize(new Dimension(header.getWidth(), 45));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, BORDER));

        // Alternating row colors
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (!isSelected) {
                    if (row % 2 == 0) {
                        c.setBackground(LATAR_KARTU);
                    } else {
                        c.setBackground(LATAR_UTAMA);
                    }
                }

                return c;
            }
        });

        return table;
    }

    /**
     * Apply card style ke panel (shadow dan rounded corners)
     * 
     * @param panel Panel yang akan di-style
     */
    public static void applyCardStyle(JPanel panel) {
        panel.setBackground(LATAR_KARTU);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER, 1, true),
                BorderFactory.createEmptyBorder(SPACING_L, SPACING_L, SPACING_L, SPACING_L)));
    }

    /**
     * Apply hover effect ke button
     * 
     * @param button      Button yang akan diberi hover effect
     * @param normalColor Warna normal
     * @param hoverColor  Warna saat hover
     */
    public static void applyButtonHoverEffect(JButton button, Color normalColor, Color hoverColor) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(normalColor);
            }
        });
    }

    /**
     * Apply focus effect ke text field
     * 
     * @param textField TextField yang akan diberi focus effect
     */
    public static void applyInputFocusEffect(JTextField textField) {
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textField.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(BIRU_UTAMA, 2),
                        BorderFactory.createEmptyBorder(7, 11, 7, 11)));
            }

            @Override
            public void focusLost(FocusEvent e) {
                textField.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(BORDER, 1),
                        BorderFactory.createEmptyBorder(8, 12, 8, 12)));
            }
        });
    }

    /**
     * Buat gradient panel untuk background
     * 
     * @param color1 Warna awal gradient
     * @param color2 Warna akhir gradient
     * @return JPanel dengan gradient background
     */
    public static JPanel createGradientPanel(Color color1, Color color2) {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth();
                int h = getHeight();
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
    }

    /**
     * Buat panel dengan drop shadow effect (Redesign 2025)
     * Shadow: 0 8px 24px rgba(0,0,0,0.08)
     * 
     * @param cornerRadius Radius sudut panel
     * @return JPanel dengan shadow effect
     */
    public static JPanel createDropShadowPanel(int cornerRadius) {
        return new JPanel() {
            private final int shadowSize = 12;
            private final int shadowOffsetY = 4;

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int width = getWidth() - shadowSize * 2;
                int height = getHeight() - shadowSize * 2;

                // Draw shadow layers
                for (int i = 0; i < shadowSize; i++) {
                    int alpha = (int) (20 * (1 - (double) i / shadowSize));
                    g2d.setColor(new Color(0, 0, 0, alpha));
                    g2d.fillRoundRect(
                            shadowSize - i,
                            shadowSize - i + shadowOffsetY,
                            width + i * 2,
                            height + i * 2,
                            cornerRadius + i,
                            cornerRadius + i);
                }

                // Draw main panel background
                g2d.setColor(LATAR_KARTU);
                g2d.fillRoundRect(shadowSize, shadowSize, width, height, cornerRadius, cornerRadius);

                g2d.dispose();
            }

            @Override
            public Insets getInsets() {
                return new Insets(shadowSize + SPACING_XXL, shadowSize + SPACING_XXL,
                        shadowSize + SPACING_XXL, shadowSize + SPACING_XXL);
            }
        };
    }

    /**
     * Warna Success Icon Modern (Redesign 2025)
     */
    public static final Color SUCCESS_ICON = new Color(34, 197, 94); // #22C55E

    /**
     * Buat inline notification panel untuk error/success messages
     * Redesign 2025: Icon lebih besar (32px), spacing sesuai spesifikasi
     * 
     * @param message Pesan yang akan ditampilkan
     * @param type    Tipe notifikasi: "error" atau "success"
     * @return JPanel dengan styling notification
     */
    public static JPanel createInlineNotification(String message, String type) {
        JPanel notifPanel = new JPanel();
        notifPanel.setLayout(new FlowLayout(FlowLayout.LEFT, SPACING_M, 0));
        notifPanel.setPreferredSize(new Dimension(320, 48)); // Sedikit lebih tinggi untuk icon besar
        notifPanel.setMaximumSize(new Dimension(320, 48));

        // Set warna berdasarkan tipe dengan rounded corners (RADIUS_DIALOG = 12px)
        if (type.equalsIgnoreCase("error")) {
            notifPanel.setBackground(ERROR_BG);
            notifPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(ERROR_BORDER, 1, true),
                    BorderFactory.createEmptyBorder(SPACING_S, SPACING_M, SPACING_S, SPACING_M)));
        } else if (type.equalsIgnoreCase("success")) {
            notifPanel.setBackground(SUCCESS_BG);
            notifPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(SUCCESS_BORDER, 1, true),
                    BorderFactory.createEmptyBorder(SPACING_S, SPACING_M, SPACING_S, SPACING_M)));
        }

        // Icon label - ukuran lebih besar (32px sesuai spesifikasi)
        JLabel iconLabel = new JLabel();
        iconLabel.setFont(new Font("Segoe UI", Font.BOLD, 20)); // Icon lebih besar
        iconLabel.setPreferredSize(new Dimension(32, 32));
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        if (type.equalsIgnoreCase("error")) {
            iconLabel.setText("⚠");
            iconLabel.setForeground(ERROR_TEXT);
        } else {
            iconLabel.setText("✓");
            iconLabel.setForeground(SUCCESS_ICON); // #22C55E - green success modern
        }

        // Message label
        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        if (type.equalsIgnoreCase("error")) {
            messageLabel.setForeground(ERROR_TEXT);
        } else {
            messageLabel.setForeground(SUCCESS_TEXT);
        }

        notifPanel.add(iconLabel);
        notifPanel.add(messageLabel);

        return notifPanel;
    }

    /**
     * Buat modern dialog notification (Redesign 2025)
     * Sesuai spesifikasi: dialog width 360-400px, rounded 12px, padding 24px
     * 
     * @param parent  Parent frame
     * @param message Pesan yang akan ditampilkan
     * @param title   Judul dialog
     * @param type    Tipe dialog: "success", "error", "info"
     */
    public static void showModernDialog(JFrame parent, String message, String title, String type) {
        JDialog dialog = new JDialog(parent, title, true);
        dialog.setSize(380, 180); // Dialog width 360-400px sesuai spesifikasi
        dialog.setLocationRelativeTo(parent);
        dialog.setResizable(false);

        // Main panel dengan padding 24px
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(LATAR_KARTU);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(SPACING_L, SPACING_L, SPACING_L, SPACING_L));

        // Content panel (icon + message)
        JPanel contentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, SPACING_M, 0));
        contentPanel.setBackground(LATAR_KARTU);

        // Icon (32-40px sesuai spesifikasi)
        JLabel iconLabel = new JLabel();
        iconLabel.setFont(new Font("Segoe UI", Font.PLAIN, 36));
        iconLabel.setPreferredSize(new Dimension(40, 40));
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);

        if (type.equalsIgnoreCase("success")) {
            iconLabel.setText("✓");
            iconLabel.setForeground(SUCCESS_ICON); // #22C55E
        } else if (type.equalsIgnoreCase("error")) {
            iconLabel.setText("✕");
            iconLabel.setForeground(BAHAYA);
        } else {
            iconLabel.setText("ℹ");
            iconLabel.setForeground(MODERN_BLUE);
        }

        // Message
        JLabel messageLabel = new JLabel("<html>" + message + "</html>");
        messageLabel.setFont(FONT_BODY);
        messageLabel.setForeground(TEKS_UTAMA);

        contentPanel.add(iconLabel);
        contentPanel.add(messageLabel);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(LATAR_KARTU);

        // OK Button (36-40px height, Modern Blue)
        JButton btnOK = new JButton("OK");
        btnOK.setFont(FONT_BUTTON);
        btnOK.setPreferredSize(new Dimension(100, 38));
        btnOK.setBackground(MODERN_BLUE);
        btnOK.setForeground(Color.WHITE);
        btnOK.setFocusPainted(false);
        btnOK.setCursor(new Cursor(Cursor.HAND_CURSOR));
        applyButtonHoverEffect(btnOK, MODERN_BLUE, MODERN_BLUE_HOVER);
        btnOK.addActionListener(e -> dialog.dispose());

        buttonPanel.add(btnOK);

        mainPanel.add(contentPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setContentPane(mainPanel);
        dialog.setVisible(true);
    }

    /**
     * Buat elevated card panel dengan shadow effect (Redesign 2025)
     * Sesuai spesifikasi: rounded corners 12-16px, elevation shadow
     * 
     * @param cornerRadius Radius sudut (12 atau 16)
     * @return JPanel dengan elevated style
     */
    public static JPanel createElevatedCard(int cornerRadius) {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int shadowSize = 8;
                int w = getWidth() - shadowSize * 2;
                int h = getHeight() - shadowSize * 2;

                // Draw shadow layers
                for (int i = 0; i < shadowSize; i++) {
                    int alpha = (int) (15 * (1 - (double) i / shadowSize));
                    g2d.setColor(new Color(0, 0, 0, alpha));
                    g2d.fillRoundRect(
                            shadowSize - i,
                            shadowSize - i + 2,
                            w + i * 2,
                            h + i * 2,
                            cornerRadius + i,
                            cornerRadius + i);
                }

                // Draw main card background
                g2d.setColor(LATAR_KARTU);
                g2d.fillRoundRect(shadowSize, shadowSize, w, h, cornerRadius, cornerRadius);

                // Draw subtle border
                g2d.setColor(new Color(0, 0, 0, 10));
                g2d.drawRoundRect(shadowSize, shadowSize, w - 1, h - 1, cornerRadius, cornerRadius);

                g2d.dispose();
            }

            @Override
            public Insets getInsets() {
                return new Insets(8 + SPACING_L, 8 + SPACING_L, 8 + SPACING_L, 8 + SPACING_L);
            }
        };
    }

    /**
     * Buat statistics card modern dengan ikon besar dan warna accent
     * Sesuai spesifikasi: ikon 48-64px, angka 48-60pt bold
     * 
     * @param icon        Emoji atau karakter ikon
     * @param label       Label statistik
     * @param value       Nilai statistik
     * @param accentColor Warna accent untuk ikon
     * @param bgColor     Warna background light untuk ikon
     * @return JPanel statistics card
     */
    public static JPanel createStatisticsCard(String icon, String label, String value, Color accentColor,
            Color bgColor) {
        JPanel card = createElevatedCard(16);
        card.setLayout(new BorderLayout(SPACING_M, 0));
        card.setOpaque(false);

        // Icon panel dengan background lingkaran
        JPanel iconContainer = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(bgColor);
                g2d.fillRoundRect(0, 0, 56, 56, 16, 16);
                g2d.dispose();
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(56, 56);
            }
        };
        iconContainer.setLayout(new GridBagLayout());
        iconContainer.setOpaque(false);

        JLabel lblIcon = new JLabel(icon);
        lblIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 28));
        lblIcon.setForeground(accentColor);
        iconContainer.add(lblIcon);

        // Value and label panel
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);

        JLabel lblValue = new JLabel(value);
        lblValue.setFont(new Font("Segoe UI", Font.BOLD, 36));
        lblValue.setForeground(TEKS_UTAMA);
        lblValue.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblLabel = new JLabel(label);
        lblLabel.setFont(FONT_BODY);
        lblLabel.setForeground(TEKS_SEKUNDER);
        lblLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        textPanel.add(lblValue);
        textPanel.add(Box.createVerticalStrut(4));
        textPanel.add(lblLabel);

        card.add(iconContainer, BorderLayout.WEST);
        card.add(textPanel, BorderLayout.CENTER);

        return card;
    }

    /**
     * Buat activity item card dengan avatar dan timestamp
     * 
     * @param icon      Emoji ikon aktivitas
     * @param text      Deskripsi aktivitas
     * @param timestamp Waktu aktivitas
     * @return JPanel activity item
     */
    public static JPanel createActivityItem(String icon, String text, String timestamp) {
        JPanel item = new JPanel(new BorderLayout(SPACING_M, 0));
        item.setBackground(LATAR_KARTU);
        item.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0, 10)),
                BorderFactory.createEmptyBorder(SPACING_M, 0, SPACING_M, 0)));

        // Icon dengan background bulat
        JPanel iconBg = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(ACCENT_BLUE_LIGHT);
                g2d.fillOval(0, 0, 36, 36);
                g2d.dispose();
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(36, 36);
            }
        };
        iconBg.setLayout(new GridBagLayout());
        iconBg.setOpaque(false);
        JLabel lblIcon = new JLabel(icon);
        lblIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
        iconBg.add(lblIcon);

        // Text
        JLabel lblText = new JLabel(text);
        lblText.setFont(FONT_BODY);
        lblText.setForeground(TEKS_UTAMA);

        // Timestamp
        JLabel lblTime = new JLabel(timestamp);
        lblTime.setFont(FONT_CAPTION);
        lblTime.setForeground(TEKS_REDUP);

        item.add(iconBg, BorderLayout.WEST);
        item.add(lblText, BorderLayout.CENTER);
        item.add(lblTime, BorderLayout.EAST);

        // Hover effect
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                item.setBackground(LATAR_UTAMA);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                item.setBackground(LATAR_KARTU);
            }
        });

        return item;
    }

    // ===== DYNAMIC DARK MODE METHODS =====

    /**
     * Buat elevated card dengan dynamic colors (Dark Mode Support)
     * 
     * @param cornerRadius Radius sudut
     * @return JPanel dengan elevated style yang mendukung dark mode
     */
    public static JPanel createElevatedCardDynamic(int cornerRadius) {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int shadowSize = 8;
                int w = getWidth() - shadowSize * 2;
                int h = getHeight() - shadowSize * 2;

                // Draw shadow layers (lighter in dark mode)
                for (int i = 0; i < shadowSize; i++) {
                    int alpha = isDarkMode ? (int) (8 * (1 - (double) i / shadowSize)) 
                                          : (int) (15 * (1 - (double) i / shadowSize));
                    g2d.setColor(new Color(0, 0, 0, alpha));
                    g2d.fillRoundRect(
                            shadowSize - i,
                            shadowSize - i + 2,
                            w + i * 2,
                            h + i * 2,
                            cornerRadius + i,
                            cornerRadius + i);
                }

                // Draw main card background with dynamic color
                g2d.setColor(getBgCard());
                g2d.fillRoundRect(shadowSize, shadowSize, w, h, cornerRadius, cornerRadius);

                // Draw subtle border
                g2d.setColor(isDarkMode ? new Color(255, 255, 255, 8) : new Color(0, 0, 0, 10));
                g2d.drawRoundRect(shadowSize, shadowSize, w - 1, h - 1, cornerRadius, cornerRadius);

                g2d.dispose();
            }

            @Override
            public Insets getInsets() {
                return new Insets(8 + SPACING_L, 8 + SPACING_L, 8 + SPACING_L, 8 + SPACING_L);
            }
        };
    }

    /**
     * Buat statistics card dengan dynamic colors (Dark Mode Support)
     * 
     * @param icon        Emoji atau karakter ikon
     * @param label       Label statistik
     * @param value       Nilai statistik
     * @param accentColor Warna accent untuk ikon (dynamic)
     * @param bgColor     Warna background light untuk ikon (dynamic)
     * @return JPanel statistics card
     */
    public static JPanel createStatisticsCardDynamic(String icon, String label, String value, Color accentColor,
            Color bgColor) {
        JPanel card = createElevatedCardDynamic(16);
        card.setLayout(new BorderLayout(SPACING_M, 0));
        card.setOpaque(false);

        // Icon panel dengan background
        JPanel iconContainer = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(bgColor);
                g2d.fillRoundRect(0, 0, 56, 56, 16, 16);
                g2d.dispose();
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(56, 56);
            }
        };
        iconContainer.setLayout(new GridBagLayout());
        iconContainer.setOpaque(false);

        JLabel lblIcon = new JLabel(icon);
        lblIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 28));
        lblIcon.setForeground(accentColor);
        iconContainer.add(lblIcon);

        // Value and label panel with dynamic colors
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);

        JLabel lblValue = new JLabel(value);
        lblValue.setFont(new Font("Segoe UI", Font.BOLD, 36));
        lblValue.setForeground(getTextPrimary());
        lblValue.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblLabel = new JLabel(label);
        lblLabel.setFont(FONT_BODY);
        lblLabel.setForeground(getTextSecondary());
        lblLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        textPanel.add(lblValue);
        textPanel.add(Box.createVerticalStrut(4));
        textPanel.add(lblLabel);

        card.add(iconContainer, BorderLayout.WEST);
        card.add(textPanel, BorderLayout.CENTER);

        return card;
    }

    /**
     * Buat activity item dengan dynamic colors (Dark Mode Support)
     * 
     * @param icon      Emoji ikon aktivitas
     * @param text      Deskripsi aktivitas
     * @param timestamp Waktu aktivitas
     * @return JPanel activity item
     */
    public static JPanel createActivityItemDynamic(String icon, String text, String timestamp) {
        JPanel item = new JPanel(new BorderLayout(SPACING_M, 0));
        item.setBackground(getBgCard());
        item.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, isDarkMode ? new Color(255, 255, 255, 10) : new Color(0, 0, 0, 10)),
                BorderFactory.createEmptyBorder(SPACING_M, 0, SPACING_M, 0)));

        // Icon dengan background bulat
        JPanel iconBg = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(getAccentBlueBg());
                g2d.fillOval(0, 0, 36, 36);
                g2d.dispose();
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(36, 36);
            }
        };
        iconBg.setLayout(new GridBagLayout());
        iconBg.setOpaque(false);
        JLabel lblIcon = new JLabel(icon);
        lblIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
        iconBg.add(lblIcon);

        // Text with dynamic color
        JLabel lblText = new JLabel(text);
        lblText.setFont(FONT_BODY);
        lblText.setForeground(getTextPrimary());

        // Timestamp with dynamic color
        JLabel lblTime = new JLabel(timestamp);
        lblTime.setFont(FONT_CAPTION);
        lblTime.setForeground(getTextMuted());

        item.add(iconBg, BorderLayout.WEST);
        item.add(lblText, BorderLayout.CENTER);
        item.add(lblTime, BorderLayout.EAST);

        // Hover effect with dynamic colors
        Color normalBg = getBgCard();
        Color hoverBg = getBgHover();
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                item.setBackground(hoverBg);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                item.setBackground(normalBg);
            }
        });

        return item;
    }

    /**
     * Buat top bar modern dengan shadow (Light theme)
     * 
     * @param height Tinggi top bar
     * @return JPanel dengan shadow effect
     */
    public static JPanel createModernTopBar(int height) {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();

                // Draw shadow at bottom
                for (int i = 0; i < 4; i++) {
                    int alpha = (int) (20 * (1 - (double) i / 4));
                    g2d.setColor(new Color(0, 0, 0, alpha));
                    g2d.drawLine(0, getHeight() - 1 + i, getWidth(), getHeight() - 1 + i);
                }

                g2d.dispose();
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(super.getPreferredSize().width, height);
            }
        };
    }

    /**
     * Buat rounded search field modern
     * 
     * @param placeholder Teks placeholder
     * @return JTextField dengan styling modern
     */
    public static JTextField createRoundedSearchField(String placeholder) {
        JTextField field = new JTextField(placeholder) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw rounded background
                g2d.setColor(LATAR_UTAMA);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

                // Draw border
                g2d.setColor(BORDER);
                g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

                g2d.dispose();
                super.paintComponent(g);
            }
        };
        field.setOpaque(false);
        field.setFont(FONT_BODY);
        field.setForeground(TEKS_SEKUNDER);
        field.setBorder(BorderFactory.createEmptyBorder(8, 36, 8, 12));
        field.setPreferredSize(new Dimension(300, 40));

        // Clear placeholder on focus
        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(TEKS_UTAMA);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(TEKS_SEKUNDER);
                }
            }
        });

        return field;
    }

    /**
     * Tampilkan popup Login Berhasil yang profesional (Redesign 2025)
     * Fitur:
     * - Icon success dengan lingkaran hijau
     * - Pesan selamat datang
     * - Auto-close dengan countdown
     * - Desain modern enterprise-grade
     * 
     * @param parent     Parent frame
     * @param onComplete Runnable yang dijalankan setelah dialog ditutup
     */
    public static void showLoginSuccessDialog(JFrame parent, Runnable onComplete) {
        // Custom undecorated dialog untuk tampilan lebih modern
        JDialog dialog = new JDialog(parent, true);
        dialog.setUndecorated(true);
        dialog.setSize(400, 240);
        dialog.setLocationRelativeTo(parent);

        // Main panel dengan rounded corners effect
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Background putih dengan rounded corners
                g2d.setColor(LATAR_KARTU);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), RADIUS_DIALOG, RADIUS_DIALOG);

                // Border subtle
                g2d.setColor(BORDER);
                g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, RADIUS_DIALOG, RADIUS_DIALOG);

                g2d.dispose();
            }
        };
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setOpaque(false);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(SPACING_XL, SPACING_XL, SPACING_L, SPACING_XL));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Success Icon - lingkaran hijau dengan checkmark
        JPanel iconPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Lingkaran hijau
                g2d.setColor(SUCCESS_ICON);
                g2d.fillOval(0, 0, 64, 64);

                // Checkmark putih
                g2d.setColor(Color.WHITE);
                g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g2d.drawLine(18, 32, 28, 44);
                g2d.drawLine(28, 44, 46, 22);

                g2d.dispose();
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(64, 64);
            }
        };
        iconPanel.setOpaque(false);

        gbc.insets = new Insets(0, 0, SPACING_M, 0);
        mainPanel.add(iconPanel, gbc);

        // Title "Login Berhasil"
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, SPACING_S, 0);
        JLabel titleLabel = new JLabel("Login Berhasil");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(SUCCESS_TEXT);
        mainPanel.add(titleLabel, gbc);

        // Subtitle
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, SPACING_L, 0);
        JLabel subtitleLabel = new JLabel("Selamat datang di Sistem Inventaris Aset");
        subtitleLabel.setFont(FONT_BODY);
        subtitleLabel.setForeground(TEKS_SEKUNDER);
        mainPanel.add(subtitleLabel, gbc);

        // Countdown label
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 0, 0);
        JLabel countdownLabel = new JLabel("Mengalihkan dalam 2 detik...");
        countdownLabel.setFont(FONT_CAPTION);
        countdownLabel.setForeground(TEKS_REDUP);
        mainPanel.add(countdownLabel, gbc);

        // Container panel untuk shadow effect
        JPanel containerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw shadow
                for (int i = 0; i < 10; i++) {
                    int alpha = (int) (30 * (1 - (double) i / 10));
                    g2d.setColor(new Color(0, 0, 0, alpha));
                    g2d.fillRoundRect(
                            10 - i, 10 - i + 3,
                            getWidth() - 20 + i * 2,
                            getHeight() - 20 + i * 2,
                            RADIUS_DIALOG + i, RADIUS_DIALOG + i);
                }
                g2d.dispose();
            }
        };
        containerPanel.setLayout(new BorderLayout());
        containerPanel.setOpaque(false);
        containerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        containerPanel.add(mainPanel, BorderLayout.CENTER);

        dialog.setContentPane(containerPanel);
        dialog.setBackground(new Color(0, 0, 0, 0));

        // Auto-close timer dengan countdown
        final int[] countdown = { 2 };
        Timer countdownTimer = new Timer(1000, null);
        countdownTimer.addActionListener(e -> {
            countdown[0]--;
            if (countdown[0] > 0) {
                countdownLabel.setText("Mengalihkan dalam " + countdown[0] + " detik...");
            } else {
                countdownTimer.stop();
                dialog.dispose();
                if (onComplete != null) {
                    onComplete.run();
                }
            }
        });
        countdownTimer.setRepeats(true);
        countdownTimer.start();

        dialog.setVisible(true);
    }
    
    // ===== ICON LOADING UTILITIES =====
    
    /**
     * Load icon dari resource path dengan proper error handling dan scaling
     * 
     * @param iconPath Path ke icon (e.g., "/icon/CARI.png")
     * @param width Target width (0 untuk original size)
     * @param height Target height (0 untuk original size)
     * @return ImageIcon yang sudah di-scale, atau null jika gagal
     */
    public static ImageIcon loadIcon(String iconPath, int width, int height) {
        try {
            java.net.URL imgURL = ModernTheme.class.getResource(iconPath);
            if (imgURL != null) {
                ImageIcon originalIcon = new ImageIcon(imgURL);
                
                // Jika width dan height 0, gunakan original size
                if (width == 0 && height == 0) {
                    return originalIcon;
                }
                
                // Scale icon
                Image scaledImage = originalIcon.getImage().getScaledInstance(
                    width > 0 ? width : originalIcon.getIconWidth(),
                    height > 0 ? height : originalIcon.getIconHeight(),
                    Image.SCALE_SMOOTH
                );
                return new ImageIcon(scaledImage);
            } else {
                System.err.println("⚠️ Icon tidak ditemukan: " + iconPath);
                return null;
            }
        } catch (Exception e) {
            System.err.println("❌ Error loading icon " + iconPath + ": " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Load icon dengan size default 24x24 (cocok untuk button)
     * 
     * @param iconPath Path ke icon (e.g., "/icon/CARI.png")
     * @return ImageIcon 24x24, atau null jika gagal
     */
    public static ImageIcon loadIcon(String iconPath) {
        return loadIcon(iconPath, 24, 24);
    }
    
    /**
     * Load icon dengan size custom (square)
     * 
     * @param iconPath Path ke icon
     * @param size Size (width = height)
     * @return ImageIcon dengan size yang ditentukan
     */
    public static ImageIcon loadIconSquare(String iconPath, int size) {
        return loadIcon(iconPath, size, size);
    }
    
    /**
     * Buat button dengan icon dan text
     * Icon akan di-load dan di-scale otomatis
     * 
     * @param text Text button
     * @param iconPath Path ke icon (e.g., "/icon/CARI.png")
     * @param iconSize Size icon (square)
     * @return JButton dengan icon dan styling
     */
    public static JButton createIconButton(String text, String iconPath, int iconSize) {
        JButton button = new JButton(text);
        
        // Load icon
        ImageIcon icon = loadIconSquare(iconPath, iconSize);
        if (icon != null) {
            button.setIcon(icon);
        }
        
        // Styling
        button.setFont(FONT_BUTTON);
        button.setForeground(TEKS_UTAMA);
        button.setBackground(LATAR_KARTU);
        button.setBorder(BorderFactory.createEmptyBorder(10, 16, 10, 16));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setHorizontalTextPosition(SwingConstants.RIGHT);
        button.setIconTextGap(8);
        
        // Hover effect
        button.addMouseListener(new MouseAdapter() {
            Color originalBg = button.getBackground();
            
            @Override
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(new Color(245, 247, 250));
            }
            
            @Override
            public void mouseExited(MouseEvent evt) {
                button.setBackground(originalBg);
            }
        });
        
        return button;
    }
    
    /**
     * Buat button icon-only (tanpa text)
     * Cocok untuk toolbar atau action buttons
     * 
     * @param iconPath Path ke icon
     * @param iconSize Size icon
     * @param tooltip Tooltip text
     * @return JButton icon-only
     */
    public static JButton createIconOnlyButton(String iconPath, int iconSize, String tooltip) {
        JButton button = new JButton();
        
        // Load icon
        ImageIcon icon = loadIconSquare(iconPath, iconSize);
        if (icon != null) {
            button.setIcon(icon);
        }
        
        // Styling
        button.setToolTipText(tooltip);
        button.setBackground(LATAR_KARTU);
        button.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        
        // Hover effect dengan rounded background
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(new Color(245, 247, 250));
            }
            
            @Override
            public void mouseExited(MouseEvent evt) {
                button.setBackground(LATAR_KARTU);
            }
        });
        
        return button;
    }
    
    /**
     * Buat JLabel dengan icon
     * 
     * @param text Text label
     * @param iconPath Path ke icon
     * @param iconSize Size icon
     * @return JLabel dengan icon
     */
    public static JLabel createIconLabel(String text, String iconPath, int iconSize) {
        JLabel label = new JLabel(text);
        
        // Load icon
        ImageIcon icon = loadIconSquare(iconPath, iconSize);
        if (icon != null) {
            label.setIcon(icon);
        }
        
        label.setFont(FONT_BODY);
        label.setForeground(TEKS_UTAMA);
        label.setIconTextGap(8);
        
        return label;
    }
    
    /**
     * Resize existing ImageIcon
     * 
     * @param icon Original icon
     * @param width Target width
     * @param height Target height
     * @return Resized ImageIcon
     */
    public static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        if (icon == null) return null;
        
        Image scaledImage = icon.getImage().getScaledInstance(
            width, height, Image.SCALE_SMOOTH
        );
        return new ImageIcon(scaledImage);
    }
}
