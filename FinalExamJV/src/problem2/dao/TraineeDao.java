package problem2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import problem2.entities.Trainee;
import problem2.management.ConnectionMngt;

public class TraineeDao {
	private ConnectionMngt connectionMngt;
	public TraineeDao() {
		connectionMngt=new ConnectionMngt();
	}

	public Trainee save(Trainee trainee)  throws SQLException {
		String sql="INSERT INTO Trainee (account, full_name, gender, birth_date, phone_number, gpa, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try(Connection conn=connectionMngt.getConnection();
				PreparedStatement preparedStatement=conn.prepareStatement(sql);){
			preparedStatement.setString(1, trainee.getAccount());
			preparedStatement.setString(2, trainee.getFull_name());
			preparedStatement.setInt(3, trainee.getGender());
			preparedStatement.setDate(4,new java.sql.Date(System.currentTimeMillis()));
			preparedStatement.setString(5, trainee.getPhone_number());
			preparedStatement.setString(6, trainee.getGpa());
			preparedStatement.setString(7, trainee.getStatus());
			boolean ret=preparedStatement.execute();
			return trainee;
		}		
	}
	public boolean update(Trainee trainee) throws SQLException {
		String sql="UPDATE Trainee SET account=? WHERE Trainee_id = ?";
		try(Connection conn=connectionMngt.getConnection();
				PreparedStatement preparedStatement=conn.prepareStatement(sql);){
			preparedStatement.setString(1, trainee.getAccount());
			preparedStatement.setInt(2, trainee.getTrainee_id());
			int ret=preparedStatement.executeUpdate();
			if(ret > 0) {
				return true;
			}
		}
		return false;
		
	}
	public Trainee remove(Trainee trainee)throws SQLException {
		String sql="DELETE FROM Trainee WHERE account = ?";
		try(Connection conn=connectionMngt.getConnection();
				Statement stmt = conn.createStatement();PreparedStatement preparedStatement=conn.prepareStatement(sql)){
			preparedStatement.setString(1, trainee.getAccount());
			preparedStatement.executeUpdate();
			return trainee;
		}
	}
	public Trainee findIncompletedTrainee()  throws SQLException {
		String sql="SELECT * FROM Trainee WHERE gpa < 6";
		Trainee trainee=null;
		try(Connection conn=connectionMngt.getConnection();
				Statement stmt = conn.createStatement();PreparedStatement pstm=conn.prepareStatement(sql);){
			try(ResultSet rs=pstm.executeQuery();){
				if(rs.next()) {
					trainee=new Trainee();
					trainee.setTrainee_id(rs.getInt("trainee_id"));				
					trainee.setAccount(rs.getString("account"));
					trainee.setFull_name(rs.getString("full_name"));
					trainee.setGender(rs.getInt("gender"));
					trainee.setBirth_date(rs.getDate("birth_date"));
					trainee.setPhone_number(rs.getString("phone_number"));
					trainee.setGpa(rs.getString("gpa"));
					trainee.setStatus(rs.getString("status"));
					
					}
			}
			
			return trainee;
		}		
	}
	public Trainee findExcellentTrainee() throws SQLException {
		Trainee trainee=null;
		String sql="SELECT account, full_name, gender, birth_date, gpa FROM Trainee WHERE gpa < 100 AND gpa >90";
		try(Connection conn=connectionMngt.getConnection();
				Statement stmt = conn.createStatement();PreparedStatement pstm=conn.prepareStatement(sql);){
			
			try(ResultSet rs=pstm.executeQuery();){
				if(rs.next()) {
					trainee=new Trainee();
					trainee.setTrainee_id(rs.getInt("trainee_id"));				
					trainee.setAccount(rs.getString("account"));
					trainee.setFull_name(rs.getString("full_name"));
					trainee.setGender(rs.getInt("gender"));
					trainee.setBirth_date(rs.getDate("birth_date"));
					trainee.setPhone_number(rs.getString("phone_number"));
					trainee.setGpa(rs.getString("gpa"));
					trainee.setStatus(rs.getString("status"));
					
					}
			}
			return trainee;
		}	
		
	}

}
