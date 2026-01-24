@echo off
chcp 65001 >nul
color 0B
cls

echo ╔════════════════════════════════════════════════════════════════╗
echo ║                                                                ║
echo ║     ✅ FINAL CHECK SEBELUM COMMIT & PUSH                      ║
echo ║                                                                ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.
echo Script ini akan melakukan pengecekan akhir sebelum commit & push.
echo.
pause
cls

set ALL_OK=1

REM ============================================
REM CHECK 1: STRUKTUR FOLDER
REM ============================================
echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║ [1/6] Checking Folder Structure...                            ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.

set FOLDERS_OK=1

if exist "docs\" (
    echo ✅ docs/ ada
) else (
    echo ❌ docs/ TIDAK ADA
    set FOLDERS_OK=0
    set ALL_OK=0
)

if exist "scripts\" (
    echo ✅ scripts/ ada
) else (
    echo ❌ scripts/ TIDAK ADA
    set FOLDERS_OK=0
    set ALL_OK=0
)

if exist "config\" (
    echo ✅ config/ ada
) else (
    echo ❌ config/ TIDAK ADA
    set FOLDERS_OK=0
    set ALL_OK=0
)

if exist "src\" (
    echo ✅ src/ ada
) else (
    echo ❌ src/ TIDAK ADA
    set FOLDERS_OK=0
    set ALL_OK=0
)

if exist "Database\" (
    echo ✅ Database/ ada
) else (
    echo ❌ Database/ TIDAK ADA
    set FOLDERS_OK=0
    set ALL_OK=0
)

if exist "Libraries\" (
    echo ✅ Libraries/ ada
) else (
    echo ❌ Libraries/ TIDAK ADA
    set FOLDERS_OK=0
    set ALL_OK=0
)

echo.
pause
cls

REM ============================================
REM CHECK 2: DOKUMENTASI
REM ============================================
echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║ [2/6] Checking Documentation...                               ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.

set DOCS_OK=1

if exist "README.md" (
    echo ✅ README.md ada
) else (
    echo ❌ README.md TIDAK ADA
    set DOCS_OK=0
    set ALL_OK=0
)

if exist "README_FIRST.txt" (
    echo ✅ README_FIRST.txt ada
) else (
    echo ❌ README_FIRST.txt TIDAK ADA
    set DOCS_OK=0
    set ALL_OK=0
)

if exist "docs\QUICK_START.md" (
    echo ✅ docs\QUICK_START.md ada
) else (
    echo ❌ docs\QUICK_START.md TIDAK ADA
    set DOCS_OK=0
    set ALL_OK=0
)

if exist "docs\SETUP_GUIDE.md" (
    echo ✅ docs\SETUP_GUIDE.md ada
) else (
    echo ❌ docs\SETUP_GUIDE.md TIDAK ADA
    set DOCS_OK=0
    set ALL_OK=0
)

if exist "docs\FOLDER_STRUCTURE.md" (
    echo ✅ docs\FOLDER_STRUCTURE.md ada
) else (
    echo ❌ docs\FOLDER_STRUCTURE.md TIDAK ADA
    set DOCS_OK=0
    set ALL_OK=0
)

if exist "JAWABAN_PERTANYAAN.md" (
    echo ✅ JAWABAN_PERTANYAAN.md ada
) else (
    echo ❌ JAWABAN_PERTANYAAN.md TIDAK ADA
    set DOCS_OK=0
    set ALL_OK=0
)

echo.
pause
cls

REM ============================================
REM CHECK 3: SCRIPTS
REM ============================================
echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║ [3/6] Checking Scripts...                                     ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.

set SCRIPTS_OK=1

if exist "START_HERE.bat" (
    echo ✅ START_HERE.bat ada
) else (
    echo ❌ START_HERE.bat TIDAK ADA
    set SCRIPTS_OK=0
    set ALL_OK=0
)

if exist "QUICK_TEST.bat" (
    echo ✅ QUICK_TEST.bat ada
) else (
    echo ❌ QUICK_TEST.bat TIDAK ADA
    set SCRIPTS_OK=0
    set ALL_OK=0
)

if exist "TEST_SEMUA.bat" (
    echo ✅ TEST_SEMUA.bat ada
) else (
    echo ❌ TEST_SEMUA.bat TIDAK ADA
    set SCRIPTS_OK=0
    set ALL_OK=0
)

if exist "scripts\SETUP_OTOMATIS.bat" (
    echo ✅ scripts\SETUP_OTOMATIS.bat ada
) else (
    echo ❌ scripts\SETUP_OTOMATIS.bat TIDAK ADA
    set SCRIPTS_OK=0
    set ALL_OK=0
)

