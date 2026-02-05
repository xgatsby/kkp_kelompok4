# Panduan Penggunaan Library Tambahan

**Tanggal:** 5 Februari 2026  
**Versi:** 1.0  
**Status:** ✅ Terintegrasi

---

## 📚 Library yang Ditambahkan

### 1. FlatLaf Extras 3.6.2
**File:** `Libraries/flatlaf-extras-3.6.2.jar`  
**Tujuan:** Dukungan SVG Icons dan komponen tambahan FlatLaf

#### Fitur Utama:
- **FlatSVGIcon** - Load dan render SVG icons (scalable, tajam di semua resolusi)
- **FlatInspector** - Debug tool untuk UI development
- **FlatUIDefaultsInspector** - Inspect UI properties
- **TriStateCheckBox** - Checkbox dengan 3 state (checked, unchecked, indeterminate)

#### Contoh Penggunaan:

```java
import com.formdev.flatlaf.extras.FlatSVGIcon;

// Load SVG icon
FlatSVGIcon icon = new FlatSVGIcon("src/icon/user.svg");
icon.setColorFilter(new FlatSVGIcon.ColorFilter(color -> ModernTheme.BIRU_UTAMA));

// Gunakan di button
JButton btn = new JButton("User", icon);

// Atau di label
JLabel lbl = new JLabel("Dashboard", icon);
```

#### Best Practices:
- Gunakan SVG untuk icons yang perlu scalable (logo, menu icons)
- Set ColorFilter untuk menyesuaikan warna dengan theme
- Simpan SVG di folder `src/icon/` dengan nama deskriptif

---

### 2. MigLayout 5.3
**Files:** 
- `Libraries/miglayout-core-5.3.jar` (Core library)
- `Libraries/miglayout-swing-5.3.jar` (Swing integration)

**Tujuan:** Layout manager modern yang powerful dan mudah digunakan

#### Keunggulan vs GridBagLayout:
- Syntax lebih sederhana dan readable
- Responsive layout dengan minimal code
- Support untuk constraints yang kompleks
- Grid-based tapi fleksibel

#### Contoh Penggunaan:

```java
import net.miginfocom.swing.MigLayout;

// Basic layout
JPanel panel = new JPanel(new MigLayout());
panel.add(lblNama, "gap 10");
panel.add(txtNama, "growx, wrap");
panel.add(lblEmail, "gap 10");
panel.add(txtEmail, "growx, wrap");

// Layout dengan constraints
JPanel formPanel = new JPanel(new MigLayout(
    "fillx, insets 20",           // Layout constraints
    "[right]10[grow,fill]",       // Column constraints
    "[]10[]10[]"                  // Row constraints
));

formPanel.add(lblNama, "");
formPanel.add(txtNama, "wrap");
formPanel.add(lblEmail, "");
formPanel.add(txtEmail, "wrap");
formPanel.add(btnSimpan, "skip, split 2");
formPanel.add(btnBatal, "");

// Responsive grid
JPanel cardGrid = new JPanel(new MigLayout(
    "fillx, wrap 3",              // 3 columns, auto wrap
    "[grow,fill][grow,fill][grow,fill]"
));

cardGrid.add(card1);
cardGrid.add(card2);
cardGrid.add(card3);
```

#### Common Constraints:
- `wrap` - Pindah ke baris baru
- `span` - Span multiple columns/rows
- `grow` - Component bisa grow
- `fill` - Fill available space
- `gap` - Spacing antar komponen
- `insets` - Padding panel
- `split` - Split cell untuk multiple components

---

### 3. JFreeChart 1.5.4
**File:** `Libraries/jfreechart-1.5.4.jar`  
**Tujuan:** Library untuk membuat grafik dan chart

#### Fitur Utama:
- Bar Chart (grafik batang)
- Line Chart (grafik garis)
- Pie Chart (grafik lingkaran)
- Area Chart, Scatter Plot, dll
- Export ke PNG/JPEG/PDF
- Interactive charts (zoom, pan)

#### Contoh Penggunaan:

