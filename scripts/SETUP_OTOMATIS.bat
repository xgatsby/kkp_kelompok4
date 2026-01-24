@echo off
chcp 65001 >nul
color 0A
cls

echo ╔════════════════════════════════════════════════════════════════╗
echo ║     🚀 ONE-CLICK SETUP - SISTEM INVENTARIS ASET SEKOLAH      ║
echo ║              Setup Otomatis & Mudah                           ║
echo ╔════════════════════════════════════════════════════════════════╝
echo.
echo [INFO] Script ini akan:
echo   ✓ Cek Java (install otomatis jika belum ada)
echo   ✓ Cek MySQL (panduan install jika belum ada)
echo   ✓ Setup database otomatis
echo   ✓ Build aplikasi
echo   ✓ Jalankan aplikasi
echo.
pause
cls

REM ============================================
REM STEP 1: CEK & INSTALL JAVA
REM ============================================
echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║ [1/5] Checking Java...                                        ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.

java -version >nul 2>&1
if %errorlevel% equ 0 (
    echo ✓ Java sudah terinstall
    java -version
    goto :mysql_check
)

echo ✗ Java belum terinstall!
echo.
echo [AUTO-INSTALL] Downloading Java JDK 11...
echo.

REM Download Java portable (tidak perlu install)
if not exist "tools" mkdir tools
if not exist "tools\jdk" (
    echo Downloading JDK... (ini akan memakan waktu beberapa menit)
    echo.
    echo [INFO] Silakan download manual dari:
    echo https://adoptium.net/temurin/releases/?version=11
    echo.
    echo Pilih: Windows x64 JDK .zip
    echo Extract ke folder: tools\jdk
    echo.
    echo Tekan tombol apapun setelah selesai download & extract...
    pause
)

REM Set JAVA_HOME temporary
set JAVA_HOME=%~dp0tools\jdk
set PATH=%JAVA_HOME%\bin;%PATH%

java -version >nul 2>&1
if %errorlevel% neq 0 (
    color 0C
    echo.
    echo ❌ Java masih belum terdeteksi!
    echo.
    echo Silakan install Java manual:
    echo 1. Download: https://adoptium.net/
    echo 2. Install dengan default settings
    echo 3. Restart CMD
    echo 4. Jalankan ulang script ini
    echo.
    pause
    exit /b 1
)

echo ✓ Java berhasil di-setup!

:mysql_check
REM ============================================
REM STEP 2: CEK MYSQL
REM ============================================
echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║ [2/5] Checking MySQL...                                       ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.

REM Cek apakah MySQL service running
tasklist /FI "IMAGENAME eq mysqld.exe" 2>NUL | find /I /N "mysqld.exe">NUL
if "%ERRORLEVEL%"=="0" (
    echo ✓ MySQL sudah running
    goto :database_setup
)

echo ✗ MySQL belum running!
echo.
echo [AUTO-DETECT] Mencari instalasi MySQL...

REM Cari MySQL di lokasi umum
set MYSQL_FOUND=0

if exist "C:\laragon\bin\mysql" (
    echo ✓ Ditemukan: Laragon MySQL
    echo.
    echo [ACTION] Silakan:
    echo 1. Buka Laragon
    echo 2. Klik "Start All"
    echo 3. Tekan tombol apapun untuk lanjut...
    pause
    set MYSQL_FOUND=1
    goto :database_setup
)

if exist "C:\xampp\mysql" (
    echo ✓ Ditemukan: XAMPP MySQL
    echo.
    echo [ACTION] Silakan:
    echo 1. Buka XAMPP Control Panel
    echo 2. Start MySQL
    echo 3. Tekan tombol apapun untuk lanjut...
    pause
    set MYSQL_FOUND=1
    goto :database_setup
)

if exist "C:\Program Files\MySQL" (
    echo ✓ Ditemukan: MySQL Standalone
    echo.
    echo [ACTION] Silakan start MySQL service:
    echo 1. Buka Services (Win+R → services.msc)
    echo 2. Cari "MySQL" → Start
    echo 3. Tekan tombol apapun untuk lanjut...
    pause
    set MYSQL_FOUND=1
    goto :database_setup
)

REM MySQL tidak ditemukan
color 0C
echo.
echo ❌ MySQL tidak ditemukan!
echo.
echo [REKOMENDASI] Install Laragon (Paling Mudah):
echo.
echo 1. Download: https://laragon.org/download/
echo 2. Install dengan default settings
echo 3. Buka Laragon → Start All
echo 4. Jalankan ulang script ini
echo.
echo Alternatif lain:
echo - XAMPP: https://www.apachefriends.org/
echo - MySQL: https://dev.mysql.com/downloads/mysql/
echo.
pause
exit /b 1

:database_setup
REM ============================================
REM STEP 3: SETUP DATABASE
REM ============================================
echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║ [3/5] Setting up Database...                                  ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.

