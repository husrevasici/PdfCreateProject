package PdfProject;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class APdfCreate extends APdfRead {

	public APdfCreate() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void PdfCreate2() throws Exception {

		DatabaseItemsControl d = new DatabaseItemsControl();
		String fileNew = "D:/dowlandPdf/AverisonLast.pdf";
		PdfWriter writer = new PdfWriter(fileNew);
		// Creating a PdfDocument object
		PdfDocument pdfDoc = new PdfDocument(writer);

		// Creating a Document object
		Document doc = new Document(pdfDoc);

		DatabaseConnection databaseConnection = new DatabaseConnection();
		Connection connection = (Connection) databaseConnection.veritabaninaBaglan();

		Statement smt = (Statement) databaseConnection.con.createStatement();
		Statement smt1 = (Statement) databaseConnection.con.createStatement();

		String q = "select*from a_ders_uygulama_plani1";
		String q1 = "select*from a_ders_uygulama_plani_control";
		ResultSet rs = smt.executeQuery(q);
		ResultSet rs1 = smt1.executeQuery(q1);

		ArrayList<String> aDersUygulamaPlani = new ArrayList<String>();
		ArrayList<String> aDersUygulamaPlaniControlLineValue = new ArrayList<String>();
		ArrayList<String> aDersUygulamaPlaniControlLineName = new ArrayList<String>();
		// ArrayList<String> aDersUygulamaPlaniControl = new ArrayList<String>();
		while (rs.next()) {
			// aDersUygulamaPlani.add(rs.getString("Ders_adi"));
			aDersUygulamaPlani.add(rs.getString("Ders_kodu"));
			aDersUygulamaPlani.add(rs.getString("Kredi"));
			aDersUygulamaPlani.add(rs.getString("AKTS"));
			aDersUygulamaPlani.add(rs.getString("Önkosul"));
			aDersUygulamaPlani.add(rs.getString("Degerlendirme"));

			aDersUygulamaPlaniControlLineValue.add(rs.getString("Ögretim_elemani"));
			aDersUygulamaPlaniControlLineName.add("Ögretim Elemani");
			aDersUygulamaPlaniControlLineValue.add(rs.getString("Eposta"));
			aDersUygulamaPlaniControlLineName.add("Eposta");
			aDersUygulamaPlaniControlLineValue.add(rs.getString("Ofis_saatleri"));
			aDersUygulamaPlaniControlLineName.add("Ofis Saatleri");
			aDersUygulamaPlaniControlLineValue.add(rs.getString("Ders_saatleri"));
			aDersUygulamaPlaniControlLineName.add("Ders Saatleri");
			aDersUygulamaPlaniControlLineValue.add(rs.getString("Web"));
			aDersUygulamaPlaniControlLineName.add("Web");
			aDersUygulamaPlaniControlLineValue.add(rs.getString("Aciklama"));
			aDersUygulamaPlaniControlLineName.add("Aciklama");
			aDersUygulamaPlaniControlLineValue.add(rs.getString("Ders_kaynaklari"));
			aDersUygulamaPlaniControlLineName.add("Ders Kaynaklari");
			aDersUygulamaPlaniControlLineValue.add(rs.getString("Dersin_amaclari"));
			aDersUygulamaPlaniControlLineName.add("Ders Amaclari");
			aDersUygulamaPlaniControlLineValue.add(rs.getString("Ders_ciktilari"));
			aDersUygulamaPlaniControlLineName.add("Ders Ciktilari");
			aDersUygulamaPlaniControlLineValue.add(rs.getString("Dersler"));
			aDersUygulamaPlaniControlLineName.add("Dersler");
		}
		while (rs1.next()) {
			// aDersUygulamaPlani.add(rs1.getString("Ders_adi"));
			aDersUygulamaPlani.add(rs1.getString("Ders_kodu"));
			aDersUygulamaPlani.add(rs1.getString("Kredi"));
			aDersUygulamaPlani.add(rs1.getString("AKTS"));
			aDersUygulamaPlani.add(rs1.getString("Önkosul"));
			aDersUygulamaPlani.add(rs1.getString("Degerlendirme"));
		}
		// aDersUygulamaPlani.add("Ders adi");
		aDersUygulamaPlani.add("Ders kodu");
		aDersUygulamaPlani.add("Ders Kredi");
		aDersUygulamaPlani.add("AKTS");
		aDersUygulamaPlani.add("OnKosul");
		aDersUygulamaPlani.add("Degerlendirme");

		for (int i = 0; i < 5; i++) {
			if (aDersUygulamaPlani.get(i).equalsIgnoreCase(aDersUygulamaPlani.get(i + 5))) {
				Paragraph paragraph = new Paragraph("sabit - Dokumanda verilen " + aDersUygulamaPlani.get(i + 10)
						+ " kismi dogru olarak girilmistir.");
				doc.add(paragraph);
			} else {
				Paragraph paragraph = new Paragraph("****** sabit - Dokumanda verilen " + aDersUygulamaPlani.get(i + 10)
						+ " kismi Yanlis yada eksik olarak girilmistir Lütfen Konrol ediniz.");
				doc.add(paragraph);
			}
		}

		for (int i = 0; i < aDersUygulamaPlaniControlLineValue.size(); i++) {
			if (aDersUygulamaPlaniControlLineValue.get(i) == null) {
				Paragraph paragraph = new Paragraph("****Dokumanda verilen " + aDersUygulamaPlaniControlLineName.get(i)
						+ " kismi bos birakilmistir. Lütfen Tekran Kontrol ediniz.");
				doc.add(paragraph);
			} else {
				Paragraph paragraph = new Paragraph(
						"Dokumanda verilen " + aDersUygulamaPlaniControlLineName.get(i) + " kisminda veri vardir.");
				doc.add(paragraph);
			}
		}

		doc.close();

	}

}

