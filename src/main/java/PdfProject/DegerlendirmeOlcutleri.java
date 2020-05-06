package PdfProject;

import java.util.regex.Pattern;

class DegerOlcutleri {
	String adi;
	String sayisi;
	String toplamKatkisi;

	DegerOlcutleri(String adi, String sayisi, String toplamKatkisi) {
		this.adi = adi;
		this.sayisi = sayisi;
		this.toplamKatkisi = toplamKatkisi;
	}
}

public class DegerlendirmeOlcutleri extends DersTanimlamaFormlariRead {

	public void start() throws Exception {
		for (int i = 0; i < degerlendirmeOlcutleri.length; i++) {
			pdfLineEdit(degerlendirmeOlcutleri[i]);
		}
	}

	private void pdfLineEdit(String degerlendirmeOlcutleri) throws Exception {
		p = Pattern.compile(degerlendirmeOlcutleri, Pattern.CASE_INSENSITIVE);
		DegerOlcutleri d;
		System.out.println("DEĞERLENDİRME ÖLÇÜTLERİ ");
		for (int i = 0; i < 1; i++) {
			m = p.matcher(arrayListNew.get(14));
			while (m.find()) {
				d = new DegerOlcutleri(m.group(1), m.group(2), m.group(3));
				arrayListDegerlendirmeOlcutleri.add(d);
				System.out.println(
						"1.grup: " + m.group(1) + " " + "2.grup: " + m.group(2) + " " + "3.grup: " + m.group(3));

			}

		}
	}

}
