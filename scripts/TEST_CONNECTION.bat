@echo off
chcp 65001 >nul
color 0A
cls

echo ╔════════════════════════════════════════════════════════╗
echo ║           TEST KONEKSI DATABASE                       ║
echo ╚════════════════════════════════════════════════════════╝
echo.

echo Testing database connection...
echo.

java -cp "dist\InventarisAsetSekolah.jar;dist\lib\*" koneksi.koneksi

echo.
echo Test selesai!
echo.
pause
