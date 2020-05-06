package PdfProject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DersTanimlamaFormlariPdfLineEdit extends DersTanimlamaFormlariRead {

	private Pattern p1, p2;
	private Matcher m;
	private static int count = 1, index;
	private static String kelimeBirlestirme;
// Dersin Yarıyılı

	// Ders Çıktıları ile Program Çıktıları Arasındaki

	public void pdfLineEditIndexFind() throws Exception {

		for (int i = 0; i < word.length-1; i++) {

			p1 = Pattern.compile(word[i]);
			p2 = Pattern.compile(word[i + 1]);
			// System.out.println(word[i]);
			pdfLineEditWordFineIndex(p1, p2);

		} // end for
//		p1 = Pattern.compile(word[14]);
//		p2 = Pattern.compile(word[15]);
		// dersinDegerlendirmeOlcutleriKismi(p1, p2);
	} // end method -> pdfLineEditIndexFind()

	private void pdfLineEditWordFineIndex(Pattern p1, Pattern p2) throws Exception {

		for (int i = 0; i < arrayList.size(); i++) {
			if (p2.matcher(arrayList.get(i)).matches()) {
				// System.out.println(i + ".indeks: " + arrayList.get(i) + "--" + count++);
				index = i;
			}
		}
		for (int i = 0; i < arrayList.size(); i++) {
			if (p1.matcher(arrayList.get(i)).matches()) {

				kelimeBirlestirme = arrayList.get(i);

				for (int y = i; y + 1 < index; y++) {
					kelimeBirlestirme = kelimeBirlestirme + " " + arrayList.get(y + 1);
				}
				arrayList.set(i, kelimeBirlestirme);
				arrayListNew.add(arrayList.get(i));

			} // end if

		} // end For

	} // end function

//	private void dersinDegerlendirmeOlcutleriKismi(Pattern p1, Pattern p2) {
//
//		for (int i = 0; i < arrayList.size(); i++) {
//			if (p2.matcher(arrayList.get(i)).matches()) {
//				index = i;
//			}
//		}
//		for (int i = 0; i < arrayList.size(); i++) {
//			if (p1.matcher(arrayList.get(i)).matches()) {
//
//				for (int y = i; y < index; y++) {
//					arrayListDegerlendirmeOlcutleri.add(arrayList.get(y).trim());
//				}
//
//			}
//		}
//
//	}
} // end Class -> DersTanimlamaFormlarıPdfLineEdit
