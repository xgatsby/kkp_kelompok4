-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 16 Jan 2026 pada 19.43
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventaris_aset`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `aset`
--

CREATE TABLE `aset` (
  `id_aset` varchar(11) NOT NULL,
  `nama_aset` varchar(100) NOT NULL,
  `kondisi` varchar(30) NOT NULL,
  `tanggal_masuk` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `aset`
--

INSERT INTO `aset` (`id_aset`, `nama_aset`, `kondisi`, `tanggal_masuk`) VALUES
('AST001', 'Meja Siswa', 'Baik', '2023-07-10'),
('AST002', 'Kursi Siswa', 'Baik', '2023-07-10'),
('AST003', 'Papan Tulis', 'Baik', '2023-07-12'),
('AST004', 'Proyektor LCD', 'Baik', '2023-08-01'),
('AST005', 'Komputer Laboratorium', 'Baik', '2023-08-05'),
('AST006', 'Printer Kantor', 'Rusak Ringan', '2023-09-15'),
('AST007', 'Lemari Arsip', 'Baik', '2023-09-20'),
('AST008', 'Bola Basket', 'Baik', '2023-10-02'),
('AST009', 'Mikroskop', 'Baik', '2023-10-10'),
('AST010', 'Kipas Angin', 'Rusak Ringan', '2023-11-01');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori`
--

