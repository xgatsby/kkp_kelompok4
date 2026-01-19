@echo off
chcp 65001 >nul
echo =====================================================
echo   INITIALIZE GIT REPOSITORY
echo =====================================================
echo.

echo [1/4] Checking Git...
where git >nul 2>&1
if %errorlevel% neq 0 (
    echo ❌ Git tidak ditemukan!
    echo    Download Git: https://git-scm.com/downloads
    pause
    exit /b 1
)
echo ✓ Git ditemukan

echo.
echo [2/4] Initialize Git Repository...
git init
if %errorlevel% neq 0 (
    echo ❌ Gagal initialize git!
    pause
    exit /b 1
)
echo ✓ Git repository initialized

echo.
echo [3/4] Add all files...
git add .
echo ✓ Files added

echo.
echo [4/4] Create initial commit...
git commit -m "Initial commit: Sistem Inventaris Aset Sekolah"
if %errorlevel% neq 0 (
    echo ❌ Gagal commit!
    pause
    exit /b 1
)
echo ✓ Initial commit created

echo.
echo =====================================================
echo ✓ Git repository siap!
echo.
echo Langkah selanjutnya:
echo 1. Buat repository di GitHub
echo 2. Jalankan command berikut (ganti USERNAME):
echo.
echo    git remote add origin https://github.com/USERNAME/InventarisAsetSekolah.git
echo    git branch -M main
echo    git push -u origin main
echo.
echo Atau baca file PUSH_TO_GITHUB.md untuk panduan lengkap
echo =====================================================
echo.
pause
