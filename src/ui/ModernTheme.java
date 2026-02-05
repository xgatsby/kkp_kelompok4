package ui;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

/**
 * ModernTheme - Tema Modern untuk Sistem Inventaris Aset
 * 
 * Class ini menyediakan konstanta warna, typography, spacing, dan factory methods
 * untuk membuat komponen UI yang konsisten dengan desain modern 2025.
 * 
 * @author Sistem Inventaris Aset SMA Negeri 62 Jakarta
 * @version 2.0
 */
public class ModernTheme {
    
    // ===== COLOR CONSTANTS =====
    
    /**
     * Warna Utama (Primary Colors)
     */
    public static final Color BIRU_UTAMA = new Color(25, 118, 210);      // #1976D2
    public static final Color HIJAU_SEKUNDER = new Color(56, 142, 60);   // #388E3C
    public static final Color TEAL_AKSEN = new Color(0, 137, 123);       // #00897B
    
    /**
     * Warna Fungsional (Functional Colors)
     */
    public static final Color PERINGATAN = new Color(245, 124, 0);       // #F57C00
    public static final Color BAHAYA = new Color(211, 47, 47);           // #D32F2F
    public static final Color SUKSES = new Color(56, 142, 60);           // #388E3C
    public static final Color INFO = new Color(2, 136, 209);             // #0288D1
    
    /**
     * Warna Netral (Neutral Colors)
     */
    public static final Color LATAR_UTAMA = new Color(250, 250, 250);    // #FAFAFA
    public static final Color LATAR_KARTU = new Color(255, 255, 255);    // #FFFFFF
    public static final Color LATAR_SIDEBAR = new Color(245, 245, 245);  // #F5F5F5
    public static final Color TEKS_UTAMA = new Color(33, 33, 33);        // #212121
    public static final Color TEKS_SEKUNDER = new Color(117, 117, 117);  // #757575
    public static final Color TEKS_REDUP = new Color(158, 158, 158);     // #9E9E9E
    public static final Color BORDER = new Color(224, 224, 224);         // #E0E0E0
    public static final Color BORDER_GELAP = new Color(189, 189, 189);   // #BDBDBD
    
    /**
     * Warna Hover untuk Buttons
     */
    public static final Color BIRU_HOVER = new Color(21, 101, 192);      // #1565C0
    public static final Color HIJAU_HOVER = new Color(46, 125, 50);      // #2E7D32
    public static final Color MERAH_HOVER = new Color(198, 40, 40);      // #C62828
    public static final Color ABU_HOVER = new Color(97, 97, 97);         // #616161
    
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
    public static final int RADIUS_BUTTON = 4;
    
    // ===== COMPONENT DIMENSIONS =====
    
    public static final int INPUT_HEIGHT = 40;
    public static final int BUTTON_HEIGHT = 36;
    public static final int SIDEBAR_WIDTH = 240;
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
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        
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
            BorderFactory.createEmptyBorder(SPACING_L, SPACING_L, SPACING_L, SPACING_L)
        ));
    }
    
    /**
     * Apply hover effect ke button
     * 
     * @param button Button yang akan diberi hover effect
     * @param normalColor Warna normal
     * @param hoverColor Warna saat hover
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
                    BorderFactory.createEmptyBorder(7, 11, 7, 11)
                ));
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                textField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(BORDER, 1),
                    BorderFactory.createEmptyBorder(8, 12, 8, 12)
                ));
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
}
