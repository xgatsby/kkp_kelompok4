package koneksi;
import java.sql.*;
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
        }
        
        try{
            koneksi = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Berhasil Koneksi Database");
        }
        catch (SQLException ex){
            System.out.println("Gagal Koneksi Database: "+ex.getMessage());
            ex.printStackTrace();
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
}