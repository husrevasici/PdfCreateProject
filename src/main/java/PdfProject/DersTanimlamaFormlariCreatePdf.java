package PdfProject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.BaseFont;
import com.mysql.jdbc.Statement;

public class DersTanimlamaFormlariCreatePdf {
	private static final String DEFAULT_ENCODING = "cp1254";
	private static final String DEFAULT_FONT = "times-roman";
	Font cellFont = FontFactory.getFont(DEFAULT_FONT, DEFAULT_ENCODING, 7, Font.NORMAL);

	public static void pdfCreate() throws Exception {
		// Creating a PdfWriter object
		String dest = "D:/dowlandPdf/BM358DersTanimlamaFormlariPdfVersion3.pdf";
		PdfWriter writer = new PdfWriter(dest);
		// Creating a PdfDocument object
		PdfDocument pdfDoc = new PdfDocument(writer);

		// Creating a Document object
		Document doc = new Document(pdfDoc);

		DatabaseConnection databaseConnection = new DatabaseConnection();
		Connection connection = (Connection) databaseConnection.veritabaninaBaglan();

		Statement smt = (Statement) databaseConnection.con.createStatement();
		Statement smt1 = (Statement) databaseConnection.con.createStatement();

		String q = "select*from ders_tanimlama_formu";
		String q1 = "select*from ders_tanimlama_formu_control";
		ResultSet rs = smt.executeQuery(q);
		ResultSet rs1 = smt1.executeQuery(q1);
		// Creating a table

		ArrayList<String> dersTanimlamaFormlari = new ArrayList<String>();
		ArrayList<String> dersTanimlamaFormlariControlLineValue = new ArrayList<String>();
		ArrayList<String> dersTanimlamaFormlariControlLineName = new ArrayList<String>();

		while (rs.next()) {
			dersTanimlamaFormlari.add(rs.getString("id"));
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
			dersTanimlamaFormlari.add(rs1.getString("id"));
			dersTanimlamaFormlari.add(rs1.getString("DersinYariyili"));
			dersTanimlamaFormlari.add(rs1.getString("DersinKredisi"));
			dersTanimlamaFormlari.add(rs1.getString("DersinOnkosullari"));
			dersTanimlamaFormlari.add(rs1.getString("DersinTuru"));
			dersTanimlamaFormlari.add(rs1.getString("OgretimDili"));
		}
		dersTanimlamaFormlari.add("id");
		dersTanimlamaFormlari.add("Dersin Yarıyılı");
		dersTanimlamaFormlari.add("Dersin Kredisi");
		dersTanimlamaFormlari.add("Dersin Önkoşulları");
		dersTanimlamaFormlari.add("Dersin Tütü");
		dersTanimlamaFormlari.add("Öğretim Dili");

		for (int i = 0; i < 6; i++) {
			if (dersTanimlamaFormlari.get(i).equalsIgnoreCase(dersTanimlamaFormlari.get(i + 6))) {
				Paragraph p4 = new Paragraph();
				Text t2 = new Text(
						"Dökümanda verilen " + dersTanimlamaFormlari.get(i + 12) + " kısmı doğru olarak girilmiştir.");
				t2.setFont(PdfFontFactory.createFont(BaseFont.TIMES_ROMAN, "Cp1254", BaseFont.EMBEDDED));
				t2.setFontSize(10);
				p4.add(t2);
				doc.add(p4);
			} else {
				Paragraph p4 = new Paragraph();
				Text t2 = new Text(
						"Dökümanda verilen " + dersTanimlamaFormlari.get(i + 12) + " kısmı yanlış olarak girilmiştir.");
				t2.setFont(PdfFontFactory.createFont(BaseFont.TIMES_ROMAN, "Cp1254", BaseFont.EMBEDDED));
				t2.setFontSize(10);
				p4.add(t2);
				doc.add(p4);
			}
		}
		for (int i = 0; i < dersTanimlamaFormlariControlLineValue.size(); i++) {
			if (dersTanimlamaFormlariControlLineValue.get(i) == null) {
				Paragraph p4 = new Paragraph();
				Text t2 = new Text("Dökümanda verilen " + dersTanimlamaFormlariControlLineName.get(i)
						+ "boştur. Lütfen kontrol ediniz ve doldurunuz.");
				t2.setFont(PdfFontFactory.createFont(BaseFont.TIMES_ROMAN, "Cp1254", BaseFont.EMBEDDED));
				t2.setFontSize(10);
				p4.add(t2);
				doc.add(p4);
			} else {
				Paragraph p4 = new Paragraph();
				Text t2 = new Text(
						"Dökümanda verilen " + dersTanimlamaFormlariControlLineName.get(i) + " kısmı doldurulmuştur.");
				t2.setFont(PdfFontFactory.createFont(BaseFont.TIMES_ROMAN, "Cp1254", BaseFont.EMBEDDED));
				t2.setFontSize(10);
				p4.add(t2);
				doc.add(p4);
			}
		}

		// Closing the document
		doc.close();

		System.out.println("Background added successfully..");

	}

}
