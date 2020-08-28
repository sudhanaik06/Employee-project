package maven.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="employee_info")
public class EmployeeInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int id;
	
	@Column(name="base_image")
	public String base64Image;
	
	@Column(name="aadhar_number")
	public String aadharNumber;
	
	@Column(name="pan_number")
	public String panNumber;
	
	public EmployeeInfo() {
		
	}

	public EmployeeInfo(int id, String base64Image, String aadharNumber, String panNumber) {
		
		this.id = id;
		this.base64Image = base64Image;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	
}
