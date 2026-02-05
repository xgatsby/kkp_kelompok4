# 🗺️ UI Navigation Map

**Application:** Sistem Inventaris Aset Sekolah  
**Visual Flow Diagram**

---

## 📍 Application Flow

```
┌─────────────────────────────────────────────────────────────────┐
│                         LOGIN SCREEN                             │
│                                                                  │
│  Files: Login.PNG, Login.md                                     │
│  Components: Username, Password, LOGIN button                   │
│                                                                  │
│                    [Enter Credentials]                           │
└────────────────────────────┬────────────────────────────────────┘
                             │
                             ▼
┌─────────────────────────────────────────────────────────────────┐
│                         DASHBOARD                                │
│                                                                  │
│  Files: Dashboard.PNG, Dashboard.md                             │
│  Welcome Message + Navigation Menu                              │
│                                                                  │
│  ┌──────────────┬──────────────┬──────────────┬──────────────┐ │
│  │ Master Data  │  Transaksi   │   Laporan    │   Logout     │ │
│  └──────┬───────┴──────┬───────┴──────┬───────┴──────┬───────┘ │
└─────────┼──────────────┼──────────────┼──────────────┼─────────┘
          │              │              │              │
          ▼              ▼              ▼              ▼
    ┌─────────┐    ┌─────────┐    ┌─────────┐    [Back to
    │ Master  │    │ Trans-  │    │ Reports │     Login]
    │  Data   │    │ actions │    │         │
    └────┬────┘    └────┬────┘    └────┬────┘
         │              │              │
         │              │              │
    ┌────┴────┐    ┌────┴────┐    ┌────┴────┐
    │         │    │         │    │         │
    ▼         ▼    ▼         ▼    ▼         ▼
```

---

## 📂 Master Data Branch

```
MASTER DATA
    │
    ├─► FORM DATA MEMBER
    │   Files: Form Data Member.PNG, Form Data Member.md
    │   Fields: ID Member, Nama Member, Kontak
    │   Actions: SIMPAN, UBAH, HAPUS, BERSIKAN
    │   Features: Table, Search, Print
    │
    ├─► FORM DATA ASET
    │   Files: Form Data Aset.PNG, form data aset.md
    │   Purpose: Asset management and tracking
    │   Actions: SIMPAN, UBAH, HAPUS, BERSIKAN
    │   Features: Table, Search, Print
    │
    ├─► FORM DATA KATEGORI
    │   Files: Form Data Kategori.PNG, form data kategori.md
    │   Purpose: Category management for classification
    │   Actions: SIMPAN, UBAH, HAPUS, BERSIKAN
    │   Features: Table, Search, Print
    │
    └─► FORM DATA LOKASI
        Files: Form Data Lokasi.PNG, form data lokasi.md
        Purpose: Location management for tracking
        Actions: SIMPAN, UBAH, HAPUS, BERSIKAN
        Features: Table, Search, Print
```

---

## 🔄 Transactions Branch

```
TRANSAKSI
    │
    ├─► FORM DATA PEMINJAMAN
    │   Files: Form Data Peminjaman.PNG, form data peminjaman.md
    │   Purpose: Asset borrowing/loan management
    │   Actions: SIMPAN, UBAH, HAPUS, BERSIKAN
    │   Features: Table, Search, Print
    │
    └─► FORM DATA MUTASI
        Files: Form Data Mutasi.PNG, form data mutasi.md
        Purpose: Asset transfer/mutation management
        Actions: SIMPAN, UBAH, HAPUS, BERSIKAN
        Features: Table, Search, Print
```

---

## 📊 Reports Branch

```
LAPORAN
    │
    ├─► LAPORAN DATA ASET
    │   Files: Laporan (print) Data Aset.PNG, laporan (print) data aset.md
    │   Format: PDF with school logo, data table, print date
    │   Technology: JasperReports (JRXML)
    │
    ├─► LAPORAN DATA KATEGORI
    │   Files: Laporan (print) Data Kategori.PNG, laporan (print) data kategori.md
    │   Format: PDF with school logo, data table, print date
    │   Technology: JasperReports (JRXML)
    │
    ├─► LAPORAN DATA LOKASI
    │   Files: Laporan (print) Data Lokasi.PNG, laporan data lokasi_mutasi_peminjaman.md
    │   Format: PDF with school logo, data table, print date
    │   Technology: JasperReports (JRXML)
    │
    ├─► LAPORAN DATA MEMBER
    │   Files: Laporan (print) Data Member.PNG, laporan (print) data member.md
    │   Format: PDF with school logo, data table, print date
    │   Technology: JasperReports (JRXML)
    │
    ├─► LAPORAN DATA PEMINJAMAN
    │   Files: Laporan (print) Data Peminjaman.PNG, laporan data lokasi_mutasi_peminjaman.md
    │   Format: PDF with school logo, data table, print date
    │   Technology: JasperReports (JRXML)
    │
    └─► LAPORAN MUTASI
        Files: Laporan (print) Mutasi.PNG, laporan data lokasi_mutasi_peminjaman.md
        Format: PDF with school logo, data table, print date
        Technology: JasperReports (JRXML)
```

