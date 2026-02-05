package master;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import koneksi.koneksi;
import ui.ModernTheme;

/**
 * Login Screen - Modernized Version
 * Sistem Inventaris Aset SMA Negeri 62 Jakarta
 */
public class login extends JFrame {
    
    // Components
    private JPanel mainPanel;
    private JPanel loginCard;
    private JLabel lblLogo;
    private JLabel lblTitle;
    private JLabel lblSubtitle;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JLabel lblCopyright;
    
    public login() {
        // Apply Modern Theme
        ModernTheme.applyTheme();
        
        initComponents();
        setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        setTitle("Login - Sistem Inventaris Aset");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setResizable(false);
        
        // Main Panel dengan Gradient Background
        mainPanel = ModernTheme.createGradientPanel(
            new Color(227, 242, 253),  // #E3F2FD (light blue)
            Color.WHITE
        );
        mainPanel.setLayout(new GridBagLayout());
        
        // Login Card Panel
        loginCard = ModernTheme.createStyledPanel();
        loginCard.setLayout(new GridBagLayout());
        loginCard.setPreferredSize(new Dimension(450, 500));
        ModernTheme.applyCardStyle(loginCard);
        
        // Add shadow effect
        loginCard.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(ModernTheme.BORDER, 1, true),
            BorderFactory.createEmptyBorder(
                ModernTheme.SPACING_XXL,
                ModernTheme.SPACING_XXL,
                ModernTheme.SPACING_XXL,
                ModernTheme.SPACING_XXL
            )
        ));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, ModernTheme.SPACING_M, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        
        // Logo Sekolah
        lblLogo = new JLabel();
        lblLogo.setPreferredSize(new Dimension(80, 80));
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Load logo image
        try {
            ImageIcon logoIcon = new ImageIcon(getClass().getResource("/icon/LOGO2.jpg"));
            Image logoImage = logoIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            lblLogo.setIcon(new ImageIcon(logoImage));
        } catch (Exception e) {
            // Fallback jika logo tidak ditemukan
            lblLogo.setOpaque(true);
            lblLogo.setBackground(ModernTheme.LATAR_SIDEBAR);
            lblLogo.setBorder(BorderFactory.createLineBorder(ModernTheme.BORDER, 2, true));
            lblLogo.setText("LOGO");
            lblLogo.setFont(ModernTheme.FONT_CAPTION);
            lblLogo.setForeground(ModernTheme.TEKS_REDUP);
        }
        loginCard.add(lblLogo, gbc);
        
        // Title
        gbc.gridy++;
        gbc.insets = new Insets(ModernTheme.SPACING_M, 0, ModernTheme.SPACING_S, 0);
        lblTitle = ModernTheme.createStyledLabel("SMA NEGERI 62 JAKARTA", "h2");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        loginCard.add(lblTitle, gbc);
        
        // Subtitle
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, ModernTheme.SPACING_XXL, 0);
        lblSubtitle = ModernTheme.createStyledLabel("Sistem Inventaris Aset Sekolah", "body");
        lblSubtitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblSubtitle.setForeground(ModernTheme.TEKS_SEKUNDER);
        loginCard.add(lblSubtitle, gbc);
        
        // Username Label
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, ModernTheme.SPACING_S, 0);
        gbc.anchor = GridBagConstraints.WEST;
        lblUsername = ModernTheme.createStyledLabel("Nama Pengguna", "label");
        loginCard.add(lblUsername, gbc);
        
        // Username Field
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, ModernTheme.SPACING_L, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtUsername = ModernTheme.createStyledTextField();
        txtUsername.setPreferredSize(new Dimension(350, ModernTheme.INPUT_HEIGHT));
        loginCard.add(txtUsername, gbc);
        
        // Password Label
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, ModernTheme.SPACING_S, 0);
        gbc.fill = GridBagConstraints.NONE;
        lblPassword = ModernTheme.createStyledLabel("Kata Sandi", "label");
        loginCard.add(lblPassword, gbc);
        
        // Password Field
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, ModernTheme.SPACING_XL, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtPassword = new JPasswordField();
        txtPassword.setFont(ModernTheme.FONT_BODY);
        txtPassword.setPreferredSize(new Dimension(350, ModernTheme.INPUT_HEIGHT));
        txtPassword.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(ModernTheme.BORDER, 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        ModernTheme.applyInputFocusEffect(txtPassword);
        loginCard.add(txtPassword, gbc);
        
        // Login Button
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        btnLogin = ModernTheme.createStyledButton("MASUK", "primary");
        btnLogin.setPreferredSize(new Dimension(350, 45));
        btnLogin.addActionListener(evt -> loginActionPerformed());
        loginCard.add(btnLogin, gbc);
        
        // Add login card to main panel
        GridBagConstraints mainGbc = new GridBagConstraints();
        mainGbc.gridx = 0;
        mainGbc.gridy = 0;
        mainPanel.add(loginCard, mainGbc);
        
        // Copyright Label
        lblCopyright = ModernTheme.createStyledLabel(
            "© 2026 SMA Negeri 62 Jakarta", 
            "caption"
        );
        lblCopyright.setHorizontalAlignment(SwingConstants.CENTER);
        mainGbc.gridy = 1;
        mainGbc.insets = new Insets(ModernTheme.SPACING_XL, 0, ModernTheme.SPACING_M, 0);
        mainPanel.add(lblCopyright, mainGbc);
        
        // Set content pane
        setContentPane(mainPanel);
    }
    
    private void loginActionPerformed() {
        try {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            java.sql.Connection conn = new koneksi().connect();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txtUsername.getText());
            pst.setString(2, new String(txtPassword.getPassword()));
            java.sql.ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(
                    this, 
                    "Berhasil masuk ke sistem",
                    "Login Berhasil",
                    JOptionPane.INFORMATION_MESSAGE
                );
                this.setVisible(false);
                new master.branda().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(
                    this, 
                    "Nama pengguna atau kata sandi salah",
                    "Login Gagal",
                    JOptionPane.ERROR_MESSAGE
                );
                txtPassword.setText("");
                txtUsername.requestFocus();
            }
            
            rs.close();
            pst.close();
            conn.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this, 
                "Terjadi kesalahan: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new login().setVisible(true);
        });
    }
}
