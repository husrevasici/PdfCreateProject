package PdfProject;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class CPdfRead extends ProgramInterface {
	static String pdfFileInText;
	static ArrayList<String> arrayList = new ArrayList<String>();
	static ArrayList<Integer> arrayListKatilanOgrenciSayisi = new ArrayList<Integer>();
	static ArrayList<Integer> arrayListid = new ArrayList<Integer>();
	static ArrayList<Double> arrayListAnketPuani = new ArrayList<Double>();
	static ArrayList<String> arrayListAnketSorulari = new ArrayList<String>();
	static ArrayList<Integer> arrayListCount = new ArrayList<Integer>();
	static ArrayList<Integer> arrayListCount1 = new ArrayList<Integer>();

	static String min, max, average;
	static int countTwoDotSixBetweenFive, countTwoDotSevenBetweenTwoDotSix, countTwoDotEightBetweenTwoDotSeven,
			countTwoDotNineBetweenTwoDotEight, countthreeBetweenTwoDotNine, countZeroUnder, countFiveOn,
			countthreeBetweenFive,countTwoDotFiveUnder;
	static String coutAnketSorulariKatilanAverage, countAnketSorularinaKatilanMin, countAnketSorulariKatilanMax;

	static String array[];
	static Hashtable<String, String> hashTable = new Hashtable<String, String>();
	static Pattern p, p1;
	static Matcher m, m1;

	public void pdfRead() throws Exception {
		CPdfLineEdit cPdfLineEdit = new CPdfLineEdit();
		CPdfWordPartition cPdfWordPartition = new CPdfWordPartition();
		// File file = new File(fileName);
		File file = new File("C:/Users/Mulla Husrev Asici/Documents/MUDEK_CENG307 -Redacted.pdf");
		PDDocument document = PDDocument.load(file);
// 
		// PDFTextStripper pdfStripper = new PDFTextStripper();

		// String text = pdfStripper.getText(document);

		if (!document.isEncrypted()) {

			PDFTextStripper tStripper = new PDFTextStripper();
			tStripper.setStartPage(8);
			tStripper.setEndPage(9);
			pdfFileInText = tStripper.getText(document);
			array = pdfFileInText.split("\\r?\\n");
		}

		for (int i = 0; i < array.length; i++) {
			arrayList.add(array[i]);
			System.out.println(i + ".indeks-->> " + arrayList.get(i));
		}

		// arrayList.remove(o);
		cPdfLineEdit.pdfLineEditIndexFind();
		cPdfWordPartition.Partition();

		System.out.println("min-->" + min);
		System.out.println("max-->" + max);
		System.out.println("average-->" + average);

	}
}
