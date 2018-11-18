package com.thecoffeshop.DTO;

import java.util.List;

import com.thecoffeshop.Models.*;

public class TableStatusDTO {

	private Tablestatus tablestatus;

	private Boolean canDelete;
	
	public Boolean getCanDelete() {
		return canDelete;
	}

	public void setCanDelete(Boolean canDelete) {
		this.canDelete = canDelete;
	}

	public Tablestatus getTablestatus() {
		return tablestatus;
	}

	public void setTablestatus(Tablestatus tablestatus) {
		this.tablestatus = tablestatus;
	}
}
