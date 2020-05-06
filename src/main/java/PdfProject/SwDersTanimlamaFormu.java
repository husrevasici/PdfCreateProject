package PdfProject;

public class SwDersTanimlamaFormu {

	private int id;
	private String DersinKoduveAdi, DersinYariyili, Dersinİcerigi, DersKitabi, YardimciDersKitaplari, DersinKredisi,
			DersinOnkosullari, DersinTuru, OgretimDili, DersinAmaclari, DersinOgrenimCiktilari, DersinVerilisBicimi,
			DersinHaftalıkDagilimi, EgitimveOgretimFaaliyetleri;

	public SwDersTanimlamaFormu(int id, String DersinKoduveAdi, String DersinYariyili, String Dersinİcerigi,
			String DersKitabi, String YardimciDersKitaplari, String DersinKredisi, String DersinOnkosullari,
			String DersinTuru, String OgretimDili, String DersinAmaclari, String DersinOgrenimCiktilari,
			String DersinVerilisBicimi, String DersinHaftalıkDagilimi, String EgitimveOgretimFaaliyetleri) {
		this.setId(id);
		this.setDersinKoduveAdi(DersinKoduveAdi);
		this.setDersinYariyili(DersinYariyili);
		this.setDersinİcerigi(Dersinİcerigi);
		this.setDersKitabi(DersKitabi);
		this.setYardimciDersKitaplari(YardimciDersKitaplari);
		this.setDersinKredisi(DersinKredisi);
		this.setDersinOnkosullari(DersinOnkosullari);
		this.setDersinTuru(DersinTuru);
		this.setOgretimDili(OgretimDili);
		this.setDersinAmaclari(DersinAmaclari);
		this.setDersinOgrenimCiktilari(DersinOgrenimCiktilari);
		this.setDersinVerilisBicimi(DersinVerilisBicimi);
		this.setDersinHaftalıkDagilimi(DersinHaftalıkDagilimi);
		this.setEgitimveOgretimFaaliyetleri(EgitimveOgretimFaaliyetleri);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDersinKoduveAdi() {
		return DersinKoduveAdi;
	}

	public void setDersinKoduveAdi(String dersinKoduveAdi) {
		DersinKoduveAdi = dersinKoduveAdi;
	}

	public String getDersinYariyili() {
		return DersinYariyili;
	}

	public void setDersinYariyili(String dersinYariyili) {
		DersinYariyili = dersinYariyili;
	}

	public String getDersinİcerigi() {
		return Dersinİcerigi;
	}

	public void setDersinİcerigi(String dersinİcerigi) {
		Dersinİcerigi = dersinİcerigi;
	}

	public String getDersKitabi() {
		return DersKitabi;
	}

	public void setDersKitabi(String dersKitabi) {
		DersKitabi = dersKitabi;
	}

	public String getYardimciDersKitaplari() {
		return YardimciDersKitaplari;
	}

	public void setYardimciDersKitaplari(String yardimciDersKitaplari) {
		YardimciDersKitaplari = yardimciDersKitaplari;
	}

	public String getDersinKredisi() {
		return DersinKredisi;
	}

	public void setDersinKredisi(String dersinKredisi) {
		DersinKredisi = dersinKredisi;
	}

	public String getDersinOnkosullari() {
		return DersinOnkosullari;
	}

	public void setDersinOnkosullari(String dersinOnkosullari) {
		DersinOnkosullari = dersinOnkosullari;
	}

	public String getDersinTuru() {
		return DersinTuru;
	}

	public void setDersinTuru(String dersinTuru) {
		DersinTuru = dersinTuru;
	}

	public String getOgretimDili() {
		return OgretimDili;
	}

	public void setOgretimDili(String ogretimDili) {
		OgretimDili = ogretimDili;
	}

	public String getDersinAmaclari() {
		return DersinAmaclari;
	}

	public void setDersinAmaclari(String dersinAmaclari) {
		DersinAmaclari = dersinAmaclari;
	}

	public String getDersinOgrenimCiktilari() {
		return DersinOgrenimCiktilari;
	}

	public void setDersinOgrenimCiktilari(String dersinOgrenimCiktilari) {
		DersinOgrenimCiktilari = dersinOgrenimCiktilari;
	}

	public String getDersinVerilisBicimi() {
		return DersinVerilisBicimi;
	}

	public void setDersinVerilisBicimi(String dersinVerilisBicimi) {
		DersinVerilisBicimi = dersinVerilisBicimi;
	}

	public String getDersinHaftalıkDagilimi() {
		return DersinHaftalıkDagilimi;
	}

	public void setDersinHaftalıkDagilimi(String dersinHaftalıkDagilimi) {
		DersinHaftalıkDagilimi = dersinHaftalıkDagilimi;
	}

	public String getEgitimveOgretimFaaliyetleri() {
		return EgitimveOgretimFaaliyetleri;
	}

	public void setEgitimveOgretimFaaliyetleri(String egitimveOgretimFaaliyetleri) {
		EgitimveOgretimFaaliyetleri = egitimveOgretimFaaliyetleri;
	}
}
