package com.thecoffeshop.DTO;

import com.thecoffeshop.Models.*;

public class SupplierDTO {

	private Supplier supplier;

	private Boolean canDelete;

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Boolean getCanDelete() {
		return canDelete;
	}

	public void setCanDelete(Boolean canDelete) {
		this.canDelete = canDelete;
	}

}
