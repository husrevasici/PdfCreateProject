package PdfProject;

import java.sql.Connection;
import java.sql.ResultSet;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;

import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.mysql.jdbc.Statement;
import com.itextpdf.text.pdf.BaseFont;

public class DPdfCreate extends DPdfRead {
	public static final String FONT = "resources/fonts/FreeSans.ttf";
	public static final String dest = "D:/dowlandPdf/D4Version50FdenemePdf.pdf";
	static String resultsFromTheMidtermExamLetterGradeName[] = { "D", "AA", "BA", "BB", "CB", "CC", "DC", "DD", "FD",
			"FF" };

	public void pdfCreate() throws Exception {
		// Creating a PdfWriter object
		PdfWriter writer = new PdfWriter(dest);

		// Creating a PdfDocument object
		PdfDocument pdfDoc = new PdfDocument(writer);

		// Creating a Document object
		Document doc = new Document(pdfDoc);

		DatabaseConnection databaseConnection = new DatabaseConnection();
		Connection connection = databaseConnection.veritabaninaBaglan();
		Statement smt = (Statement) databaseConnection.con.createStatement();
		String q = "select*from d_not_cizelgesi";
		ResultSet rs = smt.executeQuery(q);
//		Paragraph paragraph1 = new Paragraph("D-DERS NOT CIZELGESI RAPOR");
//		doc.add(paragraph1);
		Table table, table1, table2, table3, table4, table5;
		float[] pointColumnWidths = { 450F, 70F, 70F };
		float[] pointColumnWidths1 = { 100F, 70F };
		float[] pointColumnWidths2 = { 100F, 100F, 100F, 100F, 100F, 100F, 100F, 100F };
		float[] pointColumnWidths3 = { 180F, 130F };
		float[] pointColumnWidths4 = { 310F };

		Cell cell;
		// PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
//		BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN, "Cp1254", BaseFont.EMBEDDED);
//		Font catFont = new Font(bf, 12, Font.BOLD);

		table = new Table(pointColumnWidths);
		table.addHeaderCell("Ayrıntı");
		table.addHeaderCell("Vize");
		table.addHeaderCell("Final");
		table.setSkipFirstHeader(true); // tablo yeni sayfaya gecerse yeni sayfada baslik koyar
		table1 = new Table(pointColumnWidths1);
		table1.addHeaderCell("Harf Notu");
		table1.addHeaderCell("Sayi");
		table1.setSkipFirstHeader(true); // tablo yeni sayfaya gecerse yeni sayfada baslik koyar

		table2 = new Table(pointColumnWidths2);
		table3 = new Table(pointColumnWidths3);
		table3.addHeaderCell("Isım");
		table3.addHeaderCell("Numara");

		table4 = new Table(pointColumnWidths4);
		table4.addHeaderCell("Isım");
		table4.addHeaderCell("Numara");
//		Font font = new Font(FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.WHITE);
//        // create header cell
//        PdfPCell cell = new PdfPCell(new Phrase("HMKCODE.com - iText PDFTable Example",font));
		for (int aw = 0; aw < 1; aw++) {
			cell = new Cell().add("Ortalama");
			// cell.setBackgroundColor(Color.PINK);
			cell.setBorder(Border.NO_BORDER);
			cell.setTextAlignment(TextAlignment.LEFT);
			cell.setBorder(new SolidBorder(Color.BLACK, 1));
			table.addCell(cell);

			cell = new Cell().add(Double.toString(resultsFromTheMidtermExamDoubleValue[aw]));
			// cell.setBackgroundColor(Color.PINK);
			cell.setBorder(Border.NO_BORDER);
			cell.setTextAlignment(TextAlignment.CENTER);
			cell.setBorder(new SolidBorder(Color.BLACK, 1));
			table.addCell(cell);

			cell = new Cell().add(Double.toString(resultsFromTheFinalExamDoubleValue[aw]));
			// cell.setBackgroundColor(Color.PINK);
			cell.setBorder(Border.NO_BORDER);
			cell.setTextAlignment(TextAlignment.CENTER);
			cell.setBorder(new SolidBorder(Color.BLACK, 1));
			table.addCell(cell);
		}
		// tablo verileri eklemek icin
		for (int aw = 0; aw < 9; aw++) {

			cell = new Cell().add(resultFromTheMidtermAndFinalReportLineName[aw]);
			// if (aw % 2 != 0)
			// cell.setBackgroundColor(Color.PINK);
			// else
			// cell.setBackgroundColor(Color.CYAN);
			cell.setBorder(Border.NO_BORDER);
			cell.setTextAlignment(TextAlignment.LEFT);
			cell.setBorder(new SolidBorder(Color.BLACK, 1));
			table.addCell(cell);

			cell = new Cell().add(Integer.toString(resultsFromTheMidtermExamIntegerValue[aw]));
//			if (aw % 2 != 0)
//				cell.setBackgroundColor(Color.PINK);
//			else
//				cell.setBackgroundColor(Color.CYAN);
			cell.setBorder(Border.NO_BORDER);
			cell.setTextAlignment(TextAlignment.CENTER);
			cell.setBorder(new SolidBorder(Color.BLACK, 1));
			table.addCell(cell);

			cell = new Cell().add(Integer.toString(resultsFromTheFinalExamIntegerValue[aw]));
//			if (aw % 2 != 0)
//				cell.setBackgroundColor(Color.PINK);
//			else
			// cell.setBackgroundColor(Color.CYAN);
			cell.setBorder(Border.NO_BORDER);
			cell.setTextAlignment(TextAlignment.CENTER);
			cell.setBorder(new SolidBorder(Color.BLACK, 1));
			table.addCell(cell);

		}
		doc.add(table);
		Paragraph paragragh = new Paragraph("");
		doc.add(paragragh);
		// tablo1 verileri eklemek icin
		for (int aw = 0; aw < 9; aw++) {
			cell = new Cell().add(resultsFromTheMidtermExamLetterGradeName[aw]);
//			if (aw % 2 != 0)
			// cell.setBackgroundColor(Color.PINK);
			// else
			// cell.setBackgroundColor(Color.CYAN);
			cell.setBorder(Border.NO_BORDER);
			cell.setTextAlignment(TextAlignment.CENTER);
			cell.setBorder(new SolidBorder(Color.BLACK, 1));
			table1.addCell(cell);

			cell = new Cell().add(Integer.toString(resultsFromTheMidtermExamLetterGrade[aw]));
			// if (aw % 2 != 0)
			// cell.setBackgroundColor(Color.PINK);
			// else
			// cell.setBackgroundColor(Color.CYAN);
			cell.setBorder(Border.NO_BORDER);
			cell.setTextAlignment(TextAlignment.CENTER);
			cell.setBorder(new SolidBorder(Color.BLACK, 1));
			table1.addCell(cell);
		}

		doc.add(table1);
		Paragraph paragragh3 = new Paragraph("");
		doc.add(paragragh);

		cell = new Cell();
		Paragraph p = new Paragraph();
		Text t1 = new Text("Vize / Final");
		t1.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		t1.setFontSize(10);
		p.add(t1);
		cell.add(p);
		// cell.setBackgroundColor(Color.YELLOW);
		cell.setBorder(Border.NO_BORDER);
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setBorder(new SolidBorder(Color.BLACK, 1));
		table2.addCell(cell);

		for (int i = 0; i < 7; i++) {
			cell = new Cell();
			Paragraph p4 = new Paragraph();
			Text t2 = new Text(BetweenNoteName[i]);
			t2.setFont(PdfFontFactory.createFont(BaseFont.TIMES_ROMAN, "Cp1254", BaseFont.EMBEDDED));
			t2.setFontSize(10);
			p4.add(t2);
			cell.add(p4);
			// cell.setBackgroundColor(Color.YELLOW);
			cell.setBorder(Border.NO_BORDER);
			cell.setTextAlignment(TextAlignment.CENTER);
			cell.setBorder(new SolidBorder(Color.BLACK, 1));
			table2.addCell(cell);
		}
		BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN, "Cp1254", BaseFont.EMBEDDED);
		Font catFont = new Font(bf, 18, Font.BOLD, BaseColor.BLUE);
		for (int i = 0; i < 7; i++) {
			cell = new Cell();
			Paragraph p5 = new Paragraph();
			Text t3 = new Text(BetweenNoteName[i]);
			t3.setFont(PdfFontFactory.createFont(BaseFont.TIMES_ROMAN, "Cp1254", BaseFont.EMBEDDED));
			t3.setFontSize(10);
			p5.add(t3);

			cell.add(p5);
			// cell.setBackgroundColor(Color.YELLOW);
			cell.setBorder(Border.NO_BORDER);
			cell.setTextAlignment(TextAlignment.CENTER);
			cell.setBorder(new SolidBorder(Color.BLACK, 1));
			table2.addCell(cell);
			// ######
			for (int j = 0; j < 7; j++) {
				cell = new Cell().add(Integer.toString(BetweenNote[i][j]));
				// if (i % 2 != 0)
				// cell.setBackgroundColor(Color.PINK);
				// else
				// cell.setBackgroundColor(Color.CYAN);
				cell.setBorder(Border.NO_BORDER);
				cell.setTextAlignment(TextAlignment.CENTER);
				cell.setBorder(new SolidBorder(Color.BLACK, 1));
				table2.addCell(cell);
			}
		}
		doc.add(table2);
		AreaBreak aB = new AreaBreak();
		doc.add(aB);

