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
 * Materialdetail generated by hbm2java
 */
@Entity
@Table(name = "materialdetail", catalog = "luanvan")
public class Materialdetail implements java.io.Serializable {

	private int mdId;
	private Importbill importbill;
	private Material material;
	private Date mdDateOfManufacture;
	private Date mdExpirationDate;
	private Integer mdQuantity;
	private String createBy;
	private Date createAt;
	private String updateBy;
	private Date updateAt;
	private Boolean isDelete;
	private String deleteBy;
	private Date deleteAt;
	private Set<Exportbill> exportbills = new HashSet<Exportbill>(0);

	public Materialdetail() {
	}

	public Materialdetail(int mdId) {
		this.mdId = mdId;
	}

	public Materialdetail(int mdId, Importbill importbill, Material material, Date mdDateOfManufacture,
			Date mdExpirationDate, Integer mdQuantity, String createBy, Date createAt, String updateBy, Date updateAt,
			Boolean isDelete, String deleteBy, Date deleteAt, Set<Exportbill> exportbills) {
		this.mdId = mdId;
		this.importbill = importbill;
		this.material = material;
		this.mdDateOfManufacture = mdDateOfManufacture;
		this.mdExpirationDate = mdExpirationDate;
		this.mdQuantity = mdQuantity;
		this.createBy = createBy;
		this.createAt = createAt;
		this.updateBy = updateBy;
		this.updateAt = updateAt;
		this.isDelete = isDelete;
		this.deleteBy = deleteBy;
		this.deleteAt = deleteAt;
		this.exportbills = exportbills;
	}

	@Id

	@Column(name = "MD_ID", unique = true, nullable = false)
	public int getMdId() {
		return this.mdId;
	}

	public void setMdId(int mdId) {
		this.mdId = mdId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IB_ID")
	public Importbill getImportbill() {
		return this.importbill;
	}

	public void setImportbill(Importbill importbill) {
		this.importbill = importbill;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MA_ID")
	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MD_DATE_OF_MANUFACTURE", length = 10)
	public Date getMdDateOfManufacture() {
		return this.mdDateOfManufacture;
	}

	public void setMdDateOfManufacture(Date mdDateOfManufacture) {
		this.mdDateOfManufacture = mdDateOfManufacture;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MD_EXPIRATION_DATE", length = 10)
	public Date getMdExpirationDate() {
		return this.mdExpirationDate;
	}

	public void setMdExpirationDate(Date mdExpirationDate) {
		this.mdExpirationDate = mdExpirationDate;
	}

	@Column(name = "MD_QUANTITY")
	public Integer getMdQuantity() {
		return this.mdQuantity;
	}

	public void setMdQuantity(Integer mdQuantity) {
		this.mdQuantity = mdQuantity;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "materialdetail")
	public Set<Exportbill> getExportbills() {
		return this.exportbills;
	}

	public void setExportbills(Set<Exportbill> exportbills) {
		this.exportbills = exportbills;
	}

}
