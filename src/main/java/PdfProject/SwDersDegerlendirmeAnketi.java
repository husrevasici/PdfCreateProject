package PdfProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwDersDegerlendirmeAnketi extends JFrame {

	private JPanel contentPane;
	private JLabel label_dersuygulamaplani;
	private JLabel label_anasayfa;
	private JTable table_dersdegerlendirmeanketi;
	private JTextField textField_soruno;
	private JTextArea textArea_anketsorusu;
	private JTextArea textArea_anketpuani;
	private JTextArea textArea_ogrencisayisi;
	private JLabel label_dersdegerlendirmeanketi;
	private JLabel label_X;
	private JLabel label_minimize;
	private JLabel lblNotizelgesi;
	private JLabel lblDersTanmlamaFormu;
	private static SwDersDegerlendirmeAnketi frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SwDersDegerlendirmeAnketi();
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
	public SwDersDegerlendirmeAnketi() {
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
				main(null);
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

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.ORANGE));
		panel_1.setBounds(190, 5, 1035, 310);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		scrollPane.setBounds(10, 11, 1015, 293);
		panel_1.add(scrollPane);

		table_dersdegerlendirmeanketi = new JTable();
		table_dersdegerlendirmeanketi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table_dersdegerlendirmeanketi.getSelectedRow();
				TableModel model = table_dersdegerlendirmeanketi.getModel();
				textField_soruno.setText("" + model.getValueAt(i, 0).toString());
				textArea_anketsorusu.setText(" " + model.getValueAt(i, 1).toString());
				textArea_ogrencisayisi.setText("" + model.getValueAt(i, 2).toString());
				textArea_anketpuani.setText("" + model.getValueAt(i, 3).toString());
			}
		});
		table_dersdegerlendirmeanketi.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Soru No",
				"Sorulan Anket Sorusu", "Kat\u0131lan \u00D6\u011Frenci Say\u0131s\u0131", "Anket Puan\u0131" }));
		table_dersdegerlendirmeanketi.getColumnModel().getColumn(0).setPreferredWidth(51);
		table_dersdegerlendirmeanketi.getColumnModel().getColumn(1).setPreferredWidth(380);
		table_dersdegerlendirmeanketi.getColumnModel().getColumn(2).setPreferredWidth(114);
		scrollPane.setViewportView(table_dersdegerlendirmeanketi);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.ORANGE));
		panel_2.setBounds(190, 326, 1035, 179);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblSoruNo = new JLabel("Soru No :");
		lblSoruNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoruNo.setFont(new Font("Arial", Font.BOLD, 14));
		lblSoruNo.setBounds(100, 32, 88, 14);
		panel_2.add(lblSoruNo);

		JLabel lblAnketSorular = new JLabel("Anket Soruları :");
		lblAnketSorular.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnketSorular.setFont(new Font("Arial", Font.BOLD, 14));
		lblAnketSorular.setBounds(350, 32, 122, 14);
		panel_2.add(lblAnketSorular);

		JLabel lblKatlanrenciSays = new JLabel("Katılan Öğrenci Sayısı :");
		lblKatlanrenciSays.setHorizontalAlignment(SwingConstants.CENTER);
		lblKatlanrenciSays.setFont(new Font("Arial", Font.BOLD, 14));
		lblKatlanrenciSays.setBounds(22, 78, 166, 14);
		panel_2.add(lblKatlanrenciSays);

		JLabel lblAnketPuan = new JLabel("Anket Puanı :");
		lblAnketPuan.setFont(new Font("Arial", Font.BOLD, 14));
		lblAnketPuan.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnketPuan.setBounds(80, 135, 108, 14);
		panel_2.add(lblAnketPuan);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(197, 21, 127, 30);
		panel_2.add(scrollPane_3);

		textField_soruno = new JTextField();
		scrollPane_3.setViewportView(textField_soruno);
		textField_soruno.setColumns(10);

		JButton btnNewButton = new JButton("Görüntüle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DersDegerlendirmeAnketiSwingInterfaceTableShow();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(472, 101, 108, 36);
		panel_2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Kaydet");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q = "INSERT INTO `c_ogrenci_ders_degerlendirme_anketi`"
						+ "(`id`,`sorulan_anket_sorusu`, `katilan_ogrenci_sayisi`, `anket_puani`, `ders_kodu`) VALUES "
						+ "(?,?,?,?,?)";

				DatabaseConnection db = new DatabaseConnection();
				PreparedStatement ps = null;
				try {
					ps = (PreparedStatement) db.veritabaninaBaglan().prepareStatement(q);
					ps.setInt(1, Integer.valueOf(textField_soruno.getText()));
					ps.setString(2, textArea_anketsorusu.getText());
					ps.setString(3, textArea_ogrencisayisi.getText());
					ps.setString(4, textArea_anketpuani.getText());
					ps.setString(5, "307");

					if (ps.executeUpdate() != 0) {
						JOptionPane.showMessageDialog(null, "Değişiklik yapılmıştır.");
					} else {
						JOptionPane.showMessageDialog(null, "Error: Check Your Information");
					}
					DefaultTableModel model = (DefaultTableModel) table_dersdegerlendirmeanketi.getModel();
					model.setRowCount(0);
					DersDegerlendirmeAnketiSwingInterfaceTableShow();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.setBounds(610, 101, 108, 36);
		panel_2.add(btnNewButton_1);

		JButton button_guncelle = new JButton("Güncelle");
		button_guncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_dersdegerlendirmeanketi.getSelectedRow();
				String value = (table_dersdegerlendirmeanketi.getModel().getValueAt(row, 0).toString());
				String q = "UPDATE c_ogrenci_ders_degerlendirme_anketi SET sorulan_anket_sorusu=?, katilan_ogrenci_sayisi=?, anket_puani=?, ders_kodu=? where id="
						+ value;
				DatabaseConnection db = new DatabaseConnection();
				PreparedStatement ps = null;

				try {
					ps = (PreparedStatement) db.veritabaninaBaglan().prepareStatement(q);

					ps.setString(1, textArea_anketsorusu.getText());
					ps.setString(2, textArea_ogrencisayisi.getText());
					ps.setString(3, textArea_anketpuani.getText());
					ps.setInt(4, 307);

					//

					DefaultTableModel model = (DefaultTableModel) table_dersdegerlendirmeanketi.getModel();
					model.setRowCount(0);
					DersDegerlendirmeAnketiSwingInterfaceTableShow();

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

		textArea_ogrencisayisi = new JTextArea();
		scrollPane_1.setViewportView(textArea_ogrencisayisi);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(199, 127, 127, 30);
		panel_2.add(scrollPane_2);

		textArea_anketpuani = new JTextArea();
		scrollPane_2.setViewportView(textArea_anketpuani);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(472, 16, 542, 42);
		panel_2.add(scrollPane_4);

		textArea_anketsorusu = new JTextArea();
		scrollPane_4.setViewportView(textArea_anketsorusu);

		JButton button_delete = new JButton("Sil");
		button_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_dersdegerlendirmeanketi.getSelectedRow();
				String value = (table_dersdegerlendirmeanketi.getModel().getValueAt(row, 0).toString());
				String q = "DELETE FROM c_ogrenci_ders_degerlendirme_anketi  where id=" + value;
				DatabaseConnection db = new DatabaseConnection();
				PreparedStatement ps = null;
				try {
					ps = (PreparedStatement) db.veritabaninaBaglan().prepareStatement(q);

					ps.executeUpdate();
					DefaultTableModel model = (DefaultTableModel) table_dersdegerlendirmeanketi.getModel();
					model.setRowCount(0);
					DersDegerlendirmeAnketiSwingInterfaceTableShow();

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				}
			}
		});
		button_delete.setBounds(860, 101, 108, 36);
		panel_2.add(button_delete);

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
		setLocationRelativeTo(null);
	}

	public ArrayList<SwDersDegerlendirmeAnketiArrayListItems> SwDersDegerlendirmeAnketiArrayListItemsList()
			throws Exception {
		ArrayList<SwDersDegerlendirmeAnketiArrayListItems> SwDersDegerlendirmeAnketiArrayListItemsList = new ArrayList();
		DatabaseConnection d = new DatabaseConnection();
		Connection connection = d.veritabaninaBaglan();
		String q = "select*from c_ogrenci_ders_degerlendirme_anketi";
		PreparedStatement ps = d.veritabaninaBaglan().prepareStatement(q);

		ResultSet rs = ps.executeQuery();

		SwDersDegerlendirmeAnketiArrayListItems swDersDegerlendirmeAnketiArrayItemsClassObject;
		while (rs.next()) {
			swDersDegerlendirmeAnketiArrayItemsClassObject = new SwDersDegerlendirmeAnketiArrayListItems(
					rs.getInt("id"), rs.getString("sorulan_anket_sorusu"), rs.getString("katilan_ogrenci_sayisi"),
					rs.getString("anket_puani"), rs.getString("ders_kodu"));
			System.out.println("veritabanindan degerleri aldi.");
			SwDersDegerlendirmeAnketiArrayListItemsList.add(swDersDegerlendirmeAnketiArrayItemsClassObject);
		}

		return SwDersDegerlendirmeAnketiArrayListItemsList;

	}

	public void DersDegerlendirmeAnketiSwingInterfaceTableShow() throws Exception {
		ArrayList<SwDersDegerlendirmeAnketiArrayListItems> list = SwDersDegerlendirmeAnketiArrayListItemsList();
		DefaultTableModel model = (DefaultTableModel) table_dersdegerlendirmeanketi.getModel();
		model.setRowCount(0);
		Object row[] = new Object[4];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getId();
			row[1] = list.get(i).getSorulan_anket_sorusu();
			row[2] = list.get(i).getKatilan_ogrenci_sayisi();
			row[3] = list.get(i).getAnket_puani();
			model.addRow(row);
		}
		table_dersdegerlendirmeanketi.setModel(model);
	}

}
