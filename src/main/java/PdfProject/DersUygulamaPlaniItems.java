package PdfProject;

public class DersUygulamaPlaniItems {

	private int id;
	private String dersAdi, dersKodu, kredi, AKTS, onKosul, ogretimElamani, ePosta, ofisSaatleri, dersSaatleri, web,
			aciklama, dersKaynaklari, dersinAmaclari, dersCiktilari, dersler, degerlendirme;

	public dersUygulamaPlaniItems(int id, String dersAdi, String dersKodu, String kredi, String AKTS, String onKosul,
			String ogretimElamani, String ePosta, String ofisSaatleri, String dersSaatleri, String web, String aciklama,
			String dersKaynaklari, String dersinAmaclari, String dersCiktilari, String dersler, String degerlendirme) {
		this.setId(id);
		this.setDersAdi(dersAdi);
		this.setDersKodu(dersKodu);
		this.setKredi(kredi);
		this.setAKTS(AKTS);
		this.setOnKosul(onKosul);
		this.setOgretimElamani(ogretimElamani);
		this.setePosta(ePosta);
		this.setOfisSaatleri(ofisSaatleri);
		this.setDersSaatleri(dersSaatleri);
		this.setWeb(web);
		this.setAciklama(aciklama);
		this.setDersKaynaklari(dersKaynaklari);
		this.setDersinAmaclari(dersinAmaclari);
		this.setDersCiktilari(dersCiktilari);
		this.setDersler(dersler);
		this.setDegerlendirme(degerlendirme);
	}

	public String getDersAdi() {
		return dersAdi;
	}

	public void setDersAdi(String dersAdi) {
		this.dersAdi = dersAdi;
	}

	public String getDersKodu() {
		return dersKodu;
	}

	public void setDersKodu(String dersKodu) {
		this.dersKodu = dersKodu;
	}

	public String getKredi() {
		return kredi;
	}

	public void setKredi(String kredi) {
		this.kredi = kredi;
	}

	public String getAKTS() {
		return AKTS;
	}

	public void setAKTS(String aKTS) {
		AKTS = aKTS;
	}

	public String getOnKosul() {
		return onKosul;
	}

	public void setOnKosul(String onKosul) {
		this.onKosul = onKosul;
	}

	public String getOgretimElamani() {
		return ogretimElamani;
	}

	public void setOgretimElamani(String ogretimElamani) {
		this.ogretimElamani = ogretimElamani;
	}

	public String getePosta() {
		return ePosta;
	}

	public void setePosta(String ePosta) {
		this.ePosta = ePosta;
	}

	public String getOfisSaatleri() {
		return ofisSaatleri;
	}

	public void setOfisSaatleri(String ofisSaatleri) {
		this.ofisSaatleri = ofisSaatleri;
	}

	public String getDersSaatleri() {
		return dersSaatleri;
	}

	public void setDersSaatleri(String dersSaatleri) {
		this.dersSaatleri = dersSaatleri;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public String getDersKaynaklari() {
		return dersKaynaklari;
	}

	public void setDersKaynaklari(String dersKaynaklari) {
		this.dersKaynaklari = dersKaynaklari;
	}

	public String getDersinAmaclari() {
		return dersinAmaclari;
	}

	public void setDersinAmaclari(String dersinAmaclari) {
		this.dersinAmaclari = dersinAmaclari;
	}

	public String getDersCiktilari() {
		return dersCiktilari;
	}

	public void setDersCiktilari(String dersCiktilari) {
		this.dersCiktilari = dersCiktilari;
	}

	public String getDersler() {
		return dersler;
	}

	public void setDersler(String dersler) {
		this.dersler = dersler;
	}

	public String getDegerlendirme() {
		return degerlendirme;
	}

	public void setDegerlendirme(String degerlendirme) {
		this.degerlendirme = degerlendirme;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
