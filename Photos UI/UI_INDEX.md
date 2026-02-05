# 📋 UI Codebase Index - Sistem Inventaris Aset Sekolah

**Generated:** February 5, 2026  
**Application:** Inventaris Aset SMA Negeri 62 Jakarta  
**Technology:** Java Swing Desktop Application

---

## 🎯 Overview

This document provides a comprehensive semantic index of all UI screens in the Inventaris Aset Sekolah application. Each screen is documented with screenshots and detailed descriptions.

---

## 📊 UI Screen Categories

### 1. Authentication
- [Login Screen](#login-screen)

### 2. Main Navigation
- [Dashboard](#dashboard)

### 3. Master Data Forms
- [Form Data Member](#form-data-member)
- [Form Data Aset](#form-data-aset)
- [Form Data Kategori](#form-data-kategori)
- [Form Data Lokasi](#form-data-lokasi)

### 4. Transaction Forms
- [Form Data Peminjaman](#form-data-peminjaman)
- [Form Data Mutasi](#form-data-mutasi)

### 5. Reports (Print Views)
- [Laporan Data Aset](#laporan-data-aset)
- [Laporan Data Kategori](#laporan-data-kategori)
- [Laporan Data Lokasi](#laporan-data-lokasi)
- [Laporan Data Member](#laporan-data-member)
- [Laporan Data Peminjaman](#laporan-data-peminjaman-report)
- [Laporan Mutasi](#laporan-mutasi)

### 6. UI Components
- [Icon Print](#icon-print)

---

## 🔐 Login Screen

**Files:**
- Screenshot: `Login.PNG`
- Documentation: `Login.md`

**Purpose:** User authentication entry point

**Key Components:**
- Username input field
- Password input field (masked)
- LOGIN button
- Simple, minimalist design

**Technology:** Java Swing (JFrame, JTextField, JPasswordField, JButton)

**Visual Characteristics:**
- White background
- Black title "LOGIN"
- Gray buttons
- Centered layout
- No icons or branding

---

## 🏠 Dashboard

**Files:**
- Screenshot: `Dashboard.PNG`
- Documentation: `Dashboard.md`

**Purpose:** Main landing page after login with navigation menu

**Key Components:**
**Menu Bar:**
- File
- Master Data
- Transaksi
- Laporan
- Logout

**Sidebar Navigation (Two-Column Layout):**
- **Form Data Master:**
  - Data Member (with user icon)
  - Data Aset (with document icon)
  - Data Kategori (with category icon)
  - Data Lokasi (with location icon)
- **Form Data Transaksi:**
  - Peminjaman Aset (with loan icon)
  - Mutasi Aset (with transfer icon)

**Welcome Message:**
- "Halo, Selamat Datang !"
- "Aplikasi Berbasis Desktop"
- "PERANCANGAN SISTEM INVENTARIS ASET"
- "DI SMA NEGERI 62 JAKARTA"
- Date display: "Minggu, 25 Januari 2026"

**Technology:** Java Swing (JFrame, JMenuBar, JPanel)

**Visual Characteristics:**
- Gray background
- Clean, professional layout
- Icon-based navigation
- Two-column design (sidebar + main content)

---

## 👥 Form Data Member

**Files:**
- Screenshot: `Form Data Member.PNG`
- Documentation: `Form Data Member.md`

**Purpose:** CRUD operations for member data management

**Key Components:**

**Input Fields:**
- ID Member (auto-generated, e.g., "MBR002")
- Nama Member (text input)
- Kontak (text input)

**Action Buttons:**
- SIMPAN (Save)
- UBAH (Edit)
- HAPUS (Delete)
- BERSIKAN (Clear)

**Data Table:**
- Columns: ID Member, Nama Member, Kontak
- Example data: MBR001, Andi Pratama, 081234567890
- Print icon for report generation

**Additional Features:**
- Search box with magnifying glass icon
- Date display: "Rabu, 04 Februari 2026"
- "Branda" icon in top right

**Technology:** Java Swing (JTextField, JButton, JTable, JScrollPane)

**Visual Characteristics:**
- White background
- Bold title "Form Data Member"
- Horizontal separator line
- Gray action buttons
- Organized table layout

---

## 📦 Form Data Aset

**Files:**
- Screenshot: `Form Data Aset.PNG`
- Documentation: `form data aset.md`

**Purpose:** Asset management and tracking

**Key Components:**
- Asset input fields
- CRUD operation buttons
- Asset data table
- Print functionality

**Technology:** Java Swing

---

## 🏷️ Form Data Kategori

**Files:**
- Screenshot: `Form Data Kategori.PNG`
- Documentation: `form data kategori.md`

**Purpose:** Category management for asset classification

**Key Components:**
- Category input fields
- CRUD operation buttons
- Category data table
- Print functionality

**Technology:** Java Swing

---

## 📍 Form Data Lokasi

**Files:**
- Screenshot: `Form Data Lokasi.PNG`
- Documentation: `form data lokasi.md`

**Purpose:** Location management for asset tracking

**Key Components:**
- Location input fields
- CRUD operation buttons
- Location data table
- Print functionality

**Technology:** Java Swing

---

## 🔄 Form Data Mutasi

**Files:**
- Screenshot: `Form Data Mutasi.PNG`
- Documentation: `form data mutasi.md`

**Purpose:** Asset transfer/mutation transaction management

**Key Components:**
- Mutation transaction fields
- CRUD operation buttons
- Transaction history table
- Print functionality

**Technology:** Java Swing

---

## 📤 Form Data Peminjaman

**Files:**
- Screenshot: `Form Data Peminjaman.PNG`
- Documentation: `form data peminjaman.md`

**Purpose:** Asset borrowing/loan transaction management

**Key Components:**
- Loan transaction fields
- CRUD operation buttons
- Loan history table
- Print functionality

**Technology:** Java Swing

---

## 🖨️ Laporan Data Aset

**Files:**
- Screenshot: `Laporan (print) Data Aset.PNG`
- Documentation: `laporan (print) data aset.md`

**Purpose:** Printable report of all assets

**Report Format:**
- Header with school logo and name
- Report title
- Data table with asset information
- Footer with print date

**Technology:** JasperReports (JRXML)

---

## 🖨️ Laporan Data Kategori

**Files:**
- Screenshot: `Laporan (print) Data Kategori.PNG`
- Documentation: `laporan (print) data kategori.md`

**Purpose:** Printable report of all categories

**Report Format:**
- Header with school logo and name
- Report title
- Data table with category information
- Footer with print date

**Technology:** JasperReports (JRXML)

---

## 🖨️ Laporan Data Lokasi

**Files:**
- Screenshot: `Laporan (print) Data Lokasi.PNG`
- Documentation: `laporan data lokasi_mutasi_peminjaman.md`

**Purpose:** Printable report of all locations

**Report Format:**
- Header with school logo and name
- Report title
- Data table with location information
- Footer with print date

**Technology:** JasperReports (JRXML)

---

## 🖨️ Laporan Data Member

**Files:**
- Screenshot: `Laporan (print) Data Member.PNG`
- Documentation: `laporan (print) data member.md`

**Purpose:** Printable report of all members

**Report Format:**
- Header with school logo and name
- Report title
- Data table with member information
- Footer with print date

**Technology:** JasperReports (JRXML)

---

## 🖨️ Laporan Data Peminjaman (Report)

**Files:**
- Screenshot: `Laporan (print) Data Peminjaman.PNG`
- Documentation: `laporan data lokasi_mutasi_peminjaman.md`

**Purpose:** Printable report of all loan transactions

**Report Format:**
- Header with school logo and name
- Report title
- Data table with loan transaction information
- Footer with print date

**Technology:** JasperReports (JRXML)

---

## 🖨️ Laporan Mutasi

**Files:**
- Screenshot: `Laporan (print) Mutasi.PNG`
- Documentation: `laporan data lokasi_mutasi_peminjaman.md`

**Purpose:** Printable report of all asset mutations

**Report Format:**
- Header with school logo and name
- Report title
- Data table with mutation transaction information
- Footer with print date

**Technology:** JasperReports (JRXML)

---

## 🎨 Icon Print

**Files:**
- Screenshot: `Icon Print.PNG`
- Documentation: `Icon Print.md`

**Purpose:** Print icon used throughout the application

**Usage:** Appears in forms to trigger report generation

---

## 🏫 Branding Assets

**Files:**
- `LOGO_sekolah 62 jakarta.png`

**Purpose:** School logo used in reports and UI

**Usage:** 
- Report headers
- Application branding
- UI decoration

---

## 📐 Design Patterns & Conventions

### Common UI Elements Across All Forms:

1. **Header Section:**
   - Welcome message: "Halo, Selamat Datang !"
   - Search functionality
   - Branda icon

2. **Form Title:**
   - Bold, large font
   - Horizontal separator line below

3. **Input Section:**
   - Left-aligned labels
   - Right-aligned input fields
   - Consistent spacing

4. **Action Buttons:**
   - Standard set: SIMPAN, UBAH, HAPUS, BERSIKAN
   - Gray background
   - Black text
   - Horizontal alignment

5. **Data Table:**
   - White background
   - Gray headers
   - Scrollable
   - Print icon in top right

6. **Footer:**
   - Date display in bottom right
   - Format: "Day, DD Month YYYY"

### Color Scheme:
- **Primary Background:** White (#FFFFFF)
- **Secondary Background:** Light Gray
- **Text:** Black (#000000)
- **Buttons:** Gray
- **Borders:** Dark Gray/Black

### Typography:
- **Titles:** Large, Bold, Uppercase
- **Labels:** Standard, Left-aligned
- **Data:** Standard, Black

---

## 🔗 Navigation Flow

```
Login Screen
    ↓
Dashboard (Main Menu)
    ├── Master Data
    │   ├── Form Data Member
    │   ├── Form Data Aset
    │   ├── Form Data Kategori
    │   └── Form Data Lokasi
    ├── Transaksi
    │   ├── Form Data Peminjaman
    │   └── Form Data Mutasi
    ├── Laporan
    │   ├── Laporan Data Aset
    │   ├── Laporan Data Kategori
    │   ├── Laporan Data Lokasi
    │   ├── Laporan Data Member
    │   ├── Laporan Data Peminjaman
    │   └── Laporan Mutasi
    └── Logout → Login Screen
```

---

## 🛠️ Technology Stack Summary

**UI Framework:** Java Swing
- JFrame (main windows)
- JPanel (containers)
- JTextField (text inputs)
- JPasswordField (password input)
- JButton (action buttons)
- JTable (data grids)
- JScrollPane (scrollable areas)
- JMenuBar (menu navigation)

**Reporting:** JasperReports
- JRXML templates
- PDF generation
- Print functionality

**Layout Managers:**
- GroupLayout
- GridBagLayout
- BorderLayout

---

## 📊 Screen Statistics

**Total Screens:** 13
- Authentication: 1
- Navigation: 1
- Master Data Forms: 4
- Transaction Forms: 2
- Reports: 6

**Total Files in Photos UI Folder:** 28
- PNG Images: 19
- Markdown Docs: 8
- Logo: 1

---

## 🔍 Search Index

**By Functionality:**
- **Authentication:** Login
- **Dashboard:** Main navigation, Welcome screen
- **Member Management:** Form Data Member, Laporan Data Member
- **Asset Management:** Form Data Aset, Laporan Data Aset
- **Category Management:** Form Data Kategori, Laporan Data Kategori
- **Location Management:** Form Data Lokasi, Laporan Data Lokasi
- **Loan Management:** Form Data Peminjaman, Laporan Data Peminjaman
- **Transfer Management:** Form Data Mutasi, Laporan Mutasi

**By Component Type:**
- **Forms:** 6 (Login, Member, Aset, Kategori, Lokasi, Peminjaman, Mutasi)
- **Reports:** 6 (Aset, Kategori, Lokasi, Member, Peminjaman, Mutasi)
- **Navigation:** 1 (Dashboard)

**By User Action:**
- **Create:** All master data and transaction forms
- **Read:** All forms with data tables, all reports
- **Update:** All master data and transaction forms
- **Delete:** All master data and transaction forms
- **Print:** All reports, print icons in forms

---

## 📝 Notes

1. All forms follow consistent CRUD pattern
2. All reports use JasperReports with school branding
3. Date format: Indonesian locale (e.g., "Rabu, 04 Februari 2026")
4. Application uses default Java Swing Look & Feel
5. Focus on functionality over visual aesthetics
6. Suitable for internal school administration use

---

**Document Version:** 1.0  
**Last Updated:** February 5, 2026  
**Maintained By:** System Documentation Team
