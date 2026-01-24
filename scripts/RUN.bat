@echo off
chcp 65001 >nul
color 0A
cls

echo ╔════════════════════════════════════════════════════════╗
echo ║     SISTEM INVENTARIS ASET SEKOLAH - LAUNCHER         ║
echo ╚════════════════════════════════════════════════════════╝
echo.

echo [1/3] Checking Java...
java -version >nul 2>&1
if %errorlevel% neq 0 (
    color 0C
    echo ❌ Java tidak ditemukan!
    echo.
    echo Silakan install Java JDK 8+ dari:
    echo https://www.oracle.com/java/technologies/downloads/
    echo.
    pause
    exit /b 1
)
echo ✓ Java terdeteksi

echo.
echo [2/3] Checking JAR file...
if not exist "dist\InventarisAsetSekolah.jar" (
    color 0C
    echo ❌ JAR file tidak ditemukan!
    echo.
    echo Silakan build dulu:
    echo 1. Jalankan BUILD.bat
    echo.
    pause
    exit /b 1
)
echo ✓ JAR file ditemukan

echo.
echo [3/3] Starting application...
echo.
echo ╔════════════════════════════════════════════════════════╗
echo ║              APLIKASI SEDANG BERJALAN                 ║
echo ║         Jangan tutup window ini!                      ║
echo ╚════════════════════════════════════════════════════════╝
echo.

REM Run dengan classpath eksplisit untuk memastikan library ter-load
java --add-opens java.base/java.util=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.lang.reflect=ALL-UNNAMED -cp "dist\InventarisAsetSekolah.jar;dist\lib\*" master.login

echo.
echo Aplikasi ditutup.
echo.
pause
