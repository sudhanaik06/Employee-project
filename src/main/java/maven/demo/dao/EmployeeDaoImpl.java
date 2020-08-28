package maven.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import maven.demo.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getEmployees() {
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query  ... sort by last name
		Query<Employee> theQuery = 
				currentSession.createQuery("from Employee",
						Employee.class);

		// execute query and get result list
		List<Employee> customers = theQuery.getResultList();

		// return the results		
		return customers;
	}

	@Override
	public void saveCustomer(Employee theEmployee) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate the customer ...
		currentSession.saveOrUpdate(theEmployee);

	}
	
	@Override
	public Employee getEmployee(int employeeId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Employee theEmployee = currentSession.get(Employee.class, employeeId);
		return theEmployee;
	}
	
	@Override
	public void deleteCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Employee where id=:employeeId ");
		theQuery.setParameter("employeeId", theId);

		theQuery.executeUpdate();		
	}

	/*@Override
	public Employee getEmployeeName(String name) {
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Employee theEmployee = currentSession.get(Employee.class, name);
		return theEmployee;
	}*/

	
}
