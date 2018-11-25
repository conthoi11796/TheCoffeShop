package com.thecoffeshop.Models;
// Generated Nov 20, 2018 8:44:18 AM by Hibernate Tools 5.1.7.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tablestatus generated by hbm2java
 */
@Entity
@Table(name = "tablestatus", catalog = "luanvan")
public class Tablestatus implements java.io.Serializable {

	private int tablestatusid;
	private String name;
	private Date updateat;
	private Boolean isdelete;
	private Set<Dinnertable> dinnertables = new HashSet<Dinnertable>(0);

	public Tablestatus() {
	}

	public Tablestatus(int tablestatusid) {
		this.tablestatusid = tablestatusid;
	}

	public Tablestatus(int tablestatusid, String name, Date updateat, Boolean isdelete, Set<Dinnertable> dinnertables) {
		this.tablestatusid = tablestatusid;
		this.name = name;
		this.updateat = updateat;
		this.isdelete = isdelete;
		this.dinnertables = dinnertables;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "TABLESTATUSID", unique = true, nullable = false)
	public int getTablestatusid() {
		return this.tablestatusid;
	}

	public void setTablestatusid(int tablestatusid) {
		this.tablestatusid = tablestatusid;
	}

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tablestatus")
	public Set<Dinnertable> getDinnertables() {
		return this.dinnertables;
	}

	public void setDinnertables(Set<Dinnertable> dinnertables) {
		this.dinnertables = dinnertables;
	}

}
