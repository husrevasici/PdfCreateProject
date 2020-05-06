package PdfProject;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class APdfRead extends Anasayfa {

	static Hashtable<String, String> h = new Hashtable<String, String>();
	static ArrayList<String> arrayList = new ArrayList<String>();
	static ArrayList<String> arrayListNew = new ArrayList<String>();
	static String linesNew[] = new String[16];
	static String lines[];
	static Matcher m;
	static boolean t;
	static Pattern p, p1, p2, p3, p4, p5, p6, p7;

	static int idx, dersCiktilariIndex, aciklamaIndex, derskaynaklariIndex, derslerIndex;
	static String kelimeBirlestirme;
	ProgramInterface programInterfaceObject = new ProgramInterface();

	public void pdfRead() throws Exception {

		APdfLineEdit pdfEdtLine = new APdfLineEdit();
		File file = new File(fileName);
		// File file = new File("/D:/A.pdf");
		PDDocument document = PDDocument.load(file);

		// PDFTextStripper pdfStripper = new PDFTextStripper();

		// String text = pdfStripper.getText(document);

		if (!document.isEncrypted()) {

			PDFTextStripper tStripper = new PDFTextStripper();
			tStripper.setStartPage(1);
			tStripper.setEndPage(4);
			String pdfFileInText = tStripper.getText(document);
			lines = pdfFileInText.split("\\r?\\n");

		}
		for (int i = 0; i < lines.length; i++) {
			arrayList.add(lines[i]);
			 System.out.println(i+".indeks: "+lines[i]);
		}

		pdfEdtLine.pdfLineEditIndexFind();

		for (int i = 0; i < arrayListNew.size(); i++) {
			// System.out.println("i" + i + " . indekste " + arrayListNew.get(i));
			linesNew[i] = arrayListNew.get(i);
			// System.out.println(lines[i]);
		}
		pdfReadAndInserHashTable();
		editId();
		System.out.println("id------------------>>>>>>>>>>>>>"+h.get("id"));
		document.close();

	} // end construcor

	public static void InsertHashTable() {
		for (int i = 0; i < linesNew.length; i++) {
			m = p.matcher(linesNew[i]);
			if (m.matches()) {
				h.put(m.group(1), m.group(2));

				System.out.println(i + 1 + "->>" + m.group(1) + " ****** " + "2->>" + m.group(2));

			} // end if
		} // end for

	} // end InsertHashTable

	public static void pdfReadAndInserHashTable() {
		// buradaki tüm stringler için büyük küçük harf duyarlılığı yap !!!!
		p = Pattern.compile("([Dd][eE][rR][sS] [kK][oO][dD][uU])(.+?)");
		InsertHashTable();
		p = Pattern.compile("(Ders adı)(.+?)");
		InsertHashTable();
		p = Pattern.compile("(Kredi)(.+?)");
		InsertHashTable();
		p = Pattern.compile("(AKTS)(.+?)");
		InsertHashTable();
		p = Pattern.compile("(Önkoşul)(.+?)");
		InsertHashTable();
		p = Pattern.compile("(Öğretim elemanı)(.+?)");
		InsertHashTable();
		p = Pattern.compile("(Eposta)(.+?)");
		InsertHashTable();
		p = Pattern.compile("(Ofis saatleri)(.+?)");
		InsertHashTable();
		p = Pattern.compile("(Web)(.+?)");
		InsertHashTable();
		p = Pattern.compile("(Açıklama)(.+?)");
		InsertHashTable();
		p = Pattern.compile("(Ders kaynakları)(.+?)");
		InsertHashTable();
		p = Pattern.compile("(Dersin amaçları)(.+?)");
		InsertHashTable();
		p = Pattern.compile("(Ders çıktıları)(.+?)");
		InsertHashTable();
		p = Pattern.compile("(Dersler)(.+?)");
		InsertHashTable();
		p = Pattern.compile("(Değerlendirme)(.+?)");
		InsertHashTable();

	}// end pdfReadAndInserHashTable

	public void editId() throws Exception {

		Pattern pEdit = Pattern.compile("\\b([Cc][Ee][Nn][Gg])\\s*+(\\d{2,3})\\b", Pattern.CASE_INSENSITIVE);
		Matcher mEdit;

		mEdit = pEdit.matcher(h.get("Ders kodu"));

		while (mEdit.find()) {
			h.put("id", mEdit.group(2));
//			System.out.println(mEdit.group(1) + mEdit.group(2));
//			System.out.println("h.get(id)--->>>>" + h.get("id"));
		}
	} // end function --> pdfReadAndInserHashTable
} // end class

/*
 * m = p.matcher(lines[i]); m1 = p1.matcher(lines[i+1]); if (m.matches()) { if
 * (m1.matches()) { System.out.println(lines[i]); System.out.println(lines[i +
 * 1]); }
 * 
 * }
 */

