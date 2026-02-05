package ui;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.Icon;
import java.awt.Color;

/**
 * IconManager - Utility class untuk loading SVG icons menggunakan FlatLaf
 * Extras
 * 
 * Mendukung pewarnaan dinamis untuk Light/Dark mode.
 * Icons disimpan di folder src/icons/ dalam format SVG.
 * 
 * @author Sistem Inventaris Aset SMA Negeri 62 Jakarta
 * @version 1.0
 */
public class IconManager {

    // Default icon size
    public static final int SIZE_SMALL = 16;
    public static final int SIZE_MEDIUM = 20;
    public static final int SIZE_LARGE = 24;
    public static final int SIZE_XLARGE = 32;

    /**
     * Get SVG icon dengan ukuran default (20px)
     * 
     * @param name Nama icon tanpa ekstensi .svg
     * @return Icon yang siap digunakan
     */
    public static Icon get(String name) {
        return get(name, SIZE_MEDIUM);
    }

    /**
     * Get SVG icon dengan ukuran custom
     * 
     * @param name Nama icon tanpa ekstensi .svg
     * @param size Ukuran icon dalam pixel
     * @return Icon yang siap digunakan
     */
    public static Icon get(String name, int size) {
        try {
            FlatSVGIcon icon = new FlatSVGIcon("icons/" + name + ".svg", size, size);
            return icon;
        } catch (Throwable e) {
            // Catch NoClassDefFoundError if JSVG library is incompatible
            System.err.println("Gagal load icon " + name + ": " + e.getMessage());
            return null;
        }
    }

    /**
     * Get SVG icon dengan warna custom
     * 
     * @param name  Nama icon tanpa ekstensi .svg
     * @param size  Ukuran icon dalam pixel
     * @param color Warna icon
     * @return Icon yang siap digunakan dengan warna tertentu
     */
    public static Icon get(String name, int size, Color color) {
        try {
            FlatSVGIcon icon = new FlatSVGIcon("icons/" + name + ".svg", size, size);
            // Gunakan ColorFilter untuk mewarnai SVG
            FlatSVGIcon.ColorFilter colorFilter = FlatSVGIcon.ColorFilter.getInstance();
            colorFilter.add(Color.BLACK, color);
            icon.setColorFilter(colorFilter);
            return icon;
        } catch (Throwable e) {
            System.err.println("Gagal load icon " + name + ": " + e.getMessage());
            return null;
        }
    }

    /**
     * Get SVG icon untuk sidebar menu
     * Otomatis menyesuaikan warna berdasarkan mode (Light/Dark)
     * 
     * @param name     Nama icon
     * @param isActive Apakah menu sedang aktif
     * @return Icon dengan warna yang sesuai
     */
    public static Icon getMenuIcon(String name, boolean isActive) {
        Color iconColor = isActive ? ModernTheme.getAccentBlue() : ModernTheme.getTextSecondary();
        return get(name, SIZE_MEDIUM, iconColor);
    }

    /**
     * Get SVG icon untuk button dengan warna putih (untuk button berwarna)
     * 
     * @param name Nama icon
     * @return Icon berwarna putih
     */
    public static Icon getButtonIcon(String name) {
        return get(name, SIZE_SMALL, Color.WHITE);
    }
}
