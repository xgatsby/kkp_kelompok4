@echo off
chcp 65001 >nul
color 0B
cls

echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║                                                                ║
echo ║     🎯 SELAMAT DATANG DI SISTEM INVENTARIS ASET SEKOLAH      ║
echo ║                                                                ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.
echo.
echo   Pilih opsi setup:
echo.
echo   ┌────────────────────────────────────────────────────────────┐
echo   │                                                            │
echo   │  [1] 🚀 SETUP OTOMATIS (Recommended)                      │
echo   │      → Auto-detect semua, setup database, build, run      │
echo   │      → Paling mudah untuk pemula!                         │
echo   │                                                            │
echo   │  [2] 📦 SETUP MANUAL                                      │
echo   │      → Untuk yang sudah install Java + MySQL              │
echo   │      → Lebih cepat jika prasyarat sudah ada               │
echo   │                                                            │
echo   │  [3] ▶️  JALANKAN APLIKASI                                │
echo   │      → Jika sudah pernah setup sebelumnya                 │
echo   │                                                            │
echo   │  [4] 🧪 TEST KONEKSI DATABASE                             │
echo   │      → Cek apakah database sudah siap                     │
echo   │                                                            │
echo   │  [5] 📚 BUKA DOKUMENTASI                                  │
echo   │      → Panduan lengkap aplikasi                           │
echo   │                                                            │
echo   │  [6] ❌ KELUAR                                            │
echo   │                                                            │
echo   └────────────────────────────────────────────────────────────┘
echo.
echo.
set /p choice="   Pilih [1-6]: "

if "%choice%"=="1" goto setup_auto
if "%choice%"=="2" goto setup_manual
if "%choice%"=="3" goto run_app
if "%choice%"=="4" goto test_db
if "%choice%"=="5" goto docs
if "%choice%"=="6" goto exit

echo.
echo   ❌ Pilihan tidak valid!
timeout /t 2 >nul
goto start

:setup_auto
cls
echo.
echo   🚀 Menjalankan Setup Otomatis...
echo.
timeout /t 2 >nul
call scripts\SETUP_OTOMATIS.bat
goto end

:setup_manual
cls
echo.
echo   📦 Menjalankan Setup Manual...
echo.
timeout /t 2 >nul
call scripts\INSTALL.bat
goto end

:run_app
cls
echo.
echo   ▶️  Menjalankan Aplikasi...
echo.
timeout /t 2 >nul
call scripts\RUN.bat
goto end

:test_db
cls
echo.
echo   🧪 Testing Koneksi Database...
echo.
timeout /t 2 >nul
call scripts\TEST_CONNECTION.bat
pause
goto start

:docs
cls
echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║                    📚 DOKUMENTASI                             ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.
echo   File dokumentasi yang tersedia:
echo.
echo   1. docs\QUICK_START.md
echo      → Setup 1 menit (paling cepat!)
echo.
echo   2. docs\SETUP_GUIDE.md
echo      → Panduan lengkap + troubleshooting
echo.
echo   3. README.md
echo      → Overview project & fitur
echo.
echo   4. docs\CHECKLIST_SEBELUM_PUSH.md
echo      → Untuk maintainer/lead
echo.
echo   5. docs\ANNOUNCEMENT_TEMPLATE.txt
echo      → Template pengumuman
echo.
echo   6. docs\FOLDER_STRUCTURE.md
echo      → Struktur folder repository
echo.
echo.
echo   Buka file mana? [1-6] atau [0] untuk kembali
set /p doc_choice="   Pilih: "

if "%doc_choice%"=="1" start docs\QUICK_START.md
if "%doc_choice%"=="2" start docs\SETUP_GUIDE.md
if "%doc_choice%"=="3" start README.md
if "%doc_choice%"=="4" start docs\CHECKLIST_SEBELUM_PUSH.md
if "%doc_choice%"=="5" start docs\ANNOUNCEMENT_TEMPLATE.txt
if "%doc_choice%"=="6" start docs\FOLDER_STRUCTURE.md
if "%doc_choice%"=="0" goto start

timeout /t 2 >nul
goto start

:exit
cls
echo.
echo   👋 Terima kasih!
echo.
timeout /t 2 >nul
exit

:end
echo.
echo.
echo   Kembali ke menu? (Y/N)
set /p back="   Pilih: "
if /i "%back%"=="Y" goto start
exit
