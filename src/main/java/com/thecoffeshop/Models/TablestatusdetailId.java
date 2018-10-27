package com.thecoffeshop.Models;
// Generated Oct 26, 2018 8:38:01 PM by Hibernate Tools 5.1.7.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TablestatusdetailId generated by hbm2java
 */
@Embeddable
public class TablestatusdetailId implements java.io.Serializable {

	private int dnId;
	private String tsId;

	public TablestatusdetailId() {
	}

	public TablestatusdetailId(int dnId, String tsId) {
		this.dnId = dnId;
		this.tsId = tsId;
	}

	@Column(name = "DN_ID", nullable = false)
	public int getDnId() {
		return this.dnId;
	}

	public void setDnId(int dnId) {
		this.dnId = dnId;
	}

	@Column(name = "TS_ID", nullable = false)
	public String getTsId() {
		return this.tsId;
	}

	public void setTsId(String tsId) {
		this.tsId = tsId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TablestatusdetailId))
			return false;
		TablestatusdetailId castOther = (TablestatusdetailId) other;

		return (this.getDnId() == castOther.getDnId())
				&& ((this.getTsId() == castOther.getTsId()) || (this.getTsId() != null && castOther.getTsId() != null
						&& this.getTsId().equals(castOther.getTsId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getDnId();
		result = 37 * result + (getTsId() == null ? 0 : this.getTsId().hashCode());
		return result;
	}

}
