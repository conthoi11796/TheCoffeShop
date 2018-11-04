package com.thecoffeshop.Models;

// Generated Oct 26, 2018 8:38:01 PM by Hibernate Tools 5.1.7.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Atposition generated by hbm2java
 */
@Entity
@Table(name = "atposition", catalog = "luanvan")
public class Atposition implements java.io.Serializable {

	private AtpositionId id;
	private Employee employee;
	private Position position;
	private Date apDatestart;
	private String createBy;
	private Date createAt;
	private String updateBy;
	private Date updateAt;
	private Boolean isDelete;
	private String deleteBy;
	private Date deleteAt;

	public Atposition() {
	}

	public Atposition(AtpositionId id, Employee employee, Position position) {
		this.id = id;
		this.employee = employee;
		this.position = position;
	}

	public Atposition(AtpositionId id, Employee employee, Position position, Date apDatestart, String createBy,
			Date createAt, String updateBy, Date updateAt, Boolean isDelete, String deleteBy, Date deleteAt) {
		this.id = id;
		this.employee = employee;
		this.position = position;
		this.apDatestart = apDatestart;
		this.createBy = createBy;
		this.createAt = createAt;
		this.updateBy = updateBy;
		this.updateAt = updateAt;
		this.isDelete = isDelete;
		this.deleteBy = deleteBy;
		this.deleteAt = deleteAt;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "emId", column = @Column(name = "EM_ID", nullable = false, length = 7)),
			@AttributeOverride(name = "poId", column = @Column(name = "PO_ID", nullable = false)) })
	public AtpositionId getId() {
		return this.id;
	}

	public void setId(AtpositionId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EM_ID", nullable = false, insertable = false, updatable = false)
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PO_ID", nullable = false, insertable = false, updatable = false)
	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AP_DATESTART", length = 10)
	public Date getApDatestart() {
		return this.apDatestart;
	}

	public void setApDatestart(Date apDatestart) {
		this.apDatestart = apDatestart;
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

}
