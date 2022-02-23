package exercise1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ListIterator;

public class Exercise1 {
	public static void main(String args[]) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection con = DriverManager.getConnection("jdbc:mysql:///lab02", "root", "thao1010");) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Show tables");
			ArrayList<String> listTableName=new ArrayList<>();
			System.out.print("Tables in the database: ");
			while (rs.next()) {
				String nameTable = rs.getString(1);
				listTableName.add(nameTable);
				System.out.print(nameTable+",");
			}
			System.out.println();
			ListIterator litr = listTableName.listIterator();
	        while (litr.hasNext()) {
	            String element = (String) litr.next();
	            System.out.println("Table "+element);
	            String query = "Select * from "+element;
				ResultSet resultSet = stmt.executeQuery(query);
				ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
				for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
					System.out.println("Name of column " + i + ":" + resultSetMetaData.getColumnName(i) + " - TypeData: "
							+ resultSetMetaData.getColumnTypeName(i) + "   ");					
				}
				System.out.println("*******");
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