		for (int i = 0; i < BetweenNoteNameSurname.length; i++) {
			cell = new Cell().add((BetweenNoteNameSurname[i]));
			// if (i % 2 != 0)
			// cell.setBackgroundColor(Color.PINK);
			// else
			// cell.setBackgroundColor(Color.CYAN);
			cell.setBorder(Border.NO_BORDER);
			cell.setTextAlignment(TextAlignment.LEFT);
			cell.setBorder(new SolidBorder(Color.BLACK, 1));
			table3.addCell(cell);

			cell = new Cell().add((BetweenNoteNumber[i]));
			// if (i % 2 != 0)
			// cell.setBackgroundColor(Color.PINK);
			// else
			// cell.setBackgroundColor(Color.CYAN);
			cell.setBorder(Border.NO_BORDER);
			cell.setTextAlignment(TextAlignment.CENTER);
			cell.setBorder(new SolidBorder(Color.BLACK, 1));
			table3.addCell(cell);
		}
		doc.add(table3);

		Paragraph paragragh5 = new Paragraph("");
		doc.add(paragragh);
//
//		cell = new Cell().add("D, G, 0 ve 25 altinda not alan kisiler ");
//		// cell.setBackgroundColor(Color.YELLOW);
//		cell.setBorder(Border.NO_BORDER);
//		cell.setTextAlignment(TextAlignment.CENTER);
//		cell.setBorder(new SolidBorder(Color.BLACK, 1));
//		table4.addCell(cell);

