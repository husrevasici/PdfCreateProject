package PdfProject;

import java.util.regex.Pattern;

class DersinIsYukuValueAdd {
	String etkinlik;
	String toplamhaftaSayisi;
	String süre;
	String donemSonuToplamIsYuku;

	DersinIsYukuValueAdd(String etkinlik, String toplamhaftaSayisi, String süre, String donemSonuToplamIsYuku) {
		this.etkinlik = etkinlik;
		this.toplamhaftaSayisi = toplamhaftaSayisi;
		this.süre = süre;
		this.donemSonuToplamIsYuku = donemSonuToplamIsYuku;
	}
}

public class DersinIsYuku extends DersTanimlamaFormlariRead {

	public void start() {
		for (int i = 0; i < DersinIsYuku.length; i++) {
			pdfLineEdit(DersinIsYuku[i]);
		}
	} // end function start

	private void pdfLineEdit(String DersinIsYuku) {
		p = Pattern.compile(DersinIsYuku, Pattern.CASE_INSENSITIVE);
		DersinIsYukuValueAdd d;
		for (int i = 0; i < 1; i++) {
			m = p.matcher(arrayListNew.get(15));
			while (m.find()) {
				d = new DersinIsYukuValueAdd(m.group(1), m.group(2), m.group(3), m.group(4));
				arrayListDersinIsYuku.add(d);
				System.out.println("grup 1: " + m.group(1) + "  grup 2: " + m.group(2) + "  grup3: " + m.group(3)
						+ " grup4: " + m.group(4));

			}
		}
	} // end function pdfLineEdit
}// end class