---

## 🎯 User Journey Examples

### Journey 1: Add New Member
```
Login → Dashboard → Master Data → Form Data Member → 
Fill Fields → SIMPAN → View in Table → Print Report
```

### Journey 2: Borrow Asset
```
Login → Dashboard → Transaksi → Form Data Peminjaman → 
Fill Fields → SIMPAN → View in Table → Print Report
```

### Journey 3: Generate Asset Report
```
Login → Dashboard → Laporan → Laporan Data Aset → 
View Report → Print/Export PDF
```

### Journey 4: Transfer Asset
```
Login → Dashboard → Transaksi → Form Data Mutasi → 
Fill Fields → SIMPAN → View in Table → Print Report
```

---

## 🔗 Screen Relationships

### Data Dependencies:
```
Member ──┐
         ├──► Peminjaman (Loan Transaction)
Aset ────┤
         └──► Mutasi (Transfer Transaction)

Kategori ──► Aset (Asset Classification)
Lokasi ────► Aset (Asset Location)
```

### Report Dependencies:
```
Form Data Member ──► Laporan Data Member
Form Data Aset ────► Laporan Data Aset
Form Data Kategori ─► Laporan Data Kategori
Form Data Lokasi ───► Laporan Data Lokasi
Form Data Peminjaman ─► Laporan Data Peminjaman
Form Data Mutasi ────► Laporan Mutasi
```

---

## 🎨 Common UI Elements Across Screens

### All Forms Share:
```
┌─────────────────────────────────────────┐
│ Header: Welcome + Search + Branda Icon  │
├─────────────────────────────────────────┤
│ Title: [FORM NAME]                      │
│ ─────────────────────────────────────── │
├─────────────────────────────────────────┤
│ Input Fields:                           │
│   Label 1: [Input Field]                │
│   Label 2: [Input Field]                │
│   Label 3: [Input Field]                │
├─────────────────────────────────────────┤
│ [SIMPAN] [UBAH] [HAPUS] [BERSIKAN]     │
├─────────────────────────────────────────┤
│ Data Table with Print Icon             │
│ ┌───────┬───────┬───────┐              │
│ │ Col 1 │ Col 2 │ Col 3 │              │
│ ├───────┼───────┼───────┤              │
│ │ Data  │ Data  │ Data  │              │
│ └───────┴───────┴───────┘              │
├─────────────────────────────────────────┤
│ Footer: Date Display                    │
└─────────────────────────────────────────┘
```

### All Reports Share:
```
┌─────────────────────────────────────────┐
│ [School Logo]  SMA NEGERI 62 JAKARTA   │
├─────────────────────────────────────────┤
│         LAPORAN [DATA TYPE]             │
├─────────────────────────────────────────┤
│ Data Table                              │
│ ┌───────┬───────┬───────┬───────┐      │
│ │ Col 1 │ Col 2 │ Col 3 │ Col 4 │      │
│ ├───────┼───────┼───────┼───────┤      │
│ │ Data  │ Data  │ Data  │ Data  │      │
│ │ Data  │ Data  │ Data  │ Data  │      │
│ └───────┴───────┴───────┴───────┘      │
├─────────────────────────────────────────┤
│ Print Date: [Date]                      │
└─────────────────────────────────────────┘
```

---

## 📱 Screen Access Matrix

| Screen | From Dashboard | Direct Access | Print Available |
|--------|---------------|---------------|-----------------|
| Login | No | Entry Point | No |
| Dashboard | - | After Login | No |
| Form Member | Master Data Menu | Yes | Yes |
| Form Aset | Master Data Menu | Yes | Yes |
| Form Kategori | Master Data Menu | Yes | Yes |
| Form Lokasi | Master Data Menu | Yes | Yes |
| Form Peminjaman | Transaksi Menu | Yes | Yes |
| Form Mutasi | Transaksi Menu | Yes | Yes |
| Report Aset | Laporan Menu | Yes | Yes |
| Report Kategori | Laporan Menu | Yes | Yes |
| Report Lokasi | Laporan Menu | Yes | Yes |
| Report Member | Laporan Menu | Yes | Yes |
| Report Peminjaman | Laporan Menu | Yes | Yes |
| Report Mutasi | Laporan Menu | Yes | Yes |

---

**Generated:** February 5, 2026  
**Version:** 1.0  
**Purpose:** Visual navigation reference for developers and designers
