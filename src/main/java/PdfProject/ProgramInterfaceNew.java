package PdfProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class ProgramInterfaceNew {

	private JFrame frame;
	static String fileName;
	private static JButton buton_rapor_olustur;
	private static JPanel panel_anaekran;
	private static JButton buttonPdfYukle;
	private static JLabel labelDosyaYolu;
	private static JLabel labelDosyaYoluYazı;
	private static JPanel panel_veritabanı_görüntüleme;
	private static JLabel label_X;
	private static JLabel label_minimize;
	private static JLabel lblVeritabanGrntle;
	private static JLabel labelAnasayfa;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgramInterfaceNew window = new ProgramInterfaceNew();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProgramInterfaceNew() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 841, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

//		frame.setUndecorated(true);

//		JPanel panel_arayuz = new JPanel();
//		panel_arayuz.setBackground(Color.WHITE);
//		panel_arayuz.setBounds(0, 128, 591, 254);
//		frame.getContentPane().add(panel_arayuz);
//		panel_arayuz.setLayout(null);

		JPanel panel_sabitkisim = new JPanel();
		panel_sabitkisim.setBounds(0, 0, 135, 382);
		panel_sabitkisim.setForeground(Color.WHITE);
		frame.getContentPane().add(panel_sabitkisim);
		panel_sabitkisim.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(32, 0, 79, 81);
		panel_sabitkisim.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(ProgramInterfaceNew.class.getResource("/LoginDesing/Resim1.png")));

		labelAnasayfa = new JLabel("AnaSayfa");
		labelAnasayfa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
				labelAnasayfa.setBorder(label_border);// kenarlarını ayarlar.
				labelAnasayfa.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				labelAnasayfa.setBorder(label_border);// kenarlarını ayarlar.
				labelAnasayfa.setForeground(Color.black);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panel_anaekran.setVisible(true);
				buton_rapor_olustur.setVisible(false);
				buttonPdfYukle.setVisible(true);
				labelDosyaYolu.setVisible(true);
				labelDosyaYoluYazı.setVisible(true);
				label_minimize.setVisible(true);
				label_X.setVisible(true);
				panel_veritabanı_görüntüleme.setVisible(false);

			}
		});
		labelAnasayfa.setHorizontalAlignment(SwingConstants.CENTER);
		labelAnasayfa.setFont(new Font("Arial", Font.BOLD, 12));
		labelAnasayfa.setBounds(0, 84, 135, 40);
		labelAnasayfa.setBackground(Color.YELLOW);
		panel_sabitkisim.add(labelAnasayfa);

		lblVeritabanGrntle = new JLabel("Veritabanı Görüntüle");
		lblVeritabanGrntle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				panel_anaekran.setVisible(false);
				panel_veritabanı_görüntüleme.setVisible(true);
				buton_rapor_olustur.setVisible(false);
				buttonPdfYukle.setVisible(false);
				labelDosyaYolu.setVisible(false);
				labelDosyaYoluYazı.setVisible(false);
				label_X.setVisible(true);
				label_minimize.setVisible(true);
				table.setVisible(true);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
				lblVeritabanGrntle.setBorder(label_border);// kenarlarını ayarlar.
				lblVeritabanGrntle.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				lblVeritabanGrntle.setBorder(label_border);// kenarlarını ayarlar.
				lblVeritabanGrntle.setForeground(Color.black);
			}

		});
		lblVeritabanGrntle.setHorizontalAlignment(SwingConstants.CENTER);
		lblVeritabanGrntle.setFont(new Font("Arial", Font.BOLD, 12));
		lblVeritabanGrntle.setBounds(0, 135, 135, 40);
		panel_sabitkisim.add(lblVeritabanGrntle);

		JLabel lblVeritabanDzenle = new JLabel("Veritabanı Düzenle");
		lblVeritabanDzenle.setHorizontalAlignment(SwingConstants.CENTER);
		lblVeritabanDzenle.setFont(new Font("Arial", Font.BOLD, 12));
		lblVeritabanDzenle.setBounds(0, 186, 135, 40);
		panel_sabitkisim.add(lblVeritabanDzenle);

		panel_anaekran = new JPanel();
		panel_anaekran.setBounds(134, 0, 651, 363);
		frame.getContentPane().add(panel_anaekran);
		panel_anaekran.setVisible(true);

		buttonPdfYukle = new JButton("Pdf Yükle");
		buttonPdfYukle.setBounds(26, 74, 149, 31);
		buttonPdfYukle.setVisible(false);
		buttonPdfYukle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser jFileChooser = new JFileChooser();
					jFileChooser.showOpenDialog(null);
					File f = jFileChooser.getSelectedFile();
					fileName = f.getAbsolutePath();

				} catch (Exception ex) {
					ex.printStackTrace();
				}
				buton_rapor_olustur.setVisible(true);
				labelDosyaYoluYazı.setText(fileName);
//					try {
//						BPdfRead bpdfReadObject = new BPdfRead();
//						bpdfReadObject.pdfRead();
//						BPdfCreate bPdfCreate = new BPdfCreate();
//						bPdfCreate.PdfCreate2();
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
			}

		});
		panel_anaekran.setLayout(null);
		buttonPdfYukle.setFont(new Font("Arial", Font.BOLD, 12));
		panel_anaekran.add(buttonPdfYukle);

		labelDosyaYolu = new JLabel("Dosya Yolu:");
		labelDosyaYolu.setBounds(26, 116, 86, 31);
		labelDosyaYolu.setVisible(false);
		panel_anaekran.add(labelDosyaYolu);

		labelDosyaYoluYazı = new JLabel("");
		labelDosyaYoluYazı.setBounds(26, 146, 381, 31);
		labelDosyaYoluYazı.setVisible(false);
		panel_anaekran.add(labelDosyaYoluYazı);

		buton_rapor_olustur = new JButton("Rapor Oluştur");
		buton_rapor_olustur.setBounds(26, 210, 149, 31);
		buton_rapor_olustur.setVisible(false);
		buton_rapor_olustur.addActionListener(new ActionListener() {
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
		buton_rapor_olustur.setFont(new Font("Arial", Font.BOLD, 12));
		panel_anaekran.add(buton_rapor_olustur);

		panel_veritabanı_görüntüleme = new JPanel();
		panel_veritabanı_görüntüleme.setBounds(134, 0, 651, 363);
		frame.getContentPane().add(panel_veritabanı_görüntüleme);
		
		panel_veritabanı_görüntüleme.setLayout(null);
		table = new JTable();
		table.setBounds(204, 0, 447, 352);
		panel_veritabanı_görüntüleme.add(table);

		label_X = new JLabel(" X");
		label_X.setBounds(606, 10, 25, 25);
		panel_veritabanı_görüntüleme.add(label_X);
		label_X.addMouseListener(new MouseAdapter() {
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

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		label_X.setFont(new Font("Arial", Font.PLAIN, 18));

		label_minimize = new JLabel(" -");
		label_minimize.setBounds(571, 8, 25, 25);
		panel_veritabanı_görüntüleme.add(label_minimize);

		label_minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
				label_minimize.setBorder(label_border);// kenarlarını ayarlar.
				label_minimize.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				label_minimize.setBorder(label_border);// kenarlarını ayarlar.
				label_minimize.setForeground(Color.black);
			}
		});
		label_minimize.setFont(new Font("Arial", Font.PLAIN, 21));
		String data[][] = { { "101", "Amit", "670000" }, { "102", "Jai", "780000" }, { "101", "Sachin", "700000" } };
		String column[] = { "ID", "NAME", "SALARY" };

		frame.setLocationRelativeTo(null);

	}
}