//for (int i = 0; i <arrayList.size(); i++) {
//if(arrayList.get(i)==null || arrayList.get(i)==" ")
//	System.out.println("1");
//else if(arrayList.get(i).isEmpty())
//	System.out.println("2");
//else
//	System.out.println("3");
//}
//
//public void pdfLineEdit() {
//	try {
//
//		ArrayList<String> matches = new ArrayList<String>();
//		p = Pattern.compile("[Öö][Ğğ][Rr][Ee][Tt][İi][Mm].*");
//		p1 = Pattern.compile("[Dd][Ee][Rr][Ss].*");
//		p2 = Pattern.compile("[Dd][Ee][Rr][Ss][Ii][Nn].*");
//		p3 = Pattern.compile("[Aa][Kk][Aa][Dd][Ee][Mm][İi][Kk].*");
//		p4 = Pattern.compile("[Dd][Ee][Rr][Ss][Ll][Ee][Rr].*");
//		p5 = Pattern.compile("[Aa][Çç][Iı][Kk][Ll][Aa][Mm][Aa].*");
//		p6 = Pattern.compile("[Ww][Ee][Bb].*");
//		p7 = Pattern.compile("[Dd][Ee][Rr][Ss][Ll][Ee][Rr].*");
//
////		p2=Pattern.compile("");
//
//		for (int i = 0; i < lines.length; i++) {
//			arrayList.add(lines[i]);
//		}
//
//		for (int i = 0; i < arrayList.size(); i++) {
//			// Öğretim elemanı
//			if (p.matcher(arrayList.get(i)).matches()) {
//				// System.out.println(i + ".indekste " + lines[i]);
//				if (arrayList.get(i + 1).contains("elemanı")) {
//					arrayList.set(i, arrayList.get(i) + arrayList.get(i + 1) + arrayList.get(i + 2));
//					arrayList.remove(i + 1);
//					arrayList.remove(i + 1);
////					System.out.println(arrayList.get(i));
//				}
//			}
//			// Ders kaynakları
//			if (p1.matcher(arrayList.get(i)).matches()) {
//				if (arrayList.get(i + 1).contains("kaynakları")) {
//					arrayList.set(i, arrayList.get(i) + arrayList.get(i + 1));
//					arrayList.remove(i + 1);
//				}
//			}
//			// Dersin amaçları
//			if (p2.matcher(arrayList.get(i)).matches()) {
//				if (arrayList.get(i + 1).contains("amaçları")) {
//					arrayList.set(i, arrayList.get(i) + arrayList.get(i + 1));
//					arrayList.remove(i + 1);
//
//				}
//			}
//			// Akademik dürüstlük
//			if (p3.matcher(arrayList.get(i)).matches()) {
//				if (arrayList.get(i + 1).contains("dürüstlük")) {
//					arrayList.set(i, arrayList.get(i) + arrayList.get(i + 1));
//					arrayList.remove(i + 1);
////					System.out.println(arrayList.get(i));
//				}
//			}
//
//		}
//		/// ########################
//		// dersin amaçları index bulma
//		for (int i = 0; i < arrayList.size(); i++) {
//			if (p2.matcher(arrayList.get(i)).matches()) {
//				if (arrayList.get(i).contains("amaçları")) {
//					idx = i;
//					// System.out.println(idx);
//				}
//			}
//		}
////		 iki kalıp arasında boşlukları alma ve taşıma işlemi
////		 Ders kaynakları ----- Dersin amaçları
//		for (int i = 0; i < arrayList.size(); i++) {
//			if (p1.matcher(arrayList.get(i)).matches()) {
//				if (arrayList.get(i).contains("kaynakları")) {
//					kelimeBirlestirme = arrayList.get(i);
//					// System.out.println(kelimeBirlestirme);
//					for (int y = i; y + 1 < idx; y++) {
//						kelimeBirlestirme = kelimeBirlestirme + arrayList.get(y + 1);
//					}
//					arrayList.set(i, kelimeBirlestirme);
//					for (int j = i; j + 1 < idx; j++) {
//						arrayList.remove(i + 1);
//					}
//				}
//			}
//		}
//		/// ########################
//		// dersÇiktilarinin indexini bulma
//		for (int i = 0; i < arrayList.size(); i++) {
//			if (p1.matcher(arrayList.get(i)).matches()) {
//				if (arrayList.get(i).contains("çıktıları")) {
//					dersCiktilariIndex = i;
//
//				}
//			}
//		}
//
//		for (int i = 0; i < arrayList.size(); i++) {
//			if (p2.matcher(arrayList.get(i)).matches()) {
//				if (arrayList.get(i).contains("amaçları")) {
//					kelimeBirlestirme = arrayList.get(i);
//					// System.out.println(kelimeBirlestirme);
//					for (int y = i; y + 1 < dersCiktilariIndex; y++) {
//						kelimeBirlestirme = kelimeBirlestirme + arrayList.get(y + 1);
//
//					}
//					// System.out.println(kelimeBirlestirme);
//					arrayList.set(i, kelimeBirlestirme);
//					for (int j = i; j + 1 < dersCiktilariIndex; j++) {
//						arrayList.remove(i + 1);
//					}
//
//				}
//			}
//		}
//		/// ########################
//		// Web in indexini öğrenme
//		for (int i = 0; i < arrayList.size(); i++) {
//			if (p5.matcher(arrayList.get(i)).matches()) {
//				aciklamaIndex = i;
//			}
//		}
//
//		for (int i = 0; i < arrayList.size(); i++) {
//			if (p6.matcher(arrayList.get(i)).matches()) {
//				kelimeBirlestirme = arrayList.get(i);
//				// System.out.println(kelimeBirlestirme);
//				for (int y = i; y + 1 < aciklamaIndex; y++) {
//					kelimeBirlestirme = kelimeBirlestirme + arrayList.get(y + 1);
//
//				}
//				// System.out.println(kelimeBirlestirme);
//				arrayList.set(i, kelimeBirlestirme);
//				for (int j = i; j + 1 < aciklamaIndex; j++) {
//					arrayList.remove(i + 1);
//				}
//
//			}
//		}
//		/// ########################
//		for (int i = 0; i < arrayList.size(); i++) {
//			if (p1.matcher(arrayList.get(i)).matches()) {
//				if (arrayList.get(i).contains("kaynakları")) {
//					derskaynaklariIndex = i;
//				}
//			}
//		}
//
//		for (int i = 0; i < arrayList.size(); i++) {
//			if (p5.matcher(arrayList.get(i)).matches()) {
//				kelimeBirlestirme = arrayList.get(i);
//				// System.out.println(kelimeBirlestirme);
//				for (int y = i; y + 1 < derskaynaklariIndex; y++) {
//					kelimeBirlestirme = kelimeBirlestirme + arrayList.get(y + 1);
//
//				}
//				// System.out.println(kelimeBirlestirme);
//				arrayList.set(i, kelimeBirlestirme);
//				for (int j = i; j + 1 < derskaynaklariIndex; j++) {
//					arrayList.remove(i + 1);
//				}
//
//			}
//		}
//		/// ########################
//
//		for (int i = 0; i < arrayList.size(); i++) {
//			if (p7.matcher(arrayList.get(i)).matches()) {
//				derslerIndex=i;
//				System.out.println(derslerIndex);
//			}
//		}
//		
//		for (int i = 0; i < arrayList.size(); i++) {
//			if (p1.matcher(arrayList.get(i)).matches()) {
//				if (arrayList.get(i).contains("çıktıları")) {
//					kelimeBirlestirme = arrayList.get(i);
//					// System.out.println(kelimeBirlestirme);
//					for (int y = i; y + 1 < derslerIndex; y++) {
//						kelimeBirlestirme = kelimeBirlestirme + arrayList.get(y + 1);
//
//					}
//					// System.out.println(kelimeBirlestirme);
//					arrayList.set(i, kelimeBirlestirme);
//					for (int j = i; j + 1 < derslerIndex; j++) {
//						arrayList.remove(i + 1);
//					}
//
//				}
//			}
//		}
//		for (int i = 0; i < arrayList.size(); i++) {
//			System.out.println(i + ".indeks: " + arrayList.get(i));
//		}
//
//	} catch (
//
//	Exception e) {
//		e.printStackTrace();
//	}
//}
/*
 * class ADersUygulamaPlani { String DersAdi; String DersKodu; String Kredi;
 * String AKTS; String Onkosul; String OgretimElemani; String EPosta; String
 * DersSaatleri; String Web; String Aciklama; String DersKaynaklari; String
 * DersinAmaclari; String DersCiktilari; String Dersler; String Degerlendirme;
 * 
 * ADersUygulamaPlani(String DersAdi, String DersKodu, String Kredi, String
 * AKTS, String Onkosul, String OgretimElemani, String EPosta, String
 * DersSaatleri, String Web, String Aciklama, String DersKaynaklari, String
 * DersinAmaclari, String DersCiktilari, String Dersler, String Degerlendirme) {
 * this.DersAdi = DersAdi; this.DersKodu = DersKodu; this.Kredi = Kredi;
 * this.AKTS = AKTS; this.Onkosul = Onkosul; this.OgretimElemani =
 * OgretimElemani; this.EPosta = EPosta; this.DersSaatleri = DersSaatleri;
 * this.Web = Web; this.Aciklama = Aciklama; this.DersKaynaklari =
 * DersKaynaklari; this.DersinAmaclari = DersinAmaclari; this.DersCiktilari =
 * DersCiktilari; this.Dersler = Dersler; this.Degerlendirme = Degerlendirme; }
 * }
 */
