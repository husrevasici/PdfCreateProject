package PdfProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.io.codec.Base64.InputStream;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegisterAdmin {

	private JFrame frame;
	private JTextField textField_name;
	private JTextField textField_username;
	private JTextField textField_phone;
	private JPasswordField passwordField;
	private JPasswordField confirm_passwordField;
	private JRadioButton radioButtonFemale;
	private JRadioButton radioButtonMale;
	String image_path = null;
	static int idusername = 3;

	/**
	 * Launch the application.
	 */
	public boolean verifyFields() {
		String fname = textField_name.getText();
		String uname = textField_username.getText();
		String phone = textField_phone.getText();
		String pass1 = String.valueOf(passwordField.getText());
		String pass2 = String.valueOf(confirm_passwordField.getText());

		if (fname.trim().equals("") || uname.trim().equals("") || phone.trim().equals("") || pass1.trim().equals("")
				|| pass2.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "One or More fields are", "Empty Fields", 2);
			return false;
		} else if (!pass1.equals(pass2)) {
			// check if the two password are equals
			JOptionPane.showMessageDialog(null, "Password Doesnt't Match", "Confirm Password", 2);
			return false;
		} else {
			// everthing is okey
			return true;
		}

	}

	public boolean checkUserName(String username) throws Exception {
		DatabaseConnection dataConnection = new DatabaseConnection();
		Connection connection = dataConnection.veritabaninaBaglan();
		PreparedStatement ps;
		ResultSet rs;
		boolean username_exist = false;
		String q = "select*from `users` where `username`=?";
		ps = (PreparedStatement) dataConnection.veritabaninaBaglan().prepareStatement(q);

		ps.setString(1, username);
		rs = ps.executeQuery();

		if (rs.next()) {
			username_exist = true;
			JOptionPane.showMessageDialog(null, "This username is Already Taken, Choose Another One", "Username Fields",
					2);
		}
		return username_exist;

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterAdmin window = new RegisterAdmin();
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
	public RegisterAdmin() {
		initialize();
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 523, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 215, 0));
		panel.setBounds(0, 0, 450, 460);
		frame.getContentPane().add(panel);
		Border panel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		panel.setBorder(panel_border);// kenarlarını ayarlar.

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(10, 10, 430, 440);
		panel.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 57, 441, 383);
		panel_1.add(panel_2);

		final JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname = textField_name.getText();
				String username = textField_username.getText();
				String phone = textField_phone.getText();
				String pass1 = String.valueOf(passwordField.getText());
				String pass2 = String.valueOf(confirm_passwordField.getText());
				String gender = "Male";

