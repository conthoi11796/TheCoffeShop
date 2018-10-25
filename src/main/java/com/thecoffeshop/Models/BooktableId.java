package com.thecoffeshop.Models;
// Generated Oct 24, 2018 11:35:31 AM by Hibernate Tools 5.1.7.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BooktableId generated by hbm2java
 */
@Embeddable
public class BooktableId implements java.io.Serializable {

	private String cuId;
	private int dnId;
	private String emId;

	public BooktableId() {
	}

	public BooktableId(String cuId, int dnId, String emId) {
		this.cuId = cuId;
		this.dnId = dnId;
		this.emId = emId;
	}

	@Column(name = "CU_ID", nullable = false, length = 7)
	public String getCuId() {
		return this.cuId;
	}

	public void setCuId(String cuId) {
		this.cuId = cuId;
	}

	@Column(name = "DN_ID", nullable = false)
	public int getDnId() {
		return this.dnId;
	}

	public void setDnId(int dnId) {
		this.dnId = dnId;
	}

	@Column(name = "EM_ID", nullable = false, length = 7)
	public String getEmId() {
		return this.emId;
	}

	public void setEmId(String emId) {
		this.emId = emId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BooktableId))
			return false;
		BooktableId castOther = (BooktableId) other;

		return ((this.getCuId() == castOther.getCuId()) || (this.getCuId() != null && castOther.getCuId() != null
				&& this.getCuId().equals(castOther.getCuId()))) && (this.getDnId() == castOther.getDnId())
				&& ((this.getEmId() == castOther.getEmId()) || (this.getEmId() != null && castOther.getEmId() != null
						&& this.getEmId().equals(castOther.getEmId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCuId() == null ? 0 : this.getCuId().hashCode());
		result = 37 * result + this.getDnId();
		result = 37 * result + (getEmId() == null ? 0 : this.getEmId().hashCode());
		return result;
	}

}