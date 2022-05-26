package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	final String DB_CONNECTION = "jdbc:mysql://localhost:3306/escola";
	final String DB_USERNAME = "root";
	final String DB_PASSWORD = "root";

	public Connection conect() {
		try {
			return DriverManager.getConnection(DB_CONNECTION, DB_USERNAME, DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
