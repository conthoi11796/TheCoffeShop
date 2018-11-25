package com.thecoffeshop.Models;
// Generated Nov 20, 2018 8:44:18 AM by Hibernate Tools 5.1.7.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RegisterId generated by hbm2java
 */
@Embeddable
public class RegisterId implements java.io.Serializable {

	private String employeeid;
	private String scheduleid;

	public RegisterId() {
	}

	public RegisterId(String employeeid, String scheduleid) {
		this.employeeid = employeeid;
		this.scheduleid = scheduleid;
	}

	@Column(name = "EMPLOYEEID", nullable = false, length = 7)
	public String getEmployeeid() {
		return this.employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	@Column(name = "SCHEDULEID", nullable = false, length = 7)
	public String getScheduleid() {
		return this.scheduleid;
	}

	public void setScheduleid(String scheduleid) {
		this.scheduleid = scheduleid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RegisterId))
			return false;
		RegisterId castOther = (RegisterId) other;

		return ((this.getEmployeeid() == castOther.getEmployeeid()) || (this.getEmployeeid() != null
				&& castOther.getEmployeeid() != null && this.getEmployeeid().equals(castOther.getEmployeeid())))
				&& ((this.getScheduleid() == castOther.getScheduleid())
						|| (this.getScheduleid() != null && castOther.getScheduleid() != null
								&& this.getScheduleid().equals(castOther.getScheduleid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getEmployeeid() == null ? 0 : this.getEmployeeid().hashCode());
		result = 37 * result + (getScheduleid() == null ? 0 : this.getScheduleid().hashCode());
		return result;
	}

}