//				if (radioButtonFemale.isSelected()) {
//					gender = "Female";
//				}
				if (verifyFields()) {
					try {
						if (!checkUserName(username)) {
							String INSERT_QUERY_REGİSTER_ADMİN = "INSERT INTO `users`"
									+ "(`username`,`password`,`fullname`,`phone`,`gender`,`image`) VALUES"
									+ "(?,?,?,?,?,?)";
							// `idusers`,
							DatabaseConnection dataConnection = new DatabaseConnection();
							PreparedStatement prpstmt = null;
//							prpstmt = (PreparedStatement).con.prepareStatement(INSERT_QUERY_REGİSTER_ADMİN);
							prpstmt = (PreparedStatement) dataConnection.veritabaninaBaglan()
									.prepareStatement(INSERT_QUERY_REGİSTER_ADMİN);

							prpstmt.setString(1, username);
							prpstmt.setString(2, pass1);
							prpstmt.setString(3, fname);
							prpstmt.setString(4, phone);
							prpstmt.setString(5, gender);

							if (image_path != null) {
								FileInputStream image = new FileInputStream(new File(image_path));
								prpstmt.setBlob(6, image);
							} else {
								prpstmt.setNull(6, java.sql.Types.NULL);
							}

							if (prpstmt.executeUpdate() != 0) {
								JOptionPane.showMessageDialog(null, "Kayıt Yapılmıştır.");
							} else {
								JOptionPane.showMessageDialog(null, "Error: Check Your Information");
							}
						}
						idusername++;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		btnKaydet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnKaydet.setBackground(new Color(0, 101, 183));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnKaydet.setBackground(new Color(235, 47, 6));
			}
		});

		btnKaydet.setForeground(SystemColor.inactiveCaptionText);
		btnKaydet.setFont(new Font("Arial", Font.BOLD, 16));
		btnKaydet.setBackground(new Color(235, 47, 6));
		btnKaydet.setBounds(115, 311, 237, 34);
		panel_2.add(btnKaydet);

		JLabel lblName = new JLabel("Ad Soyad :");
		lblName.setFont(new Font("Arial", Font.BOLD, 14));
		lblName.setBounds(70, 40, 100, 20);
		panel_2.add(lblName);

		textField_name = new JTextField();
		textField_name.setBounds(161, 39, 191, 24);
		panel_2.add(textField_name);
		textField_name.setColumns(10);

		JLabel username = new JLabel("Kullanıcı adı:");
		username.setFont(new Font("Arial", Font.BOLD, 14));
		username.setBounds(54, 71, 110, 20);
		panel_2.add(username);

		textField_username = new JTextField();
		textField_username.setBounds(161, 70, 191, 24);
		panel_2.add(textField_username);
		textField_username.setColumns(10);

		JLabel lblPassword = new JLabel(" Şifre:");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 14));
		lblPassword.setBounds(101, 110, 73, 17);
		panel_2.add(lblPassword);

		JLabel confirmPassword = new JLabel("Tekrar Şifre giriniz:");
		confirmPassword.setFont(new Font("Arial", Font.BOLD, 14));
		confirmPassword.setBounds(10, 138, 141, 25);
		panel_2.add(confirmPassword);

		JLabel Phone = new JLabel("Telefon No:");
		Phone.setFont(new Font("Arial", Font.BOLD, 14));
		Phone.setBounds(64, 174, 87, 14);
		panel_2.add(Phone);

		JLabel Gender = new JLabel("Cinsiyet:");
		Gender.setFont(new Font("Arial", Font.BOLD, 14));
		Gender.setBounds(88, 209, 63, 14);
		panel_2.add(Gender);

		textField_phone = new JTextField();
		textField_phone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		textField_phone.setBounds(161, 172, 191, 24);
		panel_2.add(textField_phone);
		textField_phone.setColumns(10);

		radioButtonMale = new JRadioButton("Erkek");
		radioButtonMale.setSelected(true);
		radioButtonMale.setBounds(161, 206, 55, 23);
		panel_2.add(radioButtonMale);

		JRadioButton radioButtonFemale = new JRadioButton("Bayan");
		radioButtonFemale.setBounds(218, 206, 73, 23);
		panel_2.add(radioButtonFemale);

		passwordField = new JPasswordField();
		passwordField.setBounds(161, 105, 191, 24);
		panel_2.add(passwordField);

		confirm_passwordField = new JPasswordField();
		confirm_passwordField.setBounds(161, 139, 191, 24);
		panel_2.add(confirm_passwordField);

		JLabel lblResimSec = new JLabel("Resim:");
		lblResimSec.setFont(new Font("Arial", Font.BOLD, 14));
		lblResimSec.setBounds(110, 243, 47, 14);
		panel_2.add(lblResimSec);

		final JLabel lblPath = new JLabel("Path:");
		lblPath.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPath.setBounds(283, 243, 148, 14);
		panel_2.add(lblPath);

		JButton btnNewButton = new JButton("Resim Seç");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = null;
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File(System.getProperty("user.home")));

				FileNameExtensionFilter extension = new FileNameExtensionFilter("*Images", "jpg", "png", "jpeg");
				chooser.addChoosableFileFilter(extension);

				int filestate = chooser.showSaveDialog(null);

				if (filestate == JFileChooser.APPROVE_OPTION) {
					File selectedImage = chooser.getSelectedFile();
					path = selectedImage.getAbsolutePath();
					lblPath.setText(path);
					image_path = path;
				}
			}
		});
		btnNewButton.setBounds(161, 240, 100, 23);
		panel_2.add(btnNewButton);

		Border field_border = BorderFactory.createMatteBorder(1, 5, 1, 1, Color.white);
		textField_name.setBorder(field_border);
		textField_phone.setBorder(field_border);
		textField_username.setBorder(field_border);
		passwordField.setBorder(field_border);
		confirm_passwordField.setBorder(field_border);

		ButtonGroup bg = new ButtonGroup();
		bg.add(radioButtonMale);
		bg.add(radioButtonFemale);

		final JLabel label_giris_ekrani = new JLabel("Giriş Yapın !");
		label_giris_ekrani.setFont(new Font("Arial", Font.BOLD, 11));
		label_giris_ekrani.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Border labelNewAccount_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.red);
				label_giris_ekrani.setBorder(labelNewAccount_border);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Border labelNewAccount_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY);
				label_giris_ekrani.setBorder(labelNewAccount_border);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				AdminPanel ap = new AdminPanel();
				ap.main(null);
				frame.setVisible(false);
//				ap.frame.setVisible(true);
//				ap.frame.pack();
//				ap.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				ap.frame.dispose();
			}
		});
		label_giris_ekrani.setBounds(200, 356, 73, 16);
		panel_2.add(label_giris_ekrani);
		final JLabel label_close = new JLabel(" X");
		label_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
				label_close.setBorder(label_border);// kenarlarını ayarlar.
				label_close.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				label_close.setBorder(label_border);// kenarlarını ayarlar.
				label_close.setForeground(Color.black);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		label_close.setFont(new Font("Arial", Font.PLAIN, 18));
		Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		label_close.setBorder(label_border);// kenarlarını ayarlar.
		label_close.setCursor(new Cursor(Cursor.HAND_CURSOR));
		label_close.setBounds(400, 3, 20, 25);
		panel_1.add(label_close);

		final JLabel label_minimize = new JLabel(" -");
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
		label_minimize.setBounds(378, 3, 20, 25);
		label_minimize.setBorder(label_border); // kenarlarını ayarlar.
		label_minimize.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_1.add(label_minimize);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(0, 84, 140));
		panel_3.setBounds(168, 0, 135, 46);
		panel_1.add(panel_3);
		Border jpanel_title_border = BorderFactory.createMatteBorder(0, 1, 1, 1, Color.yellow);
		panel_3.setBorder(jpanel_title_border);

		JLabel lblRegister = new JLabel("Kayıt Ekranı");
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setFont(new Font("Arial", Font.BOLD, 21));
		lblRegister.setBounds(0, 11, 125, 24);
		panel_3.add(lblRegister);
		frame.setLocationRelativeTo(null);
	}
}
