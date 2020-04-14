package com.savan.Model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author SAVAN
 *
 */
@Entity
@Table(name = "Emp")
public class EmployeeModel {

	@Id
	@Column(name = "employe_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeId;
	
	@Column(name = "employe_name",length = 100,nullable = false)
	private String employeName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "date_of_join")
	private Date Doj;
	
	@Column(name = "salary")
	private double salary;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the employeId
	 */
	public int getEmployeId() {
		return employeId;
	}

	/**
	 * @param employeId the employeId to set
	 */
	public void setEmployeId(int employeId) {
		this.employeId = employeId;
	}

	/**
	 * @return the employeName
	 */
	public String getEmployeName() {
		return employeName;
	}

	/**
	 * @param employeName the employeName to set
	 */
	public void setEmployeName(String employeName) {
		this.employeName = employeName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the doj
	 */
	public Date getDoj() {
		return Doj;
	}

	/**
	 * @param doj the doj to set
	 */
	public void setDoj(Date doj) {
		Doj = doj;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
