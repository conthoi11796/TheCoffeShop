package com.thecoffeshop.DTO;

import com.thecoffeshop.Models.*;

public class BillStatusDTO {

	private Billstatus  billstatus;
	
	private Boolean canDelete;

	public Billstatus getBillstatus() {
		return billstatus;
	}

	public void setBillstatus(Billstatus billstatus) {
		this.billstatus = billstatus;
	}

	public Boolean getCanDelete() {
		return canDelete;
	}

	public void setCanDelete(Boolean canDelete) {
		this.canDelete = canDelete;
	}

}
