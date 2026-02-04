
---

## 🖥️ Tampilan Umum Form

* Merupakan **form pengelolaan data lokasi** dalam aplikasi Java desktop.
* Sangat khas **Java Swing**, kemungkinan ditampilkan sebagai:

  * `JInternalFrame` di dalam Dashboard, atau
  * panel konten utama.
* Background **abu-abu terang** default Swing.
* Tampilan bersih, fokus pada **input dan pengelolaan data lokasi**.

---

## 🏷️ Judul Form

* Di bagian atas form terdapat judul:
  **“FORM DATA LOKASI”**
* Karakteristik judul:

  * Huruf **kapital**
  * Warna **hitam**
  * Ukuran font lebih besar dari label field
* Berfungsi sebagai penanda halaman aktif.

---

## 🧾 Area Input Data Lokasi

Form input disusun **ringkas dan rapi**, karena data lokasi umumnya sederhana.

### 🔹 Struktur Input

* Setiap baris terdiri dari:

  * **Label di sisi kiri**
  * **Field input di sisi kanan**
* Alignment lurus dan konsisten.

### 🔹 Field yang Umumnya Ada

Berdasarkan konteks manajemen lokasi, field biasanya meliputi:

* ID Lokasi
* Nama Lokasi
* Keterangan / Deskripsi Lokasi

### Karakteristik Field:

* Menggunakan `JTextField`
* Warna putih
* Border standar Swing
* Ukuran field seragam
* Jarak antar field proporsional

---

## 🔘 Tombol Aksi (CRUD)

Di bagian bawah form terdapat **tombol kontrol data**, umumnya:

* **Tambah**
* **Simpan**
* **Ubah**
* **Hapus**
* **Batal / Reset**

### Karakteristik Tombol:

* Bentuk persegi panjang standar Swing
* Warna abu-abu default
* Teks hitam
* Ukuran seragam
* Disusun horizontal

➡️ Pola tombol **konsisten** dengan Form Data Kategori dan form lainnya.

---

## 📊 Tabel Data Lokasi

Di bawah atau di samping area input terdapat **tabel data lokasi**:

* Menggunakan `JTable`
* Background putih
* Header tabel abu-abu
* Scrollbar vertikal
* Menampilkan daftar lokasi yang sudah tersimpan

Fungsi tabel:

* Melihat data lokasi
* Memilih data untuk diedit atau dihapus
* Mendukung proses CRUD

---

## 🎨 Warna & Gaya Visual

* Warna dominan:

  * Abu-abu (background)
  * Putih (field & tabel)
  * Hitam (teks)
* Tidak ada ikon, warna aksen, atau animasi
* Gaya **klasik & fungsional**

---

**Tampilan Umum:**
- Jendela aplikasi desktop dengan title bar hitam di bagian atas
- Latar belakang utama berwarna putih dengan border abu-abu di sekeliling
- Layout yang terorganisir dengan baik, fokus pada form input data lokasi

**Elemen-elemen Utama:**

**1. Header:**
- Teks "Halo, Selamat Datang !" di bagian kiri atas
- Search box dengan ikon magnifying glass di kanan atas
- Ikon "Branda" di pojok kanan atas

**2. Judul Form:**
- Teks "Form Data Lokasi" dengan font besar dan tebal, terpusat
- Garis horizontal tebal hitam di bawah judul sebagai pemisah visual

**3. Form Input:**
- **ID Lokasi:**
  - Label di kiri
  - Kotak input teks kosong
- **Keterangan:**
  - Label di kanan
  - Kotak input teks kosong
- **Nama Lokasi:**
  - Label di kiri
  - Kotak input teks kosong

**4. Tabel Data:**
- Header kolom: ID Lokasi, Nama Lokasi, Keterangan
- Isi tabel: Satu baris data dengan informasi:
  - ID Lokasi: LOK001
  - Nama Lokasi: Ruang Kelas
  - Keterangan: Ruang kegiatan belajar mengajar siswa
- Ikon printer di kanan atas tabel

**5. Tombol Aksi:**
- **SIMPAN** (kiri)
- **UBAH** (tengah kiri)
- **HAPUS** (tengah kanan)
- **BERSIKAN** (kanan)
- Semua tombol berwarna abu-abu dengan teks hitam

**6. Informasi Tanggal:**
- Teks "Rabu, 04 Februari 2026" di pojok kanan bawah

**Fungsi:**
Ini adalah form untuk mengelola data lokasi dalam sistem inventaris aset, dengan kemampuan untuk menambah, mengubah, menghapus, dan mencetak data lokasi. Form ini juga menampilkan data lokasi yang sudah ada dalam tabel untuk referensi, termasuk informasi deskripsi atau keterangan tentang setiap lokasi tempat aset disimpan atau digunakan.