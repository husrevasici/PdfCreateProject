package PdfProject;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class ProgramInterface {

	static JFrame frame;
	static JTextField textField;
	static JComboBox comboBox;
	static String fileName;
	static String comboBox1SelectItem;
	private JLabel lblNewLabel_1;
	static int idWiindowsBuilder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgramInterface window = new ProgramInterface();
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
	public ProgramInterface() {

		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 649, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Dosya Seç");
		btnNewButton.setBounds(27, 56, 140, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.showOpenDialog(null);
				File f = jFileChooser.getSelectedFile();
				fileName = f.getAbsolutePath();
				textField.setText(fileName);
				lblNewLabel_1.setText(comboBox1SelectItem);

				if (comboBox1SelectItem == "A Ders Uygulama Planı") {
					try {

						// APdfCreate a_pdfCreate = new APdfCreate(); // Define Object

						APdfRead a_pdfRead = new APdfRead(); // Define Object
						a_pdfRead.pdfRead();
						APdfDatabaseAdd databaseAdd = new APdfDatabaseAdd();
						databaseAdd.DatabaseControl();
						// databaseAdd.Add();
						// a_pdfCreate.PdfCreate2();

					} catch (Exception e1) {
						e1.printStackTrace();
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (comboBox1SelectItem == "A Ders Uygulama Planı") {
					// c dosyası
					try {
						CPdfRead cpdfReadObject = new CPdfRead();
						CPdfCreate cPdfCreate = new CPdfCreate();
						cpdfReadObject.pdfRead();
						CPdfDatabaseAdd cPdfDatabase = new CPdfDatabaseAdd();
						// cPdfDatabase.Add();
						cPdfDatabase.DatabaseControl();
						cPdfDatabase.DatabaseControl1();
						cPdfDatabase.DatabaseControl2();

						// cPdfCreate.PdfCreate2();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (comboBox1SelectItem == "A Ders Uygulama Planı") {

					try {

						DPdfRead dPdfRead = new DPdfRead();
						DPdfDatabaseAdd dPdfDatabaseAddObject = new DPdfDatabaseAdd();
						// DPdfCreate dPdfCreate = new DPdfCreate();
						dPdfRead.pdfRead();
						// dPdfDatabaseAddObject.Add();
						dPdfDatabaseAddObject.DatabaseControlDdersNotizelgesi();
						dPdfDatabaseAddObject.DatabaseControlDdersNotCizelgesiVize();
						dPdfDatabaseAddObject.DatabaseControlDdersNotCizelgesiFinal();
						dPdfDatabaseAddObject.DatabaseControlDdersNotCizelgesiHarfNotu();

						// dPdfCreate.pdfCreate();

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} // end if
				if (comboBox1SelectItem == "A Ders Uygulama Planı") {

					try {
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
				} // end else if
				else if (comboBox1SelectItem == "B Dönem Sonu Raporu") {

					try {
						BPdfRead bpdfReadObject = new BPdfRead();
						bpdfReadObject.pdfRead();
						BPdfCreate bPdfCreate = new BPdfCreate();
						bPdfCreate.PdfCreate2();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} // end actionPerformed
		}); // end btnNewButton.addActionListener(new ActionListener()

		frame.getContentPane().add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(123, 132, 161, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		String s1[] = { "A Ders Uygulama Planı", "B Dönem Sonu Raporu", "C Ders Planı", "D Ders Planı",
				"Ders Tanımlama Formu" };
		comboBox = new JComboBox(s1);
		comboBox.setBounds(27, 25, 140, 20);
		comboBox.setSelectedItem(null);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getSource() == comboBox) {
					comboBox1SelectItem = comboBox.getSelectedItem().toString();
				}

			}
		});
		frame.getContentPane().add(comboBox);

		JLabel lblNewLabel = new JLabel("Dosyanın Yolu :");
		lblNewLabel.setBounds(27, 135, 86, 14);
		frame.getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(27, 97, 334, 14);
		frame.getContentPane().add(lblNewLabel_1);

	}

}
