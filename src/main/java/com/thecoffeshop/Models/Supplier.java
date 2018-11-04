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
 * Supplier generated by hbm2java
 */
@Entity
@Table(name = "supplier", catalog = "luanvan")
public class Supplier implements java.io.Serializable {

	private String suId;
	private String suName;
	private String suAddress;
	private Integer suPhoneNumber;
	private String createBy;
	private Date createAt;
	private String updateBy;
	private Date updateAt;
	private Boolean isDelete;
	private String deleteBy;
	private Date deleteAt;
	private Set<Importbill> importbills = new HashSet<Importbill>(0);

	public Supplier() {
	}

	public Supplier(String suId) {
		this.suId = suId;
	}

	public Supplier(String suId, String suName, String suAddress, Integer suPhoneNumber, String createBy, Date createAt,
			String updateBy, Date updateAt, Boolean isDelete, String deleteBy, Date deleteAt,
			Set<Importbill> importbills) {
		this.suId = suId;
		this.suName = suName;
		this.suAddress = suAddress;
		this.suPhoneNumber = suPhoneNumber;
		this.createBy = createBy;
		this.createAt = createAt;
		this.updateBy = updateBy;
		this.updateAt = updateAt;
		this.isDelete = isDelete;
		this.deleteBy = deleteBy;
		this.deleteAt = deleteAt;
		this.importbills = importbills;
	}

	@Id

	@Column(name = "SU_ID", unique = true, nullable = false, length = 7)
	public String getSuId() {
		return this.suId;
	}

	public void setSuId(String suId) {
		this.suId = suId;
	}

	@Column(name = "SU_NAME")
	public String getSuName() {
		return this.suName;
	}

	public void setSuName(String suName) {
		this.suName = suName;
	}

	@Column(name = "SU_ADDRESS")
	public String getSuAddress() {
		return this.suAddress;
	}

	public void setSuAddress(String suAddress) {
		this.suAddress = suAddress;
	}

	@Column(name = "SU_PHONE_NUMBER", precision = 8, scale = 0)
	public Integer getSuPhoneNumber() {
		return this.suPhoneNumber;
	}

	public void setSuPhoneNumber(Integer suPhoneNumber) {
		this.suPhoneNumber = suPhoneNumber;
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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "supplier")
	public Set<Importbill> getImportbills() {
		return this.importbills;
	}

	public void setImportbills(Set<Importbill> importbills) {
		this.importbills = importbills;
	}

}
