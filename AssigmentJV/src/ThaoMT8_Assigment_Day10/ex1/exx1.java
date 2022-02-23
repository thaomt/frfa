package ThaoMT8_Assigment_Day10.ex1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ListIterator;

public class exx1 {
	public static void main(String args[]) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql:///lab02", "root", "thao1010");
			// Creating a Statement object
			Statement stmt = con.createStatement();
			// Retrieving the data
			ResultSet rs = stmt.executeQuery("Show tables");
			//table name
			String[] types = { "TABLE" };
			rs = con.getMetaData().getTables("lab02", null, "%", types);
			ArrayList<String> listTableName=new ArrayList<>();
			String tableName = "";
			int j=1;
			while (rs.next()) {
				tableName = rs.getString(3);
				listTableName.add(tableName);
				System.out.println("Name table "+j+" : " + tableName);
				j++;
			}
			// column name
			DatabaseMetaData meta = con.getMetaData();
			ListIterator litr = listTableName.listIterator();
	        while (litr.hasNext()) {
	            String element = (String) litr.next();
	            rs = meta.getColumns("lab02", null, element, "%");
				String columnName = "";
				int i=1;
				while (rs.next()) {
					columnName=rs.getString(4);
					System.out.println("Name of column "+i +" of table " + element + " : " + columnName);
					i++;
				}
				System.out.println("---------------");
	            
	        }
	        rs.close();
			// close JDBC connection
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
