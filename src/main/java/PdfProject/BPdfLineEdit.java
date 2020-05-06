package PdfProject;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class BPdfLineEdit extends BPdfRead {

	public void pdfLineEditIndexFind() {
		// Dersin Kodu, Adı ve Yarıyılı:
		ArrayList<String> arrayListRemovo = new ArrayList<String>();
		String LessonCodeName = "([Dd][Ee][Rr][Ss][İi][Nn].[KK][Oo][Dd][Uu][,].[Aa][Dd][Iı].[Vv][Ee].[Yy][Aa][Rr][Iı][Yy][Iı][Ll][Iı][:])(.*)";
		String LessonTeacher = "([Öö][Ğğ][Rr][Ee][Tt][İi][Mm].[Üü][Yy][Ee][Ss][İi][Nn][İi][Nn].[Üü][Nn][Vv][Aa][Nn][Iı][,].[Aa][Dd][Iı].[Vv][Ee].[Ss][Oo][Yy][Aa][Dd][Iı][:])(.*)";
		String subStudent = "(.*)([Tt][Oo][Pp][Ll][Aa][Mm].\\d+?.[Öö][Ğğ][Rr][Ee][Nn][Cc][Ii])(.*)";
		String generalAverage = "(.*)([Gg][Ee][Nn][Ee][Ll].[Oo][Rr][Tt][Aa][Ll][Aa][Mm][Aa][Ss][Iı].\\d+\\.\\d+)(.*)";
		String minMinAverage = "(.*)([Dd][Üü][Şş][Üü][Kk])(.*)(\\d+\\.\\d+)(.*)";
		String maxMinAverage = "(.*)([Yy][Üü][Kk][Ss][Ee][Kk])(.*)(\\d+\\.\\d+)(.*)";

		for (int i = 0; i < arrayList.size(); i++) {
			arrayListRemovo.add(arrayList.get(i));

		}

		p = Pattern.compile(LessonCodeName);
		for (int i = 0; i < arrayList.size(); i++) {
			m = p.matcher(arrayList.get(i));
			if (m.find()) {
				hashTable.put("Dersin Kodu, Adı ve Yarıyılı", m.group(2).trim()); // Öğrenci değerlendirme anketine
																					// katılan
				// sayı
			}
		}
		p = Pattern.compile(LessonTeacher);
		for (int i = 0; i < arrayList.size(); i++) {
			m = p.matcher(arrayList.get(i));
			if (m.find()) {
				hashTable.put("Öğretim Üyesinin Ünvanı, Adı ve Soyadı", m.group(2).trim()); // Öğrenci değerlendirme
																							// anketine
				// katılan sayı
			}
		}
		for (int i = 0; i < arrayListRemovo.size() * 2; i++) {
			arrayListRemovo.set(0, arrayListRemovo.get(0) + arrayListRemovo.get(1));
			arrayListRemovo.remove(1);
		}
		p = Pattern.compile(subStudent);
		for (int i = 0; i < arrayListRemovo.size(); i++) {
			m = p.matcher(arrayListRemovo.get(i));
			if (m.find()) {
				hashTable.put("Toplam Öğrenci", m.group(2).trim()); // Öğrenci değerlendirme anketine katılan sayı
			}
		}

		p = Pattern.compile(generalAverage);
		for (int i = 0; i < arrayListRemovo.size(); i++) {
			m = p.matcher(arrayListRemovo.get(i));
			if (m.find()) {
				hashTable.put("Genel Ortalama", m.group(2).trim()); //
			}
		}
		p = Pattern.compile(minMinAverage);
		for (int i = 0; i < arrayListRemovo.size(); i++) {
			m = p.matcher(arrayListRemovo.get(i));
			if (m.find()) {
				hashTable.put("En düşük ortalama", m.group(4).trim()); //
			}
		}

		p = Pattern.compile(maxMinAverage);
		for (int i = 0; i < arrayListRemovo.size(); i++) {
			m = p.matcher(arrayListRemovo.get(i));
			if (m.find()) {
				hashTable.put("En yüksek ortalama", m.group(4).trim()); //
			}
		}


		System.out.println(hashTable.get("Dersin Kodu, Adı ve Yarıyılı"));
		System.out.println(hashTable.get("Öğretim Üyesinin Ünvanı, Adı ve Soyadı"));
		System.out.println(hashTable.get("Toplam Öğrenci"));
		System.out.println(hashTable.get("Genel Ortalama"));
		System.out.println(hashTable.get("En düşük ortalama"));
		System.out.println(hashTable.get("En yüksek ortalama"));

	} // end pdfLineEditIndexFind function

} // end class

/*
 * String BreportWords[] = {
 * "([Dd][Ee][Rr][Ss][İi][Nn].[KK][Oo][Dd][Uu][,].[Aa][Dd][Iı].[Vv][Ee].[Yy][Aa][Rr][Iı][Yy][Iı][Ll][Iı][:])(.*)",
 * "([Öö][Ğğ][Rr][Ee][Tt][İi][Mm].[Üü][Yy][Ee][Ss][İi][Nn][İi][Nn].[Üü][Nn][Vv][Aa][Nn][Iı][,].[Aa][Dd][Iı].[Vv][Ee].[Ss][Oo][Yy][Aa][Dd][Iı][:])(.*)",
 * "(.*)([Tt][Oo][Pp][Ll][Aa][Mm].\\d+?.[Öö][Ğğ][Rr][Ee][Nn][Cc][Ii])(.*)",
 * "(.*)([Gg][Ee][Nn][Ee][Ll].[Oo][Rr][Tt][Aa][Ll][Aa][Mm][Aa][Ss][Iı].\\d+\\.\\d+)(.*)",
 * "(.*)([Dd][Üü][Şş][Üü][Kk])(.*)(\\d+\\.\\d+)(.*)",
 * "(.*)([Yy][Üü][Kk][Ss][Ee][Kk])(.*)(\\d+\\.\\d+)(.*)" }; String
 * BreportKeyWords[] = { "Dersin Kodu, Adı ve Yarıyılı",
 * "Öğretim Üyesinin Ünvanı, Adı ve Soyadı", "Toplam Öğrenci", "Genel Ortalama",
 * "En düşük ortalama", "En yüksek ortalama" };
 * 
 * 
 * 
 * 
 * for (int i = 0; i < 6; i++) { p = Pattern.compile(BreportWords[i]); if (i <=
 * 1) { for (int j = 0; j < arrayList.size(); j++) { m =
 * p.matcher(arrayList.get(j)); if (m.find()) { if (i == 0) {
 * hashTable.put("Dersin Kodu, Adı ve Yarıyılı", m.group(2)); // Öğrenci
 * değerlendirme anketine } else {
 * hashTable.put("Öğretim Üyesinin Ünvanı, Adı ve Soyadı", m.group(2)); } } } }
 * else { for (int j = 0; j < arrayListRemovo.size(); j++) { m =
 * p.matcher(arrayListRemovo.get(i)); if (m.find()) { if (i == 2) {
 * hashTable.put("Toplam Öğrenci", m.group(2)); // Öğrenci değerlendirme
 * anketine katılan sayı } else if (i == 3) { hashTable.put("Genel Ortalama",
 * m.group(2)); } else if (i == 4) { hashTable.put("En düşük ortalama",
 * m.group(4)); } else { hashTable.put("En yüksek ortalama", m.group(4)); } } }
 * } }
 */
