package PdfProject;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class DersTanimlamaFormlariDegerlendirmeOlcutleriPdfCreate extends mudekPdfReportCreate {

	public static void pdfCreate(Document document) throws DocumentException, Exception {
		DersTanimlamaFormlariRead dersTanimlamaReadObject = new DersTanimlamaFormlariRead();
		document.add(new Phrase("                          ", cellFont1));
		document.add(new Phrase("                          ", cellFont1));
		PdfPTable tableC1 = new PdfPTable(new float[] { 100, 42, 70 });
		tableC1.setWidthPercentage(45); // tablo boyutunu ayarlar.
		PdfPCell c1 = new PdfPCell(new Phrase("Değerlendirme Ölçütleri", cellFont3));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setColspan(3);
		tableC1.addCell(c1);

		c1 = new PdfPCell(new Phrase("", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// tablo baslik 2 sıra no
		c1 = new PdfPCell(new Phrase("Sayısı", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// tablo baslik 2 Ogrenci No
		c1 = new PdfPCell(new Phrase("Toplam Katkısı (%)", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// tablo baslik 2 Adi Soyadi

		for (int i = 0; i < dersTanimlamaReadObject.arrayListDegerlendirmeOlcutleri.size(); i++) {
			DegerOlcutleri degerOlcutleri = dersTanimlamaReadObject.arrayListDegerlendirmeOlcutleri.get(i);

			c1 = new PdfPCell(new Phrase(degerOlcutleri.adi, cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			tableC1.addCell(c1);

			c1 = new PdfPCell(new Phrase(degerOlcutleri.sayisi, cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);

			c1 = new PdfPCell(new Phrase(degerOlcutleri.toplamKatkisi, cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);

		}
		tableC1.setHeaderRows(1);
		document.add(tableC1);

	}
}
