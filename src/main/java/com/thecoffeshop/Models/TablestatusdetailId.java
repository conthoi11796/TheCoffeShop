package com.thecoffeshop.Models;
// Generated Nov 6, 2018 1:02:23 AM by Hibernate Tools 5.1.7.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TablestatusdetailId generated by hbm2java
 */
@Embeddable
public class TablestatusdetailId implements java.io.Serializable {

	private int dinnertableid;
	private int tablestatusid;

	public TablestatusdetailId() {
	}

	public TablestatusdetailId(int dinnertableid, int tablestatusid) {
		this.dinnertableid = dinnertableid;
		this.tablestatusid = tablestatusid;
	}

	@Column(name = "DINNERTABLEID", nullable = false)
	public int getDinnertableid() {
		return this.dinnertableid;
	}

	public void setDinnertableid(int dinnertableid) {
		this.dinnertableid = dinnertableid;
	}

	@Column(name = "TABLESTATUSID", nullable = false)
	public int getTablestatusid() {
		return this.tablestatusid;
	}

	public void setTablestatusid(int tablestatusid) {
		this.tablestatusid = tablestatusid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TablestatusdetailId))
			return false;
		TablestatusdetailId castOther = (TablestatusdetailId) other;

		return (this.getDinnertableid() == castOther.getDinnertableid())
				&& (this.getTablestatusid() == castOther.getTablestatusid());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getDinnertableid();
		result = 37 * result + this.getTablestatusid();
		return result;
	}

}