```java
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

// 1. PIE CHART - Distribusi Aset per Kategori
DefaultPieDataset pieDataset = new DefaultPieDataset();
pieDataset.setValue("Elektronik", 45);
pieDataset.setValue("Furniture", 30);
pieDataset.setValue("Kendaraan", 15);
pieDataset.setValue("Lainnya", 10);

JFreeChart pieChart = ChartFactory.createPieChart(
    "Distribusi Aset per Kategori",
    pieDataset,
    true,  // legend
    true,  // tooltips
    false  // URLs
);

ChartPanel piePanel = new ChartPanel(pieChart);
piePanel.setPreferredSize(new Dimension(400, 300));

// 2. BAR CHART - Pertumbuhan Aset per Tahun
DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
barDataset.addValue(120, "Aset", "2022");
barDataset.addValue(150, "Aset", "2023");
barDataset.addValue(180, "Aset", "2024");
barDataset.addValue(200, "Aset", "2025");

JFreeChart barChart = ChartFactory.createBarChart(
    "Pertumbuhan Aset per Tahun",
    "Tahun",
    "Jumlah Aset",
    barDataset
);

ChartPanel barPanel = new ChartPanel(barChart);

// 3. LINE CHART - Trend Peminjaman
DefaultCategoryDataset lineDataset = new DefaultCategoryDataset();
lineDataset.addValue(10, "Peminjaman", "Jan");
lineDataset.addValue(15, "Peminjaman", "Feb");
lineDataset.addValue(12, "Peminjaman", "Mar");
lineDataset.addValue(20, "Peminjaman", "Apr");

JFreeChart lineChart = ChartFactory.createLineChart(
    "Trend Peminjaman Bulanan",
    "Bulan",
    "Jumlah",
    lineDataset
);

ChartPanel linePanel = new ChartPanel(lineChart);

// Customize chart appearance
barChart.setBackgroundPaint(Color.WHITE);
barChart.getPlot().setBackgroundPaint(new Color(245, 245, 245));
```

#### Integrasi dengan Dashboard:

```java
// Di branda.java - tambahkan chart panel
JPanel statsPanel = new JPanel(new MigLayout("fillx, wrap 2"));

// Card dengan pie chart
JPanel pieCard = ModernTheme.createStyledPanel();
ModernTheme.applyCardStyle(pieCard);
pieCard.setLayout(new BorderLayout());
pieCard.add(createPieChart(), BorderLayout.CENTER);

// Card dengan bar chart
JPanel barCard = ModernTheme.createStyledPanel();
ModernTheme.applyCardStyle(barCard);
barCard.setLayout(new BorderLayout());
barCard.add(createBarChart(), BorderLayout.CENTER);

statsPanel.add(pieCard, "grow");
statsPanel.add(barCard, "grow");
```

---

## 🎯 Use Cases untuk Modernisasi GUI

### Phase 4 - Master Data Forms:
**Library:** MigLayout  
**Penggunaan:** Layout form yang responsive dan rapi
```java
// member.java, aset.java, kategori.java, lokasi.java
JPanel formPanel = new JPanel(new MigLayout(
    "fillx, insets 20",
    "[right]10[grow,fill]",
    "[]10[]"
));
```

### Phase 5 - Transaction Forms:
**Library:** MigLayout + FlatLaf Extras  
**Penggunaan:** Layout kompleks dengan SVG icons
```java
// mutasi.java, peminjaman.java
FlatSVGIcon transferIcon = new FlatSVGIcon("src/icon/transfer.svg");
JButton btnMutasi = new JButton("Transfer Aset", transferIcon);
```

### Phase 6 - Dashboard Enhancement:
**Library:** JFreeChart  
**Penggunaan:** Visualisasi data statistik
```java
// branda.java - tambahkan grafik
ChartPanel chartPanel = createAssetGrowthChart();
dashboardPanel.add(chartPanel, "span, grow");
```

---

## 📦 Verifikasi Instalasi

### Test Compile:
```bash
scripts\BUILD.bat
```

### Test Import:
```java
// Test FlatLaf Extras
import com.formdev.flatlaf.extras.FlatSVGIcon;

// Test MigLayout
import net.miginfocom.swing.MigLayout;

// Test JFreeChart
import org.jfree.chart.ChartFactory;
```

### Cek Classpath:
Library sudah ditambahkan ke `nbproject/project.properties`:
- `file.reference.flatlaf-extras-3.6.2.jar`
- `file.reference.miglayout-core-5.3.jar`
- `file.reference.miglayout-swing-5.3.jar`
- `file.reference.jfreechart-1.5.4.jar`

---

## 🚀 Next Steps

1. **Phase 4:** Gunakan MigLayout untuk form layouts
2. **Phase 5:** Tambahkan SVG icons dengan FlatLaf Extras
3. **Phase 6:** Implementasi dashboard charts dengan JFreeChart

---

## 📚 Resources

- **FlatLaf Extras:** https://www.formdev.com/flatlaf/extras/
- **MigLayout:** http://www.miglayout.com/
- **JFreeChart:** https://www.jfree.org/jfreechart/

---

**Status:** ✅ Semua library terintegrasi dan siap digunakan  
**Build:** ✅ Successful (1 warning - normal untuk Java 8)  
**Next:** Implementasi di Phase 4 (Master Data Forms)