REM Cari path MySQL
set MYSQL_PATH=
if exist "C:\laragon\bin\mysql" (
    for /d %%i in ("C:\laragon\bin\mysql\*") do set MYSQL_PATH=%%i\bin
)
if "%MYSQL_PATH%"=="" if exist "C:\xampp\mysql\bin" set MYSQL_PATH=C:\xampp\mysql\bin
if "%MYSQL_PATH%"=="" if exist "C:\Program Files\MySQL\MySQL Server 8.0\bin" set MYSQL_PATH=C:\Program Files\MySQL\MySQL Server 8.0\bin

if "%MYSQL_PATH%"=="" (
    where mysql >nul 2>&1
    if %ERRORLEVEL% EQU 0 (
        set MYSQL_CMD=mysql
        goto :run_sql
    )
    echo ✗ MySQL command tidak ditemukan di PATH
    goto :manual_db
)

set MYSQL_CMD="%MYSQL_PATH%\mysql.exe"

:run_sql
echo [INFO] Membuat database dan user...
%MYSQL_CMD% -u root -e "CREATE DATABASE IF NOT EXISTS inventaris_aset;" 2>nul
%MYSQL_CMD% -u root -e "CREATE USER IF NOT EXISTS 'inventaris'@'localhost' IDENTIFIED BY 'inventaris123';" 2>nul
%MYSQL_CMD% -u root -e "GRANT ALL PRIVILEGES ON inventaris_aset.* TO 'inventaris'@'localhost';" 2>nul
%MYSQL_CMD% -u root -e "FLUSH PRIVILEGES;" 2>nul

echo [INFO] Import data...
%MYSQL_CMD% -u root inventaris_aset < "Database\inventaris_aset.sql" 2>nul

if %ERRORLEVEL% EQU 0 (
    echo ✓ Database berhasil di-setup!
    goto :build_app
)

:manual_db
echo.
echo ⚠ Setup database otomatis gagal!
echo.
echo [MANUAL SETUP] Silakan jalankan perintah ini di MySQL:
echo.
echo CREATE DATABASE IF NOT EXISTS inventaris_aset;
echo CREATE USER IF NOT EXISTS 'inventaris'@'localhost' IDENTIFIED BY 'inventaris123';
echo GRANT ALL PRIVILEGES ON inventaris_aset.* TO 'inventaris'@'localhost';
echo FLUSH PRIVILEGES;
echo USE inventaris_aset;
echo SOURCE Database/inventaris_aset.sql;
echo.
echo Sudah selesai? (Y/N)
set /p confirm=
if /i "%confirm%" neq "Y" exit /b 1

:build_app
REM ============================================
REM STEP 4: BUILD APLIKASI
REM ============================================
echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║ [4/5] Building Application...                                 ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.

if exist "dist\InventarisAsetSekolah.jar" (
    echo ✓ JAR file sudah ada, skip build
    goto :run_app
)

echo [INFO] Compiling source code...
echo Ini akan memakan waktu beberapa saat...
echo.

REM Clean old build
if exist build rmdir /s /q build 2>nul
if exist dist rmdir /s /q dist 2>nul
mkdir build\classes 2>nul
mkdir dist 2>nul

REM Compile
javac -encoding UTF-8 -source 8 -target 8 ^
    -d build\classes ^
    -cp "Libraries\*" ^
    src\koneksi\*.java ^
    src\master\*.java ^
    src\transaksi\*.java 2>nul

if %errorlevel% neq 0 (
    color 0C
    echo ✗ Compilation failed!
    echo.
    echo Coba pakai NetBeans:
    echo 1. Buka NetBeans
    echo 2. File → Open Project
    echo 3. Clean and Build (Shift+F11)
    echo.
    pause
    exit /b 1
)

REM Copy resources
xcopy /E /I /Y src\icon build\classes\icon >nul 2>nul
xcopy /E /I /Y src\laporan build\classes\laporan >nul 2>nul

REM Create JAR
cd build\classes
jar cvfm ..\..\dist\InventarisAsetSekolah.jar ..\..\manifest.mf . >nul 2>nul
cd ..\..

REM Copy libraries
mkdir dist\lib 2>nul
xcopy /Y Libraries\*.jar dist\lib\ >nul 2>nul

echo ✓ Build successful!

:run_app
REM ============================================
REM STEP 5: JALANKAN APLIKASI
REM ============================================
echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║ [5/5] Starting Application...                                 ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.

echo ✓ Setup selesai!
echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║              🎉 APLIKASI SIAP DIGUNAKAN! 🎉                   ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.
echo 🔐 Login:
echo    Username: admin
echo    Password: admin123
echo.
echo 📚 Dokumentasi:
echo    - docs\QUICK_START.md
echo    - docs\SETUP_GUIDE.md
echo.
echo Tekan tombol apapun untuk menjalankan aplikasi...
pause

cls
echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║              APLIKASI SEDANG BERJALAN                         ║
echo ║         Jangan tutup window ini!                              ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.

java --add-opens java.base/java.util=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.lang.reflect=ALL-UNNAMED -cp "dist\InventarisAsetSekolah.jar;dist\lib\*" master.login

echo.
echo Aplikasi ditutup.
echo.
echo Untuk menjalankan lagi, gunakan: RUN.bat
echo.
pause
