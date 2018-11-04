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
 * Salary generated by hbm2java
 */
@Entity
@Table(name = "salary", catalog = "luanvan")
public class Salary implements java.io.Serializable {

	private String saId;
	private Integer saSalarysOnHour;
	private Date saDatestart;
	private String createBy;
	private Date createAt;
	private String updateBy;
	private Date updateAt;
	private Boolean isDelete;
	private String deleteBy;
	private Date deleteAt;
	private Set<Employee> employees = new HashSet<Employee>(0);

	public Salary() {
	}

	public Salary(String saId) {
		this.saId = saId;
	}

	public Salary(String saId, Integer saSalarysOnHour, Date saDatestart, String createBy, Date createAt,
			String updateBy, Date updateAt, Boolean isDelete, String deleteBy, Date deleteAt, Set<Employee> employees) {
		this.saId = saId;
		this.saSalarysOnHour = saSalarysOnHour;
		this.saDatestart = saDatestart;
		this.createBy = createBy;
		this.createAt = createAt;
		this.updateBy = updateBy;
		this.updateAt = updateAt;
		this.isDelete = isDelete;
		this.deleteBy = deleteBy;
		this.deleteAt = deleteAt;
		this.employees = employees;
	}

	@Id

	@Column(name = "SA_ID", unique = true, nullable = false, length = 7)
	public String getSaId() {
		return this.saId;
	}

	public void setSaId(String saId) {
		this.saId = saId;
	}

	@Column(name = "SA_SALARYS_ON_HOUR")
	public Integer getSaSalarysOnHour() {
		return this.saSalarysOnHour;
	}

	public void setSaSalarysOnHour(Integer saSalarysOnHour) {
		this.saSalarysOnHour = saSalarysOnHour;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SA_DATESTART", length = 10)
	public Date getSaDatestart() {
		return this.saDatestart;
	}

	public void setSaDatestart(Date saDatestart) {
		this.saDatestart = saDatestart;
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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "salary")
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
