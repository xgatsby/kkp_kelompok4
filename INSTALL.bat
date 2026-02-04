@echo off
echo ========================================
echo INSTALASI SISTEM INVENTARIS ASET SEKOLAH
echo ========================================
echo.
echo Langkah 1: Setup Database
echo ----------------------------
echo Pastikan MySQL sudah terinstall dan berjalan
echo.
pause

echo.
echo Langkah 2: Import Database
echo ----------------------------
echo Jalankan file: Database/inventaris_aset.sql
echo Atau gunakan command:
echo mysql -u root -p < Database/inventaris_aset.sql
echo.
pause

echo.
echo Langkah 3: Konfigurasi Database
echo ----------------------------
echo Edit file: config/db.properties
echo Sesuaikan username dan password MySQL Anda
echo.
pause

echo.
echo Langkah 4: Build Project
echo ----------------------------
echo Buka project di NetBeans
echo Klik kanan project > Clean and Build
echo.
pause

echo.
echo Langkah 5: Run Project
echo ----------------------------
echo Klik kanan project > Run
echo Atau tekan F6
echo.
echo Login dengan:
echo Username: admin
echo Password: admin
echo.
pause

echo.
echo ========================================
echo INSTALASI SELESAI!
echo ========================================
echo.
echo Untuk troubleshooting, lihat:
echo - docs/SETUP_GUIDE.md
echo - docs/TROUBLESHOOTING_PRINT.md
echo.
pause