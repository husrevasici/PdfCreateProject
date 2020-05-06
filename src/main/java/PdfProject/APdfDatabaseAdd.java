package PdfProject;

import java.sql.*;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class APdfDatabaseAdd extends DatabaseConnection {
	static int dersKoduId;
	static boolean flag = false;
	static DatabaseItemsControl databaseItemsControl = new DatabaseItemsControl();
	private static String INSERT_QUERY = "INSERT INTO `a_ders_uygulama_plani1`"
			+ "(`id`, `Ders_adi`, `Ders_kodu`, `Kredi`, `AKTS`, "
			+ "`Önkosul`, `Ögretim_elemani`, `Eposta`, `Ofis_saatleri`,"
			+ " `Ders_saatleri`, `Web`, `Aciklama`, `Ders_kaynaklari`, "
			+ "`Dersin_amaclari`, `Ders_ciktilari`, `Dersler`, `Degerlendirme`) VALUES "
			+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public void DatabaseControl() throws Throwable {

		Connection connection = veritabaninaBaglan();
		String q = "select*from a_ders_uygulama_plani1 where id=307";
		PreparedStatement ps = veritabaninaBaglan().prepareStatement(q);

		ResultSet rs = ps.executeQuery();
		System.out.println("while döngüsüne geldi");
		while (rs.next()) {
			flag = true;
			System.out.println("while döngüsüne girdi.");
			System.out.println("Veritabanından gelen id 'nin değeri: " + rs.getString("id"));
			if (rs.getString("id").equals("307")) {
				System.out.println("veritabaninda kayitli bir ders vardir.");

			} else {
				System.out.println("veritabaninda kayitli bir ders yoktur.");

			}

		}
		if (flag == false) {
			Add();
		}
		System.out.println("while döngüsünden çıktı");
		ps.close();
		rs.close();
		connection.close();
	}

	public static void Add() {
		try {
			System.out.println("1");
			con = veritabaninaBaglan(); // DatabaseConnection Classında geldi.
			int Id = Integer.parseInt(APdfRead.h.get("id"));
			KullaniciEkle(Id, APdfRead.h.get("Ders adi"), APdfRead.h.get("Ders kodu"), APdfRead.h.get("Kredi"),
					APdfRead.h.get("AKTS"), APdfRead.h.get("Önkoşul"), APdfRead.h.get("Öğretim elemanı"),
					APdfRead.h.get("Eposta"), APdfRead.h.get("Ofis saatleri"), APdfRead.h.get("Ders saatleri"),
					APdfRead.h.get("Web"), APdfRead.h.get("Açıklama"), APdfRead.h.get("Ders kaynakları"),
					APdfRead.h.get("Dersin amaçları"), APdfRead.h.get("Ders çıktıları"), APdfRead.h.get("Dersler"),
					APdfRead.h.get("Değerlendirme"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void KullaniciEkle(int id, String Ders_adi, String Ders_kodu, String Kredi, String AKTS,
			String Önkosul, String Ögretim_elemani, String Eposta, String Ofis_saatleri, String Ders_saatleri,
			String Web, String Aciklama, String Ders_kaynaklari, String Ders_amaclari, String Ders_ciktilari,
			String Dersler, String Degerlendirme) throws Exception {

		System.out.println("2");
		PreparedStatement prpstmt = null;
		prpstmt = con.prepareStatement(INSERT_QUERY);
		prpstmt.setInt(1, id);
		prpstmt.setString(2, Ders_adi);
		prpstmt.setString(3, Ders_kodu);
		prpstmt.setString(4, Kredi);
		prpstmt.setString(5, AKTS);
		prpstmt.setString(6, Önkosul);
		prpstmt.setString(7, Ögretim_elemani);
		prpstmt.setString(8, Eposta);
		prpstmt.setString(9, Ofis_saatleri);
		prpstmt.setString(10, Ders_saatleri);
		prpstmt.setString(11, Web);
		prpstmt.setString(12, Aciklama);
		prpstmt.setString(13, Ders_kaynaklari);
		prpstmt.setString(14, Ders_amaclari);
		prpstmt.setString(15, Ders_ciktilari);
		prpstmt.setString(16, Dersler);
		prpstmt.setString(17, Degerlendirme);
		// sorguyu gönder
		prpstmt.executeUpdate();
		System.out.println("\n***" + id + " id'li kullanici eklendi.");
		prpstmt.close();
		// databaseItemsControl.A_Ders_Uygulama_Plani_ControlItems();

	}

}
