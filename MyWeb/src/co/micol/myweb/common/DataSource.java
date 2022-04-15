package co.micol.myweb.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	private static DataSource dataSource = new DataSource();
	private Connection conn;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "micol";
	private String password = "1234";

	private DataSource() {
	};

	public static DataSource getInstance() {
		return dataSource;
	}

	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB OUT !!!!!!!!!!!!!!");
		}
		return conn;
	}
}
