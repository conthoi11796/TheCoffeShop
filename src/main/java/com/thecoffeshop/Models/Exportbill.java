package com.thecoffeshop.Models;
// Generated Nov 6, 2018 1:02:23 AM by Hibernate Tools 5.1.7.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Exportbill generated by hbm2java
 */
@Entity
@Table(name = "exportbill", catalog = "luanvan")
public class Exportbill implements java.io.Serializable {

	private Integer exportbillid;
	private Employee employee;
	private Materialdetail materialdetail;
	private Product product;
	private Integer quantity;
	private String createby;
	private Date createat;
	private String updateby;
	private Date updateat;
	private Boolean isdelete;
	private String deleteby;
	private Date deleteat;

	public Exportbill() {
	}

	public Exportbill(Employee employee, Materialdetail materialdetail, Product product, Integer quantity,
			String createby, Date createat, String updateby, Date updateat, Boolean isdelete, String deleteby,
			Date deleteat) {
		this.employee = employee;
		this.materialdetail = materialdetail;
		this.product = product;
		this.quantity = quantity;
		this.createby = createby;
		this.createat = createat;
		this.updateby = updateby;
		this.updateat = updateat;
		this.isdelete = isdelete;
		this.deleteby = deleteby;
		this.deleteat = deleteat;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "EXPORTBILLID", unique = true, nullable = false)
	public Integer getExportbillid() {
		return this.exportbillid;
	}

	public void setExportbillid(Integer exportbillid) {
		this.exportbillid = exportbillid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEEID")
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MATERIALDETAILID")
	public Materialdetail getMaterialdetail() {
		return this.materialdetail;
	}

	public void setMaterialdetail(Materialdetail materialdetail) {
		this.materialdetail = materialdetail;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PRODUCTID")
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

}