if exist "scripts\INSTALL.bat" (
    echo ✅ scripts\INSTALL.bat ada
) else (
    echo ❌ scripts\INSTALL.bat TIDAK ADA
    set SCRIPTS_OK=0
    set ALL_OK=0
)

if exist "scripts\BUILD.bat" (
    echo ✅ scripts\BUILD.bat ada
) else (
    echo ❌ scripts\BUILD.bat TIDAK ADA
    set SCRIPTS_OK=0
    set ALL_OK=0
)

if exist "scripts\RUN.bat" (
    echo ✅ scripts\RUN.bat ada
) else (
    echo ❌ scripts\RUN.bat TIDAK ADA
    set SCRIPTS_OK=0
    set ALL_OK=0
)

if exist "scripts\SETUP_DATABASE.bat" (
    echo ✅ scripts\SETUP_DATABASE.bat ada
) else (
    echo ❌ scripts\SETUP_DATABASE.bat TIDAK ADA
    set SCRIPTS_OK=0
    set ALL_OK=0
)

echo.
pause
cls

REM ============================================
REM CHECK 4: GITIGNORE
REM ============================================
echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║ [4/6] Checking .gitignore...                                  ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.

if exist ".gitignore" (
    echo ✅ .gitignore ada
    
    REM Check if .gitignore contains important entries
    findstr /C:"build/" .gitignore >nul 2>&1
    if %errorlevel% equ 0 (
        echo ✅ .gitignore contains build/
    ) else (
        echo ⚠️  .gitignore tidak contain build/
    )
    
    findstr /C:"dist/" .gitignore >nul 2>&1
    if %errorlevel% equ 0 (
        echo ✅ .gitignore contains dist/
    ) else (
        echo ⚠️  .gitignore tidak contain dist/
    )
) else (
    echo ❌ .gitignore TIDAK ADA
    set ALL_OK=0
)

echo.
pause
cls

REM ============================================
REM CHECK 5: SOURCE CODE
REM ============================================
echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║ [5/6] Checking Source Code...                                 ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.

set SOURCE_OK=1

if exist "src\koneksi\koneksi.java" (
    echo ✅ src\koneksi\koneksi.java ada
) else (
    echo ❌ src\koneksi\koneksi.java TIDAK ADA
    set SOURCE_OK=0
    set ALL_OK=0
)

if exist "src\master\login.java" (
    echo ✅ src\master\login.java ada
) else (
    echo ❌ src\master\login.java TIDAK ADA
    set SOURCE_OK=0
    set ALL_OK=0
)

if exist "Database\inventaris_aset.sql" (
    echo ✅ Database\inventaris_aset.sql ada
) else (
    echo ❌ Database\inventaris_aset.sql TIDAK ADA
    set SOURCE_OK=0
    set ALL_OK=0
)

echo.
pause
cls

REM ============================================
REM CHECK 6: GIT STATUS
REM ============================================
echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║ [6/6] Checking Git Status...                                  ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.

git --version >nul 2>&1
if %errorlevel% equ 0 (
    echo ✅ Git terinstall
    echo.
    echo Status Git:
    echo ════════════════════════════════════════════════════════════════
    git status --short
    echo ════════════════════════════════════════════════════════════════
) else (
    echo ⚠️  Git tidak terinstall
    echo    Install Git: https://git-scm.com/download/win
)

echo.
pause
cls

REM ============================================
REM HASIL AKHIR
REM ============================================
echo.
echo ╔════════════════════════════════════════════════════════════════╗
echo ║                    📊 HASIL FINAL CHECK                       ║
echo ╚════════════════════════════════════════════════════════════════╝
echo.

if %ALL_OK%==1 (
    color 0A
    echo ✅✅✅ SEMUA CHECK PASSED! ✅✅✅
    echo.
    echo 🎉 Repository siap untuk commit & push!
    echo.
    echo 📤 Langkah selanjutnya:
    echo.
    echo    1. git add .
    echo    2. git commit -m "Reorganisasi struktur repository dan update dokumentasi"
    echo    3. git push origin main
    echo.
    echo 📖 Atau baca: docs\internal\CARA_COMMIT_PERUBAHAN.txt
    echo.
) else (
    color 0C
    echo ❌❌❌ ADA FILE YANG KURANG! ❌❌❌
    echo.
    echo 📋 Cek kembali file yang ditandai ❌ di atas
    echo.
    echo 📖 Baca: docs\internal\STRUKTUR_REPOSITORY.txt
    echo.
)

echo ════════════════════════════════════════════════════════════════
echo.
pause
