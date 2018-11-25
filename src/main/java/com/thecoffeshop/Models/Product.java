package com.thecoffeshop.Models;
// Generated Nov 20, 2018 8:44:18 AM by Hibernate Tools 5.1.7.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product", catalog = "luanvan")
public class Product implements java.io.Serializable {

	private String productid;
	private Categoryproduct categoryproduct;
	private String name;
	private String description;
	private String numberinventory;
	private Date updateat;
	private Boolean isdelete;
	private Set<Billdetail> billdetails = new HashSet<Billdetail>(0);
	private Set<Image> images = new HashSet<Image>(0);
	private Set<Exportbill> exportbills = new HashSet<Exportbill>(0);
	private Set<Price> prices = new HashSet<Price>(0);

	public Product() {
	}

	public Product(String productid) {
		this.productid = productid;
	}

	public Product(String productid, Categoryproduct categoryproduct, String name, String description,
			String numberinventory, Date updateat, Boolean isdelete, Set<Billdetail> billdetails, Set<Image> images,
			Set<Exportbill> exportbills, Set<Price> prices) {
		this.productid = productid;
		this.categoryproduct = categoryproduct;
		this.name = name;
		this.description = description;
		this.numberinventory = numberinventory;
		this.updateat = updateat;
		this.isdelete = isdelete;
		this.billdetails = billdetails;
		this.images = images;
		this.exportbills = exportbills;
		this.prices = prices;
	}

	@Id

	@Column(name = "PRODUCTID", unique = true, nullable = false, length = 7)
	public String getProductid() {
		return this.productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CATEGORYPRODUCTID")
	public Categoryproduct getCategoryproduct() {
		return this.categoryproduct;
	}

	public void setCategoryproduct(Categoryproduct categoryproduct) {
		this.categoryproduct = categoryproduct;
	}

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "NUMBERINVENTORY", length = 10)
	public String getNumberinventory() {
		return this.numberinventory;
	}

	public void setNumberinventory(String numberinventory) {
		this.numberinventory = numberinventory;
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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
	public Set<Billdetail> getBilldetails() {
		return this.billdetails;
	}

	public void setBilldetails(Set<Billdetail> billdetails) {
		this.billdetails = billdetails;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "imageofproduct", catalog = "luanvan", joinColumns = {
			@JoinColumn(name = "PRODUCTID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "IMAGEID", nullable = false, updatable = false) })
	public Set<Image> getImages() {
		return this.images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
	public Set<Exportbill> getExportbills() {
		return this.exportbills;
	}

	public void setExportbills(Set<Exportbill> exportbills) {
		this.exportbills = exportbills;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
	public Set<Price> getPrices() {
		return this.prices;
	}

	public void setPrices(Set<Price> prices) {
		this.prices = prices;
	}

}
