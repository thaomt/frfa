package viDu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDAOImpement implements EmployeeDAO {
	private ConnectionMngt connectionMngt;
	public EmployeeDAOImpement() {
		connectionMngt=new ConnectionMngt();
	}

	@Override
	public Employee getByID(int id) throws SQLException {
		final String sql="SELECT * FROM test.employees WHERE id =?";
		Employee employee=null;
		try(Connection connection=connectionMngt.getConnection();
				PreparedStatement pstm=connection.prepareStatement(sql);){
			pstm.setInt(1, id);
			try(ResultSet rs=pstm.executeQuery();){
				if(rs.next()) {
					employee=new Employee();
					employee.setId(rs.getInt("id"));				
					employee.setName(rs.getString("name"));
					employee.setAge(rs.getInt("age"));
					}
			}
			
			
		}
		return employee;
	}

	@Override
	public Employee save(Employee employee) throws SQLException {
		//String sql="INSERT INTO Employees (name, age) VALUES (?, ?)";
		String sql="INSERT INTO Employees (name, age) VALUES (?, ?)";
		//Statement.RETURN_GENERATED_KEYS
		try(Connection conn=connectionMngt.getConnection();
				PreparedStatement preparedStatement=conn.prepareStatement(sql);){
			//preparedStatement.setInt(1,employee.getId());
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setInt(2, employee.getAge());
			//preparedStatement.executeBatch();
			preparedStatement.setString(1, "ha");
			preparedStatement.setInt(2, 8);
			//ResultSet res = preparedStatement.getGeneratedKeys();
			boolean ret=preparedStatement.execute();
			//System.out.println("The statement is exxcute with stattua"+ret);
			return employee;
		}
		
		
	}

	@Override
	public boolean update(Employee employee) throws SQLException {
		String sql="UPDATE employees SET age=?, name=? WHERE id = ?";
		try(Connection conn=connectionMngt.getConnection();
				PreparedStatement preparedStatement=conn.prepareStatement(sql);){
			preparedStatement.setInt(1, employee.getAge());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setInt(3, employee.getId());
			int ret=preparedStatement.executeUpdate();
			if(ret > 0) {
				return true;
			}
		}
		return false;
	}

}
