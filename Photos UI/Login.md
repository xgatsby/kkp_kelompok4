## 🖥️ Tampilan Umum

* Aplikasi menggunakan **window desktop Java** (kemungkinan Swing).
* Latar belakang **abu-abu terang** khas default Swing.
* Ukuran jendela proporsional, tidak fullscreen.

---

## 🏷️ Judul Aplikasi

* Di bagian **atas tengah** terdapat judul:
  **“LOGIN”**
* Teks:

  * Huruf **kapital semua**
  * Warna **hitam**
  * Font standar (default Java, kemungkinan `SansSerif`)
* Judul cukup jelas tapi tampil **sederhana / polos**.

---

## 🧍‍♂️ Form Input

Form login berada di **tengah window**, terdiri dari dua field:

### 1️⃣ Username

* Label: **“Username”**
* Posisi label di **sebelah kiri** input field.
* Input field:

  * Bentuk persegi panjang
  * Background **putih**
  * Border standar Swing
  * Lebar cukup untuk input teks

### 2️⃣ Password

* Label: **“Password”**
* Posisi sejajar di bawah Username
* Input field:

  * Bertipe **password field** (karakter disamarkan dengan `*`)
  * Ukuran dan style sama dengan username (konsisten)

➡️ Alignment rapi secara vertikal, menunjukkan penggunaan layout manager (kemungkinan `GridLayout` atau `GroupLayout`).

---

## 🔘 Tombol Aksi

Di bawah form terdapat **dua tombol**:

### 🔹 Button “Login”

* Posisi **kiri**
* Warna default Swing (abu-abu)
* Fungsi: submit login

### 🔹 Button “Reset”

* Posisi **kanan**
* Ukuran sama dengan tombol Login
* Fungsi: mengosongkan field input

➡️ Tombol sejajar horizontal, jarak antar tombol cukup rapi.

---

## 🎨 Warna & Gaya Visual

* **Monokrom / default Swing**
* Tidak ada:

  * ikon
  * logo
  * warna aksen
  * animasi
* Fokus pada **fungsi**, bukan estetika.

---

## 📌 Kesan Keseluruhan

✅ **Kelebihan**

* Tampilan **bersih & mudah dipahami**
* Layout rapi dan konsisten
* Cocok untuk **aplikasi tugas / internal / akademik**

⚠️ **Kekurangan**

* Terlihat **sangat default**
* Kurang identitas visual
* Tidak ada feedback visual (misalnya error login)

---

**Tampilan Umum:**
- Ini adalah antarmuka login sederhana dengan desain minimalis
- Latar belakang utama berwarna putih
- Ada border abu-abu di sekeliling jendela aplikasi

**Elemen-elemen Utama:**

1. **Header:**
   - Judul "LOGIN" ditampilkan dengan huruf besar, tebal, dan berwarna hitam
   - Ada garis horizontal tebal hitam di bawah judul untuk pemisah visual

2. **Form Input:**
   - **Username Field:**
     - Label "Username" di sebelah kiri
     - Kotak input teks kosong di sebelah kanan label
     - Tidak ada placeholder text yang terlihat
   
   - **Password Field:**
     - Label "Password" di sebelah kiri
     - Kotak input teks kosong di sebelah kanan label
     - Tidak ada placeholder text yang terlihat

3. **Tombol Login:**
   - Tombol dengan teks "LOGIN" di tengah bawah form
   - Warna tombol abu-abu
   - Teks di dalam tombol berwarna hitam
   - Bentuk tombol persegi panjang dengan border

4. **Layout:**
   - Semua elemen terpusat secara vertikal
   - Jarak antar elemen rata dan terorganisir dengan baik
   - Desain clean dan sederhana, fokus pada fungsionalitas

5. **Jendela Aplikasi:**
   - Ada title bar hitam di bagian atas dengan ikon minimize, maximize, dan close (X) di pojok kanan
