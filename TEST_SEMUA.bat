@echo off
chcp 65001 >nul
color 0E
cls

echo ╔════════════════════════════════════════════════════════════════╗
echo ║                                                                ║
echo ║     🧪 TEST KELENGKAPAN PRASYARAT                             ║
echo ║                                                                ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.
echo Script ini akan mengecek apakah semua prasyarat sudah terpenuhi.
echo.
pause
cls

set ALL_OK=1

REM ============================================
REM TEST 1: CEK JAVA
REM ============================================
echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║ [1/4] Testing Java...                                         ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.

java -version >nul 2>&1
if %errorlevel% equ 0 (
    echo ✅ Java TERDETEKSI
    java -version 2>&1 | findstr /C:"version"
    echo.
) else (
    echo ❌ Java TIDAK TERDETEKSI
    echo.
    echo 📥 Download: https://adoptium.net/
    echo.
    set ALL_OK=0
)

pause
cls

REM ============================================
REM TEST 2: CEK MYSQL
REM ============================================
echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║ [2/4] Testing MySQL...                                        ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.

REM Cek apakah MySQL service running
tasklist /FI "IMAGENAME eq mysqld.exe" 2>NUL | find /I /N "mysqld.exe">NUL
if "%ERRORLEVEL%"=="0" (
    echo ✅ MySQL SERVICE RUNNING
    echo.
) else (
    echo ❌ MySQL SERVICE TIDAK RUNNING
    echo.
    echo 💡 Solusi:
    echo    - Laragon: Buka Laragon → Start All
    echo    - XAMPP: Buka XAMPP Control → Start MySQL
    echo.
    set ALL_OK=0
)

REM Cek path MySQL
set MYSQL_FOUND=0
if exist "C:\laragon\bin\mysql" (
    echo ✅ MySQL PATH DITEMUKAN: Laragon
    set MYSQL_FOUND=1
)
if exist "C:\xampp\mysql\bin" (
    echo ✅ MySQL PATH DITEMUKAN: XAMPP
    set MYSQL_FOUND=1
)
if exist "C:\Program Files\MySQL\MySQL Server 8.0\bin" (
    echo ✅ MySQL PATH DITEMUKAN: MySQL Standalone
    set MYSQL_FOUND=1
)

if %MYSQL_FOUND%==0 (
    echo ❌ MySQL PATH TIDAK DITEMUKAN
    echo.
    echo 📥 Install salah satu:
    echo    - Laragon: https://laragon.org/download/
    echo    - XAMPP: https://www.apachefriends.org/
    echo.
    set ALL_OK=0
)

echo.
pause
cls

REM ============================================
REM TEST 3: CEK FILE PROJECT
REM ============================================
echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║ [3/4] Testing Project Files...                                ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.

set FILES_OK=1

if exist "src\" (
    echo ✅ Folder src/ ada
) else (
    echo ❌ Folder src/ TIDAK ADA
    set FILES_OK=0
    set ALL_OK=0
)

if exist "Libraries\" (
    echo ✅ Folder Libraries/ ada
) else (
    echo ❌ Folder Libraries/ TIDAK ADA
    set FILES_OK=0
    set ALL_OK=0
)

if exist "Database\inventaris_aset.sql" (
    echo ✅ File Database/inventaris_aset.sql ada
) else (
    echo ❌ File Database/inventaris_aset.sql TIDAK ADA
    set FILES_OK=0
    set ALL_OK=0
)

if exist "scripts\SETUP_OTOMATIS.bat" (
    echo ✅ Script installer ada
) else (
    echo ❌ Script installer TIDAK ADA
    set FILES_OK=0
    set ALL_OK=0
)

if %FILES_OK%==0 (
    echo.
    echo ⚠️  Pastikan Anda berada di folder root project!
    echo    Jalankan script ini dari folder: kkp_kelompok4\
)

echo.
pause
cls

REM ============================================
REM TEST 4: CEK NETBEANS (OPSIONAL)
REM ============================================
echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║ [4/4] Testing NetBeans (Optional)...                          ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.

set NETBEANS_FOUND=0
if exist "C:\Program Files\NetBeans*\bin\netbeans64.exe" set NETBEANS_FOUND=1
if exist "C:\Program Files (x86)\NetBeans*\bin\netbeans64.exe" set NETBEANS_FOUND=1

if %NETBEANS_FOUND%==1 (
    echo ✅ NetBeans TERDETEKSI
    echo    (Opsional, tapi recommended untuk development)
) else (
    echo ⚠️  NetBeans TIDAK TERDETEKSI
    echo    (Opsional, tapi recommended untuk development)
    echo.
    echo 📥 Download: https://netbeans.apache.org/download/
)

echo.
pause
cls

REM ============================================
REM HASIL AKHIR
REM ============================================
echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║                    📊 HASIL TEST                              ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.

if %ALL_OK%==1 (
    color 0A
    echo ✅✅✅ SEMUA PRASYARAT TERPENUHI! ✅✅✅
    echo.
    echo 🎉 Anda siap menjalankan aplikasi!
    echo.
    echo 🚀 Langkah selanjutnya:
    echo    1. Double-click: START_HERE.bat
    echo    2. Pilih: [1] Setup Otomatis
    echo    3. Atau langsung: scripts\SETUP_OTOMATIS.bat
    echo.
) else (
    color 0C
    echo ❌❌❌ ADA PRASYARAT YANG BELUM TERPENUHI ❌❌❌
    echo.
    echo 📋 Yang perlu dilakukan:
    echo.
    
    java -version >nul 2>&1
    if %errorlevel% neq 0 (
        echo    ❌ Install Java JDK 8+
        echo       → https://adoptium.net/
        echo.
    )
    
    tasklist /FI "IMAGENAME eq mysqld.exe" 2>NUL | find /I /N "mysqld.exe">NUL
    if "%ERRORLEVEL%"=="1" (
        echo    ❌ Start MySQL service
        echo       → Laragon: Start All
        echo       → XAMPP: Start MySQL
        echo.
    )
    
    echo 📖 Baca panduan lengkap: docs\SETUP_GUIDE.md
    echo.
)

echo ════════════════════════════════════════════════════════════════
echo.
pause
