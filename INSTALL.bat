@echo off
chcp 65001 >nul
color 0A
cls

echo ╔════════════════════════════════════════════════════════╗
echo ║     INSTALLER SISTEM INVENTARIS ASET SEKOLAH          ║
echo ║              One-Click Installation                    ║
echo ╚════════════════════════════════════════════════════════╝
echo.

echo [1/5] Checking Java...
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
echo [2/5] Checking MySQL...
where mysql >nul 2>&1
if %errorlevel% neq 0 (
    color 0C
    echo ❌ MySQL tidak ditemukan!
    echo.
    echo Silakan install MySQL dari:
    echo https://dev.mysql.com/downloads/mysql/
    echo.
    pause
    exit /b 1
)
echo ✓ MySQL terdeteksi

echo.
echo [3/5] Setup Database...
echo.
echo Masukkan password MySQL root Anda:
mysql -u root -p < database_setup.sql
if %errorlevel% neq 0 (
    color 0C
    echo ❌ Gagal setup database!
    echo.
    echo Coba jalankan manual:
    echo mysql -u root -p ^< database_setup.sql
    echo.
    pause
    exit /b 1
)
echo ✓ Database berhasil dibuat

echo.
echo [4/5] Checking NetBeans...
set NETBEANS_FOUND=0
if exist "C:\Program Files\NetBeans*\bin\netbeans64.exe" set NETBEANS_FOUND=1
if exist "C:\Program Files (x86)\NetBeans*\bin\netbeans64.exe" set NETBEANS_FOUND=1

echo.
echo [5/5] Build Project...
if exist "dist\InventarisAsetSekolah.jar" (
    echo ✓ JAR file sudah ada
) else (
    echo ⚠ JAR file belum ada
    echo   Silakan build dulu di NetBeans:
    echo   1. Buka project di NetBeans
    echo   2. Clean and Build (Shift+F11)
)

echo.
echo ╔════════════════════════════════════════════════════════╗
echo ║                  INSTALASI SELESAI!                    ║
echo ╚════════════════════════════════════════════════════════╝
echo.
echo Pilih cara menjalankan:
echo.
echo [1] Buka di NetBeans (Recommended)
echo [2] Jalankan JAR file langsung
echo [3] Exit
echo.
set /p choice="Pilihan (1/2/3): "

if "%choice%"=="1" (
    echo.
    echo Membuka NetBeans...
    echo Silakan:
    echo 1. File → Open Project
    echo 2. Pilih folder: %CD%
    echo 3. Run (F6)
    echo.
    echo Login: admin / admin123
    echo.
    pause
    exit /b 0
)

if "%choice%"=="2" (
    if exist "dist\InventarisAsetSekolah.jar" (
        echo.
        echo Menjalankan aplikasi...
        start java -jar "dist\InventarisAsetSekolah.jar"
        echo.
        echo Login: admin / admin123
        echo.
        pause
        exit /b 0
    ) else (
        color 0C
        echo.
        echo ❌ JAR file tidak ditemukan!
        echo    Build dulu di NetBeans
        echo.
        pause
        exit /b 1
    )
)

echo.
echo Terima kasih!
pause
