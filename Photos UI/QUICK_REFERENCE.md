# 🚀 Quick Reference Guide - UI Screens

**Application:** Sistem Inventaris Aset Sekolah  
**For:** Developers & Designers

---

## 📱 Screen Quick Lookup

| Screen ID | Name | Category | Files |
|-----------|------|----------|-------|
| `login` | Login Screen | Authentication | Login.PNG, Login.md |
| `dashboard` | Dashboard | Navigation | Dashboard.PNG, Dashboard.md |
| `form_member` | Form Data Member | Master Data | Form Data Member.PNG, Form Data Member.md |
| `form_aset` | Form Data Aset | Master Data | Form Data Aset.PNG, form data aset.md |
| `form_kategori` | Form Data Kategori | Master Data | Form Data Kategori.PNG, form data kategori.md |
| `form_lokasi` | Form Data Lokasi | Master Data | Form Data Lokasi.PNG, form data lokasi.md |
| `form_peminjaman` | Form Data Peminjaman | Transaction | Form Data Peminjaman.PNG, form data peminjaman.md |
| `form_mutasi` | Form Data Mutasi | Transaction | Form Data Mutasi.PNG, form data mutasi.md |
| `report_aset` | Laporan Data Aset | Report | Laporan (print) Data Aset.PNG, laporan (print) data aset.md |
| `report_kategori` | Laporan Data Kategori | Report | Laporan (print) Data Kategori.PNG, laporan (print) data kategori.md |
| `report_lokasi` | Laporan Data Lokasi | Report | Laporan (print) Data Lokasi.PNG, laporan data lokasi_mutasi_peminjaman.md |
| `report_member` | Laporan Data Member | Report | Laporan (print) Data Member.PNG, laporan (print) data member.md |
| `report_peminjaman` | Laporan Data Peminjaman | Report | Laporan (print) Data Peminjaman.PNG, laporan data lokasi_mutasi_peminjaman.md |
| `report_mutasi` | Laporan Mutasi | Report | Laporan (print) Mutasi.PNG, laporan data lokasi_mutasi_peminjaman.md |

---

## 🎯 Common Patterns

### All CRUD Forms Include:
- ✅ Input fields (left-aligned labels, right-aligned inputs)
- ✅ Action buttons: SIMPAN, UBAH, HAPUS, BERSIKAN
- ✅ Data table with scrollbar
- ✅ Print icon
- ✅ Search functionality
- ✅ Date display

### All Reports Include:
- ✅ School logo and name header
- ✅ Report title
- ✅ Data table
- ✅ Print date footer
- ✅ JasperReports (JRXML) format

---

## 🔍 Search by Keyword

**Authentication:** login  
**Navigation:** dashboard, menu  
**Members:** form_member, report_member  
**Assets:** form_aset, report_aset  
**Categories:** form_kategori, report_kategori  
**Locations:** form_lokasi, report_lokasi  
**Loans:** form_peminjaman, report_peminjaman  
**Transfers:** form_mutasi, report_mutasi  

---

## 🛠️ Technology Reference

**UI Components:**
- JFrame, JPanel, JTextField, JPasswordField
- JButton, JTable, JScrollPane, JMenuBar

**Reporting:**
- JasperReports, JRXML templates

**Layout:**
- GroupLayout, GridBagLayout, BorderLayout

---

## 📊 Statistics

- **Total Screens:** 13
- **Master Data Forms:** 4
- **Transaction Forms:** 2
- **Reports:** 6
- **Total Files:** 28 (19 PNG + 8 MD + 1 Logo)

---

## 📂 File Organization

```
Photos UI/
├── Login.PNG & Login.md
├── Dashboard.PNG & Dashboard.md
├── Form Data Member.PNG & Form Data Member.md
├── Form Data Aset.PNG & form data aset.md
├── Form Data Kategori.PNG & form data kategori.md
├── Form Data Lokasi.PNG & form data lokasi.md
├── Form Data Peminjaman.PNG & form data peminjaman.md
├── Form Data Mutasi.PNG & form data mutasi.md
├── Laporan (print) Data Aset.PNG & laporan (print) data aset.md
├── Laporan (print) Data Kategori.PNG & laporan (print) data kategori.md
├── Laporan (print) Data Lokasi.PNG & laporan data lokasi_mutasi_peminjaman.md
├── Laporan (print) Data Member.PNG & laporan (print) data member.md
├── Laporan (print) Data Peminjaman.PNG
├── Laporan (print) Mutasi.PNG
├── Icon Print.PNG & Icon Print.md
└── LOGO_sekolah 62 jakarta.png
```

---

**Generated:** February 5, 2026  
**Version:** 1.0
