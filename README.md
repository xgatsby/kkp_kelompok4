# 📦 Sistem Inventaris Aset Sekolah

## ⚡ Quick Start

### Windows:
```cmd
git clone https://github.com/xgatsby/kkp_kelompok4.git
cd kkp_kelompok4
INSTALL.bat
```

**Selesai!** Login: `` / `` 🎉

---

## ✨ Fitur

- Login & manajemen user
- Data aset, kategori, lokasi
- Data member peminjam
- Transaksi mutasi & peminjaman
- Cetak laporan PDF

## 🛠️ Yang Dibutuhkan

1. **Java JDK 8+** - https://www.oracle.com/java/technologies/downloads/
2. **MySQL 5.7/8.0** - https://dev.mysql.com/downloads/mysql/
3. **NetBeans IDE** (opsional) - https://netbeans.apache.org/download/

## 📖 Cara Pakai

### Opsi 1: Pakai Installer (Recommended)

**Windows:**
1. Double-click `INSTALL.bat`
2. Ikuti instruksi
3. Pilih cara run (NetBeans atau JAR)

### Opsi 3: Jalankan JAR (Kalau Udah Build)

```cmd
RUN.bat
```

## 📁 Struktur Project

```
kkp_kelompok4/
├── Database/              # File SQL database
├── Libraries/             # Library JAR (MySQL, JasperReports, dll)
├── src/                   # Source code
├── INSTALL.bat            # Installer otomatis
├── RUN.bat                # Quick launcher
└── README.md
```

## 🔧 Konfigurasi Database

Kalau mau ganti user/password database, edit `src/koneksi/koneksi.java`:

## � Troubleshooting

### Error: "Access denied for user"
Pastikan username dan password di `koneksi.java` sesuai dengan MySQL kamu.

### Error: "Cannot connect to database"
- Cek MySQL service udah jalan belum
- Pastikan database `inventaris_aset` udah dibuat
- Cek port MySQL (default: 3306)

### Error saat Build
- Pastikan JDK udah terinstall
- Pastikan semua library di folder `Libraries/` ada
- Coba Clean and Build ulang

### INSTALL.bat Tidak Jalan
- Klik kanan → Run as Administrator
- Atau jalankan manual step-by-step

## � Catatan

- Semua library udah include di folder `Libraries/`
- JAR file ada di `dist/InventarisAsetSekolah.jar` setelah build

---

**Repository:** https://github.com/xgatsby/kkp_kelompok4

**Butuh bantuan?** Buat issue di https://github.com/xgatsby/kkp_kelompok4/issues
