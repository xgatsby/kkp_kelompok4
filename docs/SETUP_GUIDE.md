# 🚀 SETUP GUIDE - Sistem Inventaris Aset Sekolah

## 📋 Prasyarat (Install Dulu!)

Sebelum mulai, pastikan sudah install:

### 1. **Java JDK 8 atau lebih tinggi**
- Download: https://www.oracle.com/java/technologies/downloads/
- Atau pakai OpenJDK: https://adoptium.net/
- **Cek instalasi**: Buka CMD, ketik `java -version`

### 2. **MySQL Server** (Pilih salah satu)

**Opsi A: Laragon (Recommended - Paling Mudah)**
- Download: https://laragon.org/download/
- Install → Start All
- MySQL otomatis jalan di port 3306

**Opsi B: XAMPP**
- Download: https://www.apachefriends.org/
- Install → Start MySQL

**Opsi C: MySQL Standalone**
- Download: https://dev.mysql.com/downloads/mysql/
- Install dengan default settings

### 3. **NetBeans IDE** (Opsional, tapi recommended)
- Download: https://netbeans.apache.org/download/
- Pilih versi dengan Java SE support

---

## 🎯 CARA SETUP (3 LANGKAH MUDAH!)

### **LANGKAH 1: Clone Repository**

```bash
git clone https://github.com/xgatsby/kkp_kelompok4.git
cd kkp_kelompok4
```

### **LANGKAH 2: Setup Database**

**Cara Otomatis (Recommended):**
```bash
# Double-click file ini:
scripts\SETUP_DATABASE.bat
```

**Cara Manual (Jika otomatis gagal):**
1. Buka MySQL Command Line atau phpMyAdmin
2. Login sebagai root (password kosong atau sesuai instalasi)
3. Jalankan perintah ini:

```sql
CREATE DATABASE IF NOT EXISTS inventaris_aset;
CREATE USER IF NOT EXISTS 'inventaris'@'localhost' IDENTIFIED BY 'inventaris123';
GRANT ALL PRIVILEGES ON inventaris_aset.* TO 'inventaris'@'localhost';
FLUSH PRIVILEGES;
USE inventaris_aset;
SOURCE Database/inventaris_aset.sql;
```

### **LANGKAH 3: Jalankan Aplikasi**

**Cara 1: Pakai NetBeans (Recommended)**
1. Buka NetBeans
2. File → Open Project
3. Pilih folder `kkp_kelompok4`
4. Klik kanan project → Clean and Build
5. Klik kanan project → Run (atau tekan F6)

**Cara 2: Tanpa NetBeans**
```bash
# Build dulu:
scripts\BUILD.bat

# Lalu jalankan:
scripts\RUN.bat
```

**Cara 3: One-Click Installer**
```bash
# Double-click file ini (akan setup semuanya):
scripts\INSTALL.bat
```

---

## 🔐 Login Aplikasi

```
Username: admin
Password: admin123
```

---

## ❓ TROUBLESHOOTING

### ❌ Error: "Access denied for user"
**Solusi:**
1. Pastikan MySQL sudah jalan (cek di Task Manager)
2. Cek username/password di `src/koneksi/koneksi.java`
3. Atau jalankan ulang `scripts\SETUP_DATABASE.bat`

### ❌ Error: "Cannot connect to database"
**Solusi:**
1. Pastikan MySQL service running
2. Cek port MySQL (default: 3306)
3. Test koneksi: `scripts\TEST_CONNECTION.bat`

### ❌ Error: "Java not found"
**Solusi:**
1. Install Java JDK
2. Set JAVA_HOME di Environment Variables
3. Restart CMD/Terminal

### ❌ Error: "Driver tidak ditemukan"
**Solusi:**
- Pastikan file `Libraries/mysql-connector-java-8.0.33.jar` ada
- Jangan hapus folder `Libraries/`

### ❌ Error: "Laporan tidak ditemukan"
**Solusi:**
1. Clean and Build ulang di NetBeans
2. Atau jalankan `scripts\BUILD.bat`

### ❌ Build gagal di NetBeans
**Solusi:**
1. Tools → Java Platforms → Pastikan JDK terdeteksi
2. Clean and Build (Shift + F11)
3. Restart NetBeans

---

## 📁 Struktur Project (Yang Penting)

```
kkp_kelompok4/
├── src/                    # Source code (JANGAN EDIT sembarangan!)
│   ├── koneksi/           # Koneksi database
│   ├── master/            # Form master data
│   ├── transaksi/         # Form transaksi
│   ├── laporan/           # Template laporan
│   └── icon/              # Icon aplikasi
├── Libraries/             # JAR files (JANGAN HAPUS!)
├── Database/              # File SQL database
├── nbproject/             # Config NetBeans
├── docs/                  # Dokumentasi
├── scripts/               # Installer scripts
├── config/                # File konfigurasi
├── START_HERE.bat         # Menu interaktif
└── README.md              # Dokumentasi utama
```

---

## 🔧 Konfigurasi Database (Jika Perlu Ubah)

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

## 🎓 Tips Development

### ✅ DO (Lakukan):
- Selalu `git pull` sebelum mulai coding
- Test aplikasi setelah `git pull`
- Commit dengan pesan yang jelas
- Koordinasi sebelum edit file yang sama

### ❌ DON'T (Jangan):
- Jangan commit folder `build/` atau `dist/`
- Jangan commit file `.class`
- Jangan hapus folder `Libraries/`
- Jangan hardcode path absolut (pakai relative path)

---

## 📞 Butuh Bantuan?

1. Cek dulu di bagian **TROUBLESHOOTING** di atas
2. Buat issue di GitHub: https://github.com/xgatsby/kkp_kelompok4/issues
3. Lihat dokumentasi lain di folder `docs/`

---

## 🎉 Selamat Coding!

Jika semua langkah di atas berhasil, aplikasi sudah siap digunakan!

**Happy Coding! 🚀**
