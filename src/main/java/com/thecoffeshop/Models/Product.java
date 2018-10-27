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

	private String PId;
	private Categoryproduct categoryproduct;
	private String PName;
	private String PDescription;
	private String PNumberInventory;
	private String createBy;
	private Date createAt;
	private String updateBy;
	private Date updateAt;
	private Boolean isDelete;
	private String deleteBy;
	private Date deleteAt;
	private Set<Billdetail> billdetails = new HashSet<Billdetail>(0);
	private Set<Image> images = new HashSet<Image>(0);
	private Set<Exportbill> exportbills = new HashSet<Exportbill>(0);
	private Set<Price> prices = new HashSet<Price>(0);

	public Product() {
	}

	public Product(String PId) {
		this.PId = PId;
	}

	public Product(String PId, Categoryproduct categoryproduct, String PName, String PDescription,
			String PNumberInventory, String createBy, Date createAt, String updateBy, Date updateAt, Boolean isDelete,
			String deleteBy, Date deleteAt, Set<Billdetail> billdetails, Set<Image> images, Set<Exportbill> exportbills,
			Set<Price> prices) {
		this.PId = PId;
		this.categoryproduct = categoryproduct;
		this.PName = PName;
		this.PDescription = PDescription;
		this.PNumberInventory = PNumberInventory;
		this.createBy = createBy;
		this.createAt = createAt;
		this.updateBy = updateBy;
		this.updateAt = updateAt;
		this.isDelete = isDelete;
		this.deleteBy = deleteBy;
		this.deleteAt = deleteAt;
		this.billdetails = billdetails;
		this.images = images;
		this.exportbills = exportbills;
		this.prices = prices;
	}

	@Id

	@Column(name = "P_ID", unique = true, nullable = false, length = 7)
	public String getPId() {
		return this.PId;
	}

	public void setPId(String PId) {
		this.PId = PId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CG_PRD_ID")
	public Categoryproduct getCategoryproduct() {
		return this.categoryproduct;
	}

	public void setCategoryproduct(Categoryproduct categoryproduct) {
		this.categoryproduct = categoryproduct;
	}

	@Column(name = "P_NAME")
	public String getPName() {
		return this.PName;
	}

	public void setPName(String PName) {
		this.PName = PName;
	}

	@Column(name = "P_DESCRIPTION")
	public String getPDescription() {
		return this.PDescription;
	}

	public void setPDescription(String PDescription) {
		this.PDescription = PDescription;
	}

	@Column(name = "P_NUMBER_INVENTORY", length = 10)
	public String getPNumberInventory() {
		return this.PNumberInventory;
	}

	public void setPNumberInventory(String PNumberInventory) {
		this.PNumberInventory = PNumberInventory;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<Billdetail> getBilldetails() {
		return this.billdetails;
	}

	public void setBilldetails(Set<Billdetail> billdetails) {
		this.billdetails = billdetails;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "imageofproduct", catalog = "luanvan", joinColumns = {
			@JoinColumn(name = "P_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "IMG_ID", nullable = false, updatable = false) })
	public Set<Image> getImages() {
		return this.images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<Exportbill> getExportbills() {
		return this.exportbills;
	}

	public void setExportbills(Set<Exportbill> exportbills) {
		this.exportbills = exportbills;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<Price> getPrices() {
		return this.prices;
	}

	public void setPrices(Set<Price> prices) {
		this.prices = prices;
	}

}
