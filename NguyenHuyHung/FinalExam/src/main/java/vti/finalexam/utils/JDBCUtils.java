package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

	private Properties properties;
	private Connection connection;
	public JDBCUtils()  {
		properties = new Properties();
		try {
			properties.load(new FileInputStream("src/main/resources/data.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public  Connection connectDB()   {
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url,username,password);
			System.out.println("Success");
			return  connection;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return  null;

	}
	public void disconnect() throws SQLException {
		if (connection != null && connection.isClosed()) {
			connection.close();
		}
	}
}
