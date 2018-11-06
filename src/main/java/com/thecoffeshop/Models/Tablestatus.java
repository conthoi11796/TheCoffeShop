package com.thecoffeshop.Models;
// Generated Nov 6, 2018 1:02:23 AM by Hibernate Tools 5.1.7.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private String createby;
	private Date createat;
	private String updateby;
	private Date updateat;
	private Boolean isdelete;
	private String deleteby;
	private Date deleteat;
	private Set<Tablestatusdetail> tablestatusdetails = new HashSet<Tablestatusdetail>(0);

	public Tablestatus() {
	}

	public Tablestatus(int tablestatusid) {
		this.tablestatusid = tablestatusid;
	}

	public Tablestatus(int tablestatusid, String name, String createby, Date createat, String updateby, Date updateat,
			Boolean isdelete, String deleteby, Date deleteat, Set<Tablestatusdetail> tablestatusdetails) {
		this.tablestatusid = tablestatusid;
		this.name = name;
		this.createby = createby;
		this.createat = createat;
		this.updateby = updateby;
		this.updateat = updateat;
		this.isdelete = isdelete;
		this.deleteby = deleteby;
		this.deleteat = deleteat;
		this.tablestatusdetails = tablestatusdetails;
	}

	@Id

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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tablestatus")
	public Set<Tablestatusdetail> getTablestatusdetails() {
		return this.tablestatusdetails;
	}

	public void setTablestatusdetails(Set<Tablestatusdetail> tablestatusdetails) {
		this.tablestatusdetails = tablestatusdetails;
	}

}
