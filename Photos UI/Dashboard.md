---

## 🖥️ Tampilan Umum Dashboard

* Merupakan **window utama aplikasi Java desktop** (sangat kemungkinan **Java Swing**).
* Tampilan **lebih kompleks** dibanding halaman Login.
* Menggunakan **layout klasik aplikasi desktop**:
  👉 **menu di atas + konten di tengah**.
* Latar belakang dominan **abu-abu terang** (default Swing).

---

## 🧭 Menu Bar (Bagian Atas)

Di bagian paling atas terdapat **MenuBar** dengan beberapa menu:

### 📁 Menu yang terlihat

* **File**
* **Master Data**
* **Transaksi**
* **Laporan**
* **Logout**

➡️ Ciri khas `JMenuBar` Swing:

* Teks hitam
* Font standar
* Tidak ada ikon di menu

Menu ini menunjukkan aplikasi memiliki **alur data & proses bisnis**, bukan sekadar tampilan statis.

---

## 🏷️ Judul / Header Dashboard

* Di bagian atas area konten terdapat judul besar:
  **“DASHBOARD”**
* Karakteristik:

  * Huruf **kapital**
  * Warna **hitam**
  * Ukuran font lebih besar dari menu & isi
* Berfungsi sebagai **penanda halaman aktif**.

---

## 📄 Area Konten Utama

Bagian tengah dashboard relatif **kosong** / minimal konten, berfungsi sebagai:

* halaman utama setelah login
* landing page sebelum user memilih menu

Tidak terlihat:

* tabel
* grafik
* card statistik
* ikon navigasi

➡️ Ini umum pada aplikasi desktop yang:

* navigasinya berbasis **menu**
* konten muncul di **window / panel terpisah**

---

## 🧱 Layout & Struktur

* Struktur tampilan menunjukkan penggunaan:

  * `JFrame`
  * `JMenuBar`
  * `JPanel`
* Alignment lurus & simetris.
* Tidak ada sidebar kiri (berbeda dengan web dashboard modern).

---

## 🎨 Warna & Gaya Visual

* Warna:

  * Abu-abu (background)
  * Hitam (teks)
* **Tidak ada warna aksen**
* **Tidak ada ikon atau ilustrasi**
* Sangat mengandalkan **default Look & Feel Swing**

---

## 🧠 Kesan Fungsional

Dashboard ini terlihat seperti:

* aplikasi **administrasi / kasir / sistem informasi**
* fokus pada **fungsi dan menu**, bukan visual

---

**Tampilan Umum:**
- Ini adalah tampilan dashboard aplikasi desktop dengan layout dua kolom
- Latar belakang utama berwarna putih dengan border abu-abu di sekeliling jendela aplikasi
- Title bar hitam di bagian atas dengan ikon minimize, maximize, dan close (X) di pojok kanan

**Elemen-elemen Utama:**

**1. Sidebar Kiri (Menu Navigasi):**
- Background abu-abu muda
- Dibagi menjadi dua bagian menu utama:
  - **Form Data Master** (header menu)
    - Data Member (dengan ikon user)
    - Data Aset (dengan ikon dokumen)
    - Data Kategori (dengan ikon kategori)
    - Data Lokasi (dengan ikon lokasi)
  - **Form Data Transaksi** (header menu)
    - Peminjaman Aset (dengan ikon peminjaman)
    - Mutasi Aset (dengan ikon mutasi)

**2. Konten Utama (Area Tengah-Kanan):**
- **Judul Selamat Datang:**
  - Teks "Halo, Selamat Datang !" dengan font besar dan tebal
- **Subjudul Aplikasi:**
  - "Aplikasi Berbasis Desktop" di tengah
- **Judul Proyek:**
  - "PERANCANGAN SISTEM INVENTARIS ASET" dalam huruf besar tebal
  - "DI SMA NEGERI 62 JAKARTA" di bawahnya
- **Tanggal:**
  - "Minggu, 25 Januari 2026" di pojok kanan bawah

**Layout dan Desain:**
- Menu sidebar terorganisir dengan baik, setiap item memiliki ikon dan teks
- Konten utama berfokus pada informasi judul dan deskripsi aplikasi
- Warna yang digunakan: putih, abu-abu, hitam untuk teks
- Desain clean dan profesional, cocok untuk aplikasi sistem inventaris aset sekolah

Ini adalah tampilan dashboard utama setelah login, menampilkan menu navigasi dan informasi dasar tentang aplikasi sistem inventaris aset di SMA Negeri 62 Jakarta.