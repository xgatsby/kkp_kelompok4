# 📁 Struktur Folder Repository

## 📂 Struktur Lengkap

```
kkp_kelompok4/
│
├── 📄 README.md                    # Dokumentasi utama (BACA INI DULU!)
├── 📄 README_FIRST.txt             # Panduan singkat untuk tim
├── 📄 LICENSE                      # Lisensi project
├── 📄 .gitignore                   # Git ignore rules
│
├── 🚀 START_HERE.bat               # ⭐ MULAI DARI SINI! (Menu interaktif)
│
├── 📂 docs/                        # 📚 Dokumentasi
│   ├── QUICK_START.md              # Setup 1 menit
│   ├── SETUP_GUIDE.md              # Panduan lengkap
│   ├── CHECKLIST_SEBELUM_PUSH.md   # Checklist untuk maintainer
│   ├── ANNOUNCEMENT_TEMPLATE.txt   # Template pengumuman
│   ├── CHANGELOG.md                # Riwayat perubahan
│   └── FOLDER_STRUCTURE.md         # File ini (struktur folder)
│
├── 📂 scripts/                     # 🔧 Script Installer & Utilities
│   ├── SETUP_OTOMATIS.bat          # Setup otomatis (one-click)
│   ├── INSTALL.bat                 # Installer manual
│   ├── BUILD.bat                   # Build aplikasi
│   ├── RUN.bat                     # Jalankan aplikasi
│   ├── SETUP_DATABASE.bat          # Setup database
│   ├── TEST_CONNECTION.bat         # Test koneksi database
│   └── init_git.bat                # Git initialization
│
├── 📂 config/                      # ⚙️ File Konfigurasi
│   ├── db.properties               # Konfigurasi database
│   ├── database_setup.sql          # SQL setup script
│   └── build.xml                   # Ant build configuration
│
├── 📂 src/                         # 💻 Source Code (JANGAN EDIT SEMBARANGAN!)
│   ├── koneksi/                    # Koneksi database
│   ├── master/                     # Form master data
│   ├── transaksi/                  # Form transaksi
│   ├── laporan/                    # Template laporan JasperReports
│   └── icon/                       # Icon & assets
│
├── 📂 Database/                    # 🗄️ Database SQL Files
│   └── inventaris_aset.sql         # Database schema & data
│
├── 📂 Libraries/                   # 📚 JAR Dependencies (JANGAN HAPUS!)
│   ├── mysql-connector-java-8.0.33.jar
│   ├── jasperreports-6.0.0.jar
│   └── ... (14 JAR files total)
│
├── 📂 nbproject/                   # 🔨 NetBeans Project Config
│   ├── project.xml
│   ├── project.properties
│   └── build-impl.xml
│
├── 📂 build/                       # 🏗️ Build Output (Auto-generated, di-ignore)
├── 📂 dist/                        # 📦 Distribution (Auto-generated, di-ignore)
└── 📄 manifest.mf                  # JAR Manifest

```

---

## 🎯 File Penting untuk Tim

### 🚀 Untuk Mulai Setup:
1. **START_HERE.bat** - Menu interaktif (paling mudah!)
2. **README_FIRST.txt** - Baca ini dulu
3. **docs/QUICK_START.md** - Setup 1 menit

### 📚 Untuk Dokumentasi:
1. **README.md** - Overview project
2. **docs/SETUP_GUIDE.md** - Panduan lengkap
3. **docs/CHANGELOG.md** - Riwayat perubahan

### 🔧 Untuk Development:
1. **scripts/BUILD.bat** - Build aplikasi
2. **scripts/RUN.bat** - Jalankan aplikasi
3. **config/db.properties** - Konfigurasi database

---

## ✅ Yang Di-Commit ke Git

### ✓ WAJIB di-commit:
- `src/` - Source code
- `Libraries/` - JAR files
- `Database/` - SQL files
- `nbproject/*.xml, *.properties` - NetBeans config
- `docs/` - Dokumentasi
- `scripts/` - Installer scripts
- `config/` - File konfigurasi
- `README.md`, `LICENSE`, `.gitignore`
- `manifest.mf`, `build.xml`

### ✗ JANGAN di-commit:
- `build/` - Build output
- `dist/` - Distribution files
- `nbproject/private/` - Private config
- `*.class` - Compiled files
- `.kiro/`, `.vscode/`, `.idea/` - IDE config

---

## 📋 Penjelasan Folder

### 📂 `docs/`
Semua dokumentasi project:
- Panduan setup
- Troubleshooting
- Changelog
- Checklist

### 📂 `scripts/`
Script untuk installer dan utilities:
- Setup otomatis
- Build & run
- Database setup
- Testing

### 📂 `config/`
File konfigurasi:
- Database config
- Build config
- Setup scripts

### 📂 `src/`
Source code aplikasi:
- `koneksi/` - Database connection
- `master/` - Master data forms (aset, kategori, lokasi, member)
- `transaksi/` - Transaction forms (mutasi, peminjaman)
- `laporan/` - JasperReports templates
- `icon/` - UI icons & images

### 📂 `Database/`
File SQL untuk database:
- Schema database
- Sample data
- Setup scripts

### 📂 `Libraries/`
JAR dependencies (14 files):
- MySQL Connector
- JasperReports
- iText PDF
- JCalendar
- Commons libraries

### 📂 `nbproject/`
NetBeans project configuration:
- Project settings
- Build configuration
- Classpath settings

---

## 🎓 Tips Navigasi

### Baru Clone Repository?
1. Baca: `README_FIRST.txt`
2. Jalankan: `START_HERE.bat`
3. Pilih: Setup Otomatis

### Mau Edit Code?
1. Buka: NetBeans
2. File → Open Project
3. Edit di folder: `src/`

### Mau Lihat Dokumentasi?
1. Buka folder: `docs/`
2. Baca: `SETUP_GUIDE.md`

### Mau Build Manual?
1. Jalankan: `scripts/BUILD.bat`
2. Atau: NetBeans → Clean and Build

---

## 📞 Butuh Bantuan?

Lihat dokumentasi di folder `docs/` atau tanya di grup tim!
