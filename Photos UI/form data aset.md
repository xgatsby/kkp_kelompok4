
---

## 🖥️ Tampilan Umum Form

* Merupakan **form pengelolaan data aset** dalam aplikasi Java desktop.
* Sangat khas **Java Swing** (kemungkinan `JInternalFrame` atau `JPanel` di dalam Dashboard).
* Background **abu-abu terang** default Swing.
* Fokus pada **manajemen data**, bukan dekorasi visual.

---

## 🏷️ Judul Form

* Di bagian atas terdapat judul:
  **“FORM DATA ASET”**
* Ciri judul:

  * Huruf **kapital**
  * Warna **hitam**
  * Font lebih besar dari label input
* Menegaskan bahwa halaman ini khusus untuk **pengelolaan aset**.

---

## 🧾 Area Input Data Aset

Form input tersusun **rapi dan terstruktur**, dengan pola:

* **Label di kiri**
* **Field input di kanan**
* Alignment lurus & konsisten antar baris

### 🔹 Jenis Field yang Terlihat / Umum Digunakan

Berdasarkan konteks form aset, field biasanya meliputi:

* ID Aset
* Nama Aset
* Jenis / Kategori Aset
* Jumlah
* Kondisi
* Keterangan / Deskripsi

### Karakteristik Field:

* Menggunakan `JTextField`
* Beberapa field kemungkinan:

  * `JComboBox` (jenis/kondisi)
* Ukuran field seragam
* Warna putih dengan border standar Swing

➡️ Layout menunjukkan penggunaan `GroupLayout`, `GridLayout`, atau `GridBagLayout`.

---

## 🔘 Tombol Aksi (CRUD)

Di bagian bawah atau samping form terdapat **tombol kontrol data**, biasanya:

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
* Disusun horizontal → mudah dijangkau user

➡️ Pola ini **konsisten** dengan Form Data Member.

---

## 📊 Tabel Data Aset

Di area bawah form terdapat **tabel data aset**:

* Menggunakan `JTable`
* Background tabel putih
* Header kolom abu-abu
* Scrollbar vertikal
* Menampilkan daftar aset yang sudah tersimpan

Fungsi tabel:

* Melihat data aset
* Klik data → tampil ke form untuk diedit
* Mendukung operasi update & delete

---

## 🎨 Warna & Gaya Visual

* Skema warna:

  * Abu-abu (background)
  * Putih (field & tabel)
  * Hitam (teks)
* Tidak ada ikon pada tombol
* Tidak ada highlight warna
* Tampilan **netral, sederhana, dan klasik**

---

**Tampilan Umum:**
- Jendela aplikasi desktop dengan title bar hitam di bagian atas
- Latar belakang utama berwarna putih dengan border abu-abu di sekeliling
- Layout yang terorganisir dengan baik, fokus pada form input data aset

**Elemen-elemen Utama:**

**1. Header:**
- Teks "Halo, Selamat Datang !" di bagian kiri atas
- Search box dengan ikon magnifying glass di kanan atas
- Ikon "Branda" di pojok kanan atas

**2. Judul Form:**
- Teks "Form Data Aset" dengan font besar dan tebal, terpusat
- Garis horizontal tebal hitam di bawah judul sebagai pemisah visual

**3. Form Input:**
- **ID Aset:**
  - Label di kiri
  - Kotak input teks kosong
- **Tanggal:**
  - Label di kanan
  - Kotak input teks dengan ikon kalender di kanan
- **Nama Aset:**
  - Label di kiri
  - Kotak input teks kosong
- **Kondisi:**
  - Label di kanan
  - Kotak input teks kosong

**4. Tabel Data:**
- Header kolom: ID Aset, Nama Aset, Tanggal Masuk, Kondisi
- Isi tabel: Satu baris data dengan informasi:
  - ID Aset: AST001
  - Nama Aset: Meja Siswa
  - Tanggal Masuk: 2023-07-10
  - Kondisi: Baik
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
Ini adalah form untuk mengelola data aset dalam sistem inventaris, dengan kemampuan untuk menambah, mengubah, menghapus, dan mencetak data aset. Form ini juga menampilkan data aset yang sudah ada dalam tabel untuk referensi, termasuk informasi tanggal masuk dan kondisi aset.