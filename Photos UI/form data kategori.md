---

## 🖥️ Tampilan Umum Form

* Merupakan **form pengelolaan data kategori** dalam aplikasi Java desktop.
* Sangat khas **Java Swing**, kemungkinan ditampilkan sebagai:

  * `JInternalFrame` di dalam Dashboard, atau
  * panel konten utama.
* Latar belakang **abu-abu terang** default Swing.
* Tampilan sederhana, fokus pada **input dan pengelolaan data kategori**.

---

## 🏷️ Judul Form

* Di bagian atas form terdapat judul:
  **“FORM DATA KATEGORI”**
* Karakteristik judul:

  * Huruf **kapital**
  * Warna **hitam**
  * Ukuran font lebih besar dari label input
* Berfungsi sebagai penanda halaman aktif.

---

## 🧾 Area Input Data Kategori

Form input tersusun **ringkas dan rapi**, karena data kategori umumnya tidak terlalu banyak.

### 🔹 Struktur Input

* Setiap baris terdiri dari:

  * **Label di sisi kiri**
  * **Field input di sisi kanan**
* Alignment lurus dan konsisten.

### 🔹 Field yang Umumnya Ada

Berdasarkan konteks kategori aset, field biasanya meliputi:

* ID Kategori
* Nama Kategori
* Keterangan / Deskripsi

### Karakteristik Field:

* Menggunakan `JTextField`
* Warna putih
* Border standar Swing
* Ukuran field seragam
* Jarak antar field proporsional → mudah dibaca.

---

## 🔘 Tombol Aksi (CRUD)

Di bagian bawah form terdapat **tombol-tombol kontrol data**, biasanya:

* **Tambah**
* **Simpan**
* **Ubah**
* **Hapus**
* **Batal / Reset**

### Karakteristik Tombol:

* Bentuk persegi panjang standar Swing
* Warna abu-abu default
* Teks hitam
* Ukuran relatif sama
* Disusun sejajar horizontal

➡️ Pola tombol **identik** dengan Form Data Member & Aset, menunjukkan konsistensi desain.

---

## 📊 Tabel Data Kategori

Di bawah atau di samping area input terdapat **tabel data kategori**:

* Menggunakan `JTable`
* Background putih
* Header kolom abu-abu
* Scrollbar vertikal
* Menampilkan daftar kategori yang sudah tersimpan

Fungsi tabel:

* Menampilkan data kategori
* Memilih data untuk diedit atau dihapus
* Mendukung alur CRUD sepenuhnya

---

## 🎨 Warna & Gaya Visual

* Skema warna:

  * Abu-abu (background)
  * Putih (field & tabel)
  * Hitam (teks)
* Tidak ada ikon atau warna aksen
* Tidak ada animasi atau efek visual
* Gaya **klasik, netral, dan fungsional**

---

**Tampilan Umum:**
- Jendela aplikasi desktop dengan title bar hitam di bagian atas
- Latar belakang utama berwarna putih dengan border abu-abu di sekeliling
- Layout yang terorganisir dengan baik, fokus pada form input data kategori

**Elemen-elemen Utama:**

**1. Header:**
- Teks "Halo, Selamat Datang !" di bagian kiri atas
- Search box dengan ikon magnifying glass di kanan atas
- Ikon "Branda" di pojok kanan atas

**2. Judul Form:**
- Teks "Form Data Kategori" dengan font besar dan tebal, terpusat
- Garis horizontal tebal hitam di bawah judul sebagai pemisah visual

**3. Form Input:**
- **ID Kategori:**
  - Label di kiri
  - Kotak input teks kosong
- **Keterangan:**
  - Label di kanan
  - Kotak input teks kosong
- **Nama Kategori:**
  - Label di kiri
  - Kotak input teks kosong

**4. Tabel Data:**
- Header kolom: ID Kategori, Nama Kategori, Keterangan
- Isi tabel: Satu baris data dengan informasi:
  - ID Kategori: KAT001
  - Nama Kategori: Alat Tulis
  - Keterangan: Perlengkapan alat tulis siswa dan guru
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
Ini adalah form untuk mengelola data kategori aset dalam sistem inventaris, dengan kemampuan untuk menambah, mengubah, menghapus, dan mencetak data kategori. Form ini juga menampilkan data kategori yang sudah ada dalam tabel untuk referensi, termasuk informasi deskripsi atau keterangan tentang setiap kategori aset.