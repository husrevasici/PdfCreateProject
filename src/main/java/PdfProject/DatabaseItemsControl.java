package PdfProject;

import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class DatabaseItemsControl extends DatabaseConnection {

	static String controlDers_Adi, controlDers_Kodu, controlKredi, controlAKTS, controlÖnkosul, controlDegerlendirme,
			ders_Adi, ders_Kodu, kredi, AKTS, onkosul, degerlendirme, Eposta;
	private static int controlId, id;

	public static void A_Ders_Uygulama_Plani_ControlItems() {
		try {
			con = veritabaninaBaglan();
			Statement st = (Statement) con.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM  a_ders_uygulama_plani_control");
			System.out.println("3");
			while (result.next()) {
			System.out.println("4");
				int controlId = result.getInt("id");
				controlDers_Adi = result.getString("Ders_adi");
				controlDers_Kodu = result.getString("Ders_kodu");
				controlKredi = result.getString("Kredi");
				controlAKTS = result.getString("AKTS");
				controlÖnkosul = result.getString("Önkosul");
				controlDegerlendirme = result.getString("Degerlendirme");
				A_Ders_Uygulama_PlaniItems();
				System.out.println("5");
			}

		} catch (Exception e) {
			System.out.println("!! A_Ders_Uygulama_Plani_ControlItems-- hata !!");
			e.printStackTrace();
		}

	}

	public static void A_Ders_Uygulama_PlaniItems() {
		try {
			System.out.println("5");
			con = veritabaninaBaglan();
			Statement st = (Statement) con.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM  a_ders_uygulama_plani1");
			while (result.next()) {
				System.out.println("6");
				id = result.getInt("id");
				ders_Adi = result.getString("Ders_adi");
				ders_Kodu = result.getString("Ders_kodu");
				kredi = result.getString("Kredi");
				AKTS = result.getString("AKTS");
				onkosul = result.getString("Önkosul");
				degerlendirme = result.getString("Degerlendirme");
				Eposta = result.getString("Eposta");

				ControlItems();
			}

		} catch (Exception e) {
			System.out.println("!! A_Ders_Uygulama_PlaniItems--hata!!");
			e.printStackTrace();
		}

	}

	public static void ControlItems() {

		System.out.println("7");
		System.out.println("id karşılaştırması: " + controlId + "-------------" + id);
		System.out.println("ders adi karşılaştırılması: " + controlDers_Adi + "-------------" + ders_Adi);
		System.out.println("Ders kodu karşılaştırması: " + controlDers_Kodu + "-------------" + ders_Kodu);
		System.out.println("Kredi karşılaştırılması: " + controlKredi + "-------------" + kredi);
		System.out.println("AKTS karşılaştırması: " + controlAKTS + "-------------" + AKTS);
		System.out.println(
				"Önkoşul adi karşılaştırılması: " + "(" + controlÖnkosul + ")" + " *** " + "(" + onkosul + ")");

	}

}