CREATE TABLE `kategori` (
  `id_kategori` varchar(11) NOT NULL,
  `nama_kategori` varchar(50) NOT NULL,
  `keterangan` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama_kategori`, `keterangan`) VALUES
('KAT001', 'Alat Tulis', 'Perlengkapan alat tulis siswa dan guru'),
('KAT002', 'Buku Pelajaran', 'Buku pendukung kegiatan belajar mengajar'),
('KAT003', 'Seragam Sekolah', 'Seragam resmi siswa sesuai ketentuan sekolah'),
('KAT004', 'Peralatan Olahraga', 'Perlengkapan olahraga untuk kegiatan jasmani'),
('KAT005', 'Perlengkapan Pramuka', 'Atribut dan perlengkapan kegiatan pramuka'),
('KAT006', 'Alat Praktikum', 'Peralatan laboratorium untuk praktik siswa'),
('KAT007', 'Media Pembelajaran', 'Alat bantu pembelajaran di kelas'),
('KAT008', 'Peralatan Kebersihan', 'Perlengkapan kebersihan lingkungan sekolah'),
('KAT009', 'Alat Kesenian', 'Perlengkapan kegiatan seni dan budaya'),
('KAT010', 'Peralatan Kantor', 'Perlengkapan administrasi sekolah');

-- --------------------------------------------------------

--
-- Struktur dari tabel `lokasi`
--

CREATE TABLE `lokasi` (
  `id_lokasi` varchar(11) NOT NULL,
  `nama_lokasi` varchar(50) NOT NULL,
  `keterangan` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `lokasi`
--

INSERT INTO `lokasi` (`id_lokasi`, `nama_lokasi`, `keterangan`) VALUES
('LOK001', 'Ruang Kelas', 'Ruang kegiatan belajar mengajar siswa'),
('LOK002', 'Perpustakaan', 'Tempat penyimpanan dan peminjaman buku'),
('LOK003', 'Laboratorium IPA', 'Ruang praktikum ilmu pengetahuan alam'),
('LOK004', 'Laboratorium Komputer', 'Ruang praktik teknologi informasi'),
('LOK005', 'Ruang Guru', 'Ruang kerja dan administrasi guru'),
('LOK006', 'Ruang TU', 'Ruang tata usaha dan administrasi sekolah'),
('LOK007', 'UKS', 'Unit kesehatan sekolah untuk siswa'),
('LOK008', 'Gudang Sekolah', 'Tempat penyimpanan barang dan inventaris'),
('LOK009', 'Lapangan Olahraga', 'Area kegiatan olahraga dan upacara'),
('LOK010', 'Aula Sekolah', 'Ruang kegiatan dan pertemuan sekolah');

-- --------------------------------------------------------

--
-- Struktur dari tabel `member`
--

CREATE TABLE `member` (
  `id_member` varchar(11) NOT NULL,
  `nama_member` varchar(100) NOT NULL,
  `kontak` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `member`
--

INSERT INTO `member` (`id_member`, `nama_member`, `kontak`) VALUES
('MBR001', 'Andi Pratama', '081234567890'),
('MBR002', 'Budi Santoso', '082345678901'),
('MBR003', 'Citra Lestari', '083456789012'),
('MBR004', 'Dewi Anggraini', '084567890123'),
('MBR005', 'Eko Saputra', '085678901234'),
('MBR006', 'Fajar Nugroho', '086789012345'),
('MBR007', 'Gita Maharani', '087890123456'),
('MBR008', 'Hendra Wijaya', '088901234567'),
('MBR009', 'Intan Permata', '081998877665'),
('MBR010', 'Joko Susilo', '082112223334');

-- --------------------------------------------------------

--
-- Struktur dari tabel `mutasi`
--

CREATE TABLE `mutasi` (
  `id_mutasi` varchar(11) NOT NULL,
  `tanggal_mutasi` date NOT NULL,
  `lokasi_asal` varchar(50) NOT NULL,
  `lokasi_tujuan` varchar(50) NOT NULL,
  `id_aset` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `mutasi`
--

INSERT INTO `mutasi` (`id_mutasi`, `tanggal_mutasi`, `lokasi_asal`, `lokasi_tujuan`, `id_aset`) VALUES
('MTS001', '2024-01-03', 'Gudang Sekolah', 'Ruang Kelas', 'AST001'),
('MTS002', '2024-01-05', 'Gudang Sekolah', 'Laboratorium Komputer', 'AST005'),
('MTS003', '2024-01-08', 'Gudang Sekolah', 'Perpustakaan', 'AST003'),
('MTS004', '2024-01-12', 'Ruang Kelas', 'Aula Sekolah', 'AST004'),
('MTS005', '2024-01-15', 'Gudang Sekolah', 'Lapangan Olahraga', 'AST008'),
('MTS006', '2024-01-18', 'Laboratorium IPA', 'Ruang Kelas', 'AST009'),
('MTS007', '2024-01-20', 'Ruang TU', 'Ruang Guru', 'AST007'),
('MTS008', '2024-01-25', 'Gudang Sekolah', 'UKS', 'AST010'),
('MTS009', '2024-01-28', 'Gudang Sekolah', 'Laboratorium IPA', 'AST006'),
('MTS010', '2024-02-02', 'Aula Sekolah', 'Gudang Sekolah', 'AST002');

-- --------------------------------------------------------

--
-- Struktur dari tabel `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id_peminjaman` varchar(11) NOT NULL,
  `nama_member` varchar(11) NOT NULL,
  `tanggal_masuk` date NOT NULL,
  `tanggal_keluar` date DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  `id_aset` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `peminjaman`
--

INSERT INTO `peminjaman` (`id_peminjaman`, `nama_member`, `tanggal_masuk`, `tanggal_keluar`, `status`, `id_aset`) VALUES
('PMJ001', 'Andi Pratam', '2024-01-05', '2024-01-07', 'Dikembalikan', 'AST001'),
('PMJ002', 'Budi Santos', '2024-01-06', '2024-01-08', 'Dikembalikan', 'AST002'),
('PMJ003', 'Citra Lesta', '2024-01-10', '2024-01-13', 'Dipinjam', 'AST004'),
('PMJ004', 'Dewi Anggra', '2024-01-12', '2024-01-14', 'Dikembalikan', 'AST003'),
('PMJ005', 'Eko Saputra', '2024-01-15', '2024-01-18', 'Dipinjam', 'AST005'),
('PMJ006', 'Fajar Nugro', '2024-01-18', '2024-01-20', 'Dikembalikan', 'AST008'),
('PMJ007', 'Gita Mahara', '2024-01-22', '2024-01-25', 'Dipinjam', 'AST009'),
('PMJ008', 'Hendra Wija', '2024-01-25', '2024-01-26', 'Dikembalikan', 'AST010'),
('PMJ009', 'Intan Perma', '2024-01-28', '2024-01-31', 'Dipinjam', 'AST006'),
('PMJ010', 'Joko Susilo', '2024-02-01', '2024-02-03', 'Dikembalikan', 'AST007');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`username`, `password`) VALUES
('admin', 'admin123');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `aset`
--
ALTER TABLE `aset`
  ADD PRIMARY KEY (`id_aset`);

--
-- Indeks untuk tabel `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indeks untuk tabel `lokasi`
--
ALTER TABLE `lokasi`
  ADD PRIMARY KEY (`id_lokasi`);

--
-- Indeks untuk tabel `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id_member`);

--
-- Indeks untuk tabel `mutasi`
--
ALTER TABLE `mutasi`
  ADD PRIMARY KEY (`id_mutasi`);

--
-- Indeks untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id_peminjaman`),
  ADD KEY `id_member` (`nama_member`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
