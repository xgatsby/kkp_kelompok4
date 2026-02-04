
---

## 🖥️ Tampilan Umum Form

* Merupakan **form pengelolaan data mutasi aset** dalam aplikasi Java desktop.
* Sangat khas **Java Swing**, kemungkinan ditampilkan sebagai:

  * `JInternalFrame` di dalam Dashboard, atau
  * panel konten utama.
* Background **abu-abu terang** default Swing.
* Form ini berfungsi untuk **mencatat perpindahan aset** antar lokasi atau kondisi.

---

## 🏷️ Judul Form

* Di bagian atas form terdapat judul:
  **“FORM DATA MUTASI”**
* Karakteristik:

  * Huruf **kapital**
  * Warna **hitam**
  * Ukuran font lebih besar dari label input
* Menegaskan konteks transaksi mutasi.

---

## 🧾 Area Input Data Mutasi

Berbeda dari form master data, form mutasi bersifat **transaksional**, sehingga field lebih variatif.

### 🔹 Struktur Input

* Label di sisi kiri, field di sisi kanan
* Alignment lurus dan rapi
* Jarak antar field konsisten

### 🔹 Field yang Umumnya Ada

Berdasarkan fungsi mutasi aset, field biasanya meliputi:

* ID Mutasi
* Tanggal Mutasi
* Nama / Kode Aset
* Lokasi Asal
* Lokasi Tujuan
* Keterangan Mutasi

### 🔹 Jenis Komponen

* `JTextField` → ID, keterangan
* `JComboBox` → aset, lokasi asal, lokasi tujuan
* Kemungkinan `JFormattedTextField` atau input tanggal

➡️ Menunjukkan form ini lebih kompleks dibanding Kategori/Lokasi.

---

## 🔘 Tombol Aksi

Di bagian bawah form terdapat tombol kontrol, biasanya:

* **Simpan**
* **Batal / Reset**
* (Opsional) **Hapus** untuk pembatalan mutasi

### Karakteristik Tombol:

* Bentuk standar Swing
* Warna abu-abu
* Teks hitam
* Ukuran seragam
* Posisi mudah dijangkau

➡️ Tombol disesuaikan dengan konteks **transaksi**, bukan master data murni.

---

## 📊 Tabel Data Mutasi

Di bagian bawah form terdapat **tabel data mutasi**:

* Menggunakan `JTable`
* Background putih
* Header abu-abu
* Scrollbar vertikal
* Menampilkan histori mutasi aset

Kolom tabel umumnya:

* Tanggal
* Aset
* Lokasi Asal
* Lokasi Tujuan
* Keterangan

---

## 🎨 Warna & Gaya Visual

* Warna dominan:

  * Abu-abu (background)
  * Putih (field & tabel)
  * Hitam (teks)
* Tidak ada ikon atau warna aksen
* Gaya **klasik, serius, dan fungsional**

---

**Tampilan Umum:**
- Jendela aplikasi desktop dengan title bar hitam di bagian atas
- Latar belakang utama berwarna putih dengan border abu-abu di sekeliling
- Layout yang terorganisir dengan baik, fokus pada form input data mutasi aset

**Elemen-elemen Utama:**

**1. Header:**
- Teks "Halo, Selamat Datang !" di bagian kiri atas
- Search box dengan ikon magnifying glass di kanan atas
- Ikon "Branda" di pojok kanan atas

**2. Judul Form:**
- Teks "Form Data Mutasi" dengan font besar dan tebal, terpusat
- Garis horizontal tebal hitam di bawah judul sebagai pemisah visual

**3. Form Input:**
- **ID Mutasi:**
  - Label di kiri
  - Kotak input teks kosong
- **Lokasi Tujuan:**
  - Label di kanan
  - Kotak input teks kosong
- **Tanggal Mutasi:**
  - Label di kiri
  - Kotak input teks dengan ikon kalender di kanan
- **ID Aset:**
  - Label di kanan
  - Dropdown menu dengan teks "-- Pilih ID Aset --"
- **Lokasi Asal:**
  - Label di kiri
  - Dropdown menu dengan teks "-- Pilih Lokasi Asal --"

**4. Tabel Data:**
- Header kolom: ID Mutasi, Tanggal Mutasi, Lokasi Asal, Lokasi Tujuan, ID Aset
- Isi tabel: Satu baris data dengan informasi:
  - ID Mutasi: MTS002
  - Tanggal Mutasi: 2024-01-05
  - Lokasi Asal: Gudang Sekolah
  - Lokasi Tujuan: Laboratorium Komputer
  - ID Aset: AST005
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
Ini adalah form untuk mengelola data mutasi aset dalam sistem inventaris, dengan kemampuan untuk menambah, mengubah, menghapus, dan mencetak data mutasi. Form ini memungkinkan pengguna untuk merekam perpindahan aset dari satu lokasi ke lokasi lain, termasuk informasi tanggal mutasi dan identitas aset yang dipindahkan.