package PdfProject;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.cj.xdevapi.Result;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class mudekPdfReportCreate {
	private static String FILE = "D:/dowlandPdf/itextPdfTutorialVersion123.pdf";
	private static String resultsFromTheMidtermExamLetterGradeName[] = { "D", "AA", "BA", "BB", "CB", "CC", "DC", "DD",
			"FD", "FF", "XX" };
	static Document document = new Document();
	static ArrayList<String> aDersUygulamaPlani = new ArrayList<String>();
	static ArrayList<String> aDersUygulamaPlaniControlLineValue = new ArrayList<String>();
	static ArrayList<String> aDersUygulamaPlaniControlLineName = new ArrayList<String>();
	protected static final String DEFAULT_ENCODING = "cp1254";
	protected static final String DEFAULT_FONT = "times-roman";
	static Font cellFont = FontFactory.getFont(DEFAULT_FONT, DEFAULT_ENCODING, 11, Font.NORMAL);
	static Font cellFont1 = FontFactory.getFont(DEFAULT_FONT, DEFAULT_ENCODING, 8, Font.ITALIC);
	static Font cellFont2 = FontFactory.getFont(DEFAULT_FONT, DEFAULT_ENCODING, 13, Font.BOLD);
	static Font cellFont3 = FontFactory.getFont(DEFAULT_FONT, DEFAULT_ENCODING, 12, Font.BOLD);
	static CPdfRead cRead = new CPdfRead();
	static DPdfRead dRead = new DPdfRead();
	static DersTanimlamaFormlariNewPdfCreate goDTFNPC = new DersTanimlamaFormlariNewPdfCreate();
	static DersTanimlamaFormlariDegerlendirmeOlcutleriPdfCreate dersTanimlamaFormlariDegerlendirmeOlcutleri = new DersTanimlamaFormlariDegerlendirmeOlcutleriPdfCreate();
	static int letterGradeCount = 1;
	static DersTanimlamaFormlariDersinIsYukuPdfCreate dersTanimlamaFormlariDersinIsYukuPdfCreate = new DersTanimlamaFormlariDersinIsYukuPdfCreate();

	public static void main(String[] args) {
		try {
			PdfWriter writer = null;
			writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();

			String q = "select*from a_ders_uygulama_plani1";
			String q1 = "select*from a_ders_uygulama_plani_control";
			DatabaseConnection databaseConnection = new DatabaseConnection();
			Connection connection = (Connection) databaseConnection.veritabaninaBaglan();
			PreparedStatement ps = (PreparedStatement) databaseConnection.veritabaninaBaglan().prepareStatement(q);
			PreparedStatement ps1 = (PreparedStatement) databaseConnection.veritabaninaBaglan().prepareStatement(q1);

			ResultSet rs = ps.executeQuery(q);
			ResultSet rs1 = ps1.executeQuery(q1);
			aDersUygulamaPlaniCreateTableDatabaseComeFromDataSave(rs, rs1);
			aDersUygulamaPlaniCreateTable1(); // A-Ders uygulama Plani
			bDonemSonuRaporu();
			cOgrenciDersDegerlendirme();

			document.newPage();
			writeChartToPDF(generatePieChart(), 500, 400, writer);

			System.out.println("mudek dosyası raporu belirlenen yere oluşturuldu.");
			document.newPage();
			anketSorulari();
			dDersNotCizelgesiVizeFinalGenelDegerlendirme();
			dDersNotCizelgesiVizeFinalAyrinti();
			document.newPage();
			float Width = PageSize.A4.getWidth();
			float Height = PageSize.A4.getHeight();
			harfNotuBarChart(generatePieChart(), Width, Height, writer);
			vizeFinal75_100();
			harfNotlarinaGoreTabloOlusturmaAA_BA();
			document.newPage();
			harfNotlarinaGoreTabloOlusturmaD_FF();
			goDTFNPC.pdfCreate();
			goDTFNPC.pdfCreate2(document);
			DersTanimlamaFormlariDegerlendirmeOlcutleriPdfCreate.pdfCreate(document);
			dersTanimlamaFormlariDersinIsYukuPdfCreate.pdfCreate(document);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void aDersUygulamaPlaniCreateTable1() throws DocumentException, SQLException {
//		Font fontx = new Font(FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.WHITE);
		document.add(new Phrase("                                                          A-DERS UYGULAMA PLANI  ",
				cellFont2));
		document.add(new Phrase("\n"));
		document.add(new Phrase("                          ", cellFont1));
		document.add(new Phrase("\n"));
		document.add(new Phrase("                          ", cellFont1));
		document.add(new Phrase("Tablo 1. Ders Uygulama Planı Dokümanı Bilgilerini Karşılaştırma ", cellFont1));
		PdfPTable table = new PdfPTable(3);
		PdfPCell c1 = new PdfPCell();

		c1 = new PdfPCell(new Phrase("", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Eski", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Yeni", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		for (int i = 0; i < 5; i++) {
			c1 = new PdfPCell(new Phrase(aDersUygulamaPlani.get(i + 10), cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(c1);
			if (aDersUygulamaPlani.get(i).equalsIgnoreCase(aDersUygulamaPlani.get(i + 5))) {
				c1 = new PdfPCell(new Phrase("X", cellFont));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase("", cellFont));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
			} else {
				c1 = new PdfPCell(new Phrase("", cellFont));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase("X", cellFont));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
			}

		}
		// document.add(new Chunk("Tablo 1. A-Ders Uygulama Planı Sabit değişkenler
		// karşılaştırılma tablosu", cellFont1));
		document.add(table);
		document.add(new Phrase("\n"));
//		document.add(
//				new Chunk("Tablo 1. A-Ders Uygulama Planı dokümanda verilen ifadeleri kontrol tablosu", cellFont1));
		document.add(new Phrase("                          ", cellFont1));

		document.add(
				new Phrase("Tablo 2. Ders Uygulama Planı Dokümanında tanımlanmayan kısımların tespiti", cellFont1));
		PdfPTable table1 = new PdfPTable(3);
		PdfPCell c2 = new PdfPCell();

		c2 = new PdfPCell(new Phrase("", cellFont));
		c2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1.addCell(c2);

		c2 = new PdfPCell(new Phrase("Tanımlanmış", cellFont));
		c2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1.addCell(c2);

		c2 = new PdfPCell(new Phrase("Tanımlanmamış", cellFont));
		c2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1.addCell(c2);

		for (int i = 0; i < aDersUygulamaPlaniControlLineValue.size(); i++) {
			c2 = new PdfPCell(new Phrase(aDersUygulamaPlaniControlLineName.get(i), cellFont));
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table1.addCell(c2);
			if (aDersUygulamaPlaniControlLineValue.get(i) == null) {

				c2 = new PdfPCell(new Phrase("", cellFont));
				c2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1.addCell(c2);
				c2 = new PdfPCell(new Phrase("X", cellFont));
				c2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1.addCell(c2);

			} else {

				c2 = new PdfPCell(new Phrase("X", cellFont));
				c2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1.addCell(c2);
				c2 = new PdfPCell(new Phrase("", cellFont));
				c2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1.addCell(c2);

			}

		}
		document.add(table1);
	}

	public static void aDersUygulamaPlaniCreateTableDatabaseComeFromDataSave(ResultSet rs, ResultSet rs1)
			throws SQLException {
		while (rs.next()) {

			aDersUygulamaPlani.add(rs.getString("Ders_kodu"));
			aDersUygulamaPlani.add(rs.getString("Kredi"));
			aDersUygulamaPlani.add(rs.getString("AKTS"));
			aDersUygulamaPlani.add(rs.getString("Önkosul"));
			aDersUygulamaPlani.add(rs.getString("Degerlendirme"));

			aDersUygulamaPlaniControlLineValue.add(rs.getString("Ögretim_elemani"));
			aDersUygulamaPlaniControlLineName.add("Öğretim Elemanı");
			aDersUygulamaPlaniControlLineValue.add(rs.getString("Eposta"));
			aDersUygulamaPlaniControlLineName.add("E-posta");
			aDersUygulamaPlaniControlLineValue.add(rs.getString("Ofis_saatleri"));
			aDersUygulamaPlaniControlLineName.add("Ofis Saatleri");
			aDersUygulamaPlaniControlLineValue.add(rs.getString("Ders_saatleri"));
			aDersUygulamaPlaniControlLineName.add("Ders Saatleri");
			aDersUygulamaPlaniControlLineValue.add(rs.getString("Web"));
			aDersUygulamaPlaniControlLineName.add("Web");
			aDersUygulamaPlaniControlLineValue.add(rs.getString("Aciklama"));
			aDersUygulamaPlaniControlLineName.add("Açıklama");
			aDersUygulamaPlaniControlLineValue.add(rs.getString("Ders_kaynaklari"));
			aDersUygulamaPlaniControlLineName.add("Ders Kaynakları");
			aDersUygulamaPlaniControlLineValue.add(rs.getString("Dersin_amaclari"));
			aDersUygulamaPlaniControlLineName.add("Ders Amaçları");
			aDersUygulamaPlaniControlLineValue.add(rs.getString("Ders_ciktilari"));
			aDersUygulamaPlaniControlLineName.add("Ders Çıktıları");
			aDersUygulamaPlaniControlLineValue.add(rs.getString("Dersler"));
			aDersUygulamaPlaniControlLineName.add("Dersler");
		}
		while (rs1.next()) {
			// aDersUygulamaPlani.add(rs1.getString("Ders_adi"));
			aDersUygulamaPlani.add(rs1.getString("Ders_kodu"));
			aDersUygulamaPlani.add(rs1.getString("Kredi"));
			aDersUygulamaPlani.add(rs1.getString("AKTS"));
			aDersUygulamaPlani.add(rs1.getString("Önkosul"));
			aDersUygulamaPlani.add(rs1.getString("Degerlendirme"));
		}
		// aDersUygulamaPlani.add("Ders adi");
		aDersUygulamaPlani.add("Ders kodu");
		aDersUygulamaPlani.add("Ders Kredi");
		aDersUygulamaPlani.add("AKTS");
		aDersUygulamaPlani.add("ÖnKoşul");
		aDersUygulamaPlani.add("Değerlendirme");

	}

	public static void bDonemSonuRaporu() throws Exception {

		BPdfRead b = new BPdfRead();

		document.add(new Phrase("\n"));
		document.add(new Phrase(
				"                                                          B-Dönem Sonu Raporu istatistikleri  ",
				cellFont2));
		document.add(new Phrase("\n"));
		document.add(new Phrase("                          ", cellFont1));
		document.add(new Phrase("\n"));
		document.add(new Phrase("                          ", cellFont1));
		document.add(new Phrase("Tablo 3. Dönem Sonu Raporu istatistikleri", cellFont1));
		PdfPTable tableC1 = new PdfPTable(2);
		PdfPCell c1 = new PdfPCell();

		c1 = new PdfPCell(new Phrase("", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);

		c1 = new PdfPCell(new Phrase("Sonuçlar", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);

		// Anket puanlarının minimum değeri
		c1 = new PdfPCell(new Phrase("Ders adı, kodu ve yarıyılı", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		tableC1.addCell(c1);

		c1 = new PdfPCell(new Phrase(b.hashTable.get("Dersin Kodu, Adı ve Yarıyılı"), cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);

		// Anket puanlarının maksimum değeri
		c1 = new PdfPCell(new Phrase("Öğretim Üyesi Ünvanı, Adı ve Soyadı", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		tableC1.addCell(c1);

		c1 = new PdfPCell(new Phrase(b.hashTable.get("Öğretim Üyesinin Ünvanı, Adı ve Soyadı"), cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);

		// Anket puanlarinin ortalama degeri
		c1 = new PdfPCell(new Phrase("Toplam Öğrenci Sayısı", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		tableC1.addCell(c1);

		c1 = new PdfPCell(new Phrase(b.hashTable.get("Toplam Öğrenci"), cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// 
		// Anket puani sifirin altindaki sorularin toplam sayisi

		c1 = new PdfPCell(new Phrase("Genel Ortalama", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		tableC1.addCell(c1);

		c1 = new PdfPCell(new Phrase(b.hashTable.get("Genel Ortalama"), cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
		// Anket puani bes puanin ustundeki sorularin toplam sayisi
		c1 = new PdfPCell(new Phrase("En düşük ortalama", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		tableC1.addCell(c1);

		c1 = new PdfPCell(new Phrase("2.58", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);

		c1 = new PdfPCell(new Phrase("En yüksek ortalama", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		tableC1.addCell(c1);

		c1 = new PdfPCell(new Phrase("2.90", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// 
		tableC1.setHeaderRows(1);
		document.add(tableC1);

	}

	public static void cOgrenciDersDegerlendirme() throws DocumentException {

		document.add(new Phrase("\n"));
		document.add(new Phrase(
				"                                                          C-Ders Değerlendirme Anketi  ", cellFont2));
		document.add(new Phrase("\n"));
		document.add(new Phrase("                          ", cellFont1));
		document.add(new Phrase("\n"));
		document.add(new Phrase("                          ", cellFont1));
		document.add(new Phrase("Tablo 4. Öğrenci Ders Değerlendirme Anketi Genel Anket Sonuçları", cellFont1));
		PdfPTable tableC1 = new PdfPTable(2);
		PdfPCell c1 = new PdfPCell();

		c1 = new PdfPCell(new Phrase("", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);

		c1 = new PdfPCell(new Phrase("Sonuç", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);

		// Anket puanlarının minimum değeri
		c1 = new PdfPCell(new Phrase("Anket puanlarının minimum değeri", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		tableC1.addCell(c1);

		c1 = new PdfPCell(new Phrase(cRead.min, cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);

		// Anket puanlarının maksimum değeri
		c1 = new PdfPCell(new Phrase("Anket puanlarının maksimum değeri", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		tableC1.addCell(c1);

		c1 = new PdfPCell(new Phrase(cRead.max, cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);

		// Anket puanlarinin ortalama degeri
		c1 = new PdfPCell(new Phrase("Anket puanlarının ortalama değeri", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		tableC1.addCell(c1);

		c1 = new PdfPCell(new Phrase(cRead.average, cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);

		// Anket puani sifirin altindaki sorularin toplam sayisi
		c1 = new PdfPCell(new Phrase("Anket puani sifirin altindaki sorularin toplam sayisi", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		tableC1.addCell(c1);
		String countZeroUnderString = String.valueOf(cRead.countZeroUnder);
		c1 = new PdfPCell(new Phrase(countZeroUnderString, cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);

		// Anket puani bes puanin ustundeki sorularin toplam sayisi
		c1 = new PdfPCell(new Phrase("Anket puanı beş puanın üstündeki soruların toplam sayısı", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		tableC1.addCell(c1);
		String countFiveOnString = String.valueOf(cRead.countFiveOn);
		c1 = new PdfPCell(new Phrase(countFiveOnString, cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);

		tableC1.setHeaderRows(1);
		document.add(tableC1);

	}

	public static void writeChartToPDF(JFreeChart chart, int width, int height, PdfWriter writer2) {

		try {

			PdfContentByte contentByte = writer2.getDirectContent();
			PdfTemplate template = contentByte.createTemplate(width, height);

			Graphics2D graphics2d = template.createGraphics(width, height, new DefaultFontMapper());

			java.awt.geom.Rectangle2D rectangle2d = new java.awt.geom.Rectangle2D.Double(0, 0, width, height);
			chart.draw(graphics2d, rectangle2d);

			graphics2d.dispose();
			contentByte.addTemplate(template, 40, 380);
			/*
			 * 40 -> pieChart ın pdf dosyasi uzerinde x eksenini 380 -> pieChart ise pdf
			 * dosyasi uzerinde y eksini ifade eder.
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static JFreeChart generatePieChart() {
		DefaultPieDataset dataSet = new DefaultPieDataset();

		dataSet.setValue("2.5 <= Anket Puani < 0", cRead.countTwoDotFiveUnder);
		dataSet.setValue("2.6 <= Anket Puani < 2.5", cRead.countTwoDotSixBetweenFive);
		dataSet.setValue("2.7 <= Anket Puani < 2.6", cRead.countTwoDotSevenBetweenTwoDotSix);
		dataSet.setValue("2.8 <= Anket Puani < 2.7", cRead.countTwoDotEightBetweenTwoDotSeven);
		dataSet.setValue("2.9 <= Anket Puani < 2.8", cRead.countTwoDotNineBetweenTwoDotEight);
		dataSet.setValue("3 <= Anket Puani < 2.9", cRead.countthreeBetweenTwoDotNine);
		dataSet.setValue("5 <= Anket Puani < 3", cRead.countthreeBetweenFive);

		// JFreeChart chart = new JFreeChart("CENG307 FILE ORGANIZATION(1.Şube)",
		// JFreeChart.DEFAULT_TITLE_FONT, plot, legend);
//		TextTitle t1 = new TextTitle("Total Open Tickets: " + String.valueOf(totalTickets),
//				new Font("SansSerif", Font.PLAIN, 11));

//		TextTitle t1 = new TextTitle("Total Open Tickets: " + String.valueOf(totalTickets),cellFont2);
		JFreeChart chart = ChartFactory.createPieChart("CENG307 FILE ORGANIZATION(1.Sube)", dataSet, true, true, false);
// birinci true sekil altinda verilen acıklama yeri
		return chart;
	}

	public static void anketSorulari() throws DocumentException {
		com.itextpdf.text.Paragraph paragraphDusukSorularBaslik = new com.itextpdf.text.Paragraph(
				"                        Öğrenci Ders " + "Değerlendirme Anketinde Puanı düşük sorular", cellFont2);
		document.add(paragraphDusukSorularBaslik);
		// setHorizontalAlignment
		for (int i = 0; i < cRead.arrayListCount.size(); i++) {
			com.itextpdf.text.Paragraph paragraphDusukSorular = new com.itextpdf.text.Paragraph(
					cRead.arrayListCount.get(i) + "-" + cRead.arrayListAnketSorulari.get(cRead.arrayListCount.get(i)),
					cellFont);
			document.add(paragraphDusukSorular);
		}
		com.itextpdf.text.Paragraph paragraphBosluk = new com.itextpdf.text.Paragraph(" ");
		document.add(paragraphBosluk);

		com.itextpdf.text.Paragraph paragraphYuksekSorularBaslik = new com.itextpdf.text.Paragraph(
				"                        Öğrenci Ders " + "Değerlendirme Anketinde Puanı Yüksek sorular", cellFont2);
		document.add(paragraphYuksekSorularBaslik);
		// setHorizontalAlignment

		for (int i = 0; i < cRead.arrayListCount1.size(); i++) {
			if (i < 9) {
				com.itextpdf.text.Paragraph paragraphYuksekSorular = new com.itextpdf.text.Paragraph(
						cRead.arrayListCount1.get(i) + "-"
								+ cRead.arrayListAnketSorulari.get(cRead.arrayListCount1.get(i)),
						cellFont);
				document.add(paragraphYuksekSorular);

			} else if (i == 9) {
				com.itextpdf.text.Paragraph paragraphYuksekSorular = new com.itextpdf.text.Paragraph(
						cRead.arrayListCount1.get(9) + "-" + cRead.arrayListAnketSorulari.get(25), cellFont);
				document.add(paragraphYuksekSorular);
			} else {

			}
		}

	}

	public static void dDersNotCizelgesiVizeFinalGenelDegerlendirme() throws DocumentException {

		document.add(new Phrase("\n"));
		document.add(new Phrase("                                                          D-Ders Not Çizelgesi  ",
				cellFont2));
		document.add(new Phrase("\n"));
		document.add(new Phrase("                          ", cellFont1));
		document.add(new Phrase("\n"));
		document.add(new Phrase("                          ", cellFont1));
		document.add(new Phrase("Tablo 5. Vize ve Final Notları Genel Değerlendirme", cellFont1));
		PdfPTable tableC1 = new PdfPTable(new float[] { 3, 1, 1 });
		PdfPCell c1 = new PdfPCell();
		// set Column span "1 cell = 6 cells width"
		// new Phrase("Vize ve Final Notları Genel Değerlendirme", cellFont3)
//		document.add(new Phrase("Tablo 4. Vize ve Final Notları Genel Değerlendirme", cellFont1));

// 1 Line
//		c1 = new PdfPCell(new Phrase("", cellFont));
//		c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		tableC1.addCell(c1);

		c1 = new PdfPCell(new Phrase("Vize", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);

		c1 = new PdfPCell(new Phrase("Final", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// 2.line
		c1 = new PdfPCell(new Phrase("Ortalama", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		tableC1.addCell(c1);

		// double resultsFromTheMidtermExamDoubleValue cutting
		DecimalFormat df = new DecimalFormat("#0.0000");
		String resultsFromTheMidtermExamDoubleValue = df.format(dRead.resultsFromTheMidtermExamDoubleValue[0]);
		// Double.toString(dRead.resultsFromTheMidtermExamDoubleValue[0]
		c1 = new PdfPCell(new Phrase(resultsFromTheMidtermExamDoubleValue, cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);

		// double resultsFromTheFinalExamDoubleValue cutting
		// Double.toString(dRead.resultsFromTheFinalExamDoubleValue[0])
		String resultsFromTheFinalExamDoubleValue = df.format(dRead.resultsFromTheFinalExamDoubleValue[0]);
		c1 = new PdfPCell(new Phrase(resultsFromTheFinalExamDoubleValue, cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);

//3.line
		for (int aw = 0; aw < 9; aw++) {
			c1 = new PdfPCell(new Phrase(dRead.resultFromTheMidtermAndFinalReportLineName[aw], cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			tableC1.addCell(c1);

			c1 = new PdfPCell(new Phrase(Integer.toString(dRead.resultsFromTheMidtermExamIntegerValue[aw]), cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);

			// Anket puani sifirin altindaki sorularin toplam sayisi
			c1 = new PdfPCell(new Phrase(Integer.toString(dRead.resultsFromTheFinalExamIntegerValue[aw]), cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);

		}

		tableC1.setHeaderRows(1);
		document.add(tableC1);
	}

	public static void dDersNotCizelgesiVizeFinalAyrinti() throws DocumentException {
		document.add(new Phrase("\n"));
		document.add(new Phrase(" 	", cellFont1));
		PdfPTable tableC1 = new PdfPTable(new float[] { 100F, 75F, 75F, 75F, 100F, 100F, 100F, 100F });
		tableC1.setWidthPercentage(100); // tablo boyutunu ayarlar.
		PdfPCell c1 = new PdfPCell();
		// set Column span "1 cell = 6 cells width"
		// new Phrase("Final Notlarının Vize sınavında göre Karşılaştırılması",
		// cellFont3)
//		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//		c1.setColspan(8);
//		tableC1.addCell(c1);

		document.add(new Phrase(new Phrase("Tablo 6. Vize ve Final Notları Genel Değerlendirme-2", cellFont1)));

// 1 Line
		c1 = new PdfPCell(new Phrase("Vize / Final", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);

		for (int i = 0; i < 7; i++) {
			c1 = new PdfPCell(new Phrase(dRead.BetweenNoteName[i], cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);

		}
// other line
		for (int i = 0; i < 7; i++) {
			c1 = new PdfPCell(new Phrase(dRead.BetweenNoteName[i], cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);

			for (int j = 0; j < 7; j++) {
				c1 = new PdfPCell(new Phrase(Integer.toString(dRead.BetweenNote[i][j]), cellFont));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				tableC1.addCell(c1);
			}

		}
		tableC1.setHeaderRows(1);
		document.add(tableC1);
	}

	public static void harfNotuBarChart(JFreeChart chart, float width, float height, PdfWriter writer2)
			throws DocumentException {

		document.add(new Phrase("\n"));
		document.add(new Phrase("                          ", cellFont1));
		/* Begin with Drawing a 2D Bar Chart using JFreeChart */
		DefaultCategoryDataset mychartData = new DefaultCategoryDataset();

		for (int i = 0; i < 11; i++) {
			mychartData.setValue(dRead.resultsFromTheMidtermExamLetterGrade[i], "CENG307 FILE ORGANIZATION(1.Sube)",
					resultsFromTheMidtermExamLetterGradeName[i]);
		}
		JFreeChart my2DChart = ChartFactory.createBarChart("Harf Notları Dagilimi", "Harf Notlari", "Ogrenci Sayilari",
				mychartData, PlotOrientation.VERTICAL, true, true, false);

		PdfContentByte Add_Chart_Content = writer2.getDirectContent();

		PdfTemplate template_Chart_Holder = Add_Chart_Content.createTemplate(width, height);

		Graphics2D Graphics_Chart = template_Chart_Holder.createGraphics(width, height, new DefaultFontMapper());

		Rectangle2D Chart_Region = new Rectangle2D.Double(0, 50, 540, 380);

		my2DChart.draw(Graphics_Chart, Chart_Region);
		Graphics_Chart.dispose();

		Add_Chart_Content.addTemplate(template_Chart_Holder, 0, 0);
	}

	public static void vizeFinal75_100() throws DocumentException {

		for (int i = 0; i < 22; i++) {
			document.add(new Phrase("\n"));
		}
		document.add(new Phrase("                          ", cellFont1));
		PdfPTable tableC1 = new PdfPTable(new float[] { 30, 60, 135, 60 });
		tableC1.setWidthPercentage(65);
		PdfPCell c1 = new PdfPCell(new Phrase("Vize - Final 75-100 arası öğrencilerin listesi", cellFont3));// tablo
																											// name
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setColspan(4);
		tableC1.addCell(c1);

		c1 = new PdfPCell(new Phrase("S.N", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// tablo baslik 2 sıra no
		c1 = new PdfPCell(new Phrase("Öğrenci No", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// tablo baslik 2 Ogrenci No
		c1 = new PdfPCell(new Phrase("Adı Soyadı", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// tablo baslik 2 Adi Soyadi
		c1 = new PdfPCell(new Phrase("Başarı Notu", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// tablo baslik 2 Basari Notu

		for (int i = 0; i < dRead.BetweenNoteNameSurname.length; i++) {
			c1 = new PdfPCell(new Phrase(Integer.toString(letterGradeCount), cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);
			letterGradeCount++;

			c1 = new PdfPCell(new Phrase(dRead.BetweenNoteNumber[i], cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);

			c1 = new PdfPCell(new Phrase(dRead.BetweenNoteNameSurname[i], cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			tableC1.addCell(c1);

			c1 = new PdfPCell(new Phrase(dRead.BetweenNoteNameSurnameLetterGrade[i], cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);

		}
		tableC1.setHeaderRows(1);
		document.add(tableC1);
		letterGradeCount = 1;
	}

	public static void harfNotlarinaGoreTabloOlusturmaAA_BA() throws DocumentException {

		document.add(new Phrase("                          ", cellFont1));
		PdfPTable tableC1 = new PdfPTable(new float[] { 30, 60, 135, 60 });
		tableC1.setWidthPercentage(65); // tablo boyutunu ayarlar.
		PdfPCell c1 = new PdfPCell(new Phrase("Harf Notu AA-BA olan öğrencilerin listesi", cellFont3));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setColspan(4);
		tableC1.addCell(c1);

		c1 = new PdfPCell(new Phrase("S.N", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// tablo baslik 2 sıra no
		c1 = new PdfPCell(new Phrase("Öğrenci No", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// tablo baslik 2 Ogrenci No
		c1 = new PdfPCell(new Phrase("Adı Soyadı", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// tablo baslik 2 Adi Soyadi
		c1 = new PdfPCell(new Phrase("Başarı Notu", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// tablo baslik 2 Basari Notu

		for (int i = 0; i < dRead.arrayListStudentInformation.size(); i++) {
			StudentInformation studentInformation = dRead.arrayListStudentInformation.get(i);
			if (studentInformation.LetterGrade.equals("AA") || studentInformation.LetterGrade.equals("BA")) {

				c1 = new PdfPCell(new Phrase(Integer.toString(letterGradeCount), cellFont));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				tableC1.addCell(c1);

				c1 = new PdfPCell(new Phrase(studentInformation.StudentNumber, cellFont));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				tableC1.addCell(c1);

				c1 = new PdfPCell(new Phrase(studentInformation.StudentNameSurname, cellFont));
				c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				tableC1.addCell(c1);

				c1 = new PdfPCell(new Phrase(studentInformation.LetterGrade, cellFont));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				tableC1.addCell(c1);
				letterGradeCount++;
			}

		}
		tableC1.setHeaderRows(1);
		document.add(tableC1);
		letterGradeCount = 1;
	}

	public static void harfNotlarinaGoreTabloOlusturmaD_FF() throws DocumentException {
		document.add(new Phrase("                          ", cellFont1));
		PdfPTable tableC1 = new PdfPTable(new float[] { 30, 60, 135, 60 });
		tableC1.setWidthPercentage(65); // tablo boyutunu ayarlar.
		PdfPCell c1 = new PdfPCell(new Phrase("Harf Notu D-FF olan öğrencilerin listesi", cellFont3));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setColspan(4);
		tableC1.addCell(c1);

		c1 = new PdfPCell(new Phrase("S.N", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// tablo baslik 2 sıra no
		c1 = new PdfPCell(new Phrase("Öğrenci No", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// tablo baslik 2 Ogrenci No
		c1 = new PdfPCell(new Phrase("Adı Soyadı", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// tablo baslik 2 Adi Soyadi
		c1 = new PdfPCell(new Phrase("Başarı Notu", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// tablo baslik 2 Basari Notu

		for (int i = 0; i < dRead.arrayListStudentInformation.size(); i++) {
			StudentInformation studentInformation = dRead.arrayListStudentInformation.get(i);
			if (studentInformation.LetterGrade.equals("D ") || studentInformation.LetterGrade.equals("FF")) {

				c1 = new PdfPCell(new Phrase(Integer.toString(letterGradeCount), cellFont));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				tableC1.addCell(c1);

				c1 = new PdfPCell(new Phrase(studentInformation.StudentNumber, cellFont));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				tableC1.addCell(c1);

				c1 = new PdfPCell(new Phrase(studentInformation.StudentNameSurname, cellFont));
				c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				tableC1.addCell(c1);

				c1 = new PdfPCell(new Phrase(studentInformation.LetterGrade, cellFont));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				tableC1.addCell(c1);
				letterGradeCount++;
			}

		}
		tableC1.setHeaderRows(1);
		document.add(tableC1);
		letterGradeCount = 1;
	}
}
