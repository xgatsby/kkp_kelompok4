# TROUBLESHOOTING: Error Print Laporan

## Error yang Terjadi

Saat klik tombol **LAPORAN** di Form Member, muncul error:

```
Gagal mencetak laporan: Unable to make field transient java.util.Set 
java.util.AbstractMap.keySet accessible: module java.base does not 
"opens java.util" to unnamed module @67799180
```

## Penyebab

Error ini terjadi karena:
1. **Java 9+ Module System** - Java versi 9 ke atas memiliki module system yang lebih ketat
2. **JasperReports** - Library ini perlu akses ke internal Java classes
3. **Missing JVM Arguments** - Saat run JAR tanpa JVM arguments, module system memblokir akses

## Solusi

### ✓ Cara 1: Gunakan RUN.bat (RECOMMENDED)

File `scripts\RUN.bat` sudah dikonfigurasi dengan JVM arguments yang benar:

```batch
cd D:\KKP\InventarisAsetSekolah
.\scripts\RUN.bat
```

### ✓ Cara 2: Run Manual dengan JVM Arguments

```batch
java --add-opens java.base/java.util=ALL-UNNAMED ^
     --add-opens java.base/java.lang=ALL-UNNAMED ^
     --add-opens java.base/java.lang.reflect=ALL-UNNAMED ^
     -jar dist\InventarisAsetSekolah.jar
```

### ✓ Cara 3: Run dari NetBeans

File `nbproject\project.properties` sudah dikonfigurasi dengan JVM arguments:
- Buka project di NetBeans
- Klik Run (F6)
- JVM arguments otomatis terbawa

## Penjelasan JVM Arguments

| Argument | Fungsi |
|----------|--------|
| `--add-opens java.base/java.util=ALL-UNNAMED` | Buka akses ke java.util untuk JasperReports |
| `--add-opens java.base/java.lang=ALL-UNNAMED` | Buka akses ke java.lang untuk reflection |
| `--add-opens java.base/java.lang.reflect=ALL-UNNAMED` | Buka akses ke reflection API |

## Testing

Setelah menjalankan dengan cara yang benar:

1. Login ke aplikasi (admin/admin123)
2. Buka **Form Member**
3. Klik tombol **LAPORAN** (icon printer)
4. Laporan PDF akan muncul di JasperViewer
5. ✓ Tidak ada error lagi!

## File yang Sudah Dikonfigurasi

- ✓ `nbproject\project.properties` - Line 109
- ✓ `scripts\RUN.bat` - Line 48
- ✓ `manifest.mf` - Class-Path sudah benar

## Catatan Penting

⚠️ **JANGAN** run dengan cara ini (akan error):
```batch
java -jar dist\InventarisAsetSekolah.jar  ❌ SALAH!
```

✓ **SELALU** gunakan salah satu cara di atas yang sudah ada JVM arguments!

---

**Tanggal Fix:** 4 Februari 2026  
**Status:** ✓ RESOLVED  
**Tested:** Windows 10/11 dengan Java 8+
