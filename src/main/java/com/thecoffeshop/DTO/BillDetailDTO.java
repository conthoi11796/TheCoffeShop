package com.thecoffeshop.DTO;

import com.thecoffeshop.Models.*;
public class BillDetailDTO {

	private Billdetail billdetail; 
	
	private int price;

	public Billdetail getBilldetail() {
		return billdetail;
	}

	public void setBilldetail(Billdetail billdetail) {
		this.billdetail = billdetail;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
