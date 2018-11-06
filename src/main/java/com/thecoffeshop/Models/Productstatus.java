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
 * Productstatus generated by hbm2java
 */
@Entity
@Table(name = "productstatus", catalog = "luanvan")
public class Productstatus implements java.io.Serializable {

	private int productstatusid;
	private String name;
	private String createby;
	private Date createat;
	private String updateby;
	private Date updateat;
	private Boolean isdelete;
	private String deleteby;
	private Date deleteat;
	private Set<Bill> bills = new HashSet<Bill>(0);

	public Productstatus() {
	}

	public Productstatus(int productstatusid) {
		this.productstatusid = productstatusid;
	}

	public Productstatus(int productstatusid, String name, String createby, Date createat, String updateby,
			Date updateat, Boolean isdelete, String deleteby, Date deleteat, Set<Bill> bills) {
		this.productstatusid = productstatusid;
		this.name = name;
		this.createby = createby;
		this.createat = createat;
		this.updateby = updateby;
		this.updateat = updateat;
		this.isdelete = isdelete;
		this.deleteby = deleteby;
		this.deleteat = deleteat;
		this.bills = bills;
	}

	@Id

	@Column(name = "PRODUCTSTATUSID", unique = true, nullable = false)
	public int getProductstatusid() {
		return this.productstatusid;
	}

	public void setProductstatusid(int productstatusid) {
		this.productstatusid = productstatusid;
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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "productstatus")
	public Set<Bill> getBills() {
		return this.bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

}
