-- =====================================================
-- SETUP DATABASE INVENTARIS ASET SEKOLAH
-- =====================================================
-- Jalankan script ini di MySQL untuk setup database
-- Cara: mysql -u root -p < database_setup.sql
-- =====================================================

-- Buat database jika belum ada
CREATE DATABASE IF NOT EXISTS inventaris_aset;
USE inventaris_aset;

-- Buat user khusus untuk aplikasi (opsional, bisa skip jika ingin pakai root)
CREATE USER IF NOT EXISTS 'inventaris'@'localhost' IDENTIFIED BY 'inventaris123';
GRANT ALL PRIVILEGES ON inventaris_aset.* TO 'inventaris'@'localhost';
FLUSH PRIVILEGES;

-- Import struktur dan data dari file SQL yang sudah ada
SOURCE Database/inventaris_aset.sql;

-- Tampilkan info
SELECT 'Database berhasil dibuat!' as Status;
SELECT 'User: inventaris' as Info;
SELECT 'Password: inventaris123' as Info;
SELECT 'Database: inventaris_aset' as Info;
