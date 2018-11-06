package com.thecoffeshop.Models;
// Generated Nov 6, 2018 1:02:23 AM by Hibernate Tools 5.1.7.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
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

	private Integer materialdetailid;
	private Importbill importbill;
	private Material material;
	private Date dateofmanufacture;
	private Date expirationdate;
	private Integer quantity;
	private String createby;
	private Date createat;
	private String updateby;
	private Date updateat;
	private Boolean isdelete;
	private String deleteby;
	private Date deleteat;
	private Set<Exportbill> exportbills = new HashSet<Exportbill>(0);

	public Materialdetail() {
	}

	public Materialdetail(Importbill importbill, Material material, Date dateofmanufacture, Date expirationdate,
			Integer quantity, String createby, Date createat, String updateby, Date updateat, Boolean isdelete,
			String deleteby, Date deleteat, Set<Exportbill> exportbills) {
		this.importbill = importbill;
		this.material = material;
		this.dateofmanufacture = dateofmanufacture;
		this.expirationdate = expirationdate;
		this.quantity = quantity;
		this.createby = createby;
		this.createat = createat;
		this.updateby = updateby;
		this.updateat = updateat;
		this.isdelete = isdelete;
		this.deleteby = deleteby;
		this.deleteat = deleteat;
		this.exportbills = exportbills;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "MATERIALDETAILID", unique = true, nullable = false)
	public Integer getMaterialdetailid() {
		return this.materialdetailid;
	}

	public void setMaterialdetailid(Integer materialdetailid) {
		this.materialdetailid = materialdetailid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IMPORTBILLID")
	public Importbill getImportbill() {
		return this.importbill;
	}

	public void setImportbill(Importbill importbill) {
		this.importbill = importbill;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MATERIALID")
	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATEOFMANUFACTURE", length = 10)
	public Date getDateofmanufacture() {
		return this.dateofmanufacture;
	}

	public void setDateofmanufacture(Date dateofmanufacture) {
		this.dateofmanufacture = dateofmanufacture;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EXPIRATIONDATE", length = 10)
	public Date getExpirationdate() {
		return this.expirationdate;
	}

	public void setExpirationdate(Date expirationdate) {
		this.expirationdate = expirationdate;
	}

	@Column(name = "QUANTITY")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "materialdetail")
	public Set<Exportbill> getExportbills() {
		return this.exportbills;
	}

	public void setExportbills(Set<Exportbill> exportbills) {
		this.exportbills = exportbills;
	}

}
