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
 * Voucher generated by hbm2java
 */
@Entity
@Table(name = "voucher")
public class Voucher implements java.io.Serializable {

	private String voId;
	private String voName;
	private Date voDatestart;
	private Date voDatefinish;
	private Integer voSaleoff;
	private String createBy;
	private Date createAt;
	private String updateBy;
	private Date updateAt;
	private Boolean isDelete;
	private String deleteBy;
	private Date deleteAt;
	private Set<Bill> bills = new HashSet<Bill>(0);

	public Voucher() {
	}

	public Voucher(String voId) {
		this.voId = voId;
	}

	public Voucher(String voId, String voName, Date voDatestart, Date voDatefinish, Integer voSaleoff, String createBy,
			Date createAt, String updateBy, Date updateAt, Boolean isDelete, String deleteBy, Date deleteAt,
			Set<Bill> bills) {
		this.voId = voId;
		this.voName = voName;
		this.voDatestart = voDatestart;
		this.voDatefinish = voDatefinish;
		this.voSaleoff = voSaleoff;
		this.createBy = createBy;
		this.createAt = createAt;
		this.updateBy = updateBy;
		this.updateAt = updateAt;
		this.isDelete = isDelete;
		this.deleteBy = deleteBy;
		this.deleteAt = deleteAt;
		this.bills = bills;
	}

	@Id

	@Column(name = "VO_ID", unique = true, nullable = false, length = 7)
	public String getVoId() {
		return this.voId;
	}

	public void setVoId(String voId) {
		this.voId = voId;
	}

	@Column(name = "VO_NAME")
	public String getVoName() {
		return this.voName;
	}

	public void setVoName(String voName) {
		this.voName = voName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VO_DATESTART", length = 10)
	public Date getVoDatestart() {
		return this.voDatestart;
	}

	public void setVoDatestart(Date voDatestart) {
		this.voDatestart = voDatestart;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VO_DATEFINISH", length = 10)
	public Date getVoDatefinish() {
		return this.voDatefinish;
	}

	public void setVoDatefinish(Date voDatefinish) {
		this.voDatefinish = voDatefinish;
	}

	@Column(name = "VO_SALEOFF")
	public Integer getVoSaleoff() {
		return this.voSaleoff;
	}

	public void setVoSaleoff(Integer voSaleoff) {
		this.voSaleoff = voSaleoff;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "voucher")
	public Set<Bill> getBills() {
		return this.bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

}