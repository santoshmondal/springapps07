package com.rediff.hibernate.refernce;

import java.io.Serializable;
import java.util.Set;

/**
 * 1:1 Student has Address
 * 1:M Student has Many Phone 
 * M:1 Many Students Has One Company
 * M:N Many Student has many syllabus
 * 
 * Unidirectional
 *  
 * @author santoshm 
 *
 */
public class Student extends BasePojo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long sid;
	private String name;
	private String mname;
	private String lname;

	private Address address; // 1:1
	private Company company;//M:1
	private Set<Phone> phone_set;// 1:M
	private Set<Syllabus> syllabus_set; //M:N

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Phone> getPhone_set() {
		return phone_set;
	}

	public void setPhone_set(Set<Phone> phone_set) {
		this.phone_set = phone_set;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<Syllabus> getSyllabus_set() {
		return syllabus_set;
	}

	public void setSyllabus_set(Set<Syllabus> syllabus_set) {
		this.syllabus_set = syllabus_set;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

}
