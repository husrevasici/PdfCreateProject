package PdfProject;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class DersTanimlamaFormlariRead extends DersTanimlamaFormlari {

	static String array[];
	static String pdfFileInText;
	static ArrayList<String> arrayList = new ArrayList<String>();
	static ArrayList<String> arrayListNew = new ArrayList<String>();
	static ArrayList<DegerOlcutleri> arrayListDegerlendirmeOlcutleri = new ArrayList<DegerOlcutleri>();
	static ArrayList<DersinIsYukuValueAdd> arrayListDersinIsYuku = new ArrayList<DersinIsYukuValueAdd>();

	public void pdfRead() throws Exception {
		DegerlendirmeOlcutleri dTFEPL2 = new DegerlendirmeOlcutleri();
		DersinIsYuku dIY = new DersinIsYuku();
		ProgramInterface p = new ProgramInterface();
		//File file = new File(p.fileName);
		 File file = new File("C:/Users/Mulla Husrev Asici/Documents/MUDEK_CENG307 -Redacted2.pdf");
		// D:\BM101-Turkce.pdf

		PDDocument document = PDDocument.load(file);

		// PDFTextStripper pdfStripper = new PDFTextStripper();

		// String text = pdfStripper.getText(document);

		if (!document.isEncrypted()) {
			PDFTextStripper tStripper = new PDFTextStripper();
			tStripper.setStartPage(14);
			tStripper.setEndPage(17);
			pdfFileInText = tStripper.getText(document);
			array = pdfFileInText.split("\\r?\\n");
		}

		for (int i = 0; i < array.length; i++) { // pdf ten satır satır okunan verinin ilk hali
			arrayList.add(array[i].trim());
			System.out.println(i + ".indeks: " + arrayList.get(i));
		}

		DersTanimlamaFormlariPdfLineEdit d = new DersTanimlamaFormlariPdfLineEdit();
		d.pdfLineEditIndexFind();
		for (int i = 0; i < arrayListNew.size(); i++) {
			// DersTanimlamaFormlarıPdfLineEdit classindan satir ve karsisinda bilgi
			// seklinde duzenlendigindeki hali
			System.out.println(i + ".indeks: " + arrayListNew.get(i));
		}

		pdfReadAndInserHashTable();
		System.out.println("////////////////////////////////////");
		editId();
		System.out.println("***********************************");
		dTFEPL2.start(); // degerlendirme olcutleri
		System.out.println("------------------------------------");
		dIY.start(); // dersin is yuku

		for (DegerOlcutleri deger : arrayListDegerlendirmeOlcutleri) {
			// DegerlendirmeOlcutleri classindan degerlendirme olcutleri kisminin
			// duzenlenmesi
//			System.out.println(deger.adi + deger.sayisi + deger.toplamKatkisi);
		}
		System.out.println("####################################");
		for (DersinIsYukuValueAdd deger : arrayListDersinIsYuku) {
			// DersinIsYuku classindan duzenlenen verinin gosterilmesi
//			System.out.println(deger.etkinlik + " " + deger.toplamhaftaSayisi + " " + deger.süre + " "
//					+ deger.donemSonuToplamIsYuku);
		}

	} // end function --> pdfRead

	public void pdfReadAndInserHashTable() throws Exception {

		for (int i = 0; i < word2.length; i++) {
			p = Pattern.compile(word2[i]);
			InsertHashTable();

		}

	} // end function --> pdfReadAndInserHashTable

	public static void InsertHashTable() throws Exception {
		for (int i = 0; i < arrayListNew.size(); i++) {
			m = p.matcher(arrayListNew.get(i));
			if (m.matches()) {
				h.put(m.group(1), m.group(2).trim());
				System.out.println(i + 1 + "->>" + m.group(1) + " ****** " + "-->>" + m.group(2).trim());

			} // end if
		} // end for

	} // end InsertHashTable

	public void editId() throws Exception {

		Pattern pEdit = Pattern.compile("\\b([Bb][Mm])\\s*+(\\d{2,3})\\b", Pattern.CASE_INSENSITIVE);
		Matcher mEdit;

		mEdit = pEdit.matcher(h.get("Dersin Kodu ve Adı"));
		System.out.println(h.get("Dersin Kodu ve Adı"));
		while (mEdit.find()) {
			h.put("id", mEdit.group(2));
//			System.out.println(mEdit.group(1) + mEdit.group(2));
//			System.out.println("h.get(id)--->>>>" + h.get("id"));
		}
	} // end function --> pdfReadAndInserHashTable
} // end class
