package PdfProject;

import java.io.File;

import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class DPdfRead {
	static String array[];
	static ArrayList<String> arrayList = new ArrayList<String>();
	static ArrayList<StudentInformation> arrayListStudentInformation = new ArrayList<StudentInformation>();
	static ArrayList<String> arrayListTeacherNameSurname = new ArrayList<String>();
	static ArrayList<String> arrayListLessonCodeNumberBranch = new ArrayList<String>();
	static String pdfFileInText;
	static double countAverageMidterm = 0;
	static int studentNumber = 1;

	static int resultsFromTheMidtermExamIntegerValue[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	static int resultsFromTheFinalExamIntegerValue[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	static int resultsFromTheMidtermExamLetterGrade[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	static double resultsFromTheMidtermExamDoubleValue[] = { 0, 0 };
	static double resultsFromTheFinalExamDoubleValue[] = { 0, 0 };
	static int BetweenNote[][] = { { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
	static int nameSurnameCount = 0, numberCount = 0, letterGradeCount = 0;
	static String BetweenNoteNameSurname[] = new String[3];
	static String BetweenNoteNumber[] = new String[3];
	static String BetweenNoteNameSurnameLetterGrade[] = new String[3];

	static String BetweenNoteNameSurname1[] = new String[20];
	static String BetweenNoteNumber1[] = new String[20];
	static String BetweenNoteNameSurnameLetterGrade1[] = new String[20];
	static int nameSurnameCount1 = 0, numberCount1 = 0, letterGradeCount1 = 0;

	static String BetweenNoteName[] = { "D", "G", "0 ", "0< not <25", "25<= not <50 ", "50<= note <75",
			"75<= not <100", };

	static String resultFromTheMidtermAndFinalReportLineName[] = { "Ortalamanin altinda kalan toplam ogrenci sayisi",
			"Ortalamanin ustunde olan toplam ogrenci sayisi", "0 < not < 25 arasinda not alan ogrencilerin sayisi",
			"25 <= not < 50 arasinda not alan ogrencilerin sayisi",
			"50 <= not < 75 arasinda not alan ogrencilerin sayisi",
			"75 <= not < 100 arasinda not alan ogrencilerin sayisi",
			"Devamsizlik nedeniyle giremeyen ogrencilerin sayisi", "0 alan ogrencilerin sayisi",
			"Sinava Girmeyen ogrencilerin sayisi" };

	public void pdfRead() throws Exception {
		Anasayfa p = new Anasayfa();

		File file = new File(p.fileName);
		// File file = new File("C:/Users/Mulla Husrev Asici/Documents/MUDEK_CENG307
		// -Redacted.pdf");

		PDDocument document = PDDocument.load(file);

//		PDFTextStripper pdfStripper = new PDFTextStripper();
//
//		String text = pdfStripper.getText(document);

		if (!document.isEncrypted()) {

			PDFTextStripper tStripper = new PDFTextStripper();
			tStripper.setStartPage(10);
			tStripper.setEndPage(13);
			pdfFileInText = tStripper.getText(document);
			array = pdfFileInText.split("\\r?\\n");
		}

		for (int i = 0; i < array.length; i++) {
			arrayList.add(array[i]);
			System.out.println(arrayList.get(i));
		}
		DPdfLineEdit dPdfLineEdit = new DPdfLineEdit();
		dPdfLineEdit.producingPattern();
		for (StudentInformation information : arrayListStudentInformation) {
//			System.out.println(information.StudentNumber + " " + information.StudentNameSurname + " "
//					+ information.Midterm1 + " " + information.FinalExam + " " + information.LetterGrade);
		}
		printArrayListValue(arrayListStudentInformation);

	}

	public void printArrayListValue(ArrayList<StudentInformation> arrayListStudentInformation) {

		for (int i = 0; i < arrayListStudentInformation.size(); i++) {
			StudentInformation studentInformation = arrayListStudentInformation.get(i);
			midtermAndFinalExamAverageCalculate(studentInformation.Midterm1, studentInformation.FinalExam);
		}
		System.out.println("countAverageMidterm: " + resultsFromTheMidtermExamDoubleValue[0] + " "
				+ "CountAverageFinal: " + resultsFromTheFinalExamDoubleValue[0]);
		resultsFromTheMidtermExamDoubleValue[0] /= arrayListStudentInformation.size(); // midterm average
		resultsFromTheFinalExamDoubleValue[0] /= arrayListStudentInformation.size(); // final average
		System.out.println("countAverageMidterm: " + resultsFromTheMidtermExamDoubleValue[0] + " "
				+ "CountAverageFinal: " + resultsFromTheFinalExamDoubleValue[0]);

		// ortalamanin altinda ve ustunde kalanlari hesaplama
		for (int i = 0; i < arrayListStudentInformation.size(); i++) {
			StudentInformation studentInformation = arrayListStudentInformation.get(i);
			midtermAndFinalExamReport1(studentInformation.Midterm1, studentInformation.FinalExam,
					studentInformation.LetterGrade, studentInformation.StudentNameSurname,
					studentInformation.StudentNumber);
		}
//	
	}

	public void midtermAndFinalExamAverageCalculate(String midtermExam, String finalExam) {

		// midterm D ve G yazanları ayırma
		if (midtermExam.equals("D") || midtermExam.equals("G")) {

		} else {
			resultsFromTheMidtermExamDoubleValue[0] = resultsFromTheMidtermExamDoubleValue[0]
					+ Double.parseDouble(midtermExam);
		}

		// final D ve G yazanları ayırma
		if (finalExam.equals("D") || finalExam.equals("G")) {

		} else {
			resultsFromTheFinalExamDoubleValue[0] = resultsFromTheFinalExamDoubleValue[0]
					+ Double.parseDouble(finalExam);
		}

		System.out.println(studentNumber++ + ".ogrenci: " + "arasinav notu: " + midtermExam + "--" + "toplam: "
				+ resultsFromTheMidtermExamDoubleValue[0] + " ##" + "final sinavi notu: " + finalExam + "--"
				+ "toplam: " + resultsFromTheFinalExamDoubleValue[0]);
	}

	public void midtermAndFinalExamReport1(String midtermExam, String finalExam, String letterGrade, String nameSurname,
			String number) {

		String array[] = { midtermExam, finalExam, nameSurname, number };
		for (int i = 0; i < array.length; i++) {
			midtermAndFinalExamReport2(array[i], i); // ortalama alti ve ustu hesaplama

		}
		midtermAndFinalExamReport3(midtermExam, finalExam, nameSurname, number, letterGrade); // notların aralıkları ve
																								// O, G, D
		// durumları
		midtermAndFinalExamReport4(letterGrade);
		// midtermAndFinalExamReport5(midtermExam, finalExam, nameSurname, number);

	}

	public void midtermAndFinalExamReport2(String examNote, int i) {
		if (i == 0) {
			if (examNote.equals("D")) {
				resultsFromTheMidtermExamIntegerValue[6]++;
			} else if (examNote.equals("G")) {
				resultsFromTheMidtermExamIntegerValue[8]++;
			} else if (Double.parseDouble(examNote) < resultsFromTheMidtermExamDoubleValue[0]) {
				resultsFromTheMidtermExamIntegerValue[0]++; // Midterm ortalamanin altinda kalanlarin sayisi
			} else if (Double.parseDouble(examNote) >= resultsFromTheMidtermExamDoubleValue[0]) {
				resultsFromTheMidtermExamIntegerValue[1]++; // Midterm ortalamanin ustunde kalanlarin sayisi
			} else {
				System.out.println("D, G, ortalamanin altinda veya ustunde bir deger de degil");
			}

		} else if (i == 1) {
			if (examNote.equals("D")) {
				resultsFromTheFinalExamIntegerValue[6]++;
			} else if (examNote.equals("G")) {
				resultsFromTheFinalExamIntegerValue[8]++;
			} else if (Double.parseDouble(examNote) < resultsFromTheFinalExamDoubleValue[0]) {
				resultsFromTheFinalExamIntegerValue[0]++; // final sinavinin ortalamanin altinda kalanlarin sayisi
			} else if (Double.parseDouble(examNote) >= resultsFromTheFinalExamDoubleValue[0]) {
				resultsFromTheFinalExamIntegerValue[1]++; // final sinavinin ortalamanin ustunde kalanlarin sayisi
			} else {
				System.out.println("D, G, ortalamanin altinda veya ustunde bir deger de degil");
			}
		}

	}

	public void midtermAndFinalExamReport3(String midtermExamNote, String finalExamNote, String nameSurname,
			String number, String letterGrade) {

		// Midterm Exam Note calculate
		if (midtermExamNote.equals("D")) {
			midtermExamAndFinalExamBetweenRelationalship("D", 0, finalExamNote, nameSurname, number, letterGrade);
		} else if (midtermExamNote.equals("G")) {
			midtermExamAndFinalExamBetweenRelationalship("G", 1, finalExamNote, nameSurname, number, letterGrade);
		} else if (Integer.parseInt(midtermExamNote) == 0) {
			resultsFromTheMidtermExamIntegerValue[7]++;
			midtermExamAndFinalExamBetweenRelationalship("0", 2, finalExamNote, nameSurname, number, letterGrade);

		} else if (Integer.parseInt(midtermExamNote) < 25 && Integer.parseInt(midtermExamNote) > 0) {
			resultsFromTheMidtermExamIntegerValue[2]++;
			midtermExamAndFinalExamBetweenRelationalship("0_25", 3, finalExamNote, nameSurname, number, letterGrade);
		} else if (Integer.parseInt(midtermExamNote) < 50 && Integer.parseInt(midtermExamNote) >= 25) {
			resultsFromTheMidtermExamIntegerValue[3]++;
			midtermExamAndFinalExamBetweenRelationalship("25_50", 4, finalExamNote, nameSurname, number, letterGrade);
		} else if (Integer.parseInt(midtermExamNote) < 75 && Integer.parseInt(midtermExamNote) >= 50) {
			resultsFromTheMidtermExamIntegerValue[4]++;
			midtermExamAndFinalExamBetweenRelationalship("50_75", 5, finalExamNote, nameSurname, number, letterGrade);
		} else if (Integer.parseInt(midtermExamNote) < 100 && Integer.parseInt(midtermExamNote) >= 75) {
			resultsFromTheMidtermExamIntegerValue[5]++;
			midtermExamAndFinalExamBetweenRelationalship("75_100", 6, finalExamNote, nameSurname, number, letterGrade);
		} else {
			System.out.println("Midterm sinavinda Belirlenen rakamlarin disinda bir ifade vardir.");
		}

		// final Exam Note Calculate
		if (finalExamNote.equals("D")) {

		} else if (finalExamNote.equals("G")) {

		} else if (Integer.parseInt(finalExamNote) == 0) {

			resultsFromTheFinalExamIntegerValue[7]++;

		} else if (Integer.parseInt(finalExamNote) < 25 && Integer.parseInt(finalExamNote) >= 0) {
			resultsFromTheFinalExamIntegerValue[2]++;
		} else if (Integer.parseInt(finalExamNote) < 50 && Integer.parseInt(finalExamNote) >= 25) {
			resultsFromTheFinalExamIntegerValue[3]++;
		} else if (Integer.parseInt(finalExamNote) < 75 && Integer.parseInt(finalExamNote) >= 50) {
			resultsFromTheFinalExamIntegerValue[4]++;
		} else if (Integer.parseInt(finalExamNote) < 100 && Integer.parseInt(finalExamNote) >= 75) {
			resultsFromTheFinalExamIntegerValue[5]++;
		} else {
			System.out.println("final sinavinda Belirlenen rakamlarin disinda bir ifade vardir.");
		}
	}

	public void midtermExamAndFinalExamBetweenRelationalship(String ExamNoteType, int x, String finalExamNote,
			String namaSurname, String number, String letterGrade) {
		if (finalExamNote.equals("D")) {
			midtermExamAndFinalExamBetweenRelationalshipArraySub(ExamNoteType, x, 0, finalExamNote, namaSurname, number,
					letterGrade);
		} else if (finalExamNote.equals("G")) {
			midtermExamAndFinalExamBetweenRelationalshipArraySub(ExamNoteType, x, 1, finalExamNote, namaSurname, number,
					letterGrade);
		} else if (Integer.parseInt(finalExamNote) == 0) {
			midtermExamAndFinalExamBetweenRelationalshipArraySub(ExamNoteType, x, 2, finalExamNote, namaSurname, number,
					letterGrade);
		} else if (Integer.parseInt(finalExamNote) < 25 && Integer.parseInt(finalExamNote) >= 0) {
			midtermExamAndFinalExamBetweenRelationalshipArraySub(ExamNoteType, x, 3, finalExamNote, namaSurname, number,
					letterGrade);
		} else if (Integer.parseInt(finalExamNote) < 50 && Integer.parseInt(finalExamNote) >= 25) {
			midtermExamAndFinalExamBetweenRelationalshipArraySub(ExamNoteType, x, 4, finalExamNote, namaSurname, number,
					letterGrade);
		} else if (Integer.parseInt(finalExamNote) < 75 && Integer.parseInt(finalExamNote) >= 50) {
			midtermExamAndFinalExamBetweenRelationalshipArraySub(ExamNoteType, x, 5, finalExamNote, namaSurname, number,
					letterGrade);
		} else if (Integer.parseInt(finalExamNote) < 100 && Integer.parseInt(finalExamNote) >= 75) {
			midtermExamAndFinalExamBetweenRelationalshipArraySub(ExamNoteType, x, 6, finalExamNote, namaSurname, number,
					letterGrade);
		} else {
			System.out.println("final sinavinda Belirlenen rakamlarin disinda bir ifade vardir.");
		}

	}

	public void midtermExamAndFinalExamBetweenRelationalshipArraySub(String ExamNoteType, int x, int y,
			String finalExamNote, String namaSurname, String number, String letterGrade) {
		if (ExamNoteType.equals("D"))
			BetweenNote[x][y]++;
		else if (ExamNoteType.equals("G"))
			BetweenNote[x][y]++;
		else if (ExamNoteType.equals("0"))
			BetweenNote[x][y]++;
		else if (ExamNoteType.equals("0_25"))
			BetweenNote[x][y]++;
		else if (ExamNoteType.equals("25_50"))
			BetweenNote[x][y]++;
		else if (ExamNoteType.equals("50_75"))
			BetweenNote[x][y]++;
		else if (ExamNoteType.equals("75_100"))
			BetweenNote[x][y]++;
		else
			System.out.println("vizede not alanlarin finalleri nasil diye olan kisim patlak");
		if (x == 6 && y == 6) {
			BetweenNoteNameSurname[nameSurnameCount] = namaSurname;
			nameSurnameCount++;
			BetweenNoteNumber[numberCount] = number;
			numberCount++;
			BetweenNoteNameSurnameLetterGrade[letterGradeCount] = letterGrade;
			letterGradeCount++;
			System.out
					.println(BetweenNoteNameSurname[nameSurnameCount - 1] + "****" + BetweenNoteNumber[numberCount - 1]
							+ "****" + BetweenNoteNameSurnameLetterGrade[letterGradeCount - 1]);
		}
		if (x <= 3 && y <= 3) {
			BetweenNoteNameSurname1[nameSurnameCount1] = namaSurname;
			nameSurnameCount1++;
			BetweenNoteNumber1[numberCount1] = number;
			numberCount1++;
			BetweenNoteNameSurnameLetterGrade1[letterGradeCount] = letterGrade;
			letterGradeCount1++;
//			System.out.println(BetweenNoteNameSurname1[nameSurnameCount1] + "****" + BetweenNoteNumber1[numberCount1]
//					+ "****" + BetweenNoteNameSurnameLetterGrade1[letterGradeCount1]);
		}
	}

	public void midtermAndFinalExamReport4(String letterGrade) {

		System.out.println("Harf notlari " + letterGrade);
		if (letterGrade.equals("D ")) {
			resultsFromTheMidtermExamLetterGrade[0]++;

		} else if (letterGrade.equalsIgnoreCase("AA")) {
			resultsFromTheMidtermExamLetterGrade[1]++;
		} else if (letterGrade.equalsIgnoreCase("BA")) {
			resultsFromTheMidtermExamLetterGrade[2]++;
		} else if (letterGrade.equalsIgnoreCase("BB")) {
			resultsFromTheMidtermExamLetterGrade[3]++;
		} else if (letterGrade.equalsIgnoreCase("CB")) {
			resultsFromTheMidtermExamLetterGrade[4]++;
		} else if (letterGrade.equalsIgnoreCase("CC")) {
			resultsFromTheMidtermExamLetterGrade[5]++;
		} else if (letterGrade.equalsIgnoreCase("DC")) {
			resultsFromTheMidtermExamLetterGrade[6]++;
		} else if (letterGrade.equalsIgnoreCase("DD")) {
			resultsFromTheMidtermExamLetterGrade[7]++;
		} else if (letterGrade.equalsIgnoreCase("FD")) {
			resultsFromTheMidtermExamLetterGrade[8]++;
		} else if (letterGrade.equalsIgnoreCase("FF")) {
			resultsFromTheMidtermExamLetterGrade[9]++;
		} else {
			resultsFromTheMidtermExamLetterGrade[10]++; // geçersiz harf notu
		}
	}

}
//i=0 arasinavda ortalamanin altinda kalan kisilerin sayisi
// i=1 arasinavda ortalamanin ustunde kalan kisilerin sayisi
// i=2 arasinavda not araligi 0-25
// i=3 arasinavda not araligi 25-50
// i=4 arasinavda not araligi 50-75
// i=5 arasinavda not araligi 75-100
// i=6 arasinavdaki Devamsiz ogrencileri sayisi
// i=7 arasinavdaki 0 alan öğrencilerin sayisi
// i=15 arasinavda G alan ogrencilerin sayisi

// i=8 final sinavindaki ortalamanin altinda kalan kisilerin sayisi
// i=9 final ortalamanin ustunde kalan kisilerin sayisi
// i=10 final not araligi 0-25
// i=11 final not araligi 25-50
// i=12 final not araligi 50-75
// i=13 final not araligi 75-100
// i=14 final sinavindaki Devamsiz ogrencileri sayisi
// i=15 final sinavindaki 0 alan öğrencilerin sayisi
// i=16 final sinavinda G alan ogrencilerin sayisi

// i=0 arasinavdaki ortalama not
// i=1 arasinavdaki standart sapma
// i=2 final sinavindaki ortalama not
// i=3 final sinavindaki standart sapma

//
//System.out.println("Ortalamanın altinda kalan kisilerin sayisi: " + resultsFromTheMidtermExamIntegerValue[0]);
//System.out.println("Ortalamanın ustunde olan kisilerin sayisi: " + resultsFromTheMidtermExamIntegerValue[1]);
//System.out.println(
//		"0 <= not < 25 arasindaki not olan ogrencilerin sayisi: " + resultsFromTheMidtermExamIntegerValue[2]);
//System.out.println(
//		"25 <= not < 50 arasindaki not olan ogrencilerin sayisi: " + resultsFromTheMidtermExamIntegerValue[3]);
//System.out.println(
//		"50 <= not < 75 arasindaki not olan ogrencilerin sayisi: " + resultsFromTheMidtermExamIntegerValue[4]);
//System.out.println(
//		"75 <= not < 100 arasindaki not olan ogrencilerin sayisi: " + resultsFromTheMidtermExamIntegerValue[5]);
//// arasindaki not araliklarina gore not sayilari
//System.out.println("Devamsiz ogrencilerin sayisi: " + resultsFromTheMidtermExamIntegerValue[6]);
//System.out.println("Sifir alan ogrencilerin sayisi: " + resultsFromTheMidtermExamIntegerValue[7]);
//System.out.println("Girmeyen ogrencilerin sayisi: " + resultsFromTheMidtermExamIntegerValue[15]);
//
//System.out.println("Ortalamanın altinda kalan kisilerin sayisi: " + resultsFromTheMidtermExamIntegerValue[8]);
//System.out.println("Ortalamanın ustunde olan kisilerin sayisi: " + resultsFromTheMidtermExamIntegerValue[9]);
//System.out.println(
//		"0 <= not < 25 arasindaki not olan ogrencilerin sayisi: " + resultsFromTheMidtermExamIntegerValue[10]);
//System.out.println(
//		"25 <= not < 50 arasindaki not olan ogrencilerin sayisi: " + resultsFromTheMidtermExamIntegerValue[11]);
//System.out.println(
//		"50 <= not < 75 arasindaki not olan ogrencilerin sayisi: " + resultsFromTheMidtermExamIntegerValue[12]);
//System.out.println("75 <= not < 100 arasindaki not olan ogrencilerin sayisi: "
//		+ resultsFromTheMidtermExamIntegerValue[13]);
//// arasindaki not araliklarina gore not sayilari
//System.out.println("Devamsiz ogrencilerin sayisi: " + resultsFromTheMidtermExamIntegerValue[14]);
//
//System.out.println("Sifir alan ogrencilerin sayisi: " + resultsFromTheMidtermExamIntegerValue[16]);
//System.out.println("Girmeyen ogrencilerin sayisi: " + resultsFromTheMidtermExamIntegerValue[17]);