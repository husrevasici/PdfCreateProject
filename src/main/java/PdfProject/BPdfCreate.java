package PdfProject;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;

public class BPdfCreate extends BPdfRead {

	public void PdfCreate2() throws Exception {

		String fileNew = "D:/b_dönem_sonu_raporu.pdf";
		// Creating a PdfDocument object
		PdfDocument pdfDoc = new PdfDocument(new PdfWriter(fileNew));

		// Creating a Document object
		Document doc = new Document(pdfDoc);

		// Creating a table
		Table table = new Table(2);

		// Adding cells to the table

		table.addCell(new Cell().add("Dersin Kodu, Adı ve Yarıyılı"));
		table.addCell(new Cell().add(hashTable.get("Dersin Kodu, Adı ve Yarıyılı")));

		table.addCell(new Cell().add("Öğretim Üyesinin Ünvanı, Adı ve Soyadı"));
		table.addCell(new Cell().add(hashTable.get("Öğretim Üyesinin Ünvanı, Adı ve Soyadı")));

		table.addCell(new Cell().add("Toplam Öğrenci"));
		table.addCell(new Cell().add(hashTable.get("Toplam Öğrenci")));

		table.addCell(new Cell().add("Genel Ortalama"));
		table.addCell(new Cell().add(hashTable.get("Genel Ortalama")));

		table.addCell(new Cell().add("En düşük ortalama"));
		table.addCell(new Cell().add(hashTable.get("En düşük ortalama")));

		table.addCell(new Cell().add("En yüksek ortalama"));
		table.addCell(new Cell().add(hashTable.get("En yüksek ortalama")));

		// Adding Table to document
		doc.add(table);
		doc.close();
	}
}
