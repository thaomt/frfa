package problem2.management;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMngt {
	//
	private static final String CONNECTION_STRING="jdbc:mysql://localhost:3306/test";
	public  Connection getConnection() {
		try {
			//1.Register a driver
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			//2.Create new connection
			final String username="root";
			final String password="thao1010";
			return DriverManager.getConnection(CONNECTION_STRING, username, password);
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	public static void main(String args[]) {
		ConnectionMngt connectionMngt=new ConnectionMngt();
		try(Connection connection=connectionMngt.getConnection()){
			System.out.println(connection.getMetaData().getDatabaseProductName());
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}
	}

}
