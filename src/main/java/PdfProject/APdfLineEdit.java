package PdfProject;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class APdfLineEdit extends APdfRead {

	private String w1, wNew, kelimeBirlestirme;
	static private int index;
	private String secondWords[] = { "kodu", "adı", "elemanı", "saatleri", "saatleri", "kaynakları", "amaçları",
			"çıktıları", "dürüstlük" };
	private String secondWordsNew[] = { "Ders kodu", "Ders adı", "Öğretim elemanı", "Ofis saatleri", "Ders saatleri",
			"Ders kaynakları", "Dersin amaçları", "Ders çıktıları", "Akademik dürüstlük" };
	private String firstWords[] = { "[Dd][Ee][Rr][Ss].*", "[Dd][Ee][Rr][Ss].*", "[Öö][Ğğ][Rr][Ee][Tt][İi][Mm].*",
			"[Oo][Ff][İi][Ss].*", "[Dd][Ee][Rr][Ss].*", "[Dd][Ee][Rr][Ss].*", "[Dd][Ee][Rr][Ss][İi][Nn].*",
			"[Dd][Ee][Rr][Ss].*", "[Aa][Kk][Aa][Dd][Ee][Mm][İi][Kk].*" };

	private String word[] = { "[Dd][Ee][Rr][Ss].[Kk][Oo][Dd][Uu].*", "[Dd][Ee][Rr][Ss].[Aa][Dd][Iı].*",
			"[Kk][Rr][Ee][Dd].*", "[Aa][Kk][Tt][Ss].*", "[Öö][Nn][Kk][Oo][Şş][Uu][Ll].*",
			"[Öö][Ğğ][Rr][Ee][Tt][İi][Mm].[Ee][Ll][Ee][Mm][Aa][Nn][Iı].*", "[Ee][Pp][Oo][Ss][Tt][Aa].*",
			"[Oo][Ff][İi][Ss]", "[Oo][Ff][İi][Ss].[Ss][Aa][Aa][Tt][Ll][Ee][Rr][İi].*",
			"[Dd][Ee][Rr][Ss].[Ss][Aa][Aa][Tt][Ll][Ee][Rr][İi].*", "[Ww][Ee][Bb].*",
			"[Aa][Çç][Iı][Kk][Ll][Aa][Mm][Aa].*", "[Dd][Ee][Rr][Ss].[Kk][Aa][Yy][Nn][Aa][Kk][Ll][Aa][Rr][Iı].*",
			"[Dd][Ee][Rr][Ss][İi][Nn].[Aa][Mm][Aa][Çç][Ll][Aa][Rr][Iı].*",
			"[Dd][Ee][Rr][Ss].[Çç][Iı][Kk][Tt][Iı][Ll][Aa][Rr][Iı].*", "[Dd][Ee][Rr][Ss][Ll][Ee][Rr].*",
			"[Dd][Ee][Ğğ][Ee][Rr][Ll][Ee][Nn][Dd][İi][Rr][Mm][Ee].*",
			"[Aa][Kk][Aa][Dd][Ee][Mm][İi][Kk].[Dd][Üü][Rr][Üü][Ss][Tt][Ll][Üü][Kk].*", };

	public void pdfLineEditIndexFind() throws Exception {

		try {
			ArrayList<String> matches = new ArrayList<String>();
			for (int i = 0; i < firstWords.length; i++) {
				p1 = Pattern.compile(firstWords[i]);
				w1 = secondWords[i];
				wNew = secondWordsNew[i];
				pdfLineEditFirstWordAndSecondsWord(p1, w1, wNew);
			}

			for (int i = 0; i < word.length; i++) {
				if (i <= 16) {
					p1 = Pattern.compile(word[i]); // "[Aa][Çç][Iı][Kk][Ll][Aa][Mm][Aa].*"
					p2 = Pattern.compile(word[i + 1]); // "[Dd][Ee][Rr][Ss].[Kk][Aa][Yy][Nn][Aa][Kk][Ll][Aa][Rr][Iı].*"
					pdfLineEditWordFineIndex(p1, p2);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void pdfLineEditFirstWordAndSecondsWord(Pattern p1, String w1, String wNew) {

		for (int i = 0; i < arrayList.size(); i++) {
			if (p1.matcher(arrayList.get(i)).matches()) {

				if (arrayList.get(i).contains(w1)) {

				} else if (arrayList.get(i + 1).contains(wNew)) {

				} else if (arrayList.get(i + 1).contains(w1)) {
					arrayList.set(i, arrayList.get(i) + arrayList.get(i + 1));
					arrayList.remove(i + 1);

				}

			}

		}

	}

	private void pdfLineEditWordFineIndex(Pattern p1, Pattern p2) {

		for (int i = 0; i < arrayList.size(); i++) {
			if (p2.matcher(arrayList.get(i)).matches()) {
				index = i;
			}
		}
		for (int i = 0; i < arrayList.size(); i++) {
			if (p1.matcher(arrayList.get(i)).matches()) {

				kelimeBirlestirme = arrayList.get(i);

				for (int y = i; y + 1 < index; y++) {
					kelimeBirlestirme = kelimeBirlestirme + arrayList.get(y + 1);
				}
				arrayList.set(i, kelimeBirlestirme);
				arrayListNew.add(arrayList.get(i));
//				for (int z = i; z + 1 < index; z++) {
//					arrayList.remove(z + 1);
//				}

			}

		}
	}
}
