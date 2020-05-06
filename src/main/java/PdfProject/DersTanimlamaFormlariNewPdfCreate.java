package PdfProject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DersTanimlamaFormlariNewPdfCreate extends mudekPdfReportCreate {

	// public static void pdfCreate(Document document) throws Exception {
//	}
	static ArrayList<String> dersTanimlamaFormlari = new ArrayList<String>();
	static ArrayList<String> dersTanimlamaFormlariControlLineValue = new ArrayList<String>();
	static ArrayList<String> dersTanimlamaFormlariControlLineName = new ArrayList<String>();

	public static void pdfCreate() throws Exception {

		DatabaseConnection databaseConnection = new DatabaseConnection();
		Connection connection = (Connection) databaseConnection.veritabaninaBaglan();

		String q = "select*from ders_tanimlama_formu";
		String q1 = "select*from ders_tanimlama_formu_control";
		PreparedStatement ps = (PreparedStatement) databaseConnection.veritabaninaBaglan().prepareStatement(q);
		PreparedStatement ps1 = (PreparedStatement) databaseConnection.veritabaninaBaglan().prepareStatement(q1);

		ResultSet rs = ps.executeQuery(q);
		ResultSet rs1 = ps1.executeQuery(q1);
		// Creating a table

		while (rs.next()) {
			// dersTanimlamaFormlari.add(rs.getString("id"));
			dersTanimlamaFormlari.add(rs.getString("DersinKoduveAdi"));
			dersTanimlamaFormlari.add(rs.getString("DersinYariyili"));
			dersTanimlamaFormlari.add(rs.getString("DersinKredisi"));
			dersTanimlamaFormlari.add(rs.getString("DersinOnkosullari"));
			dersTanimlamaFormlari.add(rs.getString("DersinTuru"));
			dersTanimlamaFormlari.add(rs.getString("OgretimDili"));

			dersTanimlamaFormlariControlLineValue.add(rs.getString("Dersinİcerigi"));
			dersTanimlamaFormlariControlLineName.add("Dersin İçeriği");

			dersTanimlamaFormlariControlLineValue.add(rs.getString("DersKitabi"));
			dersTanimlamaFormlariControlLineName.add("Ders Kitabı");

			dersTanimlamaFormlariControlLineValue.add(rs.getString("YardimciDersKitaplari"));
			dersTanimlamaFormlariControlLineName.add("Yardımcı Ders Kitapları");

			dersTanimlamaFormlariControlLineValue.add(rs.getString("DersinAmaclari"));
			dersTanimlamaFormlariControlLineName.add("Dersin Amaçları");

			dersTanimlamaFormlariControlLineValue.add(rs.getString("DersinOgrenimCiktilari"));
			dersTanimlamaFormlariControlLineName.add("Dersin Öğrenim Çıktıları");

			dersTanimlamaFormlariControlLineValue.add(rs.getString("DersinVerilisBicimi"));
			dersTanimlamaFormlariControlLineName.add("Dersin Veriliş Biçimi");

			dersTanimlamaFormlariControlLineValue.add(rs.getString("DersinHaftalıkDagilimi"));
			dersTanimlamaFormlariControlLineName.add("Dersin Haftalık Dağılımı");

			dersTanimlamaFormlariControlLineValue.add(rs.getString("EgitimveOgretimFaaliyetleri"));
			dersTanimlamaFormlariControlLineName.add("Eğitim ve Öğretim Faaliyetleri");
		}
		while (rs1.next()) {
			// dersTanimlamaFormlari.add(rs1.getString("id"));
			dersTanimlamaFormlari.add(rs1.getString("DersinKoduveAdi"));
			dersTanimlamaFormlari.add(rs1.getString("DersinYariyili"));
			dersTanimlamaFormlari.add(rs1.getString("DersinKredisi"));
			dersTanimlamaFormlari.add(rs1.getString("DersinOnkosullari"));
			dersTanimlamaFormlari.add(rs1.getString("DersinTuru"));
			dersTanimlamaFormlari.add(rs1.getString("OgretimDili"));
		}
		// dersTanimlamaFormlari.add("id");
		dersTanimlamaFormlari.add("Dersin Kodu ve Adi");
		dersTanimlamaFormlari.add("Dersin Yarıyılı");
		dersTanimlamaFormlari.add("Dersin Kredisi");
		dersTanimlamaFormlari.add("Dersin Önkoşulları");
		dersTanimlamaFormlari.add("Dersin Tütü");
		dersTanimlamaFormlari.add("Öğretim Dili");

	}

	public static void pdfCreate2(Document document) throws DocumentException {
		for (int i = 0; i < dersTanimlamaFormlari.size(); i++) {

			System.out.println(dersTanimlamaFormlari.get(i));
		}
		document.add(new Phrase("\n"));
		document.add(new Phrase(""));
		document.add(new Phrase("\n"));
		document.add(new Phrase(""));
		document.add(new Phrase("                                                          Ders Tanımlama Formları  ",
				cellFont2));
		document.add(new Phrase("\n"));
		document.add(new Phrase("                          ", cellFont1));

		document.add(new Phrase("Tablo 11. Ders Tanımlama Formu Dokümanı Bilgilerini Karşılaştırma  ", cellFont1));
		PdfPTable table = new PdfPTable(3);
		PdfPCell c1 = new PdfPCell();
		// set Column span "1 cell = 6 cells width"

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

		for (int i = 0; i < 6; i++) {

			c1 = new PdfPCell(new Phrase(dersTanimlamaFormlari.get(i + 12), cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(c1);

			if (dersTanimlamaFormlari.get(i).equalsIgnoreCase(dersTanimlamaFormlari.get(i + 6))) {

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
		document.add(new Phrase("\n"));

		document.add(new Phrase("                          ", cellFont1));

		document.add(
				new Phrase("Tablo 10. Ders Uygulama Planı Dokümanında tanımlanmayan kısımların tespiti", cellFont1));
		PdfPTable table1 = new PdfPTable(3);
		PdfPCell c2 = new PdfPCell();
//		c2.setHorizontalAlignment(Element.ALIGN_CENTER);
//		c2.setColspan(3);
//		table1.addCell(c2);

		c2 = new PdfPCell(new Phrase("", cellFont));
		c2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1.addCell(c2);

		c2 = new PdfPCell(new Phrase("Dolu", cellFont));
		c2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1.addCell(c2);

		c2 = new PdfPCell(new Phrase("Boş", cellFont));
		c2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1.addCell(c2);

		for (int i = 0; i < dersTanimlamaFormlariControlLineName.size(); i++) {
			c2 = new PdfPCell(new Phrase(dersTanimlamaFormlariControlLineName.get(i), cellFont));
			c2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table1.addCell(c2);
			if (dersTanimlamaFormlariControlLineValue.get(i) == null) {
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

}