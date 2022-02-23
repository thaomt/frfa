package viDu;

import java.sql.SQLException;

public interface EmployeeDAO {
	Employee getByID(int id) throws SQLException;
	Employee save(Employee employee) throws SQLException;
	boolean update(Employee employee) throws SQLException;
	

}
