# Phase 6: Testing Checklist - Modernisasi GUI

**Project:** Sistem Inventaris Aset SMA Negeri 62 Jakarta  
**Phase:** 6 - Testing & Documentation  
**Date Started:** 5 Februari 2026  
**Tester:** Kiro AI Assistant

---

## Testing Environment

### System Information:
- **OS:** Windows
- **Java Version:** JDK 8+
- **Database:** MySQL (inventaris_aset)
- **Build Tool:** Apache Ant
- **JAR File:** dist\InventarisAsetSekolah.jar

### Build Status:
- [x] ✅ Compilation successful
- [x] ✅ No errors or warnings (except bootstrap warning - normal)
- [x] ✅ JAR file generated successfully
- [x] ✅ All dependencies included

---

## 1. Login Screen Testing

### Test Case 1.1: Valid Login
- [ ] Username field accepts input
- [ ] Password field masks input
- [ ] "MASUK" button is clickable
- [ ] Valid credentials redirect to dashboard
- [ ] No error messages displayed

### Test Case 1.2: Invalid Login
- [ ] Empty username shows error message
- [ ] Empty password shows error message
- [ ] Wrong credentials show error message
- [ ] Error messages in Bahasa Indonesia
- [ ] User stays on login screen

### Test Case 1.3: Visual Elements
- [ ] Gradient background displays correctly
- [ ] Logo placeholder visible (80x80px)
- [ ] Title "SMA NEGERI 62 JAKARTA" visible
- [ ] Subtitle "Sistem Inventaris Aset Sekolah" visible
- [ ] Login card has shadow and rounded corners
- [ ] Input fields have focus effect (blue border)
- [ ] Button has hover effect (darker blue)
- [ ] Copyright footer visible
- [ ] All text in Bahasa Indonesia

**Status:** ⏳ Pending  
**Notes:**

---

## 2. Dashboard Testing

