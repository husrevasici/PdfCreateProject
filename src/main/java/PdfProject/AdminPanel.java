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

import com.mysql.jdbc.PreparedStatement;

import javax.swing.BorderFactory;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPanel {

	private JFrame frame;
	private JLabel lblNewLabel_1;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	static boolean flag = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					AdminPanel window = new AdminPanel();
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
	public AdminPanel() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 510, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 215, 0));
		panel.setBounds(0, 0, 510, 340);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		Border panel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		panel.setBorder(panel_border);// kenarlarını ayarlar.

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(10, 10, 490, 320);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 77, 490, 243);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(AdminPanel.class.getResource("/LoginDesing/usernma1.png")));
		lblNewLabel_2.setBounds(93, 54, 37, 24);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(AdminPanel.class.getResource("/LoginDesing/qweqwe2.png")));
		lblNewLabel_3.setBounds(93, 104, 37, 24);
		panel_2.add(lblNewLabel_3);

		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().trim().toLowerCase().equals("username")) {
					txtUsername.setText("");
					txtUsername.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().trim().toLowerCase().equals("")
						|| txtUsername.getText().trim().toLowerCase().equals("username")) {
					txtUsername.setText("username");
					txtUsername.setForeground(new Color(153, 153, 153));
				}
			}
		});
		txtUsername.setForeground(new Color(153, 153, 153));
		txtUsername.setText("username");
		txtUsername.setBounds(140, 54, 243, 24);

		panel_2.add(txtUsername);
		txtUsername.setColumns(10);

		passwordField = new JPasswordField("password");
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				String pass = String.copyValueOf(passwordField.getPassword());
				if (pass.trim().toLowerCase().equals("password")) {
					passwordField.setText("");
					passwordField.setForeground(Color.BLACK);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				String pass = String.copyValueOf(passwordField.getPassword());
				if (pass.trim().toLowerCase().equals("password") || pass.trim().toLowerCase().equals("")) {
					passwordField.setText("password");
					passwordField.setForeground(new Color(153, 153, 153));
				}
			}
		});
		passwordField.setForeground(Color.LIGHT_GRAY);
		passwordField.setBounds(140, 104, 243, 24);
		panel_2.add(passwordField);

		final JButton btnGiri = new JButton("Giriş");
		btnGiri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = txtUsername.getText();
				String password = String.copyValueOf(passwordField.getPassword());

				if (userName.trim().equals("username") && password.trim().equals("password")) {
					JOptionPane.showMessageDialog(null, "Lütfen Kullanıcı Adınızı ve Şifrenizi Giriniz.",
							"Empty Username", 2);
				} else if (userName.trim().equals("username")) {
					JOptionPane.showMessageDialog(null, "Lütfen Kullanıcı Adınızı Giriniz.", "Empty Username", 2);
				} else if (password.trim().equals("password")) {
					JOptionPane.showMessageDialog(null, "Lütfen Şifrenizi Giriniz.", "Empty password", 2);
				} else {
					try {
						DatabaseConnection dataConnection = new DatabaseConnection();
						Connection connection = dataConnection.veritabaninaBaglan();

						String q = "select*from `users` where `username`=? and `password`=?";

						PreparedStatement ps = (PreparedStatement) dataConnection.veritabaninaBaglan()
								.prepareStatement(q);

						ps.setString(1, userName);
						ps.setString(2, password);
						ResultSet rs = ps.executeQuery();

						if (rs.next()) {
							flag = true;

							System.out.println("giriş yaptiniz");
//							ProgramInterfaceNew pf = new ProgramInterfaceNew();
//							pf.main(null);
							Anasayfa a = new Anasayfa();
							a.main(null);
							frame.setVisible(false);

						} else {
							JOptionPane.showMessageDialog(null, "Geçersiz Kullanıcı adı / Şifre", "Login Error", 2);
						}
//						if (flag == false) {
//							JOptionPane.showMessageDialog(null, "Kayıtlı bir admin yoktur.", "Login Error", 2);
//						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

//				ps.close();
//				rs.close();
//				connection.close();
			}
		});
		btnGiri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGiri.setBackground(new Color(0, 101, 183));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnGiri.setBackground(new Color(0, 84, 104));
			}
		});
		btnGiri.setForeground(SystemColor.inactiveCaptionBorder);
		btnGiri.setFont(new Font("Arial", Font.BOLD, 16));
		btnGiri.setBounds(155, 150, 202, 34);
		btnGiri.setBackground(new Color(0, 84, 140));
		btnGiri.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_2.add(btnGiri);

		final JLabel labelNewAccount = new JLabel("Kayıt ol !");
		labelNewAccount.setForeground(new Color(255, 0, 0));
		labelNewAccount.setFont(new Font("Arial", Font.BOLD, 11));
		labelNewAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Border labelNewAccount_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.red);
				labelNewAccount.setBorder(labelNewAccount_border);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Border labelNewAccount_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY);
				labelNewAccount.setBorder(labelNewAccount_border);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterAdmin rf = new RegisterAdmin();
				rf.main(null);
				frame.setVisible(false);
			}
		});
		labelNewAccount.setBounds(234, 197, 46, 14);
		labelNewAccount.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_2.add(labelNewAccount);

		final JLabel lblNewLabel = new JLabel(" X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				lblNewLabel.setBorder(label_border);// kenarlarını ayarlar.
				lblNewLabel.setForeground(Color.black);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
				lblNewLabel.setBorder(label_border);// kenarlarını ayarlar.
				lblNewLabel.setForeground(Color.white);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(449, 7, 20, 25);
		Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		lblNewLabel.setBorder(label_border);// kenarlarını ayarlar.
		lblNewLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_1.add(lblNewLabel);

		lblNewLabel_1 = new JLabel(" -");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
				lblNewLabel_1.setBorder(label_border);// kenarlarını ayarlar.
				lblNewLabel_1.setForeground(Color.black);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
				lblNewLabel_1.setBorder(label_border);// kenarlarını ayarlar.
				lblNewLabel_1.setForeground(Color.white);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(425, 7, 20, 25);
		lblNewLabel_1.setBorder(label_border); // kenarlarını ayarlar.
		lblNewLabel_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_1.add(lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(50, 205, 50));
		panel_3.setBounds(168, 0, 135, 46);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		Border jpanel_title_border = BorderFactory.createMatteBorder(0, 1, 1, 1, Color.yellow);
		panel_3.setBorder(jpanel_title_border);

		JLabel lblLogin = new JLabel("Giriş Ekranı");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Arial", Font.BOLD, 21));
		lblLogin.setBounds(10, 11, 125, 24);
		panel_3.add(lblLogin);
		frame.setLocationRelativeTo(null);
	}
}
