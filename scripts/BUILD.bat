@echo off
chcp 65001 >nul
color 0A
cls

echo ╔════════════════════════════════════════════════════════╗
echo ║          BUILD SCRIPT - TANPA NETBEANS                ║
echo ║        Compile Java Project Secara Manual             ║
echo ╚════════════════════════════════════════════════════════╝
echo.

echo [1/6] Checking Java...
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
echo [2/6] Cleaning old build...
if exist build rmdir /s /q build
if exist dist rmdir /s /q dist
mkdir build\classes
mkdir dist
echo ✓ Clean complete

echo.
echo [3/6] Compiling Java files...
echo Ini akan memakan waktu beberapa saat...

javac -encoding UTF-8 -source 8 -target 8 ^
    -d build\classes ^
    -cp "Libraries\*" ^
    src\koneksi\*.java ^
    src\master\*.java ^
    src\transaksi\*.java

if %errorlevel% neq 0 (
    color 0C
    echo.
    echo ❌ Compilation failed!
    echo.
    pause
    exit /b 1
)
echo ✓ Compilation successful

echo.
echo [4/6] Copying resources...
xcopy /E /I /Y src\icon build\classes\icon >nul
xcopy /E /I /Y src\laporan build\classes\laporan >nul
echo ✓ Resources copied

echo.
echo [5/6] Creating JAR file...
cd build\classes
jar cvfm ..\..\dist\InventarisAsetSekolah.jar ..\..\manifest.mf . >nul
cd ..\..
echo ✓ JAR created

echo.
echo [6/6] Copying libraries...
mkdir dist\lib
xcopy /Y Libraries\*.jar dist\lib\ >nul
echo ✓ Libraries copied

echo.
echo ╔════════════════════════════════════════════════════════╗
echo ║              BUILD SUCCESSFUL! ✓                      ║
echo ╚════════════════════════════════════════════════════════╝
echo.
echo JAR file: dist\InventarisAsetSekolah.jar
echo.
echo Untuk menjalankan:
echo   java -jar dist\InventarisAsetSekolah.jar
echo.
echo Atau gunakan:
echo   RUN.bat
echo.
pause