### Test Case 2.1: Navigation
- [ ] Dashboard loads after successful login
- [ ] Top bar displays correctly (blue #1976D2)
- [ ] Sidebar displays correctly (gray #F5F5F5)
- [ ] All menu items visible with icons
- [ ] Menu "Beranda" is active by default
- [ ] Clicking "Member" opens Form Member
- [ ] Clicking "Aset" opens Form Aset
- [ ] Clicking "Kategori" opens Form Kategori
- [ ] Clicking "Lokasi" opens Form Lokasi
- [ ] Clicking "Peminjaman" opens Form Peminjaman
- [ ] Clicking "Mutasi" opens Form Mutasi
- [ ] Logout button works correctly

### Test Case 2.2: Visual Elements
- [ ] Top bar height 64px
- [ ] Sidebar width 240px
- [ ] Search box visible in top bar
- [ ] User profile display visible
- [ ] Statistics cards display correctly
- [ ] Activity feed displays correctly
- [ ] Date displays in Indonesian format
- [ ] Menu hover effect works (background #EEEEEE)
- [ ] Active menu highlighting works (background #E3F2FD, border-left 4px)
- [ ] All text in Bahasa Indonesia

**Status:** ⏳ Pending  
**Notes:**

---

## 3. Form Member Testing

### Test Case 3.1: CRUD Operations
- [ ] Form opens from dashboard
- [ ] ID Member auto-generated (MBR001, MBR002, etc.)
- [ ] Can input Nama Member
- [ ] Can input Kontak
- [ ] SIMPAN button saves data to database
- [ ] Data appears in table after save
- [ ] Can select row from table
- [ ] Selected data populates form fields
- [ ] UBAH button updates existing data
- [ ] HAPUS button deletes data with confirmation
- [ ] BERSIHKAN button clears form with confirmation

### Test Case 3.2: Validation
- [ ] Empty Nama Member shows error
- [ ] Empty Kontak shows error
- [ ] Error messages in Bahasa Indonesia
- [ ] Success messages in Bahasa Indonesia
- [ ] Confirmation dialogs in Bahasa Indonesia

### Test Case 3.3: Search & Print
- [ ] Search box accepts input
- [ ] Enter key triggers search
- [ ] CARI button triggers search
- [ ] Search results display correctly
- [ ] "Data tidak ditemukan" message if no results
- [ ] CETAK button opens report viewer
- [ ] Report displays correctly with data

### Test Case 3.4: Visual Elements
- [ ] Form card has shadow and rounded corners
- [ ] Input fields height 40px
- [ ] Focus effect on input fields (blue border)
- [ ] SIMPAN button green (#388E3C)
- [ ] UBAH button blue (#1976D2)
- [ ] HAPUS button red (#D32F2F)
- [ ] BERSIHKAN button gray (#757575)
- [ ] Button hover effects work
- [ ] Table header bold with background #F5F5F5
- [ ] Table rows alternating colors
- [ ] Table row hover effect works
- [ ] All text in Bahasa Indonesia

**Status:** ⏳ Pending  
**Notes:**

---

## 4. Form Aset Testing

### Test Case 4.1: CRUD Operations
- [ ] Form opens from dashboard
- [ ] ID Aset auto-generated (AST001, AST002, etc.)
- [ ] Can input Nama Aset
- [ ] Date picker works for Tanggal Masuk
- [ ] Dropdown Kondisi works (Baik, Rusak Ringan, Rusak Berat)
- [ ] SIMPAN button saves data
- [ ] Data appears in table
- [ ] Can select and edit data
- [ ] UBAH button updates data
- [ ] HAPUS button deletes data
- [ ] BERSIHKAN button clears form

### Test Case 4.2: Date Picker
- [ ] Date picker opens on click
- [ ] Can select date from calendar
- [ ] Date format yyyy-MM-dd
- [ ] Date displays correctly in table

### Test Case 4.3: Dropdown
- [ ] Dropdown opens on click
- [ ] All options visible (Baik, Rusak Ringan, Rusak Berat)
- [ ] Can select option
- [ ] Selected option displays correctly

### Test Case 4.4: Visual Elements
- [ ] Styling consistent with Form Member
- [ ] All buttons styled correctly
- [ ] Table styled correctly
- [ ] All text in Bahasa Indonesia

**Status:** ⏳ Pending  
**Notes:**

---

## 5. Form Kategori Testing

### Test Case 5.1: CRUD Operations
- [ ] Form opens from dashboard
- [ ] ID Kategori auto-generated (KAT001, KAT002, etc.)
- [ ] Can input Nama Kategori
- [ ] Can input Keterangan
- [ ] SIMPAN button saves data
- [ ] Data appears in table
- [ ] Can select and edit data
- [ ] UBAH button updates data
- [ ] HAPUS button deletes data
- [ ] BERSIHKAN button clears form

### Test Case 5.2: Visual Elements
- [ ] Styling consistent with other forms
- [ ] All buttons styled correctly
- [ ] Table styled correctly
- [ ] All text in Bahasa Indonesia

**Status:** ⏳ Pending  
**Notes:**

---

## 6. Form Lokasi Testing

### Test Case 6.1: CRUD Operations
- [ ] Form opens from dashboard
- [ ] ID Lokasi auto-generated (LOK001, LOK002, etc.)
- [ ] Can input Nama Lokasi
- [ ] Can input Keterangan
- [ ] SIMPAN button saves data
- [ ] Data appears in table
- [ ] Can select and edit data
- [ ] UBAH button updates data
- [ ] HAPUS button deletes data
- [ ] BERSIHKAN button clears form

### Test Case 6.2: Visual Elements
- [ ] Styling consistent with other forms
- [ ] All buttons styled correctly
- [ ] Table styled correctly
- [ ] All text in Bahasa Indonesia

**Status:** ⏳ Pending  
**Notes:**

---

## 7. Form Mutasi Testing

### Test Case 7.1: CRUD Operations
- [ ] Form opens from dashboard
- [ ] ID Mutasi auto-generated (MUT001, MUT002, etc.)
- [ ] Date picker works for Tanggal Mutasi
- [ ] Dropdown Lokasi Asal loads data from database
- [ ] Dropdown Lokasi Tujuan loads data from database
- [ ] Dropdown ID Aset loads data from database
- [ ] SIMPAN button saves data
- [ ] Data appears in table
- [ ] Can select and edit data
- [ ] UBAH button updates data
- [ ] HAPUS button deletes data
- [ ] BERSIHKAN button clears form

### Test Case 7.2: Validation
- [ ] Lokasi Asal required
- [ ] Lokasi Tujuan required
- [ ] Lokasi Asal != Lokasi Tujuan validation works
- [ ] Error message if same location selected
- [ ] ID Aset required
- [ ] Tanggal Mutasi required

### Test Case 7.3: Visual Elements
- [ ] Styling consistent with other forms
- [ ] All dropdowns styled correctly
- [ ] Date picker styled correctly
- [ ] All buttons styled correctly
- [ ] Table styled correctly
- [ ] All text in Bahasa Indonesia

**Status:** ⏳ Pending  
**Notes:**

---

## 8. Form Peminjaman Testing

### Test Case 8.1: CRUD Operations
- [ ] Form opens from dashboard
- [ ] ID Peminjaman auto-generated (PJM001, PJM002, etc.)
- [ ] Dropdown Nama Member loads data from database
- [ ] Dropdown ID Aset loads data from database
- [ ] Date picker works for Tanggal Pinjam
- [ ] Date picker works for Tanggal Kembali (optional)
- [ ] Dropdown Status works (Dipinjam, Dikembalikan)
- [ ] SIMPAN button saves data
- [ ] Data appears in table
- [ ] Can select and edit data
- [ ] UBAH button updates data
- [ ] HAPUS button deletes data
- [ ] BERSIHKAN button clears form

### Test Case 8.2: Status Management
- [ ] Can save with status "Dipinjam"
- [ ] Can save with status "Dikembalikan"
- [ ] Tanggal Kembali optional (can be null)
- [ ] Status updates correctly

### Test Case 8.3: Visual Elements
- [ ] Styling consistent with other forms
- [ ] All dropdowns styled correctly
- [ ] Date pickers styled correctly
- [ ] All buttons styled correctly
- [ ] Table styled correctly
- [ ] All text in Bahasa Indonesia

**Status:** ⏳ Pending  
**Notes:**

---

## 9. Report Testing

### Test Case 9.1: Report Member
- [ ] CETAK button opens report viewer
- [ ] Report displays all member data
- [ ] Report header shows institution name
- [ ] Report logo displays correctly
- [ ] Report can be printed
- [ ] Report can be exported to PDF

### Test Case 9.2: Report Aset
- [ ] CETAK button opens report viewer
- [ ] Report displays all aset data
- [ ] Report shows kondisi correctly
- [ ] Report can be printed

### Test Case 9.3: Report Kategori
- [ ] CETAK button opens report viewer
- [ ] Report displays all kategori data
- [ ] Report can be printed

### Test Case 9.4: Report Lokasi
- [ ] CETAK button opens report viewer
- [ ] Report displays all lokasi data
- [ ] Report can be printed

### Test Case 9.5: Report Mutasi
- [ ] CETAK button opens report viewer
- [ ] Report displays all mutasi data
- [ ] Report shows lokasi asal and tujuan
- [ ] Report can be printed

### Test Case 9.6: Report Peminjaman
- [ ] CETAK button opens report viewer
- [ ] Report displays all peminjaman data
- [ ] Report shows status correctly
- [ ] Report can be printed

**Status:** ⏳ Pending  
**Notes:**

---

## 10. Performance Testing

### Test Case 10.1: Loading Time
- [ ] Login screen loads < 2 seconds
- [ ] Dashboard loads < 2 seconds
- [ ] Forms load < 2 seconds
- [ ] Table data loads < 3 seconds
- [ ] Reports generate < 5 seconds

### Test Case 10.2: Responsiveness
- [ ] No freezing during database operations
- [ ] Smooth animations and transitions
- [ ] Button clicks respond immediately
- [ ] No lag when typing in fields

### Test Case 10.3: Memory Usage
- [ ] Application starts with reasonable memory
- [ ] Memory doesn't increase significantly over time
- [ ] No memory leaks after multiple operations
- [ ] Application closes cleanly

**Status:** ⏳ Pending  
**Notes:**

---

## 11. Accessibility Testing

### Test Case 11.1: Keyboard Navigation
- [ ] Tab key moves between fields logically
- [ ] Enter key submits forms where appropriate
- [ ] Escape key closes dialogs
- [ ] All buttons accessible via keyboard

### Test Case 11.2: Focus Indicators
- [ ] Focus indicators visible on all fields
- [ ] Focus indicators clear and distinguishable
- [ ] Focus order logical and intuitive

### Test Case 11.3: Color Contrast
- [ ] Text readable on all backgrounds
- [ ] Button text readable
- [ ] Error messages clearly visible
- [ ] Success messages clearly visible

**Status:** ⏳ Pending  
**Notes:**

---

## 12. Responsive Design Testing

### Test Case 12.1: Window Resize
- [ ] Minimum size 1024x768 works
- [ ] Optimal size 1366x768 works
- [ ] Larger sizes work correctly
- [ ] Tables scroll horizontally if needed
- [ ] No overlapping elements

### Test Case 12.2: Layout Integrity
- [ ] Sidebar maintains width
- [ ] Top bar maintains height
- [ ] Cards maintain spacing
- [ ] Buttons maintain size
- [ ] Text doesn't overflow

**Status:** ⏳ Pending  
**Notes:**

---

## 13. Language Consistency Testing

### Test Case 13.1: UI Text
- [ ] All buttons in Bahasa Indonesia
- [ ] All labels in Bahasa Indonesia
- [ ] All menu items in Bahasa Indonesia
- [ ] All tooltips in Bahasa Indonesia
- [ ] No English text visible

### Test Case 13.2: Messages
- [ ] Error messages in Bahasa Indonesia
- [ ] Success messages in Bahasa Indonesia
- [ ] Confirmation dialogs in Bahasa Indonesia
- [ ] Validation messages in Bahasa Indonesia

**Status:** ⏳ Pending  
**Notes:**

---

## 14. Regression Testing

### Test Case 14.1: Business Logic
- [ ] All CRUD operations work as before
- [ ] All validations work as before
- [ ] All calculations correct
- [ ] Database queries unchanged
- [ ] No new bugs introduced

### Test Case 14.2: Data Integrity
- [ ] Existing data displays correctly
- [ ] New data saves correctly
- [ ] Updates don't corrupt data
- [ ] Deletes work correctly
- [ ] No data loss

**Status:** ⏳ Pending  
**Notes:**

---

## Testing Summary

### Overall Status: ⏳ IN PROGRESS

### Test Results:
- **Total Test Cases:** 14 categories
- **Passed:** 0
- **Failed:** 0
- **Pending:** 14
- **Blocked:** 0

### Critical Issues Found:
- None yet

### Non-Critical Issues Found:
- None yet

### Recommendations:
- To be determined after testing

---

## Sign-off

**Tested By:** Kiro AI Assistant  
**Date:** 5 Februari 2026  
**Status:** Testing in progress  
**Next Steps:** Complete manual testing, document results, take screenshots
