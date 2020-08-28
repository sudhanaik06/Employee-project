package maven.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import maven.demo.entity.Employee;
import maven.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired(required=true)
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@PostMapping("/employee")
	public Employee addCustomer(@RequestBody Employee theEmployee) {
		employeeService.saveCustomer(theEmployee);
		return theEmployee;
	}
	@GetMapping("/employee/{employeeId}")
	public Employee getCustomer(@PathVariable int employeeId){
		
		Employee theCustomer = employeeService.getEmployee(employeeId);
		
		if(theCustomer==null) {
			throw new EmployeeNotFoundException("Customer not found - "+employeeId);
		}
		return theCustomer;
	}
	
	/*@GetMapping("/employee/{name}")
	public Employee getEmployee(@PathVariable String name){
		
		Employee theCustomer = employeeService.getEmployeeName(name);
		
		if(theCustomer==null) {
			throw new EmployeeNotFoundException("Customer not found - "+name);
		}
		return theCustomer;
	}*/
	
	@DeleteMapping("/employee/{employeeId}")
	public String deleteCustomer(@PathVariable int employeeId) {
		Employee tempCustomer = employeeService.getEmployee(employeeId);
		if(tempCustomer==null) {
			throw new EmployeeNotFoundException("Customer not found -"+employeeId);
		}
		
		employeeService.deleteCustomer(employeeId);
		
		return "Deleted customer Id:-"+employeeId;
	}
	
	@PutMapping("/employee")
	public Employee updateCustomer(@RequestBody Employee theEmployee) {
		
		employeeService.saveCustomer(theEmployee);
		return theEmployee;
	}
}
