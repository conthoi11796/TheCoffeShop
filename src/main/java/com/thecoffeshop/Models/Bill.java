package com.thecoffeshop.Models;

// Generated Oct 26, 2018 8:38:01 PM by Hibernate Tools 5.1.7.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Bill generated by hbm2java
 */
@Entity
@Table(name = "bill", catalog = "luanvan")
public class Bill implements java.io.Serializable {

	private int biId;
	private Billstatus billstatus;
	private Customer customer;
	private Dinnertable dinnertable;
	private Employee employee;
	private Productstatus productstatus;
	private Voucher voucher;
	private Date biDatetimeStart;
	private Date biDateimeFinish;
	private String createBy;
	private Date createAt;
	private String updateBy;
	private Date updateAt;
	private Boolean isDelete;
	private String deleteBy;
	private Date deleteAt;
	private Set<Billdetail> billdetails = new HashSet<Billdetail>(0);

	public Bill() {
	}

	public Bill(int biId) {
		this.biId = biId;
	}

	public Bill(int biId, Billstatus billstatus, Customer customer, Dinnertable dinnertable, Employee employee,
			Productstatus productstatus, Voucher voucher, Date biDatetimeStart, Date biDateimeFinish, String createBy,
			Date createAt, String updateBy, Date updateAt, Boolean isDelete, String deleteBy, Date deleteAt,
			Set<Billdetail> billdetails) {
		this.biId = biId;
		this.billstatus = billstatus;
		this.customer = customer;
		this.dinnertable = dinnertable;
		this.employee = employee;
		this.productstatus = productstatus;
		this.voucher = voucher;
		this.biDatetimeStart = biDatetimeStart;
		this.biDateimeFinish = biDateimeFinish;
		this.createBy = createBy;
		this.createAt = createAt;
		this.updateBy = updateBy;
		this.updateAt = updateAt;
		this.isDelete = isDelete;
		this.deleteBy = deleteBy;
		this.deleteAt = deleteAt;
		this.billdetails = billdetails;
	}

	@Id

	@Column(name = "BI_ID", unique = true, nullable = false)
	public int getBiId() {
		return this.biId;
	}

	public void setBiId(int biId) {
		this.biId = biId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BT_ID")
	public Billstatus getBillstatus() {
		return this.billstatus;
	}

	public void setBillstatus(Billstatus billstatus) {
		this.billstatus = billstatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CU_ID")
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DN_ID")
	public Dinnertable getDinnertable() {
		return this.dinnertable;
	}

	public void setDinnertable(Dinnertable dinnertable) {
		this.dinnertable = dinnertable;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EM_ID")
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PS_ID")
	public Productstatus getProductstatus() {
		return this.productstatus;
	}

	public void setProductstatus(Productstatus productstatus) {
		this.productstatus = productstatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VO_ID")
	public Voucher getVoucher() {
		return this.voucher;
	}

	public void setVoucher(Voucher voucher) {
		this.voucher = voucher;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BI_DATETIME_START", length = 19)
	public Date getBiDatetimeStart() {
		return this.biDatetimeStart;
	}

	public void setBiDatetimeStart(Date biDatetimeStart) {
		this.biDatetimeStart = biDatetimeStart;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BI_DATEIME_FINISH", length = 19)
	public Date getBiDateimeFinish() {
		return this.biDateimeFinish;
	}

	public void setBiDateimeFinish(Date biDateimeFinish) {
		this.biDateimeFinish = biDateimeFinish;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bill")
	public Set<Billdetail> getBilldetails() {
		return this.billdetails;
	}

	public void setBilldetails(Set<Billdetail> billdetails) {
		this.billdetails = billdetails;
	}

}
