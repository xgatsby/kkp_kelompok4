package koneksi;
import java.sql.*;
import javax.swing.JOptionPane;

public class koneksi {
    private Connection koneksi;
    
    // Konstanta untuk kredensial database
    public static final String DB_URL = "jdbc:mysql://localhost:3306/inventaris_aset?useSSL=false&serverTimezone=UTC";
    public static final String DB_USER = "inventaris";
    public static final String DB_PASS = "inventaris123";
    
    public Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Berhasil Load Driver");
        }
        catch(ClassNotFoundException ex){
            System.out.println("Gagal Load Driver: "+ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                "Driver MySQL tidak ditemukan!\n\n" +
                "Pastikan file mysql-connector-java-8.0.33.jar ada di folder lib/\n\n" +
                "Error: " + ex.getMessage(),
                "Error Driver",
                JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        try{
            koneksi = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Berhasil Koneksi Database");
        }
        catch (SQLException ex){
            System.out.println("Gagal Koneksi Database: "+ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                "Gagal koneksi ke database!\n\n" +
                "Pastikan:\n" +
                "1. MySQL/Laragon sudah berjalan\n" +
                "2. Database 'inventaris_aset' sudah dibuat\n" +
                "3. User 'inventaris' dengan password 'inventaris123' sudah ada\n\n" +
                "Error: " + ex.getMessage(),
                "Error Koneksi Database",
                JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return koneksi;
    }
    
    // Method static untuk mendapatkan koneksi langsung
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new SQLException("Driver tidak ditemukan: " + ex.getMessage());
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
    
    // Method untuk test koneksi
    public static boolean testConnection() {
        try {
            Connection conn = getConnection();
            if (conn != null) {
                conn.close();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Test koneksi gagal: " + e.getMessage());
        }
        return false;
    }
    
    // Main method untuk test koneksi
    public static void main(String[] args) {
        System.out.println("=== TEST KONEKSI DATABASE ===");
        System.out.println("URL: " + DB_URL);
        System.out.println("User: " + DB_USER);
        System.out.println();
        
        koneksi k = new koneksi();
        Connection conn = k.connect();
        
        if (conn != null) {
            System.out.println();
            System.out.println("✓ KONEKSI BERHASIL!");
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println();
            System.out.println("✗ KONEKSI GAGAL!");
        }
    }
}