package PdfProject;

import java.util.regex.Pattern;

public class CPdfLineEdit extends CPdfRead {

	private String f = "26.";
	private String s = "G E N E L   O R TA L A M A :";
	//
	static private int index;

	public void pdfLineEditIndexFind() throws Exception {
		p = Pattern.compile(f);
		p1 = Pattern.compile(s);

		// p1 deseninden m1 ile arama işlemi ve bulduğunda index=i yapmak
		for (int i = 0; i < arrayList.size(); i++) {
			m = p.matcher(arrayList.get(i));
			m1 = p1.matcher(arrayList.get(i));
			if (m1.find()) {
				index = i;
				// System.out.println("indeks: " + index);
			}
		}

		// p deseni üzerinde m ile arama yapmak ve bulduğunda kayan satırları düzenlemek
		for (int i = 0; i < arrayList.size(); i++) {
			m = p.matcher(arrayList.get(i));
			if (m.find()) {
				for (int j = i; i < index - 1; i++) {
					arrayList.set(j, arrayList.get(j) + arrayList.get(j + 1) + " ");
					arrayList.remove(j + 1);
				}
			}
		}

	}
}
