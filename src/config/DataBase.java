package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	final static String DB_CONNECTION = "jdbc:mysql://127.0.0.1:3306/escola";
	final static String DB_USERNAME = "carlos";
	final static String DB_PASSWORD = "2002Vini@";

	public static Connection conect() {
		try {
			return DriverManager.getConnection(DB_CONNECTION, DB_USERNAME, DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
