# Changelog - Sistem Inventaris Aset Sekolah

## [2026-01-25] - Reorganisasi Repository & Update Dokumentasi

### Added
- ➕ Folder `docs/` untuk semua dokumentasi
- ➕ Folder `scripts/` untuk semua installer & utilities
- ➕ Folder `config/` untuk semua file konfigurasi
- ➕ `START_HERE.bat` - Menu interaktif utama
- ➕ `README_FIRST.txt` - Panduan singkat untuk pemula
- ➕ `QUICK_TEST.bat` - Quick test prasyarat (5 detik)
- ➕ `TEST_SEMUA.bat` - Full test prasyarat lengkap
- ➕ `FINAL_CHECK.bat` - Final check sebelum commit & push
- ➕ `scripts/SETUP_OTOMATIS.bat` - One-click setup dengan auto-detection
- ➕ `scripts/INSTALL.bat` - Installer manual
- ➕ `scripts/BUILD.bat` - Build aplikasi
- ➕ `scripts/RUN.bat` - Quick launcher
- ➕ `scripts/SETUP_DATABASE.bat` - Setup database otomatis
- ➕ `scripts/TEST_CONNECTION.bat` - Test koneksi database
- ➕ `docs/QUICK_START.md` - Setup 1 menit
- ➕ `docs/SETUP_GUIDE.md` - Panduan lengkap + troubleshooting
- ➕ `docs/FOLDER_STRUCTURE.md` - Struktur folder repository
- ➕ `docs/ANNOUNCEMENT_TEMPLATE.txt` - Template pengumuman
- ➕ `JAWABAN_PERTANYAAN.md` - FAQ tentang one-click setup
- ➕ `docs/internal/STRUKTUR_REPOSITORY.txt` - Penjelasan struktur
- ➕ `docs/internal/CARA_COMMIT_PERUBAHAN.txt` - Panduan commit & push
- ➕ `docs/internal/STATUS_REPOSITORY.md` - Status lengkap repository
- ➕ `docs/internal/RINGKASAN_FINAL.txt` - Ringkasan final untuk commit

### Changed
- 🔄 Rename `SETUP_UNTUK_TIM.md` → `docs/SETUP_GUIDE.md` (kata-kata lebih umum)
- 🔄 Rename `PESAN_UNTUK_TIM.txt` → `docs/ANNOUNCEMENT_TEMPLATE.txt`
- 🔄 Update `README.md` dengan struktur baru dan quick start
- 🔄 Update `.gitignore` untuk struktur folder baru
- 🔄 Update semua referensi file di dokumentasi
- 🔄 Semua kata "tim" dan "anggota tim" diganti dengan kata-kata umum

### Improved
- ✨ One-click setup: Jika prasyarat terpenuhi, tinggal click script
- ✨ Auto-detection: Script otomatis detect Java & MySQL
- ✨ Quick test: Cek prasyarat dalam 5 detik
- ✨ Menu interaktif: START_HERE.bat untuk kemudahan
- ✨ Dokumentasi lengkap: Quick start, setup guide, FAQ, troubleshooting
- ✨ Struktur rapi: Folder terorganisir dengan baik

### Fixed
- 🐛 Path database di `scripts/SETUP_DATABASE.bat` (dari `%~dp0Database\` ke `%~dp0..\Database\`)
- 🐛 Referensi file dokumentasi lama yang sudah diganti nama
- 🐛 Kata-kata spesifik "tim" di semua file

### Files Modified
- `README.md` - Update dengan struktur baru
- `README_FIRST.txt` - Panduan singkat
- `.gitignore` - Update untuk struktur baru
- `scripts/SETUP_OTOMATIS.bat` - Update referensi dokumentasi
- `docs/internal/STRUKTUR_REPOSITORY.txt` - Update referensi file
- `docs/internal/CARA_COMMIT_PERUBAHAN.txt` - Update commit message

### Repository Structure
```
kkp_kelompok4/
├── 📂 docs/                    # Dokumentasi lengkap
├── 📂 scripts/                 # Installer & utilities
├── 📂 config/                  # File konfigurasi
├── 📂 src/                     # Source code
├── 📂 Database/                # SQL files
├── 📂 Libraries/               # JAR dependencies
├── 🚀 START_HERE.bat           # Menu interaktif utama
├── 📄 README.md                # Dokumentasi utama
└── 📄 README_FIRST.txt         # Panduan singkat
```

### Benefits
- ✅ Repository lebih rapi dan terorganisir
- ✅ Dokumentasi lengkap dan mudah dipahami
- ✅ One-click setup untuk kemudahan
- ✅ Script test untuk cek prasyarat
- ✅ Kata-kata umum (bukan spesifik "tim")
- ✅ Siap production dan dibagikan

---

## [2026-01-20] - Fix JasperReports

### Fixed
- ✅ Error "Laporan tidak ditemukan" setelah Clean and Build
- ✅ Error `NoClassDefFoundError: org/apache/commons/beanutils/MethodUtils`
- ✅ Error "Byte data not found at : LOGO.png" saat generate laporan
- ✅ Hardcoded absolute paths di file `.jrxml` (LOGO.png, LOGO2.jpg)
- ✅ Error `InaccessibleObjectException` di Java 9+ (JVM args)

### Added
- ➕ Library `commons-beanutils-1.9.4.jar` untuk JasperReports compilation
- ➕ Auto-compile `.jrxml` to `.jasper` on-the-fly di semua 6 laporan
- ➕ JVM arguments untuk Java 9+ compatibility

### Changed
- 🔄 Semua path gambar di `.jrxml` dari relative ke classpath (`/laporan/LOGO.png`)
- 🔄 Kode laporan sekarang compile `.jrxml` otomatis jika `.jasper` tidak ada

### Files Modified
- `src/transaksi/peminjaman.java` - Auto-compile laporan
- `src/transaksi/mutasi.java` - Auto-compile laporan
- `src/master/aset.java` - Auto-compile laporan
- `src/master/kategori.java` - Auto-compile laporan
- `src/master/member.java` - Auto-compile laporan
- `src/master/lokasi.java` - Auto-compile laporan
- `src/laporan/*.jrxml` - Path gambar classpath
- `nbproject/project.properties` - Tambah library & JVM args
- `Libraries/commons-beanutils-1.9.4.jar` - Library baru

### Commits
- `cfe0c52` - Fix image paths in .jrxml files to use classpath
- `abd7038` - Add CHANGELOG.md documenting all fixes and changes
- `4826726` - Add commons-beanutils library for JasperReports compilation
- `8edab7f` - Fix JasperReports: Auto-compile .jrxml to .jasper on-the-fly
- `c1c07db` - Fix hardcoded paths in .jrxml files
- `ab49f74` - Add JVM arguments for Java 9+ compatibility

---

## [2026-01-19] - Initial Release

### Added
- ✨ Sistem login dengan username/password
- ✨ CRUD Data Aset, Kategori, Lokasi, Member
- ✨ Transaksi Mutasi & Peminjaman
- ✨ Cetak Laporan PDF (JasperReports)
- ✨ Database MySQL dengan user `inventaris`
- ✨ Installer otomatis (`INSTALL.bat`)
- ✨ Quick launcher (`RUN.bat`)
- ✨ Dokumentasi lengkap (`README.md`)

### Technical
- Java 8+ compatibility
- MySQL 8.0 connector
- JasperReports 6.0.0
- NetBeans project structure
