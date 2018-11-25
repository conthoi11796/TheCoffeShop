package com.thecoffeshop.Models;
// Generated Nov 20, 2018 8:44:18 AM by Hibernate Tools 5.1.7.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Image generated by hbm2java
 */
@Entity
@Table(name = "image", catalog = "luanvan")
public class Image implements java.io.Serializable {

	private int imageid;
	private String name;
	private Set<Employee> employees = new HashSet<Employee>(0);
	private Set<Product> products = new HashSet<Product>(0);

	public Image() {
	}

	public Image(int imageid) {
		this.imageid = imageid;
	}

	public Image(int imageid, String name, Set<Employee> employees, Set<Product> products) {
		this.imageid = imageid;
		this.name = name;
		this.employees = employees;
		this.products = products;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "IMAGEID", unique = true, nullable = false)
	public int getImageid() {
		return this.imageid;
	}

	public void setImageid(int imageid) {
		this.imageid = imageid;
	}

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "imageofemployee", catalog = "luanvan", joinColumns = {
			@JoinColumn(name = "IMAGEID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "EMPLOYEEID", nullable = false, updatable = false) })
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "images")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
