package PdfProject;

import java.sql.Connection;
import java.sql.ResultSet;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.mysql.jdbc.Statement;

public class CPdfCreate extends CPdfRead {
	static int count = 0;
	static int indeks = 0;
	static double ortalama = 1;
	static String ortalamaString;

	public void PdfCreate2() throws Exception {
		CPdfWordPartition cPdfWordPartition = new CPdfWordPartition();
		String fileNew = "D:/dowlandPdf/C2Pdf1.pdf";
		// Creating a PdfDocument object
		PdfDocument pdfDoc = new PdfDocument(new PdfWriter(fileNew));

		// Creating a Document object
		Document doc = new Document(pdfDoc);

		float[] pointColumnWidths = { 50F, 200F, 50F, 50F };
		Table table = new Table(pointColumnWidths);

		DatabaseConnection databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.veritabaninaBaglan();
		Statement smt = (Statement) databaseConnection.con.createStatement();

		String q = "select*from c_ogrenci_ders_degerlendirme_anketi";

		ResultSet rs = smt.executeQuery(q);
		Paragraph paragraph0 = new Paragraph("Anket sorularini cevaplayanlarin sayisi" + min);
		Paragraph paragraph = new Paragraph("Anket puanlarinin minimum degeri: " + min);
		doc.add(paragraph);
		Paragraph paragraph1 = new Paragraph("Anket puanlarinin maksimum degeri: " + max);
		doc.add(paragraph1);
		Paragraph paragraph2 = new Paragraph("Anket puanlarinin ortalama degeri: " + average);
		doc.add(paragraph2);
		Paragraph paragraph3 = new Paragraph(
				"Anket puani sifirin altindaki sorularin toplam sayisi: " + countZeroUnder);
		doc.add(paragraph3);
		Paragraph paragraph4 = new Paragraph(
				"Anket puani bes puanin ustundeki sorularin toplam sayisi: " + countFiveOn);
		doc.add(paragraph4);
//		Paragraph paragraph5 = new Paragraph(
//				"Anket puani 2.6 ve altindaki sorularin toplam sayisi: " + countTwoDotSixUnder);
//		doc.add(paragraph5);
		Paragraph paragraph6 = new Paragraph(
				"Anket puani '2.7 >= anketPuani > 2.6' arasindaki sorularin toplam sayisi: "
						+ countTwoDotSevenBetweenTwoDotSix);
		doc.add(paragraph6);

		Paragraph paragraph7 = new Paragraph(
				"Anket puani '2.8 >= anketPuani > 2.7' arasindaki sorularin toplam sayisi: "
						+ countTwoDotEightBetweenTwoDotSeven);
		doc.add(paragraph7);
		Paragraph paragraph8 = new Paragraph(
				"Anket puani '2.9 >= anketPuani > 2.8' arasindaki sorularin toplam sayisi: "
						+ countTwoDotNineBetweenTwoDotEight);
		doc.add(paragraph8);
		Paragraph paragraph9 = new Paragraph("Anket puani '3 >= anketPuani > 2.9' arasindaki sorularin toplam sayisi: "
				+ countthreeBetweenTwoDotNine);
		doc.add(paragraph9);

		doc.close();
	}
}

/*
 * Cell c1 = new Cell(); // Creating cell 1 c1.add(rs.getString("id")); //
 * Adding name to cell 1 c1.setBackgroundColor(Color.YELLOW); // Setting
 * background color c1.setBorder(Border.NO_BORDER); // Setting border
 * c1.setTextAlignment(TextAlignment.CENTER); // Setting text alignment
 * table.addCell(c1);
 * 
 * Cell c2 = new Cell(); c2.add(rs.getString("sorulan_anket_sorusu"));
 * c2.setBackgroundColor(Color.RED); c2.setBorder(Border.NO_BORDER);
 * c2.setTextAlignment(TextAlignment.CENTER); table.addCell(c2);
 * 
 * // Populating row 2 and adding it to the table Cell c3 = new Cell();
 * c3.add(rs.getString("katilan_ogrenci_sayisi"));
 * c3.setBackgroundColor(Color.BLUE); c3.setBorder(Border.NO_BORDER);
 * c3.setTextAlignment(TextAlignment.CENTER); table.addCell(c3);
 * 
 * Cell c4 = new Cell(); c4.add(rs.getString("anket_puani"));
 * c4.setBackgroundColor(Color.ORANGE); c4.setBorder(Border.NO_BORDER);
 * c4.setTextAlignment(TextAlignment.CENTER); table.addCell(c4);
 * 
 */