/*
 * // Creating a table Table table = new Table(3);
 * 
 * // Adding cells to the table
 * 
 * table.addCell(new Cell().add("Ders kodu")); table.addCell(new
 * Cell().add(h.get("Ders kodu"))); if (h.get("Ders kodu").isEmpty()) {
 * table.addCell(new Cell().add("Boş")); } else { table.addCell(new
 * Cell().add("dolu")); }
 * 
 * table.addCell(new Cell().add("Ders adı")); table.addCell(new
 * Cell().add(h.get("Ders adı"))); if (h.get("Ders adı").isEmpty()) {
 * table.addCell(new Cell().add("Boş")); } else { table.addCell(new
 * Cell().add("dolu")); }
 * 
 * table.addCell(new Cell().add("Kredi")); table.addCell(new
 * Cell().add(h.get("Kredi"))); if (h.get("Kredi").isEmpty()) {
 * table.addCell(new Cell().add("Boş")); } else { table.addCell(new
 * Cell().add("dolu")); }
 * 
 * table.addCell(new Cell().add("AKTS")); table.addCell(new
 * Cell().add(h.get("AKTS"))); if (h.get("AKTS").isEmpty()) { table.addCell(new
 * Cell().add("Boş")); } else { table.addCell(new Cell().add("dolu")); }
 * 
 * table.addCell(new Cell().add("Önkoşul")); table.addCell(new
 * Cell().add(h.get("Önkoşul"))); if (h.get("Önkoşul").isEmpty()) {
 * table.addCell(new Cell().add("Boş")); } else { table.addCell(new
 * Cell().add("dolu")); }
 * 
 * table.addCell(new Cell().add("Öğretim elemanı")); table.addCell(new
 * Cell().add(h.get("Öğretim elemanı"))); if
 * (h.get("Öğretim elemanı").isEmpty()) { table.addCell(new Cell().add("Boş"));
 * } else { table.addCell(new Cell().add("dolu")); }
 * 
 * table.addCell(new Cell().add("Eposta")); table.addCell(new
 * Cell().add(h.get("Eposta"))); if (h.get("Eposta").isEmpty()) {
 * table.addCell(new Cell().add("Boş")); } else { table.addCell(new
 * Cell().add("dolu")); }
 * 
 * table.addCell(new Cell().add("Ofis saatleri")); table.addCell(new
 * Cell().add(h.get("Ofis saatleri"))); if (h.get("Ofis saatleri").isEmpty()) {
 * table.addCell(new Cell().add("Boş")); } else { table.addCell(new
 * Cell().add("dolu")); }
 * 
 * table.addCell(new Cell().add("Web")); table.addCell(new
 * Cell().add(h.get("Web"))); if (h.get("Web").isEmpty()) { table.addCell(new
 * Cell().add("Boş")); } else { table.addCell(new Cell().add("dolu")); }
 * 
 * table.addCell(new Cell().add("Açıklama")); table.addCell(new
 * Cell().add(h.get("Açıklama"))); if (h.get("Açıklama").isEmpty()) {
 * table.addCell(new Cell().add("Boş")); } else { table.addCell(new
 * Cell().add("dolu")); }
 * 
 * table.addCell(new Cell().add("Ders kaynakları")); table.addCell(new
 * Cell().add(h.get("Ders kaynakları"))); if
 * (h.get("Ders kaynakları").isEmpty()) { table.addCell(new Cell().add("Boş"));
 * } else { table.addCell(new Cell().add("dolu")); }
 * 
 * table.addCell(new Cell().add("Dersin amaçları")); table.addCell(new
 * Cell().add(h.get("Dersin amaçları"))); if
 * (h.get("Dersin amaçları").isEmpty()) { table.addCell(new Cell().add("Boş"));
 * } else { table.addCell(new Cell().add("dolu")); }
 * 
 * table.addCell(new Cell().add("Ders çıktıları")); table.addCell(new
 * Cell().add(h.get("Ders çıktıları"))); if (h.get("Ders çıktıları").isEmpty())
 * { table.addCell(new Cell().add("Boş")); } else { table.addCell(new
 * Cell().add("dolu")); }
 * 
 * table.addCell(new Cell().add("Dersler")); table.addCell(new
 * Cell().add(h.get("Dersler"))); if (h.get("Dersler").isEmpty()) {
 * table.addCell(new Cell().add("Boş")); } else { table.addCell(new
 * Cell().add("dolu")); }
 * 
 * table.addCell(new Cell().add("Değerlendirme")); table.addCell(new
 * Cell().add(h.get("Değerlendirme"))); if (h.get("Değerlendirme").isEmpty()) {
 * table.addCell(new Cell().add("Boş")); } else { table.addCell(new
 * Cell().add("dolu")); } // Adding Table to document doc.add(table);
 * 
 * doc.add(new Paragraph("Eposta karşılaştırması:" + d.controlDers_Adi + "---" +
 * d.ders_Adi)); doc.add(new Paragraph("Ders adi karşılaştırılması: " +
 * d.controlDers_Adi + "---" + d.ders_Adi)); doc.add(new
 * Paragraph("Ders kodu karşılaştırması: " + d.controlDers_Kodu + "---" +
 * d.ders_Kodu)); doc.add(new Paragraph("Kredi karşılaştırılması: " +
 * d.controlKredi + "---" + d.kredi)); doc.add(new
 * Paragraph("AKTS karşılaştırması:" + d.controlAKTS + "---" + d.AKTS));
 * 
 * doc.close();
 */
