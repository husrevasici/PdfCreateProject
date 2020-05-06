package PdfProject;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class DersTanimlamaFormlariDersinIsYukuPdfCreate extends mudekPdfReportCreate {

	public static void pdfCreate(Document document) throws DocumentException, Exception {

		DersTanimlamaFormlariRead dersTanimlamaReadObject = new DersTanimlamaFormlariRead();
		document.add(new Phrase("                          ", cellFont1));
		document.add(new Phrase("                          ", cellFont1));
		PdfPTable tableC1 = new PdfPTable(new float[] { 130, 40, 60, 60 });
		tableC1.setWidthPercentage(65); // tablo boyutunu ayarlar.
		PdfPCell c1 = new PdfPCell(new Phrase("Dersin İş Yükü", cellFont3));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setColspan(4);
		tableC1.addCell(c1);

		c1 = new PdfPCell(new Phrase("Etkinlik", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// tablo baslik 2 Etkinlik
		c1 = new PdfPCell(new Phrase("Toplam Hafta Sayısı", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// tablo baslik 2 Toplam Hafta Sayısı
		c1 = new PdfPCell(new Phrase("Süre(Haftalık Saat)", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// tablo baslik 2 Süre (haftalık saaat)
		c1 = new PdfPCell(new Phrase("Dönem Sonu Toplam İş Yükü", cellFont));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableC1.addCell(c1);
// tablo baslik 2 Dönem Sonu Toplam İş Yükü

		for (int i = 0; i < 5; i++) {
			DersinIsYukuValueAdd dersinIsYuku = dersTanimlamaReadObject.arrayListDersinIsYuku.get(i);

			c1 = new PdfPCell(new Phrase(dersinIsYuku.etkinlik, cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			tableC1.addCell(c1);

			c1 = new PdfPCell(new Phrase(dersinIsYuku.toplamhaftaSayisi, cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);

			c1 = new PdfPCell(new Phrase(dersinIsYuku.süre, cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);

			c1 = new PdfPCell(new Phrase(dersinIsYuku.donemSonuToplamIsYuku, cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);
		}
		for (int i = 5; i < 8; i++) {
			DersinIsYukuValueAdd dersinIsYuku = dersTanimlamaReadObject.arrayListDersinIsYuku.get(i);

			c1 = new PdfPCell(new Phrase(dersinIsYuku.etkinlik, cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			tableC1.addCell(c1);

			c1 = new PdfPCell(new Phrase("", cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);

			c1 = new PdfPCell(new Phrase("", cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);

			c1 = new PdfPCell(new Phrase(dersinIsYuku.toplamhaftaSayisi, cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);
		}
		for (int i = 8; i < 10; i++) {
			DersinIsYukuValueAdd dersinIsYuku = dersTanimlamaReadObject.arrayListDersinIsYuku.get(i);

			c1 = new PdfPCell(new Phrase(dersinIsYuku.etkinlik, cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			tableC1.addCell(c1);

			c1 = new PdfPCell(new Phrase(dersinIsYuku.toplamhaftaSayisi, cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);

			c1 = new PdfPCell(new Phrase(dersinIsYuku.süre, cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);

			c1 = new PdfPCell(new Phrase(dersinIsYuku.donemSonuToplamIsYuku, cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);
		}
		for (int i = 10; i < 14; i++) {
			DersinIsYukuValueAdd dersinIsYuku = dersTanimlamaReadObject.arrayListDersinIsYuku.get(i);

			c1 = new PdfPCell(new Phrase(dersinIsYuku.etkinlik, cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			tableC1.addCell(c1);

			c1 = new PdfPCell(new Phrase("", cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);

			c1 = new PdfPCell(new Phrase("", cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);

			c1 = new PdfPCell(new Phrase(dersinIsYuku.toplamhaftaSayisi, cellFont));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableC1.addCell(c1);
		}

		tableC1.setHeaderRows(1);
		document.add(tableC1);

	}
}
