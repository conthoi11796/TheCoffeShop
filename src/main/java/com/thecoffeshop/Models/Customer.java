package com.thecoffeshop.Models;
// Generated Oct 24, 2018 11:35:31 AM by Hibernate Tools 5.1.7.Final

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
@Table(name = "customer")
public class Customer implements java.io.Serializable {

	private String cuId;
	private String cuName;
	private String cuAddress;
	private Integer cuPhoneNumber;
	private String createBy;
	private Date createAt;
	private String updateBy;
	private Date updateAt;
	private Boolean isDelete;
	private String deleteBy;
	private Date deleteAt;
	private Set<Bill> bills = new HashSet<Bill>(0);
	private Set<Booktable> booktables = new HashSet<Booktable>(0);

	public Customer() {
	}

	public Customer(String cuId) {
		this.cuId = cuId;
	}

	public Customer(String cuId, String cuName, String cuAddress, Integer cuPhoneNumber, String createBy, Date createAt,
			String updateBy, Date updateAt, Boolean isDelete, String deleteBy, Date deleteAt, Set<Bill> bills,
			Set<Booktable> booktables) {
		this.cuId = cuId;
		this.cuName = cuName;
		this.cuAddress = cuAddress;
		this.cuPhoneNumber = cuPhoneNumber;
		this.createBy = createBy;
		this.createAt = createAt;
		this.updateBy = updateBy;
		this.updateAt = updateAt;
		this.isDelete = isDelete;
		this.deleteBy = deleteBy;
		this.deleteAt = deleteAt;
		this.bills = bills;
		this.booktables = booktables;
	}

	@Id

	@Column(name = "CU_ID", unique = true, nullable = false, length = 7)
	public String getCuId() {
		return this.cuId;
	}

	public void setCuId(String cuId) {
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

	@Column(name = "CU_PHONE_NUMBER", precision = 8, scale = 0)
	public Integer getCuPhoneNumber() {
		return this.cuPhoneNumber;
	}

	public void setCuPhoneNumber(Integer cuPhoneNumber) {
		this.cuPhoneNumber = cuPhoneNumber;
	}

	@Column(name = "CREATE_BY", length = 7)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_AT", length = 19)
	public Date getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Column(name = "UPDATE_BY", length = 7)
	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_AT", length = 19)
	public Date getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<Bill> getBills() {
		return this.bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<Booktable> getBooktables() {
		return this.booktables;
	}

	public void setBooktables(Set<Booktable> booktables) {
		this.booktables = booktables;
	}

}