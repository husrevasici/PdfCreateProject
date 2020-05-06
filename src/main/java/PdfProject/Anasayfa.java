package PdfProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Anasayfa extends JFrame {

	private JPanel contentPane;
	private JLabel label_dersuygulamaplani;
	private JLabel label_anasayfa;
	private JPanel panel_anasayfa;
	static String fileName;
	private JButton btnDosyaYkle;
	private JButton btnRaporOlustur;
	private JTextArea textArea_dosyayolu;
	private JLabel label_dersdegerlendirmeanketi;
	private JLabel lblNotizelgesi;
	private JLabel lblDersTanmlamaFormu;
	/**
	 * Launch the application.
	 */
	static Anasayfa frame = new Anasayfa();
	private JLabel label_X;
	private JLabel label_minimize;

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

	/**
	 * Create the frame.
	 */
	public Anasayfa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1230, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.ORANGE));
		panel.setBounds(5, 5, 180, 500);
		contentPane.add(panel);

		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(Anasayfa.class.getResource("/LoginDesing/Resim1.png")));
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
		panel.add(label_anasayfa);

		label_dersuygulamaplani = new JLabel("Ders Uygulama Planı");
		label_dersuygulamaplani.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				DersUygulamaPlani dup = new DersUygulamaPlani();
				dup.main(null);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				label_dersuygulamaplani.setBorder(label_border);// kenarlarını ayarlar.
				label_dersuygulamaplani.setForeground(Color.black);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red); // üzerine gelince
				// kenarları
				label_dersuygulamaplani.setBorder(label_border);// kenarlarını ayarlar.
				label_dersuygulamaplani.setForeground(Color.red); // üzerinde gelince yazısını ayarlar.
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

		panel_anasayfa = new JPanel();
		panel_anasayfa.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.ORANGE));
		panel_anasayfa.setBounds(190, 5, 1035, 500);
		contentPane.add(panel_anasayfa);
		panel_anasayfa.setLayout(null);

		btnDosyaYkle = new JButton("Dosya Yükle");
		btnDosyaYkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser jFileChooser = new JFileChooser();
					jFileChooser.showOpenDialog(null);
					File f = jFileChooser.getSelectedFile();
					fileName = f.getAbsolutePath();

				} catch (Exception ex) {
					ex.printStackTrace();
				}
				btnRaporOlustur.setVisible(true);

				textArea_dosyayolu.setText(fileName);
				textArea_dosyayolu.setVisible(true);
			}
		});
		btnDosyaYkle.setBounds(52, 34, 117, 23);
		panel_anasayfa.add(btnDosyaYkle);

		btnRaporOlustur = new JButton("Rapor Oluştur");
		btnRaporOlustur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					// APdfCreate a_pdfCreate = new APdfCreate(); // Define Object

					APdfRead a_pdfRead = new APdfRead(); // Define Object
					a_pdfRead.pdfRead();
					APdfDatabaseAdd databaseAdd = new APdfDatabaseAdd();
					databaseAdd.DatabaseControl();
					// databaseAdd.Add();
					// a_pdfCreate.PdfCreate2();

					// c dosyası
					BPdfRead bpdfReadObject = new BPdfRead();
					bpdfReadObject.pdfRead();
					
					CPdfRead cpdfReadObject = new CPdfRead();
					CPdfCreate cPdfCreate = new CPdfCreate();
					cpdfReadObject.pdfRead();
					CPdfDatabaseAdd cPdfDatabase = new CPdfDatabaseAdd();
					// cPdfDatabase.Add();
					cPdfDatabase.DatabaseControl();
					cPdfDatabase.DatabaseControl1();
					cPdfDatabase.DatabaseControl2();

					DPdfRead dPdfRead = new DPdfRead();
					DPdfDatabaseAdd dPdfDatabaseAddObject = new DPdfDatabaseAdd();
					// DPdfCreate dPdfCreate = new DPdfCreate();
					dPdfRead.pdfRead();
					// dPdfDatabaseAddObject.Add();
					dPdfDatabaseAddObject.DatabaseControlDdersNotizelgesi();
					dPdfDatabaseAddObject.DatabaseControlDdersNotCizelgesiVize();
					dPdfDatabaseAddObject.DatabaseControlDdersNotCizelgesiFinal();
					dPdfDatabaseAddObject.DatabaseControlDdersNotCizelgesiHarfNotu();

					DersTanimlamaFormlariRead dersTanimlamaFormlariReadObject = new DersTanimlamaFormlariRead();
					DersTanimlamaFormlariDatabaseAdd dersTanimlamaFormlariObject = new DersTanimlamaFormlariDatabaseAdd();
					dersTanimlamaFormlariReadObject.pdfRead();

					// dersTanimlamaFormlariObject.Add();
					dersTanimlamaFormlariObject.DatabaseControl();
					mudekPdfReportCreate m = new mudekPdfReportCreate();
					m.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRaporOlustur.setBounds(43, 179, 136, 23);
		panel_anasayfa.add(btnRaporOlustur);
		btnRaporOlustur.setVisible(false);

		JLabel lblDosyaYolu = new JLabel("Dosya Yolu");
		lblDosyaYolu.setHorizontalAlignment(SwingConstants.CENTER);
		lblDosyaYolu.setBounds(42, 86, 127, 14);
		panel_anasayfa.add(lblDosyaYolu);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 118, 150, 40);
		panel_anasayfa.add(scrollPane);

		textArea_dosyayolu = new JTextArea();
		scrollPane.setViewportView(textArea_dosyayolu);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(245, 11, 780, 478);
		panel_anasayfa.add(scrollPane_1);

		JTextPane textPane = new JTextPane();
		scrollPane_1.setViewportView(textPane);

		label_X = new JLabel("X");
		label_X.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
				label_X.setBorder(label_border);// kenarlarını ayarlar.
				label_X.setForeground(Color.white);
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
		textArea_dosyayolu.setVisible(false);
		setLocationRelativeTo(null);
	}
}
