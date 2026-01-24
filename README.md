# 📦 Sistem Inventaris Aset Sekolah

> **🎯 Getting Started:** Baca [README_FIRST.txt](README_FIRST.txt) atau double-click [START_HERE.bat](START_HERE.bat)

## ⚡ Quick Start (1 MENIT!)

### 🎯 **Prasyarat:**
- ✅ Java JDK 8+ sudah install
- ✅ MySQL (Laragon/XAMPP) sudah install & running
- ✅ Repository sudah clone

**Cek prasyarat:** Double-click `QUICK_TEST.bat` atau `TEST_SEMUA.bat`

### 🚀 Cara Tercepat (ONE-CLICK):
```cmd
git clone https://github.com/xgatsby/kkp_kelompok4.git
cd kkp_kelompok4

# Double-click salah satu:
START_HERE.bat                  # Menu interaktif
scripts\SETUP_OTOMATIS.bat      # Setup otomatis langsung
```

### 📦 Cara Manual:
```cmd
git clone https://github.com/xgatsby/kkp_kelompok4.git
cd kkp_kelompok4
scripts\INSTALL.bat
```

**Login:** `admin` / `admin123` 🎉

---

## 📚 Dokumentasi

| File | Deskripsi |
|------|-----------|
| **README_FIRST.txt** | 👈 **BACA INI DULU!** Panduan singkat |
| **START_HERE.bat** | 🚀 Menu interaktif untuk setup |
| **QUICK_TEST.bat** | 🧪 Test prasyarat (5 detik) |
| **TEST_SEMUA.bat** | 🔍 Test lengkap semua prasyarat |
| **docs/QUICK_START.md** | ⚡ Setup 1 menit |
| **docs/SETUP_GUIDE.md** | 📖 Panduan lengkap + troubleshooting |
| **docs/FOLDER_STRUCTURE.md** | 📁 Struktur folder repository |
| **scripts/SETUP_OTOMATIS.bat** | 🤖 Setup otomatis (one-click) |
| **scripts/INSTALL.bat** | 📦 Installer manual |
| **scripts/RUN.bat** | ▶️ Quick launcher |

---

## ✨ Fitur

- Login & manajemen user
- Data aset, kategori, lokasi
- Data member peminjam
- Transaksi mutasi & peminjaman
- Cetak laporan PDF

## 🛠️ Yang Dibutuhkan

### **Wajib:**
1. **Java JDK 8+** - https://adoptium.net/
2. **MySQL 5.7/8.0** - https://laragon.org/download/ (Recommended)

### **Opsional:**
3. **NetBeans IDE** - https://netbeans.apache.org/download/ (untuk development)

### **Cek Prasyarat:**
```cmd
# Quick test (5 detik)
QUICK_TEST.bat

# Full test (lengkap)
TEST_SEMUA.bat
```

## � Struktur Project

```
kkp_kelompok4/
├── 📄 README.md                # Dokumentasi utama
├── 📄 README_FIRST.txt         # Panduan singkat
├── 🚀 START_HERE.bat           # Menu interaktif
├── 🧪 QUICK_TEST.bat           # Quick test (5 detik)
├── 🧪 TEST_SEMUA.bat           # Full test
│
├── 📂 docs/                    # Dokumentasi lengkap
│   ├── QUICK_START.md
│   ├── SETUP_GUIDE.md
│   └── internal/               # Dokumentasi internal
│
├── 📂 scripts/                 # Installer & utilities
├── 📂 config/                  # File konfigurasi
├── 📂 src/                     # Source code
├── 📂 Database/                # SQL files
├── 📂 Libraries/               # JAR dependencies
└── 📂 nbproject/               # NetBeans config
```

Lihat struktur lengkap: [STRUKTUR_FOLDER.txt](STRUKTUR_FOLDER.txt) atau [docs/FOLDER_STRUCTURE.md](docs/FOLDER_STRUCTURE.md)

---

## 🔧 Konfigurasi Database

Edit file: `src/koneksi/koneksi.java`

```java
public static final String DB_URL = "jdbc:mysql://localhost:3306/inventaris_aset";
public static final String DB_USER = "inventaris";
public static final String DB_PASS = "inventaris123";
```

**Setelah edit, WAJIB rebuild:**
- NetBeans: Clean and Build (Shift + F11)
- Manual: `scripts\BUILD.bat`

---

## 🆘 Troubleshooting

### Error: "Access denied for user"
Jalankan: `scripts\SETUP_DATABASE.bat`

### Error: "Cannot connect to database"
- Cek MySQL service sudah jalan
- Pastikan database `inventaris_aset` sudah dibuat
- Test koneksi: `scripts\TEST_CONNECTION.bat`

### Error: "Java not found"
- Install Java JDK: https://adoptium.net/
- Restart CMD
- Jalankan ulang installer

### Error saat Build
- Pastikan JDK sudah terinstall
- Pastikan semua library di folder `Libraries/` ada
- Coba Clean and Build ulang

**Troubleshooting lengkap:** [docs/SETUP_GUIDE.md](docs/SETUP_GUIDE.md)

---

## 📞 Butuh Bantuan?

1. Cek: [docs/SETUP_GUIDE.md](docs/SETUP_GUIDE.md)
2. Buat issue: https://github.com/xgatsby/kkp_kelompok4/issues
3. Lihat dokumentasi lengkap di folder `docs/`

---

**Repository:** https://github.com/xgatsby/kkp_kelompok4

**Happy Coding! 🚀**
