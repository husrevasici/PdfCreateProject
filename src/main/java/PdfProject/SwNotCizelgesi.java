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

public class SwNotCizelgesi extends JFrame {

	private JPanel contentPane;
	private JLabel label_dersuygulamaplani;
	private JLabel label_anasayfa;
	private JTable table_notcizelgesi;
	private JTextField textField_sıraNo;
	private JTextArea textArea_vize;
	private JTextArea textArea_adSoyad;
	private JTextArea textArea_ogrenciNo;
	private JLabel label_dersdegerlendirmeanketi;
	private JLabel label_X;
	private JLabel label_minimize;
	private JTextArea textArea_final;
	private JTextArea textArea_harfNotu;
	private JLabel lblNotizelgesi;
	private JLabel lblDersTanmlamaFormu;
	private static SwNotCizelgesi frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new SwNotCizelgesi();
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
	public SwNotCizelgesi() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1230, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 180, 500);
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.ORANGE));
		contentPane.add(panel);

		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(SwDersDegerlendirmeAnketi.class.getResource("/LoginDesing/Resim1.png")));
		label.setBounds(52, 20, 79, 81);
		panel.add(label);

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
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
				label_anasayfa.setBorder(label_border);// kenarlarını ayarlar.
				label_anasayfa.setForeground(Color.red);
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
		panel.add(label_anasayfa);

		label_dersuygulamaplani = new JLabel("Ders Uygulama Planı");
		label_dersuygulamaplani.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
				label_dersuygulamaplani.setBorder(label_border);// kenarlarını ayarlar.
				label_dersuygulamaplani.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				label_dersuygulamaplani.setBorder(label_border);// kenarlarını ayarlar.
				label_dersuygulamaplani.setForeground(Color.black);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				DersUygulamaPlani dup = new DersUygulamaPlani();
				dup.main(null);
			}
		});
		label_dersuygulamaplani.setHorizontalAlignment(SwingConstants.CENTER);
		label_dersuygulamaplani.setFont(new Font("Arial", Font.BOLD, 11));
		label_dersuygulamaplani.setBounds(10, 155, 160, 40);
		panel.add(label_dersuygulamaplani);

		label_dersdegerlendirmeanketi = new JLabel("Ders Değerlendirme Anketi");
		label_dersdegerlendirmeanketi.addMouseListener(new MouseAdapter() {
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
				label_dersdegerlendirmeanketi.setBorder(label_border);// kenarlarını ayarlar.
				label_dersdegerlendirmeanketi.setForeground(Color.red); // üzerinde gelince yazısını ayarlar.
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				label_dersdegerlendirmeanketi.setBorder(label_border);// kenarlarını ayarlar.
				label_dersdegerlendirmeanketi.setForeground(Color.black);
			}
		});
		label_dersdegerlendirmeanketi.setHorizontalAlignment(SwingConstants.CENTER);
		label_dersdegerlendirmeanketi.setFont(new Font("Arial", Font.BOLD, 11));
		label_dersdegerlendirmeanketi.setBounds(10, 200, 160, 40);
		panel.add(label_dersdegerlendirmeanketi);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.ORANGE));
		panel_1.setBounds(190, 5, 1035, 310);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1015, 293);
		panel_1.add(scrollPane);

		table_notcizelgesi = new JTable();
		table_notcizelgesi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table_notcizelgesi.getSelectedRow();
				TableModel model = table_notcizelgesi.getModel();
				textField_sıraNo.setText("" + model.getValueAt(i, 0).toString());
				textArea_ogrenciNo.setText("" + model.getValueAt(i, 1).toString());
				textArea_adSoyad.setText("" + model.getValueAt(i, 2).toString());
				textArea_vize.setText("" + model.getValueAt(i, 3).toString());
				textArea_final.setText("" + model.getValueAt(i, 4).toString());
				textArea_harfNotu.setText("" + model.getValueAt(i, 5).toString());
			}
		});
		table_notcizelgesi.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "S\u0131ra No", "\u00D6\u011Frenci Numaras\u0131",
						"\u00D6\u011Frenci Ad\u0131 ve Soyad\u0131", "Vize S\u0131nav\u0131", "Final S\u0131nav\u0131",
						"Harf Notu" }));
		table_notcizelgesi.getColumnModel().getColumn(0).setPreferredWidth(44);
		table_notcizelgesi.getColumnModel().getColumn(1).setPreferredWidth(121);
		table_notcizelgesi.getColumnModel().getColumn(2).setPreferredWidth(255);
		scrollPane.setViewportView(table_notcizelgesi);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.ORANGE));
		panel_2.setBounds(190, 326, 1035, 179);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblSıraNo = new JLabel("Sıra No :");
		lblSıraNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSıraNo.setFont(new Font("Arial", Font.BOLD, 14));
		lblSıraNo.setBounds(100, 32, 88, 14);
		panel_2.add(lblSıraNo);

		JLabel lblVize = new JLabel("Vize :");
		lblVize.setHorizontalAlignment(SwingConstants.CENTER);
		lblVize.setFont(new Font("Arial", Font.BOLD, 14));
		lblVize.setBounds(350, 32, 122, 14);
		panel_2.add(lblVize);

		JLabel lblOgrenciNumarasi = new JLabel("Öğrenci Numarası");
		lblOgrenciNumarasi.setHorizontalAlignment(SwingConstants.CENTER);
		lblOgrenciNumarasi.setFont(new Font("Arial", Font.BOLD, 14));
		lblOgrenciNumarasi.setBounds(22, 78, 166, 14);
		panel_2.add(lblOgrenciNumarasi);

		JLabel lblAdSoyad = new JLabel("Öğrenci Adı Soyadı :");
		lblAdSoyad.setFont(new Font("Arial", Font.BOLD, 14));
		lblAdSoyad.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdSoyad.setBounds(38, 135, 150, 14);
		panel_2.add(lblAdSoyad);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(197, 21, 127, 30);
		panel_2.add(scrollPane_3);

		textField_sıraNo = new JTextField();
		scrollPane_3.setViewportView(textField_sıraNo);
		textField_sıraNo.setColumns(10);

		JButton button_goruntule = new JButton("Görüntüle");
		button_goruntule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// veritabani görüntüle
					SwNotCizelgesiTableShow();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_goruntule.setBounds(876, 32, 108, 36);
		panel_2.add(button_goruntule);

		JButton button_kaydet = new JButton("Kaydet");
		button_kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q = "INSERT INTO `d_not_cizelgesi`"
						+ "(`id`,`StudentNumber`, `StudentNameSurname`, `Midterm1`, `FinalExam`, `LetterGrade`, `ders_kodu`) "
						+ "VALUES (?,?,?,?,?,?,?)";

				DatabaseConnection db = new DatabaseConnection();
				PreparedStatement ps = null;
				try {
					ps = (PreparedStatement) db.veritabaninaBaglan().prepareStatement(q);
					ps.setInt(1, Integer.valueOf(textField_sıraNo.getText()));
					ps.setString(2, textArea_ogrenciNo.getText());
					ps.setString(3, textArea_adSoyad.getText());
					ps.setString(4, textArea_vize.getText());
					ps.setString(5, textArea_final.getText());
					ps.setString(6, textArea_harfNotu.getText());
					ps.setInt(7, 307);

					if (ps.executeUpdate() != 0) {
						JOptionPane.showMessageDialog(null, "Değişiklik yapılmıştır.");
					} else {
						JOptionPane.showMessageDialog(null, "Error: Check Your Information");
					}
					DefaultTableModel model = (DefaultTableModel) table_notcizelgesi.getModel();
					model.setRowCount(0);
					SwNotCizelgesiTableShow();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button_kaydet.setBounds(735, 32, 108, 36);
		panel_2.add(button_kaydet);

		JButton button_guncelle = new JButton("Güncelle");
		button_guncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_notcizelgesi.getSelectedRow();
				String value = (table_notcizelgesi.getModel().getValueAt(row, 0).toString());
				String q = "UPDATE d_not_cizelgesi SET StudentNumber=?, StudentNameSurname=?, Midterm1=?,"
						+ " FinalExam=?,LetterGrade=?,ders_kodu=? where id=" + value;

				DatabaseConnection db = new DatabaseConnection();
				PreparedStatement ps = null;

				try {
					ps = (PreparedStatement) db.veritabaninaBaglan().prepareStatement(q);
					ps.setString(1, textArea_ogrenciNo.getText());
					ps.setString(2, textArea_adSoyad.getText());
					ps.setString(3, textArea_vize.getText());
					ps.setString(4, textArea_final.getText());
					ps.setString(5, textArea_harfNotu.getText());
					ps.setInt(6, 307);

					ps.executeUpdate();
					DefaultTableModel model = (DefaultTableModel) table_notcizelgesi.getModel();
					model.setRowCount(0);
					SwNotCizelgesiTableShow();

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				}

			}
		});
		button_guncelle.setBounds(735, 101, 108, 36);
		panel_2.add(button_guncelle);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(198, 73, 127, 30);
		panel_2.add(scrollPane_1);

		textArea_ogrenciNo = new JTextArea();
		scrollPane_1.setViewportView(textArea_ogrenciNo);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(199, 127, 127, 30);
		panel_2.add(scrollPane_2);

		textArea_adSoyad = new JTextArea();
		scrollPane_2.setViewportView(textArea_adSoyad);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(472, 21, 127, 30);
		panel_2.add(scrollPane_4);

		textArea_vize = new JTextArea();
		scrollPane_4.setViewportView(textArea_vize);

		JButton button_delete = new JButton("Sil");
		button_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_notcizelgesi.getSelectedRow();
				String value = (table_notcizelgesi.getModel().getValueAt(row, 0).toString());
				String q = "DELETE FROM d_not_cizelgesi  where id=" + value;
				DatabaseConnection db = new DatabaseConnection();
				PreparedStatement ps = null;
				try {
					ps = (PreparedStatement) db.veritabaninaBaglan().prepareStatement(q);

					ps.executeUpdate();
					DefaultTableModel model = (DefaultTableModel) table_notcizelgesi.getModel();
					model.setRowCount(0);
					SwNotCizelgesiTableShow();

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				}
			}
		});
		button_delete.setBounds(876, 101, 108, 36);
		panel_2.add(button_delete);

		JLabel lblFinal = new JLabel("Final :");
		lblFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinal.setFont(new Font("Arial", Font.BOLD, 14));
		lblFinal.setBounds(354, 85, 108, 14);
		panel_2.add(lblFinal);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(474, 78, 125, 28);
		panel_2.add(scrollPane_5);

		textArea_final = new JTextArea();
		scrollPane_5.setViewportView(textArea_final);

		JLabel lblHarfNotu = new JLabel("Harf Notu :");
		lblHarfNotu.setHorizontalAlignment(SwingConstants.CENTER);
		lblHarfNotu.setFont(new Font("Arial", Font.BOLD, 14));
		lblHarfNotu.setBounds(354, 136, 108, 14);
		panel_2.add(lblHarfNotu);

		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(474, 129, 125, 28);
		panel_2.add(scrollPane_6);

		textArea_harfNotu = new JTextArea();
		scrollPane_6.setViewportView(textArea_harfNotu);

		label_X = new JLabel("X");
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
		label_X.setHorizontalAlignment(SwingConstants.CENTER);
		label_X.setForeground(Color.BLACK);
		label_X.setFont(new Font("Arial", Font.BOLD, 16));
		label_X.setBounds(5, 5, 25, 25);
		panel.add(label_X);

		label_minimize = new JLabel("-");
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
		label_minimize.setHorizontalAlignment(SwingConstants.CENTER);
		label_minimize.setFont(new Font("Arial", Font.BOLD, 16));
		label_minimize.setBounds(30, 5, 25, 25);
		panel.add(label_minimize);

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
		panel.add(lblNotizelgesi);

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
		panel.add(lblDersTanmlamaFormu);

		setLocationRelativeTo(null);
	}

	public ArrayList<NotCizelgesi> NotCizelgesiFunction() throws Exception {
		ArrayList<NotCizelgesi> NotCizelgesiList = new ArrayList();
		DatabaseConnection d = new DatabaseConnection();
		Connection connection = d.veritabaninaBaglan();
		String q = "select*from d_not_cizelgesi";
		PreparedStatement ps = d.veritabaninaBaglan().prepareStatement(q);

		ResultSet rs = ps.executeQuery();

		NotCizelgesi NotCizelgesiClassObject;
		while (rs.next()) {
			NotCizelgesiClassObject = new NotCizelgesi(rs.getInt("id"), rs.getString("StudentNumber"),
					rs.getString("StudentNameSurname"), rs.getString("Midterm1"), rs.getString("FinalExam"),
					rs.getString("LetterGrade"), rs.getInt("ders_kodu"));

			NotCizelgesiList.add(NotCizelgesiClassObject);
		}

		return NotCizelgesiList;

	}

	public void SwNotCizelgesiTableShow() throws Exception {
		ArrayList<NotCizelgesi> list = NotCizelgesiFunction();
		DefaultTableModel model = (DefaultTableModel) table_notcizelgesi.getModel();
		model.setRowCount(0);
		Object row[] = new Object[6];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getId();
			row[1] = list.get(i).getStudentNumber();
			row[2] = list.get(i).getStudentNameSurname();
			row[3] = list.get(i).getMidterm1();
			row[4] = list.get(i).getFinalExam();
			row[5] = list.get(i).getLetterGrade();
			model.addRow(row);
		}

		table_notcizelgesi.setModel(model);
	}

}
