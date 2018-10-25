package com.thecoffeshop.Models;
// Generated Oct 24, 2018 11:35:31 AM by Hibernate Tools 5.1.7.Final

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
 * Importbill generated by hbm2java
 */
@Entity
@Table(name = "importbill")
public class Importbill implements java.io.Serializable {

	private int ibId;
	private Supplier supplier;
	private Date ibDateTime;
	private String createBy;
	private Date createAt;
	private String updateBy;
	private Date updateAt;
	private Boolean isDelete;
	private String deleteBy;
	private Date deleteAt;
	private Set<Materialdetail> materialdetails = new HashSet<Materialdetail>(0);

	public Importbill() {
	}

	public Importbill(int ibId) {
		this.ibId = ibId;
	}

	public Importbill(int ibId, Supplier supplier, Date ibDateTime, String createBy, Date createAt, String updateBy,
			Date updateAt, Boolean isDelete, String deleteBy, Date deleteAt, Set<Materialdetail> materialdetails) {
		this.ibId = ibId;
		this.supplier = supplier;
		this.ibDateTime = ibDateTime;
		this.createBy = createBy;
		this.createAt = createAt;
		this.updateBy = updateBy;
		this.updateAt = updateAt;
		this.isDelete = isDelete;
		this.deleteBy = deleteBy;
		this.deleteAt = deleteAt;
		this.materialdetails = materialdetails;
	}

	@Id

	@Column(name = "IB_ID", unique = true, nullable = false)
	public int getIbId() {
		return this.ibId;
	}

	public void setIbId(int ibId) {
		this.ibId = ibId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SU_ID")
	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "IB_DATE_TIME", length = 19)
	public Date getIbDateTime() {
		return this.ibDateTime;
	}

	public void setIbDateTime(Date ibDateTime) {
		this.ibDateTime = ibDateTime;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "importbill")
	public Set<Materialdetail> getMaterialdetails() {
		return this.materialdetails;
	}

	public void setMaterialdetails(Set<Materialdetail> materialdetails) {
		this.materialdetails = materialdetails;
	}

}
