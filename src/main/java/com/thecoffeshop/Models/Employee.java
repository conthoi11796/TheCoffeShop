package com.thecoffeshop.Models;
// Generated Nov 6, 2018 1:02:23 AM by Hibernate Tools 5.1.7.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "employee", catalog = "luanvan")
public class Employee implements java.io.Serializable {

	private String employeeid;
	private Salary salary;
	private String name;
	private Boolean sex;
	private Integer phone;
	private String address;
	private String usename;
	private String password;
	private String createby;
	private Date createat;
	private String updateby;
	private Date updateat;
	private Boolean isdelete;
	private String deleteby;
	private Date deleteat;
	private Set<Bill> bills = new HashSet<Bill>(0);
	private Set<Atposition> atpositions = new HashSet<Atposition>(0);
	private Set<Exportbill> exportbills = new HashSet<Exportbill>(0);
	private Set<Register> registers = new HashSet<Register>(0);
	private Set<Image> images = new HashSet<Image>(0);
	private Set<Booktable> booktables = new HashSet<Booktable>(0);

	public Employee() {
	}

	public Employee(String employeeid) {
		this.employeeid = employeeid;
	}

	public Employee(String employeeid, Salary salary, String name, Boolean sex, Integer phone, String address,
			String usename, String password, String createby, Date createat, String updateby, Date updateat,
			Boolean isdelete, String deleteby, Date deleteat, Set<Bill> bills, Set<Atposition> atpositions,
			Set<Exportbill> exportbills, Set<Register> registers, Set<Image> images, Set<Booktable> booktables) {
		this.employeeid = employeeid;
		this.salary = salary;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.address = address;
		this.usename = usename;
		this.password = password;
		this.createby = createby;
		this.createat = createat;
		this.updateby = updateby;
		this.updateat = updateat;
		this.isdelete = isdelete;
		this.deleteby = deleteby;
		this.deleteat = deleteat;
		this.bills = bills;
		this.atpositions = atpositions;
		this.exportbills = exportbills;
		this.registers = registers;
		this.images = images;
		this.booktables = booktables;
	}

	@Id

	@Column(name = "EMPLOYEEID", unique = true, nullable = false, length = 7)
	public String getEmployeeid() {
		return this.employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SALARYID")
	public Salary getSalary() {
		return this.salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SEX")
	public Boolean getSex() {
		return this.sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	@Column(name = "PHONE", precision = 8, scale = 0)
	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "USENAME")
	public String getUsename() {
		return this.usename;
	}

	public void setUsename(String usename) {
		this.usename = usename;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "CREATEBY", length = 7)
	public String getCreateby() {
		return this.createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEAT", length = 19)
	public Date getCreateat() {
		return this.createat;
	}

	public void setCreateat(Date createat) {
		this.createat = createat;
	}

	@Column(name = "UPDATEBY", length = 7)
	public String getUpdateby() {
		return this.updateby;
	}

	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATEAT", length = 19)
	public Date getUpdateat() {
		return this.updateat;
	}

	public void setUpdateat(Date updateat) {
		this.updateat = updateat;
	}

	@Column(name = "ISDELETE")
	public Boolean getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}

	@Column(name = "DELETEBY", length = 7)
	public String getDeleteby() {
		return this.deleteby;
	}

	public void setDeleteby(String deleteby) {
		this.deleteby = deleteby;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DELETEAT", length = 19)
	public Date getDeleteat() {
		return this.deleteat;
	}

	public void setDeleteat(Date deleteat) {
		this.deleteat = deleteat;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
	public Set<Bill> getBills() {
		return this.bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
	public Set<Atposition> getAtpositions() {
		return this.atpositions;
	}

	public void setAtpositions(Set<Atposition> atpositions) {
		this.atpositions = atpositions;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
	public Set<Exportbill> getExportbills() {
		return this.exportbills;
	}

	public void setExportbills(Set<Exportbill> exportbills) {
		this.exportbills = exportbills;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
	public Set<Register> getRegisters() {
		return this.registers;
	}

	public void setRegisters(Set<Register> registers) {
		this.registers = registers;
	}

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "employees")
	public Set<Image> getImages() {
		return this.images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
	public Set<Booktable> getBooktables() {
		return this.booktables;
	}

	public void setBooktables(Set<Booktable> booktables) {
		this.booktables = booktables;
	}

}
