package PdfProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class SwDersTanimlamaFormuInterface extends JFrame {

	// private JFrame frame;
	private JPanel contentPane;
	private JTable dersTanimlamaFormuTable;
	private JPanel panel_veritabanigoruntule;
	private JLabel label_anasayfa;
	private JLabel lblDersUygulamaPlan;

	private JLabel label_X;
	private JLabel label_minimize;
	private JScrollPane scrollPane;
	private JPanel panel_edit;

	private JLabel lblId;
	private JLabel lblDersinKoduveAdi;
	private JLabel lblDersinyariyili;
	private JLabel lblDersinIcerigi;
	private JLabel lblDersKitabi;
	private JLabel lblnYardimciDersKitaplari;
	private JLabel lblDersinKredisi;
	private JLabel lblDersinOnkosullari;
	private JLabel lblDersinTuru;
	private JLabel lblOgretimDili;
	private JLabel lblDersinAmaclari;
	private JLabel lblDersinOgrenimCiktilari;
	private JLabel lblDersinVerilisBicimi;
	private JLabel lblDersinHaftalikDagilimi;

	private JLabel lblEgitimveOgretimFaliyetleri;

	private JButton button_editkaydet;

	private JTextArea textArea_id;
	private JTextArea textArea_DersinKoduveAdi;
	private JTextArea textArea_Dersinyariyili;
	private JTextArea textArea_DersinIcerigi;
	private JTextArea textArea_DersKitabi;
	private JTextArea textArea_YardimciDersKitaplari;
	private JTextArea textArea_DersinKredisi;
	private JTextArea textArea_DersinOnkosullari;
	private JTextArea textArea_DersinTuru;
	private JTextArea textArea_OgretimDili;
	private JTextArea textArea_DersinAmaclari;
	private JTextArea textArea_DersinOgrenimCiktilari;
	private JTextArea textArea_DersinVerilisBicimi;
	private JTextArea textArea_DersinHaftalikDagilimi;

	private JTextArea textArea_EgitimveOgretimFaliyetleri;
	private JButton btnNewButton;
	private JButton button_delete;
	private JButton btnGrntle;
	private JLabel lblrenciDersDeerlendirme;
	private JLabel lblNotizelgesi;
	private JLabel lblDersTanmlamaFormu;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane_4;
	private JScrollPane scrollPane_5;
	private JScrollPane scrollPane_6;
	private JScrollPane scrollPane_7;
	private JScrollPane scrollPane_8;
	private JScrollPane scrollPane_9;
	private JScrollPane scrollPane_10;
	private JScrollPane scrollPane_11;
	private JScrollPane scrollPane_12;
	private JScrollPane scrollPane_13;
	private JScrollPane scrollPane_14;
	private JScrollPane scrollPane_15;
	private JLabel lblcikis;
	private static SwDersTanimlamaFormuInterface frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SwDersTanimlamaFormuInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SwDersTanimlamaFormuInterface() {
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
				DersUygulamaPlani dersUygulama;
				try {
					frame.setVisible(false);
					dersUygulama = new DersUygulamaPlani();
					dersUygulama.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

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

		lblcikis = new JLabel("Çıkış");
		lblcikis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminPanel adminpanel;
				try {
					frame.setVisible(false);
					adminpanel = new AdminPanel();
					adminpanel.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red); // üzerine gelince
				// kenarları
				lblcikis.setBorder(label_border);// kenarlarını ayarlar.
				lblcikis.setForeground(Color.red); // üzerinde gelince yazısını ayarlar.
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				lblcikis.setBorder(label_border);// kenarlarını ayarlar.
				lblcikis.setForeground(Color.black);
			}
		});
		lblcikis.setHorizontalAlignment(SwingConstants.CENTER);
		lblcikis.setFont(new Font("Arial", Font.BOLD, 11));
		lblcikis.setBounds(10, 335, 160, 40);
		panel_sabitkisim.add(lblcikis);

		panel_edit = new JPanel();
		panel_edit.setBounds(190, 280, 1035, 225);
		panel_edit.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.ORANGE));
		contentPane.add(panel_edit);
		panel_edit.setLayout(null);

		lblId = new JLabel("Ders Kodu");
		lblId.setFont(new Font("Arial", Font.BOLD, 12));
		lblId.setBounds(69, 20, 80, 15);
		panel_edit.add(lblId);

		lblDersinKoduveAdi = new JLabel("Dersin Kodu ve Adi");
		lblDersinKoduveAdi.setFont(new Font("Arial", Font.BOLD, 12));
		lblDersinKoduveAdi.setBounds(20, 57, 129, 15);
		panel_edit.add(lblDersinKoduveAdi);

		lblDersinyariyili = new JLabel("Dersin Yarıyılı");
		lblDersinyariyili.setFont(new Font("Arial", Font.BOLD, 12));
		lblDersinyariyili.setBounds(53, 94, 80, 20);
		panel_edit.add(lblDersinyariyili);

		lblDersinIcerigi = new JLabel("Dersin İçeriği");
		lblDersinIcerigi.setBounds(53, 137, 80, 14);
		panel_edit.add(lblDersinIcerigi);
		lblDersinIcerigi.setFont(new Font("Arial", Font.BOLD, 12));

		lblDersKitabi = new JLabel("Ders Kitabı");
		lblDersKitabi.setBounds(69, 178, 80, 15);
		panel_edit.add(lblDersKitabi);
		lblDersKitabi.setFont(new Font("Arial", Font.BOLD, 12));

		lblnYardimciDersKitaplari = new JLabel("Yardımcı Ders Kitapları");
		lblnYardimciDersKitaplari.setBounds(293, 20, 145, 14);
		panel_edit.add(lblnYardimciDersKitaplari);
		lblnYardimciDersKitaplari.setFont(new Font("Arial", Font.BOLD, 12));

		lblDersinKredisi = new JLabel("Dersin Kredisi");
		lblDersinKredisi.setBounds(328, 57, 110, 14);
		panel_edit.add(lblDersinKredisi);
		lblDersinKredisi.setFont(new Font("Arial", Font.BOLD, 12));

		lblDersinOnkosullari = new JLabel("Dersin Önkoşulları");
		lblDersinOnkosullari.setBounds(317, 97, 110, 14);
		panel_edit.add(lblDersinOnkosullari);
		lblDersinOnkosullari.setFont(new Font("Arial", Font.BOLD, 12));

		lblDersinTuru = new JLabel("Dersin Türü");
		lblDersinTuru.setBounds(349, 137, 89, 14);
		panel_edit.add(lblDersinTuru);
		lblDersinTuru.setFont(new Font("Arial", Font.BOLD, 12));

		lblOgretimDili = new JLabel("Öğretim Dili");
		lblOgretimDili.setBounds(349, 178, 89, 14);
		panel_edit.add(lblOgretimDili);
		lblOgretimDili.setFont(new Font("Arial", Font.BOLD, 12));

		lblDersinAmaclari = new JLabel("Dersin Amaçları");
		lblDersinAmaclari.setBounds(656, 20, 99, 14);
		panel_edit.add(lblDersinAmaclari);
		lblDersinAmaclari.setFont(new Font("Arial", Font.BOLD, 12));

		lblDersinOgrenimCiktilari = new JLabel("Dersin Öğrenim Çıktıları");
		lblDersinOgrenimCiktilari.setBounds(610, 57, 145, 14);
		panel_edit.add(lblDersinOgrenimCiktilari);
		lblDersinOgrenimCiktilari.setFont(new Font("Arial", Font.BOLD, 12));

		lblDersinVerilisBicimi = new JLabel("Dersin Veriliş Biçimi");
		lblDersinVerilisBicimi.setBounds(628, 97, 116, 14);
		panel_edit.add(lblDersinVerilisBicimi);
		lblDersinVerilisBicimi.setFont(new Font("Arial", Font.BOLD, 12));

		lblDersinHaftalikDagilimi = new JLabel("Dersin Haftalik Dağılımı");
		lblDersinHaftalikDagilimi.setBounds(610, 137, 145, 14);
		panel_edit.add(lblDersinHaftalikDagilimi);
		lblDersinHaftalikDagilimi.setFont(new Font("Arial", Font.BOLD, 12));

		lblEgitimveOgretimFaliyetleri = new JLabel("Ders Çıktıları :");
		lblEgitimveOgretimFaliyetleri.setBounds(656, 178, 99, 14);
		panel_edit.add(lblEgitimveOgretimFaliyetleri);
		lblEgitimveOgretimFaliyetleri.setFont(new Font("Arial", Font.BOLD, 12));

		button_editkaydet = new JButton("Kaydet");
		button_editkaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q = "INSERT INTO `ders_tanimlama_formu`"
						+ "(`id`,`DersinKoduveAdi`, `DersinYariyili`, `Dersinİcerigi`, `DersKitabi`, "
						+ "`YardimciDersKitaplari`, `DersinKredisi`, `DersinOnkosullari`, `DersinTuru`,"
						+ " `OgretimDili`, `DersinAmaclari`, `DersinOgrenimCiktilari`, `DersinVerilisBicimi`, "
						+ "`DersinHaftalıkDagilimi`, `EgitimveOgretimFaaliyetleri`) VALUES "
						+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

				DatabaseConnection db = new DatabaseConnection();
				PreparedStatement ps = null;
				try {
					ps = (PreparedStatement) db.veritabaninaBaglan().prepareStatement(q);
					ps.setInt(1, Integer.valueOf(textArea_id.getText()));
					ps.setString(2, textArea_DersinKoduveAdi.getText());
					ps.setString(3, textArea_Dersinyariyili.getText());
					ps.setString(4, textArea_DersinIcerigi.getText());
					ps.setString(5, textArea_DersKitabi.getText());
					ps.setString(6, textArea_YardimciDersKitaplari.getText());
					ps.setString(7, textArea_DersinKredisi.getText());
					ps.setString(8, textArea_DersinOnkosullari.getText());
					ps.setString(9, textArea_DersinTuru.getText());
					ps.setString(10, textArea_OgretimDili.getText());
					ps.setString(11, textArea_DersinAmaclari.getText());
					ps.setString(12, textArea_DersinOgrenimCiktilari.getText());
					ps.setString(13, textArea_DersinVerilisBicimi.getText());
					ps.setString(14, textArea_DersinHaftalikDagilimi.getText());
					ps.setString(15, textArea_EgitimveOgretimFaliyetleri.getText());

					if (ps.executeUpdate() != 0) {
						JOptionPane.showMessageDialog(null, "Değişiklik yapılmıştır.");
					} else {
						JOptionPane.showMessageDialog(null, "Error: Check Your Information");
					}
					DefaultTableModel model = (DefaultTableModel) dersTanimlamaFormuTable.getModel();
					model.setRowCount(0);
					DersTanimlamaFormuTableShow();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// dersTanimlamaFormuTable
					e1.printStackTrace();
				}

			}
		});
		button_editkaydet.setBounds(926, 119, 99, 23);
		panel_edit.add(button_editkaydet);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(143, 15, 140, 30);
		panel_edit.add(scrollPane_1);

		textArea_id = new JTextArea();
		scrollPane_1.setViewportView(textArea_id);
		textArea_id.setColumns(10);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(143, 52, 140, 30);
		panel_edit.add(scrollPane_2);

		textArea_DersinKoduveAdi = new JTextArea();
		scrollPane_2.setViewportView(textArea_DersinKoduveAdi);
		textArea_DersinKoduveAdi.setColumns(10);

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(143, 92, 140, 30);
		panel_edit.add(scrollPane_3);

		textArea_Dersinyariyili = new JTextArea();
		scrollPane_3.setViewportView(textArea_Dersinyariyili);
		textArea_Dersinyariyili.setColumns(10);

		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(143, 132, 140, 30);
		panel_edit.add(scrollPane_4);

		textArea_DersinIcerigi = new JTextArea();
		scrollPane_4.setViewportView(textArea_DersinIcerigi);
		textArea_DersinIcerigi.setColumns(10);

		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(143, 173, 140, 30);
		panel_edit.add(scrollPane_5);

		textArea_DersKitabi = new JTextArea();
		scrollPane_5.setViewportView(textArea_DersKitabi);
		textArea_DersKitabi.setColumns(10);

		scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(437, 15, 140, 30);
		panel_edit.add(scrollPane_6);

		textArea_YardimciDersKitaplari = new JTextArea();
		scrollPane_6.setViewportView(textArea_YardimciDersKitaplari);
		textArea_YardimciDersKitaplari.setColumns(10);

		scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(437, 52, 140, 30);
		panel_edit.add(scrollPane_7);

		textArea_DersinKredisi = new JTextArea();
		scrollPane_7.setViewportView(textArea_DersinKredisi);
		textArea_DersinKredisi.setColumns(10);

		scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(437, 92, 140, 30);
		panel_edit.add(scrollPane_8);

		textArea_DersinOnkosullari = new JTextArea();
		scrollPane_8.setViewportView(textArea_DersinOnkosullari);
		textArea_DersinOnkosullari.setColumns(10);

		scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(437, 132, 140, 30);
		panel_edit.add(scrollPane_9);

		textArea_DersinTuru = new JTextArea();
		scrollPane_9.setViewportView(textArea_DersinTuru);
		textArea_DersinTuru.setColumns(10);

		scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(437, 173, 140, 30);
		panel_edit.add(scrollPane_10);

		textArea_OgretimDili = new JTextArea();
		scrollPane_10.setViewportView(textArea_OgretimDili);
		textArea_OgretimDili.setColumns(10);

		scrollPane_11 = new JScrollPane();
		scrollPane_11.setBounds(754, 15, 140, 30);
		panel_edit.add(scrollPane_11);

		textArea_DersinAmaclari = new JTextArea();
		scrollPane_11.setViewportView(textArea_DersinAmaclari);
		textArea_DersinAmaclari.setColumns(10);

		scrollPane_12 = new JScrollPane();
		scrollPane_12.setBounds(754, 52, 140, 30);
		panel_edit.add(scrollPane_12);

		textArea_DersinOgrenimCiktilari = new JTextArea();
		scrollPane_12.setViewportView(textArea_DersinOgrenimCiktilari);
		textArea_DersinOgrenimCiktilari.setColumns(10);

		scrollPane_13 = new JScrollPane();
		scrollPane_13.setBounds(754, 92, 140, 30);
		panel_edit.add(scrollPane_13);

		textArea_DersinVerilisBicimi = new JTextArea();
		scrollPane_13.setViewportView(textArea_DersinVerilisBicimi);
		textArea_DersinVerilisBicimi.setColumns(10);

		scrollPane_14 = new JScrollPane();
		scrollPane_14.setBounds(754, 132, 140, 30);
		panel_edit.add(scrollPane_14);

		textArea_DersinHaftalikDagilimi = new JTextArea();
		scrollPane_14.setViewportView(textArea_DersinHaftalikDagilimi);
		textArea_DersinHaftalikDagilimi.setColumns(10);

		scrollPane_15 = new JScrollPane();
		scrollPane_15.setBounds(754, 173, 140, 30);
		panel_edit.add(scrollPane_15);

		textArea_EgitimveOgretimFaliyetleri = new JTextArea();
		scrollPane_15.setViewportView(textArea_EgitimveOgretimFaliyetleri);
		textArea_EgitimveOgretimFaliyetleri.setColumns(10);

		btnNewButton = new JButton("Güncelle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int row = dersTanimlamaFormuTable.getSelectedRow();
				String value = (dersTanimlamaFormuTable.getModel().getValueAt(row, 0).toString());
				String q = "UPDATE ders_tanimlama_formu SET DersinKoduveAdi=?, DersinYariyili=?, Dersinİcerigi=?, DersKitabi=?, "
						+ "YardimciDersKitaplari=?, DersinKredisi=?,DersinOnkosullari=?, DersinTuru=?,"
						+ " OgretimDili=?, DersinAmaclari=?, DersinOgrenimCiktilari=?, DersinVerilisBicimi=?, "
						+ "DersinHaftalıkDagilimi=?, EgitimveOgretimFaaliyetleri=? where id=" + value;

				DatabaseConnection db = new DatabaseConnection();
				PreparedStatement ps = null;

				try {
					ps = (PreparedStatement) db.veritabaninaBaglan().prepareStatement(q);
//					ps.setInt(17, Integer.valueOf(value));
					ps.setString(1, textArea_DersinKoduveAdi.getText());
					ps.setString(2, textArea_Dersinyariyili.getText());
					ps.setString(3, textArea_DersinIcerigi.getText());
					ps.setString(4, textArea_DersKitabi.getText());
					ps.setString(5, textArea_YardimciDersKitaplari.getText());
					ps.setString(6, textArea_DersinKredisi.getText());
					ps.setString(7, textArea_DersinOnkosullari.getText());
					ps.setString(8, textArea_DersinTuru.getText());
					ps.setString(9, textArea_OgretimDili.getText());
					ps.setString(10, textArea_DersinAmaclari.getText());
					ps.setString(11, textArea_DersinOgrenimCiktilari.getText());
					ps.setString(12, textArea_DersinVerilisBicimi.getText());
					ps.setString(13, textArea_DersinHaftalikDagilimi.getText());
					ps.setString(14, textArea_EgitimveOgretimFaliyetleri.getText());

					//
					ps.executeUpdate();
					DefaultTableModel model = (DefaultTableModel) dersTanimlamaFormuTable.getModel();
					model.setRowCount(0);
					DersTanimlamaFormuTableShow();

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(926, 153, 99, 23);
		panel_edit.add(btnNewButton);

		button_delete = new JButton("Sil");
		button_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int row = dersTanimlamaFormuTable.getSelectedRow();
				String value = (dersTanimlamaFormuTable.getModel().getValueAt(row, 0).toString());
				String q = "DELETE FROM ders_tanimlama_formu  where id=" + value;
				DatabaseConnection db = new DatabaseConnection();
				PreparedStatement ps = null;
				try {
					ps = (PreparedStatement) db.veritabaninaBaglan().prepareStatement(q);

					ps.executeUpdate();
					DefaultTableModel model = (DefaultTableModel) dersTanimlamaFormuTable.getModel();
					model.setRowCount(0);
					DersTanimlamaFormuTableShow();

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				}
			}
		});
		button_delete.setBounds(926, 191, 99, 23);
		panel_edit.add(button_delete);

		btnGrntle = new JButton("Görüntüle");
		btnGrntle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DersTanimlamaFormuTableShow();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGrntle.setBounds(926, 85, 99, 23);
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

				int i = dersTanimlamaFormuTable.getSelectedRow();
				TableModel model = dersTanimlamaFormuTable.getModel();
				textArea_id.setText("" + model.getValueAt(i, 0).toString());
				textArea_DersinKoduveAdi.setText("" + model.getValueAt(i, 1).toString());
				textArea_Dersinyariyili.setText("" + model.getValueAt(i, 2).toString());
				textArea_DersinIcerigi.setText("" + model.getValueAt(i, 3).toString());
				textArea_DersKitabi.setText("" + model.getValueAt(i, 4).toString());
				textArea_YardimciDersKitaplari.setText("" + model.getValueAt(i, 5).toString());
				textArea_DersinKredisi.setText("" + model.getValueAt(i, 6).toString());
				textArea_DersinOnkosullari.setText("" + model.getValueAt(i, 7).toString());
				textArea_DersinTuru.setText("" + model.getValueAt(i, 8).toString());
				textArea_OgretimDili.setText(" " + model.getValueAt(i, 9).toString());
				textArea_DersinAmaclari.setText("" + model.getValueAt(i, 10).toString());
				textArea_DersinOgrenimCiktilari.setText("" + model.getValueAt(i, 11).toString());
				textArea_DersinVerilisBicimi.setText("" + model.getValueAt(i, 12).toString());
				textArea_DersinHaftalikDagilimi.setText("" + model.getValueAt(i, 13).toString());
				textArea_EgitimveOgretimFaliyetleri.setText("" + model.getValueAt(i, 14).toString());

			}
		});
		scrollPane.setBounds(10, 11, 1015, 247);
		panel_veritabanigoruntule.add(scrollPane);
		dersTanimlamaFormuTable = new JTable();
		scrollPane.setViewportView(dersTanimlamaFormuTable);
		dersTanimlamaFormuTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "id", "Dersin Kodu ve Ad\u0131", "Dersin Yar\u0131y\u0131l\u0131",
						"Dersin \u0130\u00E7eri\u011Fi", "Ders Kitab\u0131", "Yard\u0131mc\u0131 Ders Kitaplar\u0131",
						"Dersin Kredisi", "Dersin \u00D6nko\u015Fullar\u0131", "Dersin T\u00FCr\u00FC",
						"\u00D6\u011Fretim Dili", "Dersin Ama\u00E7lar\u0131",
						"Dersin \u00D6\u011Frenim \u00C7\u0131kt\u0131lar\u0131", "Dersin Verili\u015F Bi\u00E7imi",
						"Dersin Haftal\u0131k Da\u011F\u0131l\u0131m\u0131", "Egitim ve \u00D6gretim Faaliyetleri" }));
		dersTanimlamaFormuTable.getColumnModel().getColumn(0).setPreferredWidth(22);

		setLocationRelativeTo(null);
	}

	public ArrayList<SwDersTanimlamaFormu> dersTanimlamaFormuFunction() throws Exception {
		ArrayList<SwDersTanimlamaFormu> dersTanimlamaFormuItemsList = new ArrayList();
		DatabaseConnection d = new DatabaseConnection();
		Connection connection = d.veritabaninaBaglan();
		String q = "select*from ders_tanimlama_formu";
		PreparedStatement ps = d.veritabaninaBaglan().prepareStatement(q);

		ResultSet rs = ps.executeQuery();

		SwDersTanimlamaFormu dersTanimlamaFormuItemsClassObject;
		while (rs.next()) {
			dersTanimlamaFormuItemsClassObject = new SwDersTanimlamaFormu(rs.getInt("id"),
					rs.getString("DersinKoduveAdi"), rs.getString("DersinYariyili"), rs.getString("Dersinİcerigi"),
					rs.getString("DersKitabi"), rs.getString("YardimciDersKitaplari"), rs.getString("DersinKredisi"),
					rs.getString("DersinOnkosullari"), rs.getString("DersinTuru"), rs.getString("OgretimDili"),
					rs.getString("DersinAmaclari"), rs.getString("DersinOgrenimCiktilari"),
					rs.getString("DersinVerilisBicimi"), rs.getString("DersinHaftalıkDagilimi"),
					rs.getString("EgitimveOgretimFaaliyetleri"));
			System.out.println("veritabanindan degerleri aldi.");
			dersTanimlamaFormuItemsList.add(dersTanimlamaFormuItemsClassObject);
		}

		return dersTanimlamaFormuItemsList;

	}

	public void DersTanimlamaFormuTableShow() throws Exception {
		ArrayList<SwDersTanimlamaFormu> list = dersTanimlamaFormuFunction();
		DefaultTableModel model = (DefaultTableModel) dersTanimlamaFormuTable.getModel();
		model.setRowCount(0);
		Object row[] = new Object[15];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getId();
			row[1] = list.get(i).getDersinKoduveAdi();
			row[2] = list.get(i).getDersinYariyili();
			row[3] = list.get(i).getDersinİcerigi();
			row[4] = list.get(i).getDersKitabi();

			row[5] = list.get(i).getYardimciDersKitaplari();
			row[6] = list.get(i).getDersinKredisi();
			row[7] = list.get(i).getDersinOnkosullari();
			row[8] = list.get(i).getDersinTuru();
			row[9] = list.get(i).getOgretimDili();

			row[10] = list.get(i).getDersinAmaclari();
			row[11] = list.get(i).getDersinOgrenimCiktilari();
			row[12] = list.get(i).getDersinVerilisBicimi();

			row[13] = list.get(i).getDersinHaftalıkDagilimi();
			row[14] = list.get(i).getEgitimveOgretimFaaliyetleri();
			model.addRow(row);

		}
		dersTanimlamaFormuTable.setModel(model);

	}
}
