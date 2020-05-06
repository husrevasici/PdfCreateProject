package PdfProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.jdbc.Driver;

import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class DersUygulamaPlani extends JFrame {

	// private JFrame frame;
	private JPanel contentPane;
	private JTable aDersUygulamaPlaniTable;
	private JPanel panel_veritabanigoruntule;
	private JLabel label_anasayfa;
	private JLabel lblDersUygulamaPlan;

	private JLabel label_X;
	private JLabel label_minimize;
	private JScrollPane scrollPane;
	private JPanel panel_edit;
	private JLabel label_derskoduid;
	private JLabel lblDersAd;
	private JLabel lblDersKodu;
	private JLabel lblKredi;
	private JLabel lblAkts;
	private JLabel lblnKoul;
	private JLabel lblretimEleman;
	private JLabel lblEposta;
	private JLabel lblOfisSaatleri;
	private JLabel lblDersSaatleri;
	private JLabel lblWeb;
	private JLabel lblAklama;
	private JLabel lblDersKaynaklar;
	private JLabel lblDersAmalar;
	private JLabel lblDersktlar;
	private JLabel lblDersler;
	private JLabel lblDeerlendirme;
	private JButton button_editkaydet;
	private JTextField textField_derskoduid;
	private JTextField textField_dersadi;
	private JTextField textField_derskodu;
	private JTextField textField_kredi;
	private JTextField textField_akts;
	private JTextField textField_onkosul;
	private JTextField textField_ogretimelemani;
	private JTextField textField_eposta;
	private JTextField textField_ofissaatleri;
	private JTextField textField_derssaatleri;
	private JTextField textField_web;
	private JTextField textField_aciklama;
	private JTextField textField_derskaynaklari;
	private JTextField textField_dersamaclari;
	private JTextField textField_dersciktilari;
	private JTextField textField_dersler;
	private JTextField textField_degerlendirme;
	private JButton btnNewButton;
	private JButton button_delete;
	private JButton btnGrntle;
	private JLabel lblrenciDersDeerlendirme;
	private JLabel lblNotizelgesi;
	private JLabel lblDersTanmlamaFormu;

	/**
	 * Launch the application.
	 */
	static DersUygulamaPlani frame = new DersUygulamaPlani();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DersUygulamaPlani() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1230, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);

		JPanel panel_sabitkisim = new JPanel();
		panel_sabitkisim.setBounds(5, 5, 180, 500);
		panel_sabitkisim.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.ORANGE));
		panel_sabitkisim.setLayout(null);
		panel_sabitkisim.setForeground(Color.WHITE);
		contentPane.add(panel_sabitkisim);

		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(DersUygulamaPlani.class.getResource("/LoginDesing/Resim1.png")));
		label.setBounds(52, 20, 79, 81);
		panel_sabitkisim.add(label);

		label_anasayfa = new JLabel("AnaSayfa");
		label_anasayfa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				Anasayfa a = new Anasayfa();
				a.main(null);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red); // üzerine gelince
																								// kenarları
				label_anasayfa.setBorder(label_border);// kenarlarını ayarlar.
				label_anasayfa.setForeground(Color.red); // üzerinde gelince yazısını ayarlar.
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				label_anasayfa.setBorder(label_border);// kenarlarını ayarlar.
				label_anasayfa.setForeground(Color.black);
			}
		});
		label_anasayfa.setHorizontalAlignment(SwingConstants.CENTER);
		label_anasayfa.setFont(new Font("Arial", Font.BOLD, 11));
		label_anasayfa.setBackground(Color.YELLOW);
		label_anasayfa.setBounds(10, 110, 160, 40);
		panel_sabitkisim.add(label_anasayfa);

		lblDersUygulamaPlan = new JLabel("Ders Uygulama Planı");
		lblDersUygulamaPlan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				main(null);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
				lblDersUygulamaPlan.setBorder(label_border);// kenarlarını ayarlar.
				lblDersUygulamaPlan.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				lblDersUygulamaPlan.setBorder(label_border);// kenarlarını ayarlar.
				lblDersUygulamaPlan.setForeground(Color.black);
			}
		});
		lblDersUygulamaPlan.setHorizontalAlignment(SwingConstants.CENTER);
		lblDersUygulamaPlan.setFont(new Font("Arial", Font.BOLD, 11));
		lblDersUygulamaPlan.setBounds(10, 155, 160, 40);
		panel_sabitkisim.add(lblDersUygulamaPlan);

		lblrenciDersDeerlendirme = new JLabel("Ders Değerlendirme Anketi");
		lblrenciDersDeerlendirme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				SwDersDegerlendirmeAnketi dda = new SwDersDegerlendirmeAnketi();
				dda.main(null);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red); // üzerine gelince
				// kenarları
				lblrenciDersDeerlendirme.setBorder(label_border);// kenarlarını ayarlar.
				lblrenciDersDeerlendirme.setForeground(Color.red); // üzerinde gelince yazısını ayarlar.
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				lblrenciDersDeerlendirme.setBorder(label_border);// kenarlarını ayarlar.
				lblrenciDersDeerlendirme.setForeground(Color.black);
			}
		});
		lblrenciDersDeerlendirme.setHorizontalAlignment(SwingConstants.CENTER);
		lblrenciDersDeerlendirme.setFont(new Font("Arial", Font.BOLD, 11));
		lblrenciDersDeerlendirme.setBounds(10, 200, 160, 40);
		panel_sabitkisim.add(lblrenciDersDeerlendirme);

		lblNotizelgesi = new JLabel("Not Çizelgesi");
		lblNotizelgesi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SwNotCizelgesi notCizelgesi;
				try {
					frame.setVisible(false);
					notCizelgesi = new SwNotCizelgesi();
					notCizelgesi.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red); // üzerine gelince
				// kenarları
				lblNotizelgesi.setBorder(label_border);// kenarlarını ayarlar.
				lblNotizelgesi.setForeground(Color.red); // üzerinde gelince yazısını ayarlar.
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				lblNotizelgesi.setBorder(label_border);// kenarlarını ayarlar.
				lblNotizelgesi.setForeground(Color.black);
			}
		});
		lblNotizelgesi.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotizelgesi.setFont(new Font("Arial", Font.BOLD, 11));
		lblNotizelgesi.setBounds(10, 245, 160, 40);
		panel_sabitkisim.add(lblNotizelgesi);

		lblDersTanmlamaFormu = new JLabel("Ders Tanımlama Formu");
		lblDersTanmlamaFormu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SwDersTanimlamaFormuInterface dersTanimlamaFormu;
				try {
					frame.setVisible(false);
					dersTanimlamaFormu = new SwDersTanimlamaFormuInterface();
					dersTanimlamaFormu.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red); // üzerine gelince
				// kenarları
				lblDersTanmlamaFormu.setBorder(label_border);// kenarlarını ayarlar.
				lblDersTanmlamaFormu.setForeground(Color.red); // üzerinde gelince yazısını ayarlar.
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				lblDersTanmlamaFormu.setBorder(label_border);// kenarlarını ayarlar.
				lblDersTanmlamaFormu.setForeground(Color.black);
			}
		});
		lblDersTanmlamaFormu.setHorizontalAlignment(SwingConstants.CENTER);
		lblDersTanmlamaFormu.setFont(new Font("Arial", Font.BOLD, 11));
		lblDersTanmlamaFormu.setBounds(10, 290, 160, 40);
		panel_sabitkisim.add(lblDersTanmlamaFormu);
		
		
		
		label_minimize = new JLabel("-");
		label_minimize.setBounds(30, 5, 25, 25);
		panel_sabitkisim.add(label_minimize);
		label_minimize.setHorizontalAlignment(SwingConstants.CENTER);
		label_minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
				label_minimize.setBorder(label_border);// kenarlarını ayarlar.
				label_minimize.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				label_minimize.setBorder(label_border);// kenarlarını ayarlar.
				label_minimize.setForeground(Color.black);
			}
		});
		label_minimize.setFont(new Font("Arial", Font.BOLD, 16));

		label_X = new JLabel("X");
		label_X.setBounds(5, 5, 25, 25);
		panel_sabitkisim.add(label_X);
		label_X.setHorizontalAlignment(SwingConstants.CENTER);
		label_X.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
				label_X.setBorder(label_border);// kenarlarını ayarlar.
				label_X.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {

				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				label_X.setBorder(label_border);// kenarlarını ayarlar.
				label_X.setForeground(Color.black);
			}
		});
		label_X.setFont(new Font("Arial", Font.BOLD, 16));
		label_X.setForeground(Color.BLACK);

		panel_edit = new JPanel();
		panel_edit.setBounds(190, 280, 1035, 225);
		panel_edit.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.ORANGE));
		contentPane.add(panel_edit);
		panel_edit.setLayout(null);

		label_derskoduid = new JLabel("Ders Kodu");
		label_derskoduid.setFont(new Font("Arial", Font.BOLD, 12));
		label_derskoduid.setBounds(10, 20, 80, 15);
		panel_edit.add(label_derskoduid);

		lblDersAd = new JLabel("Ders Adı :");
		lblDersAd.setFont(new Font("Arial", Font.BOLD, 12));
		lblDersAd.setBounds(10, 57, 80, 15);
		panel_edit.add(lblDersAd);

		lblDersKodu = new JLabel("Ders Kodu :");
		lblDersKodu.setFont(new Font("Arial", Font.BOLD, 12));
		lblDersKodu.setBounds(10, 94, 80, 20);
		panel_edit.add(lblDersKodu);

		lblKredi = new JLabel("Kredi :");
		lblKredi.setBounds(10, 137, 80, 14);
		panel_edit.add(lblKredi);
		lblKredi.setFont(new Font("Arial", Font.BOLD, 12));

		lblAkts = new JLabel("AKTS :");
		lblAkts.setBounds(10, 178, 80, 15);
		panel_edit.add(lblAkts);
		lblAkts.setFont(new Font("Arial", Font.BOLD, 12));

		lblnKoul = new JLabel("Ön Koşul :");
		lblnKoul.setBounds(240, 20, 85, 14);
		panel_edit.add(lblnKoul);
		lblnKoul.setFont(new Font("Arial", Font.BOLD, 12));

		lblretimEleman = new JLabel("Öğretim Elemanı :");
		lblretimEleman.setBounds(240, 58, 110, 14);
		panel_edit.add(lblretimEleman);
		lblretimEleman.setFont(new Font("Arial", Font.BOLD, 12));

		lblEposta = new JLabel("E-Posta :");
		lblEposta.setBounds(240, 97, 85, 14);
		panel_edit.add(lblEposta);
		lblEposta.setFont(new Font("Arial", Font.BOLD, 12));

		lblOfisSaatleri = new JLabel("Ofis Saatleri :");
		lblOfisSaatleri.setBounds(240, 134, 89, 14);
		panel_edit.add(lblOfisSaatleri);
		lblOfisSaatleri.setFont(new Font("Arial", Font.BOLD, 12));

		lblDersSaatleri = new JLabel("Ders Saatleri :");
		lblDersSaatleri.setBounds(236, 178, 89, 14);
		panel_edit.add(lblDersSaatleri);
		lblDersSaatleri.setFont(new Font("Arial", Font.BOLD, 12));

		lblWeb = new JLabel("Web :");
		lblWeb.setBounds(512, 20, 46, 14);
		panel_edit.add(lblWeb);
		lblWeb.setFont(new Font("Arial", Font.BOLD, 12));

		lblAklama = new JLabel("Açıklama :");
		lblAklama.setBounds(512, 58, 89, 14);
		panel_edit.add(lblAklama);
		lblAklama.setFont(new Font("Arial", Font.BOLD, 12));

		lblDersKaynaklar = new JLabel("Ders Kaynakları :");
		lblDersKaynaklar.setBounds(512, 97, 116, 14);
		panel_edit.add(lblDersKaynaklar);
		lblDersKaynaklar.setFont(new Font("Arial", Font.BOLD, 12));

		lblDersAmalar = new JLabel("Ders Amaçları :");
		lblDersAmalar.setBounds(512, 137, 89, 14);
		panel_edit.add(lblDersAmalar);
		lblDersAmalar.setFont(new Font("Arial", Font.BOLD, 12));

		lblDersktlar = new JLabel("Ders Çıktıları :");
		lblDersktlar.setBounds(512, 178, 99, 14);
		panel_edit.add(lblDersktlar);
		lblDersktlar.setFont(new Font("Arial", Font.BOLD, 12));

		lblDersler = new JLabel("Dersler :");
		lblDersler.setBounds(777, 20, 89, 14);
		panel_edit.add(lblDersler);
		lblDersler.setFont(new Font("Arial", Font.BOLD, 12));

		lblDeerlendirme = new JLabel("Değerlendirme :");
		lblDeerlendirme.setBounds(777, 57, 99, 14);
		panel_edit.add(lblDeerlendirme);
		lblDeerlendirme.setFont(new Font("Arial", Font.BOLD, 12));

		button_editkaydet = new JButton("Kaydet");
		button_editkaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q = "INSERT INTO `a_ders_uygulama_plani1`" + "(`id`,`Ders_adi`, `Ders_kodu`, `Kredi`, `AKTS`, "
						+ "`Önkosul`, `Ögretim_elemani`, `Eposta`, `Ofis_saatleri`,"
						+ " `Ders_saatleri`, `Web`, `Aciklama`, `Ders_kaynaklari`, "
						+ "`Dersin_amaclari`, `Ders_ciktilari`, `Dersler`, `Degerlendirme`) VALUES "
						+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

				DatabaseConnection db = new DatabaseConnection();
				PreparedStatement ps = null;
				try {
					ps = (PreparedStatement) db.veritabaninaBaglan().prepareStatement(q);
					ps.setInt(1, Integer.valueOf(textField_derskoduid.getText()));
					ps.setString(2, textField_dersadi.getText());
					ps.setString(3, textField_derskodu.getText());
					ps.setString(4, textField_kredi.getText());
					ps.setString(5, textField_akts.getText());
					ps.setString(6, textField_onkosul.getText());
					ps.setString(7, textField_ogretimelemani.getText());
					ps.setString(8, textField_eposta.getText());
					ps.setString(9, textField_ofissaatleri.getText());
					ps.setString(10, textField_derssaatleri.getText());
					ps.setString(11, textField_web.getText());
					ps.setString(12, textField_aciklama.getText());
					ps.setString(13, textField_derskaynaklari.getText());
					ps.setString(14, textField_dersamaclari.getText());
					ps.setString(15, textField_dersciktilari.getText());
					ps.setString(16, textField_dersler.getText());
					ps.setString(17, textField_degerlendirme.getText());
					if (ps.executeUpdate() != 0) {
						JOptionPane.showMessageDialog(null, "Değişiklik yapılmıştır.");
					} else {
						JOptionPane.showMessageDialog(null, "Error: Check Your Information");
					}
					DefaultTableModel model = (DefaultTableModel) aDersUygulamaPlaniTable.getModel();
					model.setRowCount(0);
					aDersPlaniUygulamaSwingInterfaceTableShow();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button_editkaydet.setBounds(788, 134, 89, 23);
		panel_edit.add(button_editkaydet);

		textField_derskoduid = new JTextField();
		textField_derskoduid.setBounds(82, 10, 140, 30);
		panel_edit.add(textField_derskoduid);
		textField_derskoduid.setColumns(10);

		textField_dersadi = new JTextField();
		textField_dersadi.setColumns(10);
		textField_dersadi.setBounds(82, 50, 140, 30);
		panel_edit.add(textField_dersadi);

		textField_derskodu = new JTextField();
		textField_derskodu.setColumns(10);
		textField_derskodu.setBounds(82, 90, 140, 30);
		panel_edit.add(textField_derskodu);

		textField_kredi = new JTextField();
		textField_kredi.setColumns(10);
		textField_kredi.setBounds(82, 130, 140, 30);
		panel_edit.add(textField_kredi);

		textField_akts = new JTextField();
		textField_akts.setColumns(10);
		textField_akts.setBounds(82, 170, 140, 30);
		panel_edit.add(textField_akts);

		textField_onkosul = new JTextField();
		textField_onkosul.setColumns(10);
		textField_onkosul.setBounds(350, 10, 140, 30);
		panel_edit.add(textField_onkosul);

		textField_ogretimelemani = new JTextField();
		textField_ogretimelemani.setColumns(10);
		textField_ogretimelemani.setBounds(350, 50, 140, 30);
		panel_edit.add(textField_ogretimelemani);

		textField_eposta = new JTextField();
		textField_eposta.setColumns(10);
		textField_eposta.setBounds(350, 90, 140, 30);
		panel_edit.add(textField_eposta);

		textField_ofissaatleri = new JTextField();
		textField_ofissaatleri.setColumns(10);
		textField_ofissaatleri.setBounds(350, 130, 140, 30);
		panel_edit.add(textField_ofissaatleri);

		textField_derssaatleri = new JTextField();
		textField_derssaatleri.setColumns(10);
		textField_derssaatleri.setBounds(350, 170, 140, 30);
		panel_edit.add(textField_derssaatleri);

		textField_web = new JTextField();
		textField_web.setColumns(10);
		textField_web.setBounds(615, 10, 140, 30);
		panel_edit.add(textField_web);

		textField_aciklama = new JTextField();
		textField_aciklama.setColumns(10);
		textField_aciklama.setBounds(615, 50, 140, 30);
		panel_edit.add(textField_aciklama);

		textField_derskaynaklari = new JTextField();
		textField_derskaynaklari.setColumns(10);
		textField_derskaynaklari.setBounds(615, 90, 140, 30);
		panel_edit.add(textField_derskaynaklari);

		textField_dersamaclari = new JTextField();
		textField_dersamaclari.setColumns(10);
		textField_dersamaclari.setBounds(615, 130, 140, 30);
		panel_edit.add(textField_dersamaclari);

		textField_dersciktilari = new JTextField();
		textField_dersciktilari.setColumns(10);
		textField_dersciktilari.setBounds(615, 170, 140, 30);
		panel_edit.add(textField_dersciktilari);

		textField_dersler = new JTextField();
		textField_dersler.setColumns(10);
		textField_dersler.setBounds(875, 13, 140, 30);
		panel_edit.add(textField_dersler);

		textField_degerlendirme = new JTextField();
		textField_degerlendirme.setColumns(10);
		textField_degerlendirme.setBounds(875, 50, 140, 30);
		panel_edit.add(textField_degerlendirme);

		btnNewButton = new JButton("Güncelle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int row = aDersUygulamaPlaniTable.getSelectedRow();
				String value = (aDersUygulamaPlaniTable.getModel().getValueAt(row, 0).toString());
				String q = "UPDATE a_ders_uygulama_plani1 SET Ders_adi=?, Ders_kodu=?, Kredi=?, AKTS=?, "
						+ "Önkosul=?, Ögretim_elemani=?,Eposta=?, Ofis_saatleri=?,"
						+ " Ders_saatleri=?, Web=?, Aciklama=?, Ders_kaynaklari=?, "
						+ "Dersin_amaclari=?, Ders_ciktilari=?, Dersler=?, Degerlendirme=? where id=" + value;
				DatabaseConnection db = new DatabaseConnection();
				PreparedStatement ps = null;

				try {
					ps = (PreparedStatement) db.veritabaninaBaglan().prepareStatement(q);
//					ps.setInt(17, Integer.valueOf(value));
					ps.setString(1, textField_dersadi.getText());
					ps.setString(2, textField_derskodu.getText());
					ps.setString(3, textField_kredi.getText());
					ps.setString(4, textField_akts.getText());
					ps.setString(5, textField_onkosul.getText());
					ps.setString(6, textField_ogretimelemani.getText());
					ps.setString(7, textField_eposta.getText());
					ps.setString(8, textField_ofissaatleri.getText());
					ps.setString(9, textField_derssaatleri.getText());
					ps.setString(10, textField_web.getText());
					ps.setString(11, textField_aciklama.getText());
					ps.setString(12, textField_derskaynaklari.getText());
					ps.setString(13, textField_dersamaclari.getText());
					ps.setString(14, textField_dersciktilari.getText());
					ps.setString(15, textField_dersler.getText());
					ps.setString(16, textField_degerlendirme.getText());
					//
					ps.executeUpdate();
					DefaultTableModel model = (DefaultTableModel) aDersUygulamaPlaniTable.getModel();
					model.setRowCount(0);
					aDersPlaniUygulamaSwingInterfaceTableShow();

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(901, 134, 99, 23);
		panel_edit.add(btnNewButton);

		button_delete = new JButton("Sil");
		button_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int row = aDersUygulamaPlaniTable.getSelectedRow();
				String value = (aDersUygulamaPlaniTable.getModel().getValueAt(row, 0).toString());
				String q = "DELETE FROM a_ders_uygulama_plani1  where id=" + value;
				DatabaseConnection db = new DatabaseConnection();
				PreparedStatement ps = null;
				try {
					ps = (PreparedStatement) db.veritabaninaBaglan().prepareStatement(q);

					ps.executeUpdate();
					DefaultTableModel model = (DefaultTableModel) aDersUygulamaPlaniTable.getModel();
					model.setRowCount(0);
					aDersPlaniUygulamaSwingInterfaceTableShow();

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				}
			}
		});
		button_delete.setBounds(787, 175, 89, 23);
		panel_edit.add(button_delete);

		btnGrntle = new JButton("Görüntüle");
		btnGrntle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					aDersPlaniUygulamaSwingInterfaceTableShow();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGrntle.setBounds(901, 175, 89, 23);
		panel_edit.add(btnGrntle);

		panel_veritabanigoruntule = new JPanel();
		panel_veritabanigoruntule.setBounds(190, 5, 1035, 269);
		contentPane.add(panel_veritabanigoruntule);
		panel_veritabanigoruntule.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.ORANGE));
		panel_veritabanigoruntule.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int i = aDersUygulamaPlaniTable.getSelectedRow();
				TableModel model = aDersUygulamaPlaniTable.getModel();
				textField_derskoduid.setText("" + model.getValueAt(i, 0).toString());
				textField_dersadi.setText(" " + model.getValueAt(i, 1).toString());
				textField_derskodu.setText("" + model.getValueAt(i, 2).toString());
				textField_kredi.setText("" + model.getValueAt(i, 3).toString());
				textField_akts.setText("" + model.getValueAt(i, 4).toString());
				textField_onkosul.setText("" + model.getValueAt(i, 5).toString());
				textField_ogretimelemani.setText("" + model.getValueAt(i, 6).toString());
				textField_eposta.setText("" + model.getValueAt(i, 7).toString());
				textField_ofissaatleri.setText("" + model.getValueAt(i, 8).toString());
				textField_derssaatleri.setText(" " + model.getValueAt(i, 9).toString());
				textField_web.setText("" + model.getValueAt(i, 10).toString());
				textField_aciklama.setText("" + model.getValueAt(i, 11).toString());
				textField_derskaynaklari.setText("" + model.getValueAt(i, 12).toString());
				textField_dersamaclari.setText("" + model.getValueAt(i, 13).toString());
				textField_dersciktilari.setText("" + model.getValueAt(i, 14).toString());
				textField_dersler.setText("" + model.getValueAt(i, 15).toString());
				textField_degerlendirme.setText("" + model.getValueAt(i, 16).toString());

			}
		});
		scrollPane.setBounds(10, 11, 1015, 247);
		panel_veritabanigoruntule.add(scrollPane);
		aDersUygulamaPlaniTable = new JTable();
		scrollPane.setViewportView(aDersUygulamaPlaniTable);
		aDersUygulamaPlaniTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Ders Koduid", "Ders Adi", "Ders Kodu", "Kredi", "AKTS", "ogretim elemani", "on kosul",
						"E-Posta", "Ofis Saatleri", "Ders Saatleri", "Web", "aciklama", "Ders Kaynaklari",
						"Ders amaclari", "Ders ciktilari", "Dersler", "Degerlendirme" }));

		setLocationRelativeTo(null);
	}

	public ArrayList<dersUygulamaPlaniItems> dersUygulamaPlaniItemsList() throws Exception {
		ArrayList<dersUygulamaPlaniItems> dersUygulamaPlaniItemsList = new ArrayList();
		DatabaseConnection d = new DatabaseConnection();
		Connection connection = d.veritabaninaBaglan();
		String q = "select*from a_ders_uygulama_plani1";
		PreparedStatement ps = d.veritabaninaBaglan().prepareStatement(q);

		ResultSet rs = ps.executeQuery();

		dersUygulamaPlaniItems dersUygulamaPlaniItemsClassObject;
		while (rs.next()) {
			dersUygulamaPlaniItemsClassObject = new dersUygulamaPlaniItems(rs.getInt("id"), rs.getString("Ders_adi"),
					rs.getString("Ders_kodu"), rs.getString("Kredi"), rs.getString("AKTS"), rs.getString("Önkosul"),
					rs.getString("Ögretim_elemani"), rs.getString("Eposta"), rs.getString("Ofis_saatleri"),
					rs.getString("Ders_saatleri"), rs.getString("Web"), rs.getString("Aciklama"),
					rs.getString("Ders_kaynaklari"), rs.getString("Dersin_amaclari"), rs.getString("Ders_ciktilari"),
					rs.getString("Dersler"), rs.getString("Degerlendirme"));
			System.out.println("veritabanindan degerleri aldi.");
			dersUygulamaPlaniItemsList.add(dersUygulamaPlaniItemsClassObject);
		}

		return dersUygulamaPlaniItemsList;

	}

	public void aDersPlaniUygulamaSwingInterfaceTableShow() throws Exception {
		ArrayList<dersUygulamaPlaniItems> list = dersUygulamaPlaniItemsList();
		DefaultTableModel model = (DefaultTableModel) aDersUygulamaPlaniTable.getModel();
		model.setRowCount(0);
		Object row[] = new Object[17];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getId();
			row[1] = list.get(i).getDersAdi();
			row[2] = list.get(i).getDersKodu();
			row[3] = list.get(i).getKredi();
			row[4] = list.get(i).getAKTS();

			row[5] = list.get(i).getOnKosul();
			row[6] = list.get(i).getOgretimElamani();
			row[7] = list.get(i).getePosta();
			row[8] = list.get(i).getOfisSaatleri();
			row[9] = list.get(i).getDersSaatleri();

			row[10] = list.get(i).getWeb();
			row[11] = list.get(i).getAciklama();
			row[12] = list.get(i).getDersKaynaklari();
			row[13] = list.get(i).getDersinAmaclari();
			row[14] = list.get(i).getDersCiktilari();

			row[15] = list.get(i).getDersler();
			row[16] = list.get(i).getDegerlendirme();
			model.addRow(row);

		}
		aDersUygulamaPlaniTable.setModel(model);

	}
}
