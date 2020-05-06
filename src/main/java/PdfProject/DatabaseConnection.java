package PdfProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	final static String URL = "jdbc:mysql://localhost/bitirmeprojesi";
	final static String USERNAME = "root";
	final static String PASSWORD = "6126384";
	static Connection con;

	static Connection veritabaninaBaglan() throws SQLException {
		Connection con = null;
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return con;
	}

}
