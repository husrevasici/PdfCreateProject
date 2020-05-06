package PdfProject;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class BPdfRead extends Anasayfa {

	static private String array[];
	static Hashtable<String, String> hashTable = new Hashtable<String, String>();
	static ArrayList<String> arrayList = new ArrayList<String>();
	static Pattern p;
	static Matcher m;
	static String pdfFileInText;

	public void pdfRead() throws Exception {

		BPdfLineEdit bPdfLineEdit = new BPdfLineEdit();
		File file = new File(fileName);
		//File file = new File("/D:/B.pdf");
		PDDocument document = PDDocument.load(file);

		PDFTextStripper pdfStripper = new PDFTextStripper();

		String text = pdfStripper.getText(document);

		if (!document.isEncrypted()) {

			PDFTextStripper tStripper = new PDFTextStripper();
			pdfFileInText = tStripper.getText(document);
			array = pdfFileInText.split("\\r?\\n");
		}

		for (int i = 0; i < array.length; i++) {
			arrayList.add(array[i]);
			// System.out.println(arrayList.get(i));
		}
		bPdfLineEdit.pdfLineEditIndexFind();

	}

}
