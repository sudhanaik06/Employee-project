package maven.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int id;
	
	@Column(name="name")
	public String name;
	
	@Column(name="address")
	public String address;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="employee_info_id")
	public EmployeeInfo employeeInfo;
	
	public Employee() {
		
	}

	public Employee(int id, String name, String address, EmployeeInfo employeeInfo) {
		
		this.id = id;
		this.name = name;
		this.address = address;
		this.employeeInfo = employeeInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public EmployeeInfo getEmployeeInfo() {
		return employeeInfo;
	}

	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

}
