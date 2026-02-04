
---

## 🖥️ Tampilan Umum Form

* Merupakan **form transaksi peminjaman aset** dalam aplikasi Java desktop.
* Sangat khas **Java Swing**, kemungkinan ditampilkan sebagai:

  * `JInternalFrame` di dalam Dashboard, atau
  * panel konten utama.
* Background **abu-abu terang** default Swing.
* Form ini bersifat **transaksional**, bukan master data.

---

## 🏷️ Judul Form

* Di bagian atas form terdapat judul:
  **“FORM DATA PEMINJAMAN”**
* Karakteristik:

  * Huruf **kapital**
  * Warna **hitam**
  * Ukuran font lebih besar dari label field
* Menegaskan konteks transaksi peminjaman.

---

## 🧾 Area Input Data Peminjaman

Area input lebih kompleks dibanding form master data karena melibatkan **relasi antar data**.

### 🔹 Struktur Input

* Label di sisi kiri
* Field di sisi kanan
* Alignment rapi & konsisten

### 🔹 Field yang Umumnya Ada

Berdasarkan fungsi peminjaman aset, field biasanya meliputi:

* ID Peminjaman
* Tanggal Peminjaman
* Nama / ID Member
* Nama / Kode Aset
* Jumlah
* Tanggal Kembali
* Keterangan

### 🔹 Jenis Komponen

* `JTextField` → ID, jumlah, keterangan
* `JComboBox` → member, aset
* `JFormattedTextField` / date input → tanggal pinjam & kembali

➡️ Form ini terlihat **padat**, mencerminkan kompleksitas transaksi.

---

## 🔘 Tombol Aksi

Di bagian bawah form terdapat tombol kontrol transaksi, biasanya:

* **Simpan**
* **Batal / Reset**
* (Opsional) **Hapus** atau **Perpanjang**

### Karakteristik Tombol:

* Bentuk standar Swing
* Warna abu-abu default
* Teks hitam
* Ukuran seragam
* Posisi mudah diakses

---

## 📊 Tabel Data Peminjaman

Di bagian bawah form terdapat **tabel data peminjaman**:

* Menggunakan `JTable`
* Background putih
* Header abu-abu
* Scrollbar vertikal
* Menampilkan daftar transaksi peminjaman

Kolom tabel biasanya:

* ID Peminjaman
* Tanggal Pinjam
* Member
* Aset
* Jumlah
* Tanggal Kembali
* Status

---

## 🎨 Warna & Gaya Visual

* Warna dominan:

  * Abu-abu (background)
  * Putih (field & tabel)
  * Hitam (teks)
* Tidak ada ikon atau warna aksen
* Gaya **serius, administratif, dan fungsional**

---


**Tampilan Umum:**
- Jendela aplikasi desktop dengan title bar hitam di bagian atas
- Latar belakang utama berwarna putih dengan border abu-abu di sekeliling
- Layout yang terorganisir dengan baik, fokus pada form input data peminjaman aset

**Elemen-elemen Utama:**

**1. Header:**
- Teks "Halo, Selamat Datang !" di bagian kiri atas
- Search box dengan ikon magnifying glass di kanan atas
- Ikon "Branda" di pojok kanan atas

**2. Judul Form:**
- Teks "Form Data Peminjaman" dengan font besar dan tebal, terpusat
- Garis horizontal tebal hitam di bawah judul sebagai pemisah visual

**3. Form Input:**
- **ID Peminjam:**
  - Label di kiri
  - Kotak input teks kosong
- **Tanggal Masuk:**
  - Label di kanan
  - Kotak input teks dengan ikon kalender di kanan
- **Nama Member:**
  - Label di kiri
  - Dropdown menu dengan teks "-- Pilih Nama Member --"
- **Tanggal Keluar:**
  - Label di kanan
  - Kotak input teks dengan ikon kalender di kanan
- **Status:**
  - Label di kiri
  - Kotak input teks kosong
- **ID Aset:**
  - Label di kanan
  - Dropdown menu dengan teks "-- Pilih ID Aset --"

**4. Tabel Data:**
- Header kolom: ID Peminjam, Nama Member, Status, Tanggal Masuk, Tanggal Keluar, ID Aset
- Isi tabel: Satu baris data dengan informasi:
  - ID Peminjam: PMJ008
  - Nama Member: Hendra Wijaya
  - Status: Dikembalikan
  - Tanggal Masuk: 2024-01-25
  - Tanggal Keluar: 2024-01-26
  - ID Aset: AST010
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
Ini adalah form untuk mengelola data peminjaman aset dalam sistem inventaris, dengan kemampuan untuk menambah, mengubah, menghapus, dan mencetak data peminjaman. Form ini memungkinkan pengguna untuk merekam transaksi peminjaman aset, termasuk informasi peminjam, tanggal peminjaman dan pengembalian, serta status peminjaman. Tabel data menampilkan riwayat peminjaman yang sudah tercatat.