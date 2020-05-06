package PdfProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class CPdfDatabaseAdd extends DatabaseConnection {
	CPdfRead cPdfRead = new CPdfRead();
	static boolean flag = false;
	static boolean flag1 = false;
	static boolean flag2 = false;
	static String INSERT_QUERY = "INSERT INTO `c_ogrenci_ders_degerlendirme_anketi` "
			+ "(`id`, `sorulan_anket_sorusu`, `katilan_ogrenci_sayisi`, `anket_puani`, `ders_kodu`) VALUES "
			+ "(?,?,?,?,?)";

	static String INSERT_QUERY_DERS_DEGERLENDIRME_ANKET_PUAN = "INSERT INTO `c_ogrenci_ders_degerlendirme_anketi_puan`"
			+ "(`ders_kodu`, `sıfır_ikibucuk`, `ikibucuk_ikinoktaalti`, `ikinoktaalti_ikinoktayedi`"
			+ ", `ikinoktayedi_ikinoktasekiz`, `ikinoktasekiz_ikinoktadokuz`, `ikinoktadokuz_uc`, `uc_bes`) VALUES "
			+ "(?,?,?,?,?,?,?,?)";
	static String INSERT_QUERY_ANKET_RAPOR = "INSERT INTO `c_ogrenci_ders_degerlendirme_anketi_rapor` "
			+ "(`id`, `maximum`, `minimum`, `ortalama`, `sifir_alti`, `bes_ustu`) VALUES " + "(?,?,?,?,?,?)";

	public void DatabaseControl() throws Throwable {
		String dersKodu = APdfRead.h.get("id");
		Connection connection = veritabaninaBaglan();
		String q = "select*from c_ogrenci_ders_degerlendirme_anketi where ders_kodu=" + dersKodu.trim();

		PreparedStatement ps = veritabaninaBaglan().prepareStatement(q);

		ResultSet rs = ps.executeQuery();
		System.out.println("c_ogrenci_ders_degerlendirme_anketi--while döngüsüne geldi");
		while (rs.next()) {
			flag = true;
			System.out.println("while döngüsüne girdi.");
			System.out.println("Veritabanından gelen id 'nin değeri: " + rs.getString("ders_kodu"));
			if (rs.getString("ders_kodu").equals(APdfRead.h.get("id"))) {
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

//	static APdfRead aPdfRead = new APdfRead();
	public void Add() throws Throwable {

		for (int i = 0; i < cPdfRead.arrayListid.size(); i++) {

			DatabaseAdd(cPdfRead.arrayListid.get(i), cPdfRead.arrayListAnketSorulari.get(i),
					cPdfRead.arrayListKatilanOgrenciSayisi.get(i), cPdfRead.arrayListAnketPuani.get(i));
		}
		DatabaseAddAnketPuan();
	}

	public void DatabaseControl1() throws Throwable {
		String dersKodu = APdfRead.h.get("id");
		Connection connection = veritabaninaBaglan();
		String q = "select*from c_ogrenci_ders_degerlendirme_anketi_puan where ders_kodu=" + dersKodu.trim();
		PreparedStatement ps = veritabaninaBaglan().prepareStatement(q);

		ResultSet rs = ps.executeQuery();
		System.out.println("while döngüsüne geldi");
		while (rs.next()) {
			flag1 = true;
			System.out.println("while döngüsüne girdi.");
			System.out.println("Veritabanından gelen id 'nin değeri: " + rs.getString("ders_kodu"));
			if (rs.getString("ders_kodu").equals(APdfRead.h.get("id"))) {
				System.out.println("veritabaninda kayitli bir ders vardir.");

			} else {
				System.out.println("veritabaninda kayitli bir ders yoktur.");

			}

		}
		if (flag1 == false) {
			DatabaseAddAnketPuan();
		}
		System.out.println("while döngüsünden çıktı");
		ps.close();
		rs.close();
		connection.close();
	}

	private static void DatabaseAdd(int id, String AnketSorulari, int KatilanOgrenciSayisi, double AnketPuani)
			throws Exception {

		int dersId = Integer.parseInt(APdfRead.h.get("id"));

		con = veritabaninaBaglan();
		PreparedStatement prpstmt = null;
		prpstmt = con.prepareStatement(INSERT_QUERY);

		prpstmt.setInt(1, id);
		prpstmt.setString(2, AnketSorulari);
		prpstmt.setInt(3, KatilanOgrenciSayisi);
		prpstmt.setDouble(4, AnketPuani);
		prpstmt.setInt(5, dersId);
		prpstmt.executeUpdate();

	}

	private static void DatabaseAddAnketPuan() throws Exception {

		con = veritabaninaBaglan();
		CPdfRead cRead = new CPdfRead();
		int dersId = Integer.parseInt(APdfRead.h.get("id"));
		PreparedStatement prpstmt1 = null;
		prpstmt1 = con.prepareStatement(INSERT_QUERY_DERS_DEGERLENDIRME_ANKET_PUAN);

		prpstmt1.setInt(1, dersId);
		prpstmt1.setInt(2, cRead.countTwoDotFiveUnder);
		prpstmt1.setInt(3, cRead.countTwoDotSixBetweenFive);
		prpstmt1.setInt(4, cRead.countTwoDotSevenBetweenTwoDotSix);
		prpstmt1.setInt(5, cRead.countTwoDotEightBetweenTwoDotSeven);
		prpstmt1.setInt(6, cRead.countTwoDotNineBetweenTwoDotEight);
		prpstmt1.setInt(7, cRead.countthreeBetweenTwoDotNine);
		prpstmt1.setInt(8, cRead.countthreeBetweenFive);
		prpstmt1.executeUpdate();
		prpstmt1.close();

	}

	public void DatabaseControl2() throws Throwable {
		String dersKodu = APdfRead.h.get("id");
		Connection connection = veritabaninaBaglan();
		String q = "select*from c_ogrenci_ders_degerlendirme_anketi_rapor where id=" + dersKodu.trim();

		PreparedStatement ps = veritabaninaBaglan().prepareStatement(q);

		ResultSet rs = ps.executeQuery();
		System.out.println("c_ogrenci_ders_degerlendirme_anketi_rapor-while döngüsüne geldi");
		while (rs.next()) {
			flag2 = true;
			System.out.println("while döngüsüne girdi.");
			System.out.println("Veritabanından gelen id 'nin değeri: " + rs.getString("id"));
			if (rs.getString("id").equals(APdfRead.h.get("id"))) {
				System.out.println("veritabaninda kayitli bir ders vardir.");

			} else {
				System.out.println("veritabaninda kayitli bir ders yoktur.");

			}

		}
		if (flag2 == false) {
			DatabaseAddAnketRapor();
		}
		System.out.println("while döngüsünden çıktı");
		ps.close();
		rs.close();
		connection.close();
	}

	private static void DatabaseAddAnketRapor() throws Exception {

		con = veritabaninaBaglan();
		CPdfRead cRead = new CPdfRead();
		int dersId = Integer.parseInt(APdfRead.h.get("id"));
		PreparedStatement prpstmt1 = null;
		prpstmt1 = con.prepareStatement(INSERT_QUERY_ANKET_RAPOR);

		prpstmt1.setInt(1, dersId);
		prpstmt1.setString(2, cRead.max);
		prpstmt1.setString(3, cRead.min);
		prpstmt1.setString(4, cRead.average);
		prpstmt1.setInt(5, cRead.countZeroUnder);
		prpstmt1.setInt(6, cRead.countFiveOn);
		prpstmt1.executeUpdate();
		prpstmt1.close();

	}

}
