package maven.demo.service;

import java.util.List;

import maven.demo.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public void saveCustomer(Employee theEmployee);

	public Employee getEmployee(int employeeId);
	
	public void deleteCustomer(int theId);

	//public Employee getEmployeeName(String name);

	
}
