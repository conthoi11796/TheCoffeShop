package com.thecoffeshop.Models;

// Generated Oct 26, 2018 8:38:01 PM by Hibernate Tools 5.1.7.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AtpositionId generated by hbm2java
 */
@Embeddable
public class AtpositionId implements java.io.Serializable {

	private String emId;
	private String poId;

	public AtpositionId() {
	}

	public AtpositionId(String emId, String poId) {
		this.emId = emId;
		this.poId = poId;
	}

	@Column(name = "EM_ID", nullable = false, length = 7)
	public String getEmId() {
		return this.emId;
	}

	public void setEmId(String emId) {
		this.emId = emId;
	}

	@Column(name = "PO_ID", nullable = false)
	public String getPoId() {
		return this.poId;
	}

	public void setPoId(String poId) {
		this.poId = poId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AtpositionId))
			return false;
		AtpositionId castOther = (AtpositionId) other;

		return ((this.getEmId() == castOther.getEmId()) || (this.getEmId() != null && castOther.getEmId() != null
				&& this.getEmId().equals(castOther.getEmId())))
				&& ((this.getPoId() == castOther.getPoId()) || (this.getPoId() != null && castOther.getPoId() != null
						&& this.getPoId().equals(castOther.getPoId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getEmId() == null ? 0 : this.getEmId().hashCode());
		result = 37 * result + (getPoId() == null ? 0 : this.getPoId().hashCode());
		return result;
	}

}
