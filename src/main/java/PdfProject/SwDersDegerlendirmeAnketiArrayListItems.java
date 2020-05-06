package PdfProject;

public class SwDersDegerlendirmeAnketiArrayListItems {
	private int id;
	private String sorulan_anket_sorusu, katilan_ogrenci_sayisi, anket_puani, ders_kodu;

	public SwDersDegerlendirmeAnketiArrayListItems(int id, String sorulan_anket_sorusu, String katilan_ogrenci_sayisi,
			String anket_puani, String ders_kodu) {

		this.setId(id);
		this.setSorulan_anket_sorusu(sorulan_anket_sorusu);
		this.setKatilan_ogrenci_sayisi(katilan_ogrenci_sayisi);
		this.setAnket_puani(anket_puani);
		this.setDers_kodu(ders_kodu);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSorulan_anket_sorusu() {
		return sorulan_anket_sorusu;
	}

	public void setSorulan_anket_sorusu(String sorulan_anket_sorusu) {
		this.sorulan_anket_sorusu = sorulan_anket_sorusu;
	}

	public String getKatilan_ogrenci_sayisi() {
		return katilan_ogrenci_sayisi;
	}

	public void setKatilan_ogrenci_sayisi(String katilan_ogrenci_sayisi) {
		this.katilan_ogrenci_sayisi = katilan_ogrenci_sayisi;
	}

	public String getAnket_puani() {
		return anket_puani;
	}

	public void setAnket_puani(String anket_puani) {
		this.anket_puani = anket_puani;
	}

	public String getDers_kodu() {
		return ders_kodu;
	}

	public void setDers_kodu(String ders_kodu) {
		this.ders_kodu = ders_kodu;
	}
}
