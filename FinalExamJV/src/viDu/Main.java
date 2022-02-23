package viDu;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		EmployeeDAO employeeDAO = new EmployeeDAOImpement();
		Employee employee = new Employee();
		employee.setAge(10);
		//employee.setId(2);
		employee.setName("nam");
		// 1..save employee to database

		employeeDAO.save(employee);
		System.out.println(employee);

		// 2.get employee by id

		Employee employee2 = employeeDAO.getByID(3);
		System.out.println(employee2);

		// 3.update employee
		//employee2.setAge(31);
		//employeeDAO.update(employee2);
		
		// 4. get update employee
		//Employee update = employeeDAO.getByID(employee2.getId());
		//System.out.println(update);

	}

}
