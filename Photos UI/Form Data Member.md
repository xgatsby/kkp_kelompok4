## 🖥️ Tampilan Umum Form

* Merupakan **form input data** dalam aplikasi Java desktop (sangat khas **Java Swing**).
* Tampilan berada di dalam **window utama** (kemungkinan `JInternalFrame` atau panel).
* Latar belakang **abu-abu terang** default Swing.
* Fokus utama pada **input data member**, bukan visual dekoratif.

---

## 🏷️ Judul Form

* Di bagian atas terdapat judul:
  **“FORM DATA MEMBER”**
* Karakteristik:

  * Huruf **kapital**
  * Warna **hitam**
  * Ukuran font lebih besar dari label field
* Berfungsi sebagai penanda konteks halaman yang sedang aktif.

---

## 🧾 Area Input Data

Form berisi beberapa **field input** yang tersusun rapi secara vertikal:

### 🔹 Label & Field

* Setiap data memiliki:

  * **Label di sebelah kiri**
  * **Field input di sebelah kanan**
* Jenis field:

  * `JTextField` untuk data teks
  * kemungkinan `JComboBox` untuk pilihan (jika ada)
* Ukuran field seragam → menunjukkan konsistensi layout.

### 🔹 Contoh data yang biasanya muncul (berdasarkan struktur form):

* ID Member
* Nama Member
* Alamat
* No. Telepon
* (opsional) Jenis Kelamin / Status / Keterangan

➡️ Alignment rapi, jarak antar field konsisten, kemungkinan menggunakan `GroupLayout` atau `GridBagLayout`.

---

## 🔘 Tombol Aksi (Bagian Bawah Form)

Di bagian bawah form terdapat beberapa tombol kontrol, umumnya:

* **Tambah**
* **Simpan**
* **Ubah**
* **Hapus**
* **Batal / Reset**

### Karakteristik tombol:

* Bentuk standar Swing (persegi panjang)
* Warna abu-abu default
* Teks hitam
* Ukuran tombol relatif seragam
* Posisi sejajar horizontal

➡️ Tombol-tombol ini menunjukkan form bersifat **CRUD (Create, Read, Update, Delete)**.

---

## 📊 Tabel Data Member

Di bagian bawah atau samping form terdapat **tabel data**:

* Menggunakan `JTable`
* Kolom berisi data member yang sudah tersimpan
* Background putih
* Header tabel abu-abu
* Scrollbar vertikal di sisi kanan

Fungsi tabel:

* menampilkan data yang sudah diinput
* memilih data untuk diedit atau dihapus

---

## 🎨 Warna & Gaya Visual

* Warna dominan:

  * Abu-abu (background)
  * Putih (field & tabel)
  * Hitam (teks)
* Tidak ada:

  * ikon pada tombol
  * warna aksen
  * animasi
* Gaya **sangat fungsional & klasik**.

---

**Tampilan Umum:**
- Jendela aplikasi desktop dengan title bar hitam di bagian atas
- Latar belakang utama berwarna putih dengan border abu-abu di sekeliling
- Layout yang terorganisir dengan baik, fokus pada form input data member

**Elemen-elemen Utama:**

**1. Header:**
- Teks "Halo, Selamat Datang !" di bagian kiri atas
- Search box dengan ikon magnifying glass di kanan atas
- Ikon "Branda" di pojok kanan atas

**2. Judul Form:**
- Teks "Form Data Member" dengan font besar dan tebal, terpusat
- Garis horizontal tebal hitam di bawah judul sebagai pemisah visual

**3. Form Input:**
- **ID Member:**
  - Label di kiri
  - Kotak input teks dengan nilai "MBR002" yang sudah terisi
- **Nama Member:**
  - Label di kiri  
  - Kotak input teks kosong
- **Kontak:**
  - Label di kiri
  - Kotak input teks kosong

**4. Tabel Data:**
- Header kolom: ID Member, Nama Member, Kontak
- Isi tabel: Satu baris data dengan informasi:
  - ID Member: MBR001
  - Nama Member: Andi Pratama
  - Kontak: 081234567890
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
Ini adalah form untuk mengelola data member dalam sistem inventaris aset, dengan kemampuan untuk menambah, mengubah, menghapus, dan mencetak data member. Form ini juga menampilkan data member yang sudah ada dalam tabel untuk referensi.