		table4 = new Table(pointColumnWidths3);

		for (int i = 0; i < BetweenNoteNameSurname1.length; i++) {

			cell = new Cell();
			Paragraph p5 = new Paragraph();
			Text t3 = new Text(BetweenNoteNameSurname1[i]);
			t3.setFont(PdfFontFactory.createFont(BaseFont.TIMES_ROMAN, "Cp1254", BaseFont.EMBEDDED));
			t3.setFontSize(10);
			p5.add(t3);
			cell.add(p5);
			cell.setBorder(Border.NO_BORDER);
			cell.setTextAlignment(TextAlignment.LEFT);
			cell.setBorder(new SolidBorder(Color.BLACK, 1));
			table4.addCell(cell);

			cell = new Cell();
			Paragraph p6 = new Paragraph();
			Text t4 = new Text(BetweenNoteNumber1[i]);
			t4.setFont(PdfFontFactory.createFont(BaseFont.TIMES_ROMAN, "Cp1254", BaseFont.EMBEDDED));
			t4.setFontSize(10);
			p6.add(t4);
			cell.add(p6);
			cell.setBorder(Border.NO_BORDER);
			cell.setTextAlignment(TextAlignment.CENTER);
			cell.setBorder(new SolidBorder(Color.BLACK, 1));
			table4.addCell(cell);

		}
		doc.add(table4);

		doc.close();
		System.out.println("Background added successfully..");
	}

}
