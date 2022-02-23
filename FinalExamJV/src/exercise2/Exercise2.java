package exercise2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise2 {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection con = DriverManager.getConnection("jdbc:mysql:///lab02", "root", "thao1010");) {
			con.setAutoCommit(false);
			try {
				Statement stmt = con.createStatement();
				PreparedStatement inst=null;
				
				// insert data into Student
				String sql = "INSERT INTO student VALUES (?, ?, ?, ?)";
				inst=con.prepareStatement(sql);
				inst.setInt(1, 3);
				inst.setString(2,"thao");
				inst.setString(3, "mai");
				inst.setString(4, "1-1-1");
				inst.execute();
				
				stmt.executeUpdate(sql);
				//inst=con.prepareStatement(sql);
				sql = "INSERT INTO student VALUES (4, 'Nguyen Xuan', 'Hoang', '20-11-2021')";
				stmt.executeUpdate(sql);
				// insert data into Course
				String sql2 = "INSERT INTO course VALUES (3, 'technical', '200')";
				stmt.executeUpdate(sql2);
				sql2 = "INSERT INTO course VALUES (4, 'art', '060')";
				stmt.executeUpdate(sql2);
				// insert data into Enrollment
				String sql3 = "INSERT INTO enrollment VALUES (3, 3, 3, '11')";
				stmt.executeUpdate(sql3);
				sql3 = "INSERT INTO enrollment VALUES (4, 4, 2, '07')";
				stmt.executeUpdate(sql3);
				
				// Change EnrollmentDate in table Student
				String sql4 = "UPDATE student " + "SET EnrollmentDate = '12-10-2020' WHERE id = 2 ";
				stmt.executeUpdate(sql4);
				
				// Add new a row to the Course after that roll back data in that table
				stmt.executeUpdate("INSERT INTO course VALUE(5, 'mussic', '09');");
				con.commit();
				System.out.println(" All task sucessfull");
			} catch (SQLException e) {
				e.printStackTrace();
				con.rollback();
			}

		}
	}

}
