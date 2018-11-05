package com.thecoffeshop.Models;
// Generated Oct 26, 2018 8:38:01 PM by Hibernate Tools 5.1.7.Final

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
 * Customer generated by hbm2java
 */
@Entity
@Table(name = "customer", catalog = "luanvan")
public class Customer implements java.io.Serializable {

	private int cuId;
	private String cuName;
	private String cuAddress;
	private String cuPhoneNumber;
	private Boolean isDelete;
	private String deleteBy;
	private Date deleteAt;
	private Set<Bill> bills = new HashSet<Bill>(0);
	private Set<Booktable> booktables = new HashSet<Booktable>(0);

	public Customer() {
	}

	public Customer(int cuId) {
		this.cuId = cuId;
	}

	public Customer(int cuId, String cuName, String cuAddress, String cuPhoneNumber, Boolean isDelete, String deleteBy, Date deleteAt, Set<Bill> bills,
			Set<Booktable> booktables) {
		this.cuId = cuId;
		this.cuName = cuName;
		this.cuAddress = cuAddress;
		this.cuPhoneNumber = cuPhoneNumber;
		this.isDelete = isDelete;
		this.deleteBy = deleteBy;
		this.deleteAt = deleteAt;
		this.bills = bills;
		this.booktables = booktables;
	}

	@Id

	@Column(name = "CU_ID", unique = true, nullable = false, length = 7)
	public int getCuId() {
		return this.cuId;
	}

	public void setCuId(int cuId) {
		this.cuId = cuId;
	}

	@Column(name = "CU_NAME")
	public String getCuName() {
		return this.cuName;
	}

	public void setCuName(String cuName) {
		this.cuName = cuName;
	}

	@Column(name = "CU_ADDRESS")
	public String getCuAddress() {
		return this.cuAddress;
	}

	public void setCuAddress(String cuAddress) {
		this.cuAddress = cuAddress;
	}

	@Column(name = "CU_PHONE_NUMBER", length = 10)
	public String getCuPhoneNumber() {
		return this.cuPhoneNumber;
	}

	public void setCuPhoneNumber(String cuPhoneNumber) {
		this.cuPhoneNumber = cuPhoneNumber;
	}

	@Column(name = "IS_DELETE")
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name = "DELETE_BY", length = 7)
	public String getDeleteBy() {
		return this.deleteBy;
	}

	public void setDeleteBy(String deleteBy) {
		this.deleteBy = deleteBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DELETE_AT", length = 19)
	public Date getDeleteAt() {
		return this.deleteAt;
	}

	public void setDeleteAt(Date deleteAt) {
		this.deleteAt = deleteAt;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
	public Set<Bill> getBills() {
		return this.bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
	public Set<Booktable> getBooktables() {
		return this.booktables;
	}

	public void setBooktables(Set<Booktable> booktables) {
		this.booktables = booktables;
	}

}
