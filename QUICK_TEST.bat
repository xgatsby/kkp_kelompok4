@echo off
REM Quick test - Cek prasyarat dalam 5 detik
chcp 65001 >nul 2>&1
color 0B

echo.
echo 🧪 Quick Test Prasyarat...
echo.

set OK=1

REM Test Java
java -version >nul 2>&1
if %errorlevel% equ 0 (
    echo ✅ Java: OK
) else (
    echo ❌ Java: NOT FOUND
    set OK=0
)

REM Test MySQL
tasklist /FI "IMAGENAME eq mysqld.exe" 2>NUL | find /I /N "mysqld.exe">NUL
if "%ERRORLEVEL%"=="0" (
    echo ✅ MySQL: RUNNING
) else (
    echo ❌ MySQL: NOT RUNNING
    set OK=0
)

REM Test Files
if exist "src\" (
    echo ✅ Files: OK
) else (
    echo ❌ Files: NOT FOUND
    set OK=0
)

echo.
if %OK%==1 (
    color 0A
    echo ✅ SIAP! Jalankan: START_HERE.bat
) else (
    color 0C
    echo ❌ BELUM SIAP! Jalankan: TEST_SEMUA.bat
)
echo.
timeout /t 3 >nul
