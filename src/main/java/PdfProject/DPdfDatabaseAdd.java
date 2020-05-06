package PdfProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class DPdfDatabaseAdd extends DatabaseConnection {
	static boolean flag = false;
	static boolean flag1 = false;
	static boolean flag2 = false;
	static boolean flag3 = false;
	DPdfRead dPdfReadObject = new DPdfRead();
	static String INSERT_QUERY = "INSERT INTO `d_not_cizelgesi`"
			+ "(`id`,`StudentNumber`,`StudentNameSurname`,`Midterm1`,`FinalExam`,`LetterGrade`,`ders_kodu`) VALUES"
			+ "(?,?,?,?,?,?,?)";

	static String INSERT_QUERY1 = "INSERT INTO `d_not_cizelgesi_vize`"
			+ "(`ders_kodu`,`ortalama`,`ortalama_alti`,`ortalama_ustu`,`not0_25`,`not_25_50`,`not_50_75`,"
			+ "`not_75_100`,`Devamsizlik`,`not_0`,`Girmeyen`) VALUES" + "(?,?,?,?,?,?,?,?,?,?,?)";
	static String INSERT_QUERY2 = "INSERT INTO `d_not_cizelgesi_final`"
			+ "(`ders_kodu`,`ortalama`,`ortalama_alti`,`ortalama_ustu`,`not_0_25`,`not_25_50`,`not_50_75`,"
			+ "`not_75_100`,`devamsizlik`,`not_0`,`girmeyen`) VALUES" + "(?,?,?,?,?,?,?,?,?,?,?)";
	static String INSERT_QUERY3 = "INSERT INTO `d_not_cizelgesi_harf_notu`"
			+ "(`ders_kodu`,`AA`,`BA`,`BB`,`CB`,`CC`,`DC`,`DD`,`FD`,`FF`,`D`,`Gecersiz`) VALUES"
			+ "(?,?,?,?,?,?,?,?,?,?,?,?)";

	DPdfRead dRead = new DPdfRead();

	public void DatabaseControlDdersNotizelgesi() throws Throwable {
		String dersKodu = APdfRead.h.get("id");
		Connection connection = veritabaninaBaglan();
		String q = "select*from d_not_cizelgesi where ders_kodu=" + dersKodu.trim();

		PreparedStatement ps = veritabaninaBaglan().prepareStatement(q);

		ResultSet rs = ps.executeQuery();
		System.out.println("d_not_cizelgesi--while döngüsüne geldi");
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
			System.out.println("flag==false'ın içine girdi");
			Add();
		}
		System.out.println("while döngüsünden çıktı");
		ps.close();
		rs.close();
		connection.close();
	}

	public void Add() throws Throwable {
		con = veritabaninaBaglan();
		System.out.println("Add( fonksiyonu içerisinde girdi.)");
		for (StudentInformation information : dPdfReadObject.arrayListStudentInformation) {
			DatabaseAddDdersNotCizelgesi(information.Id, information.StudentNumber, information.StudentNameSurname,
					information.Midterm1, information.FinalExam, information.LetterGrade);
		}
	}

	private static void DatabaseAddDdersNotCizelgesi(int id, String StudentNumber, String StudentNameSurname,
			String Midterm1, String FinalExam, String LetterGrade) throws Exception {

		System.out.println("DatabaseAdd() fonksiyonu içerisinde");
		PreparedStatement prpstmt = null;
		int dersId = Integer.parseInt(APdfRead.h.get("id"));
		prpstmt = con.prepareStatement(INSERT_QUERY);
		prpstmt.setInt(1, id);
		prpstmt.setString(2, StudentNumber);
		prpstmt.setString(3, StudentNameSurname);
		prpstmt.setString(4, Midterm1);
		prpstmt.setString(5, FinalExam);
		prpstmt.setString(6, LetterGrade);
		prpstmt.setInt(7, dersId);

		prpstmt.executeUpdate();

	}

	public void DatabaseControlDdersNotCizelgesiVize() throws Throwable {
		String dersKodu = APdfRead.h.get("id");
		Connection connection = veritabaninaBaglan();
		String q = "select*from d_not_cizelgesi_vize where ders_kodu=" + dersKodu.trim();

		PreparedStatement ps = veritabaninaBaglan().prepareStatement(q);

		ResultSet rs = ps.executeQuery();
		System.out.println("d_not_cizelgesi_vize--while döngüsüne geldi");
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
			System.out.println("flag==false'ın içine girdi");
			DatabaseAddDdersNotCizelgesiVize();
		}
		System.out.println("while döngüsünden çıktı");
		ps.close();
		rs.close();
		connection.close();
	}

	private void DatabaseAddDdersNotCizelgesiVize() throws Throwable {
		System.out.println("DatabaseAddDdersNotCizelgesiVize() fonksiyonu içerisinde");
		con = veritabaninaBaglan();
		PreparedStatement prpstmt = null;
		int dersId = Integer.parseInt(APdfRead.h.get("id"));
		prpstmt = con.prepareStatement(INSERT_QUERY1);
		prpstmt.setInt(1, dersId);
		prpstmt.setDouble(2, dRead.resultsFromTheMidtermExamDoubleValue[0]);
		prpstmt.setInt(3, dRead.resultsFromTheMidtermExamIntegerValue[0]);
		prpstmt.setInt(4, dRead.resultsFromTheMidtermExamIntegerValue[1]);
		prpstmt.setInt(5, dRead.resultsFromTheMidtermExamIntegerValue[2]);
		prpstmt.setInt(6, dRead.resultsFromTheMidtermExamIntegerValue[3]);
		prpstmt.setInt(7, dRead.resultsFromTheMidtermExamIntegerValue[4]);
		prpstmt.setInt(8, dRead.resultsFromTheMidtermExamIntegerValue[5]);
		prpstmt.setInt(9, dRead.resultsFromTheMidtermExamIntegerValue[6]);
		prpstmt.setInt(10, dRead.resultsFromTheMidtermExamIntegerValue[7]);
		prpstmt.setInt(11, dRead.resultsFromTheMidtermExamIntegerValue[8]);

		prpstmt.executeUpdate();

	}

	public void DatabaseControlDdersNotCizelgesiFinal() throws Throwable {
		String dersKodu = APdfRead.h.get("id");
		Connection connection = veritabaninaBaglan();
		String q = "select*from d_not_cizelgesi_final where ders_kodu=" + dersKodu.trim();

		PreparedStatement ps = veritabaninaBaglan().prepareStatement(q);

		ResultSet rs = ps.executeQuery();
		System.out.println("d_not_cizelgesi_final--while döngüsüne geldi");
		while (rs.next()) {
			flag2 = true;
			System.out.println("while döngüsüne girdi.");
			System.out.println("Veritabanından gelen id 'nin değeri: " + rs.getString("ders_kodu"));
			if (rs.getString("ders_kodu").equals(APdfRead.h.get("id"))) {
				System.out.println("veritabaninda kayitli bir ders vardir.");

			} else {
				System.out.println("veritabaninda kayitli bir ders yoktur.");

			}

		}
		if (flag2 == false) {
			System.out.println("flag==false'ın içine girdi");
			DatabaseAddDdersNotCizelgesiFinal();
		}
		System.out.println("while döngüsünden çıktı");
		ps.close();
		rs.close();
		connection.close();
	}

	private void DatabaseAddDdersNotCizelgesiFinal() throws Throwable {
		System.out.println("DatabaseAddDdersNotCizelgesiFinal() fonksiyonu içerisinde");
		con = veritabaninaBaglan();
		PreparedStatement prpstmt = null;
		int dersId = Integer.parseInt(APdfRead.h.get("id"));
		prpstmt = con.prepareStatement(INSERT_QUERY2);
		prpstmt.setInt(1, dersId);
		prpstmt.setDouble(2, dRead.resultsFromTheFinalExamDoubleValue[0]);
		prpstmt.setInt(3, dRead.resultsFromTheFinalExamIntegerValue[0]);
		prpstmt.setInt(4, dRead.resultsFromTheFinalExamIntegerValue[1]);
		prpstmt.setInt(5, dRead.resultsFromTheFinalExamIntegerValue[2]);
		prpstmt.setInt(6, dRead.resultsFromTheFinalExamIntegerValue[3]);
		prpstmt.setInt(7, dRead.resultsFromTheFinalExamIntegerValue[4]);
		prpstmt.setInt(8, dRead.resultsFromTheFinalExamIntegerValue[5]);
		prpstmt.setInt(9, dRead.resultsFromTheFinalExamIntegerValue[6]);
		prpstmt.setInt(10, dRead.resultsFromTheFinalExamIntegerValue[7]);
		prpstmt.setInt(11, dRead.resultsFromTheFinalExamIntegerValue[8]);

		prpstmt.executeUpdate();

	}

	public void DatabaseControlDdersNotCizelgesiHarfNotu() throws Throwable {
		String dersKodu = APdfRead.h.get("id");
		Connection connection = veritabaninaBaglan();
		String q = "select*from d_not_cizelgesi_harf_notu where ders_kodu=" + dersKodu.trim();

		PreparedStatement ps = veritabaninaBaglan().prepareStatement(q);

		ResultSet rs = ps.executeQuery();
		System.out.println("d_not_cizelgesi_harf_notu--while döngüsüne geldi");
		while (rs.next()) {
			flag3 = true;
			System.out.println("while döngüsüne girdi.");
			System.out.println("Veritabanından gelen id 'nin değeri: " + rs.getString("ders_kodu"));
			if (rs.getString("ders_kodu").equals(APdfRead.h.get("id"))) {
				System.out.println("veritabaninda kayitli bir ders vardir.");

			} else {
				System.out.println("veritabaninda kayitli bir ders yoktur.");

			}

		}
		if (flag3 == false) {
			System.out.println("flag==false'ın içine girdi");
			DatabaseDdersNotCizelgesiHarfNotu();
		}
		System.out.println("while döngüsünden çıktı");
		ps.close();
		rs.close();
		connection.close();
	}

	private void DatabaseDdersNotCizelgesiHarfNotu() throws Throwable {
		System.out.println("DatabaseDdersNotCizelgesiHarfNotu() fonksiyonu içerisinde");
		con = veritabaninaBaglan();
		PreparedStatement prpstmt = null;
		int dersId = Integer.parseInt(APdfRead.h.get("id"));
		prpstmt = con.prepareStatement(INSERT_QUERY3);
		prpstmt.setInt(1, dersId);
		prpstmt.setInt(2, dRead.resultsFromTheMidtermExamLetterGrade[1]); // AA
		prpstmt.setInt(3, dRead.resultsFromTheMidtermExamLetterGrade[2]); // BA
		prpstmt.setInt(4, dRead.resultsFromTheMidtermExamLetterGrade[3]); // BB
		prpstmt.setInt(5, dRead.resultsFromTheMidtermExamLetterGrade[4]); // BC
		prpstmt.setInt(6, dRead.resultsFromTheMidtermExamLetterGrade[5]); // CC
		prpstmt.setInt(7, dRead.resultsFromTheMidtermExamLetterGrade[6]); // DC
		prpstmt.setInt(8, dRead.resultsFromTheMidtermExamLetterGrade[7]); // DD
		prpstmt.setInt(9, dRead.resultsFromTheMidtermExamLetterGrade[8]); // FD
		prpstmt.setInt(10, dRead.resultsFromTheMidtermExamLetterGrade[9]); // FF
		prpstmt.setInt(11, dRead.resultsFromTheMidtermExamLetterGrade[0]); // D
		prpstmt.setInt(12, dRead.resultsFromTheMidtermExamLetterGrade[10]); // XX
		prpstmt.executeUpdate();
	}
}
