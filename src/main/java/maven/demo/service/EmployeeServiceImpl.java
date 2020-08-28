package maven.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maven.demo.dao.EmployeeDao;
import maven.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		
		return employeeDao.getEmployees();
	}

	
	@Override
	@Transactional
	public void saveCustomer(Employee theEmployee) {
		
		employeeDao.saveCustomer(theEmployee);
		
	}
	
	@Override
	@Transactional
	public Employee getEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployee(employeeId);
	}
	
	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		employeeDao.deleteCustomer(theId);
	}
	
	/*@Override
	@Transactional
	public Employee getEmployeeName(String name) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeName(name);
	}*/


	

}
