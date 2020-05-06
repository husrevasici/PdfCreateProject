package PdfProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class DersTanimlamaFormlariDatabaseAdd extends DatabaseConnection {

	DersTanimlamaFormlariRead dTF = new DersTanimlamaFormlariRead();
	static boolean flag = false;
	static String INSERT_QUERY = "INSERT INTO `ders_tanimlama_formu`"
			+ "(`id`,`DersinKoduveAdi`,`DersinYariyili`,`Dersinİcerigi`,`DersKitabi`,`YardimciDersKitaplari`,`DersinKredisi`,"
			+ "`DersinOnkosullari`,`DersinTuru`,`OgretimDili`,`DersinAmaclari`,`DersinOgrenimCiktilari`,`DersinVerilisBicimi`,"
			+ "`DersinHaftalıkDagilimi`,`EgitimveOgretimFaaliyetleri`) VALUES" + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	// String sql = "INSERT INTO tablename (col1, col2, col3) VALUES ('?', '?',
	// '?')";

	public void DatabaseControl() throws Throwable {
		
		Connection connection = veritabaninaBaglan();

		String q = "select*from ders_tanimlama_formu where id=101";
		PreparedStatement ps = veritabaninaBaglan().prepareStatement(q);
		ResultSet rs = ps.executeQuery(q);
		System.out.println("while döngüsüne geldi");
		while (rs.next()) {
			flag = true;
			System.out.println("while döngüsüne girdi.");
			System.out.println("Veritabanindan gelen id değeri: " + rs.getString("id"));
			if (rs.getString("id").equals("101")) {
				System.out.println("Veritabanin kayitli deger vardir.");

			} else {
				System.out.println("Veritabaninda kayitli bir ifade yoktur.");

			}
			System.out.println("while döngüsünden çıktı");

		}
		if (flag == false) {
			Add();
		}
		ps.close();
		rs.close();
		connection.close();
	}

	public void Add() throws Throwable {
		System.out.println("1");
		con = veritabaninaBaglan();
		int Id = Integer.parseInt(dTF.h.get("id"));
		DatabaseAdd(Id, dTF.h.get("Dersin Kodu ve Adı"), dTF.h.get("Dersin Yarıyılı"), dTF.h.get("Dersin İçeriği"),
				dTF.h.get("Ders Kitabı"), dTF.h.get("Yardımcı Ders Kitapları"), dTF.h.get("Dersin Kredisi"),
				dTF.h.get("Dersin Önkoşulları"), dTF.h.get("Dersin Türü"), dTF.h.get("Öğretim Dili"),
				dTF.h.get("Dersin Amaçları"), dTF.h.get("Dersin Öğrenim Çıktıları"), dTF.h.get("Dersin Veriliş Biçimi"),
				dTF.h.get("Dersin Haftalık Dağılımı"), dTF.h.get("Eğitim ve Öğretim Faaliyetleri"));

	}

	private static void DatabaseAdd(int id, String DersinKoduveAdi, String DersinYarili, String DersinIcerigi,
			String DersKitabi, String YardimciDersKitaplari, String DersinKredisi, String DersinOnkosullari,
			String DersinTürü, String OgretimDili, String DersinAmaclari, String DersinOgrenimCiktilari,
			String DersinVerilisBicimi, String DersinHaftalikDagilimi, String EgitimveOgretimFaaliyetleri)
			throws Exception {
		System.out.println("2");
		PreparedStatement prpstmt = null;
		prpstmt = con.prepareStatement(INSERT_QUERY);
		prpstmt.setInt(1, id);
		prpstmt.setString(2, DersinKoduveAdi);
		prpstmt.setString(3, DersinYarili);
		prpstmt.setString(4, DersinIcerigi);
		prpstmt.setString(5, DersKitabi);
		prpstmt.setString(6, YardimciDersKitaplari);
		prpstmt.setString(7, DersinKredisi);
		prpstmt.setString(8, DersinOnkosullari);
		prpstmt.setString(9, DersinTürü);
		prpstmt.setString(10, OgretimDili);
		prpstmt.setString(11, DersinAmaclari);
		prpstmt.setString(12, DersinOgrenimCiktilari);
		prpstmt.setString(13, DersinVerilisBicimi);
		prpstmt.setString(14, DersinHaftalikDagilimi);
		prpstmt.setString(15, EgitimveOgretimFaaliyetleri);
		System.out.println("3");
		prpstmt.executeUpdate();
		prpstmt.close();

	}
}
