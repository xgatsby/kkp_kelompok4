@echo off
chcp 65001 >nul
color 0A
cls

echo ╔════════════════════════════════════════════════════════╗
echo ║         SETUP DATABASE INVENTARIS ASET                ║
echo ╚════════════════════════════════════════════════════════╝
echo.

REM Cek apakah Laragon MySQL sedang berjalan
echo [1/4] Checking MySQL service...
tasklist /FI "IMAGENAME eq mysqld.exe" 2>NUL | find /I /N "mysqld.exe">NUL
if "%ERRORLEVEL%"=="1" (
    echo ✗ MySQL tidak berjalan!
    echo.
    echo Silakan:
    echo 1. Buka Laragon
    echo 2. Klik "Start All"
    echo 3. Jalankan script ini lagi
    echo.
    pause
    exit /b 1
)
echo ✓ MySQL is running
echo.

REM Cari path MySQL otomatis
set MYSQL_PATH=
set DB_FILE=%~dp0..\Database\inventaris_aset.sql

REM Cek Laragon
if exist "C:\laragon\bin\mysql" (
    for /d %%i in ("C:\laragon\bin\mysql\*") do set MYSQL_PATH=%%i\bin
)

REM Cek XAMPP
if "%MYSQL_PATH%"=="" (
    if exist "C:\xampp\mysql\bin" set MYSQL_PATH=C:\xampp\mysql\bin
)

REM Cek MySQL standalone
if "%MYSQL_PATH%"=="" (
    if exist "C:\Program Files\MySQL\MySQL Server 8.0\bin" set MYSQL_PATH=C:\Program Files\MySQL\MySQL Server 8.0\bin
)

REM Jika tidak ketemu, coba pakai mysql dari PATH
if "%MYSQL_PATH%"=="" (
    where mysql >nul 2>&1
    if %ERRORLEVEL% EQU 0 (
        set MYSQL_PATH=mysql
        goto :found
    )
)

REM Jika masih tidak ketemu
if "%MYSQL_PATH%"=="" (
    color 0C
    echo ✗ MySQL tidak ditemukan!
    echo.
    echo Silakan install salah satu:
    echo 1. Laragon: https://laragon.org/download/
    echo 2. XAMPP: https://www.apachefriends.org/
    echo 3. MySQL: https://dev.mysql.com/downloads/mysql/
    echo.
    pause
    exit /b 1
)

:found

REM Cek apakah file SQL ada
echo [2/4] Checking database file...
if not exist "%DB_FILE%" (
    echo ✗ File database tidak ditemukan!
    echo   Lokasi: %DB_FILE%
    echo.
    pause
    exit /b 1
)
echo ✓ Database file found
echo.

REM Buat database dan user
echo [3/4] Creating database and user...
"%MYSQL_PATH%\mysql.exe" -u root -e "CREATE DATABASE IF NOT EXISTS inventaris_aset;"
"%MYSQL_PATH%\mysql.exe" -u root -e "CREATE USER IF NOT EXISTS 'inventaris'@'localhost' IDENTIFIED BY 'inventaris123';"
"%MYSQL_PATH%\mysql.exe" -u root -e "GRANT ALL PRIVILEGES ON inventaris_aset.* TO 'inventaris'@'localhost';"
"%MYSQL_PATH%\mysql.exe" -u root -e "FLUSH PRIVILEGES;"

if %ERRORLEVEL% NEQ 0 (
    echo ✗ Gagal membuat database/user
    echo.
    pause
    exit /b 1
)
echo ✓ Database and user created
echo.

REM Import database
echo [4/4] Importing database structure...
"%MYSQL_PATH%\mysql.exe" -u root inventaris_aset < "%DB_FILE%"

if %ERRORLEVEL% NEQ 0 (
    echo ✗ Gagal import database
    echo.
    pause
    exit /b 1
)
echo ✓ Database imported successfully
echo.

echo ╔════════════════════════════════════════════════════════╗
echo ║              SETUP BERHASIL! ✓                        ║
echo ╚════════════════════════════════════════════════════════╝
echo.
echo Database: inventaris_aset
echo Username: inventaris
echo Password: inventaris123
echo.
echo Anda sekarang bisa:
echo 1. Login phpMyAdmin dengan user root (password kosong)
echo 2. Atau jalankan aplikasi dengan RUN.bat
echo.
pause
