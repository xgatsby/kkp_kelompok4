@echo off
chcp 65001 >nul
color 0B
cls

echo ╔════════════════════════════════════════════════════════╗
echo ║        SISTEM INVENTARIS ASET SEKOLAH                 ║
echo ║                Quick Launcher                          ║
echo ╚════════════════════════════════════════════════════════╝
echo.

if exist "dist\InventarisAsetSekolah.jar" (
    echo ✓ Menjalankan aplikasi...
    echo.
    start java -jar "dist\InventarisAsetSekolah.jar"
    echo ✓ Aplikasi berhasil dijalankan!
    echo.
    echo Login: admin / admin123
    echo.
    timeout /t 3 >nul
    exit /b 0
) else (
    color 0C
    echo ❌ JAR file tidak ditemukan!
    echo.
    echo Silakan build dulu:
    echo 1. Jalankan INSTALL.bat, atau
    echo 2. Buka di NetBeans → Clean and Build
    echo.
    pause
    exit /b 1
)
